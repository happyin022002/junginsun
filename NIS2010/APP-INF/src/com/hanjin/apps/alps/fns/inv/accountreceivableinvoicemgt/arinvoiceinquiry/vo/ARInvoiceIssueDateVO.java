/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ARInvoiceIssueDateVO.java
 *@FileTitle : ARInvoiceIssueDateVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2017.09.08
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2017.09.08  
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
 * - 관련	Event에서	작성,	서버실행요청시	PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author 
 * @since J2EE 1.6
 * @see	..
 */
public class ARInvoiceIssueDateVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<ARInvoiceIssueDateVO>  models =	new	ArrayList<ARInvoiceIssueDateVO>();


	/*	Column Info	*/
	private  String	 autoInvIssFlg   =  null;
	/*	Column Info	*/
	private  String	 blSrcNo   =  null;
	/*	Column Info	*/
	private  String	 localTotal   =  null;
	/*	Column Info	*/
	private  String	 currCd   =  null;
	/*	Column Info	*/
	private  String	 ioBndCd   =  null;
	/*	Column Info	*/
	private  String	 creUsrId1   =  null;
	/*	Column Info	*/
	private  String	 creUsrId2   =  null;
	/*	Column Info	*/
	private  String	 sailArrDt   =  null;
	/*	Column Info	*/
	private  String	 revTpCd   =  null;
	/*	Column Info	*/
	private  String	 arOfcCd   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 dpPrcsKnt   =  null;
	/*	Column Info	*/
	private  String	 podCd   =  null;
	/*	Column Info	*/
	private  String	 vvd   =  null;
	/*	Column Info	*/
	private  String	 invNo   =  null;
	/*	Column Info	*/
	private  String	 issDt   =  null;
	/*	Column Info	*/
	private  String	 polCd   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 arIfNo   =  null;
	/*	Column Info	*/
	private  String	 custCd   =  null;
	/*	Column Info	*/
	private  String	 chgAmt   =  null;
	/*	Column Info	*/
	private  String	 dpPrcsKntLocal   =  null;
	/*	Column Info	*/
	private  String	 invXchRt   =  null;
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
	/*	Column Info	*/
	private  String	 issOfcCd   =  null;
	/*	Column Info	*/
	private  String	 issOfcGstNo   =  null;
	/*	Column Info	*/
	private  String	 bkgNo   =  null;
	/*	Column Info	*/
	private  String	 sezFlg   =  null;
	/*	Column Info	*/
	private  String	 custGstNo   =  null;
	/*	Column Info	*/
	private  String	 custNm   =  null;
	/*	Column Info	*/
	private  String	 orgInvNo   =  null;
	/*	Column Info	*/
	private  String	 invTtlLoclAmt   =  null;
	/*	Column Info	*/
	private  String	 issOfcSteCd   =  null;
	/*	Column Info	*/
	private  String	 custSteCd   =  null;
	/*	Column Info	*/
	private  String	 rvsChgFlg   =  null;
	/*	Column Info	*/
	private  String	 porCntCd   =  null;
	/*	Column Info	*/
	private  String	 delCntCd   =  null;
	/*	Column Info	*/
	private  String	 idaSacCd   =  null;
	/*	Column Info	*/
	private  String	 taxableAmt   =  null;
	/*	Column Info	*/
	private  String	 idaIgstRto   =  null;
	/*	Column Info	*/
	private  String	 idaCgstRto   =  null;
	/*	Column Info	*/
	private  String	 idaSgstRto   =  null;
	/*	Column Info	*/
	private  String	 idaUgstRto   =  null;
	/*	Column Info	*/
	private  String	 ttlAmt   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public ARInvoiceIssueDateVO(){}

	public ARInvoiceIssueDateVO(String autoInvIssFlg,String blSrcNo,String localTotal,String currCd,String ioBndCd,String creUsrId1,String creUsrId2,String sailArrDt,String revTpCd,String arOfcCd,String pagerows,String dpPrcsKnt,String podCd,String vvd,String invNo,String issDt,String polCd,String ibflag,String arIfNo,String custCd,String chgAmt,String dpPrcsKntLocal,String invXchRt,String idaCgstAmt,String idaSgstAmt,String idaUgstAmt,String idaIgstAmt,String proInvNo,String issOfcCd,String issOfcGstNo,String bkgNo,String sezFlg,String custGstNo,String custNm,String orgInvNo,String invTtlLoclAmt,String issOfcSteCd,String custSteCd,String rvsChgFlg,String porCntCd,String delCntCd,String idaSacCd,String taxableAmt,String idaIgstRto,String idaCgstRto,String idaSgstRto,String idaUgstRto,String ttlAmt)	{
		this.autoInvIssFlg  = autoInvIssFlg ;
		this.blSrcNo  = blSrcNo ;
		this.localTotal  = localTotal ;
		this.currCd  = currCd ;
		this.ioBndCd  = ioBndCd ;
		this.creUsrId1  = creUsrId1 ;
		this.creUsrId2  = creUsrId2 ;
		this.sailArrDt  = sailArrDt ;
		this.revTpCd  = revTpCd ;
		this.arOfcCd  = arOfcCd ;
		this.pagerows  = pagerows ;
		this.dpPrcsKnt  = dpPrcsKnt ;
		this.podCd  = podCd ;
		this.vvd  = vvd ;
		this.invNo  = invNo ;
		this.issDt  = issDt ;
		this.polCd  = polCd ;
		this.ibflag  = ibflag ;
		this.arIfNo  = arIfNo ;
		this.custCd  = custCd ;
		this.chgAmt  = chgAmt ;
		this.dpPrcsKntLocal  = dpPrcsKntLocal ;
		this.invXchRt  = invXchRt ;
		this.idaCgstAmt  = idaCgstAmt ;
		this.idaSgstAmt  = idaSgstAmt ;
		this.idaUgstAmt  = idaUgstAmt ;
		this.idaIgstAmt  = idaIgstAmt ;
		this.proInvNo  = proInvNo ;
		this.issOfcCd  = issOfcCd ;
		this.issOfcGstNo  = issOfcGstNo ;
		this.bkgNo  = bkgNo ;
		this.sezFlg  = sezFlg ;
		this.custGstNo  = custGstNo ;
		this.custNm  = custNm ;
		this.orgInvNo  = orgInvNo ;
		this.invTtlLoclAmt  = invTtlLoclAmt ;
		this.issOfcSteCd  = issOfcSteCd ;
		this.custSteCd  = custSteCd ;
		this.rvsChgFlg  = rvsChgFlg ;
		this.porCntCd  = porCntCd ;
		this.delCntCd  = delCntCd ;
		this.idaSacCd  = idaSacCd ;
		this.taxableAmt  = taxableAmt ;
		this.idaIgstRto  = idaIgstRto ;
		this.idaCgstRto  = idaCgstRto ;
		this.idaSgstRto  = idaSgstRto ;
		this.idaUgstRto  = idaUgstRto ;
		this.ttlAmt  = ttlAmt ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("auto_inv_iss_flg", getAutoInvIssFlg());		
		this.hashColumns.put("bl_src_no", getBlSrcNo());		
		this.hashColumns.put("local_total", getLocalTotal());		
		this.hashColumns.put("curr_cd", getCurrCd());		
		this.hashColumns.put("io_bnd_cd", getIoBndCd());		
		this.hashColumns.put("cre_usr_id1", getCreUsrId1());		
		this.hashColumns.put("cre_usr_id2", getCreUsrId2());		
		this.hashColumns.put("sail_arr_dt", getSailArrDt());		
		this.hashColumns.put("rev_tp_cd", getRevTpCd());		
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("dp_prcs_knt", getDpPrcsKnt());		
		this.hashColumns.put("pod_cd", getPodCd());		
		this.hashColumns.put("vvd", getVvd());		
		this.hashColumns.put("inv_no", getInvNo());		
		this.hashColumns.put("iss_dt", getIssDt());		
		this.hashColumns.put("pol_cd", getPolCd());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("ar_if_no", getArIfNo());		
		this.hashColumns.put("cust_cd", getCustCd());		
		this.hashColumns.put("chg_amt", getChgAmt());		
		this.hashColumns.put("dp_prcs_knt_local", getDpPrcsKntLocal());		
		this.hashColumns.put("inv_xch_rt", getInvXchRt());		
		this.hashColumns.put("ida_cgst_amt", getIdaCgstAmt());		
		this.hashColumns.put("ida_sgst_amt", getIdaSgstAmt());		
		this.hashColumns.put("ida_ugst_amt", getIdaUgstAmt());		
		this.hashColumns.put("ida_igst_amt", getIdaIgstAmt());		
		this.hashColumns.put("pro_inv_no", getProInvNo());		
		this.hashColumns.put("iss_ofc_cd", getIssOfcCd());		
		this.hashColumns.put("iss_ofc_gst_no", getIssOfcGstNo());		
		this.hashColumns.put("bkg_no", getBkgNo());		
		this.hashColumns.put("sez_flg", getSezFlg());		
		this.hashColumns.put("cust_gst_no", getCustGstNo());		
		this.hashColumns.put("cust_nm", getCustNm());		
		this.hashColumns.put("org_inv_no", getOrgInvNo());		
		this.hashColumns.put("inv_ttl_locl_amt", getInvTtlLoclAmt());		
		this.hashColumns.put("iss_ofc_ste_cd", getIssOfcSteCd());		
		this.hashColumns.put("cust_ste_cd", getCustSteCd());		
		this.hashColumns.put("rvs_chg_flg", getRvsChgFlg());		
		this.hashColumns.put("por_cnt_cd", getPorCntCd());		
		this.hashColumns.put("del_cnt_cd", getDelCntCd());		
		this.hashColumns.put("ida_sac_cd", getIdaSacCd());		
		this.hashColumns.put("taxable_amt", getTaxableAmt());		
		this.hashColumns.put("ida_igst_rto", getIdaIgstRto());		
		this.hashColumns.put("ida_cgst_rto", getIdaCgstRto());		
		this.hashColumns.put("ida_sgst_rto", getIdaSgstRto());		
		this.hashColumns.put("ida_ugst_rto", getIdaUgstRto());		
		this.hashColumns.put("ttl_amt", getTtlAmt());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("auto_inv_iss_flg", "autoInvIssFlg");
		this.hashFields.put("bl_src_no", "blSrcNo");
		this.hashFields.put("local_total", "localTotal");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("cre_usr_id1", "creUsrId1");
		this.hashFields.put("cre_usr_id2", "creUsrId2");
		this.hashFields.put("sail_arr_dt", "sailArrDt");
		this.hashFields.put("rev_tp_cd", "revTpCd");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dp_prcs_knt", "dpPrcsKnt");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("iss_dt", "issDt");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ar_if_no", "arIfNo");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("chg_amt", "chgAmt");
		this.hashFields.put("dp_prcs_knt_local", "dpPrcsKntLocal");
		this.hashFields.put("inv_xch_rt", "invXchRt");
		this.hashFields.put("ida_cgst_amt", "idaCgstAmt");
		this.hashFields.put("ida_sgst_amt", "idaSgstAmt");
		this.hashFields.put("ida_ugst_amt", "idaUgstAmt");
		this.hashFields.put("ida_igst_amt", "idaIgstAmt");
		this.hashFields.put("pro_inv_no", "proInvNo");
		this.hashFields.put("iss_ofc_cd", "issOfcCd");
		this.hashFields.put("iss_ofc_gst_no", "issOfcGstNo");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("sez_flg", "sezFlg");
		this.hashFields.put("cust_gst_no", "custGstNo");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("org_inv_no", "orgInvNo");
		this.hashFields.put("inv_ttl_locl_amt", "invTtlLoclAmt");
		this.hashFields.put("iss_ofc_ste_cd", "issOfcSteCd");
		this.hashFields.put("cust_ste_cd", "custSteCd");
		this.hashFields.put("rvs_chg_flg", "rvsChgFlg");
		this.hashFields.put("por_cnt_cd", "porCntCd");
		this.hashFields.put("del_cnt_cd", "delCntCd");
		this.hashFields.put("ida_sac_cd", "idaSacCd");
		this.hashFields.put("taxable_amt", "taxableAmt");
		this.hashFields.put("ida_igst_rto", "idaIgstRto");
		this.hashFields.put("ida_cgst_rto", "idaCgstRto");
		this.hashFields.put("ida_sgst_rto", "idaSgstRto");
		this.hashFields.put("ida_ugst_rto", "idaUgstRto");
		this.hashFields.put("ttl_amt", "ttlAmt");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
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
	* @param  localTotal
	*/
	public void	setLocalTotal( String	localTotal ) {
		this.localTotal =	localTotal;
	}
 
	/**
	 * Column Info
	 * @return	localTotal
	 */
	 public	 String	getLocalTotal() {
		 return	this.localTotal;
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
	* @param  creUsrId1
	*/
	public void	setCreUsrId1( String	creUsrId1 ) {
		this.creUsrId1 =	creUsrId1;
	}
 
	/**
	 * Column Info
	 * @return	creUsrId1
	 */
	 public	 String	getCreUsrId1() {
		 return	this.creUsrId1;
	 } 
 	/**
	* Column Info
	* @param  creUsrId2
	*/
	public void	setCreUsrId2( String	creUsrId2 ) {
		this.creUsrId2 =	creUsrId2;
	}
 
	/**
	 * Column Info
	 * @return	creUsrId2
	 */
	 public	 String	getCreUsrId2() {
		 return	this.creUsrId2;
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
	* @param  custCd
	*/
	public void	setCustCd( String	custCd ) {
		this.custCd =	custCd;
	}
 
	/**
	 * Column Info
	 * @return	custCd
	 */
	 public	 String	getCustCd() {
		 return	this.custCd;
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
	* @param  dpPrcsKntLocal
	*/
	public void	setDpPrcsKntLocal( String	dpPrcsKntLocal ) {
		this.dpPrcsKntLocal =	dpPrcsKntLocal;
	}
 
	/**
	 * Column Info
	 * @return	dpPrcsKntLocal
	 */
	 public	 String	getDpPrcsKntLocal() {
		 return	this.dpPrcsKntLocal;
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
	* @param  issOfcGstNo
	*/
	public void	setIssOfcGstNo( String	issOfcGstNo ) {
		this.issOfcGstNo =	issOfcGstNo;
	}
 
	/**
	 * Column Info
	 * @return	issOfcGstNo
	 */
	 public	 String	getIssOfcGstNo() {
		 return	this.issOfcGstNo;
	 } 
 	/**
	* Column Info
	* @param  bkgNo
	*/
	public void	setBkgNo( String	bkgNo ) {
		this.bkgNo =	bkgNo;
	}
 
	/**
	 * Column Info
	 * @return	bkgNo
	 */
	 public	 String	getBkgNo() {
		 return	this.bkgNo;
	 } 
 	/**
	* Column Info
	* @param  sezFlg
	*/
	public void	setSezFlg( String	sezFlg ) {
		this.sezFlg =	sezFlg;
	}
 
	/**
	 * Column Info
	 * @return	sezFlg
	 */
	 public	 String	getSezFlg() {
		 return	this.sezFlg;
	 } 
 	/**
	* Column Info
	* @param  custGstNo
	*/
	public void	setCustGstNo( String	custGstNo ) {
		this.custGstNo =	custGstNo;
	}
 
	/**
	 * Column Info
	 * @return	custGstNo
	 */
	 public	 String	getCustGstNo() {
		 return	this.custGstNo;
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
	* @param  orgInvNo
	*/
	public void	setOrgInvNo( String	orgInvNo ) {
		this.orgInvNo =	orgInvNo;
	}
 
	/**
	 * Column Info
	 * @return	orgInvNo
	 */
	 public	 String	getOrgInvNo() {
		 return	this.orgInvNo;
	 } 
 	/**
	* Column Info
	* @param  invTtlLoclAmt
	*/
	public void	setInvTtlLoclAmt( String	invTtlLoclAmt ) {
		this.invTtlLoclAmt =	invTtlLoclAmt;
	}
 
	/**
	 * Column Info
	 * @return	invTtlLoclAmt
	 */
	 public	 String	getInvTtlLoclAmt() {
		 return	this.invTtlLoclAmt;
	 } 
 	/**
	* Column Info
	* @param  issOfcSteCd
	*/
	public void	setIssOfcSteCd( String	issOfcSteCd ) {
		this.issOfcSteCd =	issOfcSteCd;
	}
 
	/**
	 * Column Info
	 * @return	issOfcSteCd
	 */
	 public	 String	getIssOfcSteCd() {
		 return	this.issOfcSteCd;
	 } 
 	/**
	* Column Info
	* @param  custSteCd
	*/
	public void	setCustSteCd( String	custSteCd ) {
		this.custSteCd =	custSteCd;
	}
 
	/**
	 * Column Info
	 * @return	custSteCd
	 */
	 public	 String	getCustSteCd() {
		 return	this.custSteCd;
	 } 
 	/**
	* Column Info
	* @param  rvsChgFlg
	*/
	public void	setRvsChgFlg( String	rvsChgFlg ) {
		this.rvsChgFlg =	rvsChgFlg;
	}
 
	/**
	 * Column Info
	 * @return	rvsChgFlg
	 */
	 public	 String	getRvsChgFlg() {
		 return	this.rvsChgFlg;
	 } 
 	/**
	* Column Info
	* @param  porCntCd
	*/
	public void	setPorCntCd( String	porCntCd ) {
		this.porCntCd =	porCntCd;
	}
 
	/**
	 * Column Info
	 * @return	porCntCd
	 */
	 public	 String	getPorCntCd() {
		 return	this.porCntCd;
	 } 
 	/**
	* Column Info
	* @param  delCntCd
	*/
	public void	setDelCntCd( String	delCntCd ) {
		this.delCntCd =	delCntCd;
	}
 
	/**
	 * Column Info
	 * @return	delCntCd
	 */
	 public	 String	getDelCntCd() {
		 return	this.delCntCd;
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
	* @param  taxableAmt
	*/
	public void	setTaxableAmt( String	taxableAmt ) {
		this.taxableAmt =	taxableAmt;
	}
 
	/**
	 * Column Info
	 * @return	taxableAmt
	 */
	 public	 String	getTaxableAmt() {
		 return	this.taxableAmt;
	 } 
 	/**
	* Column Info
	* @param  idaIgstRto
	*/
	public void	setIdaIgstRto( String	idaIgstRto ) {
		this.idaIgstRto =	idaIgstRto;
	}
 
	/**
	 * Column Info
	 * @return	idaIgstRto
	 */
	 public	 String	getIdaIgstRto() {
		 return	this.idaIgstRto;
	 } 
 	/**
	* Column Info
	* @param  idaCgstRto
	*/
	public void	setIdaCgstRto( String	idaCgstRto ) {
		this.idaCgstRto =	idaCgstRto;
	}
 
	/**
	 * Column Info
	 * @return	idaCgstRto
	 */
	 public	 String	getIdaCgstRto() {
		 return	this.idaCgstRto;
	 } 
 	/**
	* Column Info
	* @param  idaSgstRto
	*/
	public void	setIdaSgstRto( String	idaSgstRto ) {
		this.idaSgstRto =	idaSgstRto;
	}
 
	/**
	 * Column Info
	 * @return	idaSgstRto
	 */
	 public	 String	getIdaSgstRto() {
		 return	this.idaSgstRto;
	 } 
 	/**
	* Column Info
	* @param  idaUgstRto
	*/
	public void	setIdaUgstRto( String	idaUgstRto ) {
		this.idaUgstRto =	idaUgstRto;
	}
 
	/**
	 * Column Info
	 * @return	idaUgstRto
	 */
	 public	 String	getIdaUgstRto() {
		 return	this.idaUgstRto;
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
		setAutoInvIssFlg(JSPUtil.getParameter(request,	prefix + "auto_inv_iss_flg", ""));
		setBlSrcNo(JSPUtil.getParameter(request,	prefix + "bl_src_no", ""));
		setLocalTotal(JSPUtil.getParameter(request,	prefix + "local_total", ""));
		setCurrCd(JSPUtil.getParameter(request,	prefix + "curr_cd", ""));
		setIoBndCd(JSPUtil.getParameter(request,	prefix + "io_bnd_cd", ""));
		setCreUsrId1(JSPUtil.getParameter(request,	prefix + "cre_usr_id1", ""));
		setCreUsrId2(JSPUtil.getParameter(request,	prefix + "cre_usr_id2", ""));
		setSailArrDt(JSPUtil.getParameter(request,	prefix + "sail_arr_dt", ""));
		setRevTpCd(JSPUtil.getParameter(request,	prefix + "rev_tp_cd", ""));
		setArOfcCd(JSPUtil.getParameter(request,	prefix + "ar_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setDpPrcsKnt(JSPUtil.getParameter(request,	prefix + "dp_prcs_knt", ""));
		setPodCd(JSPUtil.getParameter(request,	prefix + "pod_cd", ""));
		setVvd(JSPUtil.getParameter(request,	prefix + "vvd", ""));
		setInvNo(JSPUtil.getParameter(request,	prefix + "inv_no", ""));
		setIssDt(JSPUtil.getParameter(request,	prefix + "iss_dt", ""));
		setPolCd(JSPUtil.getParameter(request,	prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setArIfNo(JSPUtil.getParameter(request,	prefix + "ar_if_no", ""));
		setCustCd(JSPUtil.getParameter(request,	prefix + "cust_cd", ""));
		setChgAmt(JSPUtil.getParameter(request,	prefix + "chg_amt", ""));
		setDpPrcsKntLocal(JSPUtil.getParameter(request,	prefix + "dp_prcs_knt_local", ""));
		setInvXchRt(JSPUtil.getParameter(request,	prefix + "inv_xch_rt", ""));
		setIdaCgstAmt(JSPUtil.getParameter(request,	prefix + "ida_cgst_amt", ""));
		setIdaSgstAmt(JSPUtil.getParameter(request,	prefix + "ida_sgst_amt", ""));
		setIdaUgstAmt(JSPUtil.getParameter(request,	prefix + "ida_ugst_amt", ""));
		setIdaIgstAmt(JSPUtil.getParameter(request,	prefix + "ida_igst_amt", ""));
		setProInvNo(JSPUtil.getParameter(request,	prefix + "pro_inv_no", ""));
		setIssOfcCd(JSPUtil.getParameter(request,	prefix + "iss_ofc_cd", ""));
		setIssOfcGstNo(JSPUtil.getParameter(request,	prefix + "iss_ofc_gst_no", ""));
		setBkgNo(JSPUtil.getParameter(request,	prefix + "bkg_no", ""));
		setSezFlg(JSPUtil.getParameter(request,	prefix + "sez_flg", ""));
		setCustGstNo(JSPUtil.getParameter(request,	prefix + "cust_gst_no", ""));
		setCustNm(JSPUtil.getParameter(request,	prefix + "cust_nm", ""));
		setOrgInvNo(JSPUtil.getParameter(request,	prefix + "org_inv_no", ""));
		setInvTtlLoclAmt(JSPUtil.getParameter(request,	prefix + "inv_ttl_locl_amt", ""));
		setIssOfcSteCd(JSPUtil.getParameter(request,	prefix + "iss_ofc_ste_cd", ""));
		setCustSteCd(JSPUtil.getParameter(request,	prefix + "cust_ste_cd", ""));
		setRvsChgFlg(JSPUtil.getParameter(request,	prefix + "rvs_chg_flg", ""));
		setPorCntCd(JSPUtil.getParameter(request,	prefix + "por_cnt_cd", ""));
		setDelCntCd(JSPUtil.getParameter(request,	prefix + "del_cnt_cd", ""));
		setIdaSacCd(JSPUtil.getParameter(request,	prefix + "ida_sac_cd", ""));
		setTaxableAmt(JSPUtil.getParameter(request,	prefix + "taxable_amt", ""));
		setIdaIgstRto(JSPUtil.getParameter(request,	prefix + "ida_igst_rto", ""));
		setIdaCgstRto(JSPUtil.getParameter(request,	prefix + "ida_cgst_rto", ""));
		setIdaSgstRto(JSPUtil.getParameter(request,	prefix + "ida_sgst_rto", ""));
		setIdaUgstRto(JSPUtil.getParameter(request,	prefix + "ida_ugst_rto", ""));
		setTtlAmt(JSPUtil.getParameter(request,	prefix + "ttl_amt", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ARInvoiceIssueDateVO[]
	 */
	public ARInvoiceIssueDateVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return ARInvoiceIssueDateVO[]
	 */
	public ARInvoiceIssueDateVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		ARInvoiceIssueDateVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] autoInvIssFlg =	(JSPUtil.getParameter(request, prefix +	"auto_inv_iss_flg".trim(),	length));
				String[] blSrcNo =	(JSPUtil.getParameter(request, prefix +	"bl_src_no".trim(),	length));
				String[] localTotal =	(JSPUtil.getParameter(request, prefix +	"local_total".trim(),	length));
				String[] currCd =	(JSPUtil.getParameter(request, prefix +	"curr_cd".trim(),	length));
				String[] ioBndCd =	(JSPUtil.getParameter(request, prefix +	"io_bnd_cd".trim(),	length));
				String[] creUsrId1 =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id1".trim(),	length));
				String[] creUsrId2 =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id2".trim(),	length));
				String[] sailArrDt =	(JSPUtil.getParameter(request, prefix +	"sail_arr_dt".trim(),	length));
				String[] revTpCd =	(JSPUtil.getParameter(request, prefix +	"rev_tp_cd".trim(),	length));
				String[] arOfcCd =	(JSPUtil.getParameter(request, prefix +	"ar_ofc_cd".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] dpPrcsKnt =	(JSPUtil.getParameter(request, prefix +	"dp_prcs_knt".trim(),	length));
				String[] podCd =	(JSPUtil.getParameter(request, prefix +	"pod_cd".trim(),	length));
				String[] vvd =	(JSPUtil.getParameter(request, prefix +	"vvd".trim(),	length));
				String[] invNo =	(JSPUtil.getParameter(request, prefix +	"inv_no".trim(),	length));
				String[] issDt =	(JSPUtil.getParameter(request, prefix +	"iss_dt".trim(),	length));
				String[] polCd =	(JSPUtil.getParameter(request, prefix +	"pol_cd".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] arIfNo =	(JSPUtil.getParameter(request, prefix +	"ar_if_no".trim(),	length));
				String[] custCd =	(JSPUtil.getParameter(request, prefix +	"cust_cd".trim(),	length));
				String[] chgAmt =	(JSPUtil.getParameter(request, prefix +	"chg_amt".trim(),	length));
				String[] dpPrcsKntLocal =	(JSPUtil.getParameter(request, prefix +	"dp_prcs_knt_local".trim(),	length));
				String[] invXchRt =	(JSPUtil.getParameter(request, prefix +	"inv_xch_rt".trim(),	length));
				String[] idaCgstAmt =	(JSPUtil.getParameter(request, prefix +	"ida_cgst_amt".trim(),	length));
				String[] idaSgstAmt =	(JSPUtil.getParameter(request, prefix +	"ida_sgst_amt".trim(),	length));
				String[] idaUgstAmt =	(JSPUtil.getParameter(request, prefix +	"ida_ugst_amt".trim(),	length));
				String[] idaIgstAmt =	(JSPUtil.getParameter(request, prefix +	"ida_igst_amt".trim(),	length));
				String[] proInvNo =	(JSPUtil.getParameter(request, prefix +	"pro_inv_no".trim(),	length));
				String[] issOfcCd =	(JSPUtil.getParameter(request, prefix +	"iss_ofc_cd".trim(),	length));
				String[] issOfcGstNo =	(JSPUtil.getParameter(request, prefix +	"iss_ofc_gst_no".trim(),	length));
				String[] bkgNo =	(JSPUtil.getParameter(request, prefix +	"bkg_no".trim(),	length));
				String[] sezFlg =	(JSPUtil.getParameter(request, prefix +	"sez_flg".trim(),	length));
				String[] custGstNo =	(JSPUtil.getParameter(request, prefix +	"cust_gst_no".trim(),	length));
				String[] custNm =	(JSPUtil.getParameter(request, prefix +	"cust_nm".trim(),	length));
				String[] orgInvNo =	(JSPUtil.getParameter(request, prefix +	"org_inv_no".trim(),	length));
				String[] invTtlLoclAmt =	(JSPUtil.getParameter(request, prefix +	"inv_ttl_locl_amt".trim(),	length));
				String[] issOfcSteCd =	(JSPUtil.getParameter(request, prefix +	"iss_ofc_ste_cd".trim(),	length));
				String[] custSteCd =	(JSPUtil.getParameter(request, prefix +	"cust_ste_cd".trim(),	length));
				String[] rvsChgFlg =	(JSPUtil.getParameter(request, prefix +	"rvs_chg_flg".trim(),	length));
				String[] porCntCd =	(JSPUtil.getParameter(request, prefix +	"por_cnt_cd".trim(),	length));
				String[] delCntCd =	(JSPUtil.getParameter(request, prefix +	"del_cnt_cd".trim(),	length));
				String[] idaSacCd =	(JSPUtil.getParameter(request, prefix +	"ida_sac_cd".trim(),	length));
				String[] taxableAmt =	(JSPUtil.getParameter(request, prefix +	"taxable_amt".trim(),	length));
				String[] idaIgstRto =	(JSPUtil.getParameter(request, prefix +	"ida_igst_rto".trim(),	length));
				String[] idaCgstRto =	(JSPUtil.getParameter(request, prefix +	"ida_cgst_rto".trim(),	length));
				String[] idaSgstRto =	(JSPUtil.getParameter(request, prefix +	"ida_sgst_rto".trim(),	length));
				String[] idaUgstRto =	(JSPUtil.getParameter(request, prefix +	"ida_ugst_rto".trim(),	length));
				String[] ttlAmt =	(JSPUtil.getParameter(request, prefix +	"ttl_amt".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	ARInvoiceIssueDateVO();
						if ( autoInvIssFlg[i] !=	null)
						model.setAutoInvIssFlg( autoInvIssFlg[i]);
						if ( blSrcNo[i] !=	null)
						model.setBlSrcNo( blSrcNo[i]);
						if ( localTotal[i] !=	null)
						model.setLocalTotal( localTotal[i]);
						if ( currCd[i] !=	null)
						model.setCurrCd( currCd[i]);
						if ( ioBndCd[i] !=	null)
						model.setIoBndCd( ioBndCd[i]);
						if ( creUsrId1[i] !=	null)
						model.setCreUsrId1( creUsrId1[i]);
						if ( creUsrId2[i] !=	null)
						model.setCreUsrId2( creUsrId2[i]);
						if ( sailArrDt[i] !=	null)
						model.setSailArrDt( sailArrDt[i]);
						if ( revTpCd[i] !=	null)
						model.setRevTpCd( revTpCd[i]);
						if ( arOfcCd[i] !=	null)
						model.setArOfcCd( arOfcCd[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( dpPrcsKnt[i] !=	null)
						model.setDpPrcsKnt( dpPrcsKnt[i]);
						if ( podCd[i] !=	null)
						model.setPodCd( podCd[i]);
						if ( vvd[i] !=	null)
						model.setVvd( vvd[i]);
						if ( invNo[i] !=	null)
						model.setInvNo( invNo[i]);
						if ( issDt[i] !=	null)
						model.setIssDt( issDt[i]);
						if ( polCd[i] !=	null)
						model.setPolCd( polCd[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( arIfNo[i] !=	null)
						model.setArIfNo( arIfNo[i]);
						if ( custCd[i] !=	null)
						model.setCustCd( custCd[i]);
						if ( chgAmt[i] !=	null)
						model.setChgAmt( chgAmt[i]);
						if ( dpPrcsKntLocal[i] !=	null)
						model.setDpPrcsKntLocal( dpPrcsKntLocal[i]);
						if ( invXchRt[i] !=	null)
						model.setInvXchRt( invXchRt[i]);
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
						if ( issOfcCd[i] !=	null)
						model.setIssOfcCd( issOfcCd[i]);
						if ( issOfcGstNo[i] !=	null)
						model.setIssOfcGstNo( issOfcGstNo[i]);
						if ( bkgNo[i] !=	null)
						model.setBkgNo( bkgNo[i]);
						if ( sezFlg[i] !=	null)
						model.setSezFlg( sezFlg[i]);
						if ( custGstNo[i] !=	null)
						model.setCustGstNo( custGstNo[i]);
						if ( custNm[i] !=	null)
						model.setCustNm( custNm[i]);
						if ( orgInvNo[i] !=	null)
						model.setOrgInvNo( orgInvNo[i]);
						if ( invTtlLoclAmt[i] !=	null)
						model.setInvTtlLoclAmt( invTtlLoclAmt[i]);
						if ( issOfcSteCd[i] !=	null)
						model.setIssOfcSteCd( issOfcSteCd[i]);
						if ( custSteCd[i] !=	null)
						model.setCustSteCd( custSteCd[i]);
						if ( rvsChgFlg[i] !=	null)
						model.setRvsChgFlg( rvsChgFlg[i]);
						if ( porCntCd[i] !=	null)
						model.setPorCntCd( porCntCd[i]);
						if ( delCntCd[i] !=	null)
						model.setDelCntCd( delCntCd[i]);
						if ( idaSacCd[i] !=	null)
						model.setIdaSacCd( idaSacCd[i]);
						if ( taxableAmt[i] !=	null)
						model.setTaxableAmt( taxableAmt[i]);
						if ( idaIgstRto[i] !=	null)
						model.setIdaIgstRto( idaIgstRto[i]);
						if ( idaCgstRto[i] !=	null)
						model.setIdaCgstRto( idaCgstRto[i]);
						if ( idaSgstRto[i] !=	null)
						model.setIdaSgstRto( idaSgstRto[i]);
						if ( idaUgstRto[i] !=	null)
						model.setIdaUgstRto( idaUgstRto[i]);
						if ( ttlAmt[i] !=	null)
						model.setTtlAmt( ttlAmt[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getARInvoiceIssueDateVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return ARInvoiceIssueDateVO[]
	 */
	public ARInvoiceIssueDateVO[]	 getARInvoiceIssueDateVOs(){
		ARInvoiceIssueDateVO[] vos = (ARInvoiceIssueDateVO[])models.toArray(new	ARInvoiceIssueDateVO[models.size()]);
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
		this.autoInvIssFlg =	this.autoInvIssFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSrcNo =	this.blSrcNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.localTotal =	this.localTotal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd =	this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd =	this.ioBndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId1 =	this.creUsrId1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId2 =	this.creUsrId2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailArrDt =	this.sailArrDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revTpCd =	this.revTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd =	this.arOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpPrcsKnt =	this.dpPrcsKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd =	this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd =	this.vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo =	this.invNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issDt =	this.issDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd =	this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfNo =	this.arIfNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd =	this.custCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmt =	this.chgAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpPrcsKntLocal =	this.dpPrcsKntLocal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRt =	this.invXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaCgstAmt =	this.idaCgstAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaSgstAmt =	this.idaSgstAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaUgstAmt =	this.idaUgstAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaIgstAmt =	this.idaIgstAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.proInvNo =	this.proInvNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issOfcCd =	this.issOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issOfcGstNo =	this.issOfcGstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo =	this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sezFlg =	this.sezFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custGstNo =	this.custGstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm =	this.custNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgInvNo =	this.orgInvNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTtlLoclAmt =	this.invTtlLoclAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issOfcSteCd =	this.issOfcSteCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSteCd =	this.custSteCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvsChgFlg =	this.rvsChgFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCntCd =	this.porCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCntCd =	this.delCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaSacCd =	this.idaSacCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxableAmt =	this.taxableAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaIgstRto =	this.idaIgstRto.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaCgstRto =	this.idaCgstRto.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaSgstRto =	this.idaSgstRto.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaUgstRto =	this.idaUgstRto.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlAmt =	this.ttlAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}