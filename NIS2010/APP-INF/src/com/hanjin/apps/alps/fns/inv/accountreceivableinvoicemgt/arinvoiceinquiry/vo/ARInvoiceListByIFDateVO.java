/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ARInvoiceListByIFDateVO.java
 *@FileTitle : ARInvoiceListByIFDateVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2017.08.01
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2017.08.01  
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
public class ARInvoiceListByIFDateVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<ARInvoiceListByIFDateVO>  models =	new	ArrayList<ARInvoiceListByIFDateVO>();

	private InvoiceSumVO invoiceSumVO = null;
	
	/*	Column Info	*/
	private  String	 autoInvIssFlg   =  null;
	/*	Column Info	*/
	private  String	 blSrcNo   =  null;
	/*	Column Info	*/
	private  String	 currCd   =  null;
	/*	Column Info	*/
	private  String	 no   =  null;
	/*	Column Info	*/
	private  String	 loclCurrCd   =  null;
	/*	Column Info	*/
	private  String	 ioBndCd   =  null;
	/*	Column Info	*/
	private  String	 customer   =  null;
	/*	Column Info	*/
	private  String	 type   =  null;
	/*	Column Info	*/
	private  String	 sailArrDt   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 dpPrcsKnt   =  null;
	/*	Column Info	*/
	private  String	 dpPrcsKntLcl   =  null;
	/*	Column Info	*/
	private  String	 podCd   =  null;
	/*	Column Info	*/
	private  String	 vvd   =  null;
	/*	Column Info	*/
	private  String	 invNo   =  null;
	/*	Column Info	*/
	private  String	 polCd   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 goodDate   =  null;
	/*	Column Info	*/
	private  String	 arIfNo   =  null;
	/*	Column Info	*/
	private  String	 chgAmt   =  null;
	/*	Column Info	*/
	private  String	 lclAmt   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 invXchRt   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;
	/*	Column Info	*/
	private  String	 actInvNo   =  null;
	/*	Column Info	*/
	private  String	 issDt   =  null;
	/*	Column Info	*/
	private  String	 custNm   =  null;
	/*	Column Info	*/
	private  String	 invType   =  null;
	/*	Column Info	*/
	private  String	 arOfcCd   =  null;
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
	public ARInvoiceListByIFDateVO(){}

	public ARInvoiceListByIFDateVO(String autoInvIssFlg,String blSrcNo,String currCd,String no,String loclCurrCd,String ioBndCd,String customer,String type,String sailArrDt,String pagerows,String dpPrcsKnt,String dpPrcsKntLcl,String podCd,String vvd,String invNo,String polCd,String ibflag,String goodDate,String arIfNo,String chgAmt,String lclAmt,String updUsrId,String invXchRt,String creUsrId,String actInvNo,String issDt,String custNm,String invType,String arOfcCd,String idaCgstAmt,String idaSgstAmt,String idaUgstAmt,String idaIgstAmt,String proInvNo)	{
		this.autoInvIssFlg  = autoInvIssFlg ;
		this.blSrcNo  = blSrcNo ;
		this.currCd  = currCd ;
		this.no  = no ;
		this.loclCurrCd  = loclCurrCd ;
		this.ioBndCd  = ioBndCd ;
		this.customer  = customer ;
		this.type  = type ;
		this.sailArrDt  = sailArrDt ;
		this.pagerows  = pagerows ;
		this.dpPrcsKnt  = dpPrcsKnt ;
		this.dpPrcsKntLcl  = dpPrcsKntLcl ;
		this.podCd  = podCd ;
		this.vvd  = vvd ;
		this.invNo  = invNo ;
		this.polCd  = polCd ;
		this.ibflag  = ibflag ;
		this.goodDate  = goodDate ;
		this.arIfNo  = arIfNo ;
		this.chgAmt  = chgAmt ;
		this.lclAmt  = lclAmt ;
		this.updUsrId  = updUsrId ;
		this.invXchRt  = invXchRt ;
		this.creUsrId  = creUsrId ;
		this.actInvNo  = actInvNo ;
		this.issDt  = issDt ;
		this.custNm  = custNm ;
		this.invType  = invType ;
		this.arOfcCd  = arOfcCd ;
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
		this.hashColumns.put("auto_inv_iss_flg", getAutoInvIssFlg());		
		this.hashColumns.put("bl_src_no", getBlSrcNo());		
		this.hashColumns.put("curr_cd", getCurrCd());		
		this.hashColumns.put("no", getNo());		
		this.hashColumns.put("locl_curr_cd", getLoclCurrCd());		
		this.hashColumns.put("io_bnd_cd", getIoBndCd());		
		this.hashColumns.put("customer", getCustomer());		
		this.hashColumns.put("type", getType());		
		this.hashColumns.put("sail_arr_dt", getSailArrDt());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("dp_prcs_knt", getDpPrcsKnt());		
		this.hashColumns.put("dp_prcs_knt_lcl", getDpPrcsKntLcl());		
		this.hashColumns.put("pod_cd", getPodCd());		
		this.hashColumns.put("vvd", getVvd());		
		this.hashColumns.put("inv_no", getInvNo());		
		this.hashColumns.put("pol_cd", getPolCd());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("good_date", getGoodDate());		
		this.hashColumns.put("ar_if_no", getArIfNo());		
		this.hashColumns.put("chg_amt", getChgAmt());		
		this.hashColumns.put("lcl_amt", getLclAmt());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("inv_xch_rt", getInvXchRt());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("act_inv_no", getActInvNo());		
		this.hashColumns.put("iss_dt", getIssDt());		
		this.hashColumns.put("cust_nm", getCustNm());		
		this.hashColumns.put("inv_type", getInvType());		
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());		
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
		this.hashFields.put("auto_inv_iss_flg", "autoInvIssFlg");
		this.hashFields.put("bl_src_no", "blSrcNo");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("no", "no");
		this.hashFields.put("locl_curr_cd", "loclCurrCd");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("customer", "customer");
		this.hashFields.put("type", "type");
		this.hashFields.put("sail_arr_dt", "sailArrDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dp_prcs_knt", "dpPrcsKnt");
		this.hashFields.put("dp_prcs_knt_lcl", "dpPrcsKntLcl");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("good_date", "goodDate");
		this.hashFields.put("ar_if_no", "arIfNo");
		this.hashFields.put("chg_amt", "chgAmt");
		this.hashFields.put("lcl_amt", "lclAmt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("inv_xch_rt", "invXchRt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("act_inv_no", "actInvNo");
		this.hashFields.put("iss_dt", "issDt");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("inv_type", "invType");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("ida_cgst_amt", "idaCgstAmt");
		this.hashFields.put("ida_sgst_amt", "idaSgstAmt");
		this.hashFields.put("ida_ugst_amt", "idaUgstAmt");
		this.hashFields.put("ida_igst_amt", "idaIgstAmt");
		this.hashFields.put("pro_inv_no", "proInvNo");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
	
	public InvoiceSumVO getInvoiceSumVO() {
		return invoiceSumVO;
	}

	public void setInvoiceSumVO(InvoiceSumVO invoiceSumVO) {
		this.invoiceSumVO = invoiceSumVO;
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
	* @param  no
	*/
	public void	setNo( String	no ) {
		this.no =	no;
	}
 
	/**
	 * Column Info
	 * @return	no
	 */
	 public	 String	getNo() {
		 return	this.no;
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
	* @param  customer
	*/
	public void	setCustomer( String	customer ) {
		this.customer =	customer;
	}
 
	/**
	 * Column Info
	 * @return	customer
	 */
	 public	 String	getCustomer() {
		 return	this.customer;
	 } 
 	/**
	* Column Info
	* @param  type
	*/
	public void	setType( String	type ) {
		this.type =	type;
	}
 
	/**
	 * Column Info
	 * @return	type
	 */
	 public	 String	getType() {
		 return	this.type;
	 } 
 	/**
	* Column Info
	* @param  sailArrDt
	*/
	public void	setSailArrDt( String	sailArrDt ) {
		this.sailArrDt =	sailArrDt;
	}
 
	/**
	 * Column Info
	 * @return	sailArrDt
	 */
	 public	 String	getSailArrDt() {
		 return	this.sailArrDt;
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
	* @param  dpPrcsKntLcl
	*/
	public void	setDpPrcsKntLcl( String	dpPrcsKntLcl ) {
		this.dpPrcsKntLcl =	dpPrcsKntLcl;
	}
 
	/**
	 * Column Info
	 * @return	dpPrcsKntLcl
	 */
	 public	 String	getDpPrcsKntLcl() {
		 return	this.dpPrcsKntLcl;
	 } 
 	/**
	* Column Info
	* @param  podCd
	*/
	public void	setPodCd( String	podCd ) {
		this.podCd =	podCd;
	}
 
	/**
	 * Column Info
	 * @return	podCd
	 */
	 public	 String	getPodCd() {
		 return	this.podCd;
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
	* @param  polCd
	*/
	public void	setPolCd( String	polCd ) {
		this.polCd =	polCd;
	}
 
	/**
	 * Column Info
	 * @return	polCd
	 */
	 public	 String	getPolCd() {
		 return	this.polCd;
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
	* @param  lclAmt
	*/
	public void	setLclAmt( String	lclAmt ) {
		this.lclAmt =	lclAmt;
	}
 
	/**
	 * Column Info
	 * @return	lclAmt
	 */
	 public	 String	getLclAmt() {
		 return	this.lclAmt;
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
	* @param  actInvNo
	*/
	public void	setActInvNo( String	actInvNo ) {
		this.actInvNo =	actInvNo;
	}
 
	/**
	 * Column Info
	 * @return	actInvNo
	 */
	 public	 String	getActInvNo() {
		 return	this.actInvNo;
	 } 
 	/**
	* Column Info
	* @param  issDt
	*/
	public void	setIssDt( String	issDt ) {
		this.issDt =	issDt;
	}
 
	/**
	 * Column Info
	 * @return	issDt
	 */
	 public	 String	getIssDt() {
		 return	this.issDt;
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
		setAutoInvIssFlg(JSPUtil.getParameter(request,	prefix + "auto_inv_iss_flg", ""));
		setBlSrcNo(JSPUtil.getParameter(request,	prefix + "bl_src_no", ""));
		setCurrCd(JSPUtil.getParameter(request,	prefix + "curr_cd", ""));
		setNo(JSPUtil.getParameter(request,	prefix + "no", ""));
		setLoclCurrCd(JSPUtil.getParameter(request,	prefix + "locl_curr_cd", ""));
		setIoBndCd(JSPUtil.getParameter(request,	prefix + "io_bnd_cd", ""));
		setCustomer(JSPUtil.getParameter(request,	prefix + "customer", ""));
		setType(JSPUtil.getParameter(request,	prefix + "type", ""));
		setSailArrDt(JSPUtil.getParameter(request,	prefix + "sail_arr_dt", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setDpPrcsKnt(JSPUtil.getParameter(request,	prefix + "dp_prcs_knt", ""));
		setDpPrcsKntLcl(JSPUtil.getParameter(request,	prefix + "dp_prcs_knt_lcl", ""));
		setPodCd(JSPUtil.getParameter(request,	prefix + "pod_cd", ""));
		setVvd(JSPUtil.getParameter(request,	prefix + "vvd", ""));
		setInvNo(JSPUtil.getParameter(request,	prefix + "inv_no", ""));
		setPolCd(JSPUtil.getParameter(request,	prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setGoodDate(JSPUtil.getParameter(request,	prefix + "good_date", ""));
		setArIfNo(JSPUtil.getParameter(request,	prefix + "ar_if_no", ""));
		setChgAmt(JSPUtil.getParameter(request,	prefix + "chg_amt", ""));
		setLclAmt(JSPUtil.getParameter(request,	prefix + "lcl_amt", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setInvXchRt(JSPUtil.getParameter(request,	prefix + "inv_xch_rt", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setActInvNo(JSPUtil.getParameter(request,	prefix + "act_inv_no", ""));
		setIssDt(JSPUtil.getParameter(request,	prefix + "iss_dt", ""));
		setCustNm(JSPUtil.getParameter(request,	prefix + "cust_nm", ""));
		setInvType(JSPUtil.getParameter(request,	prefix + "inv_type", ""));
		setArOfcCd(JSPUtil.getParameter(request,	prefix + "ar_ofc_cd", ""));
		setIdaCgstAmt(JSPUtil.getParameter(request,	prefix + "ida_cgst_amt", ""));
		setIdaSgstAmt(JSPUtil.getParameter(request,	prefix + "ida_sgst_amt", ""));
		setIdaUgstAmt(JSPUtil.getParameter(request,	prefix + "ida_ugst_amt", ""));
		setIdaIgstAmt(JSPUtil.getParameter(request,	prefix + "ida_igst_amt", ""));
		setProInvNo(JSPUtil.getParameter(request,	prefix + "pro_inv_no", ""));
	}
	
	/**
	 * Request �쓽 �뜲�씠�꽣瑜� VO 諛곗뿴濡� 蹂��솚�븯�뿬 諛섑솚.
	 * @param request
	 * @return ARInvoiceListByIFDateVO[]
	 */
	public ARInvoiceListByIFDateVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request �꽆�뼱�삩 �뿬�윭 嫄�	DATA瑜� VO Class �뿉 �떞�뒗�떎.
	 * @param request
	 * @param prefix
	 * @return ARInvoiceListByIFDateVO[]
	 */
	public ARInvoiceListByIFDateVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		ARInvoiceListByIFDateVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] autoInvIssFlg =	(JSPUtil.getParameter(request, prefix +	"auto_inv_iss_flg".trim(),	length));
				String[] blSrcNo =	(JSPUtil.getParameter(request, prefix +	"bl_src_no".trim(),	length));
				String[] currCd =	(JSPUtil.getParameter(request, prefix +	"curr_cd".trim(),	length));
				String[] no =	(JSPUtil.getParameter(request, prefix +	"no".trim(),	length));
				String[] loclCurrCd =	(JSPUtil.getParameter(request, prefix +	"locl_curr_cd".trim(),	length));
				String[] ioBndCd =	(JSPUtil.getParameter(request, prefix +	"io_bnd_cd".trim(),	length));
				String[] customer =	(JSPUtil.getParameter(request, prefix +	"customer".trim(),	length));
				String[] type =	(JSPUtil.getParameter(request, prefix +	"type".trim(),	length));
				String[] sailArrDt =	(JSPUtil.getParameter(request, prefix +	"sail_arr_dt".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] dpPrcsKnt =	(JSPUtil.getParameter(request, prefix +	"dp_prcs_knt".trim(),	length));
				String[] dpPrcsKntLcl =	(JSPUtil.getParameter(request, prefix +	"dp_prcs_knt_lcl".trim(),	length));
				String[] podCd =	(JSPUtil.getParameter(request, prefix +	"pod_cd".trim(),	length));
				String[] vvd =	(JSPUtil.getParameter(request, prefix +	"vvd".trim(),	length));
				String[] invNo =	(JSPUtil.getParameter(request, prefix +	"inv_no".trim(),	length));
				String[] polCd =	(JSPUtil.getParameter(request, prefix +	"pol_cd".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] goodDate =	(JSPUtil.getParameter(request, prefix +	"good_date".trim(),	length));
				String[] arIfNo =	(JSPUtil.getParameter(request, prefix +	"ar_if_no".trim(),	length));
				String[] chgAmt =	(JSPUtil.getParameter(request, prefix +	"chg_amt".trim(),	length));
				String[] lclAmt =	(JSPUtil.getParameter(request, prefix +	"lcl_amt".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] invXchRt =	(JSPUtil.getParameter(request, prefix +	"inv_xch_rt".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				String[] actInvNo =	(JSPUtil.getParameter(request, prefix +	"act_inv_no".trim(),	length));
				String[] issDt =	(JSPUtil.getParameter(request, prefix +	"iss_dt".trim(),	length));
				String[] custNm =	(JSPUtil.getParameter(request, prefix +	"cust_nm".trim(),	length));
				String[] invType =	(JSPUtil.getParameter(request, prefix +	"inv_type".trim(),	length));
				String[] arOfcCd =	(JSPUtil.getParameter(request, prefix +	"ar_ofc_cd".trim(),	length));
				String[] idaCgstAmt =	(JSPUtil.getParameter(request, prefix +	"ida_cgst_amt".trim(),	length));
				String[] idaSgstAmt =	(JSPUtil.getParameter(request, prefix +	"ida_sgst_amt".trim(),	length));
				String[] idaUgstAmt =	(JSPUtil.getParameter(request, prefix +	"ida_ugst_amt".trim(),	length));
				String[] idaIgstAmt =	(JSPUtil.getParameter(request, prefix +	"ida_igst_amt".trim(),	length));
				String[] proInvNo =	(JSPUtil.getParameter(request, prefix +	"pro_inv_no".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	ARInvoiceListByIFDateVO();
						if ( autoInvIssFlg[i] !=	null)
						model.setAutoInvIssFlg( autoInvIssFlg[i]);
						if ( blSrcNo[i] !=	null)
						model.setBlSrcNo( blSrcNo[i]);
						if ( currCd[i] !=	null)
						model.setCurrCd( currCd[i]);
						if ( no[i] !=	null)
						model.setNo( no[i]);
						if ( loclCurrCd[i] !=	null)
						model.setLoclCurrCd( loclCurrCd[i]);
						if ( ioBndCd[i] !=	null)
						model.setIoBndCd( ioBndCd[i]);
						if ( customer[i] !=	null)
						model.setCustomer( customer[i]);
						if ( type[i] !=	null)
						model.setType( type[i]);
						if ( sailArrDt[i] !=	null)
						model.setSailArrDt( sailArrDt[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( dpPrcsKnt[i] !=	null)
						model.setDpPrcsKnt( dpPrcsKnt[i]);
						if ( dpPrcsKntLcl[i] !=	null)
						model.setDpPrcsKntLcl( dpPrcsKntLcl[i]);
						if ( podCd[i] !=	null)
						model.setPodCd( podCd[i]);
						if ( vvd[i] !=	null)
						model.setVvd( vvd[i]);
						if ( invNo[i] !=	null)
						model.setInvNo( invNo[i]);
						if ( polCd[i] !=	null)
						model.setPolCd( polCd[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( goodDate[i] !=	null)
						model.setGoodDate( goodDate[i]);
						if ( arIfNo[i] !=	null)
						model.setArIfNo( arIfNo[i]);
						if ( chgAmt[i] !=	null)
						model.setChgAmt( chgAmt[i]);
						if ( lclAmt[i] !=	null)
						model.setLclAmt( lclAmt[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( invXchRt[i] !=	null)
						model.setInvXchRt( invXchRt[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
						if ( actInvNo[i] !=	null)
						model.setActInvNo( actInvNo[i]);
						if ( issDt[i] !=	null)
						model.setIssDt( issDt[i]);
						if ( custNm[i] !=	null)
						model.setCustNm( custNm[i]);
						if ( invType[i] !=	null)
						model.setInvType( invType[i]);
						if ( arOfcCd[i] !=	null)
						model.setArOfcCd( arOfcCd[i]);
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
		return getARInvoiceListByIFDateVOs();
	}

	/**
	 *  VO 諛곗뿴�쓣 諛섑솚
	 * @return ARInvoiceListByIFDateVO[]
	 */
	public ARInvoiceListByIFDateVO[]	 getARInvoiceListByIFDateVOs(){
		ARInvoiceListByIFDateVO[] vos = (ARInvoiceListByIFDateVO[])models.toArray(new	ARInvoiceListByIFDateVO[models.size()]);
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
		this.autoInvIssFlg =	this.autoInvIssFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSrcNo =	this.blSrcNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd =	this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.no =	this.no.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCd =	this.loclCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd =	this.ioBndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.customer =	this.customer.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.type =	this.type.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailArrDt =	this.sailArrDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpPrcsKnt =	this.dpPrcsKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpPrcsKntLcl =	this.dpPrcsKntLcl.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd =	this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd =	this.vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo =	this.invNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd =	this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.goodDate =	this.goodDate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfNo =	this.arIfNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmt =	this.chgAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lclAmt =	this.lclAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRt =	this.invXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actInvNo =	this.actInvNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issDt =	this.issDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm =	this.custNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invType =	this.invType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd =	this.arOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaCgstAmt =	this.idaCgstAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaSgstAmt =	this.idaSgstAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaUgstAmt =	this.idaUgstAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaIgstAmt =	this.idaIgstAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.proInvNo =	this.proInvNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}