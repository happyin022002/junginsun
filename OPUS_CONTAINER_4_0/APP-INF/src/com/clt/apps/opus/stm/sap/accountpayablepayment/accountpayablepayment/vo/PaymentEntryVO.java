/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : PaymentEntryVO.java
 *@FileTitle : PaymentEntryVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.10.06
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2014.10.06  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo;

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
public class PaymentEntryVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<PaymentEntryVO>  models =	new	ArrayList<PaymentEntryVO>();


	/*	Column Info	*/
	private  String	 payDt   =  null;
	/*	Column Info	*/
	private  String	 xchRtTpCd   =  null;
	/*	Column Info	*/
	private  String	 bankAcctNo   =  null;
	/*	Column Info	*/
	private  String	 currCd   =  null;
	/*	Column Info	*/
	private  String	 payXchDt   =  null;
	/*	Column Info	*/
	private  String	 docSeq   =  null;
	/*	Column Info	*/
	private  String	 payCntCd   =  null;
	/*	Column Info	*/
	private  String	 payAddr1   =  null;
	/*	Column Info	*/
	private  String	 ibanNo   =  null;
	/*	Column Info	*/
	private  String	 frDt   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 vndrNm   =  null;
	/*	Column Info	*/
	private  String	 vndrNo   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 payNo   =  null;
	/*	Column Info	*/
	private  String	 usrId   =  null;
	/*	Column Info	*/
	private  String	 payAmt   =  null;
	/*	Column Info	*/
	private  String	 bankAcctNm   =  null;
	/*	Column Info	*/
	private  String	 periodChk   =  null;
	/*	Column Info	*/
	private  String	 payTpCd   =  null;
	/*	Column Info	*/
	private  String	 payXchRt   =  null;
	/*	Column Info	*/
	private  String	 vndrPayGrpCd   =  null;
	/*	Column Info	*/
	private  String	 bankAcctSeq   =  null;
	/*	Column Info	*/
	private  String	 xterBankAcctSeq   =  null;
	/*	Column Info	*/
	private  String	 paySeq   =  null;
	/*	Column Info	*/
	private  String	 paySteNm   =  null;
	/*	Column Info	*/
	private  String	 payBatNm   =  null;
	/*	Column Info	*/
	private  String	 toDt   =  null;
	/*	Column Info	*/
	private  String	 payCurrPrcs   =  null;
	/*	Column Info	*/
	private  String	 ofcCd   =  null;
	/*	Column Info	*/
	private  String	 chkFlg   =  null;
	/*	Column Info	*/
	private  String	 payMzdLuCd   =  null;
	/*	Column Info	*/
	private  String	 payFuncAmt   =  null;
	/*	Column Info	*/
	private  String	 cntAcctgPstFlgY   =  null;
	/*	Column Info	*/
	private  String	 payStsLuCd   =  null;
	/*	Column Info	*/
	private  String	 remitToAcctNo   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public PaymentEntryVO(){}

	public PaymentEntryVO(String payDt,String xchRtTpCd,String bankAcctNo,String currCd,String payXchDt,String docSeq,String payCntCd,String payAddr1,String ibanNo,String frDt,String pagerows,String vndrNm,String vndrNo,String ibflag,String payNo,String usrId,String payAmt,String bankAcctNm,String periodChk,String payTpCd,String payXchRt,String vndrPayGrpCd,String bankAcctSeq,String xterBankAcctSeq,String paySeq,String paySteNm,String payBatNm,String toDt,String payCurrPrcs,String ofcCd,String chkFlg,String payMzdLuCd,String payFuncAmt,String cntAcctgPstFlgY,String payStsLuCd,String remitToAcctNo)	{
		this.payDt  = payDt ;
		this.xchRtTpCd  = xchRtTpCd ;
		this.bankAcctNo  = bankAcctNo ;
		this.currCd  = currCd ;
		this.payXchDt  = payXchDt ;
		this.docSeq  = docSeq ;
		this.payCntCd  = payCntCd ;
		this.payAddr1  = payAddr1 ;
		this.ibanNo  = ibanNo ;
		this.frDt  = frDt ;
		this.pagerows  = pagerows ;
		this.vndrNm  = vndrNm ;
		this.vndrNo  = vndrNo ;
		this.ibflag  = ibflag ;
		this.payNo  = payNo ;
		this.usrId  = usrId ;
		this.payAmt  = payAmt ;
		this.bankAcctNm  = bankAcctNm ;
		this.periodChk  = periodChk ;
		this.payTpCd  = payTpCd ;
		this.payXchRt  = payXchRt ;
		this.vndrPayGrpCd  = vndrPayGrpCd ;
		this.bankAcctSeq  = bankAcctSeq ;
		this.xterBankAcctSeq  = xterBankAcctSeq ;
		this.paySeq  = paySeq ;
		this.paySteNm  = paySteNm ;
		this.payBatNm  = payBatNm ;
		this.toDt  = toDt ;
		this.payCurrPrcs  = payCurrPrcs ;
		this.ofcCd  = ofcCd ;
		this.chkFlg  = chkFlg ;
		this.payMzdLuCd  = payMzdLuCd ;
		this.payFuncAmt  = payFuncAmt ;
		this.cntAcctgPstFlgY  = cntAcctgPstFlgY ;
		this.payStsLuCd  = payStsLuCd ;
		this.remitToAcctNo  = remitToAcctNo ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pay_dt", getPayDt());		
		this.hashColumns.put("xch_rt_tp_cd", getXchRtTpCd());		
		this.hashColumns.put("bank_acct_no", getBankAcctNo());		
		this.hashColumns.put("curr_cd", getCurrCd());		
		this.hashColumns.put("pay_xch_dt", getPayXchDt());		
		this.hashColumns.put("doc_seq", getDocSeq());		
		this.hashColumns.put("pay_cnt_cd", getPayCntCd());		
		this.hashColumns.put("pay_addr1", getPayAddr1());		
		this.hashColumns.put("iban_no", getIbanNo());		
		this.hashColumns.put("fr_dt", getFrDt());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("vndr_nm", getVndrNm());		
		this.hashColumns.put("vndr_no", getVndrNo());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("pay_no", getPayNo());		
		this.hashColumns.put("usr_id", getUsrId());		
		this.hashColumns.put("pay_amt", getPayAmt());		
		this.hashColumns.put("bank_acct_nm", getBankAcctNm());		
		this.hashColumns.put("period_chk", getPeriodChk());		
		this.hashColumns.put("pay_tp_cd", getPayTpCd());		
		this.hashColumns.put("pay_xch_rt", getPayXchRt());		
		this.hashColumns.put("vndr_pay_grp_cd", getVndrPayGrpCd());		
		this.hashColumns.put("bank_acct_seq", getBankAcctSeq());		
		this.hashColumns.put("xter_bank_acct_seq", getXterBankAcctSeq());		
		this.hashColumns.put("pay_seq", getPaySeq());		
		this.hashColumns.put("pay_ste_nm", getPaySteNm());		
		this.hashColumns.put("pay_bat_nm", getPayBatNm());		
		this.hashColumns.put("to_dt", getToDt());		
		this.hashColumns.put("pay_curr_prcs", getPayCurrPrcs());		
		this.hashColumns.put("ofc_cd", getOfcCd());		
		this.hashColumns.put("chk_flg", getChkFlg());		
		this.hashColumns.put("pay_mzd_lu_cd", getPayMzdLuCd());		
		this.hashColumns.put("pay_func_amt", getPayFuncAmt());		
		this.hashColumns.put("cnt_acctg_pst_flg_y", getCntAcctgPstFlgY());		
		this.hashColumns.put("pay_sts_lu_cd", getPayStsLuCd());		
		this.hashColumns.put("remit_to_acct_no", getRemitToAcctNo());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("pay_dt", "payDt");
		this.hashFields.put("xch_rt_tp_cd", "xchRtTpCd");
		this.hashFields.put("bank_acct_no", "bankAcctNo");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("pay_xch_dt", "payXchDt");
		this.hashFields.put("doc_seq", "docSeq");
		this.hashFields.put("pay_cnt_cd", "payCntCd");
		this.hashFields.put("pay_addr1", "payAddr1");
		this.hashFields.put("iban_no", "ibanNo");
		this.hashFields.put("fr_dt", "frDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vndr_nm", "vndrNm");
		this.hashFields.put("vndr_no", "vndrNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pay_no", "payNo");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("pay_amt", "payAmt");
		this.hashFields.put("bank_acct_nm", "bankAcctNm");
		this.hashFields.put("period_chk", "periodChk");
		this.hashFields.put("pay_tp_cd", "payTpCd");
		this.hashFields.put("pay_xch_rt", "payXchRt");
		this.hashFields.put("vndr_pay_grp_cd", "vndrPayGrpCd");
		this.hashFields.put("bank_acct_seq", "bankAcctSeq");
		this.hashFields.put("xter_bank_acct_seq", "xterBankAcctSeq");
		this.hashFields.put("pay_seq", "paySeq");
		this.hashFields.put("pay_ste_nm", "paySteNm");
		this.hashFields.put("pay_bat_nm", "payBatNm");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("pay_curr_prcs", "payCurrPrcs");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("chk_flg", "chkFlg");
		this.hashFields.put("pay_mzd_lu_cd", "payMzdLuCd");
		this.hashFields.put("pay_func_amt", "payFuncAmt");
		this.hashFields.put("cnt_acctg_pst_flg_y", "cntAcctgPstFlgY");
		this.hashFields.put("pay_sts_lu_cd", "payStsLuCd");
		this.hashFields.put("remit_to_acct_no", "remitToAcctNo");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  payDt
	*/
	public void	setPayDt( String	payDt ) {
		this.payDt =	payDt;
	}
 
	/**
	 * Column Info
	 * @return	payDt
	 */
	 public	 String	getPayDt() {
		 return	this.payDt;
	 } 
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
	 public	 String	getXchRtTpCd() {
		 return	this.xchRtTpCd;
	 } 
 	/**
	* Column Info
	* @param  bankAcctNo
	*/
	public void	setBankAcctNo( String	bankAcctNo ) {
		this.bankAcctNo =	bankAcctNo;
	}
 
	/**
	 * Column Info
	 * @return	bankAcctNo
	 */
	 public	 String	getBankAcctNo() {
		 return	this.bankAcctNo;
	 } 
 	/**
	* Column Info
	* @param  currCd
	*/
	public void	setCurrCd( String	currCd ) {
		this.currCd =	currCd;
	}
 
	/**
	 * Column Info
	 * @return	currCd
	 */
	 public	 String	getCurrCd() {
		 return	this.currCd;
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
	 public	 String	getPayXchDt() {
		 return	this.payXchDt;
	 } 
 	/**
	* Column Info
	* @param  docSeq
	*/
	public void	setDocSeq( String	docSeq ) {
		this.docSeq =	docSeq;
	}
 
	/**
	 * Column Info
	 * @return	docSeq
	 */
	 public	 String	getDocSeq() {
		 return	this.docSeq;
	 } 
 	/**
	* Column Info
	* @param  payCntCd
	*/
	public void	setPayCntCd( String	payCntCd ) {
		this.payCntCd =	payCntCd;
	}
 
	/**
	 * Column Info
	 * @return	payCntCd
	 */
	 public	 String	getPayCntCd() {
		 return	this.payCntCd;
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
	 public	 String	getPayAddr1() {
		 return	this.payAddr1;
	 } 
 	/**
	* Column Info
	* @param  ibanNo
	*/
	public void	setIbanNo( String	ibanNo ) {
		this.ibanNo =	ibanNo;
	}
 
	/**
	 * Column Info
	 * @return	ibanNo
	 */
	 public	 String	getIbanNo() {
		 return	this.ibanNo;
	 } 
 	/**
	* Column Info
	* @param  frDt
	*/
	public void	setFrDt( String	frDt ) {
		this.frDt =	frDt;
	}
 
	/**
	 * Column Info
	 * @return	frDt
	 */
	 public	 String	getFrDt() {
		 return	this.frDt;
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
	* @param  vndrNm
	*/
	public void	setVndrNm( String	vndrNm ) {
		this.vndrNm =	vndrNm;
	}
 
	/**
	 * Column Info
	 * @return	vndrNm
	 */
	 public	 String	getVndrNm() {
		 return	this.vndrNm;
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
	 public	 String	getVndrNo() {
		 return	this.vndrNo;
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
	* @param  payNo
	*/
	public void	setPayNo( String	payNo ) {
		this.payNo =	payNo;
	}
 
	/**
	 * Column Info
	 * @return	payNo
	 */
	 public	 String	getPayNo() {
		 return	this.payNo;
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
	 public	 String	getUsrId() {
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
	 public	 String	getPayAmt() {
		 return	this.payAmt;
	 } 
 	/**
	* Column Info
	* @param  bankAcctNm
	*/
	public void	setBankAcctNm( String	bankAcctNm ) {
		this.bankAcctNm =	bankAcctNm;
	}
 
	/**
	 * Column Info
	 * @return	bankAcctNm
	 */
	 public	 String	getBankAcctNm() {
		 return	this.bankAcctNm;
	 } 
 	/**
	* Column Info
	* @param  periodChk
	*/
	public void	setPeriodChk( String	periodChk ) {
		this.periodChk =	periodChk;
	}
 
	/**
	 * Column Info
	 * @return	periodChk
	 */
	 public	 String	getPeriodChk() {
		 return	this.periodChk;
	 } 
 	/**
	* Column Info
	* @param  payTpCd
	*/
	public void	setPayTpCd( String	payTpCd ) {
		this.payTpCd =	payTpCd;
	}
 
	/**
	 * Column Info
	 * @return	payTpCd
	 */
	 public	 String	getPayTpCd() {
		 return	this.payTpCd;
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
	 public	 String	getPayXchRt() {
		 return	this.payXchRt;
	 } 
 	/**
	* Column Info
	* @param  vndrPayGrpCd
	*/
	public void	setVndrPayGrpCd( String	vndrPayGrpCd ) {
		this.vndrPayGrpCd =	vndrPayGrpCd;
	}
 
	/**
	 * Column Info
	 * @return	vndrPayGrpCd
	 */
	 public	 String	getVndrPayGrpCd() {
		 return	this.vndrPayGrpCd;
	 } 
 	/**
	* Column Info
	* @param  bankAcctSeq
	*/
	public void	setBankAcctSeq( String	bankAcctSeq ) {
		this.bankAcctSeq =	bankAcctSeq;
	}
 
	/**
	 * Column Info
	 * @return	bankAcctSeq
	 */
	 public	 String	getBankAcctSeq() {
		 return	this.bankAcctSeq;
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
	 public	 String	getXterBankAcctSeq() {
		 return	this.xterBankAcctSeq;
	 } 
 	/**
	* Column Info
	* @param  paySeq
	*/
	public void	setPaySeq( String	paySeq ) {
		this.paySeq =	paySeq;
	}
 
	/**
	 * Column Info
	 * @return	paySeq
	 */
	 public	 String	getPaySeq() {
		 return	this.paySeq;
	 } 
 	/**
	* Column Info
	* @param  paySteNm
	*/
	public void	setPaySteNm( String	paySteNm ) {
		this.paySteNm =	paySteNm;
	}
 
	/**
	 * Column Info
	 * @return	paySteNm
	 */
	 public	 String	getPaySteNm() {
		 return	this.paySteNm;
	 } 
 	/**
	* Column Info
	* @param  payBatNm
	*/
	public void	setPayBatNm( String	payBatNm ) {
		this.payBatNm =	payBatNm;
	}
 
	/**
	 * Column Info
	 * @return	payBatNm
	 */
	 public	 String	getPayBatNm() {
		 return	this.payBatNm;
	 } 
 	/**
	* Column Info
	* @param  toDt
	*/
	public void	setToDt( String	toDt ) {
		this.toDt =	toDt;
	}
 
	/**
	 * Column Info
	 * @return	toDt
	 */
	 public	 String	getToDt() {
		 return	this.toDt;
	 } 
 	/**
	* Column Info
	* @param  payCurrPrcs
	*/
	public void	setPayCurrPrcs( String	payCurrPrcs ) {
		this.payCurrPrcs =	payCurrPrcs;
	}
 
	/**
	 * Column Info
	 * @return	payCurrPrcs
	 */
	 public	 String	getPayCurrPrcs() {
		 return	this.payCurrPrcs;
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
	* @param  chkFlg
	*/
	public void	setChkFlg( String	chkFlg ) {
		this.chkFlg =	chkFlg;
	}
 
	/**
	 * Column Info
	 * @return	chkFlg
	 */
	 public	 String	getChkFlg() {
		 return	this.chkFlg;
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
	 public	 String	getPayMzdLuCd() {
		 return	this.payMzdLuCd;
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
	 public	 String	getPayFuncAmt() {
		 return	this.payFuncAmt;
	 } 
 	/**
	* Column Info
	* @param  cntAcctgPstFlgY
	*/
	public void	setCntAcctgPstFlgY( String	cntAcctgPstFlgY ) {
		this.cntAcctgPstFlgY =	cntAcctgPstFlgY;
	}
 
	/**
	 * Column Info
	 * @return	cntAcctgPstFlgY
	 */
	 public	 String	getCntAcctgPstFlgY() {
		 return	this.cntAcctgPstFlgY;
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
	 public	 String	getPayStsLuCd() {
		 return	this.payStsLuCd;
	 } 
 	/**
	* Column Info
	* @param  remitToAcctNo
	*/
	public void	setRemitToAcctNo( String	remitToAcctNo ) {
		this.remitToAcctNo =	remitToAcctNo;
	}
 
	/**
	 * Column Info
	 * @return	remitToAcctNo
	 */
	 public	 String	getRemitToAcctNo() {
		 return	this.remitToAcctNo;
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
		setPayDt(JSPUtil.getParameter(request,	prefix + "pay_dt", ""));
		setXchRtTpCd(JSPUtil.getParameter(request,	prefix + "xch_rt_tp_cd", ""));
		setBankAcctNo(JSPUtil.getParameter(request,	prefix + "bank_acct_no", ""));
		setCurrCd(JSPUtil.getParameter(request,	prefix + "curr_cd", ""));
		setPayXchDt(JSPUtil.getParameter(request,	prefix + "pay_xch_dt", ""));
		setDocSeq(JSPUtil.getParameter(request,	prefix + "doc_seq", ""));
		setPayCntCd(JSPUtil.getParameter(request,	prefix + "pay_cnt_cd", ""));
		setPayAddr1(JSPUtil.getParameter(request,	prefix + "pay_addr1", ""));
		setIbanNo(JSPUtil.getParameter(request,	prefix + "iban_no", ""));
		setFrDt(JSPUtil.getParameter(request,	prefix + "fr_dt", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setVndrNm(JSPUtil.getParameter(request,	prefix + "vndr_nm", ""));
		setVndrNo(JSPUtil.getParameter(request,	prefix + "vndr_no", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setPayNo(JSPUtil.getParameter(request,	prefix + "pay_no", ""));
		setUsrId(JSPUtil.getParameter(request,	prefix + "usr_id", ""));
		setPayAmt(JSPUtil.getParameter(request,	prefix + "pay_amt", ""));
		setBankAcctNm(JSPUtil.getParameter(request,	prefix + "bank_acct_nm", ""));
		setPeriodChk(JSPUtil.getParameter(request,	prefix + "period_chk", ""));
		setPayTpCd(JSPUtil.getParameter(request,	prefix + "pay_tp_cd", ""));
		setPayXchRt(JSPUtil.getParameter(request,	prefix + "pay_xch_rt", ""));
		setVndrPayGrpCd(JSPUtil.getParameter(request,	prefix + "vndr_pay_grp_cd", ""));
		setBankAcctSeq(JSPUtil.getParameter(request,	prefix + "bank_acct_seq", ""));
		setXterBankAcctSeq(JSPUtil.getParameter(request,	prefix + "xter_bank_acct_seq", ""));
		setPaySeq(JSPUtil.getParameter(request,	prefix + "pay_seq", ""));
		setPaySteNm(JSPUtil.getParameter(request,	prefix + "pay_ste_nm", ""));
		setPayBatNm(JSPUtil.getParameter(request,	prefix + "pay_bat_nm", ""));
		setToDt(JSPUtil.getParameter(request,	prefix + "to_dt", ""));
		setPayCurrPrcs(JSPUtil.getParameter(request,	prefix + "pay_curr_prcs", ""));
		setOfcCd(JSPUtil.getParameter(request,	prefix + "ofc_cd", ""));
		setChkFlg(JSPUtil.getParameter(request,	prefix + "chk_flg", ""));
		setPayMzdLuCd(JSPUtil.getParameter(request,	prefix + "pay_mzd_lu_cd", ""));
		setPayFuncAmt(JSPUtil.getParameter(request,	prefix + "pay_func_amt", ""));
		setCntAcctgPstFlgY(JSPUtil.getParameter(request,	prefix + "cnt_acctg_pst_flg_y", ""));
		setPayStsLuCd(JSPUtil.getParameter(request,	prefix + "pay_sts_lu_cd", ""));
		setRemitToAcctNo(JSPUtil.getParameter(request,	prefix + "remit_to_acct_no", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PaymentEntryVO[]
	 */
	public PaymentEntryVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return PaymentEntryVO[]
	 */
	public PaymentEntryVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		PaymentEntryVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] payDt =	(JSPUtil.getParameter(request, prefix +	"pay_dt".trim(),	length));
				String[] xchRtTpCd =	(JSPUtil.getParameter(request, prefix +	"xch_rt_tp_cd".trim(),	length));
				String[] bankAcctNo =	(JSPUtil.getParameter(request, prefix +	"bank_acct_no".trim(),	length));
				String[] currCd =	(JSPUtil.getParameter(request, prefix +	"curr_cd".trim(),	length));
				String[] payXchDt =	(JSPUtil.getParameter(request, prefix +	"pay_xch_dt".trim(),	length));
				String[] docSeq =	(JSPUtil.getParameter(request, prefix +	"doc_seq".trim(),	length));
				String[] payCntCd =	(JSPUtil.getParameter(request, prefix +	"pay_cnt_cd".trim(),	length));
				String[] payAddr1 =	(JSPUtil.getParameter(request, prefix +	"pay_addr1".trim(),	length));
				String[] ibanNo =	(JSPUtil.getParameter(request, prefix +	"iban_no".trim(),	length));
				String[] frDt =	(JSPUtil.getParameter(request, prefix +	"fr_dt".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] vndrNm =	(JSPUtil.getParameter(request, prefix +	"vndr_nm".trim(),	length));
				String[] vndrNo =	(JSPUtil.getParameter(request, prefix +	"vndr_no".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] payNo =	(JSPUtil.getParameter(request, prefix +	"pay_no".trim(),	length));
				String[] usrId =	(JSPUtil.getParameter(request, prefix +	"usr_id".trim(),	length));
				String[] payAmt =	(JSPUtil.getParameter(request, prefix +	"pay_amt".trim(),	length));
				String[] bankAcctNm =	(JSPUtil.getParameter(request, prefix +	"bank_acct_nm".trim(),	length));
				String[] periodChk =	(JSPUtil.getParameter(request, prefix +	"period_chk".trim(),	length));
				String[] payTpCd =	(JSPUtil.getParameter(request, prefix +	"pay_tp_cd".trim(),	length));
				String[] payXchRt =	(JSPUtil.getParameter(request, prefix +	"pay_xch_rt".trim(),	length));
				String[] vndrPayGrpCd =	(JSPUtil.getParameter(request, prefix +	"vndr_pay_grp_cd".trim(),	length));
				String[] bankAcctSeq =	(JSPUtil.getParameter(request, prefix +	"bank_acct_seq".trim(),	length));
				String[] xterBankAcctSeq =	(JSPUtil.getParameter(request, prefix +	"xter_bank_acct_seq".trim(),	length));
				String[] paySeq =	(JSPUtil.getParameter(request, prefix +	"pay_seq".trim(),	length));
				String[] paySteNm =	(JSPUtil.getParameter(request, prefix +	"pay_ste_nm".trim(),	length));
				String[] payBatNm =	(JSPUtil.getParameter(request, prefix +	"pay_bat_nm".trim(),	length));
				String[] toDt =	(JSPUtil.getParameter(request, prefix +	"to_dt".trim(),	length));
				String[] payCurrPrcs =	(JSPUtil.getParameter(request, prefix +	"pay_curr_prcs".trim(),	length));
				String[] ofcCd =	(JSPUtil.getParameter(request, prefix +	"ofc_cd".trim(),	length));
				String[] chkFlg =	(JSPUtil.getParameter(request, prefix +	"chk_flg".trim(),	length));
				String[] payMzdLuCd =	(JSPUtil.getParameter(request, prefix +	"pay_mzd_lu_cd".trim(),	length));
				String[] payFuncAmt =	(JSPUtil.getParameter(request, prefix +	"pay_func_amt".trim(),	length));
				String[] cntAcctgPstFlgY =	(JSPUtil.getParameter(request, prefix +	"cnt_acctg_pst_flg_y".trim(),	length));
				String[] payStsLuCd =	(JSPUtil.getParameter(request, prefix +	"pay_sts_lu_cd".trim(),	length));
				String[] remitToAcctNo =	(JSPUtil.getParameter(request, prefix +	"remit_to_acct_no".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	PaymentEntryVO();
						if ( payDt[i] !=	null)
						model.setPayDt( payDt[i]);
						if ( xchRtTpCd[i] !=	null)
						model.setXchRtTpCd( xchRtTpCd[i]);
						if ( bankAcctNo[i] !=	null)
						model.setBankAcctNo( bankAcctNo[i]);
						if ( currCd[i] !=	null)
						model.setCurrCd( currCd[i]);
						if ( payXchDt[i] !=	null)
						model.setPayXchDt( payXchDt[i]);
						if ( docSeq[i] !=	null)
						model.setDocSeq( docSeq[i]);
						if ( payCntCd[i] !=	null)
						model.setPayCntCd( payCntCd[i]);
						if ( payAddr1[i] !=	null)
						model.setPayAddr1( payAddr1[i]);
						if ( ibanNo[i] !=	null)
						model.setIbanNo( ibanNo[i]);
						if ( frDt[i] !=	null)
						model.setFrDt( frDt[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( vndrNm[i] !=	null)
						model.setVndrNm( vndrNm[i]);
						if ( vndrNo[i] !=	null)
						model.setVndrNo( vndrNo[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( payNo[i] !=	null)
						model.setPayNo( payNo[i]);
						if ( usrId[i] !=	null)
						model.setUsrId( usrId[i]);
						if ( payAmt[i] !=	null)
						model.setPayAmt( payAmt[i]);
						if ( bankAcctNm[i] !=	null)
						model.setBankAcctNm( bankAcctNm[i]);
						if ( periodChk[i] !=	null)
						model.setPeriodChk( periodChk[i]);
						if ( payTpCd[i] !=	null)
						model.setPayTpCd( payTpCd[i]);
						if ( payXchRt[i] !=	null)
						model.setPayXchRt( payXchRt[i]);
						if ( vndrPayGrpCd[i] !=	null)
						model.setVndrPayGrpCd( vndrPayGrpCd[i]);
						if ( bankAcctSeq[i] !=	null)
						model.setBankAcctSeq( bankAcctSeq[i]);
						if ( xterBankAcctSeq[i] !=	null)
						model.setXterBankAcctSeq( xterBankAcctSeq[i]);
						if ( paySeq[i] !=	null)
						model.setPaySeq( paySeq[i]);
						if ( paySteNm[i] !=	null)
						model.setPaySteNm( paySteNm[i]);
						if ( payBatNm[i] !=	null)
						model.setPayBatNm( payBatNm[i]);
						if ( toDt[i] !=	null)
						model.setToDt( toDt[i]);
						if ( payCurrPrcs[i] !=	null)
						model.setPayCurrPrcs( payCurrPrcs[i]);
						if ( ofcCd[i] !=	null)
						model.setOfcCd( ofcCd[i]);
						if ( chkFlg[i] !=	null)
						model.setChkFlg( chkFlg[i]);
						if ( payMzdLuCd[i] !=	null)
						model.setPayMzdLuCd( payMzdLuCd[i]);
						if ( payFuncAmt[i] !=	null)
						model.setPayFuncAmt( payFuncAmt[i]);
						if ( cntAcctgPstFlgY[i] !=	null)
						model.setCntAcctgPstFlgY( cntAcctgPstFlgY[i]);
						if ( payStsLuCd[i] !=	null)
						model.setPayStsLuCd( payStsLuCd[i]);
						if ( remitToAcctNo[i] !=	null)
						model.setRemitToAcctNo( remitToAcctNo[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getPaymentEntryVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return PaymentEntryVO[]
	 */
	public PaymentEntryVO[]	 getPaymentEntryVOs(){
		PaymentEntryVO[] vos = (PaymentEntryVO[])models.toArray(new	PaymentEntryVO[models.size()]);
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
		this.payDt =	this.payDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRtTpCd =	this.xchRtTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankAcctNo =	this.bankAcctNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd =	this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payXchDt =	this.payXchDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docSeq =	this.docSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payCntCd =	this.payCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payAddr1 =	this.payAddr1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibanNo =	this.ibanNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frDt =	this.frDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNm =	this.vndrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNo =	this.vndrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payNo =	this.payNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId =	this.usrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payAmt =	this.payAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankAcctNm =	this.bankAcctNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.periodChk =	this.periodChk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payTpCd =	this.payTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payXchRt =	this.payXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrPayGrpCd =	this.vndrPayGrpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankAcctSeq =	this.bankAcctSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterBankAcctSeq =	this.xterBankAcctSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paySeq =	this.paySeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paySteNm =	this.paySteNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payBatNm =	this.payBatNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt =	this.toDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payCurrPrcs =	this.payCurrPrcs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd =	this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkFlg =	this.chkFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payMzdLuCd =	this.payMzdLuCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payFuncAmt =	this.payFuncAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntAcctgPstFlgY =	this.cntAcctgPstFlgY.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payStsLuCd =	this.payStsLuCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remitToAcctNo =	this.remitToAcctNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}