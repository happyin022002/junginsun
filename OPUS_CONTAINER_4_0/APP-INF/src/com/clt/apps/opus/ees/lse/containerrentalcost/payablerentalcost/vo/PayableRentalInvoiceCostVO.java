/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : PayableRentalInvoiceCostVO.java
 *@FileTitle : PayableRentalInvoiceCostVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.01.25
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2016.01.25  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.vo;

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
public class PayableRentalInvoiceCostVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<PayableRentalInvoiceCostVO>  models =	new	ArrayList<PayableRentalInvoiceCostVO>();


	/*	Column Info	*/
	private  String	 searchTp   =  null;
	/*	Column Info	*/
	private  String	 remark   =  null;
	/*	Column Info	*/
	private  String	 chgCostYrmon   =  null;
	/*	Column Info	*/
	private  String	 invIssDt   =  null;
	/*	Column Info	*/
	private  String	 invoiceNo   =  null;
	/*	Column Info	*/
	private  String	 ifErrRsn   =  null;
	/*	Column Info	*/
	private  String	 invRcvDt   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 invStsCd   =  null;
	/*	Column Info	*/
	private  String	 ifRgstNo   =  null;
	/*	Column Info	*/
	private  String	 lstmCd   =  null;
	/*	Column Info	*/
	private  String	 crTtlAmt   =  null;
	/*	Column Info	*/
	private  String	 lseInvApstsCd   =  null;
	/*	Column Info	*/
	private  String	 costStMonth   =  null;
	/*	Column Info	*/
	private  String	 ifFlg   =  null;
	/*	Column Info	*/
	private  String	 invEffYrmon   =  null;
	/*	Column Info	*/
	private  String	 aproDt   =  null;
	/*	Column Info	*/
	private  String	 cancelFlag   =  null;
	/*	Column Info	*/
	private  String	 registerNo   =  null;
	/*	Column Info	*/
	private  String	 ttlCostAmt   =  null;
	/*	Column Info	*/
	private  String	 payRntlCostAmt   =  null;
	/*	Column Info	*/
	private  String	 invNo   =  null;
	/*	Column Info	*/
	private  String	 invoiceEdMonth   =  null;
	/*	Column Info	*/
	private  String	 invoiceStMonth   =  null;
	/*	Column Info	*/
	private  String	 aproUsrId   =  null;
	/*	Column Info	*/
	private  String	 costEdMonth   =  null;
	/*	Column Info	*/
	private  String	 vndrSeq   =  null;
	/*	Column Info	*/
	private  String	 invoiceUser   =  null;
	/*	Column Info	*/
	private  String	 chgTp   =  null;
	/*	Column Info	*/
	private  String	 payVndrSeq   =  null;
	/*	Column Info	*/
	private  String	 invVatAmt   =  null;
	/*	Column Info	*/
	private  String	 whldTaxAmt   =  null;
	/*	Column Info	*/
	private  String	 invTtlAmt   =  null;
	/*	Column Info	*/
	private  String	 lsePayTpCd   =  null;
	/*	Column Info	*/
	private  String	 agmtNo   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public PayableRentalInvoiceCostVO(){}

	public PayableRentalInvoiceCostVO(String searchTp,String remark,String chgCostYrmon,String invIssDt,String invoiceNo,String ifErrRsn,String invRcvDt,String pagerows,String ibflag,String invStsCd,String ifRgstNo,String lstmCd,String crTtlAmt,String lseInvApstsCd,String costStMonth,String ifFlg,String invEffYrmon,String aproDt,String cancelFlag,String registerNo,String ttlCostAmt,String payRntlCostAmt,String invNo,String invoiceEdMonth,String invoiceStMonth,String aproUsrId,String costEdMonth,String vndrSeq,String invoiceUser,String chgTp,String payVndrSeq,String invVatAmt,String whldTaxAmt,String invTtlAmt,String lsePayTpCd,String agmtNo)	{
		this.searchTp  = searchTp ;
		this.remark  = remark ;
		this.chgCostYrmon  = chgCostYrmon ;
		this.invIssDt  = invIssDt ;
		this.invoiceNo  = invoiceNo ;
		this.ifErrRsn  = ifErrRsn ;
		this.invRcvDt  = invRcvDt ;
		this.pagerows  = pagerows ;
		this.ibflag  = ibflag ;
		this.invStsCd  = invStsCd ;
		this.ifRgstNo  = ifRgstNo ;
		this.lstmCd  = lstmCd ;
		this.crTtlAmt  = crTtlAmt ;
		this.lseInvApstsCd  = lseInvApstsCd ;
		this.costStMonth  = costStMonth ;
		this.ifFlg  = ifFlg ;
		this.invEffYrmon  = invEffYrmon ;
		this.aproDt  = aproDt ;
		this.cancelFlag  = cancelFlag ;
		this.registerNo  = registerNo ;
		this.ttlCostAmt  = ttlCostAmt ;
		this.payRntlCostAmt  = payRntlCostAmt ;
		this.invNo  = invNo ;
		this.invoiceEdMonth  = invoiceEdMonth ;
		this.invoiceStMonth  = invoiceStMonth ;
		this.aproUsrId  = aproUsrId ;
		this.costEdMonth  = costEdMonth ;
		this.vndrSeq  = vndrSeq ;
		this.invoiceUser  = invoiceUser ;
		this.chgTp  = chgTp ;
		this.payVndrSeq  = payVndrSeq ;
		this.invVatAmt  = invVatAmt ;
		this.whldTaxAmt  = whldTaxAmt ;
		this.invTtlAmt  = invTtlAmt ;
		this.lsePayTpCd  = lsePayTpCd ;
		this.agmtNo  = agmtNo ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("search_tp", getSearchTp());		
		this.hashColumns.put("remark", getRemark());		
		this.hashColumns.put("chg_cost_yrmon", getChgCostYrmon());		
		this.hashColumns.put("inv_iss_dt", getInvIssDt());		
		this.hashColumns.put("invoice_no", getInvoiceNo());		
		this.hashColumns.put("if_err_rsn", getIfErrRsn());		
		this.hashColumns.put("inv_rcv_dt", getInvRcvDt());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("inv_sts_cd", getInvStsCd());		
		this.hashColumns.put("if_rgst_no", getIfRgstNo());		
		this.hashColumns.put("lstm_cd", getLstmCd());		
		this.hashColumns.put("cr_ttl_amt", getCrTtlAmt());		
		this.hashColumns.put("lse_inv_apsts_cd", getLseInvApstsCd());		
		this.hashColumns.put("cost_st_month", getCostStMonth());		
		this.hashColumns.put("if_flg", getIfFlg());		
		this.hashColumns.put("inv_eff_yrmon", getInvEffYrmon());		
		this.hashColumns.put("apro_dt", getAproDt());		
		this.hashColumns.put("cancel_flag", getCancelFlag());		
		this.hashColumns.put("register_no", getRegisterNo());		
		this.hashColumns.put("ttl_cost_amt", getTtlCostAmt());		
		this.hashColumns.put("pay_rntl_cost_amt", getPayRntlCostAmt());		
		this.hashColumns.put("inv_no", getInvNo());		
		this.hashColumns.put("invoice_ed_month", getInvoiceEdMonth());		
		this.hashColumns.put("invoice_st_month", getInvoiceStMonth());		
		this.hashColumns.put("apro_usr_id", getAproUsrId());		
		this.hashColumns.put("cost_ed_month", getCostEdMonth());		
		this.hashColumns.put("vndr_seq", getVndrSeq());		
		this.hashColumns.put("invoice_user", getInvoiceUser());		
		this.hashColumns.put("chg_tp", getChgTp());		
		this.hashColumns.put("pay_vndr_seq", getPayVndrSeq());		
		this.hashColumns.put("inv_vat_amt", getInvVatAmt());		
		this.hashColumns.put("whld_tax_amt", getWhldTaxAmt());		
		this.hashColumns.put("inv_ttl_amt", getInvTtlAmt());		
		this.hashColumns.put("lse_pay_tp_cd", getLsePayTpCd());		
		this.hashColumns.put("agmt_no", getAgmtNo());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("search_tp", "searchTp");
		this.hashFields.put("remark", "remark");
		this.hashFields.put("chg_cost_yrmon", "chgCostYrmon");
		this.hashFields.put("inv_iss_dt", "invIssDt");
		this.hashFields.put("invoice_no", "invoiceNo");
		this.hashFields.put("if_err_rsn", "ifErrRsn");
		this.hashFields.put("inv_rcv_dt", "invRcvDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("inv_sts_cd", "invStsCd");
		this.hashFields.put("if_rgst_no", "ifRgstNo");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("cr_ttl_amt", "crTtlAmt");
		this.hashFields.put("lse_inv_apsts_cd", "lseInvApstsCd");
		this.hashFields.put("cost_st_month", "costStMonth");
		this.hashFields.put("if_flg", "ifFlg");
		this.hashFields.put("inv_eff_yrmon", "invEffYrmon");
		this.hashFields.put("apro_dt", "aproDt");
		this.hashFields.put("cancel_flag", "cancelFlag");
		this.hashFields.put("register_no", "registerNo");
		this.hashFields.put("ttl_cost_amt", "ttlCostAmt");
		this.hashFields.put("pay_rntl_cost_amt", "payRntlCostAmt");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("invoice_ed_month", "invoiceEdMonth");
		this.hashFields.put("invoice_st_month", "invoiceStMonth");
		this.hashFields.put("apro_usr_id", "aproUsrId");
		this.hashFields.put("cost_ed_month", "costEdMonth");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("invoice_user", "invoiceUser");
		this.hashFields.put("chg_tp", "chgTp");
		this.hashFields.put("pay_vndr_seq", "payVndrSeq");
		this.hashFields.put("inv_vat_amt", "invVatAmt");
		this.hashFields.put("whld_tax_amt", "whldTaxAmt");
		this.hashFields.put("inv_ttl_amt", "invTtlAmt");
		this.hashFields.put("lse_pay_tp_cd", "lsePayTpCd");
		this.hashFields.put("agmt_no", "agmtNo");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  searchTp
	*/
	public void	setSearchTp( String	searchTp ) {
		this.searchTp =	searchTp;
	}
 
	/**
	 * Column Info
	 * @return	searchTp
	 */
	 public	 String	getSearchTp() {
		 return	this.searchTp;
	 } 
 	/**
	* Column Info
	* @param  remark
	*/
	public void	setRemark( String	remark ) {
		this.remark =	remark;
	}
 
	/**
	 * Column Info
	 * @return	remark
	 */
	 public	 String	getRemark() {
		 return	this.remark;
	 } 
 	/**
	* Column Info
	* @param  chgCostYrmon
	*/
	public void	setChgCostYrmon( String	chgCostYrmon ) {
		this.chgCostYrmon =	chgCostYrmon;
	}
 
	/**
	 * Column Info
	 * @return	chgCostYrmon
	 */
	 public	 String	getChgCostYrmon() {
		 return	this.chgCostYrmon;
	 } 
 	/**
	* Column Info
	* @param  invIssDt
	*/
	public void	setInvIssDt( String	invIssDt ) {
		this.invIssDt =	invIssDt;
	}
 
	/**
	 * Column Info
	 * @return	invIssDt
	 */
	 public	 String	getInvIssDt() {
		 return	this.invIssDt;
	 } 
 	/**
	* Column Info
	* @param  invoiceNo
	*/
	public void	setInvoiceNo( String	invoiceNo ) {
		this.invoiceNo =	invoiceNo;
	}
 
	/**
	 * Column Info
	 * @return	invoiceNo
	 */
	 public	 String	getInvoiceNo() {
		 return	this.invoiceNo;
	 } 
 	/**
	* Column Info
	* @param  ifErrRsn
	*/
	public void	setIfErrRsn( String	ifErrRsn ) {
		this.ifErrRsn =	ifErrRsn;
	}
 
	/**
	 * Column Info
	 * @return	ifErrRsn
	 */
	 public	 String	getIfErrRsn() {
		 return	this.ifErrRsn;
	 } 
 	/**
	* Column Info
	* @param  invRcvDt
	*/
	public void	setInvRcvDt( String	invRcvDt ) {
		this.invRcvDt =	invRcvDt;
	}
 
	/**
	 * Column Info
	 * @return	invRcvDt
	 */
	 public	 String	getInvRcvDt() {
		 return	this.invRcvDt;
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
	* @param  invStsCd
	*/
	public void	setInvStsCd( String	invStsCd ) {
		this.invStsCd =	invStsCd;
	}
 
	/**
	 * Column Info
	 * @return	invStsCd
	 */
	 public	 String	getInvStsCd() {
		 return	this.invStsCd;
	 } 
 	/**
	* Column Info
	* @param  ifRgstNo
	*/
	public void	setIfRgstNo( String	ifRgstNo ) {
		this.ifRgstNo =	ifRgstNo;
	}
 
	/**
	 * Column Info
	 * @return	ifRgstNo
	 */
	 public	 String	getIfRgstNo() {
		 return	this.ifRgstNo;
	 } 
 	/**
	* Column Info
	* @param  lstmCd
	*/
	public void	setLstmCd( String	lstmCd ) {
		this.lstmCd =	lstmCd;
	}
 
	/**
	 * Column Info
	 * @return	lstmCd
	 */
	 public	 String	getLstmCd() {
		 return	this.lstmCd;
	 } 
 	/**
	* Column Info
	* @param  crTtlAmt
	*/
	public void	setCrTtlAmt( String	crTtlAmt ) {
		this.crTtlAmt =	crTtlAmt;
	}
 
	/**
	 * Column Info
	 * @return	crTtlAmt
	 */
	 public	 String	getCrTtlAmt() {
		 return	this.crTtlAmt;
	 } 
 	/**
	* Column Info
	* @param  lseInvApstsCd
	*/
	public void	setLseInvApstsCd( String	lseInvApstsCd ) {
		this.lseInvApstsCd =	lseInvApstsCd;
	}
 
	/**
	 * Column Info
	 * @return	lseInvApstsCd
	 */
	 public	 String	getLseInvApstsCd() {
		 return	this.lseInvApstsCd;
	 } 
 	/**
	* Column Info
	* @param  costStMonth
	*/
	public void	setCostStMonth( String	costStMonth ) {
		this.costStMonth =	costStMonth;
	}
 
	/**
	 * Column Info
	 * @return	costStMonth
	 */
	 public	 String	getCostStMonth() {
		 return	this.costStMonth;
	 } 
 	/**
	* Column Info
	* @param  ifFlg
	*/
	public void	setIfFlg( String	ifFlg ) {
		this.ifFlg =	ifFlg;
	}
 
	/**
	 * Column Info
	 * @return	ifFlg
	 */
	 public	 String	getIfFlg() {
		 return	this.ifFlg;
	 } 
 	/**
	* Column Info
	* @param  invEffYrmon
	*/
	public void	setInvEffYrmon( String	invEffYrmon ) {
		this.invEffYrmon =	invEffYrmon;
	}
 
	/**
	 * Column Info
	 * @return	invEffYrmon
	 */
	 public	 String	getInvEffYrmon() {
		 return	this.invEffYrmon;
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
	* @param  cancelFlag
	*/
	public void	setCancelFlag( String	cancelFlag ) {
		this.cancelFlag =	cancelFlag;
	}
 
	/**
	 * Column Info
	 * @return	cancelFlag
	 */
	 public	 String	getCancelFlag() {
		 return	this.cancelFlag;
	 } 
 	/**
	* Column Info
	* @param  registerNo
	*/
	public void	setRegisterNo( String	registerNo ) {
		this.registerNo =	registerNo;
	}
 
	/**
	 * Column Info
	 * @return	registerNo
	 */
	 public	 String	getRegisterNo() {
		 return	this.registerNo;
	 } 
 	/**
	* Column Info
	* @param  ttlCostAmt
	*/
	public void	setTtlCostAmt( String	ttlCostAmt ) {
		this.ttlCostAmt =	ttlCostAmt;
	}
 
	/**
	 * Column Info
	 * @return	ttlCostAmt
	 */
	 public	 String	getTtlCostAmt() {
		 return	this.ttlCostAmt;
	 } 
 	/**
	* Column Info
	* @param  payRntlCostAmt
	*/
	public void	setPayRntlCostAmt( String	payRntlCostAmt ) {
		this.payRntlCostAmt =	payRntlCostAmt;
	}
 
	/**
	 * Column Info
	 * @return	payRntlCostAmt
	 */
	 public	 String	getPayRntlCostAmt() {
		 return	this.payRntlCostAmt;
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
	* @param  invoiceEdMonth
	*/
	public void	setInvoiceEdMonth( String	invoiceEdMonth ) {
		this.invoiceEdMonth =	invoiceEdMonth;
	}
 
	/**
	 * Column Info
	 * @return	invoiceEdMonth
	 */
	 public	 String	getInvoiceEdMonth() {
		 return	this.invoiceEdMonth;
	 } 
 	/**
	* Column Info
	* @param  invoiceStMonth
	*/
	public void	setInvoiceStMonth( String	invoiceStMonth ) {
		this.invoiceStMonth =	invoiceStMonth;
	}
 
	/**
	 * Column Info
	 * @return	invoiceStMonth
	 */
	 public	 String	getInvoiceStMonth() {
		 return	this.invoiceStMonth;
	 } 
 	/**
	* Column Info
	* @param  aproUsrId
	*/
	public void	setAproUsrId( String	aproUsrId ) {
		this.aproUsrId =	aproUsrId;
	}
 
	/**
	 * Column Info
	 * @return	aproUsrId
	 */
	 public	 String	getAproUsrId() {
		 return	this.aproUsrId;
	 } 
 	/**
	* Column Info
	* @param  costEdMonth
	*/
	public void	setCostEdMonth( String	costEdMonth ) {
		this.costEdMonth =	costEdMonth;
	}
 
	/**
	 * Column Info
	 * @return	costEdMonth
	 */
	 public	 String	getCostEdMonth() {
		 return	this.costEdMonth;
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
	* @param  invoiceUser
	*/
	public void	setInvoiceUser( String	invoiceUser ) {
		this.invoiceUser =	invoiceUser;
	}
 
	/**
	 * Column Info
	 * @return	invoiceUser
	 */
	 public	 String	getInvoiceUser() {
		 return	this.invoiceUser;
	 } 
 	/**
	* Column Info
	* @param  chgTp
	*/
	public void	setChgTp( String	chgTp ) {
		this.chgTp =	chgTp;
	}
 
	/**
	 * Column Info
	 * @return	chgTp
	 */
	 public	 String	getChgTp() {
		 return	this.chgTp;
	 } 
 	/**
	* Column Info
	* @param  payVndrSeq
	*/
	public void	setPayVndrSeq( String	payVndrSeq ) {
		this.payVndrSeq =	payVndrSeq;
	}
 
	/**
	 * Column Info
	 * @return	payVndrSeq
	 */
	 public	 String	getPayVndrSeq() {
		 return	this.payVndrSeq;
	 } 
 	/**
	* Column Info
	* @param  invVatAmt
	*/
	public void	setInvVatAmt( String	invVatAmt ) {
		this.invVatAmt =	invVatAmt;
	}
 
	/**
	 * Column Info
	 * @return	invVatAmt
	 */
	 public	 String	getInvVatAmt() {
		 return	this.invVatAmt;
	 } 
 	/**
	* Column Info
	* @param  whldTaxAmt
	*/
	public void	setWhldTaxAmt( String	whldTaxAmt ) {
		this.whldTaxAmt =	whldTaxAmt;
	}
 
	/**
	 * Column Info
	 * @return	whldTaxAmt
	 */
	 public	 String	getWhldTaxAmt() {
		 return	this.whldTaxAmt;
	 } 
 	/**
	* Column Info
	* @param  invTtlAmt
	*/
	public void	setInvTtlAmt( String	invTtlAmt ) {
		this.invTtlAmt =	invTtlAmt;
	}
 
	/**
	 * Column Info
	 * @return	invTtlAmt
	 */
	 public	 String	getInvTtlAmt() {
		 return	this.invTtlAmt;
	 } 
 	/**
	* Column Info
	* @param  lsePayTpCd
	*/
	public void	setLsePayTpCd( String	lsePayTpCd ) {
		this.lsePayTpCd =	lsePayTpCd;
	}
 
	/**
	 * Column Info
	 * @return	lsePayTpCd
	 */
	 public	 String	getLsePayTpCd() {
		 return	this.lsePayTpCd;
	 } 
 	/**
	* Column Info
	* @param  agmtNo
	*/
	public void	setAgmtNo( String	agmtNo ) {
		this.agmtNo =	agmtNo;
	}
 
	/**
	 * Column Info
	 * @return	agmtNo
	 */
	 public	 String	getAgmtNo() {
		 return	this.agmtNo;
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
		setSearchTp(JSPUtil.getParameter(request,	prefix + "search_tp", ""));
		setRemark(JSPUtil.getParameter(request,	prefix + "remark", ""));
		setChgCostYrmon(JSPUtil.getParameter(request,	prefix + "chg_cost_yrmon", ""));
		setInvIssDt(JSPUtil.getParameter(request,	prefix + "inv_iss_dt", ""));
		setInvoiceNo(JSPUtil.getParameter(request,	prefix + "invoice_no", ""));
		setIfErrRsn(JSPUtil.getParameter(request,	prefix + "if_err_rsn", ""));
		setInvRcvDt(JSPUtil.getParameter(request,	prefix + "inv_rcv_dt", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setInvStsCd(JSPUtil.getParameter(request,	prefix + "inv_sts_cd", ""));
		setIfRgstNo(JSPUtil.getParameter(request,	prefix + "if_rgst_no", ""));
		setLstmCd(JSPUtil.getParameter(request,	prefix + "lstm_cd", ""));
		setCrTtlAmt(JSPUtil.getParameter(request,	prefix + "cr_ttl_amt", ""));
		setLseInvApstsCd(JSPUtil.getParameter(request,	prefix + "lse_inv_apsts_cd", ""));
		setCostStMonth(JSPUtil.getParameter(request,	prefix + "cost_st_month", ""));
		setIfFlg(JSPUtil.getParameter(request,	prefix + "if_flg", ""));
		setInvEffYrmon(JSPUtil.getParameter(request,	prefix + "inv_eff_yrmon", ""));
		setAproDt(JSPUtil.getParameter(request,	prefix + "apro_dt", ""));
		setCancelFlag(JSPUtil.getParameter(request,	prefix + "cancel_flag", ""));
		setRegisterNo(JSPUtil.getParameter(request,	prefix + "register_no", ""));
		setTtlCostAmt(JSPUtil.getParameter(request,	prefix + "ttl_cost_amt", ""));
		setPayRntlCostAmt(JSPUtil.getParameter(request,	prefix + "pay_rntl_cost_amt", ""));
		setInvNo(JSPUtil.getParameter(request,	prefix + "inv_no", ""));
		setInvoiceEdMonth(JSPUtil.getParameter(request,	prefix + "invoice_ed_month", ""));
		setInvoiceStMonth(JSPUtil.getParameter(request,	prefix + "invoice_st_month", ""));
		setAproUsrId(JSPUtil.getParameter(request,	prefix + "apro_usr_id", ""));
		setCostEdMonth(JSPUtil.getParameter(request,	prefix + "cost_ed_month", ""));
		setVndrSeq(JSPUtil.getParameter(request,	prefix + "vndr_seq", ""));
		setInvoiceUser(JSPUtil.getParameter(request,	prefix + "invoice_user", ""));
		setChgTp(JSPUtil.getParameter(request,	prefix + "chg_tp", ""));
		setPayVndrSeq(JSPUtil.getParameter(request,	prefix + "pay_vndr_seq", ""));
		setInvVatAmt(JSPUtil.getParameter(request,	prefix + "inv_vat_amt", ""));
		setWhldTaxAmt(JSPUtil.getParameter(request,	prefix + "whld_tax_amt", ""));
		setInvTtlAmt(JSPUtil.getParameter(request,	prefix + "inv_ttl_amt", ""));
		setLsePayTpCd(JSPUtil.getParameter(request,	prefix + "lse_pay_tp_cd", ""));
		setAgmtNo(JSPUtil.getParameter(request,	prefix + "agmt_no", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PayableRentalInvoiceCostVO[]
	 */
	public PayableRentalInvoiceCostVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return PayableRentalInvoiceCostVO[]
	 */
	public PayableRentalInvoiceCostVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		PayableRentalInvoiceCostVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] searchTp =	(JSPUtil.getParameter(request, prefix +	"search_tp".trim(),	length));
				String[] remark =	(JSPUtil.getParameter(request, prefix +	"remark".trim(),	length));
				String[] chgCostYrmon =	(JSPUtil.getParameter(request, prefix +	"chg_cost_yrmon".trim(),	length));
				String[] invIssDt =	(JSPUtil.getParameter(request, prefix +	"inv_iss_dt".trim(),	length));
				String[] invoiceNo =	(JSPUtil.getParameter(request, prefix +	"invoice_no".trim(),	length));
				String[] ifErrRsn =	(JSPUtil.getParameter(request, prefix +	"if_err_rsn".trim(),	length));
				String[] invRcvDt =	(JSPUtil.getParameter(request, prefix +	"inv_rcv_dt".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] invStsCd =	(JSPUtil.getParameter(request, prefix +	"inv_sts_cd".trim(),	length));
				String[] ifRgstNo =	(JSPUtil.getParameter(request, prefix +	"if_rgst_no".trim(),	length));
				String[] lstmCd =	(JSPUtil.getParameter(request, prefix +	"lstm_cd".trim(),	length));
				String[] crTtlAmt =	(JSPUtil.getParameter(request, prefix +	"cr_ttl_amt".trim(),	length));
				String[] lseInvApstsCd =	(JSPUtil.getParameter(request, prefix +	"lse_inv_apsts_cd".trim(),	length));
				String[] costStMonth =	(JSPUtil.getParameter(request, prefix +	"cost_st_month".trim(),	length));
				String[] ifFlg =	(JSPUtil.getParameter(request, prefix +	"if_flg".trim(),	length));
				String[] invEffYrmon =	(JSPUtil.getParameter(request, prefix +	"inv_eff_yrmon".trim(),	length));
				String[] aproDt =	(JSPUtil.getParameter(request, prefix +	"apro_dt".trim(),	length));
				String[] cancelFlag =	(JSPUtil.getParameter(request, prefix +	"cancel_flag".trim(),	length));
				String[] registerNo =	(JSPUtil.getParameter(request, prefix +	"register_no".trim(),	length));
				String[] ttlCostAmt =	(JSPUtil.getParameter(request, prefix +	"ttl_cost_amt".trim(),	length));
				String[] payRntlCostAmt =	(JSPUtil.getParameter(request, prefix +	"pay_rntl_cost_amt".trim(),	length));
				String[] invNo =	(JSPUtil.getParameter(request, prefix +	"inv_no".trim(),	length));
				String[] invoiceEdMonth =	(JSPUtil.getParameter(request, prefix +	"invoice_ed_month".trim(),	length));
				String[] invoiceStMonth =	(JSPUtil.getParameter(request, prefix +	"invoice_st_month".trim(),	length));
				String[] aproUsrId =	(JSPUtil.getParameter(request, prefix +	"apro_usr_id".trim(),	length));
				String[] costEdMonth =	(JSPUtil.getParameter(request, prefix +	"cost_ed_month".trim(),	length));
				String[] vndrSeq =	(JSPUtil.getParameter(request, prefix +	"vndr_seq".trim(),	length));
				String[] invoiceUser =	(JSPUtil.getParameter(request, prefix +	"invoice_user".trim(),	length));
				String[] chgTp =	(JSPUtil.getParameter(request, prefix +	"chg_tp".trim(),	length));
				String[] payVndrSeq =	(JSPUtil.getParameter(request, prefix +	"pay_vndr_seq".trim(),	length));
				String[] invVatAmt =	(JSPUtil.getParameter(request, prefix +	"inv_vat_amt".trim(),	length));
				String[] whldTaxAmt =	(JSPUtil.getParameter(request, prefix +	"whld_tax_amt".trim(),	length));
				String[] invTtlAmt =	(JSPUtil.getParameter(request, prefix +	"inv_ttl_amt".trim(),	length));
				String[] lsePayTpCd =	(JSPUtil.getParameter(request, prefix +	"lse_pay_tp_cd".trim(),	length));
				String[] agmtNo =	(JSPUtil.getParameter(request, prefix +	"agmt_no".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	PayableRentalInvoiceCostVO();
						if ( searchTp[i] !=	null)
						model.setSearchTp( searchTp[i]);
						if ( remark[i] !=	null)
						model.setRemark( remark[i]);
						if ( chgCostYrmon[i] !=	null)
						model.setChgCostYrmon( chgCostYrmon[i]);
						if ( invIssDt[i] !=	null)
						model.setInvIssDt( invIssDt[i]);
						if ( invoiceNo[i] !=	null)
						model.setInvoiceNo( invoiceNo[i]);
						if ( ifErrRsn[i] !=	null)
						model.setIfErrRsn( ifErrRsn[i]);
						if ( invRcvDt[i] !=	null)
						model.setInvRcvDt( invRcvDt[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( invStsCd[i] !=	null)
						model.setInvStsCd( invStsCd[i]);
						if ( ifRgstNo[i] !=	null)
						model.setIfRgstNo( ifRgstNo[i]);
						if ( lstmCd[i] !=	null)
						model.setLstmCd( lstmCd[i]);
						if ( crTtlAmt[i] !=	null)
						model.setCrTtlAmt( crTtlAmt[i]);
						if ( lseInvApstsCd[i] !=	null)
						model.setLseInvApstsCd( lseInvApstsCd[i]);
						if ( costStMonth[i] !=	null)
						model.setCostStMonth( costStMonth[i]);
						if ( ifFlg[i] !=	null)
						model.setIfFlg( ifFlg[i]);
						if ( invEffYrmon[i] !=	null)
						model.setInvEffYrmon( invEffYrmon[i]);
						if ( aproDt[i] !=	null)
						model.setAproDt( aproDt[i]);
						if ( cancelFlag[i] !=	null)
						model.setCancelFlag( cancelFlag[i]);
						if ( registerNo[i] !=	null)
						model.setRegisterNo( registerNo[i]);
						if ( ttlCostAmt[i] !=	null)
						model.setTtlCostAmt( ttlCostAmt[i]);
						if ( payRntlCostAmt[i] !=	null)
						model.setPayRntlCostAmt( payRntlCostAmt[i]);
						if ( invNo[i] !=	null)
						model.setInvNo( invNo[i]);
						if ( invoiceEdMonth[i] !=	null)
						model.setInvoiceEdMonth( invoiceEdMonth[i]);
						if ( invoiceStMonth[i] !=	null)
						model.setInvoiceStMonth( invoiceStMonth[i]);
						if ( aproUsrId[i] !=	null)
						model.setAproUsrId( aproUsrId[i]);
						if ( costEdMonth[i] !=	null)
						model.setCostEdMonth( costEdMonth[i]);
						if ( vndrSeq[i] !=	null)
						model.setVndrSeq( vndrSeq[i]);
						if ( invoiceUser[i] !=	null)
						model.setInvoiceUser( invoiceUser[i]);
						if ( chgTp[i] !=	null)
						model.setChgTp( chgTp[i]);
						if ( payVndrSeq[i] !=	null)
						model.setPayVndrSeq( payVndrSeq[i]);
						if ( invVatAmt[i] !=	null)
						model.setInvVatAmt( invVatAmt[i]);
						if ( whldTaxAmt[i] !=	null)
						model.setWhldTaxAmt( whldTaxAmt[i]);
						if ( invTtlAmt[i] !=	null)
						model.setInvTtlAmt( invTtlAmt[i]);
						if ( lsePayTpCd[i] !=	null)
						model.setLsePayTpCd( lsePayTpCd[i]);
						if ( agmtNo[i] !=	null)
						model.setAgmtNo( agmtNo[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getPayableRentalInvoiceCostVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return PayableRentalInvoiceCostVO[]
	 */
	public PayableRentalInvoiceCostVO[]	 getPayableRentalInvoiceCostVOs(){
		PayableRentalInvoiceCostVO[] vos = (PayableRentalInvoiceCostVO[])models.toArray(new	PayableRentalInvoiceCostVO[models.size()]);
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
		this.searchTp =	this.searchTp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remark =	this.remark.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCostYrmon =	this.chgCostYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIssDt =	this.invIssDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invoiceNo =	this.invoiceNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifErrRsn =	this.ifErrRsn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRcvDt =	this.invRcvDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invStsCd =	this.invStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifRgstNo =	this.ifRgstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd =	this.lstmCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crTtlAmt =	this.crTtlAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lseInvApstsCd =	this.lseInvApstsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costStMonth =	this.costStMonth.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifFlg =	this.ifFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invEffYrmon =	this.invEffYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproDt =	this.aproDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cancelFlag =	this.cancelFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.registerNo =	this.registerNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlCostAmt =	this.ttlCostAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payRntlCostAmt =	this.payRntlCostAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo =	this.invNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invoiceEdMonth =	this.invoiceEdMonth.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invoiceStMonth =	this.invoiceStMonth.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproUsrId =	this.aproUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costEdMonth =	this.costEdMonth.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq =	this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invoiceUser =	this.invoiceUser.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgTp =	this.chgTp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payVndrSeq =	this.payVndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invVatAmt =	this.invVatAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whldTaxAmt =	this.whldTaxAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTtlAmt =	this.invTtlAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lsePayTpCd =	this.lsePayTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo =	this.agmtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}