/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : APIFPaymentCSRInfoListVO.java
 *@FileTitle : APIFPaymentCSRInfoListVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.01.04
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2016.01.04  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo;

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
 * - PDTO(Data Transfer	Object including Parameters)<br>
 * - 관련	Event에서	작성,	서버실행요청시	PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author 
 * @since J2EE 1.6
 * @see	..
 */
public class APIFPaymentCSRInfoListVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<APIFPaymentCSRInfoListVO>  models =	new	ArrayList<APIFPaymentCSRInfoListVO>();


	/*	Column Info	*/
	private  String	 xchRtTpCd   =  null;
	/*	Column Info	*/
	private  String	 payXchDt   =  null;
	/*	Column Info	*/
	private  String	 paySkdNo   =  null;
	/*	Column Info	*/
	private  String	 payAddr2   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt13   =  null;
	/*	Column Info	*/
	private  String	 payAddr1   =  null;
	/*	Column Info	*/
	private  String	 invSeq   =  null;
	/*	Column Info	*/
	private  String	 acctgPstFlg   =  null;
	/*	Column Info	*/
	private  String	 payBatRunSeq   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 vndrNm   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 vndrNo   =  null;
	/*	Column Info	*/
	private  String	 usrId   =  null;
	/*	Column Info	*/
	private  String	 payAmt   =  null;
	/*	Column Info	*/
	private  String	 apCtyCd   =  null;
	/*	Column Info	*/
	private  String	 liabCdCmbSeq   =  null;
	/*	Column Info	*/
	private  String	 payDesc   =  null;
	/*	Column Info	*/
	private  String	 payXchRt   =  null;
	/*	Column Info	*/
	private  String	 csrNo   =  null;
	/*	Column Info	*/
	private  String	 invPayCurrCd   =  null;
	/*	Column Info	*/
	private  String	 payStsLuCd   =  null;
	/*	Column Info	*/
	private  String	 xterBankAcctSeq   =  null;
	/*	Column Info	*/
	private  String	 acctgDt   =  null;
	/*	Column Info	*/
	private  String	 invCurrCd   =  null;
	/*	Column Info	*/
	private  String	 sysToday   =  null;
	/*	Column Info	*/
	private  String	 ofcCd   =  null;
	/*	Column Info	*/
	private  String	 apApstsCd   =  null;
	/*	Column Info	*/
	private  String	 apCntCd   =  null;
	/*	Column Info	*/
	private  String	 payMzdLuCd   =  null;
	/*	Column Info	*/
	private  String	 apInvSrcCd   =  null;
	/*	Column Info	*/
	private  String	 zipCd   =  null;
	/*	Column Info	*/
	private  String	 payFuncAmt   =  null;
	/*	Column Info	*/
	private  String	 effYrmon   =  null;
	/*	Column Info	*/
	private  String	 invPayStsFlg   =  null;
	/*	Column Info	*/
	private  String	 payStsFlg   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new HashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new HashMap<String, String>();
 
 
	/**	Constructor	*/
	public APIFPaymentCSRInfoListVO(){}

	public APIFPaymentCSRInfoListVO(String xchRtTpCd,String payXchDt,String paySkdNo,String payAddr2,String attrCtnt13,String payAddr1,String invSeq,String acctgPstFlg,String payBatRunSeq,String pagerows,String vndrNm,String ibflag,String vndrNo,String usrId,String payAmt,String apCtyCd,String liabCdCmbSeq,String payDesc,String payXchRt,String csrNo,String invPayCurrCd,String payStsLuCd,String xterBankAcctSeq,String acctgDt,String invCurrCd,String sysToday,String ofcCd,String apApstsCd,String apCntCd,String payMzdLuCd,String apInvSrcCd,String zipCd,String payFuncAmt,String effYrmon,String invPayStsFlg,String payStsFlg)	{
		this.xchRtTpCd  = xchRtTpCd ;
		this.payXchDt  = payXchDt ;
		this.paySkdNo  = paySkdNo ;
		this.payAddr2  = payAddr2 ;
		this.attrCtnt13  = attrCtnt13 ;
		this.payAddr1  = payAddr1 ;
		this.invSeq  = invSeq ;
		this.acctgPstFlg  = acctgPstFlg ;
		this.payBatRunSeq  = payBatRunSeq ;
		this.pagerows  = pagerows ;
		this.vndrNm  = vndrNm ;
		this.ibflag  = ibflag ;
		this.vndrNo  = vndrNo ;
		this.usrId  = usrId ;
		this.payAmt  = payAmt ;
		this.apCtyCd  = apCtyCd ;
		this.liabCdCmbSeq  = liabCdCmbSeq ;
		this.payDesc  = payDesc ;
		this.payXchRt  = payXchRt ;
		this.csrNo  = csrNo ;
		this.invPayCurrCd  = invPayCurrCd ;
		this.payStsLuCd  = payStsLuCd ;
		this.xterBankAcctSeq  = xterBankAcctSeq ;
		this.acctgDt  = acctgDt ;
		this.invCurrCd  = invCurrCd ;
		this.sysToday  = sysToday ;
		this.ofcCd  = ofcCd ;
		this.apApstsCd  = apApstsCd ;
		this.apCntCd  = apCntCd ;
		this.payMzdLuCd  = payMzdLuCd ;
		this.apInvSrcCd  = apInvSrcCd ;
		this.zipCd  = zipCd ;
		this.payFuncAmt  = payFuncAmt ;
		this.effYrmon  = effYrmon ;
		this.invPayStsFlg  = invPayStsFlg ;
		this.payStsFlg  = payStsFlg ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("xch_rt_tp_cd", getXchRtTpCd());		
		this.hashColumns.put("pay_xch_dt", getPayXchDt());		
		this.hashColumns.put("pay_skd_no", getPaySkdNo());		
		this.hashColumns.put("pay_addr2", getPayAddr2());		
		this.hashColumns.put("attr_ctnt13", getAttrCtnt13());		
		this.hashColumns.put("pay_addr1", getPayAddr1());		
		this.hashColumns.put("inv_seq", getInvSeq());		
		this.hashColumns.put("acctg_pst_flg", getAcctgPstFlg());		
		this.hashColumns.put("pay_bat_run_seq", getPayBatRunSeq());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("vndr_nm", getVndrNm());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("vndr_no", getVndrNo());		
		this.hashColumns.put("usr_id", getUsrId());		
		this.hashColumns.put("pay_amt", getPayAmt());		
		this.hashColumns.put("ap_cty_cd", getApCtyCd());		
		this.hashColumns.put("liab_cd_cmb_seq", getLiabCdCmbSeq());		
		this.hashColumns.put("pay_desc", getPayDesc());		
		this.hashColumns.put("pay_xch_rt", getPayXchRt());		
		this.hashColumns.put("csr_no", getCsrNo());		
		this.hashColumns.put("inv_pay_curr_cd", getInvPayCurrCd());		
		this.hashColumns.put("pay_sts_lu_cd", getPayStsLuCd());		
		this.hashColumns.put("xter_bank_acct_seq", getXterBankAcctSeq());		
		this.hashColumns.put("acctg_dt", getAcctgDt());		
		this.hashColumns.put("inv_curr_cd", getInvCurrCd());		
		this.hashColumns.put("sys_today", getSysToday());		
		this.hashColumns.put("ofc_cd", getOfcCd());		
		this.hashColumns.put("ap_apsts_cd", getApApstsCd());		
		this.hashColumns.put("ap_cnt_cd", getApCntCd());		
		this.hashColumns.put("pay_mzd_lu_cd", getPayMzdLuCd());		
		this.hashColumns.put("ap_inv_src_cd", getApInvSrcCd());		
		this.hashColumns.put("zip_cd", getZipCd());		
		this.hashColumns.put("pay_func_amt", getPayFuncAmt());		
		this.hashColumns.put("eff_yrmon", getEffYrmon());		
		this.hashColumns.put("inv_pay_sts_flg", getInvPayStsFlg());		
		this.hashColumns.put("pay_sts_flg", getPayStsFlg());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("xch_rt_tp_cd", "xchRtTpCd");
		this.hashFields.put("pay_xch_dt", "payXchDt");
		this.hashFields.put("pay_skd_no", "paySkdNo");
		this.hashFields.put("pay_addr2", "payAddr2");
		this.hashFields.put("attr_ctnt13", "attrCtnt13");
		this.hashFields.put("pay_addr1", "payAddr1");
		this.hashFields.put("inv_seq", "invSeq");
		this.hashFields.put("acctg_pst_flg", "acctgPstFlg");
		this.hashFields.put("pay_bat_run_seq", "payBatRunSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vndr_nm", "vndrNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vndr_no", "vndrNo");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("pay_amt", "payAmt");
		this.hashFields.put("ap_cty_cd", "apCtyCd");
		this.hashFields.put("liab_cd_cmb_seq", "liabCdCmbSeq");
		this.hashFields.put("pay_desc", "payDesc");
		this.hashFields.put("pay_xch_rt", "payXchRt");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("inv_pay_curr_cd", "invPayCurrCd");
		this.hashFields.put("pay_sts_lu_cd", "payStsLuCd");
		this.hashFields.put("xter_bank_acct_seq", "xterBankAcctSeq");
		this.hashFields.put("acctg_dt", "acctgDt");
		this.hashFields.put("inv_curr_cd", "invCurrCd");
		this.hashFields.put("sys_today", "sysToday");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ap_apsts_cd", "apApstsCd");
		this.hashFields.put("ap_cnt_cd", "apCntCd");
		this.hashFields.put("pay_mzd_lu_cd", "payMzdLuCd");
		this.hashFields.put("ap_inv_src_cd", "apInvSrcCd");
		this.hashFields.put("zip_cd", "zipCd");
		this.hashFields.put("pay_func_amt", "payFuncAmt");
		this.hashFields.put("eff_yrmon", "effYrmon");
		this.hashFields.put("inv_pay_sts_flg", "invPayStsFlg");
		this.hashFields.put("pay_sts_flg", "payStsFlg");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  xchRtTpCd
	*/
	public void	setXchRtTpCd( String	xchRtTpCd ) {
		this.xchRtTpCd =	xchRtTpCd;
	}
 
	/**
	 * Column Info
	 * @return	xchRtTpCd
	 */
	 public	String	getXchRtTpCd() {
		 return	this.xchRtTpCd;
	 } 
 	/**
	* Column Info
	* @param  payXchDt
	*/
	public void	setPayXchDt( String	payXchDt ) {
		this.payXchDt =	payXchDt;
	}
 
	/**
	 * Column Info
	 * @return	payXchDt
	 */
	 public	String	getPayXchDt() {
		 return	this.payXchDt;
	 } 
 	/**
	* Column Info
	* @param  paySkdNo
	*/
	public void	setPaySkdNo( String	paySkdNo ) {
		this.paySkdNo =	paySkdNo;
	}
 
	/**
	 * Column Info
	 * @return	paySkdNo
	 */
	 public	String	getPaySkdNo() {
		 return	this.paySkdNo;
	 } 
 	/**
	* Column Info
	* @param  payAddr2
	*/
	public void	setPayAddr2( String	payAddr2 ) {
		this.payAddr2 =	payAddr2;
	}
 
	/**
	 * Column Info
	 * @return	payAddr2
	 */
	 public	String	getPayAddr2() {
		 return	this.payAddr2;
	 } 
 	/**
	* Column Info
	* @param  attrCtnt13
	*/
	public void	setAttrCtnt13( String	attrCtnt13 ) {
		this.attrCtnt13 =	attrCtnt13;
	}
 
	/**
	 * Column Info
	 * @return	attrCtnt13
	 */
	 public	String	getAttrCtnt13() {
		 return	this.attrCtnt13;
	 } 
 	/**
	* Column Info
	* @param  payAddr1
	*/
	public void	setPayAddr1( String	payAddr1 ) {
		this.payAddr1 =	payAddr1;
	}
 
	/**
	 * Column Info
	 * @return	payAddr1
	 */
	 public	String	getPayAddr1() {
		 return	this.payAddr1;
	 } 
 	/**
	* Column Info
	* @param  invSeq
	*/
	public void	setInvSeq( String	invSeq ) {
		this.invSeq =	invSeq;
	}
 
	/**
	 * Column Info
	 * @return	invSeq
	 */
	 public	String	getInvSeq() {
		 return	this.invSeq;
	 } 
 	/**
	* Column Info
	* @param  acctgPstFlg
	*/
	public void	setAcctgPstFlg( String	acctgPstFlg ) {
		this.acctgPstFlg =	acctgPstFlg;
	}
 
	/**
	 * Column Info
	 * @return	acctgPstFlg
	 */
	 public	String	getAcctgPstFlg() {
		 return	this.acctgPstFlg;
	 } 
 	/**
	* Column Info
	* @param  payBatRunSeq
	*/
	public void	setPayBatRunSeq( String	payBatRunSeq ) {
		this.payBatRunSeq =	payBatRunSeq;
	}
 
	/**
	 * Column Info
	 * @return	payBatRunSeq
	 */
	 public	String	getPayBatRunSeq() {
		 return	this.payBatRunSeq;
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
	 public	String	getPagerows() {
		 return	this.pagerows;
	 } 
 	/**
	* Column Info
	* @param  vndrNm
	*/
	public void	setVndrNm( String	vndrNm ) {
		this.vndrNm =	vndrNm;
	}
 
	/**
	 * Column Info
	 * @return	vndrNm
	 */
	 public	String	getVndrNm() {
		 return	this.vndrNm;
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
	 public	String	getIbflag() {
		 return	this.ibflag;
	 } 
 	/**
	* Column Info
	* @param  vndrNo
	*/
	public void	setVndrNo( String	vndrNo ) {
		this.vndrNo =	vndrNo;
	}
 
	/**
	 * Column Info
	 * @return	vndrNo
	 */
	 public	String	getVndrNo() {
		 return	this.vndrNo;
	 } 
 	/**
	* Column Info
	* @param  usrId
	*/
	public void	setUsrId( String	usrId ) {
		this.usrId =	usrId;
	}
 
	/**
	 * Column Info
	 * @return	usrId
	 */
	 public	String	getUsrId() {
		 return	this.usrId;
	 } 
 	/**
	* Column Info
	* @param  payAmt
	*/
	public void	setPayAmt( String	payAmt ) {
		this.payAmt =	payAmt;
	}
 
	/**
	 * Column Info
	 * @return	payAmt
	 */
	 public	String	getPayAmt() {
		 return	this.payAmt;
	 } 
 	/**
	* Column Info
	* @param  apCtyCd
	*/
	public void	setApCtyCd( String	apCtyCd ) {
		this.apCtyCd =	apCtyCd;
	}
 
	/**
	 * Column Info
	 * @return	apCtyCd
	 */
	 public	String	getApCtyCd() {
		 return	this.apCtyCd;
	 } 
 	/**
	* Column Info
	* @param  liabCdCmbSeq
	*/
	public void	setLiabCdCmbSeq( String	liabCdCmbSeq ) {
		this.liabCdCmbSeq =	liabCdCmbSeq;
	}
 
	/**
	 * Column Info
	 * @return	liabCdCmbSeq
	 */
	 public	String	getLiabCdCmbSeq() {
		 return	this.liabCdCmbSeq;
	 } 
 	/**
	* Column Info
	* @param  payDesc
	*/
	public void	setPayDesc( String	payDesc ) {
		this.payDesc =	payDesc;
	}
 
	/**
	 * Column Info
	 * @return	payDesc
	 */
	 public	String	getPayDesc() {
		 return	this.payDesc;
	 } 
 	/**
	* Column Info
	* @param  payXchRt
	*/
	public void	setPayXchRt( String	payXchRt ) {
		this.payXchRt =	payXchRt;
	}
 
	/**
	 * Column Info
	 * @return	payXchRt
	 */
	 public	String	getPayXchRt() {
		 return	this.payXchRt;
	 } 
 	/**
	* Column Info
	* @param  csrNo
	*/
	public void	setCsrNo( String	csrNo ) {
		this.csrNo =	csrNo;
	}
 
	/**
	 * Column Info
	 * @return	csrNo
	 */
	 public	String	getCsrNo() {
		 return	this.csrNo;
	 } 
 	/**
	* Column Info
	* @param  invPayCurrCd
	*/
	public void	setInvPayCurrCd( String	invPayCurrCd ) {
		this.invPayCurrCd =	invPayCurrCd;
	}
 
	/**
	 * Column Info
	 * @return	invPayCurrCd
	 */
	 public	String	getInvPayCurrCd() {
		 return	this.invPayCurrCd;
	 } 
 	/**
	* Column Info
	* @param  payStsLuCd
	*/
	public void	setPayStsLuCd( String	payStsLuCd ) {
		this.payStsLuCd =	payStsLuCd;
	}
 
	/**
	 * Column Info
	 * @return	payStsLuCd
	 */
	 public	String	getPayStsLuCd() {
		 return	this.payStsLuCd;
	 } 
 	/**
	* Column Info
	* @param  xterBankAcctSeq
	*/
	public void	setXterBankAcctSeq( String	xterBankAcctSeq ) {
		this.xterBankAcctSeq =	xterBankAcctSeq;
	}
 
	/**
	 * Column Info
	 * @return	xterBankAcctSeq
	 */
	 public	String	getXterBankAcctSeq() {
		 return	this.xterBankAcctSeq;
	 } 
 	/**
	* Column Info
	* @param  acctgDt
	*/
	public void	setAcctgDt( String	acctgDt ) {
		this.acctgDt =	acctgDt;
	}
 
	/**
	 * Column Info
	 * @return	acctgDt
	 */
	 public	String	getAcctgDt() {
		 return	this.acctgDt;
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
	 public	String	getInvCurrCd() {
		 return	this.invCurrCd;
	 } 
 	/**
	* Column Info
	* @param  sysToday
	*/
	public void	setSysToday( String	sysToday ) {
		this.sysToday =	sysToday;
	}
 
	/**
	 * Column Info
	 * @return	sysToday
	 */
	 public	String	getSysToday() {
		 return	this.sysToday;
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
	 public	String	getOfcCd() {
		 return	this.ofcCd;
	 } 
 	/**
	* Column Info
	* @param  apApstsCd
	*/
	public void	setApApstsCd( String	apApstsCd ) {
		this.apApstsCd =	apApstsCd;
	}
 
	/**
	 * Column Info
	 * @return	apApstsCd
	 */
	 public	String	getApApstsCd() {
		 return	this.apApstsCd;
	 } 
 	/**
	* Column Info
	* @param  apCntCd
	*/
	public void	setApCntCd( String	apCntCd ) {
		this.apCntCd =	apCntCd;
	}
 
	/**
	 * Column Info
	 * @return	apCntCd
	 */
	 public	String	getApCntCd() {
		 return	this.apCntCd;
	 } 
 	/**
	* Column Info
	* @param  payMzdLuCd
	*/
	public void	setPayMzdLuCd( String	payMzdLuCd ) {
		this.payMzdLuCd =	payMzdLuCd;
	}
 
	/**
	 * Column Info
	 * @return	payMzdLuCd
	 */
	 public	String	getPayMzdLuCd() {
		 return	this.payMzdLuCd;
	 } 
 	/**
	* Column Info
	* @param  apInvSrcCd
	*/
	public void	setApInvSrcCd( String	apInvSrcCd ) {
		this.apInvSrcCd =	apInvSrcCd;
	}
 
	/**
	 * Column Info
	 * @return	apInvSrcCd
	 */
	 public	String	getApInvSrcCd() {
		 return	this.apInvSrcCd;
	 } 
 	/**
	* Column Info
	* @param  zipCd
	*/
	public void	setZipCd( String	zipCd ) {
		this.zipCd =	zipCd;
	}
 
	/**
	 * Column Info
	 * @return	zipCd
	 */
	 public	String	getZipCd() {
		 return	this.zipCd;
	 } 
 	/**
	* Column Info
	* @param  payFuncAmt
	*/
	public void	setPayFuncAmt( String	payFuncAmt ) {
		this.payFuncAmt =	payFuncAmt;
	}
 
	/**
	 * Column Info
	 * @return	payFuncAmt
	 */
	 public	String	getPayFuncAmt() {
		 return	this.payFuncAmt;
	 } 
 	/**
	* Column Info
	* @param  effYrmon
	*/
	public void	setEffYrmon( String	effYrmon ) {
		this.effYrmon =	effYrmon;
	}
 
	/**
	 * Column Info
	 * @return	effYrmon
	 */
	 public	String	getEffYrmon() {
		 return	this.effYrmon;
	 } 
 	/**
	* Column Info
	* @param  invPayStsFlg
	*/
	public void	setInvPayStsFlg( String	invPayStsFlg ) {
		this.invPayStsFlg =	invPayStsFlg;
	}
 
	/**
	 * Column Info
	 * @return	invPayStsFlg
	 */
	 public	String	getInvPayStsFlg() {
		 return	this.invPayStsFlg;
	 } 
 	/**
	* Column Info
	* @param  payStsFlg
	*/
	public void	setPayStsFlg( String	payStsFlg ) {
		this.payStsFlg =	payStsFlg;
	}
 
	/**
	 * Column Info
	 * @return	payStsFlg
	 */
	 public	String	getPayStsFlg() {
		 return	this.payStsFlg;
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
		setXchRtTpCd(JSPUtil.getParameter(request,	prefix + "xch_rt_tp_cd", ""));
		setPayXchDt(JSPUtil.getParameter(request,	prefix + "pay_xch_dt", ""));
		setPaySkdNo(JSPUtil.getParameter(request,	prefix + "pay_skd_no", ""));
		setPayAddr2(JSPUtil.getParameter(request,	prefix + "pay_addr2", ""));
		setAttrCtnt13(JSPUtil.getParameter(request,	prefix + "attr_ctnt13", ""));
		setPayAddr1(JSPUtil.getParameter(request,	prefix + "pay_addr1", ""));
		setInvSeq(JSPUtil.getParameter(request,	prefix + "inv_seq", ""));
		setAcctgPstFlg(JSPUtil.getParameter(request,	prefix + "acctg_pst_flg", ""));
		setPayBatRunSeq(JSPUtil.getParameter(request,	prefix + "pay_bat_run_seq", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setVndrNm(JSPUtil.getParameter(request,	prefix + "vndr_nm", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setVndrNo(JSPUtil.getParameter(request,	prefix + "vndr_no", ""));
		setUsrId(JSPUtil.getParameter(request,	prefix + "usr_id", ""));
		setPayAmt(JSPUtil.getParameter(request,	prefix + "pay_amt", ""));
		setApCtyCd(JSPUtil.getParameter(request,	prefix + "ap_cty_cd", ""));
		setLiabCdCmbSeq(JSPUtil.getParameter(request,	prefix + "liab_cd_cmb_seq", ""));
		setPayDesc(JSPUtil.getParameter(request,	prefix + "pay_desc", ""));
		setPayXchRt(JSPUtil.getParameter(request,	prefix + "pay_xch_rt", ""));
		setCsrNo(JSPUtil.getParameter(request,	prefix + "csr_no", ""));
		setInvPayCurrCd(JSPUtil.getParameter(request,	prefix + "inv_pay_curr_cd", ""));
		setPayStsLuCd(JSPUtil.getParameter(request,	prefix + "pay_sts_lu_cd", ""));
		setXterBankAcctSeq(JSPUtil.getParameter(request,	prefix + "xter_bank_acct_seq", ""));
		setAcctgDt(JSPUtil.getParameter(request,	prefix + "acctg_dt", ""));
		setInvCurrCd(JSPUtil.getParameter(request,	prefix + "inv_curr_cd", ""));
		setSysToday(JSPUtil.getParameter(request,	prefix + "sys_today", ""));
		setOfcCd(JSPUtil.getParameter(request,	prefix + "ofc_cd", ""));
		setApApstsCd(JSPUtil.getParameter(request,	prefix + "ap_apsts_cd", ""));
		setApCntCd(JSPUtil.getParameter(request,	prefix + "ap_cnt_cd", ""));
		setPayMzdLuCd(JSPUtil.getParameter(request,	prefix + "pay_mzd_lu_cd", ""));
		setApInvSrcCd(JSPUtil.getParameter(request,	prefix + "ap_inv_src_cd", ""));
		setZipCd(JSPUtil.getParameter(request,	prefix + "zip_cd", ""));
		setPayFuncAmt(JSPUtil.getParameter(request,	prefix + "pay_func_amt", ""));
		setEffYrmon(JSPUtil.getParameter(request,	prefix + "eff_yrmon", ""));
		setInvPayStsFlg(JSPUtil.getParameter(request,	prefix + "inv_pay_sts_flg", ""));
		setPayStsFlg(JSPUtil.getParameter(request,	prefix + "pay_sts_flg", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return APIFPaymentCSRInfoListVO[]
	 */
	public APIFPaymentCSRInfoListVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return APIFPaymentCSRInfoListVO[]
	 */
	public APIFPaymentCSRInfoListVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		APIFPaymentCSRInfoListVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] xchRtTpCd =	(JSPUtil.getParameter(request, prefix +	"xch_rt_tp_cd".trim(),	length));
				String[] payXchDt =	(JSPUtil.getParameter(request, prefix +	"pay_xch_dt".trim(),	length));
				String[] paySkdNo =	(JSPUtil.getParameter(request, prefix +	"pay_skd_no".trim(),	length));
				String[] payAddr2 =	(JSPUtil.getParameter(request, prefix +	"pay_addr2".trim(),	length));
				String[] attrCtnt13 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt13".trim(),	length));
				String[] payAddr1 =	(JSPUtil.getParameter(request, prefix +	"pay_addr1".trim(),	length));
				String[] invSeq =	(JSPUtil.getParameter(request, prefix +	"inv_seq".trim(),	length));
				String[] acctgPstFlg =	(JSPUtil.getParameter(request, prefix +	"acctg_pst_flg".trim(),	length));
				String[] payBatRunSeq =	(JSPUtil.getParameter(request, prefix +	"pay_bat_run_seq".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] vndrNm =	(JSPUtil.getParameter(request, prefix +	"vndr_nm".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] vndrNo =	(JSPUtil.getParameter(request, prefix +	"vndr_no".trim(),	length));
				String[] usrId =	(JSPUtil.getParameter(request, prefix +	"usr_id".trim(),	length));
				String[] payAmt =	(JSPUtil.getParameter(request, prefix +	"pay_amt".trim(),	length));
				String[] apCtyCd =	(JSPUtil.getParameter(request, prefix +	"ap_cty_cd".trim(),	length));
				String[] liabCdCmbSeq =	(JSPUtil.getParameter(request, prefix +	"liab_cd_cmb_seq".trim(),	length));
				String[] payDesc =	(JSPUtil.getParameter(request, prefix +	"pay_desc".trim(),	length));
				String[] payXchRt =	(JSPUtil.getParameter(request, prefix +	"pay_xch_rt".trim(),	length));
				String[] csrNo =	(JSPUtil.getParameter(request, prefix +	"csr_no".trim(),	length));
				String[] invPayCurrCd =	(JSPUtil.getParameter(request, prefix +	"inv_pay_curr_cd".trim(),	length));
				String[] payStsLuCd =	(JSPUtil.getParameter(request, prefix +	"pay_sts_lu_cd".trim(),	length));
				String[] xterBankAcctSeq =	(JSPUtil.getParameter(request, prefix +	"xter_bank_acct_seq".trim(),	length));
				String[] acctgDt =	(JSPUtil.getParameter(request, prefix +	"acctg_dt".trim(),	length));
				String[] invCurrCd =	(JSPUtil.getParameter(request, prefix +	"inv_curr_cd".trim(),	length));
				String[] sysToday =	(JSPUtil.getParameter(request, prefix +	"sys_today".trim(),	length));
				String[] ofcCd =	(JSPUtil.getParameter(request, prefix +	"ofc_cd".trim(),	length));
				String[] apApstsCd =	(JSPUtil.getParameter(request, prefix +	"ap_apsts_cd".trim(),	length));
				String[] apCntCd =	(JSPUtil.getParameter(request, prefix +	"ap_cnt_cd".trim(),	length));
				String[] payMzdLuCd =	(JSPUtil.getParameter(request, prefix +	"pay_mzd_lu_cd".trim(),	length));
				String[] apInvSrcCd =	(JSPUtil.getParameter(request, prefix +	"ap_inv_src_cd".trim(),	length));
				String[] zipCd =	(JSPUtil.getParameter(request, prefix +	"zip_cd".trim(),	length));
				String[] payFuncAmt =	(JSPUtil.getParameter(request, prefix +	"pay_func_amt".trim(),	length));
				String[] effYrmon =	(JSPUtil.getParameter(request, prefix +	"eff_yrmon".trim(),	length));
				String[] invPayStsFlg =	(JSPUtil.getParameter(request, prefix +	"inv_pay_sts_flg".trim(),	length));
				String[] payStsFlg =	(JSPUtil.getParameter(request, prefix +	"pay_sts_flg".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	APIFPaymentCSRInfoListVO();
						if ( xchRtTpCd[i] !=	null)
						model.setXchRtTpCd( xchRtTpCd[i]);
						if ( payXchDt[i] !=	null)
						model.setPayXchDt( payXchDt[i]);
						if ( paySkdNo[i] !=	null)
						model.setPaySkdNo( paySkdNo[i]);
						if ( payAddr2[i] !=	null)
						model.setPayAddr2( payAddr2[i]);
						if ( attrCtnt13[i] !=	null)
						model.setAttrCtnt13( attrCtnt13[i]);
						if ( payAddr1[i] !=	null)
						model.setPayAddr1( payAddr1[i]);
						if ( invSeq[i] !=	null)
						model.setInvSeq( invSeq[i]);
						if ( acctgPstFlg[i] !=	null)
						model.setAcctgPstFlg( acctgPstFlg[i]);
						if ( payBatRunSeq[i] !=	null)
						model.setPayBatRunSeq( payBatRunSeq[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( vndrNm[i] !=	null)
						model.setVndrNm( vndrNm[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( vndrNo[i] !=	null)
						model.setVndrNo( vndrNo[i]);
						if ( usrId[i] !=	null)
						model.setUsrId( usrId[i]);
						if ( payAmt[i] !=	null)
						model.setPayAmt( payAmt[i]);
						if ( apCtyCd[i] !=	null)
						model.setApCtyCd( apCtyCd[i]);
						if ( liabCdCmbSeq[i] !=	null)
						model.setLiabCdCmbSeq( liabCdCmbSeq[i]);
						if ( payDesc[i] !=	null)
						model.setPayDesc( payDesc[i]);
						if ( payXchRt[i] !=	null)
						model.setPayXchRt( payXchRt[i]);
						if ( csrNo[i] !=	null)
						model.setCsrNo( csrNo[i]);
						if ( invPayCurrCd[i] !=	null)
						model.setInvPayCurrCd( invPayCurrCd[i]);
						if ( payStsLuCd[i] !=	null)
						model.setPayStsLuCd( payStsLuCd[i]);
						if ( xterBankAcctSeq[i] !=	null)
						model.setXterBankAcctSeq( xterBankAcctSeq[i]);
						if ( acctgDt[i] !=	null)
						model.setAcctgDt( acctgDt[i]);
						if ( invCurrCd[i] !=	null)
						model.setInvCurrCd( invCurrCd[i]);
						if ( sysToday[i] !=	null)
						model.setSysToday( sysToday[i]);
						if ( ofcCd[i] !=	null)
						model.setOfcCd( ofcCd[i]);
						if ( apApstsCd[i] !=	null)
						model.setApApstsCd( apApstsCd[i]);
						if ( apCntCd[i] !=	null)
						model.setApCntCd( apCntCd[i]);
						if ( payMzdLuCd[i] !=	null)
						model.setPayMzdLuCd( payMzdLuCd[i]);
						if ( apInvSrcCd[i] !=	null)
						model.setApInvSrcCd( apInvSrcCd[i]);
						if ( zipCd[i] !=	null)
						model.setZipCd( zipCd[i]);
						if ( payFuncAmt[i] !=	null)
						model.setPayFuncAmt( payFuncAmt[i]);
						if ( effYrmon[i] !=	null)
						model.setEffYrmon( effYrmon[i]);
						if ( invPayStsFlg[i] !=	null)
						model.setInvPayStsFlg( invPayStsFlg[i]);
						if ( payStsFlg[i] !=	null)
						model.setPayStsFlg( payStsFlg[i]);
					models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getAPIFPaymentCSRInfoListVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return APIFPaymentCSRInfoListVO[]
	 */
	public APIFPaymentCSRInfoListVO[]	 getAPIFPaymentCSRInfoListVOs(){
		APIFPaymentCSRInfoListVO[] vos = (APIFPaymentCSRInfoListVO[])models.toArray(new	APIFPaymentCSRInfoListVO[models.size()]);
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
	public void	unDataFormat(){
		this.xchRtTpCd =	this.xchRtTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payXchDt =	this.payXchDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paySkdNo =	this.paySkdNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payAddr2 =	this.payAddr2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt13 =	this.attrCtnt13.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payAddr1 =	this.payAddr1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSeq =	this.invSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctgPstFlg =	this.acctgPstFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payBatRunSeq =	this.payBatRunSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNm =	this.vndrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNo =	this.vndrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId =	this.usrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payAmt =	this.payAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apCtyCd =	this.apCtyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.liabCdCmbSeq =	this.liabCdCmbSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payDesc =	this.payDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payXchRt =	this.payXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo =	this.csrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invPayCurrCd =	this.invPayCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payStsLuCd =	this.payStsLuCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterBankAcctSeq =	this.xterBankAcctSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctgDt =	this.acctgDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCurrCd =	this.invCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sysToday =	this.sysToday.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd =	this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apApstsCd =	this.apApstsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apCntCd =	this.apCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payMzdLuCd =	this.payMzdLuCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apInvSrcCd =	this.apInvSrcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zipCd =	this.zipCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payFuncAmt =	this.payFuncAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effYrmon =	this.effYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invPayStsFlg =	this.invPayStsFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payStsFlg =	this.payStsFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}