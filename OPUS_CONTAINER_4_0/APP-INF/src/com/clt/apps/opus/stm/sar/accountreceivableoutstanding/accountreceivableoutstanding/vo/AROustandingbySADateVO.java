/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : AROustandingbySADateVO.java
 *@FileTitle : AROustandingbySADateVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.06.01
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2016.06.01  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer	Object including Parameters)<br>
 * - 관련	Event에서	작성,	서버실행요청시	PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author 
 * @since J2EE 1.6
 * @see	..
 */
public class AROustandingbySADateVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<AROustandingbySADateVO>  models =	new	ArrayList<AROustandingbySADateVO>();


	/*	Column Info	*/
	private  String	 chgTpCd   =  null;
	/*	Column Info	*/
	private  String	 totLcl   =  null;
	/*	Column Info	*/
	private  String	 rctTotLcl   =  null;
	/*	Column Info	*/
	private  String	 biltoCntCd   =  null;
	/*	Column Info	*/
	private  String	 svcScpCd   =  null;
	/*	Column Info	*/
	private  String	 ibTerm   =  null;
	/*	Column Info	*/
	private  String	 otsTpCd   =  null;
	/*	Column Info	*/
	private  String	 kind3Code2   =  null;
	/*	Column Info	*/
	private  String	 creditLimit   =  null;
	/*	Column Info	*/
	private  String	 biltoCustSeq   =  null;
	/*	Column Info	*/
	private  String	 sailArrDt   =  null;
	/*	Column Info	*/
	private  String	 blNo   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 saleRepCd   =  null;
	/*	Column Info	*/
	private  String	 polCd   =  null;
	/*	Column Info	*/
	private  String	 scNo   =  null;
	/*	Column Info	*/
	private  String	 sortSeq   =  null;
	/*	Column Info	*/
	private  String	 otsGrpTpCd   =  null;
	/*	Column Info	*/
	private  String	 sailArrDtTo   =  null;
	/*	Column Info	*/
	private  String	 invTotUsd   =  null;
	/*	Column Info	*/
	private  String	 usdEqvLcl   =  null;
	/*	Column Info	*/
	private  String	 adjTotUsd   =  null;
	/*	Column Info	*/
	private  String	 invDt   =  null;
	/*	Column Info	*/
	private  String	 rhq   =  null;
	/*	Column Info	*/
	private  String	 totUsd   =  null;
	/*	Column Info	*/
	private  String	 balLoclTaxAmt   =  null;
	/*	Column Info	*/
	private  String	 rhqCd   =  null;
	/*	Column Info	*/
	private  String	 rctAmt   =  null;
	/*	Column Info	*/
	private  String	 delCd   =  null;
	/*	Column Info	*/
	private  String	 adjAmt   =  null;
	/*	Column Info	*/
	private  String	 bnd   =  null;
	/*	Column Info	*/
	private  String	 podCd   =  null;
	/*	Column Info	*/
	private  String	 vvd   =  null;
	/*	Column Info	*/
	private  String	 bkgNo   =  null;
	/*	Column Info	*/
	private  String	 crMkFlg   =  null;
	/*	Column Info	*/
	private  String	 summaryYn   =  null;
	/*	Column Info	*/
	private  String	 overdueFrom   =  null;
	/*	Column Info	*/
	private  String	 otsOfcCd   =  null;
	/*	Column Info	*/
	private  String	 custCd   =  null;
	/*	Column Info	*/
	private  String	 overDue   =  null;
	/*	Column Info	*/
	private  String	 adjTotLcl   =  null;
	/*	Column Info	*/
	private  String	 invTotLcl   =  null;
	/*	Column Info	*/
	private  String	 sailArrDtFm   =  null;
	/*	Column Info	*/
	private  String	 otsOpy   =  null;
	/*	Column Info	*/
	private  String	 port   =  null;
	/*	Column Info	*/
	private  String	 porCd   =  null;
	/*	Column Info	*/
	private  String	 laneCd   =  null;
	/*	Column Info	*/
	private  String	 rctTotUsd   =  null;
	/*	Column Info	*/
	private  String	 custNm   =  null;
	/*	Column Info	*/
	private  String	 invLoclXchRt   =  null;
	/*	Column Info	*/
	private  String	 usd   =  null;
	/*	Column Info	*/
	private  String	 rateYn   =  null;
	/*	Column Info	*/
	private  String	 creditCurrCd   =  null;
	/*	Column Info	*/
	private  String	 balAmt   =  null;
	/*	Column Info	*/
	private  String	 fCustSeq   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 blInv   =  null;
	/*	Column Info	*/
	private  String	 exRate   =  null;
	/*	Column Info	*/
	private  String	 invAmt   =  null;
	/*	Column Info	*/
	private  String	 dueDt   =  null;
	/*	Column Info	*/
	private  String	 otsRtFlg   =  null;
	/*	Column Info	*/
	private  String	 rmk   =  null;
	/*	Column Info	*/
	private  String	 kind3Code   =  null;
	/*	Column Info	*/
	private  String	 kind2   =  null;
	/*	Column Info	*/
	private  String	 kind2Radio   =  null;
	/*	Column Info	*/
	private  String	 kind3   =  null;
	/*	Column Info	*/
	private  String	 overdueTo   =  null;
	/*	Column Info	*/
	private  String	 invCurrCd   =  null;
	/*	Column Info	*/
	private  String	 obTerm   =  null;
	/*	Column Info	*/
	private  String	 balLoclFrtAmt   =  null;
	/*	Column Info	*/
	private  String	 creditFlg   =  null;
	/*	Column Info	*/
	private  String	 fCustCntCd   =  null;
	/*	Column Info	*/
	private  String	 invNo   =  null;
	/*	Column Info	*/
	private  String	 dateTpCd   =  null;
	/*	Column Info	*/
	private  String	 ofcCd   =  null;
	/*	Column Info	*/
	private  String	 apArOffstNo   =  null;
	/*	Column Info	*/
	private  String	 invUsdXchRt   =  null;
	/*	Column Info	*/
	private  String	 custSrepCd   =  null;
	/*	Column Info	*/
	private  String	 refNo   =  null;
	/*	Column Info	*/
	private  String	 creidtMk   =  null;
	/*	Column Info	*/
	private  String	 otsPayCd   =  null;
	/*	Column Info	*/
	private  String	 orgInvNo   =  null;
	/*	Column Info	*/
	private  String	 iPage   =  null;
	/*	Column Info	*/
	private  String	 totalCnt   =  null;
	/*	Column Info	*/
	private  String	 totalUsdAmt   =  null;
	/*	Column Info	*/
	private  String	 totalLclAmt   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public AROustandingbySADateVO(){}

	public AROustandingbySADateVO(String chgTpCd,String totLcl,String rctTotLcl,String biltoCntCd,String svcScpCd,String ibTerm,String otsTpCd,String kind3Code2,String creditLimit,String biltoCustSeq,String sailArrDt,String blNo,String pagerows,String saleRepCd,String polCd,String scNo,String sortSeq,String otsGrpTpCd,String sailArrDtTo,String invTotUsd,String usdEqvLcl,String adjTotUsd,String invDt,String rhq,String totUsd,String balLoclTaxAmt,String rhqCd,String rctAmt,String delCd,String adjAmt,String bnd,String podCd,String vvd,String bkgNo,String crMkFlg,String summaryYn,String overdueFrom,String otsOfcCd,String custCd,String overDue,String adjTotLcl,String invTotLcl,String sailArrDtFm,String otsOpy,String port,String porCd,String laneCd,String rctTotUsd,String custNm,String invLoclXchRt,String usd,String rateYn,String creditCurrCd,String balAmt,String fCustSeq,String ibflag,String blInv,String exRate,String invAmt,String dueDt,String otsRtFlg,String rmk,String kind3Code,String kind2,String kind2Radio,String kind3,String overdueTo,String invCurrCd,String obTerm,String balLoclFrtAmt,String creditFlg,String fCustCntCd,String invNo,String dateTpCd,String ofcCd,String apArOffstNo,String invUsdXchRt,String custSrepCd,String refNo,String creidtMk,String otsPayCd,String orgInvNo,String iPage,String totalCnt,String totalUsdAmt,String totalLclAmt)	{
		this.chgTpCd  = chgTpCd ;
		this.totLcl  = totLcl ;
		this.rctTotLcl  = rctTotLcl ;
		this.biltoCntCd  = biltoCntCd ;
		this.svcScpCd  = svcScpCd ;
		this.ibTerm  = ibTerm ;
		this.otsTpCd  = otsTpCd ;
		this.kind3Code2  = kind3Code2 ;
		this.creditLimit  = creditLimit ;
		this.biltoCustSeq  = biltoCustSeq ;
		this.sailArrDt  = sailArrDt ;
		this.blNo  = blNo ;
		this.pagerows  = pagerows ;
		this.saleRepCd  = saleRepCd ;
		this.polCd  = polCd ;
		this.scNo  = scNo ;
		this.sortSeq  = sortSeq ;
		this.otsGrpTpCd  = otsGrpTpCd ;
		this.sailArrDtTo  = sailArrDtTo ;
		this.invTotUsd  = invTotUsd ;
		this.usdEqvLcl  = usdEqvLcl ;
		this.adjTotUsd  = adjTotUsd ;
		this.invDt  = invDt ;
		this.rhq  = rhq ;
		this.totUsd  = totUsd ;
		this.balLoclTaxAmt  = balLoclTaxAmt ;
		this.rhqCd  = rhqCd ;
		this.rctAmt  = rctAmt ;
		this.delCd  = delCd ;
		this.adjAmt  = adjAmt ;
		this.bnd  = bnd ;
		this.podCd  = podCd ;
		this.vvd  = vvd ;
		this.bkgNo  = bkgNo ;
		this.crMkFlg  = crMkFlg ;
		this.summaryYn  = summaryYn ;
		this.overdueFrom  = overdueFrom ;
		this.otsOfcCd  = otsOfcCd ;
		this.custCd  = custCd ;
		this.overDue  = overDue ;
		this.adjTotLcl  = adjTotLcl ;
		this.invTotLcl  = invTotLcl ;
		this.sailArrDtFm  = sailArrDtFm ;
		this.otsOpy  = otsOpy ;
		this.port  = port ;
		this.porCd  = porCd ;
		this.laneCd  = laneCd ;
		this.rctTotUsd  = rctTotUsd ;
		this.custNm  = custNm ;
		this.invLoclXchRt  = invLoclXchRt ;
		this.usd  = usd ;
		this.rateYn  = rateYn ;
		this.creditCurrCd  = creditCurrCd ;
		this.balAmt  = balAmt ;
		this.fCustSeq  = fCustSeq ;
		this.ibflag  = ibflag ;
		this.blInv  = blInv ;
		this.exRate  = exRate ;
		this.invAmt  = invAmt ;
		this.dueDt  = dueDt ;
		this.otsRtFlg  = otsRtFlg ;
		this.rmk  = rmk ;
		this.kind3Code  = kind3Code ;
		this.kind2  = kind2 ;
		this.kind2Radio  = kind2Radio ;
		this.kind3  = kind3 ;
		this.overdueTo  = overdueTo ;
		this.invCurrCd  = invCurrCd ;
		this.obTerm  = obTerm ;
		this.balLoclFrtAmt  = balLoclFrtAmt ;
		this.creditFlg  = creditFlg ;
		this.fCustCntCd  = fCustCntCd ;
		this.invNo  = invNo ;
		this.dateTpCd  = dateTpCd ;
		this.ofcCd  = ofcCd ;
		this.apArOffstNo  = apArOffstNo ;
		this.invUsdXchRt  = invUsdXchRt ;
		this.custSrepCd  = custSrepCd ;
		this.refNo  = refNo ;
		this.creidtMk  = creidtMk ;
		this.otsPayCd  = otsPayCd ;
		this.orgInvNo  = orgInvNo ;
		this.iPage  = iPage ;
		this.totalCnt  = totalCnt ;
		this.totalUsdAmt  = totalUsdAmt ;
		this.totalLclAmt  = totalLclAmt ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("chg_tp_cd", getChgTpCd());		
		this.hashColumns.put("tot_lcl", getTotLcl());		
		this.hashColumns.put("rct_tot_lcl", getRctTotLcl());		
		this.hashColumns.put("bilto_cnt_cd", getBiltoCntCd());		
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());		
		this.hashColumns.put("ib_term", getIbTerm());		
		this.hashColumns.put("ots_tp_cd", getOtsTpCd());		
		this.hashColumns.put("kind3_code2", getKind3Code2());		
		this.hashColumns.put("credit_limit", getCreditLimit());		
		this.hashColumns.put("bilto_cust_seq", getBiltoCustSeq());		
		this.hashColumns.put("sail_arr_dt", getSailArrDt());		
		this.hashColumns.put("bl_no", getBlNo());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("sale_rep_cd", getSaleRepCd());		
		this.hashColumns.put("pol_cd", getPolCd());		
		this.hashColumns.put("sc_no", getScNo());		
		this.hashColumns.put("sort_seq", getSortSeq());		
		this.hashColumns.put("ots_grp_tp_cd", getOtsGrpTpCd());		
		this.hashColumns.put("sail_arr_dt_to", getSailArrDtTo());		
		this.hashColumns.put("inv_tot_usd", getInvTotUsd());		
		this.hashColumns.put("usd_eqv_lcl", getUsdEqvLcl());		
		this.hashColumns.put("adj_tot_usd", getAdjTotUsd());		
		this.hashColumns.put("inv_dt", getInvDt());		
		this.hashColumns.put("rhq", getRhq());		
		this.hashColumns.put("tot_usd", getTotUsd());		
		this.hashColumns.put("bal_locl_tax_amt", getBalLoclTaxAmt());		
		this.hashColumns.put("rhq_cd", getRhqCd());		
		this.hashColumns.put("rct_amt", getRctAmt());		
		this.hashColumns.put("del_cd", getDelCd());		
		this.hashColumns.put("adj_amt", getAdjAmt());		
		this.hashColumns.put("bnd", getBnd());		
		this.hashColumns.put("pod_cd", getPodCd());		
		this.hashColumns.put("vvd", getVvd());		
		this.hashColumns.put("bkg_no", getBkgNo());		
		this.hashColumns.put("cr_mk_flg", getCrMkFlg());		
		this.hashColumns.put("summary_yn", getSummaryYn());		
		this.hashColumns.put("overdue_from", getOverdueFrom());		
		this.hashColumns.put("ots_ofc_cd", getOtsOfcCd());		
		this.hashColumns.put("cust_cd", getCustCd());		
		this.hashColumns.put("over_due", getOverDue());		
		this.hashColumns.put("adj_tot_lcl", getAdjTotLcl());		
		this.hashColumns.put("inv_tot_lcl", getInvTotLcl());		
		this.hashColumns.put("sail_arr_dt_fm", getSailArrDtFm());		
		this.hashColumns.put("ots_opy", getOtsOpy());		
		this.hashColumns.put("port", getPort());		
		this.hashColumns.put("por_cd", getPorCd());		
		this.hashColumns.put("lane_cd", getLaneCd());		
		this.hashColumns.put("rct_tot_usd", getRctTotUsd());		
		this.hashColumns.put("cust_nm", getCustNm());		
		this.hashColumns.put("inv_locl_xch_rt", getInvLoclXchRt());		
		this.hashColumns.put("usd", getUsd());		
		this.hashColumns.put("rate_yn", getRateYn());		
		this.hashColumns.put("credit_curr_cd", getCreditCurrCd());		
		this.hashColumns.put("bal_amt", getBalAmt());		
		this.hashColumns.put("f_cust_seq", getFCustSeq());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("bl_inv", getBlInv());		
		this.hashColumns.put("ex_rate", getExRate());		
		this.hashColumns.put("inv_amt", getInvAmt());		
		this.hashColumns.put("due_dt", getDueDt());		
		this.hashColumns.put("ots_rt_flg", getOtsRtFlg());		
		this.hashColumns.put("rmk", getRmk());		
		this.hashColumns.put("kind3_code", getKind3Code());		
		this.hashColumns.put("kind2", getKind2());		
		this.hashColumns.put("kind2_radio", getKind2Radio());		
		this.hashColumns.put("kind_3", getKind3());		
		this.hashColumns.put("overdue_to", getOverdueTo());		
		this.hashColumns.put("inv_curr_cd", getInvCurrCd());		
		this.hashColumns.put("ob_term", getObTerm());		
		this.hashColumns.put("bal_locl_frt_amt", getBalLoclFrtAmt());		
		this.hashColumns.put("credit_flg", getCreditFlg());		
		this.hashColumns.put("f_cust_cnt_cd", getFCustCntCd());		
		this.hashColumns.put("inv_no", getInvNo());		
		this.hashColumns.put("date_tp_cd", getDateTpCd());		
		this.hashColumns.put("ofc_cd", getOfcCd());		
		this.hashColumns.put("ap_ar_offst_no", getApArOffstNo());		
		this.hashColumns.put("inv_usd_xch_rt", getInvUsdXchRt());		
		this.hashColumns.put("cust_srep_cd", getCustSrepCd());		
		this.hashColumns.put("ref_no", getRefNo());		
		this.hashColumns.put("creidt_mk", getCreidtMk());		
		this.hashColumns.put("ots_pay_cd", getOtsPayCd());		
		this.hashColumns.put("org_inv_no", getOrgInvNo());		
		this.hashColumns.put("i_page", getIPage());		
		this.hashColumns.put("total_cnt", getTotalCnt());		
		this.hashColumns.put("total_usd_amt", getTotalUsdAmt());		
		this.hashColumns.put("total_lcl_amt", getTotalLclAmt());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("chg_tp_cd", "chgTpCd");
		this.hashFields.put("tot_lcl", "totLcl");
		this.hashFields.put("rct_tot_lcl", "rctTotLcl");
		this.hashFields.put("bilto_cnt_cd", "biltoCntCd");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("ib_term", "ibTerm");
		this.hashFields.put("ots_tp_cd", "otsTpCd");
		this.hashFields.put("kind3_code2", "kind3Code2");
		this.hashFields.put("credit_limit", "creditLimit");
		this.hashFields.put("bilto_cust_seq", "biltoCustSeq");
		this.hashFields.put("sail_arr_dt", "sailArrDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sale_rep_cd", "saleRepCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("sort_seq", "sortSeq");
		this.hashFields.put("ots_grp_tp_cd", "otsGrpTpCd");
		this.hashFields.put("sail_arr_dt_to", "sailArrDtTo");
		this.hashFields.put("inv_tot_usd", "invTotUsd");
		this.hashFields.put("usd_eqv_lcl", "usdEqvLcl");
		this.hashFields.put("adj_tot_usd", "adjTotUsd");
		this.hashFields.put("inv_dt", "invDt");
		this.hashFields.put("rhq", "rhq");
		this.hashFields.put("tot_usd", "totUsd");
		this.hashFields.put("bal_locl_tax_amt", "balLoclTaxAmt");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("rct_amt", "rctAmt");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("adj_amt", "adjAmt");
		this.hashFields.put("bnd", "bnd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cr_mk_flg", "crMkFlg");
		this.hashFields.put("summary_yn", "summaryYn");
		this.hashFields.put("overdue_from", "overdueFrom");
		this.hashFields.put("ots_ofc_cd", "otsOfcCd");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("over_due", "overDue");
		this.hashFields.put("adj_tot_lcl", "adjTotLcl");
		this.hashFields.put("inv_tot_lcl", "invTotLcl");
		this.hashFields.put("sail_arr_dt_fm", "sailArrDtFm");
		this.hashFields.put("ots_opy", "otsOpy");
		this.hashFields.put("port", "port");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("lane_cd", "laneCd");
		this.hashFields.put("rct_tot_usd", "rctTotUsd");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("inv_locl_xch_rt", "invLoclXchRt");
		this.hashFields.put("usd", "usd");
		this.hashFields.put("rate_yn", "rateYn");
		this.hashFields.put("credit_curr_cd", "creditCurrCd");
		this.hashFields.put("bal_amt", "balAmt");
		this.hashFields.put("f_cust_seq", "fCustSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bl_inv", "blInv");
		this.hashFields.put("ex_rate", "exRate");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("due_dt", "dueDt");
		this.hashFields.put("ots_rt_flg", "otsRtFlg");
		this.hashFields.put("rmk", "rmk");
		this.hashFields.put("kind3_code", "kind3Code");
		this.hashFields.put("kind2", "kind2");
		this.hashFields.put("kind2_radio", "kind2Radio");
		this.hashFields.put("kind_3", "kind3");
		this.hashFields.put("overdue_to", "overdueTo");
		this.hashFields.put("inv_curr_cd", "invCurrCd");
		this.hashFields.put("ob_term", "obTerm");
		this.hashFields.put("bal_locl_frt_amt", "balLoclFrtAmt");
		this.hashFields.put("credit_flg", "creditFlg");
		this.hashFields.put("f_cust_cnt_cd", "fCustCntCd");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("date_tp_cd", "dateTpCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ap_ar_offst_no", "apArOffstNo");
		this.hashFields.put("inv_usd_xch_rt", "invUsdXchRt");
		this.hashFields.put("cust_srep_cd", "custSrepCd");
		this.hashFields.put("ref_no", "refNo");
		this.hashFields.put("creidt_mk", "creidtMk");
		this.hashFields.put("ots_pay_cd", "otsPayCd");
		this.hashFields.put("org_inv_no", "orgInvNo");
		this.hashFields.put("i_page", "iPage");
		this.hashFields.put("total_cnt", "totalCnt");
		this.hashFields.put("total_usd_amt", "totalUsdAmt");
		this.hashFields.put("total_lcl_amt", "totalLclAmt");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  chgTpCd
	*/
	public void	setChgTpCd( String	chgTpCd ) {
		this.chgTpCd =	chgTpCd;
	}
 
	/**
	 * Column Info
	 * @return	chgTpCd
	 */
	 public	 String	getChgTpCd() {
		 return	this.chgTpCd;
	 } 
 	/**
	* Column Info
	* @param  totLcl
	*/
	public void	setTotLcl( String	totLcl ) {
		this.totLcl =	totLcl;
	}
 
	/**
	 * Column Info
	 * @return	totLcl
	 */
	 public	 String	getTotLcl() {
		 return	this.totLcl;
	 } 
 	/**
	* Column Info
	* @param  rctTotLcl
	*/
	public void	setRctTotLcl( String	rctTotLcl ) {
		this.rctTotLcl =	rctTotLcl;
	}
 
	/**
	 * Column Info
	 * @return	rctTotLcl
	 */
	 public	 String	getRctTotLcl() {
		 return	this.rctTotLcl;
	 } 
 	/**
	* Column Info
	* @param  biltoCntCd
	*/
	public void	setBiltoCntCd( String	biltoCntCd ) {
		this.biltoCntCd =	biltoCntCd;
	}
 
	/**
	 * Column Info
	 * @return	biltoCntCd
	 */
	 public	 String	getBiltoCntCd() {
		 return	this.biltoCntCd;
	 } 
 	/**
	* Column Info
	* @param  svcScpCd
	*/
	public void	setSvcScpCd( String	svcScpCd ) {
		this.svcScpCd =	svcScpCd;
	}
 
	/**
	 * Column Info
	 * @return	svcScpCd
	 */
	 public	 String	getSvcScpCd() {
		 return	this.svcScpCd;
	 } 
 	/**
	* Column Info
	* @param  ibTerm
	*/
	public void	setIbTerm( String	ibTerm ) {
		this.ibTerm =	ibTerm;
	}
 
	/**
	 * Column Info
	 * @return	ibTerm
	 */
	 public	 String	getIbTerm() {
		 return	this.ibTerm;
	 } 
 	/**
	* Column Info
	* @param  otsTpCd
	*/
	public void	setOtsTpCd( String	otsTpCd ) {
		this.otsTpCd =	otsTpCd;
	}
 
	/**
	 * Column Info
	 * @return	otsTpCd
	 */
	 public	 String	getOtsTpCd() {
		 return	this.otsTpCd;
	 } 
 	/**
	* Column Info
	* @param  kind3Code2
	*/
	public void	setKind3Code2( String	kind3Code2 ) {
		this.kind3Code2 =	kind3Code2;
	}
 
	/**
	 * Column Info
	 * @return	kind3Code2
	 */
	 public	 String	getKind3Code2() {
		 return	this.kind3Code2;
	 } 
 	/**
	* Column Info
	* @param  creditLimit
	*/
	public void	setCreditLimit( String	creditLimit ) {
		this.creditLimit =	creditLimit;
	}
 
	/**
	 * Column Info
	 * @return	creditLimit
	 */
	 public	 String	getCreditLimit() {
		 return	this.creditLimit;
	 } 
 	/**
	* Column Info
	* @param  biltoCustSeq
	*/
	public void	setBiltoCustSeq( String	biltoCustSeq ) {
		this.biltoCustSeq =	biltoCustSeq;
	}
 
	/**
	 * Column Info
	 * @return	biltoCustSeq
	 */
	 public	 String	getBiltoCustSeq() {
		 return	this.biltoCustSeq;
	 } 
 	/**
	* Column Info
	* @param  sailArrDt
	*/
	public void	setSailArrDt( String	sailArrDt ) {
		this.sailArrDt =	sailArrDt;
	}
 
	/**
	 * Column Info
	 * @return	sailArrDt
	 */
	 public	 String	getSailArrDt() {
		 return	this.sailArrDt;
	 } 
 	/**
	* Column Info
	* @param  blNo
	*/
	public void	setBlNo( String	blNo ) {
		this.blNo =	blNo;
	}
 
	/**
	 * Column Info
	 * @return	blNo
	 */
	 public	 String	getBlNo() {
		 return	this.blNo;
	 } 
 	/**
	* Column Info
	* @param  pagerows
	*/
	public void	setPagerows( String	pagerows ) {
		this.pagerows =	pagerows;
	}
 
	/**
	 * Column Info
	 * @return	pagerows
	 */
	 public	 String	getPagerows() {
		 return	this.pagerows;
	 } 
 	/**
	* Column Info
	* @param  saleRepCd
	*/
	public void	setSaleRepCd( String	saleRepCd ) {
		this.saleRepCd =	saleRepCd;
	}
 
	/**
	 * Column Info
	 * @return	saleRepCd
	 */
	 public	 String	getSaleRepCd() {
		 return	this.saleRepCd;
	 } 
 	/**
	* Column Info
	* @param  polCd
	*/
	public void	setPolCd( String	polCd ) {
		this.polCd =	polCd;
	}
 
	/**
	 * Column Info
	 * @return	polCd
	 */
	 public	 String	getPolCd() {
		 return	this.polCd;
	 } 
 	/**
	* Column Info
	* @param  scNo
	*/
	public void	setScNo( String	scNo ) {
		this.scNo =	scNo;
	}
 
	/**
	 * Column Info
	 * @return	scNo
	 */
	 public	 String	getScNo() {
		 return	this.scNo;
	 } 
 	/**
	* Column Info
	* @param  sortSeq
	*/
	public void	setSortSeq( String	sortSeq ) {
		this.sortSeq =	sortSeq;
	}
 
	/**
	 * Column Info
	 * @return	sortSeq
	 */
	 public	 String	getSortSeq() {
		 return	this.sortSeq;
	 } 
 	/**
	* Column Info
	* @param  otsGrpTpCd
	*/
	public void	setOtsGrpTpCd( String	otsGrpTpCd ) {
		this.otsGrpTpCd =	otsGrpTpCd;
	}
 
	/**
	 * Column Info
	 * @return	otsGrpTpCd
	 */
	 public	 String	getOtsGrpTpCd() {
		 return	this.otsGrpTpCd;
	 } 
 	/**
	* Column Info
	* @param  sailArrDtTo
	*/
	public void	setSailArrDtTo( String	sailArrDtTo ) {
		this.sailArrDtTo =	sailArrDtTo;
	}
 
	/**
	 * Column Info
	 * @return	sailArrDtTo
	 */
	 public	 String	getSailArrDtTo() {
		 return	this.sailArrDtTo;
	 } 
 	/**
	* Column Info
	* @param  invTotUsd
	*/
	public void	setInvTotUsd( String	invTotUsd ) {
		this.invTotUsd =	invTotUsd;
	}
 
	/**
	 * Column Info
	 * @return	invTotUsd
	 */
	 public	 String	getInvTotUsd() {
		 return	this.invTotUsd;
	 } 
 	/**
	* Column Info
	* @param  usdEqvLcl
	*/
	public void	setUsdEqvLcl( String	usdEqvLcl ) {
		this.usdEqvLcl =	usdEqvLcl;
	}
 
	/**
	 * Column Info
	 * @return	usdEqvLcl
	 */
	 public	 String	getUsdEqvLcl() {
		 return	this.usdEqvLcl;
	 } 
 	/**
	* Column Info
	* @param  adjTotUsd
	*/
	public void	setAdjTotUsd( String	adjTotUsd ) {
		this.adjTotUsd =	adjTotUsd;
	}
 
	/**
	 * Column Info
	 * @return	adjTotUsd
	 */
	 public	 String	getAdjTotUsd() {
		 return	this.adjTotUsd;
	 } 
 	/**
	* Column Info
	* @param  invDt
	*/
	public void	setInvDt( String	invDt ) {
		this.invDt =	invDt;
	}
 
	/**
	 * Column Info
	 * @return	invDt
	 */
	 public	 String	getInvDt() {
		 return	this.invDt;
	 } 
 	/**
	* Column Info
	* @param  rhq
	*/
	public void	setRhq( String	rhq ) {
		this.rhq =	rhq;
	}
 
	/**
	 * Column Info
	 * @return	rhq
	 */
	 public	 String	getRhq() {
		 return	this.rhq;
	 } 
 	/**
	* Column Info
	* @param  totUsd
	*/
	public void	setTotUsd( String	totUsd ) {
		this.totUsd =	totUsd;
	}
 
	/**
	 * Column Info
	 * @return	totUsd
	 */
	 public	 String	getTotUsd() {
		 return	this.totUsd;
	 } 
 	/**
	* Column Info
	* @param  balLoclTaxAmt
	*/
	public void	setBalLoclTaxAmt( String	balLoclTaxAmt ) {
		this.balLoclTaxAmt =	balLoclTaxAmt;
	}
 
	/**
	 * Column Info
	 * @return	balLoclTaxAmt
	 */
	 public	 String	getBalLoclTaxAmt() {
		 return	this.balLoclTaxAmt;
	 } 
 	/**
	* Column Info
	* @param  rhqCd
	*/
	public void	setRhqCd( String	rhqCd ) {
		this.rhqCd =	rhqCd;
	}
 
	/**
	 * Column Info
	 * @return	rhqCd
	 */
	 public	 String	getRhqCd() {
		 return	this.rhqCd;
	 } 
 	/**
	* Column Info
	* @param  rctAmt
	*/
	public void	setRctAmt( String	rctAmt ) {
		this.rctAmt =	rctAmt;
	}
 
	/**
	 * Column Info
	 * @return	rctAmt
	 */
	 public	 String	getRctAmt() {
		 return	this.rctAmt;
	 } 
 	/**
	* Column Info
	* @param  delCd
	*/
	public void	setDelCd( String	delCd ) {
		this.delCd =	delCd;
	}
 
	/**
	 * Column Info
	 * @return	delCd
	 */
	 public	 String	getDelCd() {
		 return	this.delCd;
	 } 
 	/**
	* Column Info
	* @param  adjAmt
	*/
	public void	setAdjAmt( String	adjAmt ) {
		this.adjAmt =	adjAmt;
	}
 
	/**
	 * Column Info
	 * @return	adjAmt
	 */
	 public	 String	getAdjAmt() {
		 return	this.adjAmt;
	 } 
 	/**
	* Column Info
	* @param  bnd
	*/
	public void	setBnd( String	bnd ) {
		this.bnd =	bnd;
	}
 
	/**
	 * Column Info
	 * @return	bnd
	 */
	 public	 String	getBnd() {
		 return	this.bnd;
	 } 
 	/**
	* Column Info
	* @param  podCd
	*/
	public void	setPodCd( String	podCd ) {
		this.podCd =	podCd;
	}
 
	/**
	 * Column Info
	 * @return	podCd
	 */
	 public	 String	getPodCd() {
		 return	this.podCd;
	 } 
 	/**
	* Column Info
	* @param  vvd
	*/
	public void	setVvd( String	vvd ) {
		this.vvd =	vvd;
	}
 
	/**
	 * Column Info
	 * @return	vvd
	 */
	 public	 String	getVvd() {
		 return	this.vvd;
	 } 
 	/**
	* Column Info
	* @param  bkgNo
	*/
	public void	setBkgNo( String	bkgNo ) {
		this.bkgNo =	bkgNo;
	}
 
	/**
	 * Column Info
	 * @return	bkgNo
	 */
	 public	 String	getBkgNo() {
		 return	this.bkgNo;
	 } 
 	/**
	* Column Info
	* @param  crMkFlg
	*/
	public void	setCrMkFlg( String	crMkFlg ) {
		this.crMkFlg =	crMkFlg;
	}
 
	/**
	 * Column Info
	 * @return	crMkFlg
	 */
	 public	 String	getCrMkFlg() {
		 return	this.crMkFlg;
	 } 
 	/**
	* Column Info
	* @param  summaryYn
	*/
	public void	setSummaryYn( String	summaryYn ) {
		this.summaryYn =	summaryYn;
	}
 
	/**
	 * Column Info
	 * @return	summaryYn
	 */
	 public	 String	getSummaryYn() {
		 return	this.summaryYn;
	 } 
 	/**
	* Column Info
	* @param  overdueFrom
	*/
	public void	setOverdueFrom( String	overdueFrom ) {
		this.overdueFrom =	overdueFrom;
	}
 
	/**
	 * Column Info
	 * @return	overdueFrom
	 */
	 public	 String	getOverdueFrom() {
		 return	this.overdueFrom;
	 } 
 	/**
	* Column Info
	* @param  otsOfcCd
	*/
	public void	setOtsOfcCd( String	otsOfcCd ) {
		this.otsOfcCd =	otsOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	otsOfcCd
	 */
	 public	 String	getOtsOfcCd() {
		 return	this.otsOfcCd;
	 } 
 	/**
	* Column Info
	* @param  custCd
	*/
	public void	setCustCd( String	custCd ) {
		this.custCd =	custCd;
	}
 
	/**
	 * Column Info
	 * @return	custCd
	 */
	 public	 String	getCustCd() {
		 return	this.custCd;
	 } 
 	/**
	* Column Info
	* @param  overDue
	*/
	public void	setOverDue( String	overDue ) {
		this.overDue =	overDue;
	}
 
	/**
	 * Column Info
	 * @return	overDue
	 */
	 public	 String	getOverDue() {
		 return	this.overDue;
	 } 
 	/**
	* Column Info
	* @param  adjTotLcl
	*/
	public void	setAdjTotLcl( String	adjTotLcl ) {
		this.adjTotLcl =	adjTotLcl;
	}
 
	/**
	 * Column Info
	 * @return	adjTotLcl
	 */
	 public	 String	getAdjTotLcl() {
		 return	this.adjTotLcl;
	 } 
 	/**
	* Column Info
	* @param  invTotLcl
	*/
	public void	setInvTotLcl( String	invTotLcl ) {
		this.invTotLcl =	invTotLcl;
	}
 
	/**
	 * Column Info
	 * @return	invTotLcl
	 */
	 public	 String	getInvTotLcl() {
		 return	this.invTotLcl;
	 } 
 	/**
	* Column Info
	* @param  sailArrDtFm
	*/
	public void	setSailArrDtFm( String	sailArrDtFm ) {
		this.sailArrDtFm =	sailArrDtFm;
	}
 
	/**
	 * Column Info
	 * @return	sailArrDtFm
	 */
	 public	 String	getSailArrDtFm() {
		 return	this.sailArrDtFm;
	 } 
 	/**
	* Column Info
	* @param  otsOpy
	*/
	public void	setOtsOpy( String	otsOpy ) {
		this.otsOpy =	otsOpy;
	}
 
	/**
	 * Column Info
	 * @return	otsOpy
	 */
	 public	 String	getOtsOpy() {
		 return	this.otsOpy;
	 } 
 	/**
	* Column Info
	* @param  port
	*/
	public void	setPort( String	port ) {
		this.port =	port;
	}
 
	/**
	 * Column Info
	 * @return	port
	 */
	 public	 String	getPort() {
		 return	this.port;
	 } 
 	/**
	* Column Info
	* @param  porCd
	*/
	public void	setPorCd( String	porCd ) {
		this.porCd =	porCd;
	}
 
	/**
	 * Column Info
	 * @return	porCd
	 */
	 public	 String	getPorCd() {
		 return	this.porCd;
	 } 
 	/**
	* Column Info
	* @param  laneCd
	*/
	public void	setLaneCd( String	laneCd ) {
		this.laneCd =	laneCd;
	}
 
	/**
	 * Column Info
	 * @return	laneCd
	 */
	 public	 String	getLaneCd() {
		 return	this.laneCd;
	 } 
 	/**
	* Column Info
	* @param  rctTotUsd
	*/
	public void	setRctTotUsd( String	rctTotUsd ) {
		this.rctTotUsd =	rctTotUsd;
	}
 
	/**
	 * Column Info
	 * @return	rctTotUsd
	 */
	 public	 String	getRctTotUsd() {
		 return	this.rctTotUsd;
	 } 
 	/**
	* Column Info
	* @param  custNm
	*/
	public void	setCustNm( String	custNm ) {
		this.custNm =	custNm;
	}
 
	/**
	 * Column Info
	 * @return	custNm
	 */
	 public	 String	getCustNm() {
		 return	this.custNm;
	 } 
 	/**
	* Column Info
	* @param  invLoclXchRt
	*/
	public void	setInvLoclXchRt( String	invLoclXchRt ) {
		this.invLoclXchRt =	invLoclXchRt;
	}
 
	/**
	 * Column Info
	 * @return	invLoclXchRt
	 */
	 public	 String	getInvLoclXchRt() {
		 return	this.invLoclXchRt;
	 } 
 	/**
	* Column Info
	* @param  usd
	*/
	public void	setUsd( String	usd ) {
		this.usd =	usd;
	}
 
	/**
	 * Column Info
	 * @return	usd
	 */
	 public	 String	getUsd() {
		 return	this.usd;
	 } 
 	/**
	* Column Info
	* @param  rateYn
	*/
	public void	setRateYn( String	rateYn ) {
		this.rateYn =	rateYn;
	}
 
	/**
	 * Column Info
	 * @return	rateYn
	 */
	 public	 String	getRateYn() {
		 return	this.rateYn;
	 } 
 	/**
	* Column Info
	* @param  creditCurrCd
	*/
	public void	setCreditCurrCd( String	creditCurrCd ) {
		this.creditCurrCd =	creditCurrCd;
	}
 
	/**
	 * Column Info
	 * @return	creditCurrCd
	 */
	 public	 String	getCreditCurrCd() {
		 return	this.creditCurrCd;
	 } 
 	/**
	* Column Info
	* @param  balAmt
	*/
	public void	setBalAmt( String	balAmt ) {
		this.balAmt =	balAmt;
	}
 
	/**
	 * Column Info
	 * @return	balAmt
	 */
	 public	 String	getBalAmt() {
		 return	this.balAmt;
	 } 
 	/**
	* Column Info
	* @param  fCustSeq
	*/
	public void	setFCustSeq( String	fCustSeq ) {
		this.fCustSeq =	fCustSeq;
	}
 
	/**
	 * Column Info
	 * @return	fCustSeq
	 */
	 public	 String	getFCustSeq() {
		 return	this.fCustSeq;
	 } 
 	/**
	* Column Info
	* @param  ibflag
	*/
	public void	setIbflag( String	ibflag ) {
		this.ibflag =	ibflag;
	}
 
	/**
	 * Column Info
	 * @return	ibflag
	 */
	 public	 String	getIbflag() {
		 return	this.ibflag;
	 } 
 	/**
	* Column Info
	* @param  blInv
	*/
	public void	setBlInv( String	blInv ) {
		this.blInv =	blInv;
	}
 
	/**
	 * Column Info
	 * @return	blInv
	 */
	 public	 String	getBlInv() {
		 return	this.blInv;
	 } 
 	/**
	* Column Info
	* @param  exRate
	*/
	public void	setExRate( String	exRate ) {
		this.exRate =	exRate;
	}
 
	/**
	 * Column Info
	 * @return	exRate
	 */
	 public	 String	getExRate() {
		 return	this.exRate;
	 } 
 	/**
	* Column Info
	* @param  invAmt
	*/
	public void	setInvAmt( String	invAmt ) {
		this.invAmt =	invAmt;
	}
 
	/**
	 * Column Info
	 * @return	invAmt
	 */
	 public	 String	getInvAmt() {
		 return	this.invAmt;
	 } 
 	/**
	* Column Info
	* @param  dueDt
	*/
	public void	setDueDt( String	dueDt ) {
		this.dueDt =	dueDt;
	}
 
	/**
	 * Column Info
	 * @return	dueDt
	 */
	 public	 String	getDueDt() {
		 return	this.dueDt;
	 } 
 	/**
	* Column Info
	* @param  otsRtFlg
	*/
	public void	setOtsRtFlg( String	otsRtFlg ) {
		this.otsRtFlg =	otsRtFlg;
	}
 
	/**
	 * Column Info
	 * @return	otsRtFlg
	 */
	 public	 String	getOtsRtFlg() {
		 return	this.otsRtFlg;
	 } 
 	/**
	* Column Info
	* @param  rmk
	*/
	public void	setRmk( String	rmk ) {
		this.rmk =	rmk;
	}
 
	/**
	 * Column Info
	 * @return	rmk
	 */
	 public	 String	getRmk() {
		 return	this.rmk;
	 } 
 	/**
	* Column Info
	* @param  kind3Code
	*/
	public void	setKind3Code( String	kind3Code ) {
		this.kind3Code =	kind3Code;
	}
 
	/**
	 * Column Info
	 * @return	kind3Code
	 */
	 public	 String	getKind3Code() {
		 return	this.kind3Code;
	 } 
 	/**
	* Column Info
	* @param  kind2
	*/
	public void	setKind2( String	kind2 ) {
		this.kind2 =	kind2;
	}
 
	/**
	 * Column Info
	 * @return	kind2
	 */
	 public	 String	getKind2() {
		 return	this.kind2;
	 } 
 	/**
	* Column Info
	* @param  kind2Radio
	*/
	public void	setKind2Radio( String	kind2Radio ) {
		this.kind2Radio =	kind2Radio;
	}
 
	/**
	 * Column Info
	 * @return	kind2Radio
	 */
	 public	 String	getKind2Radio() {
		 return	this.kind2Radio;
	 } 
 	/**
	* Column Info
	* @param  kind3
	*/
	public void	setKind3( String	kind3 ) {
		this.kind3 =	kind3;
	}
 
	/**
	 * Column Info
	 * @return	kind3
	 */
	 public	 String	getKind3() {
		 return	this.kind3;
	 } 
 	/**
	* Column Info
	* @param  overdueTo
	*/
	public void	setOverdueTo( String	overdueTo ) {
		this.overdueTo =	overdueTo;
	}
 
	/**
	 * Column Info
	 * @return	overdueTo
	 */
	 public	 String	getOverdueTo() {
		 return	this.overdueTo;
	 } 
 	/**
	* Column Info
	* @param  invCurrCd
	*/
	public void	setInvCurrCd( String	invCurrCd ) {
		this.invCurrCd =	invCurrCd;
	}
 
	/**
	 * Column Info
	 * @return	invCurrCd
	 */
	 public	 String	getInvCurrCd() {
		 return	this.invCurrCd;
	 } 
 	/**
	* Column Info
	* @param  obTerm
	*/
	public void	setObTerm( String	obTerm ) {
		this.obTerm =	obTerm;
	}
 
	/**
	 * Column Info
	 * @return	obTerm
	 */
	 public	 String	getObTerm() {
		 return	this.obTerm;
	 } 
 	/**
	* Column Info
	* @param  balLoclFrtAmt
	*/
	public void	setBalLoclFrtAmt( String	balLoclFrtAmt ) {
		this.balLoclFrtAmt =	balLoclFrtAmt;
	}
 
	/**
	 * Column Info
	 * @return	balLoclFrtAmt
	 */
	 public	 String	getBalLoclFrtAmt() {
		 return	this.balLoclFrtAmt;
	 } 
 	/**
	* Column Info
	* @param  creditFlg
	*/
	public void	setCreditFlg( String	creditFlg ) {
		this.creditFlg =	creditFlg;
	}
 
	/**
	 * Column Info
	 * @return	creditFlg
	 */
	 public	 String	getCreditFlg() {
		 return	this.creditFlg;
	 } 
 	/**
	* Column Info
	* @param  fCustCntCd
	*/
	public void	setFCustCntCd( String	fCustCntCd ) {
		this.fCustCntCd =	fCustCntCd;
	}
 
	/**
	 * Column Info
	 * @return	fCustCntCd
	 */
	 public	 String	getFCustCntCd() {
		 return	this.fCustCntCd;
	 } 
 	/**
	* Column Info
	* @param  invNo
	*/
	public void	setInvNo( String	invNo ) {
		this.invNo =	invNo;
	}
 
	/**
	 * Column Info
	 * @return	invNo
	 */
	 public	 String	getInvNo() {
		 return	this.invNo;
	 } 
 	/**
	* Column Info
	* @param  dateTpCd
	*/
	public void	setDateTpCd( String	dateTpCd ) {
		this.dateTpCd =	dateTpCd;
	}
 
	/**
	 * Column Info
	 * @return	dateTpCd
	 */
	 public	 String	getDateTpCd() {
		 return	this.dateTpCd;
	 } 
 	/**
	* Column Info
	* @param  ofcCd
	*/
	public void	setOfcCd( String	ofcCd ) {
		this.ofcCd =	ofcCd;
	}
 
	/**
	 * Column Info
	 * @return	ofcCd
	 */
	 public	 String	getOfcCd() {
		 return	this.ofcCd;
	 } 
 	/**
	* Column Info
	* @param  apArOffstNo
	*/
	public void	setApArOffstNo( String	apArOffstNo ) {
		this.apArOffstNo =	apArOffstNo;
	}
 
	/**
	 * Column Info
	 * @return	apArOffstNo
	 */
	 public	 String	getApArOffstNo() {
		 return	this.apArOffstNo;
	 } 
 	/**
	* Column Info
	* @param  invUsdXchRt
	*/
	public void	setInvUsdXchRt( String	invUsdXchRt ) {
		this.invUsdXchRt =	invUsdXchRt;
	}
 
	/**
	 * Column Info
	 * @return	invUsdXchRt
	 */
	 public	 String	getInvUsdXchRt() {
		 return	this.invUsdXchRt;
	 } 
 	/**
	* Column Info
	* @param  custSrepCd
	*/
	public void	setCustSrepCd( String	custSrepCd ) {
		this.custSrepCd =	custSrepCd;
	}
 
	/**
	 * Column Info
	 * @return	custSrepCd
	 */
	 public	 String	getCustSrepCd() {
		 return	this.custSrepCd;
	 } 
 	/**
	* Column Info
	* @param  refNo
	*/
	public void	setRefNo( String	refNo ) {
		this.refNo =	refNo;
	}
 
	/**
	 * Column Info
	 * @return	refNo
	 */
	 public	 String	getRefNo() {
		 return	this.refNo;
	 } 
 	/**
	* Column Info
	* @param  creidtMk
	*/
	public void	setCreidtMk( String	creidtMk ) {
		this.creidtMk =	creidtMk;
	}
 
	/**
	 * Column Info
	 * @return	creidtMk
	 */
	 public	 String	getCreidtMk() {
		 return	this.creidtMk;
	 } 
 	/**
	* Column Info
	* @param  otsPayCd
	*/
	public void	setOtsPayCd( String	otsPayCd ) {
		this.otsPayCd =	otsPayCd;
	}
 
	/**
	 * Column Info
	 * @return	otsPayCd
	 */
	 public	 String	getOtsPayCd() {
		 return	this.otsPayCd;
	 } 
 	/**
	* Column Info
	* @param  orgInvNo
	*/
	public void	setOrgInvNo( String	orgInvNo ) {
		this.orgInvNo =	orgInvNo;
	}
 
	/**
	 * Column Info
	 * @return	orgInvNo
	 */
	 public	 String	getOrgInvNo() {
		 return	this.orgInvNo;
	 } 
 	/**
	* Column Info
	* @param  iPage
	*/
	public void	setIPage( String	iPage ) {
		this.iPage =	iPage;
	}
 
	/**
	 * Column Info
	 * @return	iPage
	 */
	 public	 String	getIPage() {
		 return	this.iPage;
	 } 
 	/**
	* Column Info
	* @param  totalCnt
	*/
	public void	setTotalCnt( String	totalCnt ) {
		this.totalCnt =	totalCnt;
	}
 
	/**
	 * Column Info
	 * @return	totalCnt
	 */
	 public	 String	getTotalCnt() {
		 return	this.totalCnt;
	 } 
 	/**
	* Column Info
	* @param  totalUsdAmt
	*/
	public void	setTotalUsdAmt( String	totalUsdAmt ) {
		this.totalUsdAmt =	totalUsdAmt;
	}
 
	/**
	 * Column Info
	 * @return	totalUsdAmt
	 */
	 public	 String	getTotalUsdAmt() {
		 return	this.totalUsdAmt;
	 } 
 	/**
	* Column Info
	* @param  totalLclAmt
	*/
	public void	setTotalLclAmt( String	totalLclAmt ) {
		this.totalLclAmt =	totalLclAmt;
	}
 
	/**
	 * Column Info
	 * @return	totalLclAmt
	 */
	 public	 String	getTotalLclAmt() {
		 return	this.totalLclAmt;
	 } 

	/**
	 * Request 의 데이터를 추출하여 VO 의	멤버변수에 설정.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request)	{
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의	멤버변수에 설정.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request,	String prefix) {
		setChgTpCd(JSPUtil.getParameter(request,	prefix + "chg_tp_cd", ""));
		setTotLcl(JSPUtil.getParameter(request,	prefix + "tot_lcl", ""));
		setRctTotLcl(JSPUtil.getParameter(request,	prefix + "rct_tot_lcl", ""));
		setBiltoCntCd(JSPUtil.getParameter(request,	prefix + "bilto_cnt_cd", ""));
		setSvcScpCd(JSPUtil.getParameter(request,	prefix + "svc_scp_cd", ""));
		setIbTerm(JSPUtil.getParameter(request,	prefix + "ib_term", ""));
		setOtsTpCd(JSPUtil.getParameter(request,	prefix + "ots_tp_cd", ""));
		setKind3Code2(JSPUtil.getParameter(request,	prefix + "kind3_code2", ""));
		setCreditLimit(JSPUtil.getParameter(request,	prefix + "credit_limit", ""));
		setBiltoCustSeq(JSPUtil.getParameter(request,	prefix + "bilto_cust_seq", ""));
		setSailArrDt(JSPUtil.getParameter(request,	prefix + "sail_arr_dt", ""));
		setBlNo(JSPUtil.getParameter(request,	prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setSaleRepCd(JSPUtil.getParameter(request,	prefix + "sale_rep_cd", ""));
		setPolCd(JSPUtil.getParameter(request,	prefix + "pol_cd", ""));
		setScNo(JSPUtil.getParameter(request,	prefix + "sc_no", ""));
		setSortSeq(JSPUtil.getParameter(request,	prefix + "sort_seq", ""));
		setOtsGrpTpCd(JSPUtil.getParameter(request,	prefix + "ots_grp_tp_cd", ""));
		setSailArrDtTo(JSPUtil.getParameter(request,	prefix + "sail_arr_dt_to", ""));
		setInvTotUsd(JSPUtil.getParameter(request,	prefix + "inv_tot_usd", ""));
		setUsdEqvLcl(JSPUtil.getParameter(request,	prefix + "usd_eqv_lcl", ""));
		setAdjTotUsd(JSPUtil.getParameter(request,	prefix + "adj_tot_usd", ""));
		setInvDt(JSPUtil.getParameter(request,	prefix + "inv_dt", ""));
		setRhq(JSPUtil.getParameter(request,	prefix + "rhq", ""));
		setTotUsd(JSPUtil.getParameter(request,	prefix + "tot_usd", ""));
		setBalLoclTaxAmt(JSPUtil.getParameter(request,	prefix + "bal_locl_tax_amt", ""));
		setRhqCd(JSPUtil.getParameter(request,	prefix + "rhq_cd", ""));
		setRctAmt(JSPUtil.getParameter(request,	prefix + "rct_amt", ""));
		setDelCd(JSPUtil.getParameter(request,	prefix + "del_cd", ""));
		setAdjAmt(JSPUtil.getParameter(request,	prefix + "adj_amt", ""));
		setBnd(JSPUtil.getParameter(request,	prefix + "bnd", ""));
		setPodCd(JSPUtil.getParameter(request,	prefix + "pod_cd", ""));
		setVvd(JSPUtil.getParameter(request,	prefix + "vvd", ""));
		setBkgNo(JSPUtil.getParameter(request,	prefix + "bkg_no", ""));
		setCrMkFlg(JSPUtil.getParameter(request,	prefix + "cr_mk_flg", ""));
		setSummaryYn(JSPUtil.getParameter(request,	prefix + "summary_yn", ""));
		setOverdueFrom(JSPUtil.getParameter(request,	prefix + "overdue_from", ""));
		setOtsOfcCd(JSPUtil.getParameter(request,	prefix + "ots_ofc_cd", ""));
		setCustCd(JSPUtil.getParameter(request,	prefix + "cust_cd", ""));
		setOverDue(JSPUtil.getParameter(request,	prefix + "over_due", ""));
		setAdjTotLcl(JSPUtil.getParameter(request,	prefix + "adj_tot_lcl", ""));
		setInvTotLcl(JSPUtil.getParameter(request,	prefix + "inv_tot_lcl", ""));
		setSailArrDtFm(JSPUtil.getParameter(request,	prefix + "sail_arr_dt_fm", ""));
		setOtsOpy(JSPUtil.getParameter(request,	prefix + "ots_opy", ""));
		setPort(JSPUtil.getParameter(request,	prefix + "port", ""));
		setPorCd(JSPUtil.getParameter(request,	prefix + "por_cd", ""));
		setLaneCd(JSPUtil.getParameter(request,	prefix + "lane_cd", ""));
		setRctTotUsd(JSPUtil.getParameter(request,	prefix + "rct_tot_usd", ""));
		setCustNm(JSPUtil.getParameter(request,	prefix + "cust_nm", ""));
		setInvLoclXchRt(JSPUtil.getParameter(request,	prefix + "inv_locl_xch_rt", ""));
		setUsd(JSPUtil.getParameter(request,	prefix + "usd", ""));
		setRateYn(JSPUtil.getParameter(request,	prefix + "rate_yn", ""));
		setCreditCurrCd(JSPUtil.getParameter(request,	prefix + "credit_curr_cd", ""));
		setBalAmt(JSPUtil.getParameter(request,	prefix + "bal_amt", ""));
		setFCustSeq(JSPUtil.getParameter(request,	prefix + "f_cust_seq", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setBlInv(JSPUtil.getParameter(request,	prefix + "bl_inv", ""));
		setExRate(JSPUtil.getParameter(request,	prefix + "ex_rate", ""));
		setInvAmt(JSPUtil.getParameter(request,	prefix + "inv_amt", ""));
		setDueDt(JSPUtil.getParameter(request,	prefix + "due_dt", ""));
		setOtsRtFlg(JSPUtil.getParameter(request,	prefix + "ots_rt_flg", ""));
		setRmk(JSPUtil.getParameter(request,	prefix + "rmk", ""));
		setKind3Code(JSPUtil.getParameter(request,	prefix + "kind3_code", ""));
		setKind2(JSPUtil.getParameter(request,	prefix + "kind2", ""));
		setKind2Radio(JSPUtil.getParameter(request,	prefix + "kind2_radio", ""));
		setKind3(JSPUtil.getParameter(request,	prefix + "kind_3", ""));
		setOverdueTo(JSPUtil.getParameter(request,	prefix + "overdue_to", ""));
		setInvCurrCd(JSPUtil.getParameter(request,	prefix + "inv_curr_cd", ""));
		setObTerm(JSPUtil.getParameter(request,	prefix + "ob_term", ""));
		setBalLoclFrtAmt(JSPUtil.getParameter(request,	prefix + "bal_locl_frt_amt", ""));
		setCreditFlg(JSPUtil.getParameter(request,	prefix + "credit_flg", ""));
		setFCustCntCd(JSPUtil.getParameter(request,	prefix + "f_cust_cnt_cd", ""));
		setInvNo(JSPUtil.getParameter(request,	prefix + "inv_no", ""));
		setDateTpCd(JSPUtil.getParameter(request,	prefix + "date_tp_cd", ""));
		setOfcCd(JSPUtil.getParameter(request,	prefix + "ofc_cd", ""));
		setApArOffstNo(JSPUtil.getParameter(request,	prefix + "ap_ar_offst_no", ""));
		setInvUsdXchRt(JSPUtil.getParameter(request,	prefix + "inv_usd_xch_rt", ""));
		setCustSrepCd(JSPUtil.getParameter(request,	prefix + "cust_srep_cd", ""));
		setRefNo(JSPUtil.getParameter(request,	prefix + "ref_no", ""));
		setCreidtMk(JSPUtil.getParameter(request,	prefix + "creidt_mk", ""));
		setOtsPayCd(JSPUtil.getParameter(request,	prefix + "ots_pay_cd", ""));
		setOrgInvNo(JSPUtil.getParameter(request,	prefix + "org_inv_no", ""));
		setIPage(JSPUtil.getParameter(request,	prefix + "i_page", ""));
		setTotalCnt(JSPUtil.getParameter(request,	prefix + "total_cnt", ""));
		setTotalUsdAmt(JSPUtil.getParameter(request,	prefix + "total_usd_amt", ""));
		setTotalLclAmt(JSPUtil.getParameter(request,	prefix + "total_lcl_amt", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AROustandingbySADateVO[]
	 */
	public AROustandingbySADateVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return AROustandingbySADateVO[]
	 */
	public AROustandingbySADateVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		AROustandingbySADateVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] chgTpCd =	(JSPUtil.getParameter(request, prefix +	"chg_tp_cd".trim(),	length));
				String[] totLcl =	(JSPUtil.getParameter(request, prefix +	"tot_lcl".trim(),	length));
				String[] rctTotLcl =	(JSPUtil.getParameter(request, prefix +	"rct_tot_lcl".trim(),	length));
				String[] biltoCntCd =	(JSPUtil.getParameter(request, prefix +	"bilto_cnt_cd".trim(),	length));
				String[] svcScpCd =	(JSPUtil.getParameter(request, prefix +	"svc_scp_cd".trim(),	length));
				String[] ibTerm =	(JSPUtil.getParameter(request, prefix +	"ib_term".trim(),	length));
				String[] otsTpCd =	(JSPUtil.getParameter(request, prefix +	"ots_tp_cd".trim(),	length));
				String[] kind3Code2 =	(JSPUtil.getParameter(request, prefix +	"kind3_code2".trim(),	length));
				String[] creditLimit =	(JSPUtil.getParameter(request, prefix +	"credit_limit".trim(),	length));
				String[] biltoCustSeq =	(JSPUtil.getParameter(request, prefix +	"bilto_cust_seq".trim(),	length));
				String[] sailArrDt =	(JSPUtil.getParameter(request, prefix +	"sail_arr_dt".trim(),	length));
				String[] blNo =	(JSPUtil.getParameter(request, prefix +	"bl_no".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] saleRepCd =	(JSPUtil.getParameter(request, prefix +	"sale_rep_cd".trim(),	length));
				String[] polCd =	(JSPUtil.getParameter(request, prefix +	"pol_cd".trim(),	length));
				String[] scNo =	(JSPUtil.getParameter(request, prefix +	"sc_no".trim(),	length));
				String[] sortSeq =	(JSPUtil.getParameter(request, prefix +	"sort_seq".trim(),	length));
				String[] otsGrpTpCd =	(JSPUtil.getParameter(request, prefix +	"ots_grp_tp_cd".trim(),	length));
				String[] sailArrDtTo =	(JSPUtil.getParameter(request, prefix +	"sail_arr_dt_to".trim(),	length));
				String[] invTotUsd =	(JSPUtil.getParameter(request, prefix +	"inv_tot_usd".trim(),	length));
				String[] usdEqvLcl =	(JSPUtil.getParameter(request, prefix +	"usd_eqv_lcl".trim(),	length));
				String[] adjTotUsd =	(JSPUtil.getParameter(request, prefix +	"adj_tot_usd".trim(),	length));
				String[] invDt =	(JSPUtil.getParameter(request, prefix +	"inv_dt".trim(),	length));
				String[] rhq =	(JSPUtil.getParameter(request, prefix +	"rhq".trim(),	length));
				String[] totUsd =	(JSPUtil.getParameter(request, prefix +	"tot_usd".trim(),	length));
				String[] balLoclTaxAmt =	(JSPUtil.getParameter(request, prefix +	"bal_locl_tax_amt".trim(),	length));
				String[] rhqCd =	(JSPUtil.getParameter(request, prefix +	"rhq_cd".trim(),	length));
				String[] rctAmt =	(JSPUtil.getParameter(request, prefix +	"rct_amt".trim(),	length));
				String[] delCd =	(JSPUtil.getParameter(request, prefix +	"del_cd".trim(),	length));
				String[] adjAmt =	(JSPUtil.getParameter(request, prefix +	"adj_amt".trim(),	length));
				String[] bnd =	(JSPUtil.getParameter(request, prefix +	"bnd".trim(),	length));
				String[] podCd =	(JSPUtil.getParameter(request, prefix +	"pod_cd".trim(),	length));
				String[] vvd =	(JSPUtil.getParameter(request, prefix +	"vvd".trim(),	length));
				String[] bkgNo =	(JSPUtil.getParameter(request, prefix +	"bkg_no".trim(),	length));
				String[] crMkFlg =	(JSPUtil.getParameter(request, prefix +	"cr_mk_flg".trim(),	length));
				String[] summaryYn =	(JSPUtil.getParameter(request, prefix +	"summary_yn".trim(),	length));
				String[] overdueFrom =	(JSPUtil.getParameter(request, prefix +	"overdue_from".trim(),	length));
				String[] otsOfcCd =	(JSPUtil.getParameter(request, prefix +	"ots_ofc_cd".trim(),	length));
				String[] custCd =	(JSPUtil.getParameter(request, prefix +	"cust_cd".trim(),	length));
				String[] overDue =	(JSPUtil.getParameter(request, prefix +	"over_due".trim(),	length));
				String[] adjTotLcl =	(JSPUtil.getParameter(request, prefix +	"adj_tot_lcl".trim(),	length));
				String[] invTotLcl =	(JSPUtil.getParameter(request, prefix +	"inv_tot_lcl".trim(),	length));
				String[] sailArrDtFm =	(JSPUtil.getParameter(request, prefix +	"sail_arr_dt_fm".trim(),	length));
				String[] otsOpy =	(JSPUtil.getParameter(request, prefix +	"ots_opy".trim(),	length));
				String[] port =	(JSPUtil.getParameter(request, prefix +	"port".trim(),	length));
				String[] porCd =	(JSPUtil.getParameter(request, prefix +	"por_cd".trim(),	length));
				String[] laneCd =	(JSPUtil.getParameter(request, prefix +	"lane_cd".trim(),	length));
				String[] rctTotUsd =	(JSPUtil.getParameter(request, prefix +	"rct_tot_usd".trim(),	length));
				String[] custNm =	(JSPUtil.getParameter(request, prefix +	"cust_nm".trim(),	length));
				String[] invLoclXchRt =	(JSPUtil.getParameter(request, prefix +	"inv_locl_xch_rt".trim(),	length));
				String[] usd =	(JSPUtil.getParameter(request, prefix +	"usd".trim(),	length));
				String[] rateYn =	(JSPUtil.getParameter(request, prefix +	"rate_yn".trim(),	length));
				String[] creditCurrCd =	(JSPUtil.getParameter(request, prefix +	"credit_curr_cd".trim(),	length));
				String[] balAmt =	(JSPUtil.getParameter(request, prefix +	"bal_amt".trim(),	length));
				String[] fCustSeq =	(JSPUtil.getParameter(request, prefix +	"f_cust_seq".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] blInv =	(JSPUtil.getParameter(request, prefix +	"bl_inv".trim(),	length));
				String[] exRate =	(JSPUtil.getParameter(request, prefix +	"ex_rate".trim(),	length));
				String[] invAmt =	(JSPUtil.getParameter(request, prefix +	"inv_amt".trim(),	length));
				String[] dueDt =	(JSPUtil.getParameter(request, prefix +	"due_dt".trim(),	length));
				String[] otsRtFlg =	(JSPUtil.getParameter(request, prefix +	"ots_rt_flg".trim(),	length));
				String[] rmk =	(JSPUtil.getParameter(request, prefix +	"rmk".trim(),	length));
				String[] kind3Code =	(JSPUtil.getParameter(request, prefix +	"kind3_code".trim(),	length));
				String[] kind2 =	(JSPUtil.getParameter(request, prefix +	"kind2".trim(),	length));
				String[] kind2Radio =	(JSPUtil.getParameter(request, prefix +	"kind2_radio".trim(),	length));
				String[] kind3 =	(JSPUtil.getParameter(request, prefix +	"kind_3".trim(),	length));
				String[] overdueTo =	(JSPUtil.getParameter(request, prefix +	"overdue_to".trim(),	length));
				String[] invCurrCd =	(JSPUtil.getParameter(request, prefix +	"inv_curr_cd".trim(),	length));
				String[] obTerm =	(JSPUtil.getParameter(request, prefix +	"ob_term".trim(),	length));
				String[] balLoclFrtAmt =	(JSPUtil.getParameter(request, prefix +	"bal_locl_frt_amt".trim(),	length));
				String[] creditFlg =	(JSPUtil.getParameter(request, prefix +	"credit_flg".trim(),	length));
				String[] fCustCntCd =	(JSPUtil.getParameter(request, prefix +	"f_cust_cnt_cd".trim(),	length));
				String[] invNo =	(JSPUtil.getParameter(request, prefix +	"inv_no".trim(),	length));
				String[] dateTpCd =	(JSPUtil.getParameter(request, prefix +	"date_tp_cd".trim(),	length));
				String[] ofcCd =	(JSPUtil.getParameter(request, prefix +	"ofc_cd".trim(),	length));
				String[] apArOffstNo =	(JSPUtil.getParameter(request, prefix +	"ap_ar_offst_no".trim(),	length));
				String[] invUsdXchRt =	(JSPUtil.getParameter(request, prefix +	"inv_usd_xch_rt".trim(),	length));
				String[] custSrepCd =	(JSPUtil.getParameter(request, prefix +	"cust_srep_cd".trim(),	length));
				String[] refNo =	(JSPUtil.getParameter(request, prefix +	"ref_no".trim(),	length));
				String[] creidtMk =	(JSPUtil.getParameter(request, prefix +	"creidt_mk".trim(),	length));
				String[] otsPayCd =	(JSPUtil.getParameter(request, prefix +	"ots_pay_cd".trim(),	length));
				String[] orgInvNo =	(JSPUtil.getParameter(request, prefix +	"org_inv_no".trim(),	length));
				String[] iPage =	(JSPUtil.getParameter(request, prefix +	"i_page".trim(),	length));
				String[] totalCnt =	(JSPUtil.getParameter(request, prefix +	"total_cnt".trim(),	length));
				String[] totalUsdAmt =	(JSPUtil.getParameter(request, prefix +	"total_usd_amt".trim(),	length));
				String[] totalLclAmt =	(JSPUtil.getParameter(request, prefix +	"total_lcl_amt".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	AROustandingbySADateVO();
						if ( chgTpCd[i] !=	null)
						model.setChgTpCd( chgTpCd[i]);
						if ( totLcl[i] !=	null)
						model.setTotLcl( totLcl[i]);
						if ( rctTotLcl[i] !=	null)
						model.setRctTotLcl( rctTotLcl[i]);
						if ( biltoCntCd[i] !=	null)
						model.setBiltoCntCd( biltoCntCd[i]);
						if ( svcScpCd[i] !=	null)
						model.setSvcScpCd( svcScpCd[i]);
						if ( ibTerm[i] !=	null)
						model.setIbTerm( ibTerm[i]);
						if ( otsTpCd[i] !=	null)
						model.setOtsTpCd( otsTpCd[i]);
						if ( kind3Code2[i] !=	null)
						model.setKind3Code2( kind3Code2[i]);
						if ( creditLimit[i] !=	null)
						model.setCreditLimit( creditLimit[i]);
						if ( biltoCustSeq[i] !=	null)
						model.setBiltoCustSeq( biltoCustSeq[i]);
						if ( sailArrDt[i] !=	null)
						model.setSailArrDt( sailArrDt[i]);
						if ( blNo[i] !=	null)
						model.setBlNo( blNo[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( saleRepCd[i] !=	null)
						model.setSaleRepCd( saleRepCd[i]);
						if ( polCd[i] !=	null)
						model.setPolCd( polCd[i]);
						if ( scNo[i] !=	null)
						model.setScNo( scNo[i]);
						if ( sortSeq[i] !=	null)
						model.setSortSeq( sortSeq[i]);
						if ( otsGrpTpCd[i] !=	null)
						model.setOtsGrpTpCd( otsGrpTpCd[i]);
						if ( sailArrDtTo[i] !=	null)
						model.setSailArrDtTo( sailArrDtTo[i]);
						if ( invTotUsd[i] !=	null)
						model.setInvTotUsd( invTotUsd[i]);
						if ( usdEqvLcl[i] !=	null)
						model.setUsdEqvLcl( usdEqvLcl[i]);
						if ( adjTotUsd[i] !=	null)
						model.setAdjTotUsd( adjTotUsd[i]);
						if ( invDt[i] !=	null)
						model.setInvDt( invDt[i]);
						if ( rhq[i] !=	null)
						model.setRhq( rhq[i]);
						if ( totUsd[i] !=	null)
						model.setTotUsd( totUsd[i]);
						if ( balLoclTaxAmt[i] !=	null)
						model.setBalLoclTaxAmt( balLoclTaxAmt[i]);
						if ( rhqCd[i] !=	null)
						model.setRhqCd( rhqCd[i]);
						if ( rctAmt[i] !=	null)
						model.setRctAmt( rctAmt[i]);
						if ( delCd[i] !=	null)
						model.setDelCd( delCd[i]);
						if ( adjAmt[i] !=	null)
						model.setAdjAmt( adjAmt[i]);
						if ( bnd[i] !=	null)
						model.setBnd( bnd[i]);
						if ( podCd[i] !=	null)
						model.setPodCd( podCd[i]);
						if ( vvd[i] !=	null)
						model.setVvd( vvd[i]);
						if ( bkgNo[i] !=	null)
						model.setBkgNo( bkgNo[i]);
						if ( crMkFlg[i] !=	null)
						model.setCrMkFlg( crMkFlg[i]);
						if ( summaryYn[i] !=	null)
						model.setSummaryYn( summaryYn[i]);
						if ( overdueFrom[i] !=	null)
						model.setOverdueFrom( overdueFrom[i]);
						if ( otsOfcCd[i] !=	null)
						model.setOtsOfcCd( otsOfcCd[i]);
						if ( custCd[i] !=	null)
						model.setCustCd( custCd[i]);
						if ( overDue[i] !=	null)
						model.setOverDue( overDue[i]);
						if ( adjTotLcl[i] !=	null)
						model.setAdjTotLcl( adjTotLcl[i]);
						if ( invTotLcl[i] !=	null)
						model.setInvTotLcl( invTotLcl[i]);
						if ( sailArrDtFm[i] !=	null)
						model.setSailArrDtFm( sailArrDtFm[i]);
						if ( otsOpy[i] !=	null)
						model.setOtsOpy( otsOpy[i]);
						if ( port[i] !=	null)
						model.setPort( port[i]);
						if ( porCd[i] !=	null)
						model.setPorCd( porCd[i]);
						if ( laneCd[i] !=	null)
						model.setLaneCd( laneCd[i]);
						if ( rctTotUsd[i] !=	null)
						model.setRctTotUsd( rctTotUsd[i]);
						if ( custNm[i] !=	null)
						model.setCustNm( custNm[i]);
						if ( invLoclXchRt[i] !=	null)
						model.setInvLoclXchRt( invLoclXchRt[i]);
						if ( usd[i] !=	null)
						model.setUsd( usd[i]);
						if ( rateYn[i] !=	null)
						model.setRateYn( rateYn[i]);
						if ( creditCurrCd[i] !=	null)
						model.setCreditCurrCd( creditCurrCd[i]);
						if ( balAmt[i] !=	null)
						model.setBalAmt( balAmt[i]);
						if ( fCustSeq[i] !=	null)
						model.setFCustSeq( fCustSeq[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( blInv[i] !=	null)
						model.setBlInv( blInv[i]);
						if ( exRate[i] !=	null)
						model.setExRate( exRate[i]);
						if ( invAmt[i] !=	null)
						model.setInvAmt( invAmt[i]);
						if ( dueDt[i] !=	null)
						model.setDueDt( dueDt[i]);
						if ( otsRtFlg[i] !=	null)
						model.setOtsRtFlg( otsRtFlg[i]);
						if ( rmk[i] !=	null)
						model.setRmk( rmk[i]);
						if ( kind3Code[i] !=	null)
						model.setKind3Code( kind3Code[i]);
						if ( kind2[i] !=	null)
						model.setKind2( kind2[i]);
						if ( kind2Radio[i] !=	null)
						model.setKind2Radio( kind2Radio[i]);
						if ( kind3[i] !=	null)
						model.setKind3( kind3[i]);
						if ( overdueTo[i] !=	null)
						model.setOverdueTo( overdueTo[i]);
						if ( invCurrCd[i] !=	null)
						model.setInvCurrCd( invCurrCd[i]);
						if ( obTerm[i] !=	null)
						model.setObTerm( obTerm[i]);
						if ( balLoclFrtAmt[i] !=	null)
						model.setBalLoclFrtAmt( balLoclFrtAmt[i]);
						if ( creditFlg[i] !=	null)
						model.setCreditFlg( creditFlg[i]);
						if ( fCustCntCd[i] !=	null)
						model.setFCustCntCd( fCustCntCd[i]);
						if ( invNo[i] !=	null)
						model.setInvNo( invNo[i]);
						if ( dateTpCd[i] !=	null)
						model.setDateTpCd( dateTpCd[i]);
						if ( ofcCd[i] !=	null)
						model.setOfcCd( ofcCd[i]);
						if ( apArOffstNo[i] !=	null)
						model.setApArOffstNo( apArOffstNo[i]);
						if ( invUsdXchRt[i] !=	null)
						model.setInvUsdXchRt( invUsdXchRt[i]);
						if ( custSrepCd[i] !=	null)
						model.setCustSrepCd( custSrepCd[i]);
						if ( refNo[i] !=	null)
						model.setRefNo( refNo[i]);
						if ( creidtMk[i] !=	null)
						model.setCreidtMk( creidtMk[i]);
						if ( otsPayCd[i] !=	null)
						model.setOtsPayCd( otsPayCd[i]);
						if ( orgInvNo[i] !=	null)
						model.setOrgInvNo( orgInvNo[i]);
						if ( iPage[i] !=	null)
						model.setIPage( iPage[i]);
						if ( totalCnt[i] !=	null)
						model.setTotalCnt( totalCnt[i]);
						if ( totalUsdAmt[i] !=	null)
						model.setTotalUsdAmt( totalUsdAmt[i]);
						if ( totalLclAmt[i] !=	null)
						model.setTotalLclAmt( totalLclAmt[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getAROustandingbySADateVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return AROustandingbySADateVO[]
	 */
	public AROustandingbySADateVO[]	 getAROustandingbySADateVOs(){
		AROustandingbySADateVO[] vos = (AROustandingbySADateVO[])models.toArray(new	AROustandingbySADateVO[models.size()]);
		return vos;
		}

	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String  toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	}
	

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void	unDataFormat(){
		this.chgTpCd =	this.chgTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totLcl =	this.totLcl.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctTotLcl =	this.rctTotLcl.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.biltoCntCd =	this.biltoCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd =	this.svcScpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibTerm =	this.ibTerm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsTpCd =	this.otsTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kind3Code2 =	this.kind3Code2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creditLimit =	this.creditLimit.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.biltoCustSeq =	this.biltoCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailArrDt =	this.sailArrDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo =	this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.saleRepCd =	this.saleRepCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd =	this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo =	this.scNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sortSeq =	this.sortSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsGrpTpCd =	this.otsGrpTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailArrDtTo =	this.sailArrDtTo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTotUsd =	this.invTotUsd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdEqvLcl =	this.usdEqvLcl.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjTotUsd =	this.adjTotUsd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDt =	this.invDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq =	this.rhq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totUsd =	this.totUsd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.balLoclTaxAmt =	this.balLoclTaxAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd =	this.rhqCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctAmt =	this.rctAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd =	this.delCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjAmt =	this.adjAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bnd =	this.bnd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd =	this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd =	this.vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo =	this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crMkFlg =	this.crMkFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.summaryYn =	this.summaryYn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overdueFrom =	this.overdueFrom.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsOfcCd =	this.otsOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd =	this.custCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overDue =	this.overDue.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjTotLcl =	this.adjTotLcl.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTotLcl =	this.invTotLcl.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailArrDtFm =	this.sailArrDtFm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsOpy =	this.otsOpy.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.port =	this.port.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd =	this.porCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneCd =	this.laneCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctTotUsd =	this.rctTotUsd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm =	this.custNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invLoclXchRt =	this.invLoclXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usd =	this.usd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateYn =	this.rateYn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creditCurrCd =	this.creditCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.balAmt =	this.balAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCustSeq =	this.fCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blInv =	this.blInv.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exRate =	this.exRate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt =	this.invAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dueDt =	this.dueDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsRtFlg =	this.otsRtFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rmk =	this.rmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kind3Code =	this.kind3Code.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kind2 =	this.kind2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kind2Radio =	this.kind2Radio.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kind3 =	this.kind3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overdueTo =	this.overdueTo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCurrCd =	this.invCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obTerm =	this.obTerm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.balLoclFrtAmt =	this.balLoclFrtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creditFlg =	this.creditFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCustCntCd =	this.fCustCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo =	this.invNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateTpCd =	this.dateTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd =	this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apArOffstNo =	this.apArOffstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invUsdXchRt =	this.invUsdXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSrepCd =	this.custSrepCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refNo =	this.refNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creidtMk =	this.creidtMk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsPayCd =	this.otsPayCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgInvNo =	this.orgInvNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iPage =	this.iPage.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalCnt =	this.totalCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalUsdAmt =	this.totalUsdAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalLclAmt =	this.totalLclAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}