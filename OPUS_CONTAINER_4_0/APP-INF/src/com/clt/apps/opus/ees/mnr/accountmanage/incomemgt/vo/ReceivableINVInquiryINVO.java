/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ReceivableINVInquiryINVO.java
 *@FileTitle : ReceivableINVInquiryINVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.07.10
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2014.07.10  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.ees.mnr.accountmanage.incomemgt.vo;

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
public class ReceivableINVInquiryINVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<ReceivableINVInquiryINVO>  models =	new	ArrayList<ReceivableINVInquiryINVO>();


	/*	Column Info	*/
	private  String	 userOfcCd   =  null;
	/*	Column Info	*/
	private  String	 fromDt   =  null;
	/*	Column Info	*/
	private  String	 cancelYn   =  null;
	/*	Column Info	*/
	private  String	 currCd   =  null;
	/*	Column Info	*/
	private  String	 buyerCd   =  null;
	/*	Column Info	*/
	private  String	 mnrGrpTpCd   =  null;
	/*	Column Info	*/
	private  String	 vat   =  null;
	/*	Column Info	*/
	private  String	 mnrPrnrCntCd   =  null;
	/*	Column Info	*/
	private  String	 invDueDt   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 mnrPrnrSeq   =  null;
	/*	Column Info	*/
	private  String	 chgCurrCd   =  null;
	/*	Column Info	*/
	private  String	 vatXchRt   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 chgXchRt   =  null;
	/*	Column Info	*/
	private  String	 mnrInvStsCd   =  null;
	/*	Column Info	*/
	private  String	 invAmt   =  null;
	/*	Column Info	*/
	private  String	 rcvInvSeq   =  null;
	/*	Column Info	*/
	private  String	 saveVndrSeq   =  null;
	/*	Column Info	*/
	private  String	 mnrInvRmk   =  null;
	/*	Column Info	*/
	private  String	 invDt   =  null;
	/*	Column Info	*/
	private  String	 inputInvNo   =  null;
	/*	Column Info	*/
	private  String	 invSchTypeCode   =  null;
	/*	Column Info	*/
	private  String	 mnrPrnrKndCd   =  null;
	/*	Column Info	*/
	private  String	 dispNo   =  null;
	/*	Column Info	*/
	private  String	 inputTypeCode   =  null;
	/*	Column Info	*/
	private  String	 dispDtlSeq   =  null;
	/*	Column Info	*/
	private  String	 mnrPrnrTpCd   =  null;
	/*	Column Info	*/
	private  String	 gAmt   =  null;
	/*	Column Info	*/
	private  String	 invNo   =  null;
	/*	Column Info	*/
	private  String	 toDt   =  null;
	/*	Column Info	*/
	private  String	 amt   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;
	/*	Column Info	*/
	private  String	 wht   =  null;
	/*	Column Info	*/
	private  String	 mnrOrdSeq   =  null;
	/*	Column Info	*/
	private  String	 vndrSeq   =  null;
	/*	Column Info	*/
	private  String	 refNo   =  null;
	/*	Column Info	*/
	private  String	 bankNm   =  null;
	/*	Column Info	*/
	private  String	 bankAcctNo   =  null;
	/*	Column Info	*/
	private  String	 mnrBilToNm   =  null;
	/*	Column Info	*/
	private  String	 mnrSwiftNo   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public ReceivableINVInquiryINVO(){}

	public ReceivableINVInquiryINVO(String userOfcCd,String fromDt,String cancelYn,String currCd,String buyerCd,String mnrGrpTpCd,String vat,String mnrPrnrCntCd,String invDueDt,String pagerows,String mnrPrnrSeq,String chgCurrCd,String vatXchRt,String ibflag,String chgXchRt,String mnrInvStsCd,String invAmt,String rcvInvSeq,String saveVndrSeq,String mnrInvRmk,String invDt,String inputInvNo,String invSchTypeCode,String mnrPrnrKndCd,String dispNo,String inputTypeCode,String dispDtlSeq,String mnrPrnrTpCd,String gAmt,String invNo,String toDt,String amt,String creUsrId,String wht,String mnrOrdSeq,String vndrSeq,String refNo,String bankNm,String bankAcctNo,String mnrBilToNm,String mnrSwiftNo)	{
		this.userOfcCd  = userOfcCd ;
		this.fromDt  = fromDt ;
		this.cancelYn  = cancelYn ;
		this.currCd  = currCd ;
		this.buyerCd  = buyerCd ;
		this.mnrGrpTpCd  = mnrGrpTpCd ;
		this.vat  = vat ;
		this.mnrPrnrCntCd  = mnrPrnrCntCd ;
		this.invDueDt  = invDueDt ;
		this.pagerows  = pagerows ;
		this.mnrPrnrSeq  = mnrPrnrSeq ;
		this.chgCurrCd  = chgCurrCd ;
		this.vatXchRt  = vatXchRt ;
		this.ibflag  = ibflag ;
		this.chgXchRt  = chgXchRt ;
		this.mnrInvStsCd  = mnrInvStsCd ;
		this.invAmt  = invAmt ;
		this.rcvInvSeq  = rcvInvSeq ;
		this.saveVndrSeq  = saveVndrSeq ;
		this.mnrInvRmk  = mnrInvRmk ;
		this.invDt  = invDt ;
		this.inputInvNo  = inputInvNo ;
		this.invSchTypeCode  = invSchTypeCode ;
		this.mnrPrnrKndCd  = mnrPrnrKndCd ;
		this.dispNo  = dispNo ;
		this.inputTypeCode  = inputTypeCode ;
		this.dispDtlSeq  = dispDtlSeq ;
		this.mnrPrnrTpCd  = mnrPrnrTpCd ;
		this.gAmt  = gAmt ;
		this.invNo  = invNo ;
		this.toDt  = toDt ;
		this.amt  = amt ;
		this.creUsrId  = creUsrId ;
		this.wht  = wht ;
		this.mnrOrdSeq  = mnrOrdSeq ;
		this.vndrSeq  = vndrSeq ;
		this.refNo  = refNo ;
		this.bankNm  = bankNm ;
		this.bankAcctNo  = bankAcctNo ;
		this.mnrBilToNm  = mnrBilToNm ;
		this.mnrSwiftNo  = mnrSwiftNo ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("user_ofc_cd", getUserOfcCd());		
		this.hashColumns.put("from_dt", getFromDt());		
		this.hashColumns.put("cancel_yn", getCancelYn());		
		this.hashColumns.put("curr_cd", getCurrCd());		
		this.hashColumns.put("buyer_cd", getBuyerCd());		
		this.hashColumns.put("mnr_grp_tp_cd", getMnrGrpTpCd());		
		this.hashColumns.put("vat", getVat());		
		this.hashColumns.put("mnr_prnr_cnt_cd", getMnrPrnrCntCd());		
		this.hashColumns.put("inv_due_dt", getInvDueDt());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("mnr_prnr_seq", getMnrPrnrSeq());		
		this.hashColumns.put("chg_curr_cd", getChgCurrCd());		
		this.hashColumns.put("vat_xch_rt", getVatXchRt());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("chg_xch_rt", getChgXchRt());		
		this.hashColumns.put("mnr_inv_sts_cd", getMnrInvStsCd());		
		this.hashColumns.put("inv_amt", getInvAmt());		
		this.hashColumns.put("rcv_inv_seq", getRcvInvSeq());		
		this.hashColumns.put("save_vndr_seq", getSaveVndrSeq());		
		this.hashColumns.put("mnr_inv_rmk", getMnrInvRmk());		
		this.hashColumns.put("inv_dt", getInvDt());		
		this.hashColumns.put("input_inv_no", getInputInvNo());		
		this.hashColumns.put("inv_sch_type_code", getInvSchTypeCode());		
		this.hashColumns.put("mnr_prnr_knd_cd", getMnrPrnrKndCd());		
		this.hashColumns.put("disp_no", getDispNo());		
		this.hashColumns.put("input_type_code", getInputTypeCode());		
		this.hashColumns.put("disp_dtl_seq", getDispDtlSeq());		
		this.hashColumns.put("mnr_prnr_tp_cd", getMnrPrnrTpCd());		
		this.hashColumns.put("g_amt", getGAmt());		
		this.hashColumns.put("inv_no", getInvNo());		
		this.hashColumns.put("to_dt", getToDt());		
		this.hashColumns.put("amt", getAmt());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("wht", getWht());		
		this.hashColumns.put("mnr_ord_seq", getMnrOrdSeq());		
		this.hashColumns.put("vndr_seq", getVndrSeq());		
		this.hashColumns.put("ref_no", getRefNo());		
		this.hashColumns.put("bank_nm", getBankNm());		
		this.hashColumns.put("bank_acct_no", getBankAcctNo());		
		this.hashColumns.put("mnr_bil_to_nm", getMnrBilToNm());		
		this.hashColumns.put("mnr_swift_no", getMnrSwiftNo());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("user_ofc_cd", "userOfcCd");
		this.hashFields.put("from_dt", "fromDt");
		this.hashFields.put("cancel_yn", "cancelYn");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("buyer_cd", "buyerCd");
		this.hashFields.put("mnr_grp_tp_cd", "mnrGrpTpCd");
		this.hashFields.put("vat", "vat");
		this.hashFields.put("mnr_prnr_cnt_cd", "mnrPrnrCntCd");
		this.hashFields.put("inv_due_dt", "invDueDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mnr_prnr_seq", "mnrPrnrSeq");
		this.hashFields.put("chg_curr_cd", "chgCurrCd");
		this.hashFields.put("vat_xch_rt", "vatXchRt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("chg_xch_rt", "chgXchRt");
		this.hashFields.put("mnr_inv_sts_cd", "mnrInvStsCd");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("rcv_inv_seq", "rcvInvSeq");
		this.hashFields.put("save_vndr_seq", "saveVndrSeq");
		this.hashFields.put("mnr_inv_rmk", "mnrInvRmk");
		this.hashFields.put("inv_dt", "invDt");
		this.hashFields.put("input_inv_no", "inputInvNo");
		this.hashFields.put("inv_sch_type_code", "invSchTypeCode");
		this.hashFields.put("mnr_prnr_knd_cd", "mnrPrnrKndCd");
		this.hashFields.put("disp_no", "dispNo");
		this.hashFields.put("input_type_code", "inputTypeCode");
		this.hashFields.put("disp_dtl_seq", "dispDtlSeq");
		this.hashFields.put("mnr_prnr_tp_cd", "mnrPrnrTpCd");
		this.hashFields.put("g_amt", "gAmt");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("amt", "amt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("wht", "wht");
		this.hashFields.put("mnr_ord_seq", "mnrOrdSeq");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("ref_no", "refNo");
		this.hashFields.put("bank_nm", "bankNm");
		this.hashFields.put("bank_acct_no", "bankAcctNo");
		this.hashFields.put("mnr_bil_to_nm", "mnrBilToNm");
		this.hashFields.put("mnr_swift_no", "mnrSwiftNo");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  userOfcCd
	*/
	public void	setUserOfcCd( String	userOfcCd ) {
		this.userOfcCd =	userOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	userOfcCd
	 */
	 public	 String	getUserOfcCd() {
		 return	this.userOfcCd;
	 } 
 	/**
	* Column Info
	* @param  fromDt
	*/
	public void	setFromDt( String	fromDt ) {
		this.fromDt =	fromDt;
	}
 
	/**
	 * Column Info
	 * @return	fromDt
	 */
	 public	 String	getFromDt() {
		 return	this.fromDt;
	 } 
 	/**
	* Column Info
	* @param  cancelYn
	*/
	public void	setCancelYn( String	cancelYn ) {
		this.cancelYn =	cancelYn;
	}
 
	/**
	 * Column Info
	 * @return	cancelYn
	 */
	 public	 String	getCancelYn() {
		 return	this.cancelYn;
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
	* @param  buyerCd
	*/
	public void	setBuyerCd( String	buyerCd ) {
		this.buyerCd =	buyerCd;
	}
 
	/**
	 * Column Info
	 * @return	buyerCd
	 */
	 public	 String	getBuyerCd() {
		 return	this.buyerCd;
	 } 
 	/**
	* Column Info
	* @param  mnrGrpTpCd
	*/
	public void	setMnrGrpTpCd( String	mnrGrpTpCd ) {
		this.mnrGrpTpCd =	mnrGrpTpCd;
	}
 
	/**
	 * Column Info
	 * @return	mnrGrpTpCd
	 */
	 public	 String	getMnrGrpTpCd() {
		 return	this.mnrGrpTpCd;
	 } 
 	/**
	* Column Info
	* @param  vat
	*/
	public void	setVat( String	vat ) {
		this.vat =	vat;
	}
 
	/**
	 * Column Info
	 * @return	vat
	 */
	 public	 String	getVat() {
		 return	this.vat;
	 } 
 	/**
	* Column Info
	* @param  mnrPrnrCntCd
	*/
	public void	setMnrPrnrCntCd( String	mnrPrnrCntCd ) {
		this.mnrPrnrCntCd =	mnrPrnrCntCd;
	}
 
	/**
	 * Column Info
	 * @return	mnrPrnrCntCd
	 */
	 public	 String	getMnrPrnrCntCd() {
		 return	this.mnrPrnrCntCd;
	 } 
 	/**
	* Column Info
	* @param  invDueDt
	*/
	public void	setInvDueDt( String	invDueDt ) {
		this.invDueDt =	invDueDt;
	}
 
	/**
	 * Column Info
	 * @return	invDueDt
	 */
	 public	 String	getInvDueDt() {
		 return	this.invDueDt;
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
	* @param  mnrPrnrSeq
	*/
	public void	setMnrPrnrSeq( String	mnrPrnrSeq ) {
		this.mnrPrnrSeq =	mnrPrnrSeq;
	}
 
	/**
	 * Column Info
	 * @return	mnrPrnrSeq
	 */
	 public	 String	getMnrPrnrSeq() {
		 return	this.mnrPrnrSeq;
	 } 
 	/**
	* Column Info
	* @param  chgCurrCd
	*/
	public void	setChgCurrCd( String	chgCurrCd ) {
		this.chgCurrCd =	chgCurrCd;
	}
 
	/**
	 * Column Info
	 * @return	chgCurrCd
	 */
	 public	 String	getChgCurrCd() {
		 return	this.chgCurrCd;
	 } 
 	/**
	* Column Info
	* @param  vatXchRt
	*/
	public void	setVatXchRt( String	vatXchRt ) {
		this.vatXchRt =	vatXchRt;
	}
 
	/**
	 * Column Info
	 * @return	vatXchRt
	 */
	 public	 String	getVatXchRt() {
		 return	this.vatXchRt;
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
	* @param  chgXchRt
	*/
	public void	setChgXchRt( String	chgXchRt ) {
		this.chgXchRt =	chgXchRt;
	}
 
	/**
	 * Column Info
	 * @return	chgXchRt
	 */
	 public	 String	getChgXchRt() {
		 return	this.chgXchRt;
	 } 
 	/**
	* Column Info
	* @param  mnrInvStsCd
	*/
	public void	setMnrInvStsCd( String	mnrInvStsCd ) {
		this.mnrInvStsCd =	mnrInvStsCd;
	}
 
	/**
	 * Column Info
	 * @return	mnrInvStsCd
	 */
	 public	 String	getMnrInvStsCd() {
		 return	this.mnrInvStsCd;
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
	* @param  rcvInvSeq
	*/
	public void	setRcvInvSeq( String	rcvInvSeq ) {
		this.rcvInvSeq =	rcvInvSeq;
	}
 
	/**
	 * Column Info
	 * @return	rcvInvSeq
	 */
	 public	 String	getRcvInvSeq() {
		 return	this.rcvInvSeq;
	 } 
 	/**
	* Column Info
	* @param  saveVndrSeq
	*/
	public void	setSaveVndrSeq( String	saveVndrSeq ) {
		this.saveVndrSeq =	saveVndrSeq;
	}
 
	/**
	 * Column Info
	 * @return	saveVndrSeq
	 */
	 public	 String	getSaveVndrSeq() {
		 return	this.saveVndrSeq;
	 } 
 	/**
	* Column Info
	* @param  mnrInvRmk
	*/
	public void	setMnrInvRmk( String	mnrInvRmk ) {
		this.mnrInvRmk =	mnrInvRmk;
	}
 
	/**
	 * Column Info
	 * @return	mnrInvRmk
	 */
	 public	 String	getMnrInvRmk() {
		 return	this.mnrInvRmk;
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
	* @param  inputInvNo
	*/
	public void	setInputInvNo( String	inputInvNo ) {
		this.inputInvNo =	inputInvNo;
	}
 
	/**
	 * Column Info
	 * @return	inputInvNo
	 */
	 public	 String	getInputInvNo() {
		 return	this.inputInvNo;
	 } 
 	/**
	* Column Info
	* @param  invSchTypeCode
	*/
	public void	setInvSchTypeCode( String	invSchTypeCode ) {
		this.invSchTypeCode =	invSchTypeCode;
	}
 
	/**
	 * Column Info
	 * @return	invSchTypeCode
	 */
	 public	 String	getInvSchTypeCode() {
		 return	this.invSchTypeCode;
	 } 
 	/**
	* Column Info
	* @param  mnrPrnrKndCd
	*/
	public void	setMnrPrnrKndCd( String	mnrPrnrKndCd ) {
		this.mnrPrnrKndCd =	mnrPrnrKndCd;
	}
 
	/**
	 * Column Info
	 * @return	mnrPrnrKndCd
	 */
	 public	 String	getMnrPrnrKndCd() {
		 return	this.mnrPrnrKndCd;
	 } 
 	/**
	* Column Info
	* @param  dispNo
	*/
	public void	setDispNo( String	dispNo ) {
		this.dispNo =	dispNo;
	}
 
	/**
	 * Column Info
	 * @return	dispNo
	 */
	 public	 String	getDispNo() {
		 return	this.dispNo;
	 } 
 	/**
	* Column Info
	* @param  inputTypeCode
	*/
	public void	setInputTypeCode( String	inputTypeCode ) {
		this.inputTypeCode =	inputTypeCode;
	}
 
	/**
	 * Column Info
	 * @return	inputTypeCode
	 */
	 public	 String	getInputTypeCode() {
		 return	this.inputTypeCode;
	 } 
 	/**
	* Column Info
	* @param  dispDtlSeq
	*/
	public void	setDispDtlSeq( String	dispDtlSeq ) {
		this.dispDtlSeq =	dispDtlSeq;
	}
 
	/**
	 * Column Info
	 * @return	dispDtlSeq
	 */
	 public	 String	getDispDtlSeq() {
		 return	this.dispDtlSeq;
	 } 
 	/**
	* Column Info
	* @param  mnrPrnrTpCd
	*/
	public void	setMnrPrnrTpCd( String	mnrPrnrTpCd ) {
		this.mnrPrnrTpCd =	mnrPrnrTpCd;
	}
 
	/**
	 * Column Info
	 * @return	mnrPrnrTpCd
	 */
	 public	 String	getMnrPrnrTpCd() {
		 return	this.mnrPrnrTpCd;
	 } 
 	/**
	* Column Info
	* @param  gAmt
	*/
	public void	setGAmt( String	gAmt ) {
		this.gAmt =	gAmt;
	}
 
	/**
	 * Column Info
	 * @return	gAmt
	 */
	 public	 String	getGAmt() {
		 return	this.gAmt;
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
	* @param  amt
	*/
	public void	setAmt( String	amt ) {
		this.amt =	amt;
	}
 
	/**
	 * Column Info
	 * @return	amt
	 */
	 public	 String	getAmt() {
		 return	this.amt;
	 } 
 	/**
	* Column Info
	* @param  creUsrId
	*/
	public void	setCreUsrId( String	creUsrId ) {
		this.creUsrId =	creUsrId;
	}
 
	/**
	 * Column Info
	 * @return	creUsrId
	 */
	 public	 String	getCreUsrId() {
		 return	this.creUsrId;
	 } 
 	/**
	* Column Info
	* @param  wht
	*/
	public void	setWht( String	wht ) {
		this.wht =	wht;
	}
 
	/**
	 * Column Info
	 * @return	wht
	 */
	 public	 String	getWht() {
		 return	this.wht;
	 } 
 	/**
	* Column Info
	* @param  mnrOrdSeq
	*/
	public void	setMnrOrdSeq( String	mnrOrdSeq ) {
		this.mnrOrdSeq =	mnrOrdSeq;
	}
 
	/**
	 * Column Info
	 * @return	mnrOrdSeq
	 */
	 public	 String	getMnrOrdSeq() {
		 return	this.mnrOrdSeq;
	 } 
 	/**
	* Column Info
	* @param  vndrSeq
	*/
	public void	setVndrSeq( String	vndrSeq ) {
		this.vndrSeq =	vndrSeq;
	}
 
	/**
	 * Column Info
	 * @return	vndrSeq
	 */
	 public	 String	getVndrSeq() {
		 return	this.vndrSeq;
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
	* @param  bankNm
	*/
	public void	setBankNm( String	bankNm ) {
		this.bankNm =	bankNm;
	}
 
	/**
	 * Column Info
	 * @return	bankNm
	 */
	 public	 String	getBankNm() {
		 return	this.bankNm;
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
	* @param  mnrBilToNm
	*/
	public void	setMnrBilToNm( String	mnrBilToNm ) {
		this.mnrBilToNm =	mnrBilToNm;
	}
 
	/**
	 * Column Info
	 * @return	mnrBilToNm
	 */
	 public	 String	getMnrBilToNm() {
		 return	this.mnrBilToNm;
	 } 
 	/**
	* Column Info
	* @param  mnrSwiftNo
	*/
	public void	setMnrSwiftNo( String	mnrSwiftNo ) {
		this.mnrSwiftNo =	mnrSwiftNo;
	}
 
	/**
	 * Column Info
	 * @return	mnrSwiftNo
	 */
	 public	 String	getMnrSwiftNo() {
		 return	this.mnrSwiftNo;
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
		setUserOfcCd(JSPUtil.getParameter(request,	prefix + "user_ofc_cd", ""));
		setFromDt(JSPUtil.getParameter(request,	prefix + "from_dt", ""));
		setCancelYn(JSPUtil.getParameter(request,	prefix + "cancel_yn", ""));
		setCurrCd(JSPUtil.getParameter(request,	prefix + "curr_cd", ""));
		setBuyerCd(JSPUtil.getParameter(request,	prefix + "buyer_cd", ""));
		setMnrGrpTpCd(JSPUtil.getParameter(request,	prefix + "mnr_grp_tp_cd", ""));
		setVat(JSPUtil.getParameter(request,	prefix + "vat", ""));
		setMnrPrnrCntCd(JSPUtil.getParameter(request,	prefix + "mnr_prnr_cnt_cd", ""));
		setInvDueDt(JSPUtil.getParameter(request,	prefix + "inv_due_dt", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setMnrPrnrSeq(JSPUtil.getParameter(request,	prefix + "mnr_prnr_seq", ""));
		setChgCurrCd(JSPUtil.getParameter(request,	prefix + "chg_curr_cd", ""));
		setVatXchRt(JSPUtil.getParameter(request,	prefix + "vat_xch_rt", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setChgXchRt(JSPUtil.getParameter(request,	prefix + "chg_xch_rt", ""));
		setMnrInvStsCd(JSPUtil.getParameter(request,	prefix + "mnr_inv_sts_cd", ""));
		setInvAmt(JSPUtil.getParameter(request,	prefix + "inv_amt", ""));
		setRcvInvSeq(JSPUtil.getParameter(request,	prefix + "rcv_inv_seq", ""));
		setSaveVndrSeq(JSPUtil.getParameter(request,	prefix + "save_vndr_seq", ""));
		setMnrInvRmk(JSPUtil.getParameter(request,	prefix + "mnr_inv_rmk", ""));
		setInvDt(JSPUtil.getParameter(request,	prefix + "inv_dt", ""));
		setInputInvNo(JSPUtil.getParameter(request,	prefix + "input_inv_no", ""));
		setInvSchTypeCode(JSPUtil.getParameter(request,	prefix + "inv_sch_type_code", ""));
		setMnrPrnrKndCd(JSPUtil.getParameter(request,	prefix + "mnr_prnr_knd_cd", ""));
		setDispNo(JSPUtil.getParameter(request,	prefix + "disp_no", ""));
		setInputTypeCode(JSPUtil.getParameter(request,	prefix + "input_type_code", ""));
		setDispDtlSeq(JSPUtil.getParameter(request,	prefix + "disp_dtl_seq", ""));
		setMnrPrnrTpCd(JSPUtil.getParameter(request,	prefix + "mnr_prnr_tp_cd", ""));
		setGAmt(JSPUtil.getParameter(request,	prefix + "g_amt", ""));
		setInvNo(JSPUtil.getParameter(request,	prefix + "inv_no", ""));
		setToDt(JSPUtil.getParameter(request,	prefix + "to_dt", ""));
		setAmt(JSPUtil.getParameter(request,	prefix + "amt", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setWht(JSPUtil.getParameter(request,	prefix + "wht", ""));
		setMnrOrdSeq(JSPUtil.getParameter(request,	prefix + "mnr_ord_seq", ""));
		setVndrSeq(JSPUtil.getParameter(request,	prefix + "vndr_seq", ""));
		setRefNo(JSPUtil.getParameter(request,	prefix + "ref_no", ""));
		setBankNm(JSPUtil.getParameter(request,	prefix + "bank_nm", ""));
		setBankAcctNo(JSPUtil.getParameter(request,	prefix + "bank_acct_no", ""));
		setMnrBilToNm(JSPUtil.getParameter(request,	prefix + "mnr_bil_to_nm", ""));
		setMnrSwiftNo(JSPUtil.getParameter(request,	prefix + "mnr_swift_no", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ReceivableINVInquiryINVO[]
	 */
	public ReceivableINVInquiryINVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return ReceivableINVInquiryINVO[]
	 */
	public ReceivableINVInquiryINVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		ReceivableINVInquiryINVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] userOfcCd =	(JSPUtil.getParameter(request, prefix +	"user_ofc_cd".trim(),	length));
				String[] fromDt =	(JSPUtil.getParameter(request, prefix +	"from_dt".trim(),	length));
				String[] cancelYn =	(JSPUtil.getParameter(request, prefix +	"cancel_yn".trim(),	length));
				String[] currCd =	(JSPUtil.getParameter(request, prefix +	"curr_cd".trim(),	length));
				String[] buyerCd =	(JSPUtil.getParameter(request, prefix +	"buyer_cd".trim(),	length));
				String[] mnrGrpTpCd =	(JSPUtil.getParameter(request, prefix +	"mnr_grp_tp_cd".trim(),	length));
				String[] vat =	(JSPUtil.getParameter(request, prefix +	"vat".trim(),	length));
				String[] mnrPrnrCntCd =	(JSPUtil.getParameter(request, prefix +	"mnr_prnr_cnt_cd".trim(),	length));
				String[] invDueDt =	(JSPUtil.getParameter(request, prefix +	"inv_due_dt".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] mnrPrnrSeq =	(JSPUtil.getParameter(request, prefix +	"mnr_prnr_seq".trim(),	length));
				String[] chgCurrCd =	(JSPUtil.getParameter(request, prefix +	"chg_curr_cd".trim(),	length));
				String[] vatXchRt =	(JSPUtil.getParameter(request, prefix +	"vat_xch_rt".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] chgXchRt =	(JSPUtil.getParameter(request, prefix +	"chg_xch_rt".trim(),	length));
				String[] mnrInvStsCd =	(JSPUtil.getParameter(request, prefix +	"mnr_inv_sts_cd".trim(),	length));
				String[] invAmt =	(JSPUtil.getParameter(request, prefix +	"inv_amt".trim(),	length));
				String[] rcvInvSeq =	(JSPUtil.getParameter(request, prefix +	"rcv_inv_seq".trim(),	length));
				String[] saveVndrSeq =	(JSPUtil.getParameter(request, prefix +	"save_vndr_seq".trim(),	length));
				String[] mnrInvRmk =	(JSPUtil.getParameter(request, prefix +	"mnr_inv_rmk".trim(),	length));
				String[] invDt =	(JSPUtil.getParameter(request, prefix +	"inv_dt".trim(),	length));
				String[] inputInvNo =	(JSPUtil.getParameter(request, prefix +	"input_inv_no".trim(),	length));
				String[] invSchTypeCode =	(JSPUtil.getParameter(request, prefix +	"inv_sch_type_code".trim(),	length));
				String[] mnrPrnrKndCd =	(JSPUtil.getParameter(request, prefix +	"mnr_prnr_knd_cd".trim(),	length));
				String[] dispNo =	(JSPUtil.getParameter(request, prefix +	"disp_no".trim(),	length));
				String[] inputTypeCode =	(JSPUtil.getParameter(request, prefix +	"input_type_code".trim(),	length));
				String[] dispDtlSeq =	(JSPUtil.getParameter(request, prefix +	"disp_dtl_seq".trim(),	length));
				String[] mnrPrnrTpCd =	(JSPUtil.getParameter(request, prefix +	"mnr_prnr_tp_cd".trim(),	length));
				String[] gAmt =	(JSPUtil.getParameter(request, prefix +	"g_amt".trim(),	length));
				String[] invNo =	(JSPUtil.getParameter(request, prefix +	"inv_no".trim(),	length));
				String[] toDt =	(JSPUtil.getParameter(request, prefix +	"to_dt".trim(),	length));
				String[] amt =	(JSPUtil.getParameter(request, prefix +	"amt".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				String[] wht =	(JSPUtil.getParameter(request, prefix +	"wht".trim(),	length));
				String[] mnrOrdSeq =	(JSPUtil.getParameter(request, prefix +	"mnr_ord_seq".trim(),	length));
				String[] vndrSeq =	(JSPUtil.getParameter(request, prefix +	"vndr_seq".trim(),	length));
				String[] refNo =	(JSPUtil.getParameter(request, prefix +	"ref_no".trim(),	length));
				String[] bankNm =	(JSPUtil.getParameter(request, prefix +	"bank_nm".trim(),	length));
				String[] bankAcctNo =	(JSPUtil.getParameter(request, prefix +	"bank_acct_no".trim(),	length));
				String[] mnrBilToNm =	(JSPUtil.getParameter(request, prefix +	"mnr_bil_to_nm".trim(),	length));
				String[] mnrSwiftNo =	(JSPUtil.getParameter(request, prefix +	"mnr_swift_no".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	ReceivableINVInquiryINVO();
						if ( userOfcCd[i] !=	null)
						model.setUserOfcCd( userOfcCd[i]);
						if ( fromDt[i] !=	null)
						model.setFromDt( fromDt[i]);
						if ( cancelYn[i] !=	null)
						model.setCancelYn( cancelYn[i]);
						if ( currCd[i] !=	null)
						model.setCurrCd( currCd[i]);
						if ( buyerCd[i] !=	null)
						model.setBuyerCd( buyerCd[i]);
						if ( mnrGrpTpCd[i] !=	null)
						model.setMnrGrpTpCd( mnrGrpTpCd[i]);
						if ( vat[i] !=	null)
						model.setVat( vat[i]);
						if ( mnrPrnrCntCd[i] !=	null)
						model.setMnrPrnrCntCd( mnrPrnrCntCd[i]);
						if ( invDueDt[i] !=	null)
						model.setInvDueDt( invDueDt[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( mnrPrnrSeq[i] !=	null)
						model.setMnrPrnrSeq( mnrPrnrSeq[i]);
						if ( chgCurrCd[i] !=	null)
						model.setChgCurrCd( chgCurrCd[i]);
						if ( vatXchRt[i] !=	null)
						model.setVatXchRt( vatXchRt[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( chgXchRt[i] !=	null)
						model.setChgXchRt( chgXchRt[i]);
						if ( mnrInvStsCd[i] !=	null)
						model.setMnrInvStsCd( mnrInvStsCd[i]);
						if ( invAmt[i] !=	null)
						model.setInvAmt( invAmt[i]);
						if ( rcvInvSeq[i] !=	null)
						model.setRcvInvSeq( rcvInvSeq[i]);
						if ( saveVndrSeq[i] !=	null)
						model.setSaveVndrSeq( saveVndrSeq[i]);
						if ( mnrInvRmk[i] !=	null)
						model.setMnrInvRmk( mnrInvRmk[i]);
						if ( invDt[i] !=	null)
						model.setInvDt( invDt[i]);
						if ( inputInvNo[i] !=	null)
						model.setInputInvNo( inputInvNo[i]);
						if ( invSchTypeCode[i] !=	null)
						model.setInvSchTypeCode( invSchTypeCode[i]);
						if ( mnrPrnrKndCd[i] !=	null)
						model.setMnrPrnrKndCd( mnrPrnrKndCd[i]);
						if ( dispNo[i] !=	null)
						model.setDispNo( dispNo[i]);
						if ( inputTypeCode[i] !=	null)
						model.setInputTypeCode( inputTypeCode[i]);
						if ( dispDtlSeq[i] !=	null)
						model.setDispDtlSeq( dispDtlSeq[i]);
						if ( mnrPrnrTpCd[i] !=	null)
						model.setMnrPrnrTpCd( mnrPrnrTpCd[i]);
						if ( gAmt[i] !=	null)
						model.setGAmt( gAmt[i]);
						if ( invNo[i] !=	null)
						model.setInvNo( invNo[i]);
						if ( toDt[i] !=	null)
						model.setToDt( toDt[i]);
						if ( amt[i] !=	null)
						model.setAmt( amt[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
						if ( wht[i] !=	null)
						model.setWht( wht[i]);
						if ( mnrOrdSeq[i] !=	null)
						model.setMnrOrdSeq( mnrOrdSeq[i]);
						if ( vndrSeq[i] !=	null)
						model.setVndrSeq( vndrSeq[i]);
						if ( refNo[i] !=	null)
						model.setRefNo( refNo[i]);
						if ( bankNm[i] !=	null)
						model.setBankNm( bankNm[i]);
						if ( bankAcctNo[i] !=	null)
						model.setBankAcctNo( bankAcctNo[i]);
						if ( mnrBilToNm[i] !=	null)
						model.setMnrBilToNm( mnrBilToNm[i]);
						if ( mnrSwiftNo[i] !=	null)
						model.setMnrSwiftNo( mnrSwiftNo[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getReceivableINVInquiryINVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return ReceivableINVInquiryINVO[]
	 */
	public ReceivableINVInquiryINVO[]	 getReceivableINVInquiryINVOs(){
		ReceivableINVInquiryINVO[] vos = (ReceivableINVInquiryINVO[])models.toArray(new	ReceivableINVInquiryINVO[models.size()]);
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
		this.userOfcCd =	this.userOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromDt =	this.fromDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cancelYn =	this.cancelYn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd =	this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.buyerCd =	this.buyerCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrGrpTpCd =	this.mnrGrpTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vat =	this.vat.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPrnrCntCd =	this.mnrPrnrCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDueDt =	this.invDueDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPrnrSeq =	this.mnrPrnrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCurrCd =	this.chgCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vatXchRt =	this.vatXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgXchRt =	this.chgXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrInvStsCd =	this.mnrInvStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt =	this.invAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvInvSeq =	this.rcvInvSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.saveVndrSeq =	this.saveVndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrInvRmk =	this.mnrInvRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDt =	this.invDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inputInvNo =	this.inputInvNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSchTypeCode =	this.invSchTypeCode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPrnrKndCd =	this.mnrPrnrKndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispNo =	this.dispNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inputTypeCode =	this.inputTypeCode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispDtlSeq =	this.dispDtlSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPrnrTpCd =	this.mnrPrnrTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gAmt =	this.gAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo =	this.invNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt =	this.toDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt =	this.amt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wht =	this.wht.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrOrdSeq =	this.mnrOrdSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq =	this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refNo =	this.refNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankNm =	this.bankNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankAcctNo =	this.bankAcctNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrBilToNm =	this.mnrBilToNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrSwiftNo =	this.mnrSwiftNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}