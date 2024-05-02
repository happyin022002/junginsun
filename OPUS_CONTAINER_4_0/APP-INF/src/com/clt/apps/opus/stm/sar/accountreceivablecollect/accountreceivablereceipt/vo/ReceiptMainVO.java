/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ReceiptMainVO.java
 *@FileTitle : ReceiptMainVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.12.26
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2014.12.26  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo;

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
 * - 愿�젴	Event�먯꽌	�묒꽦,	�쒕쾭�ㅽ뻾�붿껌��PDTO����븷���섑뻾�섎뒗 Value Object<br>
 * 
 * @author 
 * @since J2EE 1.6
 * @see	..
 */
public class ReceiptMainVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<ReceiptMainVO>  models =	new	ArrayList<ReceiptMainVO>();


	/*	Column Info	*/
	private  String	 rctOfcCd   =  null;
	/*	Column Info	*/
	private  String	 balRctAmt   =  null;
	/*	Column Info	*/
	private  String	 bfrBalRctAmt   =  null;
	/*	Column Info	*/
	private  String	 creDt   =  null;
	/*	Column Info	*/
	private  String	 fncCurrScale   =  null;
	/*	Column Info	*/
	private  String	 appAmt   =  null;
	/*	Column Info	*/
	private  String	 ttlAmt   =  null;
	/*	Column Info	*/
	private  String	 mtrtyDt   =  null;
	/*	Column Info	*/
	private  String	 rctCxlRsnCd   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 dpPrcsKnt   =  null;
	/*	Column Info	*/
	private  String	 agnCd   =  null;
	/*	Column Info	*/
	private  String	 rctCurrCd   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 rctPrnFlg   =  null;
	/*	Column Info	*/
	private  String	 cxlDesc   =  null;
	/*	Column Info	*/
	private  String	 rctSeq   =  null;
	/*	Column Info	*/
	private  String	 rctCustCntCd   =  null;
	/*	Column Info	*/
	private  String	 rctDpsDt   =  null;
	/*	Column Info	*/
	private  String	 rctCxlRmk   =  null;
	/*	Column Info	*/
	private  String	 bankAcctNm   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 updDt   =  null;
	/*	Column Info	*/
	private  String	 bankAcctSeq   =  null;
	/*	Column Info	*/
	private  String	 chqNo   =  null;
	/*	Column Info	*/
	private  String	 rctAmt   =  null;
	/*	Column Info	*/
	private  String	 rctRmk   =  null;
	/*	Column Info	*/
	private  String	 unidAmt   =  null;
	/*	Column Info	*/
	private  String	 agnOfcCd   =  null;
	/*	Column Info	*/
	private  String	 unappAmt   =  null;
	/*	Column Info	*/
	private  String	 rctCxlDt   =  null;
	/*	Column Info	*/
	private  String	 rctCxlCateCd   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;
	/*	Column Info	*/
	private  String	 rctCustSeq   =  null;
	/*	Column Info	*/
	private  String	 otsOfcCd   =  null;
	/*	Column Info	*/
	private  String	 rctTpCd   =  null;
	/*	Column Info	*/
	private  String	 rctDt   =  null;
	/*	Column Info	*/
	private  String	 rvsAllFlg   =  null;
	/*	Column Info	*/
	private  String	 asaNo   =  null;
	/*	Column Info	*/
	private  String	 bankChgAmt   =  null;
	/*	Column Info	*/
	private  String	 newRctFlg   =  null;
	/*	Column Info	*/
	private  String	 saveKindCd   =  null;
	/*	Column Info	*/
	private  String	 rctStsCd   =  null;
	/*	Column Info	*/
	private  String	 rctNo   =  null;
	/*	Column Info	*/
	private  String	 bfrCustCntCd   =  null;
	/*	Column Info	*/
	private  String	 bfrCustSeq   =  null;
	/*	Column Info	*/
	private  String	 localChgFlag   =  null;
	/*	Column Info	*/
	private  String	 boundType   =  null;
	/*	Column Info	*/
	private  String	 invoiceType   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public ReceiptMainVO(){}

	public ReceiptMainVO(String rctOfcCd,String balRctAmt,String bfrBalRctAmt,String creDt,String fncCurrScale,String appAmt,String ttlAmt,String mtrtyDt,String rctCxlRsnCd,String pagerows,String dpPrcsKnt,String agnCd,String rctCurrCd,String ibflag,String rctPrnFlg,String cxlDesc,String rctSeq,String rctCustCntCd,String rctDpsDt,String rctCxlRmk,String bankAcctNm,String updUsrId,String updDt,String bankAcctSeq,String chqNo,String rctAmt,String rctRmk,String unidAmt,String agnOfcCd,String unappAmt,String rctCxlDt,String rctCxlCateCd,String creUsrId,String rctCustSeq,String otsOfcCd,String rctTpCd,String rctDt,String rvsAllFlg,String asaNo,String bankChgAmt,String newRctFlg,String saveKindCd,String rctStsCd,String rctNo,String bfrCustCntCd,String bfrCustSeq,String localChgFlag,String boundType,String invoiceType)	{
		this.rctOfcCd  = rctOfcCd ;
		this.balRctAmt  = balRctAmt ;
		this.bfrBalRctAmt  = bfrBalRctAmt ;
		this.creDt  = creDt ;
		this.fncCurrScale  = fncCurrScale ;
		this.appAmt  = appAmt ;
		this.ttlAmt  = ttlAmt ;
		this.mtrtyDt  = mtrtyDt ;
		this.rctCxlRsnCd  = rctCxlRsnCd ;
		this.pagerows  = pagerows ;
		this.dpPrcsKnt  = dpPrcsKnt ;
		this.agnCd  = agnCd ;
		this.rctCurrCd  = rctCurrCd ;
		this.ibflag  = ibflag ;
		this.rctPrnFlg  = rctPrnFlg ;
		this.cxlDesc  = cxlDesc ;
		this.rctSeq  = rctSeq ;
		this.rctCustCntCd  = rctCustCntCd ;
		this.rctDpsDt  = rctDpsDt ;
		this.rctCxlRmk  = rctCxlRmk ;
		this.bankAcctNm  = bankAcctNm ;
		this.updUsrId  = updUsrId ;
		this.updDt  = updDt ;
		this.bankAcctSeq  = bankAcctSeq ;
		this.chqNo  = chqNo ;
		this.rctAmt  = rctAmt ;
		this.rctRmk  = rctRmk ;
		this.unidAmt  = unidAmt ;
		this.agnOfcCd  = agnOfcCd ;
		this.unappAmt  = unappAmt ;
		this.rctCxlDt  = rctCxlDt ;
		this.rctCxlCateCd  = rctCxlCateCd ;
		this.creUsrId  = creUsrId ;
		this.rctCustSeq  = rctCustSeq ;
		this.otsOfcCd  = otsOfcCd ;
		this.rctTpCd  = rctTpCd ;
		this.rctDt  = rctDt ;
		this.rvsAllFlg  = rvsAllFlg ;
		this.asaNo  = asaNo ;
		this.bankChgAmt  = bankChgAmt ;
		this.newRctFlg  = newRctFlg ;
		this.saveKindCd  = saveKindCd ;
		this.rctStsCd  = rctStsCd ;
		this.rctNo  = rctNo ;
		this.bfrCustCntCd  = bfrCustCntCd ;
		this.bfrCustSeq  = bfrCustSeq ;
		this.localChgFlag  = localChgFlag ;
		this.boundType  = boundType ;
		this.invoiceType  = invoiceType ;
	}


	/**
	 * �뚯씠釉�而щ읆����옣��媛믪쓣 Hashtable<"column_name", "value">	濡�諛섑솚
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rct_ofc_cd", getRctOfcCd());		
		this.hashColumns.put("bal_rct_amt", getBalRctAmt());		
		this.hashColumns.put("bfr_bal_rct_amt", getBfrBalRctAmt());		
		this.hashColumns.put("cre_dt", getCreDt());		
		this.hashColumns.put("fnc_curr_scale", getFncCurrScale());		
		this.hashColumns.put("app_amt", getAppAmt());		
		this.hashColumns.put("ttl_amt", getTtlAmt());		
		this.hashColumns.put("mtrty_dt", getMtrtyDt());		
		this.hashColumns.put("rct_cxl_rsn_cd", getRctCxlRsnCd());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("dp_prcs_knt", getDpPrcsKnt());		
		this.hashColumns.put("agn_cd", getAgnCd());		
		this.hashColumns.put("rct_curr_cd", getRctCurrCd());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("rct_prn_flg", getRctPrnFlg());		
		this.hashColumns.put("cxl_desc", getCxlDesc());		
		this.hashColumns.put("rct_seq", getRctSeq());		
		this.hashColumns.put("rct_cust_cnt_cd", getRctCustCntCd());		
		this.hashColumns.put("rct_dps_dt", getRctDpsDt());		
		this.hashColumns.put("rct_cxl_rmk", getRctCxlRmk());		
		this.hashColumns.put("bank_acct_nm", getBankAcctNm());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("upd_dt", getUpdDt());		
		this.hashColumns.put("bank_acct_seq", getBankAcctSeq());		
		this.hashColumns.put("chq_no", getChqNo());		
		this.hashColumns.put("rct_amt", getRctAmt());		
		this.hashColumns.put("rct_rmk", getRctRmk());		
		this.hashColumns.put("unid_amt", getUnidAmt());		
		this.hashColumns.put("agn_ofc_cd", getAgnOfcCd());		
		this.hashColumns.put("unapp_amt", getUnappAmt());		
		this.hashColumns.put("rct_cxl_dt", getRctCxlDt());		
		this.hashColumns.put("rct_cxl_cate_cd", getRctCxlCateCd());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("rct_cust_seq", getRctCustSeq());		
		this.hashColumns.put("ots_ofc_cd", getOtsOfcCd());		
		this.hashColumns.put("rct_tp_cd", getRctTpCd());		
		this.hashColumns.put("rct_dt", getRctDt());		
		this.hashColumns.put("rvs_all_flg", getRvsAllFlg());		
		this.hashColumns.put("asa_no", getAsaNo());		
		this.hashColumns.put("bank_chg_amt", getBankChgAmt());		
		this.hashColumns.put("new_rct_flg", getNewRctFlg());		
		this.hashColumns.put("save_kind_cd", getSaveKindCd());		
		this.hashColumns.put("rct_sts_cd", getRctStsCd());		
		this.hashColumns.put("rct_no", getRctNo());		
		this.hashColumns.put("bfr_cust_cnt_cd", getBfrCustCntCd());		
		this.hashColumns.put("bfr_cust_seq", getBfrCustSeq());		
		this.hashColumns.put("local_chg_flag", getLocalChgFlag());		
		this.hashColumns.put("bound_type", getBoundType());		
		this.hashColumns.put("invoice_type", getInvoiceType());		
		return this.hashColumns;
}

	/**
	 * 而щ읆紐낆뿉	��쓳�섎뒗 硫ㅻ쾭蹂�닔紐낆쓣	��옣�섏뿬 Hashtable<"column_name", "variable"> 濡�諛섑솚
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("rct_ofc_cd", "rctOfcCd");
		this.hashFields.put("bal_rct_amt", "balRctAmt");
		this.hashFields.put("bfr_bal_rct_amt", "bfrBalRctAmt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("fnc_curr_scale", "fncCurrScale");
		this.hashFields.put("app_amt", "appAmt");
		this.hashFields.put("ttl_amt", "ttlAmt");
		this.hashFields.put("mtrty_dt", "mtrtyDt");
		this.hashFields.put("rct_cxl_rsn_cd", "rctCxlRsnCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dp_prcs_knt", "dpPrcsKnt");
		this.hashFields.put("agn_cd", "agnCd");
		this.hashFields.put("rct_curr_cd", "rctCurrCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rct_prn_flg", "rctPrnFlg");
		this.hashFields.put("cxl_desc", "cxlDesc");
		this.hashFields.put("rct_seq", "rctSeq");
		this.hashFields.put("rct_cust_cnt_cd", "rctCustCntCd");
		this.hashFields.put("rct_dps_dt", "rctDpsDt");
		this.hashFields.put("rct_cxl_rmk", "rctCxlRmk");
		this.hashFields.put("bank_acct_nm", "bankAcctNm");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("bank_acct_seq", "bankAcctSeq");
		this.hashFields.put("chq_no", "chqNo");
		this.hashFields.put("rct_amt", "rctAmt");
		this.hashFields.put("rct_rmk", "rctRmk");
		this.hashFields.put("unid_amt", "unidAmt");
		this.hashFields.put("agn_ofc_cd", "agnOfcCd");
		this.hashFields.put("unapp_amt", "unappAmt");
		this.hashFields.put("rct_cxl_dt", "rctCxlDt");
		this.hashFields.put("rct_cxl_cate_cd", "rctCxlCateCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("rct_cust_seq", "rctCustSeq");
		this.hashFields.put("ots_ofc_cd", "otsOfcCd");
		this.hashFields.put("rct_tp_cd", "rctTpCd");
		this.hashFields.put("rct_dt", "rctDt");
		this.hashFields.put("rvs_all_flg", "rvsAllFlg");
		this.hashFields.put("asa_no", "asaNo");
		this.hashFields.put("bank_chg_amt", "bankChgAmt");
		this.hashFields.put("new_rct_flg", "newRctFlg");
		this.hashFields.put("save_kind_cd", "saveKindCd");
		this.hashFields.put("rct_sts_cd", "rctStsCd");
		this.hashFields.put("rct_no", "rctNo");
		this.hashFields.put("bfr_cust_cnt_cd", "bfrCustCntCd");
		this.hashFields.put("bfr_cust_seq", "bfrCustSeq");
		this.hashFields.put("local_chg_flag", "localChgFlag");
		this.hashFields.put("bound_type", "boundType");
		this.hashFields.put("invoice_type", "invoiceType");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  rctOfcCd
	*/
	public void	setRctOfcCd( String	rctOfcCd ) {
		this.rctOfcCd =	rctOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	rctOfcCd
	 */
	 public	 String	getRctOfcCd() {
		 return	this.rctOfcCd;
	 } 
 	/**
	* Column Info
	* @param  balRctAmt
	*/
	public void	setBalRctAmt( String	balRctAmt ) {
		this.balRctAmt =	balRctAmt;
	}
 
	/**
	 * Column Info
	 * @return	balRctAmt
	 */
	 public	 String	getBalRctAmt() {
		 return	this.balRctAmt;
	 } 
 	/**
	* Column Info
	* @param  bfrBalRctAmt
	*/
	public void	setBfrBalRctAmt( String	bfrBalRctAmt ) {
		this.bfrBalRctAmt =	bfrBalRctAmt;
	}
 
	/**
	 * Column Info
	 * @return	bfrBalRctAmt
	 */
	 public	 String	getBfrBalRctAmt() {
		 return	this.bfrBalRctAmt;
	 } 
 	/**
	* Column Info
	* @param  creDt
	*/
	public void	setCreDt( String	creDt ) {
		this.creDt =	creDt;
	}
 
	/**
	 * Column Info
	 * @return	creDt
	 */
	 public	 String	getCreDt() {
		 return	this.creDt;
	 } 
 	/**
	* Column Info
	* @param  fncCurrScale
	*/
	public void	setFncCurrScale( String	fncCurrScale ) {
		this.fncCurrScale =	fncCurrScale;
	}
 
	/**
	 * Column Info
	 * @return	fncCurrScale
	 */
	 public	 String	getFncCurrScale() {
		 return	this.fncCurrScale;
	 } 
 	/**
	* Column Info
	* @param  appAmt
	*/
	public void	setAppAmt( String	appAmt ) {
		this.appAmt =	appAmt;
	}
 
	/**
	 * Column Info
	 * @return	appAmt
	 */
	 public	 String	getAppAmt() {
		 return	this.appAmt;
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
	* @param  mtrtyDt
	*/
	public void	setMtrtyDt( String	mtrtyDt ) {
		this.mtrtyDt =	mtrtyDt;
	}
 
	/**
	 * Column Info
	 * @return	mtrtyDt
	 */
	 public	 String	getMtrtyDt() {
		 return	this.mtrtyDt;
	 } 
 	/**
	* Column Info
	* @param  rctCxlRsnCd
	*/
	public void	setRctCxlRsnCd( String	rctCxlRsnCd ) {
		this.rctCxlRsnCd =	rctCxlRsnCd;
	}
 
	/**
	 * Column Info
	 * @return	rctCxlRsnCd
	 */
	 public	 String	getRctCxlRsnCd() {
		 return	this.rctCxlRsnCd;
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
	* @param  agnCd
	*/
	public void	setAgnCd( String	agnCd ) {
		this.agnCd =	agnCd;
	}
 
	/**
	 * Column Info
	 * @return	agnCd
	 */
	 public	 String	getAgnCd() {
		 return	this.agnCd;
	 } 
 	/**
	* Column Info
	* @param  rctCurrCd
	*/
	public void	setRctCurrCd( String	rctCurrCd ) {
		this.rctCurrCd =	rctCurrCd;
	}
 
	/**
	 * Column Info
	 * @return	rctCurrCd
	 */
	 public	 String	getRctCurrCd() {
		 return	this.rctCurrCd;
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
	* @param  rctPrnFlg
	*/
	public void	setRctPrnFlg( String	rctPrnFlg ) {
		this.rctPrnFlg =	rctPrnFlg;
	}
 
	/**
	 * Column Info
	 * @return	rctPrnFlg
	 */
	 public	 String	getRctPrnFlg() {
		 return	this.rctPrnFlg;
	 } 
 	/**
	* Column Info
	* @param  cxlDesc
	*/
	public void	setCxlDesc( String	cxlDesc ) {
		this.cxlDesc =	cxlDesc;
	}
 
	/**
	 * Column Info
	 * @return	cxlDesc
	 */
	 public	 String	getCxlDesc() {
		 return	this.cxlDesc;
	 } 
 	/**
	* Column Info
	* @param  rctSeq
	*/
	public void	setRctSeq( String	rctSeq ) {
		this.rctSeq =	rctSeq;
	}
 
	/**
	 * Column Info
	 * @return	rctSeq
	 */
	 public	 String	getRctSeq() {
		 return	this.rctSeq;
	 } 
 	/**
	* Column Info
	* @param  rctCustCntCd
	*/
	public void	setRctCustCntCd( String	rctCustCntCd ) {
		this.rctCustCntCd =	rctCustCntCd;
	}
 
	/**
	 * Column Info
	 * @return	rctCustCntCd
	 */
	 public	 String	getRctCustCntCd() {
		 return	this.rctCustCntCd;
	 } 
 	/**
	* Column Info
	* @param  rctDpsDt
	*/
	public void	setRctDpsDt( String	rctDpsDt ) {
		this.rctDpsDt =	rctDpsDt;
	}
 
	/**
	 * Column Info
	 * @return	rctDpsDt
	 */
	 public	 String	getRctDpsDt() {
		 return	this.rctDpsDt;
	 } 
 	/**
	* Column Info
	* @param  rctCxlRmk
	*/
	public void	setRctCxlRmk( String	rctCxlRmk ) {
		this.rctCxlRmk =	rctCxlRmk;
	}
 
	/**
	 * Column Info
	 * @return	rctCxlRmk
	 */
	 public	 String	getRctCxlRmk() {
		 return	this.rctCxlRmk;
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
	* @param  updUsrId
	*/
	public void	setUpdUsrId( String	updUsrId ) {
		this.updUsrId =	updUsrId;
	}
 
	/**
	 * Column Info
	 * @return	updUsrId
	 */
	 public	 String	getUpdUsrId() {
		 return	this.updUsrId;
	 } 
 	/**
	* Column Info
	* @param  updDt
	*/
	public void	setUpdDt( String	updDt ) {
		this.updDt =	updDt;
	}
 
	/**
	 * Column Info
	 * @return	updDt
	 */
	 public	 String	getUpdDt() {
		 return	this.updDt;
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
	* @param  chqNo
	*/
	public void	setChqNo( String	chqNo ) {
		this.chqNo =	chqNo;
	}
 
	/**
	 * Column Info
	 * @return	chqNo
	 */
	 public	 String	getChqNo() {
		 return	this.chqNo;
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
	* @param  rctRmk
	*/
	public void	setRctRmk( String	rctRmk ) {
		this.rctRmk =	rctRmk;
	}
 
	/**
	 * Column Info
	 * @return	rctRmk
	 */
	 public	 String	getRctRmk() {
		 return	this.rctRmk;
	 } 
 	/**
	* Column Info
	* @param  unidAmt
	*/
	public void	setUnidAmt( String	unidAmt ) {
		this.unidAmt =	unidAmt;
	}
 
	/**
	 * Column Info
	 * @return	unidAmt
	 */
	 public	 String	getUnidAmt() {
		 return	this.unidAmt;
	 } 
 	/**
	* Column Info
	* @param  agnOfcCd
	*/
	public void	setAgnOfcCd( String	agnOfcCd ) {
		this.agnOfcCd =	agnOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	agnOfcCd
	 */
	 public	 String	getAgnOfcCd() {
		 return	this.agnOfcCd;
	 } 
 	/**
	* Column Info
	* @param  unappAmt
	*/
	public void	setUnappAmt( String	unappAmt ) {
		this.unappAmt =	unappAmt;
	}
 
	/**
	 * Column Info
	 * @return	unappAmt
	 */
	 public	 String	getUnappAmt() {
		 return	this.unappAmt;
	 } 
 	/**
	* Column Info
	* @param  rctCxlDt
	*/
	public void	setRctCxlDt( String	rctCxlDt ) {
		this.rctCxlDt =	rctCxlDt;
	}
 
	/**
	 * Column Info
	 * @return	rctCxlDt
	 */
	 public	 String	getRctCxlDt() {
		 return	this.rctCxlDt;
	 } 
 	/**
	* Column Info
	* @param  rctCxlCateCd
	*/
	public void	setRctCxlCateCd( String	rctCxlCateCd ) {
		this.rctCxlCateCd =	rctCxlCateCd;
	}
 
	/**
	 * Column Info
	 * @return	rctCxlCateCd
	 */
	 public	 String	getRctCxlCateCd() {
		 return	this.rctCxlCateCd;
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
	* @param  rctCustSeq
	*/
	public void	setRctCustSeq( String	rctCustSeq ) {
		this.rctCustSeq =	rctCustSeq;
	}
 
	/**
	 * Column Info
	 * @return	rctCustSeq
	 */
	 public	 String	getRctCustSeq() {
		 return	this.rctCustSeq;
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
	* @param  rctTpCd
	*/
	public void	setRctTpCd( String	rctTpCd ) {
		this.rctTpCd =	rctTpCd;
	}
 
	/**
	 * Column Info
	 * @return	rctTpCd
	 */
	 public	 String	getRctTpCd() {
		 return	this.rctTpCd;
	 } 
 	/**
	* Column Info
	* @param  rctDt
	*/
	public void	setRctDt( String	rctDt ) {
		this.rctDt =	rctDt;
	}
 
	/**
	 * Column Info
	 * @return	rctDt
	 */
	 public	 String	getRctDt() {
		 return	this.rctDt;
	 } 
 	/**
	* Column Info
	* @param  rvsAllFlg
	*/
	public void	setRvsAllFlg( String	rvsAllFlg ) {
		this.rvsAllFlg =	rvsAllFlg;
	}
 
	/**
	 * Column Info
	 * @return	rvsAllFlg
	 */
	 public	 String	getRvsAllFlg() {
		 return	this.rvsAllFlg;
	 } 
 	/**
	* Column Info
	* @param  asaNo
	*/
	public void	setAsaNo( String	asaNo ) {
		this.asaNo =	asaNo;
	}
 
	/**
	 * Column Info
	 * @return	asaNo
	 */
	 public	 String	getAsaNo() {
		 return	this.asaNo;
	 } 
 	/**
	* Column Info
	* @param  bankChgAmt
	*/
	public void	setBankChgAmt( String	bankChgAmt ) {
		this.bankChgAmt =	bankChgAmt;
	}
 
	/**
	 * Column Info
	 * @return	bankChgAmt
	 */
	 public	 String	getBankChgAmt() {
		 return	this.bankChgAmt;
	 } 
 	/**
	* Column Info
	* @param  newRctFlg
	*/
	public void	setNewRctFlg( String	newRctFlg ) {
		this.newRctFlg =	newRctFlg;
	}
 
	/**
	 * Column Info
	 * @return	newRctFlg
	 */
	 public	 String	getNewRctFlg() {
		 return	this.newRctFlg;
	 } 
 	/**
	* Column Info
	* @param  saveKindCd
	*/
	public void	setSaveKindCd( String	saveKindCd ) {
		this.saveKindCd =	saveKindCd;
	}
 
	/**
	 * Column Info
	 * @return	saveKindCd
	 */
	 public	 String	getSaveKindCd() {
		 return	this.saveKindCd;
	 } 
 	/**
	* Column Info
	* @param  rctStsCd
	*/
	public void	setRctStsCd( String	rctStsCd ) {
		this.rctStsCd =	rctStsCd;
	}
 
	/**
	 * Column Info
	 * @return	rctStsCd
	 */
	 public	 String	getRctStsCd() {
		 return	this.rctStsCd;
	 } 
 	/**
	* Column Info
	* @param  rctNo
	*/
	public void	setRctNo( String	rctNo ) {
		this.rctNo =	rctNo;
	}
 
	/**
	 * Column Info
	 * @return	rctNo
	 */
	 public	 String	getRctNo() {
		 return	this.rctNo;
	 } 
 	/**
	* Column Info
	* @param  bfrCustCntCd
	*/
	public void	setBfrCustCntCd( String	bfrCustCntCd ) {
		this.bfrCustCntCd =	bfrCustCntCd;
	}
 
	/**
	 * Column Info
	 * @return	bfrCustCntCd
	 */
	 public	 String	getBfrCustCntCd() {
		 return	this.bfrCustCntCd;
	 } 
 	/**
	* Column Info
	* @param  bfrCustSeq
	*/
	public void	setBfrCustSeq( String	bfrCustSeq ) {
		this.bfrCustSeq =	bfrCustSeq;
	}
 
	/**
	 * Column Info
	 * @return	bfrCustSeq
	 */
	 public	 String	getBfrCustSeq() {
		 return	this.bfrCustSeq;
	 } 
 	/**
	* Column Info
	* @param  localChgFlag
	*/
	public void	setLocalChgFlag( String	localChgFlag ) {
		this.localChgFlag =	localChgFlag;
	}
 
	/**
	 * Column Info
	 * @return	localChgFlag
	 */
	 public	 String	getLocalChgFlag() {
		 return	this.localChgFlag;
	 } 
 	/**
	* Column Info
	* @param  boundType
	*/
	public void	setBoundType( String	boundType ) {
		this.boundType =	boundType;
	}
 
	/**
	 * Column Info
	 * @return	boundType
	 */
	 public	 String	getBoundType() {
		 return	this.boundType;
	 } 
 	/**
	* Column Info
	* @param  invoiceType
	*/
	public void	setInvoiceType( String	invoiceType ) {
		this.invoiceType =	invoiceType;
	}
 
	/**
	 * Column Info
	 * @return	invoiceType
	 */
	 public	 String	getInvoiceType() {
		 return	this.invoiceType;
	 } 

	/**
	 * Request ���곗씠�곕� 異붿텧�섏뿬 VO ��硫ㅻ쾭蹂�닔���ㅼ젙.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request)	{
		fromRequest(request,"");
	}

	/**
	 * Request ���곗씠�곕� 異붿텧�섏뿬 VO ��硫ㅻ쾭蹂�닔���ㅼ젙.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request,	String prefix) {
		setRctOfcCd(JSPUtil.getParameter(request,	prefix + "rct_ofc_cd", ""));
		setBalRctAmt(JSPUtil.getParameter(request,	prefix + "bal_rct_amt", ""));
		setBfrBalRctAmt(JSPUtil.getParameter(request,	prefix + "bfr_bal_rct_amt", ""));
		setCreDt(JSPUtil.getParameter(request,	prefix + "cre_dt", ""));
		setFncCurrScale(JSPUtil.getParameter(request,	prefix + "fnc_curr_scale", ""));
		setAppAmt(JSPUtil.getParameter(request,	prefix + "app_amt", ""));
		setTtlAmt(JSPUtil.getParameter(request,	prefix + "ttl_amt", ""));
		setMtrtyDt(JSPUtil.getParameter(request,	prefix + "mtrty_dt", ""));
		setRctCxlRsnCd(JSPUtil.getParameter(request,	prefix + "rct_cxl_rsn_cd", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setDpPrcsKnt(JSPUtil.getParameter(request,	prefix + "dp_prcs_knt", ""));
		setAgnCd(JSPUtil.getParameter(request,	prefix + "agn_cd", ""));
		setRctCurrCd(JSPUtil.getParameter(request,	prefix + "rct_curr_cd", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setRctPrnFlg(JSPUtil.getParameter(request,	prefix + "rct_prn_flg", ""));
		setCxlDesc(JSPUtil.getParameter(request,	prefix + "cxl_desc", ""));
		setRctSeq(JSPUtil.getParameter(request,	prefix + "rct_seq", ""));
		setRctCustCntCd(JSPUtil.getParameter(request,	prefix + "rct_cust_cnt_cd", ""));
		setRctDpsDt(JSPUtil.getParameter(request,	prefix + "rct_dps_dt", ""));
		setRctCxlRmk(JSPUtil.getParameter(request,	prefix + "rct_cxl_rmk", ""));
		setBankAcctNm(JSPUtil.getParameter(request,	prefix + "bank_acct_nm", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request,	prefix + "upd_dt", ""));
		setBankAcctSeq(JSPUtil.getParameter(request,	prefix + "bank_acct_seq", ""));
		setChqNo(JSPUtil.getParameter(request,	prefix + "chq_no", ""));
		setRctAmt(JSPUtil.getParameter(request,	prefix + "rct_amt", ""));
		setRctRmk(JSPUtil.getParameter(request,	prefix + "rct_rmk", ""));
		setUnidAmt(JSPUtil.getParameter(request,	prefix + "unid_amt", ""));
		setAgnOfcCd(JSPUtil.getParameter(request,	prefix + "agn_ofc_cd", ""));
		setUnappAmt(JSPUtil.getParameter(request,	prefix + "unapp_amt", ""));
		setRctCxlDt(JSPUtil.getParameter(request,	prefix + "rct_cxl_dt", ""));
		setRctCxlCateCd(JSPUtil.getParameter(request,	prefix + "rct_cxl_cate_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setRctCustSeq(JSPUtil.getParameter(request,	prefix + "rct_cust_seq", ""));
		setOtsOfcCd(JSPUtil.getParameter(request,	prefix + "ots_ofc_cd", ""));
		setRctTpCd(JSPUtil.getParameter(request,	prefix + "rct_tp_cd", ""));
		setRctDt(JSPUtil.getParameter(request,	prefix + "rct_dt", ""));
		setRvsAllFlg(JSPUtil.getParameter(request,	prefix + "rvs_all_flg", ""));
		setAsaNo(JSPUtil.getParameter(request,	prefix + "asa_no", ""));
		setBankChgAmt(JSPUtil.getParameter(request,	prefix + "bank_chg_amt", ""));
		setNewRctFlg(JSPUtil.getParameter(request,	prefix + "new_rct_flg", ""));
		setSaveKindCd(JSPUtil.getParameter(request,	prefix + "save_kind_cd", ""));
		setRctStsCd(JSPUtil.getParameter(request,	prefix + "rct_sts_cd", ""));
		setRctNo(JSPUtil.getParameter(request,	prefix + "rct_no", ""));
		setBfrCustCntCd(JSPUtil.getParameter(request,	prefix + "bfr_cust_cnt_cd", ""));
		setBfrCustSeq(JSPUtil.getParameter(request,	prefix + "bfr_cust_seq", ""));
		setLocalChgFlag(JSPUtil.getParameter(request,	prefix + "local_chg_flag", ""));
		setBoundType(JSPUtil.getParameter(request,	prefix + "bound_type", ""));
		setInvoiceType(JSPUtil.getParameter(request,	prefix + "invoice_type", ""));
	}
	
	/**
	 * Request ���곗씠�곕� VO 諛곗뿴濡�蹂�솚�섏뿬 諛섑솚.
	 * @param request
	 * @return ReceiptMainVO[]
	 */
	public ReceiptMainVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request �섏뼱���щ윭 嫄�DATA瑜�VO Class ���대뒗��
	 * @param request
	 * @param prefix
	 * @return ReceiptMainVO[]
	 */
	public ReceiptMainVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		ReceiptMainVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] rctOfcCd =	(JSPUtil.getParameter(request, prefix +	"rct_ofc_cd".trim(),	length));
				String[] balRctAmt =	(JSPUtil.getParameter(request, prefix +	"bal_rct_amt".trim(),	length));
				String[] bfrBalRctAmt =	(JSPUtil.getParameter(request, prefix +	"bfr_bal_rct_amt".trim(),	length));
				String[] creDt =	(JSPUtil.getParameter(request, prefix +	"cre_dt".trim(),	length));
				String[] fncCurrScale =	(JSPUtil.getParameter(request, prefix +	"fnc_curr_scale".trim(),	length));
				String[] appAmt =	(JSPUtil.getParameter(request, prefix +	"app_amt".trim(),	length));
				String[] ttlAmt =	(JSPUtil.getParameter(request, prefix +	"ttl_amt".trim(),	length));
				String[] mtrtyDt =	(JSPUtil.getParameter(request, prefix +	"mtrty_dt".trim(),	length));
				String[] rctCxlRsnCd =	(JSPUtil.getParameter(request, prefix +	"rct_cxl_rsn_cd".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] dpPrcsKnt =	(JSPUtil.getParameter(request, prefix +	"dp_prcs_knt".trim(),	length));
				String[] agnCd =	(JSPUtil.getParameter(request, prefix +	"agn_cd".trim(),	length));
				String[] rctCurrCd =	(JSPUtil.getParameter(request, prefix +	"rct_curr_cd".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] rctPrnFlg =	(JSPUtil.getParameter(request, prefix +	"rct_prn_flg".trim(),	length));
				String[] cxlDesc =	(JSPUtil.getParameter(request, prefix +	"cxl_desc".trim(),	length));
				String[] rctSeq =	(JSPUtil.getParameter(request, prefix +	"rct_seq".trim(),	length));
				String[] rctCustCntCd =	(JSPUtil.getParameter(request, prefix +	"rct_cust_cnt_cd".trim(),	length));
				String[] rctDpsDt =	(JSPUtil.getParameter(request, prefix +	"rct_dps_dt".trim(),	length));
				String[] rctCxlRmk =	(JSPUtil.getParameter(request, prefix +	"rct_cxl_rmk".trim(),	length));
				String[] bankAcctNm =	(JSPUtil.getParameter(request, prefix +	"bank_acct_nm".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] updDt =	(JSPUtil.getParameter(request, prefix +	"upd_dt".trim(),	length));
				String[] bankAcctSeq =	(JSPUtil.getParameter(request, prefix +	"bank_acct_seq".trim(),	length));
				String[] chqNo =	(JSPUtil.getParameter(request, prefix +	"chq_no".trim(),	length));
				String[] rctAmt =	(JSPUtil.getParameter(request, prefix +	"rct_amt".trim(),	length));
				String[] rctRmk =	(JSPUtil.getParameter(request, prefix +	"rct_rmk".trim(),	length));
				String[] unidAmt =	(JSPUtil.getParameter(request, prefix +	"unid_amt".trim(),	length));
				String[] agnOfcCd =	(JSPUtil.getParameter(request, prefix +	"agn_ofc_cd".trim(),	length));
				String[] unappAmt =	(JSPUtil.getParameter(request, prefix +	"unapp_amt".trim(),	length));
				String[] rctCxlDt =	(JSPUtil.getParameter(request, prefix +	"rct_cxl_dt".trim(),	length));
				String[] rctCxlCateCd =	(JSPUtil.getParameter(request, prefix +	"rct_cxl_cate_cd".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				String[] rctCustSeq =	(JSPUtil.getParameter(request, prefix +	"rct_cust_seq".trim(),	length));
				String[] otsOfcCd =	(JSPUtil.getParameter(request, prefix +	"ots_ofc_cd".trim(),	length));
				String[] rctTpCd =	(JSPUtil.getParameter(request, prefix +	"rct_tp_cd".trim(),	length));
				String[] rctDt =	(JSPUtil.getParameter(request, prefix +	"rct_dt".trim(),	length));
				String[] rvsAllFlg =	(JSPUtil.getParameter(request, prefix +	"rvs_all_flg".trim(),	length));
				String[] asaNo =	(JSPUtil.getParameter(request, prefix +	"asa_no".trim(),	length));
				String[] bankChgAmt =	(JSPUtil.getParameter(request, prefix +	"bank_chg_amt".trim(),	length));
				String[] newRctFlg =	(JSPUtil.getParameter(request, prefix +	"new_rct_flg".trim(),	length));
				String[] saveKindCd =	(JSPUtil.getParameter(request, prefix +	"save_kind_cd".trim(),	length));
				String[] rctStsCd =	(JSPUtil.getParameter(request, prefix +	"rct_sts_cd".trim(),	length));
				String[] rctNo =	(JSPUtil.getParameter(request, prefix +	"rct_no".trim(),	length));
				String[] bfrCustCntCd =	(JSPUtil.getParameter(request, prefix +	"bfr_cust_cnt_cd".trim(),	length));
				String[] bfrCustSeq =	(JSPUtil.getParameter(request, prefix +	"bfr_cust_seq".trim(),	length));
				String[] localChgFlag =	(JSPUtil.getParameter(request, prefix +	"local_chg_flag".trim(),	length));
				String[] boundType =	(JSPUtil.getParameter(request, prefix +	"bound_type".trim(),	length));
				String[] invoiceType =	(JSPUtil.getParameter(request, prefix +	"invoice_type".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	ReceiptMainVO();
						if ( rctOfcCd[i] !=	null)
						model.setRctOfcCd( rctOfcCd[i]);
						if ( balRctAmt[i] !=	null)
						model.setBalRctAmt( balRctAmt[i]);
						if ( bfrBalRctAmt[i] !=	null)
						model.setBfrBalRctAmt( bfrBalRctAmt[i]);
						if ( creDt[i] !=	null)
						model.setCreDt( creDt[i]);
						if ( fncCurrScale[i] !=	null)
						model.setFncCurrScale( fncCurrScale[i]);
						if ( appAmt[i] !=	null)
						model.setAppAmt( appAmt[i]);
						if ( ttlAmt[i] !=	null)
						model.setTtlAmt( ttlAmt[i]);
						if ( mtrtyDt[i] !=	null)
						model.setMtrtyDt( mtrtyDt[i]);
						if ( rctCxlRsnCd[i] !=	null)
						model.setRctCxlRsnCd( rctCxlRsnCd[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( dpPrcsKnt[i] !=	null)
						model.setDpPrcsKnt( dpPrcsKnt[i]);
						if ( agnCd[i] !=	null)
						model.setAgnCd( agnCd[i]);
						if ( rctCurrCd[i] !=	null)
						model.setRctCurrCd( rctCurrCd[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( rctPrnFlg[i] !=	null)
						model.setRctPrnFlg( rctPrnFlg[i]);
						if ( cxlDesc[i] !=	null)
						model.setCxlDesc( cxlDesc[i]);
						if ( rctSeq[i] !=	null)
						model.setRctSeq( rctSeq[i]);
						if ( rctCustCntCd[i] !=	null)
						model.setRctCustCntCd( rctCustCntCd[i]);
						if ( rctDpsDt[i] !=	null)
						model.setRctDpsDt( rctDpsDt[i]);
						if ( rctCxlRmk[i] !=	null)
						model.setRctCxlRmk( rctCxlRmk[i]);
						if ( bankAcctNm[i] !=	null)
						model.setBankAcctNm( bankAcctNm[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( updDt[i] !=	null)
						model.setUpdDt( updDt[i]);
						if ( bankAcctSeq[i] !=	null)
						model.setBankAcctSeq( bankAcctSeq[i]);
						if ( chqNo[i] !=	null)
						model.setChqNo( chqNo[i]);
						if ( rctAmt[i] !=	null)
						model.setRctAmt( rctAmt[i]);
						if ( rctRmk[i] !=	null)
						model.setRctRmk( rctRmk[i]);
						if ( unidAmt[i] !=	null)
						model.setUnidAmt( unidAmt[i]);
						if ( agnOfcCd[i] !=	null)
						model.setAgnOfcCd( agnOfcCd[i]);
						if ( unappAmt[i] !=	null)
						model.setUnappAmt( unappAmt[i]);
						if ( rctCxlDt[i] !=	null)
						model.setRctCxlDt( rctCxlDt[i]);
						if ( rctCxlCateCd[i] !=	null)
						model.setRctCxlCateCd( rctCxlCateCd[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
						if ( rctCustSeq[i] !=	null)
						model.setRctCustSeq( rctCustSeq[i]);
						if ( otsOfcCd[i] !=	null)
						model.setOtsOfcCd( otsOfcCd[i]);
						if ( rctTpCd[i] !=	null)
						model.setRctTpCd( rctTpCd[i]);
						if ( rctDt[i] !=	null)
						model.setRctDt( rctDt[i]);
						if ( rvsAllFlg[i] !=	null)
						model.setRvsAllFlg( rvsAllFlg[i]);
						if ( asaNo[i] !=	null)
						model.setAsaNo( asaNo[i]);
						if ( bankChgAmt[i] !=	null)
						model.setBankChgAmt( bankChgAmt[i]);
						if ( newRctFlg[i] !=	null)
						model.setNewRctFlg( newRctFlg[i]);
						if ( saveKindCd[i] !=	null)
						model.setSaveKindCd( saveKindCd[i]);
						if ( rctStsCd[i] !=	null)
						model.setRctStsCd( rctStsCd[i]);
						if ( rctNo[i] !=	null)
						model.setRctNo( rctNo[i]);
						if ( bfrCustCntCd[i] !=	null)
						model.setBfrCustCntCd( bfrCustCntCd[i]);
						if ( bfrCustSeq[i] !=	null)
						model.setBfrCustSeq( bfrCustSeq[i]);
						if ( localChgFlag[i] !=	null)
						model.setLocalChgFlag( localChgFlag[i]);
						if ( boundType[i] !=	null)
						model.setBoundType( boundType[i]);
						if ( invoiceType[i] !=	null)
						model.setInvoiceType( invoiceType[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getReceiptMainVOs();
	}

	/**
	 *  VO 諛곗뿴��諛섑솚
	 * @return ReceiptMainVO[]
	 */
	public ReceiptMainVO[]	 getReceiptMainVOs(){
		ReceiptMainVO[] vos = (ReceiptMainVO[])models.toArray(new	ReceiptMainVO[models.size()]);
		return vos;
		}

	/**
	 * VO Class���댁슜��String�쇰줈 蹂�솚
	 */
	public String  toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	}
	

	/**
	* �щ㎎�낅맂 臾몄옄�댁뿉���뱀닔臾몄옄 �쒓굅("-","/",",",":")
	*/
	public void	unDataFormat(){
		this.rctOfcCd =	this.rctOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.balRctAmt =	this.balRctAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bfrBalRctAmt =	this.bfrBalRctAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt =	this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fncCurrScale =	this.fncCurrScale.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.appAmt =	this.appAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlAmt =	this.ttlAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtrtyDt =	this.mtrtyDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctCxlRsnCd =	this.rctCxlRsnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpPrcsKnt =	this.dpPrcsKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnCd =	this.agnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctCurrCd =	this.rctCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctPrnFlg =	this.rctPrnFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlDesc =	this.cxlDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctSeq =	this.rctSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctCustCntCd =	this.rctCustCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctDpsDt =	this.rctDpsDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctCxlRmk =	this.rctCxlRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankAcctNm =	this.bankAcctNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt =	this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankAcctSeq =	this.bankAcctSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chqNo =	this.chqNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctAmt =	this.rctAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctRmk =	this.rctRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unidAmt =	this.unidAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnOfcCd =	this.agnOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unappAmt =	this.unappAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctCxlDt =	this.rctCxlDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctCxlCateCd =	this.rctCxlCateCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctCustSeq =	this.rctCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsOfcCd =	this.otsOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctTpCd =	this.rctTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctDt =	this.rctDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvsAllFlg =	this.rvsAllFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asaNo =	this.asaNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankChgAmt =	this.bankChgAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newRctFlg =	this.newRctFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.saveKindCd =	this.saveKindCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctStsCd =	this.rctStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctNo =	this.rctNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bfrCustCntCd =	this.bfrCustCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bfrCustSeq =	this.bfrCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.localChgFlag =	this.localChgFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.boundType =	this.boundType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invoiceType =	this.invoiceType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}