/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : PaymentBatchListVO.java
 *@FileTitle : PaymentBatchListVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.05.26
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2014.05.26  
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
public class PaymentBatchListVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<PaymentBatchListVO>  models =	new	ArrayList<PaymentBatchListVO>();


	/*	Column Info	*/
	private  String	 bankAcctNo   =  null;
	/*	Column Info	*/
	private  String	 payDt   =  null;
	/*	Column Info	*/
	private  String	 payThruDt   =  null;
	/*	Column Info	*/
	private  String	 xchRtTpCd   =  null;
	/*	Column Info	*/
	private  String	 payXchDt   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt10   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt14   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt9   =  null;
	/*	Column Info	*/
	private  String	 vndrLglEngNm   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt13   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt8   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt12   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt11   =  null;
	/*	Column Info	*/
	private  String	 ftuDtPayFlg   =  null;
	/*	Column Info	*/
	private  String	 n1stAvalDocNo   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt15   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt1   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt2   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 vndrNo   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt3   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt4   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt5   =  null;
	/*	Column Info	*/
	private  String	 payBatSeq   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt6   =  null;
	/*	Column Info	*/
	private  String	 payOnyDueDtFlg   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt7   =  null;
	/*	Column Info	*/
	private  String	 payStsCd   =  null;
	/*	Column Info	*/
	private  String	 highPayPrioNo   =  null;
	/*	Column Info	*/
	private  String	 lowPayPrioNo   =  null;
	/*	Column Info	*/
	private  String	 payPrdNm   =  null;
	/*	Column Info	*/
	private  String	 zrAmtAlwFlg   =  null;
	/*	Column Info	*/
	private  String	 attrCateNm   =  null;
	/*	Column Info	*/
	private  String	 bankAcctNm   =  null;
	/*	Column Info	*/
	private  String	 periodChk   =  null;
	/*	Column Info	*/
	private  String	 payXchRt   =  null;
	/*	Column Info	*/
	private  String	 vndrPayGrpCd   =  null;
	/*	Column Info	*/
	private  String	 bankAcctSeq   =  null;
	/*	Column Info	*/
	private  String	 stPrnDocNo   =  null;
	/*	Column Info	*/
	private  String	 endPrnDocNo   =  null;
	/*	Column Info	*/
	private  String	 payDocNo   =  null;
	/*	Column Info	*/
	private  String	 payBatNm   =  null;
	/*	Column Info	*/
	private  String	 ofcCd   =  null;
	/*	Column Info	*/
	private  String	 payCurrCd   =  null;
	/*	Column Info	*/
	private  String	 zrInvAlwFlg   =  null;
	/*	Column Info	*/
	private  String	 xchRtTpNm   =  null;
	/*	Column Info	*/
	private  String	 payMzdLuCd   =  null;
	/*	Column Info	*/
	private  String	 usrId   =  null;
	/*	Column Info	*/
	private  String	 chkFlg   =  null;
	/*	Column Info	*/
	private  String	 functionalCurrency   =  null;
	/*	Column Info	*/
	private  String	 updPayStsCd   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new HashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new HashMap<String, String>();
 
 
	/**	Constructor	*/
	public PaymentBatchListVO(){}

	public PaymentBatchListVO(String bankAcctNo,String payDt,String payThruDt,String xchRtTpCd,String payXchDt,String attrCtnt10,String attrCtnt14,String attrCtnt9,String vndrLglEngNm,String attrCtnt13,String attrCtnt8,String attrCtnt12,String attrCtnt11,String ftuDtPayFlg,String n1stAvalDocNo,String attrCtnt15,String pagerows,String attrCtnt1,String attrCtnt2,String ibflag,String vndrNo,String attrCtnt3,String attrCtnt4,String attrCtnt5,String payBatSeq,String attrCtnt6,String payOnyDueDtFlg,String attrCtnt7,String payStsCd,String highPayPrioNo,String lowPayPrioNo,String payPrdNm,String zrAmtAlwFlg,String attrCateNm,String bankAcctNm,String periodChk,String payXchRt,String vndrPayGrpCd,String bankAcctSeq,String stPrnDocNo,String endPrnDocNo,String payDocNo,String payBatNm,String ofcCd,String payCurrCd,String zrInvAlwFlg,String xchRtTpNm,String payMzdLuCd,String usrId,String chkFlg,String functionalCurrency,String updPayStsCd)	{
		this.bankAcctNo  = bankAcctNo ;
		this.payDt  = payDt ;
		this.payThruDt  = payThruDt ;
		this.xchRtTpCd  = xchRtTpCd ;
		this.payXchDt  = payXchDt ;
		this.attrCtnt10  = attrCtnt10 ;
		this.attrCtnt14  = attrCtnt14 ;
		this.attrCtnt9  = attrCtnt9 ;
		this.vndrLglEngNm  = vndrLglEngNm ;
		this.attrCtnt13  = attrCtnt13 ;
		this.attrCtnt8  = attrCtnt8 ;
		this.attrCtnt12  = attrCtnt12 ;
		this.attrCtnt11  = attrCtnt11 ;
		this.ftuDtPayFlg  = ftuDtPayFlg ;
		this.n1stAvalDocNo  = n1stAvalDocNo ;
		this.attrCtnt15  = attrCtnt15 ;
		this.pagerows  = pagerows ;
		this.attrCtnt1  = attrCtnt1 ;
		this.attrCtnt2  = attrCtnt2 ;
		this.ibflag  = ibflag ;
		this.vndrNo  = vndrNo ;
		this.attrCtnt3  = attrCtnt3 ;
		this.attrCtnt4  = attrCtnt4 ;
		this.attrCtnt5  = attrCtnt5 ;
		this.payBatSeq  = payBatSeq ;
		this.attrCtnt6  = attrCtnt6 ;
		this.payOnyDueDtFlg  = payOnyDueDtFlg ;
		this.attrCtnt7  = attrCtnt7 ;
		this.payStsCd  = payStsCd ;
		this.highPayPrioNo  = highPayPrioNo ;
		this.lowPayPrioNo  = lowPayPrioNo ;
		this.payPrdNm  = payPrdNm ;
		this.zrAmtAlwFlg  = zrAmtAlwFlg ;
		this.attrCateNm  = attrCateNm ;
		this.bankAcctNm  = bankAcctNm ;
		this.periodChk  = periodChk ;
		this.payXchRt  = payXchRt ;
		this.vndrPayGrpCd  = vndrPayGrpCd ;
		this.bankAcctSeq  = bankAcctSeq ;
		this.stPrnDocNo  = stPrnDocNo ;
		this.endPrnDocNo  = endPrnDocNo ;
		this.payDocNo  = payDocNo ;
		this.payBatNm  = payBatNm ;
		this.ofcCd  = ofcCd ;
		this.payCurrCd  = payCurrCd ;
		this.zrInvAlwFlg  = zrInvAlwFlg ;
		this.xchRtTpNm  = xchRtTpNm ;
		this.payMzdLuCd  = payMzdLuCd ;
		this.usrId  = usrId ;
		this.chkFlg  = chkFlg ;
		this.functionalCurrency  = functionalCurrency ;
		this.updPayStsCd  = updPayStsCd ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bank_acct_no", getBankAcctNo());		
		this.hashColumns.put("pay_dt", getPayDt());		
		this.hashColumns.put("pay_thru_dt", getPayThruDt());		
		this.hashColumns.put("xch_rt_tp_cd", getXchRtTpCd());		
		this.hashColumns.put("pay_xch_dt", getPayXchDt());		
		this.hashColumns.put("attr_ctnt10", getAttrCtnt10());		
		this.hashColumns.put("attr_ctnt14", getAttrCtnt14());		
		this.hashColumns.put("attr_ctnt9", getAttrCtnt9());		
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());		
		this.hashColumns.put("attr_ctnt13", getAttrCtnt13());		
		this.hashColumns.put("attr_ctnt8", getAttrCtnt8());		
		this.hashColumns.put("attr_ctnt12", getAttrCtnt12());		
		this.hashColumns.put("attr_ctnt11", getAttrCtnt11());		
		this.hashColumns.put("ftu_dt_pay_flg", getFtuDtPayFlg());		
		this.hashColumns.put("n1st_aval_doc_no", getN1stAvalDocNo());		
		this.hashColumns.put("attr_ctnt15", getAttrCtnt15());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("attr_ctnt1", getAttrCtnt1());		
		this.hashColumns.put("attr_ctnt2", getAttrCtnt2());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("vndr_no", getVndrNo());		
		this.hashColumns.put("attr_ctnt3", getAttrCtnt3());		
		this.hashColumns.put("attr_ctnt4", getAttrCtnt4());		
		this.hashColumns.put("attr_ctnt5", getAttrCtnt5());		
		this.hashColumns.put("pay_bat_seq", getPayBatSeq());		
		this.hashColumns.put("attr_ctnt6", getAttrCtnt6());		
		this.hashColumns.put("pay_ony_due_dt_flg", getPayOnyDueDtFlg());		
		this.hashColumns.put("attr_ctnt7", getAttrCtnt7());		
		this.hashColumns.put("pay_sts_cd", getPayStsCd());		
		this.hashColumns.put("high_pay_prio_no", getHighPayPrioNo());		
		this.hashColumns.put("low_pay_prio_no", getLowPayPrioNo());		
		this.hashColumns.put("pay_prd_nm", getPayPrdNm());		
		this.hashColumns.put("zr_amt_alw_flg", getZrAmtAlwFlg());		
		this.hashColumns.put("attr_cate_nm", getAttrCateNm());		
		this.hashColumns.put("bank_acct_nm", getBankAcctNm());		
		this.hashColumns.put("period_chk", getPeriodChk());		
		this.hashColumns.put("pay_xch_rt", getPayXchRt());		
		this.hashColumns.put("vndr_pay_grp_cd", getVndrPayGrpCd());		
		this.hashColumns.put("bank_acct_seq", getBankAcctSeq());		
		this.hashColumns.put("st_prn_doc_no", getStPrnDocNo());		
		this.hashColumns.put("end_prn_doc_no", getEndPrnDocNo());		
		this.hashColumns.put("pay_doc_no", getPayDocNo());		
		this.hashColumns.put("pay_bat_nm", getPayBatNm());		
		this.hashColumns.put("ofc_cd", getOfcCd());		
		this.hashColumns.put("pay_curr_cd", getPayCurrCd());		
		this.hashColumns.put("zr_inv_alw_flg", getZrInvAlwFlg());		
		this.hashColumns.put("xch_rt_tp_nm", getXchRtTpNm());		
		this.hashColumns.put("pay_mzd_lu_cd", getPayMzdLuCd());		
		this.hashColumns.put("usr_id", getUsrId());		
		this.hashColumns.put("chk_flg", getChkFlg());		
		this.hashColumns.put("functional_currency", getFunctionalCurrency());		
		this.hashColumns.put("upd_pay_sts_cd", getUpdPayStsCd());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("bank_acct_no", "bankAcctNo");
		this.hashFields.put("pay_dt", "payDt");
		this.hashFields.put("pay_thru_dt", "payThruDt");
		this.hashFields.put("xch_rt_tp_cd", "xchRtTpCd");
		this.hashFields.put("pay_xch_dt", "payXchDt");
		this.hashFields.put("attr_ctnt10", "attrCtnt10");
		this.hashFields.put("attr_ctnt14", "attrCtnt14");
		this.hashFields.put("attr_ctnt9", "attrCtnt9");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("attr_ctnt13", "attrCtnt13");
		this.hashFields.put("attr_ctnt8", "attrCtnt8");
		this.hashFields.put("attr_ctnt12", "attrCtnt12");
		this.hashFields.put("attr_ctnt11", "attrCtnt11");
		this.hashFields.put("ftu_dt_pay_flg", "ftuDtPayFlg");
		this.hashFields.put("n1st_aval_doc_no", "n1stAvalDocNo");
		this.hashFields.put("attr_ctnt15", "attrCtnt15");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("attr_ctnt1", "attrCtnt1");
		this.hashFields.put("attr_ctnt2", "attrCtnt2");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vndr_no", "vndrNo");
		this.hashFields.put("attr_ctnt3", "attrCtnt3");
		this.hashFields.put("attr_ctnt4", "attrCtnt4");
		this.hashFields.put("attr_ctnt5", "attrCtnt5");
		this.hashFields.put("pay_bat_seq", "payBatSeq");
		this.hashFields.put("attr_ctnt6", "attrCtnt6");
		this.hashFields.put("pay_ony_due_dt_flg", "payOnyDueDtFlg");
		this.hashFields.put("attr_ctnt7", "attrCtnt7");
		this.hashFields.put("pay_sts_cd", "payStsCd");
		this.hashFields.put("high_pay_prio_no", "highPayPrioNo");
		this.hashFields.put("low_pay_prio_no", "lowPayPrioNo");
		this.hashFields.put("pay_prd_nm", "payPrdNm");
		this.hashFields.put("zr_amt_alw_flg", "zrAmtAlwFlg");
		this.hashFields.put("attr_cate_nm", "attrCateNm");
		this.hashFields.put("bank_acct_nm", "bankAcctNm");
		this.hashFields.put("period_chk", "periodChk");
		this.hashFields.put("pay_xch_rt", "payXchRt");
		this.hashFields.put("vndr_pay_grp_cd", "vndrPayGrpCd");
		this.hashFields.put("bank_acct_seq", "bankAcctSeq");
		this.hashFields.put("st_prn_doc_no", "stPrnDocNo");
		this.hashFields.put("end_prn_doc_no", "endPrnDocNo");
		this.hashFields.put("pay_doc_no", "payDocNo");
		this.hashFields.put("pay_bat_nm", "payBatNm");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("pay_curr_cd", "payCurrCd");
		this.hashFields.put("zr_inv_alw_flg", "zrInvAlwFlg");
		this.hashFields.put("xch_rt_tp_nm", "xchRtTpNm");
		this.hashFields.put("pay_mzd_lu_cd", "payMzdLuCd");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("chk_flg", "chkFlg");
		this.hashFields.put("functional_currency", "functionalCurrency");
		this.hashFields.put("upd_pay_sts_cd", "updPayStsCd");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
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
	 public	String	getBankAcctNo() {
		 return	this.bankAcctNo;
	 } 
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
	 public	String	getPayDt() {
		 return	this.payDt;
	 } 
 	/**
	* Column Info
	* @param  payThruDt
	*/
	public void	setPayThruDt( String	payThruDt ) {
		this.payThruDt =	payThruDt;
	}
 
	/**
	 * Column Info
	 * @return	payThruDt
	 */
	 public	String	getPayThruDt() {
		 return	this.payThruDt;
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
	* @param  attrCtnt10
	*/
	public void	setAttrCtnt10( String	attrCtnt10 ) {
		this.attrCtnt10 =	attrCtnt10;
	}
 
	/**
	 * Column Info
	 * @return	attrCtnt10
	 */
	 public	String	getAttrCtnt10() {
		 return	this.attrCtnt10;
	 } 
 	/**
	* Column Info
	* @param  attrCtnt14
	*/
	public void	setAttrCtnt14( String	attrCtnt14 ) {
		this.attrCtnt14 =	attrCtnt14;
	}
 
	/**
	 * Column Info
	 * @return	attrCtnt14
	 */
	 public	String	getAttrCtnt14() {
		 return	this.attrCtnt14;
	 } 
 	/**
	* Column Info
	* @param  attrCtnt9
	*/
	public void	setAttrCtnt9( String	attrCtnt9 ) {
		this.attrCtnt9 =	attrCtnt9;
	}
 
	/**
	 * Column Info
	 * @return	attrCtnt9
	 */
	 public	String	getAttrCtnt9() {
		 return	this.attrCtnt9;
	 } 
 	/**
	* Column Info
	* @param  vndrLglEngNm
	*/
	public void	setVndrLglEngNm( String	vndrLglEngNm ) {
		this.vndrLglEngNm =	vndrLglEngNm;
	}
 
	/**
	 * Column Info
	 * @return	vndrLglEngNm
	 */
	 public	String	getVndrLglEngNm() {
		 return	this.vndrLglEngNm;
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
	* @param  attrCtnt8
	*/
	public void	setAttrCtnt8( String	attrCtnt8 ) {
		this.attrCtnt8 =	attrCtnt8;
	}
 
	/**
	 * Column Info
	 * @return	attrCtnt8
	 */
	 public	String	getAttrCtnt8() {
		 return	this.attrCtnt8;
	 } 
 	/**
	* Column Info
	* @param  attrCtnt12
	*/
	public void	setAttrCtnt12( String	attrCtnt12 ) {
		this.attrCtnt12 =	attrCtnt12;
	}
 
	/**
	 * Column Info
	 * @return	attrCtnt12
	 */
	 public	String	getAttrCtnt12() {
		 return	this.attrCtnt12;
	 } 
 	/**
	* Column Info
	* @param  attrCtnt11
	*/
	public void	setAttrCtnt11( String	attrCtnt11 ) {
		this.attrCtnt11 =	attrCtnt11;
	}
 
	/**
	 * Column Info
	 * @return	attrCtnt11
	 */
	 public	String	getAttrCtnt11() {
		 return	this.attrCtnt11;
	 } 
 	/**
	* Column Info
	* @param  ftuDtPayFlg
	*/
	public void	setFtuDtPayFlg( String	ftuDtPayFlg ) {
		this.ftuDtPayFlg =	ftuDtPayFlg;
	}
 
	/**
	 * Column Info
	 * @return	ftuDtPayFlg
	 */
	 public	String	getFtuDtPayFlg() {
		 return	this.ftuDtPayFlg;
	 } 
 	/**
	* Column Info
	* @param  n1stAvalDocNo
	*/
	public void	setN1stAvalDocNo( String	n1stAvalDocNo ) {
		this.n1stAvalDocNo =	n1stAvalDocNo;
	}
 
	/**
	 * Column Info
	 * @return	n1stAvalDocNo
	 */
	 public	String	getN1stAvalDocNo() {
		 return	this.n1stAvalDocNo;
	 } 
 	/**
	* Column Info
	* @param  attrCtnt15
	*/
	public void	setAttrCtnt15( String	attrCtnt15 ) {
		this.attrCtnt15 =	attrCtnt15;
	}
 
	/**
	 * Column Info
	 * @return	attrCtnt15
	 */
	 public	String	getAttrCtnt15() {
		 return	this.attrCtnt15;
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
	* @param  attrCtnt1
	*/
	public void	setAttrCtnt1( String	attrCtnt1 ) {
		this.attrCtnt1 =	attrCtnt1;
	}
 
	/**
	 * Column Info
	 * @return	attrCtnt1
	 */
	 public	String	getAttrCtnt1() {
		 return	this.attrCtnt1;
	 } 
 	/**
	* Column Info
	* @param  attrCtnt2
	*/
	public void	setAttrCtnt2( String	attrCtnt2 ) {
		this.attrCtnt2 =	attrCtnt2;
	}
 
	/**
	 * Column Info
	 * @return	attrCtnt2
	 */
	 public	String	getAttrCtnt2() {
		 return	this.attrCtnt2;
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
	* @param  attrCtnt3
	*/
	public void	setAttrCtnt3( String	attrCtnt3 ) {
		this.attrCtnt3 =	attrCtnt3;
	}
 
	/**
	 * Column Info
	 * @return	attrCtnt3
	 */
	 public	String	getAttrCtnt3() {
		 return	this.attrCtnt3;
	 } 
 	/**
	* Column Info
	* @param  attrCtnt4
	*/
	public void	setAttrCtnt4( String	attrCtnt4 ) {
		this.attrCtnt4 =	attrCtnt4;
	}
 
	/**
	 * Column Info
	 * @return	attrCtnt4
	 */
	 public	String	getAttrCtnt4() {
		 return	this.attrCtnt4;
	 } 
 	/**
	* Column Info
	* @param  attrCtnt5
	*/
	public void	setAttrCtnt5( String	attrCtnt5 ) {
		this.attrCtnt5 =	attrCtnt5;
	}
 
	/**
	 * Column Info
	 * @return	attrCtnt5
	 */
	 public	String	getAttrCtnt5() {
		 return	this.attrCtnt5;
	 } 
 	/**
	* Column Info
	* @param  payBatSeq
	*/
	public void	setPayBatSeq( String	payBatSeq ) {
		this.payBatSeq =	payBatSeq;
	}
 
	/**
	 * Column Info
	 * @return	payBatSeq
	 */
	 public	String	getPayBatSeq() {
		 return	this.payBatSeq;
	 } 
 	/**
	* Column Info
	* @param  attrCtnt6
	*/
	public void	setAttrCtnt6( String	attrCtnt6 ) {
		this.attrCtnt6 =	attrCtnt6;
	}
 
	/**
	 * Column Info
	 * @return	attrCtnt6
	 */
	 public	String	getAttrCtnt6() {
		 return	this.attrCtnt6;
	 } 
 	/**
	* Column Info
	* @param  payOnyDueDtFlg
	*/
	public void	setPayOnyDueDtFlg( String	payOnyDueDtFlg ) {
		this.payOnyDueDtFlg =	payOnyDueDtFlg;
	}
 
	/**
	 * Column Info
	 * @return	payOnyDueDtFlg
	 */
	 public	String	getPayOnyDueDtFlg() {
		 return	this.payOnyDueDtFlg;
	 } 
 	/**
	* Column Info
	* @param  attrCtnt7
	*/
	public void	setAttrCtnt7( String	attrCtnt7 ) {
		this.attrCtnt7 =	attrCtnt7;
	}
 
	/**
	 * Column Info
	 * @return	attrCtnt7
	 */
	 public	String	getAttrCtnt7() {
		 return	this.attrCtnt7;
	 } 
 	/**
	* Column Info
	* @param  payStsCd
	*/
	public void	setPayStsCd( String	payStsCd ) {
		this.payStsCd =	payStsCd;
	}
 
	/**
	 * Column Info
	 * @return	payStsCd
	 */
	 public	String	getPayStsCd() {
		 return	this.payStsCd;
	 } 
 	/**
	* Column Info
	* @param  highPayPrioNo
	*/
	public void	setHighPayPrioNo( String	highPayPrioNo ) {
		this.highPayPrioNo =	highPayPrioNo;
	}
 
	/**
	 * Column Info
	 * @return	highPayPrioNo
	 */
	 public	String	getHighPayPrioNo() {
		 return	this.highPayPrioNo;
	 } 
 	/**
	* Column Info
	* @param  lowPayPrioNo
	*/
	public void	setLowPayPrioNo( String	lowPayPrioNo ) {
		this.lowPayPrioNo =	lowPayPrioNo;
	}
 
	/**
	 * Column Info
	 * @return	lowPayPrioNo
	 */
	 public	String	getLowPayPrioNo() {
		 return	this.lowPayPrioNo;
	 } 
 	/**
	* Column Info
	* @param  payPrdNm
	*/
	public void	setPayPrdNm( String	payPrdNm ) {
		this.payPrdNm =	payPrdNm;
	}
 
	/**
	 * Column Info
	 * @return	payPrdNm
	 */
	 public	String	getPayPrdNm() {
		 return	this.payPrdNm;
	 } 
 	/**
	* Column Info
	* @param  zrAmtAlwFlg
	*/
	public void	setZrAmtAlwFlg( String	zrAmtAlwFlg ) {
		this.zrAmtAlwFlg =	zrAmtAlwFlg;
	}
 
	/**
	 * Column Info
	 * @return	zrAmtAlwFlg
	 */
	 public	String	getZrAmtAlwFlg() {
		 return	this.zrAmtAlwFlg;
	 } 
 	/**
	* Column Info
	* @param  attrCateNm
	*/
	public void	setAttrCateNm( String	attrCateNm ) {
		this.attrCateNm =	attrCateNm;
	}
 
	/**
	 * Column Info
	 * @return	attrCateNm
	 */
	 public	String	getAttrCateNm() {
		 return	this.attrCateNm;
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
	 public	String	getBankAcctNm() {
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
	 public	String	getPeriodChk() {
		 return	this.periodChk;
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
	* @param  vndrPayGrpCd
	*/
	public void	setVndrPayGrpCd( String	vndrPayGrpCd ) {
		this.vndrPayGrpCd =	vndrPayGrpCd;
	}
 
	/**
	 * Column Info
	 * @return	vndrPayGrpCd
	 */
	 public	String	getVndrPayGrpCd() {
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
	 public	String	getBankAcctSeq() {
		 return	this.bankAcctSeq;
	 } 
 	/**
	* Column Info
	* @param  stPrnDocNo
	*/
	public void	setStPrnDocNo( String	stPrnDocNo ) {
		this.stPrnDocNo =	stPrnDocNo;
	}
 
	/**
	 * Column Info
	 * @return	stPrnDocNo
	 */
	 public	String	getStPrnDocNo() {
		 return	this.stPrnDocNo;
	 } 
 	/**
	* Column Info
	* @param  endPrnDocNo
	*/
	public void	setEndPrnDocNo( String	endPrnDocNo ) {
		this.endPrnDocNo =	endPrnDocNo;
	}
 
	/**
	 * Column Info
	 * @return	endPrnDocNo
	 */
	 public	String	getEndPrnDocNo() {
		 return	this.endPrnDocNo;
	 } 
 	/**
	* Column Info
	* @param  payDocNo
	*/
	public void	setPayDocNo( String	payDocNo ) {
		this.payDocNo =	payDocNo;
	}
 
	/**
	 * Column Info
	 * @return	payDocNo
	 */
	 public	String	getPayDocNo() {
		 return	this.payDocNo;
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
	 public	String	getPayBatNm() {
		 return	this.payBatNm;
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
	* @param  payCurrCd
	*/
	public void	setPayCurrCd( String	payCurrCd ) {
		this.payCurrCd =	payCurrCd;
	}
 
	/**
	 * Column Info
	 * @return	payCurrCd
	 */
	 public	String	getPayCurrCd() {
		 return	this.payCurrCd;
	 } 
 	/**
	* Column Info
	* @param  zrInvAlwFlg
	*/
	public void	setZrInvAlwFlg( String	zrInvAlwFlg ) {
		this.zrInvAlwFlg =	zrInvAlwFlg;
	}
 
	/**
	 * Column Info
	 * @return	zrInvAlwFlg
	 */
	 public	String	getZrInvAlwFlg() {
		 return	this.zrInvAlwFlg;
	 } 
 	/**
	* Column Info
	* @param  xchRtTpNm
	*/
	public void	setXchRtTpNm( String	xchRtTpNm ) {
		this.xchRtTpNm =	xchRtTpNm;
	}
 
	/**
	 * Column Info
	 * @return	xchRtTpNm
	 */
	 public	String	getXchRtTpNm() {
		 return	this.xchRtTpNm;
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
	* @param  chkFlg
	*/
	public void	setChkFlg( String	chkFlg ) {
		this.chkFlg =	chkFlg;
	}
 
	/**
	 * Column Info
	 * @return	chkFlg
	 */
	 public	String	getChkFlg() {
		 return	this.chkFlg;
	 } 
 	/**
	* Column Info
	* @param  functionalCurrency
	*/
	public void	setFunctionalCurrency( String	functionalCurrency ) {
		this.functionalCurrency =	functionalCurrency;
	}
 
	/**
	 * Column Info
	 * @return	functionalCurrency
	 */
	 public	String	getFunctionalCurrency() {
		 return	this.functionalCurrency;
	 } 
 	/**
	* Column Info
	* @param  updPayStsCd
	*/
	public void	setUpdPayStsCd( String	updPayStsCd ) {
		this.updPayStsCd =	updPayStsCd;
	}
 
	/**
	 * Column Info
	 * @return	updPayStsCd
	 */
	 public	String	getUpdPayStsCd() {
		 return	this.updPayStsCd;
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
		setBankAcctNo(JSPUtil.getParameter(request,	prefix + "bank_acct_no", ""));
		setPayDt(JSPUtil.getParameter(request,	prefix + "pay_dt", ""));
		setPayThruDt(JSPUtil.getParameter(request,	prefix + "pay_thru_dt", ""));
		setXchRtTpCd(JSPUtil.getParameter(request,	prefix + "xch_rt_tp_cd", ""));
		setPayXchDt(JSPUtil.getParameter(request,	prefix + "pay_xch_dt", ""));
		setAttrCtnt10(JSPUtil.getParameter(request,	prefix + "attr_ctnt10", ""));
		setAttrCtnt14(JSPUtil.getParameter(request,	prefix + "attr_ctnt14", ""));
		setAttrCtnt9(JSPUtil.getParameter(request,	prefix + "attr_ctnt9", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request,	prefix + "vndr_lgl_eng_nm", ""));
		setAttrCtnt13(JSPUtil.getParameter(request,	prefix + "attr_ctnt13", ""));
		setAttrCtnt8(JSPUtil.getParameter(request,	prefix + "attr_ctnt8", ""));
		setAttrCtnt12(JSPUtil.getParameter(request,	prefix + "attr_ctnt12", ""));
		setAttrCtnt11(JSPUtil.getParameter(request,	prefix + "attr_ctnt11", ""));
		setFtuDtPayFlg(JSPUtil.getParameter(request,	prefix + "ftu_dt_pay_flg", ""));
		setN1stAvalDocNo(JSPUtil.getParameter(request,	prefix + "n1st_aval_doc_no", ""));
		setAttrCtnt15(JSPUtil.getParameter(request,	prefix + "attr_ctnt15", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setAttrCtnt1(JSPUtil.getParameter(request,	prefix + "attr_ctnt1", ""));
		setAttrCtnt2(JSPUtil.getParameter(request,	prefix + "attr_ctnt2", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setVndrNo(JSPUtil.getParameter(request,	prefix + "vndr_no", ""));
		setAttrCtnt3(JSPUtil.getParameter(request,	prefix + "attr_ctnt3", ""));
		setAttrCtnt4(JSPUtil.getParameter(request,	prefix + "attr_ctnt4", ""));
		setAttrCtnt5(JSPUtil.getParameter(request,	prefix + "attr_ctnt5", ""));
		setPayBatSeq(JSPUtil.getParameter(request,	prefix + "pay_bat_seq", ""));
		setAttrCtnt6(JSPUtil.getParameter(request,	prefix + "attr_ctnt6", ""));
		setPayOnyDueDtFlg(JSPUtil.getParameter(request,	prefix + "pay_ony_due_dt_flg", ""));
		setAttrCtnt7(JSPUtil.getParameter(request,	prefix + "attr_ctnt7", ""));
		setPayStsCd(JSPUtil.getParameter(request,	prefix + "pay_sts_cd", ""));
		setHighPayPrioNo(JSPUtil.getParameter(request,	prefix + "high_pay_prio_no", ""));
		setLowPayPrioNo(JSPUtil.getParameter(request,	prefix + "low_pay_prio_no", ""));
		setPayPrdNm(JSPUtil.getParameter(request,	prefix + "pay_prd_nm", ""));
		setZrAmtAlwFlg(JSPUtil.getParameter(request,	prefix + "zr_amt_alw_flg", ""));
		setAttrCateNm(JSPUtil.getParameter(request,	prefix + "attr_cate_nm", ""));
		setBankAcctNm(JSPUtil.getParameter(request,	prefix + "bank_acct_nm", ""));
		setPeriodChk(JSPUtil.getParameter(request,	prefix + "period_chk", ""));
		setPayXchRt(JSPUtil.getParameter(request,	prefix + "pay_xch_rt", ""));
		setVndrPayGrpCd(JSPUtil.getParameter(request,	prefix + "vndr_pay_grp_cd", ""));
		setBankAcctSeq(JSPUtil.getParameter(request,	prefix + "bank_acct_seq", ""));
		setStPrnDocNo(JSPUtil.getParameter(request,	prefix + "st_prn_doc_no", ""));
		setEndPrnDocNo(JSPUtil.getParameter(request,	prefix + "end_prn_doc_no", ""));
		setPayDocNo(JSPUtil.getParameter(request,	prefix + "pay_doc_no", ""));
		setPayBatNm(JSPUtil.getParameter(request,	prefix + "pay_bat_nm", ""));
		setOfcCd(JSPUtil.getParameter(request,	prefix + "ofc_cd", ""));
		setPayCurrCd(JSPUtil.getParameter(request,	prefix + "pay_curr_cd", ""));
		setZrInvAlwFlg(JSPUtil.getParameter(request,	prefix + "zr_inv_alw_flg", ""));
		setXchRtTpNm(JSPUtil.getParameter(request,	prefix + "xch_rt_tp_nm", ""));
		setPayMzdLuCd(JSPUtil.getParameter(request,	prefix + "pay_mzd_lu_cd", ""));
		setUsrId(JSPUtil.getParameter(request,	prefix + "usr_id", ""));
		setChkFlg(JSPUtil.getParameter(request,	prefix + "chk_flg", ""));
		setFunctionalCurrency(JSPUtil.getParameter(request,	prefix + "functional_currency", ""));
		setUpdPayStsCd(JSPUtil.getParameter(request,	prefix + "upd_pay_sts_cd", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PaymentBatchListVO[]
	 */
	public PaymentBatchListVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return PaymentBatchListVO[]
	 */
	public PaymentBatchListVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		PaymentBatchListVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] bankAcctNo =	(JSPUtil.getParameter(request, prefix +	"bank_acct_no".trim(),	length));
				String[] payDt =	(JSPUtil.getParameter(request, prefix +	"pay_dt".trim(),	length));
				String[] payThruDt =	(JSPUtil.getParameter(request, prefix +	"pay_thru_dt".trim(),	length));
				String[] xchRtTpCd =	(JSPUtil.getParameter(request, prefix +	"xch_rt_tp_cd".trim(),	length));
				String[] payXchDt =	(JSPUtil.getParameter(request, prefix +	"pay_xch_dt".trim(),	length));
				String[] attrCtnt10 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt10".trim(),	length));
				String[] attrCtnt14 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt14".trim(),	length));
				String[] attrCtnt9 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt9".trim(),	length));
				String[] vndrLglEngNm =	(JSPUtil.getParameter(request, prefix +	"vndr_lgl_eng_nm".trim(),	length));
				String[] attrCtnt13 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt13".trim(),	length));
				String[] attrCtnt8 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt8".trim(),	length));
				String[] attrCtnt12 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt12".trim(),	length));
				String[] attrCtnt11 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt11".trim(),	length));
				String[] ftuDtPayFlg =	(JSPUtil.getParameter(request, prefix +	"ftu_dt_pay_flg".trim(),	length));
				String[] n1stAvalDocNo =	(JSPUtil.getParameter(request, prefix +	"n1st_aval_doc_no".trim(),	length));
				String[] attrCtnt15 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt15".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] attrCtnt1 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt1".trim(),	length));
				String[] attrCtnt2 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt2".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] vndrNo =	(JSPUtil.getParameter(request, prefix +	"vndr_no".trim(),	length));
				String[] attrCtnt3 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt3".trim(),	length));
				String[] attrCtnt4 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt4".trim(),	length));
				String[] attrCtnt5 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt5".trim(),	length));
				String[] payBatSeq =	(JSPUtil.getParameter(request, prefix +	"pay_bat_seq".trim(),	length));
				String[] attrCtnt6 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt6".trim(),	length));
				String[] payOnyDueDtFlg =	(JSPUtil.getParameter(request, prefix +	"pay_ony_due_dt_flg".trim(),	length));
				String[] attrCtnt7 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt7".trim(),	length));
				String[] payStsCd =	(JSPUtil.getParameter(request, prefix +	"pay_sts_cd".trim(),	length));
				String[] highPayPrioNo =	(JSPUtil.getParameter(request, prefix +	"high_pay_prio_no".trim(),	length));
				String[] lowPayPrioNo =	(JSPUtil.getParameter(request, prefix +	"low_pay_prio_no".trim(),	length));
				String[] payPrdNm =	(JSPUtil.getParameter(request, prefix +	"pay_prd_nm".trim(),	length));
				String[] zrAmtAlwFlg =	(JSPUtil.getParameter(request, prefix +	"zr_amt_alw_flg".trim(),	length));
				String[] attrCateNm =	(JSPUtil.getParameter(request, prefix +	"attr_cate_nm".trim(),	length));
				String[] bankAcctNm =	(JSPUtil.getParameter(request, prefix +	"bank_acct_nm".trim(),	length));
				String[] periodChk =	(JSPUtil.getParameter(request, prefix +	"period_chk".trim(),	length));
				String[] payXchRt =	(JSPUtil.getParameter(request, prefix +	"pay_xch_rt".trim(),	length));
				String[] vndrPayGrpCd =	(JSPUtil.getParameter(request, prefix +	"vndr_pay_grp_cd".trim(),	length));
				String[] bankAcctSeq =	(JSPUtil.getParameter(request, prefix +	"bank_acct_seq".trim(),	length));
				String[] stPrnDocNo =	(JSPUtil.getParameter(request, prefix +	"st_prn_doc_no".trim(),	length));
				String[] endPrnDocNo =	(JSPUtil.getParameter(request, prefix +	"end_prn_doc_no".trim(),	length));
				String[] payDocNo =	(JSPUtil.getParameter(request, prefix +	"pay_doc_no".trim(),	length));
				String[] payBatNm =	(JSPUtil.getParameter(request, prefix +	"pay_bat_nm".trim(),	length));
				String[] ofcCd =	(JSPUtil.getParameter(request, prefix +	"ofc_cd".trim(),	length));
				String[] payCurrCd =	(JSPUtil.getParameter(request, prefix +	"pay_curr_cd".trim(),	length));
				String[] zrInvAlwFlg =	(JSPUtil.getParameter(request, prefix +	"zr_inv_alw_flg".trim(),	length));
				String[] xchRtTpNm =	(JSPUtil.getParameter(request, prefix +	"xch_rt_tp_nm".trim(),	length));
				String[] payMzdLuCd =	(JSPUtil.getParameter(request, prefix +	"pay_mzd_lu_cd".trim(),	length));
				String[] usrId =	(JSPUtil.getParameter(request, prefix +	"usr_id".trim(),	length));
				String[] chkFlg =	(JSPUtil.getParameter(request, prefix +	"chk_flg".trim(),	length));
				String[] functionalCurrency =	(JSPUtil.getParameter(request, prefix +	"functional_currency".trim(),	length));
				String[] updPayStsCd =	(JSPUtil.getParameter(request, prefix +	"upd_pay_sts_cd".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	PaymentBatchListVO();
						if ( bankAcctNo[i] !=	null)
						model.setBankAcctNo( bankAcctNo[i]);
						if ( payDt[i] !=	null)
						model.setPayDt( payDt[i]);
						if ( payThruDt[i] !=	null)
						model.setPayThruDt( payThruDt[i]);
						if ( xchRtTpCd[i] !=	null)
						model.setXchRtTpCd( xchRtTpCd[i]);
						if ( payXchDt[i] !=	null)
						model.setPayXchDt( payXchDt[i]);
						if ( attrCtnt10[i] !=	null)
						model.setAttrCtnt10( attrCtnt10[i]);
						if ( attrCtnt14[i] !=	null)
						model.setAttrCtnt14( attrCtnt14[i]);
						if ( attrCtnt9[i] !=	null)
						model.setAttrCtnt9( attrCtnt9[i]);
						if ( vndrLglEngNm[i] !=	null)
						model.setVndrLglEngNm( vndrLglEngNm[i]);
						if ( attrCtnt13[i] !=	null)
						model.setAttrCtnt13( attrCtnt13[i]);
						if ( attrCtnt8[i] !=	null)
						model.setAttrCtnt8( attrCtnt8[i]);
						if ( attrCtnt12[i] !=	null)
						model.setAttrCtnt12( attrCtnt12[i]);
						if ( attrCtnt11[i] !=	null)
						model.setAttrCtnt11( attrCtnt11[i]);
						if ( ftuDtPayFlg[i] !=	null)
						model.setFtuDtPayFlg( ftuDtPayFlg[i]);
						if ( n1stAvalDocNo[i] !=	null)
						model.setN1stAvalDocNo( n1stAvalDocNo[i]);
						if ( attrCtnt15[i] !=	null)
						model.setAttrCtnt15( attrCtnt15[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( attrCtnt1[i] !=	null)
						model.setAttrCtnt1( attrCtnt1[i]);
						if ( attrCtnt2[i] !=	null)
						model.setAttrCtnt2( attrCtnt2[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( vndrNo[i] !=	null)
						model.setVndrNo( vndrNo[i]);
						if ( attrCtnt3[i] !=	null)
						model.setAttrCtnt3( attrCtnt3[i]);
						if ( attrCtnt4[i] !=	null)
						model.setAttrCtnt4( attrCtnt4[i]);
						if ( attrCtnt5[i] !=	null)
						model.setAttrCtnt5( attrCtnt5[i]);
						if ( payBatSeq[i] !=	null)
						model.setPayBatSeq( payBatSeq[i]);
						if ( attrCtnt6[i] !=	null)
						model.setAttrCtnt6( attrCtnt6[i]);
						if ( payOnyDueDtFlg[i] !=	null)
						model.setPayOnyDueDtFlg( payOnyDueDtFlg[i]);
						if ( attrCtnt7[i] !=	null)
						model.setAttrCtnt7( attrCtnt7[i]);
						if ( payStsCd[i] !=	null)
						model.setPayStsCd( payStsCd[i]);
						if ( highPayPrioNo[i] !=	null)
						model.setHighPayPrioNo( highPayPrioNo[i]);
						if ( lowPayPrioNo[i] !=	null)
						model.setLowPayPrioNo( lowPayPrioNo[i]);
						if ( payPrdNm[i] !=	null)
						model.setPayPrdNm( payPrdNm[i]);
						if ( zrAmtAlwFlg[i] !=	null)
						model.setZrAmtAlwFlg( zrAmtAlwFlg[i]);
						if ( attrCateNm[i] !=	null)
						model.setAttrCateNm( attrCateNm[i]);
						if ( bankAcctNm[i] !=	null)
						model.setBankAcctNm( bankAcctNm[i]);
						if ( periodChk[i] !=	null)
						model.setPeriodChk( periodChk[i]);
						if ( payXchRt[i] !=	null)
						model.setPayXchRt( payXchRt[i]);
						if ( vndrPayGrpCd[i] !=	null)
						model.setVndrPayGrpCd( vndrPayGrpCd[i]);
						if ( bankAcctSeq[i] !=	null)
						model.setBankAcctSeq( bankAcctSeq[i]);
						if ( stPrnDocNo[i] !=	null)
						model.setStPrnDocNo( stPrnDocNo[i]);
						if ( endPrnDocNo[i] !=	null)
						model.setEndPrnDocNo( endPrnDocNo[i]);
						if ( payDocNo[i] !=	null)
						model.setPayDocNo( payDocNo[i]);
						if ( payBatNm[i] !=	null)
						model.setPayBatNm( payBatNm[i]);
						if ( ofcCd[i] !=	null)
						model.setOfcCd( ofcCd[i]);
						if ( payCurrCd[i] !=	null)
						model.setPayCurrCd( payCurrCd[i]);
						if ( zrInvAlwFlg[i] !=	null)
						model.setZrInvAlwFlg( zrInvAlwFlg[i]);
						if ( xchRtTpNm[i] !=	null)
						model.setXchRtTpNm( xchRtTpNm[i]);
						if ( payMzdLuCd[i] !=	null)
						model.setPayMzdLuCd( payMzdLuCd[i]);
						if ( usrId[i] !=	null)
						model.setUsrId( usrId[i]);
						if ( chkFlg[i] !=	null)
						model.setChkFlg( chkFlg[i]);
						if ( functionalCurrency[i] !=	null)
						model.setFunctionalCurrency( functionalCurrency[i]);
						if ( updPayStsCd[i] !=	null)
						model.setUpdPayStsCd( updPayStsCd[i]);
					models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getPaymentBatchListVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return PaymentBatchListVO[]
	 */
	public PaymentBatchListVO[]	 getPaymentBatchListVOs(){
		PaymentBatchListVO[] vos = (PaymentBatchListVO[])models.toArray(new	PaymentBatchListVO[models.size()]);
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
		this.bankAcctNo =	this.bankAcctNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payDt =	this.payDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payThruDt =	this.payThruDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRtTpCd =	this.xchRtTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payXchDt =	this.payXchDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt10 =	this.attrCtnt10.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt14 =	this.attrCtnt14.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt9 =	this.attrCtnt9.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm =	this.vndrLglEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt13 =	this.attrCtnt13.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt8 =	this.attrCtnt8.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt12 =	this.attrCtnt12.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt11 =	this.attrCtnt11.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftuDtPayFlg =	this.ftuDtPayFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stAvalDocNo =	this.n1stAvalDocNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt15 =	this.attrCtnt15.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt1 =	this.attrCtnt1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt2 =	this.attrCtnt2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNo =	this.vndrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt3 =	this.attrCtnt3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt4 =	this.attrCtnt4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt5 =	this.attrCtnt5.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payBatSeq =	this.payBatSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt6 =	this.attrCtnt6.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payOnyDueDtFlg =	this.payOnyDueDtFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt7 =	this.attrCtnt7.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payStsCd =	this.payStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.highPayPrioNo =	this.highPayPrioNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lowPayPrioNo =	this.lowPayPrioNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payPrdNm =	this.payPrdNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zrAmtAlwFlg =	this.zrAmtAlwFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCateNm =	this.attrCateNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankAcctNm =	this.bankAcctNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.periodChk =	this.periodChk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payXchRt =	this.payXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrPayGrpCd =	this.vndrPayGrpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankAcctSeq =	this.bankAcctSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stPrnDocNo =	this.stPrnDocNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endPrnDocNo =	this.endPrnDocNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payDocNo =	this.payDocNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payBatNm =	this.payBatNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd =	this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payCurrCd =	this.payCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zrInvAlwFlg =	this.zrInvAlwFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRtTpNm =	this.xchRtTpNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payMzdLuCd =	this.payMzdLuCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId =	this.usrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkFlg =	this.chkFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.functionalCurrency =	this.functionalCurrency.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updPayStsCd =	this.updPayStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}