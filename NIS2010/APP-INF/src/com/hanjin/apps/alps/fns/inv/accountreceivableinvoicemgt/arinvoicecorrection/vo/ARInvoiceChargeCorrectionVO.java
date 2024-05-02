/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ARInvoiceChargeCorrectionVO.java
 *@FileTitle : ARInvoiceChargeCorrectionVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2017.08.01
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2017.08.01  
 * 1.0 Creation
=========================================================*/

package	 com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer	Object including Parameters)<br>
 * - 愿��젴	Event�뿉�꽌	�옉�꽦,	�꽌踰꾩떎�뻾�슂泥��떆	PDTO�쓽 �뿭�븷�쓣 �닔�뻾�븯�뒗 Value Object<br>
 * 
 * @author 
 * @since J2EE 1.6
 * @see	..
 */
public class ARInvoiceChargeCorrectionVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<ARInvoiceChargeCorrectionVO>  models =	new	ArrayList<ARInvoiceChargeCorrectionVO>();


	/*	Column Info	*/
	private  String	 repChgCd   =  null;
	/*	Column Info	*/
	private  String	 revCoaDirCd   =  null;
	/*	Column Info	*/
	private  String	 currCd   =  null;
	/*	Column Info	*/
	private  String	 trfRtAmt   =  null;
	/*	Column Info	*/
	private  String	 chgSeq   =  null;
	/*	Column Info	*/
	private  String	 totalAmt   =  null;
	/*	Column Info	*/
	private  String	 tjSrcNm   =  null;
	/*	Column Info	*/
	private  String	 chgCd   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 revCoaAcctCd   =  null;
	/*	Column Info	*/
	private  String	 lclAmount   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 acctCd   =  null;
	/*	Column Info	*/
	private  String	 revCoaCtrCd   =  null;
	/*	Column Info	*/
	private  String	 chgAmt   =  null;
	/*	Column Info	*/
	private  String	 revCoaCoCd   =  null;
	/*	Column Info	*/
	private  String	 invXchRtDt   =  null;
	/*	Column Info	*/
	private  String	 lclCurrCd   =  null;
	/*	Column Info	*/
	private  String	 invXchRt   =  null;
	/*	Column Info	*/
	private  String	 chgRmk   =  null;
	/*	Column Info	*/
	private  String	 sobId   =  null;
	/*	Column Info	*/
	private  String	 invRevTpSrcCd   =  null;
	/*	Column Info	*/
	private  String	 revCoaVslCd   =  null;
	/*	Column Info	*/
	private  String	 perTpCd   =  null;
	/*	Column Info	*/
	private  String	 chgFullNm   =  null;
	/*	Column Info	*/
	private  String	 revCoaSkdDirCd   =  null;
	/*	Column Info	*/
	private  String	 revCoaRgnCd   =  null;
	/*	Column Info	*/
	private  String	 mfDivCd   =  null;
	/*	Column Info	*/
	private  String	 revCoaVoyNo   =  null;
	/*	Column Info	*/
	private  String	 trfNo   =  null;
	/*	Column Info	*/
	private  String	 revCoaInterCoCd   =  null;
	/*	Column Info	*/
	private  String	 ratAsCntrQty   =  null;
	/*	Column Info	*/
	private  String	 arIfSerNo   =  null;
	/*	Column Info	*/
	private  String	 tvaFlg   =  null;
	/*	Column Info	*/
	private  String	 mnlFlg   =  null;
	/*	Column Info	*/
	private  String	 dpPrcsKnt   =  null;
	/*	Column Info	*/
	private  String	 idaCgstAmt   =  null;
	/*	Column Info	*/
	private  String	 idaSgstAmt   =  null;
	/*	Column Info	*/
	private  String	 idaUgstAmt   =  null;
	/*	Column Info	*/
	private  String	 idaIgstAmt   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public ARInvoiceChargeCorrectionVO(){}

	public ARInvoiceChargeCorrectionVO(String repChgCd,String revCoaDirCd,String currCd,String trfRtAmt,String chgSeq,String totalAmt,String tjSrcNm,String chgCd,String pagerows,String revCoaAcctCd,String lclAmount,String ibflag,String acctCd,String revCoaCtrCd,String chgAmt,String revCoaCoCd,String invXchRtDt,String lclCurrCd,String invXchRt,String chgRmk,String sobId,String invRevTpSrcCd,String revCoaVslCd,String perTpCd,String chgFullNm,String revCoaSkdDirCd,String revCoaRgnCd,String mfDivCd,String revCoaVoyNo,String trfNo,String revCoaInterCoCd,String ratAsCntrQty,String arIfSerNo,String tvaFlg,String mnlFlg,String dpPrcsKnt,String idaCgstAmt,String idaSgstAmt,String idaUgstAmt,String idaIgstAmt)	{
		this.repChgCd  = repChgCd ;
		this.revCoaDirCd  = revCoaDirCd ;
		this.currCd  = currCd ;
		this.trfRtAmt  = trfRtAmt ;
		this.chgSeq  = chgSeq ;
		this.totalAmt  = totalAmt ;
		this.tjSrcNm  = tjSrcNm ;
		this.chgCd  = chgCd ;
		this.pagerows  = pagerows ;
		this.revCoaAcctCd  = revCoaAcctCd ;
		this.lclAmount  = lclAmount ;
		this.ibflag  = ibflag ;
		this.acctCd  = acctCd ;
		this.revCoaCtrCd  = revCoaCtrCd ;
		this.chgAmt  = chgAmt ;
		this.revCoaCoCd  = revCoaCoCd ;
		this.invXchRtDt  = invXchRtDt ;
		this.lclCurrCd  = lclCurrCd ;
		this.invXchRt  = invXchRt ;
		this.chgRmk  = chgRmk ;
		this.sobId  = sobId ;
		this.invRevTpSrcCd  = invRevTpSrcCd ;
		this.revCoaVslCd  = revCoaVslCd ;
		this.perTpCd  = perTpCd ;
		this.chgFullNm  = chgFullNm ;
		this.revCoaSkdDirCd  = revCoaSkdDirCd ;
		this.revCoaRgnCd  = revCoaRgnCd ;
		this.mfDivCd  = mfDivCd ;
		this.revCoaVoyNo  = revCoaVoyNo ;
		this.trfNo  = trfNo ;
		this.revCoaInterCoCd  = revCoaInterCoCd ;
		this.ratAsCntrQty  = ratAsCntrQty ;
		this.arIfSerNo  = arIfSerNo ;
		this.tvaFlg  = tvaFlg ;
		this.mnlFlg  = mnlFlg ;
		this.dpPrcsKnt  = dpPrcsKnt ;
		this.idaCgstAmt  = idaCgstAmt ;
		this.idaSgstAmt  = idaSgstAmt ;
		this.idaUgstAmt  = idaUgstAmt ;
		this.idaIgstAmt  = idaIgstAmt ;
	}


	/**
	 * �뀒�씠釉� 而щ읆�뿉 ���옣�븷 媛믪쓣 Hashtable<"column_name", "value">	濡� 諛섑솚
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rep_chg_cd", getRepChgCd());		
		this.hashColumns.put("rev_coa_dir_cd", getRevCoaDirCd());		
		this.hashColumns.put("curr_cd", getCurrCd());		
		this.hashColumns.put("trf_rt_amt", getTrfRtAmt());		
		this.hashColumns.put("chg_seq", getChgSeq());		
		this.hashColumns.put("total_amt", getTotalAmt());		
		this.hashColumns.put("tj_src_nm", getTjSrcNm());		
		this.hashColumns.put("chg_cd", getChgCd());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("rev_coa_acct_cd", getRevCoaAcctCd());		
		this.hashColumns.put("lcl_amount", getLclAmount());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("acct_cd", getAcctCd());		
		this.hashColumns.put("rev_coa_ctr_cd", getRevCoaCtrCd());		
		this.hashColumns.put("chg_amt", getChgAmt());		
		this.hashColumns.put("rev_coa_co_cd", getRevCoaCoCd());		
		this.hashColumns.put("inv_xch_rt_dt", getInvXchRtDt());		
		this.hashColumns.put("lcl_curr_cd", getLclCurrCd());		
		this.hashColumns.put("inv_xch_rt", getInvXchRt());		
		this.hashColumns.put("chg_rmk", getChgRmk());		
		this.hashColumns.put("sob_id", getSobId());		
		this.hashColumns.put("inv_rev_tp_src_cd", getInvRevTpSrcCd());		
		this.hashColumns.put("rev_coa_vsl_cd", getRevCoaVslCd());		
		this.hashColumns.put("per_tp_cd", getPerTpCd());		
		this.hashColumns.put("chg_full_nm", getChgFullNm());		
		this.hashColumns.put("rev_coa_skd_dir_cd", getRevCoaSkdDirCd());		
		this.hashColumns.put("rev_coa_rgn_cd", getRevCoaRgnCd());		
		this.hashColumns.put("mf_div_cd", getMfDivCd());		
		this.hashColumns.put("rev_coa_voy_no", getRevCoaVoyNo());		
		this.hashColumns.put("trf_no", getTrfNo());		
		this.hashColumns.put("rev_coa_inter_co_cd", getRevCoaInterCoCd());		
		this.hashColumns.put("rat_as_cntr_qty", getRatAsCntrQty());		
		this.hashColumns.put("ar_if_ser_no", getArIfSerNo());		
		this.hashColumns.put("tva_flg", getTvaFlg());		
		this.hashColumns.put("mnl_flg", getMnlFlg());		
		this.hashColumns.put("dp_prcs_knt", getDpPrcsKnt());		
		this.hashColumns.put("ida_cgst_amt", getIdaCgstAmt());		
		this.hashColumns.put("ida_sgst_amt", getIdaSgstAmt());		
		this.hashColumns.put("ida_ugst_amt", getIdaUgstAmt());		
		this.hashColumns.put("ida_igst_amt", getIdaIgstAmt());		
		return this.hashColumns;
}

	/**
	 * 而щ읆紐낆뿉	���쓳�릺�뒗 硫ㅻ쾭蹂��닔紐낆쓣	���옣�븯�뿬 Hashtable<"column_name", "variable"> 濡� 諛섑솚
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("rep_chg_cd", "repChgCd");
		this.hashFields.put("rev_coa_dir_cd", "revCoaDirCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("trf_rt_amt", "trfRtAmt");
		this.hashFields.put("chg_seq", "chgSeq");
		this.hashFields.put("total_amt", "totalAmt");
		this.hashFields.put("tj_src_nm", "tjSrcNm");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rev_coa_acct_cd", "revCoaAcctCd");
		this.hashFields.put("lcl_amount", "lclAmount");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("rev_coa_ctr_cd", "revCoaCtrCd");
		this.hashFields.put("chg_amt", "chgAmt");
		this.hashFields.put("rev_coa_co_cd", "revCoaCoCd");
		this.hashFields.put("inv_xch_rt_dt", "invXchRtDt");
		this.hashFields.put("lcl_curr_cd", "lclCurrCd");
		this.hashFields.put("inv_xch_rt", "invXchRt");
		this.hashFields.put("chg_rmk", "chgRmk");
		this.hashFields.put("sob_id", "sobId");
		this.hashFields.put("inv_rev_tp_src_cd", "invRevTpSrcCd");
		this.hashFields.put("rev_coa_vsl_cd", "revCoaVslCd");
		this.hashFields.put("per_tp_cd", "perTpCd");
		this.hashFields.put("chg_full_nm", "chgFullNm");
		this.hashFields.put("rev_coa_skd_dir_cd", "revCoaSkdDirCd");
		this.hashFields.put("rev_coa_rgn_cd", "revCoaRgnCd");
		this.hashFields.put("mf_div_cd", "mfDivCd");
		this.hashFields.put("rev_coa_voy_no", "revCoaVoyNo");
		this.hashFields.put("trf_no", "trfNo");
		this.hashFields.put("rev_coa_inter_co_cd", "revCoaInterCoCd");
		this.hashFields.put("rat_as_cntr_qty", "ratAsCntrQty");
		this.hashFields.put("ar_if_ser_no", "arIfSerNo");
		this.hashFields.put("tva_flg", "tvaFlg");
		this.hashFields.put("mnl_flg", "mnlFlg");
		this.hashFields.put("dp_prcs_knt", "dpPrcsKnt");
		this.hashFields.put("ida_cgst_amt", "idaCgstAmt");
		this.hashFields.put("ida_sgst_amt", "idaSgstAmt");
		this.hashFields.put("ida_ugst_amt", "idaUgstAmt");
		this.hashFields.put("ida_igst_amt", "idaIgstAmt");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  repChgCd
	*/
	public void	setRepChgCd( String	repChgCd ) {
		this.repChgCd =	repChgCd;
	}
 
	/**
	 * Column Info
	 * @return	repChgCd
	 */
	 public	 String	getRepChgCd() {
		 return	this.repChgCd;
	 } 
 	/**
	* Column Info
	* @param  revCoaDirCd
	*/
	public void	setRevCoaDirCd( String	revCoaDirCd ) {
		this.revCoaDirCd =	revCoaDirCd;
	}
 
	/**
	 * Column Info
	 * @return	revCoaDirCd
	 */
	 public	 String	getRevCoaDirCd() {
		 return	this.revCoaDirCd;
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
	* @param  trfRtAmt
	*/
	public void	setTrfRtAmt( String	trfRtAmt ) {
		this.trfRtAmt =	trfRtAmt;
	}
 
	/**
	 * Column Info
	 * @return	trfRtAmt
	 */
	 public	 String	getTrfRtAmt() {
		 return	this.trfRtAmt;
	 } 
 	/**
	* Column Info
	* @param  chgSeq
	*/
	public void	setChgSeq( String	chgSeq ) {
		this.chgSeq =	chgSeq;
	}
 
	/**
	 * Column Info
	 * @return	chgSeq
	 */
	 public	 String	getChgSeq() {
		 return	this.chgSeq;
	 } 
 	/**
	* Column Info
	* @param  totalAmt
	*/
	public void	setTotalAmt( String	totalAmt ) {
		this.totalAmt =	totalAmt;
	}
 
	/**
	 * Column Info
	 * @return	totalAmt
	 */
	 public	 String	getTotalAmt() {
		 return	this.totalAmt;
	 } 
 	/**
	* Column Info
	* @param  tjSrcNm
	*/
	public void	setTjSrcNm( String	tjSrcNm ) {
		this.tjSrcNm =	tjSrcNm;
	}
 
	/**
	 * Column Info
	 * @return	tjSrcNm
	 */
	 public	 String	getTjSrcNm() {
		 return	this.tjSrcNm;
	 } 
 	/**
	* Column Info
	* @param  chgCd
	*/
	public void	setChgCd( String	chgCd ) {
		this.chgCd =	chgCd;
	}
 
	/**
	 * Column Info
	 * @return	chgCd
	 */
	 public	 String	getChgCd() {
		 return	this.chgCd;
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
	* @param  revCoaAcctCd
	*/
	public void	setRevCoaAcctCd( String	revCoaAcctCd ) {
		this.revCoaAcctCd =	revCoaAcctCd;
	}
 
	/**
	 * Column Info
	 * @return	revCoaAcctCd
	 */
	 public	 String	getRevCoaAcctCd() {
		 return	this.revCoaAcctCd;
	 } 
 	/**
	* Column Info
	* @param  lclAmount
	*/
	public void	setLclAmount( String	lclAmount ) {
		this.lclAmount =	lclAmount;
	}
 
	/**
	 * Column Info
	 * @return	lclAmount
	 */
	 public	 String	getLclAmount() {
		 return	this.lclAmount;
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
	* @param  acctCd
	*/
	public void	setAcctCd( String	acctCd ) {
		this.acctCd =	acctCd;
	}
 
	/**
	 * Column Info
	 * @return	acctCd
	 */
	 public	 String	getAcctCd() {
		 return	this.acctCd;
	 } 
 	/**
	* Column Info
	* @param  revCoaCtrCd
	*/
	public void	setRevCoaCtrCd( String	revCoaCtrCd ) {
		this.revCoaCtrCd =	revCoaCtrCd;
	}
 
	/**
	 * Column Info
	 * @return	revCoaCtrCd
	 */
	 public	 String	getRevCoaCtrCd() {
		 return	this.revCoaCtrCd;
	 } 
 	/**
	* Column Info
	* @param  chgAmt
	*/
	public void	setChgAmt( String	chgAmt ) {
		this.chgAmt =	chgAmt;
	}
 
	/**
	 * Column Info
	 * @return	chgAmt
	 */
	 public	 String	getChgAmt() {
		 return	this.chgAmt;
	 } 
 	/**
	* Column Info
	* @param  revCoaCoCd
	*/
	public void	setRevCoaCoCd( String	revCoaCoCd ) {
		this.revCoaCoCd =	revCoaCoCd;
	}
 
	/**
	 * Column Info
	 * @return	revCoaCoCd
	 */
	 public	 String	getRevCoaCoCd() {
		 return	this.revCoaCoCd;
	 } 
 	/**
	* Column Info
	* @param  invXchRtDt
	*/
	public void	setInvXchRtDt( String	invXchRtDt ) {
		this.invXchRtDt =	invXchRtDt;
	}
 
	/**
	 * Column Info
	 * @return	invXchRtDt
	 */
	 public	 String	getInvXchRtDt() {
		 return	this.invXchRtDt;
	 } 
 	/**
	* Column Info
	* @param  lclCurrCd
	*/
	public void	setLclCurrCd( String	lclCurrCd ) {
		this.lclCurrCd =	lclCurrCd;
	}
 
	/**
	 * Column Info
	 * @return	lclCurrCd
	 */
	 public	 String	getLclCurrCd() {
		 return	this.lclCurrCd;
	 } 
 	/**
	* Column Info
	* @param  invXchRt
	*/
	public void	setInvXchRt( String	invXchRt ) {
		this.invXchRt =	invXchRt;
	}
 
	/**
	 * Column Info
	 * @return	invXchRt
	 */
	 public	 String	getInvXchRt() {
		 return	this.invXchRt;
	 } 
 	/**
	* Column Info
	* @param  chgRmk
	*/
	public void	setChgRmk( String	chgRmk ) {
		this.chgRmk =	chgRmk;
	}
 
	/**
	 * Column Info
	 * @return	chgRmk
	 */
	 public	 String	getChgRmk() {
		 return	this.chgRmk;
	 } 
 	/**
	* Column Info
	* @param  sobId
	*/
	public void	setSobId( String	sobId ) {
		this.sobId =	sobId;
	}
 
	/**
	 * Column Info
	 * @return	sobId
	 */
	 public	 String	getSobId() {
		 return	this.sobId;
	 } 
 	/**
	* Column Info
	* @param  invRevTpSrcCd
	*/
	public void	setInvRevTpSrcCd( String	invRevTpSrcCd ) {
		this.invRevTpSrcCd =	invRevTpSrcCd;
	}
 
	/**
	 * Column Info
	 * @return	invRevTpSrcCd
	 */
	 public	 String	getInvRevTpSrcCd() {
		 return	this.invRevTpSrcCd;
	 } 
 	/**
	* Column Info
	* @param  revCoaVslCd
	*/
	public void	setRevCoaVslCd( String	revCoaVslCd ) {
		this.revCoaVslCd =	revCoaVslCd;
	}
 
	/**
	 * Column Info
	 * @return	revCoaVslCd
	 */
	 public	 String	getRevCoaVslCd() {
		 return	this.revCoaVslCd;
	 } 
 	/**
	* Column Info
	* @param  perTpCd
	*/
	public void	setPerTpCd( String	perTpCd ) {
		this.perTpCd =	perTpCd;
	}
 
	/**
	 * Column Info
	 * @return	perTpCd
	 */
	 public	 String	getPerTpCd() {
		 return	this.perTpCd;
	 } 
 	/**
	* Column Info
	* @param  chgFullNm
	*/
	public void	setChgFullNm( String	chgFullNm ) {
		this.chgFullNm =	chgFullNm;
	}
 
	/**
	 * Column Info
	 * @return	chgFullNm
	 */
	 public	 String	getChgFullNm() {
		 return	this.chgFullNm;
	 } 
 	/**
	* Column Info
	* @param  revCoaSkdDirCd
	*/
	public void	setRevCoaSkdDirCd( String	revCoaSkdDirCd ) {
		this.revCoaSkdDirCd =	revCoaSkdDirCd;
	}
 
	/**
	 * Column Info
	 * @return	revCoaSkdDirCd
	 */
	 public	 String	getRevCoaSkdDirCd() {
		 return	this.revCoaSkdDirCd;
	 } 
 	/**
	* Column Info
	* @param  revCoaRgnCd
	*/
	public void	setRevCoaRgnCd( String	revCoaRgnCd ) {
		this.revCoaRgnCd =	revCoaRgnCd;
	}
 
	/**
	 * Column Info
	 * @return	revCoaRgnCd
	 */
	 public	 String	getRevCoaRgnCd() {
		 return	this.revCoaRgnCd;
	 } 
 	/**
	* Column Info
	* @param  mfDivCd
	*/
	public void	setMfDivCd( String	mfDivCd ) {
		this.mfDivCd =	mfDivCd;
	}
 
	/**
	 * Column Info
	 * @return	mfDivCd
	 */
	 public	 String	getMfDivCd() {
		 return	this.mfDivCd;
	 } 
 	/**
	* Column Info
	* @param  revCoaVoyNo
	*/
	public void	setRevCoaVoyNo( String	revCoaVoyNo ) {
		this.revCoaVoyNo =	revCoaVoyNo;
	}
 
	/**
	 * Column Info
	 * @return	revCoaVoyNo
	 */
	 public	 String	getRevCoaVoyNo() {
		 return	this.revCoaVoyNo;
	 } 
 	/**
	* Column Info
	* @param  trfNo
	*/
	public void	setTrfNo( String	trfNo ) {
		this.trfNo =	trfNo;
	}
 
	/**
	 * Column Info
	 * @return	trfNo
	 */
	 public	 String	getTrfNo() {
		 return	this.trfNo;
	 } 
 	/**
	* Column Info
	* @param  revCoaInterCoCd
	*/
	public void	setRevCoaInterCoCd( String	revCoaInterCoCd ) {
		this.revCoaInterCoCd =	revCoaInterCoCd;
	}
 
	/**
	 * Column Info
	 * @return	revCoaInterCoCd
	 */
	 public	 String	getRevCoaInterCoCd() {
		 return	this.revCoaInterCoCd;
	 } 
 	/**
	* Column Info
	* @param  ratAsCntrQty
	*/
	public void	setRatAsCntrQty( String	ratAsCntrQty ) {
		this.ratAsCntrQty =	ratAsCntrQty;
	}
 
	/**
	 * Column Info
	 * @return	ratAsCntrQty
	 */
	 public	 String	getRatAsCntrQty() {
		 return	this.ratAsCntrQty;
	 } 
 	/**
	* Column Info
	* @param  arIfSerNo
	*/
	public void	setArIfSerNo( String	arIfSerNo ) {
		this.arIfSerNo =	arIfSerNo;
	}
 
	/**
	 * Column Info
	 * @return	arIfSerNo
	 */
	 public	 String	getArIfSerNo() {
		 return	this.arIfSerNo;
	 } 
 	/**
	* Column Info
	* @param  tvaFlg
	*/
	public void	setTvaFlg( String	tvaFlg ) {
		this.tvaFlg =	tvaFlg;
	}
 
	/**
	 * Column Info
	 * @return	tvaFlg
	 */
	 public	 String	getTvaFlg() {
		 return	this.tvaFlg;
	 } 
 	/**
	* Column Info
	* @param  mnlFlg
	*/
	public void	setMnlFlg( String	mnlFlg ) {
		this.mnlFlg =	mnlFlg;
	}
 
	/**
	 * Column Info
	 * @return	mnlFlg
	 */
	 public	 String	getMnlFlg() {
		 return	this.mnlFlg;
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
	* @param  idaCgstAmt
	*/
	public void	setIdaCgstAmt( String	idaCgstAmt ) {
		this.idaCgstAmt =	idaCgstAmt;
	}
 
	/**
	 * Column Info
	 * @return	idaCgstAmt
	 */
	 public	 String	getIdaCgstAmt() {
		 return	this.idaCgstAmt;
	 } 
 	/**
	* Column Info
	* @param  idaSgstAmt
	*/
	public void	setIdaSgstAmt( String	idaSgstAmt ) {
		this.idaSgstAmt =	idaSgstAmt;
	}
 
	/**
	 * Column Info
	 * @return	idaSgstAmt
	 */
	 public	 String	getIdaSgstAmt() {
		 return	this.idaSgstAmt;
	 } 
 	/**
	* Column Info
	* @param  idaUgstAmt
	*/
	public void	setIdaUgstAmt( String	idaUgstAmt ) {
		this.idaUgstAmt =	idaUgstAmt;
	}
 
	/**
	 * Column Info
	 * @return	idaUgstAmt
	 */
	 public	 String	getIdaUgstAmt() {
		 return	this.idaUgstAmt;
	 } 
 	/**
	* Column Info
	* @param  idaIgstAmt
	*/
	public void	setIdaIgstAmt( String	idaIgstAmt ) {
		this.idaIgstAmt =	idaIgstAmt;
	}
 
	/**
	 * Column Info
	 * @return	idaIgstAmt
	 */
	 public	 String	getIdaIgstAmt() {
		 return	this.idaIgstAmt;
	 } 

	/**
	 * Request �쓽 �뜲�씠�꽣瑜� 異붿텧�븯�뿬 VO �쓽	硫ㅻ쾭蹂��닔�뿉 �꽕�젙.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request)	{
		fromRequest(request,"");
	}

	/**
	 * Request �쓽 �뜲�씠�꽣瑜� 異붿텧�븯�뿬 VO �쓽	硫ㅻ쾭蹂��닔�뿉 �꽕�젙.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request,	String prefix) {
		setRepChgCd(JSPUtil.getParameter(request,	prefix + "rep_chg_cd", ""));
		setRevCoaDirCd(JSPUtil.getParameter(request,	prefix + "rev_coa_dir_cd", ""));
		setCurrCd(JSPUtil.getParameter(request,	prefix + "curr_cd", ""));
		setTrfRtAmt(JSPUtil.getParameter(request,	prefix + "trf_rt_amt", ""));
		setChgSeq(JSPUtil.getParameter(request,	prefix + "chg_seq", ""));
		setTotalAmt(JSPUtil.getParameter(request,	prefix + "total_amt", ""));
		setTjSrcNm(JSPUtil.getParameter(request,	prefix + "tj_src_nm", ""));
		setChgCd(JSPUtil.getParameter(request,	prefix + "chg_cd", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setRevCoaAcctCd(JSPUtil.getParameter(request,	prefix + "rev_coa_acct_cd", ""));
		setLclAmount(JSPUtil.getParameter(request,	prefix + "lcl_amount", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setAcctCd(JSPUtil.getParameter(request,	prefix + "acct_cd", ""));
		setRevCoaCtrCd(JSPUtil.getParameter(request,	prefix + "rev_coa_ctr_cd", ""));
		setChgAmt(JSPUtil.getParameter(request,	prefix + "chg_amt", ""));
		setRevCoaCoCd(JSPUtil.getParameter(request,	prefix + "rev_coa_co_cd", ""));
		setInvXchRtDt(JSPUtil.getParameter(request,	prefix + "inv_xch_rt_dt", ""));
		setLclCurrCd(JSPUtil.getParameter(request,	prefix + "lcl_curr_cd", ""));
		setInvXchRt(JSPUtil.getParameter(request,	prefix + "inv_xch_rt", ""));
		setChgRmk(JSPUtil.getParameter(request,	prefix + "chg_rmk", ""));
		setSobId(JSPUtil.getParameter(request,	prefix + "sob_id", ""));
		setInvRevTpSrcCd(JSPUtil.getParameter(request,	prefix + "inv_rev_tp_src_cd", ""));
		setRevCoaVslCd(JSPUtil.getParameter(request,	prefix + "rev_coa_vsl_cd", ""));
		setPerTpCd(JSPUtil.getParameter(request,	prefix + "per_tp_cd", ""));
		setChgFullNm(JSPUtil.getParameter(request,	prefix + "chg_full_nm", ""));
		setRevCoaSkdDirCd(JSPUtil.getParameter(request,	prefix + "rev_coa_skd_dir_cd", ""));
		setRevCoaRgnCd(JSPUtil.getParameter(request,	prefix + "rev_coa_rgn_cd", ""));
		setMfDivCd(JSPUtil.getParameter(request,	prefix + "mf_div_cd", ""));
		setRevCoaVoyNo(JSPUtil.getParameter(request,	prefix + "rev_coa_voy_no", ""));
		setTrfNo(JSPUtil.getParameter(request,	prefix + "trf_no", ""));
		setRevCoaInterCoCd(JSPUtil.getParameter(request,	prefix + "rev_coa_inter_co_cd", ""));
		setRatAsCntrQty(JSPUtil.getParameter(request,	prefix + "rat_as_cntr_qty", ""));
		setArIfSerNo(JSPUtil.getParameter(request,	prefix + "ar_if_ser_no", ""));
		setTvaFlg(JSPUtil.getParameter(request,	prefix + "tva_flg", ""));
		setMnlFlg(JSPUtil.getParameter(request,	prefix + "mnl_flg", ""));
		setDpPrcsKnt(JSPUtil.getParameter(request,	prefix + "dp_prcs_knt", ""));
		setIdaCgstAmt(JSPUtil.getParameter(request,	prefix + "ida_cgst_amt", ""));
		setIdaSgstAmt(JSPUtil.getParameter(request,	prefix + "ida_sgst_amt", ""));
		setIdaUgstAmt(JSPUtil.getParameter(request,	prefix + "ida_ugst_amt", ""));
		setIdaIgstAmt(JSPUtil.getParameter(request,	prefix + "ida_igst_amt", ""));
	}
	
	/**
	 * Request �쓽 �뜲�씠�꽣瑜� VO 諛곗뿴濡� 蹂��솚�븯�뿬 諛섑솚.
	 * @param request
	 * @return ARInvoiceChargeCorrectionVO[]
	 */
	public ARInvoiceChargeCorrectionVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request �꽆�뼱�삩 �뿬�윭 嫄�	DATA瑜� VO Class �뿉 �떞�뒗�떎.
	 * @param request
	 * @param prefix
	 * @return ARInvoiceChargeCorrectionVO[]
	 */
	public ARInvoiceChargeCorrectionVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		ARInvoiceChargeCorrectionVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] repChgCd =	(JSPUtil.getParameter(request, prefix +	"rep_chg_cd".trim(),	length));
				String[] revCoaDirCd =	(JSPUtil.getParameter(request, prefix +	"rev_coa_dir_cd".trim(),	length));
				String[] currCd =	(JSPUtil.getParameter(request, prefix +	"curr_cd".trim(),	length));
				String[] trfRtAmt =	(JSPUtil.getParameter(request, prefix +	"trf_rt_amt".trim(),	length));
				String[] chgSeq =	(JSPUtil.getParameter(request, prefix +	"chg_seq".trim(),	length));
				String[] totalAmt =	(JSPUtil.getParameter(request, prefix +	"total_amt".trim(),	length));
				String[] tjSrcNm =	(JSPUtil.getParameter(request, prefix +	"tj_src_nm".trim(),	length));
				String[] chgCd =	(JSPUtil.getParameter(request, prefix +	"chg_cd".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] revCoaAcctCd =	(JSPUtil.getParameter(request, prefix +	"rev_coa_acct_cd".trim(),	length));
				String[] lclAmount =	(JSPUtil.getParameter(request, prefix +	"lcl_amount".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] acctCd =	(JSPUtil.getParameter(request, prefix +	"acct_cd".trim(),	length));
				String[] revCoaCtrCd =	(JSPUtil.getParameter(request, prefix +	"rev_coa_ctr_cd".trim(),	length));
				String[] chgAmt =	(JSPUtil.getParameter(request, prefix +	"chg_amt".trim(),	length));
				String[] revCoaCoCd =	(JSPUtil.getParameter(request, prefix +	"rev_coa_co_cd".trim(),	length));
				String[] invXchRtDt =	(JSPUtil.getParameter(request, prefix +	"inv_xch_rt_dt".trim(),	length));
				String[] lclCurrCd =	(JSPUtil.getParameter(request, prefix +	"lcl_curr_cd".trim(),	length));
				String[] invXchRt =	(JSPUtil.getParameter(request, prefix +	"inv_xch_rt".trim(),	length));
				String[] chgRmk =	(JSPUtil.getParameter(request, prefix +	"chg_rmk".trim(),	length));
				String[] sobId =	(JSPUtil.getParameter(request, prefix +	"sob_id".trim(),	length));
				String[] invRevTpSrcCd =	(JSPUtil.getParameter(request, prefix +	"inv_rev_tp_src_cd".trim(),	length));
				String[] revCoaVslCd =	(JSPUtil.getParameter(request, prefix +	"rev_coa_vsl_cd".trim(),	length));
				String[] perTpCd =	(JSPUtil.getParameter(request, prefix +	"per_tp_cd".trim(),	length));
				String[] chgFullNm =	(JSPUtil.getParameter(request, prefix +	"chg_full_nm".trim(),	length));
				String[] revCoaSkdDirCd =	(JSPUtil.getParameter(request, prefix +	"rev_coa_skd_dir_cd".trim(),	length));
				String[] revCoaRgnCd =	(JSPUtil.getParameter(request, prefix +	"rev_coa_rgn_cd".trim(),	length));
				String[] mfDivCd =	(JSPUtil.getParameter(request, prefix +	"mf_div_cd".trim(),	length));
				String[] revCoaVoyNo =	(JSPUtil.getParameter(request, prefix +	"rev_coa_voy_no".trim(),	length));
				String[] trfNo =	(JSPUtil.getParameter(request, prefix +	"trf_no".trim(),	length));
				String[] revCoaInterCoCd =	(JSPUtil.getParameter(request, prefix +	"rev_coa_inter_co_cd".trim(),	length));
				String[] ratAsCntrQty =	(JSPUtil.getParameter(request, prefix +	"rat_as_cntr_qty".trim(),	length));
				String[] arIfSerNo =	(JSPUtil.getParameter(request, prefix +	"ar_if_ser_no".trim(),	length));
				String[] tvaFlg =	(JSPUtil.getParameter(request, prefix +	"tva_flg".trim(),	length));
				String[] mnlFlg =	(JSPUtil.getParameter(request, prefix +	"mnl_flg".trim(),	length));
				String[] dpPrcsKnt =	(JSPUtil.getParameter(request, prefix +	"dp_prcs_knt".trim(),	length));
				String[] idaCgstAmt =	(JSPUtil.getParameter(request, prefix +	"ida_cgst_amt".trim(),	length));
				String[] idaSgstAmt =	(JSPUtil.getParameter(request, prefix +	"ida_sgst_amt".trim(),	length));
				String[] idaUgstAmt =	(JSPUtil.getParameter(request, prefix +	"ida_ugst_amt".trim(),	length));
				String[] idaIgstAmt =	(JSPUtil.getParameter(request, prefix +	"ida_igst_amt".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	ARInvoiceChargeCorrectionVO();
						if ( repChgCd[i] !=	null)
						model.setRepChgCd( repChgCd[i]);
						if ( revCoaDirCd[i] !=	null)
						model.setRevCoaDirCd( revCoaDirCd[i]);
						if ( currCd[i] !=	null)
						model.setCurrCd( currCd[i]);
						if ( trfRtAmt[i] !=	null)
						model.setTrfRtAmt( trfRtAmt[i]);
						if ( chgSeq[i] !=	null)
						model.setChgSeq( chgSeq[i]);
						if ( totalAmt[i] !=	null)
						model.setTotalAmt( totalAmt[i]);
						if ( tjSrcNm[i] !=	null)
						model.setTjSrcNm( tjSrcNm[i]);
						if ( chgCd[i] !=	null)
						model.setChgCd( chgCd[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( revCoaAcctCd[i] !=	null)
						model.setRevCoaAcctCd( revCoaAcctCd[i]);
						if ( lclAmount[i] !=	null)
						model.setLclAmount( lclAmount[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( acctCd[i] !=	null)
						model.setAcctCd( acctCd[i]);
						if ( revCoaCtrCd[i] !=	null)
						model.setRevCoaCtrCd( revCoaCtrCd[i]);
						if ( chgAmt[i] !=	null)
						model.setChgAmt( chgAmt[i]);
						if ( revCoaCoCd[i] !=	null)
						model.setRevCoaCoCd( revCoaCoCd[i]);
						if ( invXchRtDt[i] !=	null)
						model.setInvXchRtDt( invXchRtDt[i]);
						if ( lclCurrCd[i] !=	null)
						model.setLclCurrCd( lclCurrCd[i]);
						if ( invXchRt[i] !=	null)
						model.setInvXchRt( invXchRt[i]);
						if ( chgRmk[i] !=	null)
						model.setChgRmk( chgRmk[i]);
						if ( sobId[i] !=	null)
						model.setSobId( sobId[i]);
						if ( invRevTpSrcCd[i] !=	null)
						model.setInvRevTpSrcCd( invRevTpSrcCd[i]);
						if ( revCoaVslCd[i] !=	null)
						model.setRevCoaVslCd( revCoaVslCd[i]);
						if ( perTpCd[i] !=	null)
						model.setPerTpCd( perTpCd[i]);
						if ( chgFullNm[i] !=	null)
						model.setChgFullNm( chgFullNm[i]);
						if ( revCoaSkdDirCd[i] !=	null)
						model.setRevCoaSkdDirCd( revCoaSkdDirCd[i]);
						if ( revCoaRgnCd[i] !=	null)
						model.setRevCoaRgnCd( revCoaRgnCd[i]);
						if ( mfDivCd[i] !=	null)
						model.setMfDivCd( mfDivCd[i]);
						if ( revCoaVoyNo[i] !=	null)
						model.setRevCoaVoyNo( revCoaVoyNo[i]);
						if ( trfNo[i] !=	null)
						model.setTrfNo( trfNo[i]);
						if ( revCoaInterCoCd[i] !=	null)
						model.setRevCoaInterCoCd( revCoaInterCoCd[i]);
						if ( ratAsCntrQty[i] !=	null)
						model.setRatAsCntrQty( ratAsCntrQty[i]);
						if ( arIfSerNo[i] !=	null)
						model.setArIfSerNo( arIfSerNo[i]);
						if ( tvaFlg[i] !=	null)
						model.setTvaFlg( tvaFlg[i]);
						if ( mnlFlg[i] !=	null)
						model.setMnlFlg( mnlFlg[i]);
						if ( dpPrcsKnt[i] !=	null)
						model.setDpPrcsKnt( dpPrcsKnt[i]);
						if ( idaCgstAmt[i] !=	null)
						model.setIdaCgstAmt( idaCgstAmt[i]);
						if ( idaSgstAmt[i] !=	null)
						model.setIdaSgstAmt( idaSgstAmt[i]);
						if ( idaUgstAmt[i] !=	null)
						model.setIdaUgstAmt( idaUgstAmt[i]);
						if ( idaIgstAmt[i] !=	null)
						model.setIdaIgstAmt( idaIgstAmt[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getARInvoiceChargeCorrectionVOs();
	}

	/**
	 *  VO 諛곗뿴�쓣 諛섑솚
	 * @return ARInvoiceChargeCorrectionVO[]
	 */
	public ARInvoiceChargeCorrectionVO[]	 getARInvoiceChargeCorrectionVOs(){
		ARInvoiceChargeCorrectionVO[] vos = (ARInvoiceChargeCorrectionVO[])models.toArray(new	ARInvoiceChargeCorrectionVO[models.size()]);
		return vos;
		}

	/**
	 * VO Class�쓽 �궡�슜�쓣 String�쑝濡� 蹂��솚
	 */
	public String  toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	}
	

	/**
	* �룷留룻똿�맂 臾몄옄�뿴�뿉�꽌 �듅�닔臾몄옄 �젣嫄�("-","/",",",":")
	*/
	public void	unDataFormat(){
		this.repChgCd =	this.repChgCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revCoaDirCd =	this.revCoaDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd =	this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfRtAmt =	this.trfRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgSeq =	this.chgSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalAmt =	this.totalAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tjSrcNm =	this.tjSrcNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd =	this.chgCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revCoaAcctCd =	this.revCoaAcctCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lclAmount =	this.lclAmount.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd =	this.acctCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revCoaCtrCd =	this.revCoaCtrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmt =	this.chgAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revCoaCoCd =	this.revCoaCoCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRtDt =	this.invXchRtDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lclCurrCd =	this.lclCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRt =	this.invXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgRmk =	this.chgRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sobId =	this.sobId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRevTpSrcCd =	this.invRevTpSrcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revCoaVslCd =	this.revCoaVslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.perTpCd =	this.perTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgFullNm =	this.chgFullNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revCoaSkdDirCd =	this.revCoaSkdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revCoaRgnCd =	this.revCoaRgnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfDivCd =	this.mfDivCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revCoaVoyNo =	this.revCoaVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfNo =	this.trfNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revCoaInterCoCd =	this.revCoaInterCoCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratAsCntrQty =	this.ratAsCntrQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfSerNo =	this.arIfSerNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tvaFlg =	this.tvaFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnlFlg =	this.mnlFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpPrcsKnt =	this.dpPrcsKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaCgstAmt =	this.idaCgstAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaSgstAmt =	this.idaSgstAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaUgstAmt =	this.idaUgstAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaIgstAmt =	this.idaIgstAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}