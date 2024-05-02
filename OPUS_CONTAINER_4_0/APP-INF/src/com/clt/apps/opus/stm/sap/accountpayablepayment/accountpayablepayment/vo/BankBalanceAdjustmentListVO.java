/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : BankBalanceAdjustmentListVO.java
 *@FileTitle : BankBalanceAdjustmentListVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.07.25
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2014.07.25  
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
public class BankBalanceAdjustmentListVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<BankBalanceAdjustmentListVO>  models =	new	ArrayList<BankBalanceAdjustmentListVO>();


	/*	Column Info	*/
	private  String	 bankAcctSeq   =  null;
	/*	Column Info	*/
	private  String	 inpTtlPayAmt   =  null;
	/*	Column Info	*/
	private  String	 aftTtlPayAmt   =  null;
	/*	Column Info	*/
	private  String	 inpTtlRctAmt   =  null;
	/*	Column Info	*/
	private  String	 bankStmtDesc   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 ctrlTtlRctAmt   =  null;
	/*	Column Info	*/
	private  String	 aftTtlRctAmt   =  null;
	/*	Column Info	*/
	private  String	 ctrlTtlPayAmt   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 aftEndgBalAmt   =  null;
	/*	Column Info	*/
	private  String	 usrId   =  null;
	/*	Column Info	*/
	private  String	 bankStmtDt   =  null;
	/*	Column Info	*/
	private  String	 ctrlEndgBalAmt   =  null;
	/*	Column Info	*/
	private  String	 ctrlBgnBalAmt   =  null;
	/*	Column Info	*/
	private  String	 receiptAmtToday   =  null;
	/*	Column Info	*/
	private  String	 paymentAmtToday   =  null;
	/*	Column Info	*/
	private  String	 saveChk   =  null;
	/*	Column Info	*/
	private  String	 adjChk   =  null;
	/*	Column Info	*/
	private  String	 trxChk   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public BankBalanceAdjustmentListVO(){}

	public BankBalanceAdjustmentListVO(String bankAcctSeq,String inpTtlPayAmt,String aftTtlPayAmt,String inpTtlRctAmt,String bankStmtDesc,String pagerows,String ctrlTtlRctAmt,String aftTtlRctAmt,String ctrlTtlPayAmt,String ibflag,String aftEndgBalAmt,String usrId,String bankStmtDt,String ctrlEndgBalAmt,String ctrlBgnBalAmt,String receiptAmtToday,String paymentAmtToday,String saveChk,String adjChk,String trxChk)	{
		this.bankAcctSeq  = bankAcctSeq ;
		this.inpTtlPayAmt  = inpTtlPayAmt ;
		this.aftTtlPayAmt  = aftTtlPayAmt ;
		this.inpTtlRctAmt  = inpTtlRctAmt ;
		this.bankStmtDesc  = bankStmtDesc ;
		this.pagerows  = pagerows ;
		this.ctrlTtlRctAmt  = ctrlTtlRctAmt ;
		this.aftTtlRctAmt  = aftTtlRctAmt ;
		this.ctrlTtlPayAmt  = ctrlTtlPayAmt ;
		this.ibflag  = ibflag ;
		this.aftEndgBalAmt  = aftEndgBalAmt ;
		this.usrId  = usrId ;
		this.bankStmtDt  = bankStmtDt ;
		this.ctrlEndgBalAmt  = ctrlEndgBalAmt ;
		this.ctrlBgnBalAmt  = ctrlBgnBalAmt ;
		this.receiptAmtToday  = receiptAmtToday ;
		this.paymentAmtToday  = paymentAmtToday ;
		this.saveChk  = saveChk ;
		this.adjChk  = adjChk ;
		this.trxChk  = trxChk ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bank_acct_seq", getBankAcctSeq());		
		this.hashColumns.put("inp_ttl_pay_amt", getInpTtlPayAmt());		
		this.hashColumns.put("aft_ttl_pay_amt", getAftTtlPayAmt());		
		this.hashColumns.put("inp_ttl_rct_amt", getInpTtlRctAmt());		
		this.hashColumns.put("bank_stmt_desc", getBankStmtDesc());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("ctrl_ttl_rct_amt", getCtrlTtlRctAmt());		
		this.hashColumns.put("aft_ttl_rct_amt", getAftTtlRctAmt());		
		this.hashColumns.put("ctrl_ttl_pay_amt", getCtrlTtlPayAmt());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("aft_endg_bal_amt", getAftEndgBalAmt());		
		this.hashColumns.put("usr_id", getUsrId());		
		this.hashColumns.put("bank_stmt_dt", getBankStmtDt());		
		this.hashColumns.put("ctrl_endg_bal_amt", getCtrlEndgBalAmt());		
		this.hashColumns.put("ctrl_bgn_bal_amt", getCtrlBgnBalAmt());		
		this.hashColumns.put("receipt_amt_today", getReceiptAmtToday());		
		this.hashColumns.put("payment_amt_today", getPaymentAmtToday());		
		this.hashColumns.put("save_chk", getSaveChk());		
		this.hashColumns.put("adj_chk", getAdjChk());		
		this.hashColumns.put("trx_chk", getTrxChk());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("bank_acct_seq", "bankAcctSeq");
		this.hashFields.put("inp_ttl_pay_amt", "inpTtlPayAmt");
		this.hashFields.put("aft_ttl_pay_amt", "aftTtlPayAmt");
		this.hashFields.put("inp_ttl_rct_amt", "inpTtlRctAmt");
		this.hashFields.put("bank_stmt_desc", "bankStmtDesc");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ctrl_ttl_rct_amt", "ctrlTtlRctAmt");
		this.hashFields.put("aft_ttl_rct_amt", "aftTtlRctAmt");
		this.hashFields.put("ctrl_ttl_pay_amt", "ctrlTtlPayAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("aft_endg_bal_amt", "aftEndgBalAmt");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("bank_stmt_dt", "bankStmtDt");
		this.hashFields.put("ctrl_endg_bal_amt", "ctrlEndgBalAmt");
		this.hashFields.put("ctrl_bgn_bal_amt", "ctrlBgnBalAmt");
		this.hashFields.put("receipt_amt_today", "receiptAmtToday");
		this.hashFields.put("payment_amt_today", "paymentAmtToday");
		this.hashFields.put("save_chk", "saveChk");
		this.hashFields.put("adj_chk", "adjChk");
		this.hashFields.put("trx_chk", "trxChk");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
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
	* @param  inpTtlPayAmt
	*/
	public void	setInpTtlPayAmt( String	inpTtlPayAmt ) {
		this.inpTtlPayAmt =	inpTtlPayAmt;
	}
 
	/**
	 * Column Info
	 * @return	inpTtlPayAmt
	 */
	 public	 String	getInpTtlPayAmt() {
		 return	this.inpTtlPayAmt;
	 } 
 	/**
	* Column Info
	* @param  aftTtlPayAmt
	*/
	public void	setAftTtlPayAmt( String	aftTtlPayAmt ) {
		this.aftTtlPayAmt =	aftTtlPayAmt;
	}
 
	/**
	 * Column Info
	 * @return	aftTtlPayAmt
	 */
	 public	 String	getAftTtlPayAmt() {
		 return	this.aftTtlPayAmt;
	 } 
 	/**
	* Column Info
	* @param  inpTtlRctAmt
	*/
	public void	setInpTtlRctAmt( String	inpTtlRctAmt ) {
		this.inpTtlRctAmt =	inpTtlRctAmt;
	}
 
	/**
	 * Column Info
	 * @return	inpTtlRctAmt
	 */
	 public	 String	getInpTtlRctAmt() {
		 return	this.inpTtlRctAmt;
	 } 
 	/**
	* Column Info
	* @param  bankStmtDesc
	*/
	public void	setBankStmtDesc( String	bankStmtDesc ) {
		this.bankStmtDesc =	bankStmtDesc;
	}
 
	/**
	 * Column Info
	 * @return	bankStmtDesc
	 */
	 public	 String	getBankStmtDesc() {
		 return	this.bankStmtDesc;
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
	* @param  ctrlTtlRctAmt
	*/
	public void	setCtrlTtlRctAmt( String	ctrlTtlRctAmt ) {
		this.ctrlTtlRctAmt =	ctrlTtlRctAmt;
	}
 
	/**
	 * Column Info
	 * @return	ctrlTtlRctAmt
	 */
	 public	 String	getCtrlTtlRctAmt() {
		 return	this.ctrlTtlRctAmt;
	 } 
 	/**
	* Column Info
	* @param  aftTtlRctAmt
	*/
	public void	setAftTtlRctAmt( String	aftTtlRctAmt ) {
		this.aftTtlRctAmt =	aftTtlRctAmt;
	}
 
	/**
	 * Column Info
	 * @return	aftTtlRctAmt
	 */
	 public	 String	getAftTtlRctAmt() {
		 return	this.aftTtlRctAmt;
	 } 
 	/**
	* Column Info
	* @param  ctrlTtlPayAmt
	*/
	public void	setCtrlTtlPayAmt( String	ctrlTtlPayAmt ) {
		this.ctrlTtlPayAmt =	ctrlTtlPayAmt;
	}
 
	/**
	 * Column Info
	 * @return	ctrlTtlPayAmt
	 */
	 public	 String	getCtrlTtlPayAmt() {
		 return	this.ctrlTtlPayAmt;
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
	* @param  aftEndgBalAmt
	*/
	public void	setAftEndgBalAmt( String	aftEndgBalAmt ) {
		this.aftEndgBalAmt =	aftEndgBalAmt;
	}
 
	/**
	 * Column Info
	 * @return	aftEndgBalAmt
	 */
	 public	 String	getAftEndgBalAmt() {
		 return	this.aftEndgBalAmt;
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
	* @param  bankStmtDt
	*/
	public void	setBankStmtDt( String	bankStmtDt ) {
		this.bankStmtDt =	bankStmtDt;
	}
 
	/**
	 * Column Info
	 * @return	bankStmtDt
	 */
	 public	 String	getBankStmtDt() {
		 return	this.bankStmtDt;
	 } 
 	/**
	* Column Info
	* @param  ctrlEndgBalAmt
	*/
	public void	setCtrlEndgBalAmt( String	ctrlEndgBalAmt ) {
		this.ctrlEndgBalAmt =	ctrlEndgBalAmt;
	}
 
	/**
	 * Column Info
	 * @return	ctrlEndgBalAmt
	 */
	 public	 String	getCtrlEndgBalAmt() {
		 return	this.ctrlEndgBalAmt;
	 } 
 	/**
	* Column Info
	* @param  ctrlBgnBalAmt
	*/
	public void	setCtrlBgnBalAmt( String	ctrlBgnBalAmt ) {
		this.ctrlBgnBalAmt =	ctrlBgnBalAmt;
	}
 
	/**
	 * Column Info
	 * @return	ctrlBgnBalAmt
	 */
	 public	 String	getCtrlBgnBalAmt() {
		 return	this.ctrlBgnBalAmt;
	 } 
 	/**
	* Column Info
	* @param  receiptAmtToday
	*/
	public void	setReceiptAmtToday( String	receiptAmtToday ) {
		this.receiptAmtToday =	receiptAmtToday;
	}
 
	/**
	 * Column Info
	 * @return	receiptAmtToday
	 */
	 public	 String	getReceiptAmtToday() {
		 return	this.receiptAmtToday;
	 } 
 	/**
	* Column Info
	* @param  paymentAmtToday
	*/
	public void	setPaymentAmtToday( String	paymentAmtToday ) {
		this.paymentAmtToday =	paymentAmtToday;
	}
 
	/**
	 * Column Info
	 * @return	paymentAmtToday
	 */
	 public	 String	getPaymentAmtToday() {
		 return	this.paymentAmtToday;
	 } 
 	/**
	* Column Info
	* @param  saveChk
	*/
	public void	setSaveChk( String	saveChk ) {
		this.saveChk =	saveChk;
	}
 
	/**
	 * Column Info
	 * @return	saveChk
	 */
	 public	 String	getSaveChk() {
		 return	this.saveChk;
	 } 
 	/**
	* Column Info
	* @param  adjChk
	*/
	public void	setAdjChk( String	adjChk ) {
		this.adjChk =	adjChk;
	}
 
	/**
	 * Column Info
	 * @return	adjChk
	 */
	 public	 String	getAdjChk() {
		 return	this.adjChk;
	 } 
 	/**
	* Column Info
	* @param  trxChk
	*/
	public void	setTrxChk( String	trxChk ) {
		this.trxChk =	trxChk;
	}
 
	/**
	 * Column Info
	 * @return	trxChk
	 */
	 public	 String	getTrxChk() {
		 return	this.trxChk;
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
		setBankAcctSeq(JSPUtil.getParameter(request,	prefix + "bank_acct_seq", ""));
		setInpTtlPayAmt(JSPUtil.getParameter(request,	prefix + "inp_ttl_pay_amt", ""));
		setAftTtlPayAmt(JSPUtil.getParameter(request,	prefix + "aft_ttl_pay_amt", ""));
		setInpTtlRctAmt(JSPUtil.getParameter(request,	prefix + "inp_ttl_rct_amt", ""));
		setBankStmtDesc(JSPUtil.getParameter(request,	prefix + "bank_stmt_desc", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setCtrlTtlRctAmt(JSPUtil.getParameter(request,	prefix + "ctrl_ttl_rct_amt", ""));
		setAftTtlRctAmt(JSPUtil.getParameter(request,	prefix + "aft_ttl_rct_amt", ""));
		setCtrlTtlPayAmt(JSPUtil.getParameter(request,	prefix + "ctrl_ttl_pay_amt", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setAftEndgBalAmt(JSPUtil.getParameter(request,	prefix + "aft_endg_bal_amt", ""));
		setUsrId(JSPUtil.getParameter(request,	prefix + "usr_id", ""));
		setBankStmtDt(JSPUtil.getParameter(request,	prefix + "bank_stmt_dt", ""));
		setCtrlEndgBalAmt(JSPUtil.getParameter(request,	prefix + "ctrl_endg_bal_amt", ""));
		setCtrlBgnBalAmt(JSPUtil.getParameter(request,	prefix + "ctrl_bgn_bal_amt", ""));
		setReceiptAmtToday(JSPUtil.getParameter(request,	prefix + "receipt_amt_today", ""));
		setPaymentAmtToday(JSPUtil.getParameter(request,	prefix + "payment_amt_today", ""));
		setSaveChk(JSPUtil.getParameter(request,	prefix + "save_chk", ""));
		setAdjChk(JSPUtil.getParameter(request,	prefix + "adj_chk", ""));
		setTrxChk(JSPUtil.getParameter(request,	prefix + "trx_chk", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BankBalanceAdjustmentListVO[]
	 */
	public BankBalanceAdjustmentListVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return BankBalanceAdjustmentListVO[]
	 */
	public BankBalanceAdjustmentListVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		BankBalanceAdjustmentListVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] bankAcctSeq =	(JSPUtil.getParameter(request, prefix +	"bank_acct_seq".trim(),	length));
				String[] inpTtlPayAmt =	(JSPUtil.getParameter(request, prefix +	"inp_ttl_pay_amt".trim(),	length));
				String[] aftTtlPayAmt =	(JSPUtil.getParameter(request, prefix +	"aft_ttl_pay_amt".trim(),	length));
				String[] inpTtlRctAmt =	(JSPUtil.getParameter(request, prefix +	"inp_ttl_rct_amt".trim(),	length));
				String[] bankStmtDesc =	(JSPUtil.getParameter(request, prefix +	"bank_stmt_desc".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] ctrlTtlRctAmt =	(JSPUtil.getParameter(request, prefix +	"ctrl_ttl_rct_amt".trim(),	length));
				String[] aftTtlRctAmt =	(JSPUtil.getParameter(request, prefix +	"aft_ttl_rct_amt".trim(),	length));
				String[] ctrlTtlPayAmt =	(JSPUtil.getParameter(request, prefix +	"ctrl_ttl_pay_amt".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] aftEndgBalAmt =	(JSPUtil.getParameter(request, prefix +	"aft_endg_bal_amt".trim(),	length));
				String[] usrId =	(JSPUtil.getParameter(request, prefix +	"usr_id".trim(),	length));
				String[] bankStmtDt =	(JSPUtil.getParameter(request, prefix +	"bank_stmt_dt".trim(),	length));
				String[] ctrlEndgBalAmt =	(JSPUtil.getParameter(request, prefix +	"ctrl_endg_bal_amt".trim(),	length));
				String[] ctrlBgnBalAmt =	(JSPUtil.getParameter(request, prefix +	"ctrl_bgn_bal_amt".trim(),	length));
				String[] receiptAmtToday =	(JSPUtil.getParameter(request, prefix +	"receipt_amt_today".trim(),	length));
				String[] paymentAmtToday =	(JSPUtil.getParameter(request, prefix +	"payment_amt_today".trim(),	length));
				String[] saveChk =	(JSPUtil.getParameter(request, prefix +	"save_chk".trim(),	length));
				String[] adjChk =	(JSPUtil.getParameter(request, prefix +	"adj_chk".trim(),	length));
				String[] trxChk =	(JSPUtil.getParameter(request, prefix +	"trx_chk".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	BankBalanceAdjustmentListVO();
						if ( bankAcctSeq[i] !=	null)
						model.setBankAcctSeq( bankAcctSeq[i]);
						if ( inpTtlPayAmt[i] !=	null)
						model.setInpTtlPayAmt( inpTtlPayAmt[i]);
						if ( aftTtlPayAmt[i] !=	null)
						model.setAftTtlPayAmt( aftTtlPayAmt[i]);
						if ( inpTtlRctAmt[i] !=	null)
						model.setInpTtlRctAmt( inpTtlRctAmt[i]);
						if ( bankStmtDesc[i] !=	null)
						model.setBankStmtDesc( bankStmtDesc[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( ctrlTtlRctAmt[i] !=	null)
						model.setCtrlTtlRctAmt( ctrlTtlRctAmt[i]);
						if ( aftTtlRctAmt[i] !=	null)
						model.setAftTtlRctAmt( aftTtlRctAmt[i]);
						if ( ctrlTtlPayAmt[i] !=	null)
						model.setCtrlTtlPayAmt( ctrlTtlPayAmt[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( aftEndgBalAmt[i] !=	null)
						model.setAftEndgBalAmt( aftEndgBalAmt[i]);
						if ( usrId[i] !=	null)
						model.setUsrId( usrId[i]);
						if ( bankStmtDt[i] !=	null)
						model.setBankStmtDt( bankStmtDt[i]);
						if ( ctrlEndgBalAmt[i] !=	null)
						model.setCtrlEndgBalAmt( ctrlEndgBalAmt[i]);
						if ( ctrlBgnBalAmt[i] !=	null)
						model.setCtrlBgnBalAmt( ctrlBgnBalAmt[i]);
						if ( receiptAmtToday[i] !=	null)
						model.setReceiptAmtToday( receiptAmtToday[i]);
						if ( paymentAmtToday[i] !=	null)
						model.setPaymentAmtToday( paymentAmtToday[i]);
						if ( saveChk[i] !=	null)
						model.setSaveChk( saveChk[i]);
						if ( adjChk[i] !=	null)
						model.setAdjChk( adjChk[i]);
						if ( trxChk[i] !=	null)
						model.setTrxChk( trxChk[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getBankBalanceAdjustmentListVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return BankBalanceAdjustmentListVO[]
	 */
	public BankBalanceAdjustmentListVO[]	 getBankBalanceAdjustmentListVOs(){
		BankBalanceAdjustmentListVO[] vos = (BankBalanceAdjustmentListVO[])models.toArray(new	BankBalanceAdjustmentListVO[models.size()]);
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
		this.bankAcctSeq =	this.bankAcctSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpTtlPayAmt =	this.inpTtlPayAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftTtlPayAmt =	this.aftTtlPayAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpTtlRctAmt =	this.inpTtlRctAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankStmtDesc =	this.bankStmtDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlTtlRctAmt =	this.ctrlTtlRctAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftTtlRctAmt =	this.aftTtlRctAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlTtlPayAmt =	this.ctrlTtlPayAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftEndgBalAmt =	this.aftEndgBalAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId =	this.usrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankStmtDt =	this.bankStmtDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlEndgBalAmt =	this.ctrlEndgBalAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlBgnBalAmt =	this.ctrlBgnBalAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.receiptAmtToday =	this.receiptAmtToday.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paymentAmtToday =	this.paymentAmtToday.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.saveChk =	this.saveChk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjChk =	this.adjChk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trxChk =	this.trxChk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}