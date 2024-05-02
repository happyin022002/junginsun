/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : CustomReceivableINVInquiryListVO.java
 *@FileTitle : CustomReceivableINVInquiryListVO
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
public class CustomReceivableINVInquiryListVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<CustomReceivableINVInquiryListVO>  models =	new	ArrayList<CustomReceivableINVInquiryListVO>();


	/*	Column Info	*/
	private  String	 bankAcctNo   =  null;
	/*	Column Info	*/
	private  String	 currCd   =  null;
	/*	Column Info	*/
	private  String	 buyerCd   =  null;
	/*	Column Info	*/
	private  String	 issOfcCd   =  null;
	/*	Column Info	*/
	private  String	 mnrPrnrCntCd   =  null;
	/*	Column Info	*/
	private  String	 vat   =  null;
	/*	Column Info	*/
	private  String	 dispQty   =  null;
	/*	Column Info	*/
	private  String	 ttlAmt   =  null;
	/*	Column Info	*/
	private  String	 invDueDt   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 dpPrcsKnt   =  null;
	/*	Column Info	*/
	private  String	 mnrPrnrSeq   =  null;
	/*	Column Info	*/
	private  String	 chgCurrCd   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 vatXchRt   =  null;
	/*	Column Info	*/
	private  String	 chgXchRt   =  null;
	/*	Column Info	*/
	private  String	 mnrInvStsCd   =  null;
	/*	Column Info	*/
	private  String	 mnrPrnrKndNm   =  null;
	/*	Column Info	*/
	private  String	 mnrInvStsNm   =  null;
	/*	Column Info	*/
	private  String	 bankNm   =  null;
	/*	Column Info	*/
	private  String	 partAmt   =  null;
	/*	Column Info	*/
	private  String	 rcvInvSeq   =  null;
	/*	Column Info	*/
	private  String	 invAmt   =  null;
	/*	Column Info	*/
	private  String	 vatDpPrcsKnt   =  null;
	/*	Column Info	*/
	private  String	 mnrInvRmk   =  null;
	/*	Column Info	*/
	private  String	 invDt   =  null;
	/*	Column Info	*/
	private  String	 mnrPrnrKndCd   =  null;
	/*	Column Info	*/
	private  String	 dispNo   =  null;
	/*	Column Info	*/
	private  String	 mnrPrnrLglEngNm   =  null;
	/*	Column Info	*/
	private  String	 mnrPrnrTpCd   =  null;
	/*	Column Info	*/
	private  String	 mnrInvRefNo   =  null;
	/*	Column Info	*/
	private  String	 aproDt   =  null;
	/*	Column Info	*/
	private  String	 invNo   =  null;
	/*	Column Info	*/
	private  String	 wht   =  null;
	/*	Column Info	*/
	private  String	 gVatCurrAmt   =  null;
	/*	Column Info	*/
	private  String	 mnrBilToNm   =  null;
	/*	Column Info	*/
	private  String	 mnrSwiftNo   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public CustomReceivableINVInquiryListVO(){}

	public CustomReceivableINVInquiryListVO(String bankAcctNo,String currCd,String buyerCd,String issOfcCd,String mnrPrnrCntCd,String vat,String dispQty,String ttlAmt,String invDueDt,String pagerows,String dpPrcsKnt,String mnrPrnrSeq,String chgCurrCd,String ibflag,String vatXchRt,String chgXchRt,String mnrInvStsCd,String mnrPrnrKndNm,String mnrInvStsNm,String bankNm,String partAmt,String rcvInvSeq,String invAmt,String vatDpPrcsKnt,String mnrInvRmk,String invDt,String mnrPrnrKndCd,String dispNo,String mnrPrnrLglEngNm,String mnrPrnrTpCd,String mnrInvRefNo,String aproDt,String invNo,String wht,String gVatCurrAmt,String mnrBilToNm,String mnrSwiftNo)	{
		this.bankAcctNo  = bankAcctNo ;
		this.currCd  = currCd ;
		this.buyerCd  = buyerCd ;
		this.issOfcCd  = issOfcCd ;
		this.mnrPrnrCntCd  = mnrPrnrCntCd ;
		this.vat  = vat ;
		this.dispQty  = dispQty ;
		this.ttlAmt  = ttlAmt ;
		this.invDueDt  = invDueDt ;
		this.pagerows  = pagerows ;
		this.dpPrcsKnt  = dpPrcsKnt ;
		this.mnrPrnrSeq  = mnrPrnrSeq ;
		this.chgCurrCd  = chgCurrCd ;
		this.ibflag  = ibflag ;
		this.vatXchRt  = vatXchRt ;
		this.chgXchRt  = chgXchRt ;
		this.mnrInvStsCd  = mnrInvStsCd ;
		this.mnrPrnrKndNm  = mnrPrnrKndNm ;
		this.mnrInvStsNm  = mnrInvStsNm ;
		this.bankNm  = bankNm ;
		this.partAmt  = partAmt ;
		this.rcvInvSeq  = rcvInvSeq ;
		this.invAmt  = invAmt ;
		this.vatDpPrcsKnt  = vatDpPrcsKnt ;
		this.mnrInvRmk  = mnrInvRmk ;
		this.invDt  = invDt ;
		this.mnrPrnrKndCd  = mnrPrnrKndCd ;
		this.dispNo  = dispNo ;
		this.mnrPrnrLglEngNm  = mnrPrnrLglEngNm ;
		this.mnrPrnrTpCd  = mnrPrnrTpCd ;
		this.mnrInvRefNo  = mnrInvRefNo ;
		this.aproDt  = aproDt ;
		this.invNo  = invNo ;
		this.wht  = wht ;
		this.gVatCurrAmt  = gVatCurrAmt ;
		this.mnrBilToNm  = mnrBilToNm ;
		this.mnrSwiftNo  = mnrSwiftNo ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bank_acct_no", getBankAcctNo());		
		this.hashColumns.put("curr_cd", getCurrCd());		
		this.hashColumns.put("buyer_cd", getBuyerCd());		
		this.hashColumns.put("iss_ofc_cd", getIssOfcCd());		
		this.hashColumns.put("mnr_prnr_cnt_cd", getMnrPrnrCntCd());		
		this.hashColumns.put("vat", getVat());		
		this.hashColumns.put("disp_qty", getDispQty());		
		this.hashColumns.put("ttl_amt", getTtlAmt());		
		this.hashColumns.put("inv_due_dt", getInvDueDt());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("dp_prcs_knt", getDpPrcsKnt());		
		this.hashColumns.put("mnr_prnr_seq", getMnrPrnrSeq());		
		this.hashColumns.put("chg_curr_cd", getChgCurrCd());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("vat_xch_rt", getVatXchRt());		
		this.hashColumns.put("chg_xch_rt", getChgXchRt());		
		this.hashColumns.put("mnr_inv_sts_cd", getMnrInvStsCd());		
		this.hashColumns.put("mnr_prnr_knd_nm", getMnrPrnrKndNm());		
		this.hashColumns.put("mnr_inv_sts_nm", getMnrInvStsNm());		
		this.hashColumns.put("bank_nm", getBankNm());		
		this.hashColumns.put("part_amt", getPartAmt());		
		this.hashColumns.put("rcv_inv_seq", getRcvInvSeq());		
		this.hashColumns.put("inv_amt", getInvAmt());		
		this.hashColumns.put("vat_dp_prcs_knt", getVatDpPrcsKnt());		
		this.hashColumns.put("mnr_inv_rmk", getMnrInvRmk());		
		this.hashColumns.put("inv_dt", getInvDt());		
		this.hashColumns.put("mnr_prnr_knd_cd", getMnrPrnrKndCd());		
		this.hashColumns.put("disp_no", getDispNo());		
		this.hashColumns.put("mnr_prnr_lgl_eng_nm", getMnrPrnrLglEngNm());		
		this.hashColumns.put("mnr_prnr_tp_cd", getMnrPrnrTpCd());		
		this.hashColumns.put("mnr_inv_ref_no", getMnrInvRefNo());		
		this.hashColumns.put("apro_dt", getAproDt());		
		this.hashColumns.put("inv_no", getInvNo());		
		this.hashColumns.put("wht", getWht());		
		this.hashColumns.put("g_vat_curr_amt", getGVatCurrAmt());		
		this.hashColumns.put("mnr_bil_to_nm", getMnrBilToNm());		
		this.hashColumns.put("mnr_swift_no", getMnrSwiftNo());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("bank_acct_no", "bankAcctNo");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("buyer_cd", "buyerCd");
		this.hashFields.put("iss_ofc_cd", "issOfcCd");
		this.hashFields.put("mnr_prnr_cnt_cd", "mnrPrnrCntCd");
		this.hashFields.put("vat", "vat");
		this.hashFields.put("disp_qty", "dispQty");
		this.hashFields.put("ttl_amt", "ttlAmt");
		this.hashFields.put("inv_due_dt", "invDueDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dp_prcs_knt", "dpPrcsKnt");
		this.hashFields.put("mnr_prnr_seq", "mnrPrnrSeq");
		this.hashFields.put("chg_curr_cd", "chgCurrCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vat_xch_rt", "vatXchRt");
		this.hashFields.put("chg_xch_rt", "chgXchRt");
		this.hashFields.put("mnr_inv_sts_cd", "mnrInvStsCd");
		this.hashFields.put("mnr_prnr_knd_nm", "mnrPrnrKndNm");
		this.hashFields.put("mnr_inv_sts_nm", "mnrInvStsNm");
		this.hashFields.put("bank_nm", "bankNm");
		this.hashFields.put("part_amt", "partAmt");
		this.hashFields.put("rcv_inv_seq", "rcvInvSeq");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("vat_dp_prcs_knt", "vatDpPrcsKnt");
		this.hashFields.put("mnr_inv_rmk", "mnrInvRmk");
		this.hashFields.put("inv_dt", "invDt");
		this.hashFields.put("mnr_prnr_knd_cd", "mnrPrnrKndCd");
		this.hashFields.put("disp_no", "dispNo");
		this.hashFields.put("mnr_prnr_lgl_eng_nm", "mnrPrnrLglEngNm");
		this.hashFields.put("mnr_prnr_tp_cd", "mnrPrnrTpCd");
		this.hashFields.put("mnr_inv_ref_no", "mnrInvRefNo");
		this.hashFields.put("apro_dt", "aproDt");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("wht", "wht");
		this.hashFields.put("g_vat_curr_amt", "gVatCurrAmt");
		this.hashFields.put("mnr_bil_to_nm", "mnrBilToNm");
		this.hashFields.put("mnr_swift_no", "mnrSwiftNo");
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
	* @param  issOfcCd
	*/
	public void	setIssOfcCd( String	issOfcCd ) {
		this.issOfcCd =	issOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	issOfcCd
	 */
	 public	 String	getIssOfcCd() {
		 return	this.issOfcCd;
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
	* @param  dispQty
	*/
	public void	setDispQty( String	dispQty ) {
		this.dispQty =	dispQty;
	}
 
	/**
	 * Column Info
	 * @return	dispQty
	 */
	 public	 String	getDispQty() {
		 return	this.dispQty;
	 } 
 	/**
	* Column Info
	* @param  ttlAmt
	*/
	public void	setTtlAmt( String	ttlAmt ) {
		this.ttlAmt =	ttlAmt;
	}
 
	/**
	 * Column Info
	 * @return	ttlAmt
	 */
	 public	 String	getTtlAmt() {
		 return	this.ttlAmt;
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
	* @param  dpPrcsKnt
	*/
	public void	setDpPrcsKnt( String	dpPrcsKnt ) {
		this.dpPrcsKnt =	dpPrcsKnt;
	}
 
	/**
	 * Column Info
	 * @return	dpPrcsKnt
	 */
	 public	 String	getDpPrcsKnt() {
		 return	this.dpPrcsKnt;
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
	* @param  mnrPrnrKndNm
	*/
	public void	setMnrPrnrKndNm( String	mnrPrnrKndNm ) {
		this.mnrPrnrKndNm =	mnrPrnrKndNm;
	}
 
	/**
	 * Column Info
	 * @return	mnrPrnrKndNm
	 */
	 public	 String	getMnrPrnrKndNm() {
		 return	this.mnrPrnrKndNm;
	 } 
 	/**
	* Column Info
	* @param  mnrInvStsNm
	*/
	public void	setMnrInvStsNm( String	mnrInvStsNm ) {
		this.mnrInvStsNm =	mnrInvStsNm;
	}
 
	/**
	 * Column Info
	 * @return	mnrInvStsNm
	 */
	 public	 String	getMnrInvStsNm() {
		 return	this.mnrInvStsNm;
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
	* @param  partAmt
	*/
	public void	setPartAmt( String	partAmt ) {
		this.partAmt =	partAmt;
	}
 
	/**
	 * Column Info
	 * @return	partAmt
	 */
	 public	 String	getPartAmt() {
		 return	this.partAmt;
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
	* @param  vatDpPrcsKnt
	*/
	public void	setVatDpPrcsKnt( String	vatDpPrcsKnt ) {
		this.vatDpPrcsKnt =	vatDpPrcsKnt;
	}
 
	/**
	 * Column Info
	 * @return	vatDpPrcsKnt
	 */
	 public	 String	getVatDpPrcsKnt() {
		 return	this.vatDpPrcsKnt;
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
	* @param  mnrPrnrLglEngNm
	*/
	public void	setMnrPrnrLglEngNm( String	mnrPrnrLglEngNm ) {
		this.mnrPrnrLglEngNm =	mnrPrnrLglEngNm;
	}
 
	/**
	 * Column Info
	 * @return	mnrPrnrLglEngNm
	 */
	 public	 String	getMnrPrnrLglEngNm() {
		 return	this.mnrPrnrLglEngNm;
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
	* @param  mnrInvRefNo
	*/
	public void	setMnrInvRefNo( String	mnrInvRefNo ) {
		this.mnrInvRefNo =	mnrInvRefNo;
	}
 
	/**
	 * Column Info
	 * @return	mnrInvRefNo
	 */
	 public	 String	getMnrInvRefNo() {
		 return	this.mnrInvRefNo;
	 } 
 	/**
	* Column Info
	* @param  aproDt
	*/
	public void	setAproDt( String	aproDt ) {
		this.aproDt =	aproDt;
	}
 
	/**
	 * Column Info
	 * @return	aproDt
	 */
	 public	 String	getAproDt() {
		 return	this.aproDt;
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
	* @param  gVatCurrAmt
	*/
	public void	setGVatCurrAmt( String	gVatCurrAmt ) {
		this.gVatCurrAmt =	gVatCurrAmt;
	}
 
	/**
	 * Column Info
	 * @return	gVatCurrAmt
	 */
	 public	 String	getGVatCurrAmt() {
		 return	this.gVatCurrAmt;
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
		setBankAcctNo(JSPUtil.getParameter(request,	prefix + "bank_acct_no", ""));
		setCurrCd(JSPUtil.getParameter(request,	prefix + "curr_cd", ""));
		setBuyerCd(JSPUtil.getParameter(request,	prefix + "buyer_cd", ""));
		setIssOfcCd(JSPUtil.getParameter(request,	prefix + "iss_ofc_cd", ""));
		setMnrPrnrCntCd(JSPUtil.getParameter(request,	prefix + "mnr_prnr_cnt_cd", ""));
		setVat(JSPUtil.getParameter(request,	prefix + "vat", ""));
		setDispQty(JSPUtil.getParameter(request,	prefix + "disp_qty", ""));
		setTtlAmt(JSPUtil.getParameter(request,	prefix + "ttl_amt", ""));
		setInvDueDt(JSPUtil.getParameter(request,	prefix + "inv_due_dt", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setDpPrcsKnt(JSPUtil.getParameter(request,	prefix + "dp_prcs_knt", ""));
		setMnrPrnrSeq(JSPUtil.getParameter(request,	prefix + "mnr_prnr_seq", ""));
		setChgCurrCd(JSPUtil.getParameter(request,	prefix + "chg_curr_cd", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setVatXchRt(JSPUtil.getParameter(request,	prefix + "vat_xch_rt", ""));
		setChgXchRt(JSPUtil.getParameter(request,	prefix + "chg_xch_rt", ""));
		setMnrInvStsCd(JSPUtil.getParameter(request,	prefix + "mnr_inv_sts_cd", ""));
		setMnrPrnrKndNm(JSPUtil.getParameter(request,	prefix + "mnr_prnr_knd_nm", ""));
		setMnrInvStsNm(JSPUtil.getParameter(request,	prefix + "mnr_inv_sts_nm", ""));
		setBankNm(JSPUtil.getParameter(request,	prefix + "bank_nm", ""));
		setPartAmt(JSPUtil.getParameter(request,	prefix + "part_amt", ""));
		setRcvInvSeq(JSPUtil.getParameter(request,	prefix + "rcv_inv_seq", ""));
		setInvAmt(JSPUtil.getParameter(request,	prefix + "inv_amt", ""));
		setVatDpPrcsKnt(JSPUtil.getParameter(request,	prefix + "vat_dp_prcs_knt", ""));
		setMnrInvRmk(JSPUtil.getParameter(request,	prefix + "mnr_inv_rmk", ""));
		setInvDt(JSPUtil.getParameter(request,	prefix + "inv_dt", ""));
		setMnrPrnrKndCd(JSPUtil.getParameter(request,	prefix + "mnr_prnr_knd_cd", ""));
		setDispNo(JSPUtil.getParameter(request,	prefix + "disp_no", ""));
		setMnrPrnrLglEngNm(JSPUtil.getParameter(request,	prefix + "mnr_prnr_lgl_eng_nm", ""));
		setMnrPrnrTpCd(JSPUtil.getParameter(request,	prefix + "mnr_prnr_tp_cd", ""));
		setMnrInvRefNo(JSPUtil.getParameter(request,	prefix + "mnr_inv_ref_no", ""));
		setAproDt(JSPUtil.getParameter(request,	prefix + "apro_dt", ""));
		setInvNo(JSPUtil.getParameter(request,	prefix + "inv_no", ""));
		setWht(JSPUtil.getParameter(request,	prefix + "wht", ""));
		setGVatCurrAmt(JSPUtil.getParameter(request,	prefix + "g_vat_curr_amt", ""));
		setMnrBilToNm(JSPUtil.getParameter(request,	prefix + "mnr_bil_to_nm", ""));
		setMnrSwiftNo(JSPUtil.getParameter(request,	prefix + "mnr_swift_no", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomReceivableINVInquiryListVO[]
	 */
	public CustomReceivableINVInquiryListVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return CustomReceivableINVInquiryListVO[]
	 */
	public CustomReceivableINVInquiryListVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		CustomReceivableINVInquiryListVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] bankAcctNo =	(JSPUtil.getParameter(request, prefix +	"bank_acct_no".trim(),	length));
				String[] currCd =	(JSPUtil.getParameter(request, prefix +	"curr_cd".trim(),	length));
				String[] buyerCd =	(JSPUtil.getParameter(request, prefix +	"buyer_cd".trim(),	length));
				String[] issOfcCd =	(JSPUtil.getParameter(request, prefix +	"iss_ofc_cd".trim(),	length));
				String[] mnrPrnrCntCd =	(JSPUtil.getParameter(request, prefix +	"mnr_prnr_cnt_cd".trim(),	length));
				String[] vat =	(JSPUtil.getParameter(request, prefix +	"vat".trim(),	length));
				String[] dispQty =	(JSPUtil.getParameter(request, prefix +	"disp_qty".trim(),	length));
				String[] ttlAmt =	(JSPUtil.getParameter(request, prefix +	"ttl_amt".trim(),	length));
				String[] invDueDt =	(JSPUtil.getParameter(request, prefix +	"inv_due_dt".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] dpPrcsKnt =	(JSPUtil.getParameter(request, prefix +	"dp_prcs_knt".trim(),	length));
				String[] mnrPrnrSeq =	(JSPUtil.getParameter(request, prefix +	"mnr_prnr_seq".trim(),	length));
				String[] chgCurrCd =	(JSPUtil.getParameter(request, prefix +	"chg_curr_cd".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] vatXchRt =	(JSPUtil.getParameter(request, prefix +	"vat_xch_rt".trim(),	length));
				String[] chgXchRt =	(JSPUtil.getParameter(request, prefix +	"chg_xch_rt".trim(),	length));
				String[] mnrInvStsCd =	(JSPUtil.getParameter(request, prefix +	"mnr_inv_sts_cd".trim(),	length));
				String[] mnrPrnrKndNm =	(JSPUtil.getParameter(request, prefix +	"mnr_prnr_knd_nm".trim(),	length));
				String[] mnrInvStsNm =	(JSPUtil.getParameter(request, prefix +	"mnr_inv_sts_nm".trim(),	length));
				String[] bankNm =	(JSPUtil.getParameter(request, prefix +	"bank_nm".trim(),	length));
				String[] partAmt =	(JSPUtil.getParameter(request, prefix +	"part_amt".trim(),	length));
				String[] rcvInvSeq =	(JSPUtil.getParameter(request, prefix +	"rcv_inv_seq".trim(),	length));
				String[] invAmt =	(JSPUtil.getParameter(request, prefix +	"inv_amt".trim(),	length));
				String[] vatDpPrcsKnt =	(JSPUtil.getParameter(request, prefix +	"vat_dp_prcs_knt".trim(),	length));
				String[] mnrInvRmk =	(JSPUtil.getParameter(request, prefix +	"mnr_inv_rmk".trim(),	length));
				String[] invDt =	(JSPUtil.getParameter(request, prefix +	"inv_dt".trim(),	length));
				String[] mnrPrnrKndCd =	(JSPUtil.getParameter(request, prefix +	"mnr_prnr_knd_cd".trim(),	length));
				String[] dispNo =	(JSPUtil.getParameter(request, prefix +	"disp_no".trim(),	length));
				String[] mnrPrnrLglEngNm =	(JSPUtil.getParameter(request, prefix +	"mnr_prnr_lgl_eng_nm".trim(),	length));
				String[] mnrPrnrTpCd =	(JSPUtil.getParameter(request, prefix +	"mnr_prnr_tp_cd".trim(),	length));
				String[] mnrInvRefNo =	(JSPUtil.getParameter(request, prefix +	"mnr_inv_ref_no".trim(),	length));
				String[] aproDt =	(JSPUtil.getParameter(request, prefix +	"apro_dt".trim(),	length));
				String[] invNo =	(JSPUtil.getParameter(request, prefix +	"inv_no".trim(),	length));
				String[] wht =	(JSPUtil.getParameter(request, prefix +	"wht".trim(),	length));
				String[] gVatCurrAmt =	(JSPUtil.getParameter(request, prefix +	"g_vat_curr_amt".trim(),	length));
				String[] mnrBilToNm =	(JSPUtil.getParameter(request, prefix +	"mnr_bil_to_nm".trim(),	length));
				String[] mnrSwiftNo =	(JSPUtil.getParameter(request, prefix +	"mnr_swift_no".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	CustomReceivableINVInquiryListVO();
						if ( bankAcctNo[i] !=	null)
						model.setBankAcctNo( bankAcctNo[i]);
						if ( currCd[i] !=	null)
						model.setCurrCd( currCd[i]);
						if ( buyerCd[i] !=	null)
						model.setBuyerCd( buyerCd[i]);
						if ( issOfcCd[i] !=	null)
						model.setIssOfcCd( issOfcCd[i]);
						if ( mnrPrnrCntCd[i] !=	null)
						model.setMnrPrnrCntCd( mnrPrnrCntCd[i]);
						if ( vat[i] !=	null)
						model.setVat( vat[i]);
						if ( dispQty[i] !=	null)
						model.setDispQty( dispQty[i]);
						if ( ttlAmt[i] !=	null)
						model.setTtlAmt( ttlAmt[i]);
						if ( invDueDt[i] !=	null)
						model.setInvDueDt( invDueDt[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( dpPrcsKnt[i] !=	null)
						model.setDpPrcsKnt( dpPrcsKnt[i]);
						if ( mnrPrnrSeq[i] !=	null)
						model.setMnrPrnrSeq( mnrPrnrSeq[i]);
						if ( chgCurrCd[i] !=	null)
						model.setChgCurrCd( chgCurrCd[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( vatXchRt[i] !=	null)
						model.setVatXchRt( vatXchRt[i]);
						if ( chgXchRt[i] !=	null)
						model.setChgXchRt( chgXchRt[i]);
						if ( mnrInvStsCd[i] !=	null)
						model.setMnrInvStsCd( mnrInvStsCd[i]);
						if ( mnrPrnrKndNm[i] !=	null)
						model.setMnrPrnrKndNm( mnrPrnrKndNm[i]);
						if ( mnrInvStsNm[i] !=	null)
						model.setMnrInvStsNm( mnrInvStsNm[i]);
						if ( bankNm[i] !=	null)
						model.setBankNm( bankNm[i]);
						if ( partAmt[i] !=	null)
						model.setPartAmt( partAmt[i]);
						if ( rcvInvSeq[i] !=	null)
						model.setRcvInvSeq( rcvInvSeq[i]);
						if ( invAmt[i] !=	null)
						model.setInvAmt( invAmt[i]);
						if ( vatDpPrcsKnt[i] !=	null)
						model.setVatDpPrcsKnt( vatDpPrcsKnt[i]);
						if ( mnrInvRmk[i] !=	null)
						model.setMnrInvRmk( mnrInvRmk[i]);
						if ( invDt[i] !=	null)
						model.setInvDt( invDt[i]);
						if ( mnrPrnrKndCd[i] !=	null)
						model.setMnrPrnrKndCd( mnrPrnrKndCd[i]);
						if ( dispNo[i] !=	null)
						model.setDispNo( dispNo[i]);
						if ( mnrPrnrLglEngNm[i] !=	null)
						model.setMnrPrnrLglEngNm( mnrPrnrLglEngNm[i]);
						if ( mnrPrnrTpCd[i] !=	null)
						model.setMnrPrnrTpCd( mnrPrnrTpCd[i]);
						if ( mnrInvRefNo[i] !=	null)
						model.setMnrInvRefNo( mnrInvRefNo[i]);
						if ( aproDt[i] !=	null)
						model.setAproDt( aproDt[i]);
						if ( invNo[i] !=	null)
						model.setInvNo( invNo[i]);
						if ( wht[i] !=	null)
						model.setWht( wht[i]);
						if ( gVatCurrAmt[i] !=	null)
						model.setGVatCurrAmt( gVatCurrAmt[i]);
						if ( mnrBilToNm[i] !=	null)
						model.setMnrBilToNm( mnrBilToNm[i]);
						if ( mnrSwiftNo[i] !=	null)
						model.setMnrSwiftNo( mnrSwiftNo[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getCustomReceivableINVInquiryListVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return CustomReceivableINVInquiryListVO[]
	 */
	public CustomReceivableINVInquiryListVO[]	 getCustomReceivableINVInquiryListVOs(){
		CustomReceivableINVInquiryListVO[] vos = (CustomReceivableINVInquiryListVO[])models.toArray(new	CustomReceivableINVInquiryListVO[models.size()]);
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
		this.bankAcctNo =	this.bankAcctNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd =	this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.buyerCd =	this.buyerCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issOfcCd =	this.issOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPrnrCntCd =	this.mnrPrnrCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vat =	this.vat.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispQty =	this.dispQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlAmt =	this.ttlAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDueDt =	this.invDueDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpPrcsKnt =	this.dpPrcsKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPrnrSeq =	this.mnrPrnrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCurrCd =	this.chgCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vatXchRt =	this.vatXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgXchRt =	this.chgXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrInvStsCd =	this.mnrInvStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPrnrKndNm =	this.mnrPrnrKndNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrInvStsNm =	this.mnrInvStsNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankNm =	this.bankNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.partAmt =	this.partAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvInvSeq =	this.rcvInvSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt =	this.invAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vatDpPrcsKnt =	this.vatDpPrcsKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrInvRmk =	this.mnrInvRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDt =	this.invDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPrnrKndCd =	this.mnrPrnrKndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispNo =	this.dispNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPrnrLglEngNm =	this.mnrPrnrLglEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPrnrTpCd =	this.mnrPrnrTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrInvRefNo =	this.mnrInvRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproDt =	this.aproDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo =	this.invNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wht =	this.wht.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gVatCurrAmt =	this.gVatCurrAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrBilToNm =	this.mnrBilToNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrSwiftNo =	this.mnrSwiftNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}