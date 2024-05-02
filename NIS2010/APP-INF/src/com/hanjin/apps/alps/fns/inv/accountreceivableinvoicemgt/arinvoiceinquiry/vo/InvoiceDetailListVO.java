/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : InvoiceDetailListVO.java
 *@FileTitle : InvoiceDetailListVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2017.08.02
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2017.08.02  
 * 1.0 Creation
=========================================================*/

package	 com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo;

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
public class InvoiceDetailListVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<InvoiceDetailListVO>  models =	new	ArrayList<InvoiceDetailListVO>();


	/*	Column Info	*/
	private  String	 chgRmk   =  null;
	/*	Column Info	*/
	private  String	 tvaFlg   =  null;
	/*	Column Info	*/
	private  String	 autoInvIssFlg   =  null;
	/*	Column Info	*/
	private  String	 blSrcNo   =  null;
	/*	Column Info	*/
	private  String	 invNo   =  null;
	/*	Column Info	*/
	private  String	 currCd   =  null;
	/*	Column Info	*/
	private  String	 loclCurrCd   =  null;
	/*	Column Info	*/
	private  String	 actCustSeq   =  null;
	/*	Column Info	*/
	private  String	 custNm   =  null;
	/*	Column Info	*/
	private  String	 invLoclAmt   =  null;
	/*	Column Info	*/
	private  String	 ioBndCd   =  null;
	/*	Column Info	*/
	private  String	 revTpCd   =  null;
	/*	Column Info	*/
	private  String	 arOfcCd   =  null;
	/*	Column Info	*/
	private  String	 chgCd   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 dpPrcsKnt   =  null;
	/*	Column Info	*/
	private  String	 vvd   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 goodDate   =  null;
	/*	Column Info	*/
	private  String	 arIfNo   =  null;
	/*	Column Info	*/
	private  String	 chgAmt   =  null;
	/*	Column Info	*/
	private  String	 invXchRt   =  null;
	/*	Column Info	*/
	private  String	 invType   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;
	/*	Column Info	*/
	private  String	 usrNm   =  null;
	/*	Column Info	*/
	private  String	 invRmk   =  null;
	/*	Column Info	*/
	private  String	 custRgstNo   =  null;
	/*	Column Info	*/
	private  String	 spndVatRgstNo   =  null;
	/*	Column Info	*/
	private  String	 idaGstRgstNo   =  null;
	/*	Column Info	*/
	private  String	 idaSteCd   =  null;
	/*	Column Info	*/
	private  String	 idaSteNm   =  null;
	/*	Column Info	*/
	private  String	 idaPanNo   =  null;
	/*	Column Info	*/
	private  String	 idaSpclEcnZnUtFlg   =  null;
	/*	Column Info	*/
	private  String	 idaSacCd   =  null;
	/*	Column Info	*/
	private  String	 idaCgstAmt   =  null;
	/*	Column Info	*/
	private  String	 idaSgstAmt   =  null;
	/*	Column Info	*/
	private  String	 idaUgstAmt   =  null;
	/*	Column Info	*/
	private  String	 idaIgstAmt   =  null;
	/*	Column Info	*/
	private  String	 proInvNo   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public InvoiceDetailListVO(){}

	public InvoiceDetailListVO(String chgRmk,String tvaFlg,String autoInvIssFlg,String blSrcNo,String invNo,String currCd,String loclCurrCd,String actCustSeq,String custNm,String invLoclAmt,String ioBndCd,String revTpCd,String arOfcCd,String chgCd,String pagerows,String dpPrcsKnt,String vvd,String ibflag,String goodDate,String arIfNo,String chgAmt,String invXchRt,String invType,String creUsrId,String usrNm,String invRmk,String custRgstNo,String spndVatRgstNo,String idaGstRgstNo,String idaSteCd,String idaSteNm,String idaPanNo,String idaSpclEcnZnUtFlg,String idaSacCd,String idaCgstAmt,String idaSgstAmt,String idaUgstAmt,String idaIgstAmt,String proInvNo)	{
		this.chgRmk  = chgRmk ;
		this.tvaFlg  = tvaFlg ;
		this.autoInvIssFlg  = autoInvIssFlg ;
		this.blSrcNo  = blSrcNo ;
		this.invNo  = invNo ;
		this.currCd  = currCd ;
		this.loclCurrCd  = loclCurrCd ;
		this.actCustSeq  = actCustSeq ;
		this.custNm  = custNm ;
		this.invLoclAmt  = invLoclAmt ;
		this.ioBndCd  = ioBndCd ;
		this.revTpCd  = revTpCd ;
		this.arOfcCd  = arOfcCd ;
		this.chgCd  = chgCd ;
		this.pagerows  = pagerows ;
		this.dpPrcsKnt  = dpPrcsKnt ;
		this.vvd  = vvd ;
		this.ibflag  = ibflag ;
		this.goodDate  = goodDate ;
		this.arIfNo  = arIfNo ;
		this.chgAmt  = chgAmt ;
		this.invXchRt  = invXchRt ;
		this.invType  = invType ;
		this.creUsrId  = creUsrId ;
		this.usrNm  = usrNm ;
		this.invRmk  = invRmk ;
		this.custRgstNo  = custRgstNo ;
		this.spndVatRgstNo  = spndVatRgstNo ;
		this.idaGstRgstNo  = idaGstRgstNo ;
		this.idaSteCd  = idaSteCd ;
		this.idaSteNm  = idaSteNm ;
		this.idaPanNo  = idaPanNo ;
		this.idaSpclEcnZnUtFlg  = idaSpclEcnZnUtFlg ;
		this.idaSacCd  = idaSacCd ;
		this.idaCgstAmt  = idaCgstAmt ;
		this.idaSgstAmt  = idaSgstAmt ;
		this.idaUgstAmt  = idaUgstAmt ;
		this.idaIgstAmt  = idaIgstAmt ;
		this.proInvNo  = proInvNo ;
	}


	/**
	 * �뀒�씠釉� 而щ읆�뿉 ���옣�븷 媛믪쓣 Hashtable<"column_name", "value">	濡� 諛섑솚
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("chg_rmk", getChgRmk());		
		this.hashColumns.put("tva_flg", getTvaFlg());		
		this.hashColumns.put("auto_inv_iss_flg", getAutoInvIssFlg());		
		this.hashColumns.put("bl_src_no", getBlSrcNo());		
		this.hashColumns.put("inv_no", getInvNo());		
		this.hashColumns.put("curr_cd", getCurrCd());		
		this.hashColumns.put("locl_curr_cd", getLoclCurrCd());		
		this.hashColumns.put("act_cust_seq", getActCustSeq());		
		this.hashColumns.put("cust_nm", getCustNm());		
		this.hashColumns.put("inv_locl_amt", getInvLoclAmt());		
		this.hashColumns.put("io_bnd_cd", getIoBndCd());		
		this.hashColumns.put("rev_tp_cd", getRevTpCd());		
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());		
		this.hashColumns.put("chg_cd", getChgCd());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("dp_prcs_knt", getDpPrcsKnt());		
		this.hashColumns.put("vvd", getVvd());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("good_date", getGoodDate());		
		this.hashColumns.put("ar_if_no", getArIfNo());		
		this.hashColumns.put("chg_amt", getChgAmt());		
		this.hashColumns.put("inv_xch_rt", getInvXchRt());		
		this.hashColumns.put("inv_type", getInvType());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("usr_nm", getUsrNm());		
		this.hashColumns.put("inv_rmk", getInvRmk());		
		this.hashColumns.put("cust_rgst_no", getCustRgstNo());		
		this.hashColumns.put("spnd_vat_rgst_no", getSpndVatRgstNo());		
		this.hashColumns.put("ida_gst_rgst_no", getIdaGstRgstNo());		
		this.hashColumns.put("ida_ste_cd", getIdaSteCd());		
		this.hashColumns.put("ida_ste_nm", getIdaSteNm());		
		this.hashColumns.put("ida_pan_no", getIdaPanNo());		
		this.hashColumns.put("ida_spcl_ecn_zn_ut_flg", getIdaSpclEcnZnUtFlg());		
		this.hashColumns.put("ida_sac_cd", getIdaSacCd());		
		this.hashColumns.put("ida_cgst_amt", getIdaCgstAmt());		
		this.hashColumns.put("ida_sgst_amt", getIdaSgstAmt());		
		this.hashColumns.put("ida_ugst_amt", getIdaUgstAmt());		
		this.hashColumns.put("ida_igst_amt", getIdaIgstAmt());		
		this.hashColumns.put("pro_inv_no", getProInvNo());		
		return this.hashColumns;
}

	/**
	 * 而щ읆紐낆뿉	���쓳�릺�뒗 硫ㅻ쾭蹂��닔紐낆쓣	���옣�븯�뿬 Hashtable<"column_name", "variable"> 濡� 諛섑솚
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("chg_rmk", "chgRmk");
		this.hashFields.put("tva_flg", "tvaFlg");
		this.hashFields.put("auto_inv_iss_flg", "autoInvIssFlg");
		this.hashFields.put("bl_src_no", "blSrcNo");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("locl_curr_cd", "loclCurrCd");
		this.hashFields.put("act_cust_seq", "actCustSeq");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("inv_locl_amt", "invLoclAmt");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("rev_tp_cd", "revTpCd");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dp_prcs_knt", "dpPrcsKnt");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("good_date", "goodDate");
		this.hashFields.put("ar_if_no", "arIfNo");
		this.hashFields.put("chg_amt", "chgAmt");
		this.hashFields.put("inv_xch_rt", "invXchRt");
		this.hashFields.put("inv_type", "invType");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("inv_rmk", "invRmk");
		this.hashFields.put("cust_rgst_no", "custRgstNo");
		this.hashFields.put("spnd_vat_rgst_no", "spndVatRgstNo");
		this.hashFields.put("ida_gst_rgst_no", "idaGstRgstNo");
		this.hashFields.put("ida_ste_cd", "idaSteCd");
		this.hashFields.put("ida_ste_nm", "idaSteNm");
		this.hashFields.put("ida_pan_no", "idaPanNo");
		this.hashFields.put("ida_spcl_ecn_zn_ut_flg", "idaSpclEcnZnUtFlg");
		this.hashFields.put("ida_sac_cd", "idaSacCd");
		this.hashFields.put("ida_cgst_amt", "idaCgstAmt");
		this.hashFields.put("ida_sgst_amt", "idaSgstAmt");
		this.hashFields.put("ida_ugst_amt", "idaUgstAmt");
		this.hashFields.put("ida_igst_amt", "idaIgstAmt");
		this.hashFields.put("pro_inv_no", "proInvNo");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
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
	* @param  autoInvIssFlg
	*/
	public void	setAutoInvIssFlg( String	autoInvIssFlg ) {
		this.autoInvIssFlg =	autoInvIssFlg;
	}
 
	/**
	 * Column Info
	 * @return	autoInvIssFlg
	 */
	 public	 String	getAutoInvIssFlg() {
		 return	this.autoInvIssFlg;
	 } 
 	/**
	* Column Info
	* @param  blSrcNo
	*/
	public void	setBlSrcNo( String	blSrcNo ) {
		this.blSrcNo =	blSrcNo;
	}
 
	/**
	 * Column Info
	 * @return	blSrcNo
	 */
	 public	 String	getBlSrcNo() {
		 return	this.blSrcNo;
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
	* @param  loclCurrCd
	*/
	public void	setLoclCurrCd( String	loclCurrCd ) {
		this.loclCurrCd =	loclCurrCd;
	}
 
	/**
	 * Column Info
	 * @return	loclCurrCd
	 */
	 public	 String	getLoclCurrCd() {
		 return	this.loclCurrCd;
	 } 
 	/**
	* Column Info
	* @param  actCustSeq
	*/
	public void	setActCustSeq( String	actCustSeq ) {
		this.actCustSeq =	actCustSeq;
	}
 
	/**
	 * Column Info
	 * @return	actCustSeq
	 */
	 public	 String	getActCustSeq() {
		 return	this.actCustSeq;
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
	* @param  invLoclAmt
	*/
	public void	setInvLoclAmt( String	invLoclAmt ) {
		this.invLoclAmt =	invLoclAmt;
	}
 
	/**
	 * Column Info
	 * @return	invLoclAmt
	 */
	 public	 String	getInvLoclAmt() {
		 return	this.invLoclAmt;
	 } 
 	/**
	* Column Info
	* @param  ioBndCd
	*/
	public void	setIoBndCd( String	ioBndCd ) {
		this.ioBndCd =	ioBndCd;
	}
 
	/**
	 * Column Info
	 * @return	ioBndCd
	 */
	 public	 String	getIoBndCd() {
		 return	this.ioBndCd;
	 } 
 	/**
	* Column Info
	* @param  revTpCd
	*/
	public void	setRevTpCd( String	revTpCd ) {
		this.revTpCd =	revTpCd;
	}
 
	/**
	 * Column Info
	 * @return	revTpCd
	 */
	 public	 String	getRevTpCd() {
		 return	this.revTpCd;
	 } 
 	/**
	* Column Info
	* @param  arOfcCd
	*/
	public void	setArOfcCd( String	arOfcCd ) {
		this.arOfcCd =	arOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	arOfcCd
	 */
	 public	 String	getArOfcCd() {
		 return	this.arOfcCd;
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
	* @param  goodDate
	*/
	public void	setGoodDate( String	goodDate ) {
		this.goodDate =	goodDate;
	}
 
	/**
	 * Column Info
	 * @return	goodDate
	 */
	 public	 String	getGoodDate() {
		 return	this.goodDate;
	 } 
 	/**
	* Column Info
	* @param  arIfNo
	*/
	public void	setArIfNo( String	arIfNo ) {
		this.arIfNo =	arIfNo;
	}
 
	/**
	 * Column Info
	 * @return	arIfNo
	 */
	 public	 String	getArIfNo() {
		 return	this.arIfNo;
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
	* @param  invType
	*/
	public void	setInvType( String	invType ) {
		this.invType =	invType;
	}
 
	/**
	 * Column Info
	 * @return	invType
	 */
	 public	 String	getInvType() {
		 return	this.invType;
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
	* @param  usrNm
	*/
	public void	setUsrNm( String	usrNm ) {
		this.usrNm =	usrNm;
	}
 
	/**
	 * Column Info
	 * @return	usrNm
	 */
	 public	 String	getUsrNm() {
		 return	this.usrNm;
	 } 
 	/**
	* Column Info
	* @param  invRmk
	*/
	public void	setInvRmk( String	invRmk ) {
		this.invRmk =	invRmk;
	}
 
	/**
	 * Column Info
	 * @return	invRmk
	 */
	 public	 String	getInvRmk() {
		 return	this.invRmk;
	 } 
 	/**
	* Column Info
	* @param  custRgstNo
	*/
	public void	setCustRgstNo( String	custRgstNo ) {
		this.custRgstNo =	custRgstNo;
	}
 
	/**
	 * Column Info
	 * @return	custRgstNo
	 */
	 public	 String	getCustRgstNo() {
		 return	this.custRgstNo;
	 } 
 	/**
	* Column Info
	* @param  spndVatRgstNo
	*/
	public void	setSpndVatRgstNo( String	spndVatRgstNo ) {
		this.spndVatRgstNo =	spndVatRgstNo;
	}
 
	/**
	 * Column Info
	 * @return	spndVatRgstNo
	 */
	 public	 String	getSpndVatRgstNo() {
		 return	this.spndVatRgstNo;
	 } 
 	/**
	* Column Info
	* @param  idaGstRgstNo
	*/
	public void	setIdaGstRgstNo( String	idaGstRgstNo ) {
		this.idaGstRgstNo =	idaGstRgstNo;
	}
 
	/**
	 * Column Info
	 * @return	idaGstRgstNo
	 */
	 public	 String	getIdaGstRgstNo() {
		 return	this.idaGstRgstNo;
	 } 
 	/**
	* Column Info
	* @param  idaSteCd
	*/
	public void	setIdaSteCd( String	idaSteCd ) {
		this.idaSteCd =	idaSteCd;
	}
 
	/**
	 * Column Info
	 * @return	idaSteCd
	 */
	 public	 String	getIdaSteCd() {
		 return	this.idaSteCd;
	 } 
 	/**
	* Column Info
	* @param  idaSteNm
	*/
	public void	setIdaSteNm( String	idaSteNm ) {
		this.idaSteNm =	idaSteNm;
	}
 
	/**
	 * Column Info
	 * @return	idaSteNm
	 */
	 public	 String	getIdaSteNm() {
		 return	this.idaSteNm;
	 } 
 	/**
	* Column Info
	* @param  idaPanNo
	*/
	public void	setIdaPanNo( String	idaPanNo ) {
		this.idaPanNo =	idaPanNo;
	}
 
	/**
	 * Column Info
	 * @return	idaPanNo
	 */
	 public	 String	getIdaPanNo() {
		 return	this.idaPanNo;
	 } 
 	/**
	* Column Info
	* @param  idaSpclEcnZnUtFlg
	*/
	public void	setIdaSpclEcnZnUtFlg( String	idaSpclEcnZnUtFlg ) {
		this.idaSpclEcnZnUtFlg =	idaSpclEcnZnUtFlg;
	}
 
	/**
	 * Column Info
	 * @return	idaSpclEcnZnUtFlg
	 */
	 public	 String	getIdaSpclEcnZnUtFlg() {
		 return	this.idaSpclEcnZnUtFlg;
	 } 
 	/**
	* Column Info
	* @param  idaSacCd
	*/
	public void	setIdaSacCd( String	idaSacCd ) {
		this.idaSacCd =	idaSacCd;
	}
 
	/**
	 * Column Info
	 * @return	idaSacCd
	 */
	 public	 String	getIdaSacCd() {
		 return	this.idaSacCd;
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
	* Column Info
	* @param  proInvNo
	*/
	public void	setProInvNo( String	proInvNo ) {
		this.proInvNo =	proInvNo;
	}
 
	/**
	 * Column Info
	 * @return	proInvNo
	 */
	 public	 String	getProInvNo() {
		 return	this.proInvNo;
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
		setChgRmk(JSPUtil.getParameter(request,	prefix + "chg_rmk", ""));
		setTvaFlg(JSPUtil.getParameter(request,	prefix + "tva_flg", ""));
		setAutoInvIssFlg(JSPUtil.getParameter(request,	prefix + "auto_inv_iss_flg", ""));
		setBlSrcNo(JSPUtil.getParameter(request,	prefix + "bl_src_no", ""));
		setInvNo(JSPUtil.getParameter(request,	prefix + "inv_no", ""));
		setCurrCd(JSPUtil.getParameter(request,	prefix + "curr_cd", ""));
		setLoclCurrCd(JSPUtil.getParameter(request,	prefix + "locl_curr_cd", ""));
		setActCustSeq(JSPUtil.getParameter(request,	prefix + "act_cust_seq", ""));
		setCustNm(JSPUtil.getParameter(request,	prefix + "cust_nm", ""));
		setInvLoclAmt(JSPUtil.getParameter(request,	prefix + "inv_locl_amt", ""));
		setIoBndCd(JSPUtil.getParameter(request,	prefix + "io_bnd_cd", ""));
		setRevTpCd(JSPUtil.getParameter(request,	prefix + "rev_tp_cd", ""));
		setArOfcCd(JSPUtil.getParameter(request,	prefix + "ar_ofc_cd", ""));
		setChgCd(JSPUtil.getParameter(request,	prefix + "chg_cd", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setDpPrcsKnt(JSPUtil.getParameter(request,	prefix + "dp_prcs_knt", ""));
		setVvd(JSPUtil.getParameter(request,	prefix + "vvd", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setGoodDate(JSPUtil.getParameter(request,	prefix + "good_date", ""));
		setArIfNo(JSPUtil.getParameter(request,	prefix + "ar_if_no", ""));
		setChgAmt(JSPUtil.getParameter(request,	prefix + "chg_amt", ""));
		setInvXchRt(JSPUtil.getParameter(request,	prefix + "inv_xch_rt", ""));
		setInvType(JSPUtil.getParameter(request,	prefix + "inv_type", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setUsrNm(JSPUtil.getParameter(request,	prefix + "usr_nm", ""));
		setInvRmk(JSPUtil.getParameter(request,	prefix + "inv_rmk", ""));
		setCustRgstNo(JSPUtil.getParameter(request,	prefix + "cust_rgst_no", ""));
		setSpndVatRgstNo(JSPUtil.getParameter(request,	prefix + "spnd_vat_rgst_no", ""));
		setIdaGstRgstNo(JSPUtil.getParameter(request,	prefix + "ida_gst_rgst_no", ""));
		setIdaSteCd(JSPUtil.getParameter(request,	prefix + "ida_ste_cd", ""));
		setIdaSteNm(JSPUtil.getParameter(request,	prefix + "ida_ste_nm", ""));
		setIdaPanNo(JSPUtil.getParameter(request,	prefix + "ida_pan_no", ""));
		setIdaSpclEcnZnUtFlg(JSPUtil.getParameter(request,	prefix + "ida_spcl_ecn_zn_ut_flg", ""));
		setIdaSacCd(JSPUtil.getParameter(request,	prefix + "ida_sac_cd", ""));
		setIdaCgstAmt(JSPUtil.getParameter(request,	prefix + "ida_cgst_amt", ""));
		setIdaSgstAmt(JSPUtil.getParameter(request,	prefix + "ida_sgst_amt", ""));
		setIdaUgstAmt(JSPUtil.getParameter(request,	prefix + "ida_ugst_amt", ""));
		setIdaIgstAmt(JSPUtil.getParameter(request,	prefix + "ida_igst_amt", ""));
		setProInvNo(JSPUtil.getParameter(request,	prefix + "pro_inv_no", ""));
	}
	
	/**
	 * Request �쓽 �뜲�씠�꽣瑜� VO 諛곗뿴濡� 蹂��솚�븯�뿬 諛섑솚.
	 * @param request
	 * @return InvoiceDetailListVO[]
	 */
	public InvoiceDetailListVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request �꽆�뼱�삩 �뿬�윭 嫄�	DATA瑜� VO Class �뿉 �떞�뒗�떎.
	 * @param request
	 * @param prefix
	 * @return InvoiceDetailListVO[]
	 */
	public InvoiceDetailListVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		InvoiceDetailListVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] chgRmk =	(JSPUtil.getParameter(request, prefix +	"chg_rmk".trim(),	length));
				String[] tvaFlg =	(JSPUtil.getParameter(request, prefix +	"tva_flg".trim(),	length));
				String[] autoInvIssFlg =	(JSPUtil.getParameter(request, prefix +	"auto_inv_iss_flg".trim(),	length));
				String[] blSrcNo =	(JSPUtil.getParameter(request, prefix +	"bl_src_no".trim(),	length));
				String[] invNo =	(JSPUtil.getParameter(request, prefix +	"inv_no".trim(),	length));
				String[] currCd =	(JSPUtil.getParameter(request, prefix +	"curr_cd".trim(),	length));
				String[] loclCurrCd =	(JSPUtil.getParameter(request, prefix +	"locl_curr_cd".trim(),	length));
				String[] actCustSeq =	(JSPUtil.getParameter(request, prefix +	"act_cust_seq".trim(),	length));
				String[] custNm =	(JSPUtil.getParameter(request, prefix +	"cust_nm".trim(),	length));
				String[] invLoclAmt =	(JSPUtil.getParameter(request, prefix +	"inv_locl_amt".trim(),	length));
				String[] ioBndCd =	(JSPUtil.getParameter(request, prefix +	"io_bnd_cd".trim(),	length));
				String[] revTpCd =	(JSPUtil.getParameter(request, prefix +	"rev_tp_cd".trim(),	length));
				String[] arOfcCd =	(JSPUtil.getParameter(request, prefix +	"ar_ofc_cd".trim(),	length));
				String[] chgCd =	(JSPUtil.getParameter(request, prefix +	"chg_cd".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] dpPrcsKnt =	(JSPUtil.getParameter(request, prefix +	"dp_prcs_knt".trim(),	length));
				String[] vvd =	(JSPUtil.getParameter(request, prefix +	"vvd".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] goodDate =	(JSPUtil.getParameter(request, prefix +	"good_date".trim(),	length));
				String[] arIfNo =	(JSPUtil.getParameter(request, prefix +	"ar_if_no".trim(),	length));
				String[] chgAmt =	(JSPUtil.getParameter(request, prefix +	"chg_amt".trim(),	length));
				String[] invXchRt =	(JSPUtil.getParameter(request, prefix +	"inv_xch_rt".trim(),	length));
				String[] invType =	(JSPUtil.getParameter(request, prefix +	"inv_type".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				String[] usrNm =	(JSPUtil.getParameter(request, prefix +	"usr_nm".trim(),	length));
				String[] invRmk =	(JSPUtil.getParameter(request, prefix +	"inv_rmk".trim(),	length));
				String[] custRgstNo =	(JSPUtil.getParameter(request, prefix +	"cust_rgst_no".trim(),	length));
				String[] spndVatRgstNo =	(JSPUtil.getParameter(request, prefix +	"spnd_vat_rgst_no".trim(),	length));
				String[] idaGstRgstNo =	(JSPUtil.getParameter(request, prefix +	"ida_gst_rgst_no".trim(),	length));
				String[] idaSteCd =	(JSPUtil.getParameter(request, prefix +	"ida_ste_cd".trim(),	length));
				String[] idaSteNm =	(JSPUtil.getParameter(request, prefix +	"ida_ste_nm".trim(),	length));
				String[] idaPanNo =	(JSPUtil.getParameter(request, prefix +	"ida_pan_no".trim(),	length));
				String[] idaSpclEcnZnUtFlg =	(JSPUtil.getParameter(request, prefix +	"ida_spcl_ecn_zn_ut_flg".trim(),	length));
				String[] idaSacCd =	(JSPUtil.getParameter(request, prefix +	"ida_sac_cd".trim(),	length));
				String[] idaCgstAmt =	(JSPUtil.getParameter(request, prefix +	"ida_cgst_amt".trim(),	length));
				String[] idaSgstAmt =	(JSPUtil.getParameter(request, prefix +	"ida_sgst_amt".trim(),	length));
				String[] idaUgstAmt =	(JSPUtil.getParameter(request, prefix +	"ida_ugst_amt".trim(),	length));
				String[] idaIgstAmt =	(JSPUtil.getParameter(request, prefix +	"ida_igst_amt".trim(),	length));
				String[] proInvNo =	(JSPUtil.getParameter(request, prefix +	"pro_inv_no".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	InvoiceDetailListVO();
						if ( chgRmk[i] !=	null)
						model.setChgRmk( chgRmk[i]);
						if ( tvaFlg[i] !=	null)
						model.setTvaFlg( tvaFlg[i]);
						if ( autoInvIssFlg[i] !=	null)
						model.setAutoInvIssFlg( autoInvIssFlg[i]);
						if ( blSrcNo[i] !=	null)
						model.setBlSrcNo( blSrcNo[i]);
						if ( invNo[i] !=	null)
						model.setInvNo( invNo[i]);
						if ( currCd[i] !=	null)
						model.setCurrCd( currCd[i]);
						if ( loclCurrCd[i] !=	null)
						model.setLoclCurrCd( loclCurrCd[i]);
						if ( actCustSeq[i] !=	null)
						model.setActCustSeq( actCustSeq[i]);
						if ( custNm[i] !=	null)
						model.setCustNm( custNm[i]);
						if ( invLoclAmt[i] !=	null)
						model.setInvLoclAmt( invLoclAmt[i]);
						if ( ioBndCd[i] !=	null)
						model.setIoBndCd( ioBndCd[i]);
						if ( revTpCd[i] !=	null)
						model.setRevTpCd( revTpCd[i]);
						if ( arOfcCd[i] !=	null)
						model.setArOfcCd( arOfcCd[i]);
						if ( chgCd[i] !=	null)
						model.setChgCd( chgCd[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( dpPrcsKnt[i] !=	null)
						model.setDpPrcsKnt( dpPrcsKnt[i]);
						if ( vvd[i] !=	null)
						model.setVvd( vvd[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( goodDate[i] !=	null)
						model.setGoodDate( goodDate[i]);
						if ( arIfNo[i] !=	null)
						model.setArIfNo( arIfNo[i]);
						if ( chgAmt[i] !=	null)
						model.setChgAmt( chgAmt[i]);
						if ( invXchRt[i] !=	null)
						model.setInvXchRt( invXchRt[i]);
						if ( invType[i] !=	null)
						model.setInvType( invType[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
						if ( usrNm[i] !=	null)
						model.setUsrNm( usrNm[i]);
						if ( invRmk[i] !=	null)
						model.setInvRmk( invRmk[i]);
						if ( custRgstNo[i] !=	null)
						model.setCustRgstNo( custRgstNo[i]);
						if ( spndVatRgstNo[i] !=	null)
						model.setSpndVatRgstNo( spndVatRgstNo[i]);
						if ( idaGstRgstNo[i] !=	null)
						model.setIdaGstRgstNo( idaGstRgstNo[i]);
						if ( idaSteCd[i] !=	null)
						model.setIdaSteCd( idaSteCd[i]);
						if ( idaSteNm[i] !=	null)
						model.setIdaSteNm( idaSteNm[i]);
						if ( idaPanNo[i] !=	null)
						model.setIdaPanNo( idaPanNo[i]);
						if ( idaSpclEcnZnUtFlg[i] !=	null)
						model.setIdaSpclEcnZnUtFlg( idaSpclEcnZnUtFlg[i]);
						if ( idaSacCd[i] !=	null)
						model.setIdaSacCd( idaSacCd[i]);
						if ( idaCgstAmt[i] !=	null)
						model.setIdaCgstAmt( idaCgstAmt[i]);
						if ( idaSgstAmt[i] !=	null)
						model.setIdaSgstAmt( idaSgstAmt[i]);
						if ( idaUgstAmt[i] !=	null)
						model.setIdaUgstAmt( idaUgstAmt[i]);
						if ( idaIgstAmt[i] !=	null)
						model.setIdaIgstAmt( idaIgstAmt[i]);
						if ( proInvNo[i] !=	null)
						model.setProInvNo( proInvNo[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getInvoiceDetailListVOs();
	}

	/**
	 *  VO 諛곗뿴�쓣 諛섑솚
	 * @return InvoiceDetailListVO[]
	 */
	public InvoiceDetailListVO[]	 getInvoiceDetailListVOs(){
		InvoiceDetailListVO[] vos = (InvoiceDetailListVO[])models.toArray(new	InvoiceDetailListVO[models.size()]);
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
		this.chgRmk =	this.chgRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tvaFlg =	this.tvaFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoInvIssFlg =	this.autoInvIssFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSrcNo =	this.blSrcNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo =	this.invNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd =	this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCd =	this.loclCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustSeq =	this.actCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm =	this.custNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invLoclAmt =	this.invLoclAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd =	this.ioBndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revTpCd =	this.revTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd =	this.arOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd =	this.chgCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpPrcsKnt =	this.dpPrcsKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd =	this.vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.goodDate =	this.goodDate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfNo =	this.arIfNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmt =	this.chgAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRt =	this.invXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invType =	this.invType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm =	this.usrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRmk =	this.invRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custRgstNo =	this.custRgstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spndVatRgstNo =	this.spndVatRgstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaGstRgstNo =	this.idaGstRgstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaSteCd =	this.idaSteCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaSteNm =	this.idaSteNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaPanNo =	this.idaPanNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaSpclEcnZnUtFlg =	this.idaSpclEcnZnUtFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaSacCd =	this.idaSacCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaCgstAmt =	this.idaCgstAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaSgstAmt =	this.idaSgstAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaUgstAmt =	this.idaUgstAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaIgstAmt =	this.idaIgstAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.proInvNo =	this.proInvNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}