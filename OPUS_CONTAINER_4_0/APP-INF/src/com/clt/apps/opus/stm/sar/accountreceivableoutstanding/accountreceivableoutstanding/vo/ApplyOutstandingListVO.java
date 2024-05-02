/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ApplyOutstandingListVO.java
 *@FileTitle : ApplyOutstandingListVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.04.02
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2015.04.02  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo;

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
public class ApplyOutstandingListVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<ApplyOutstandingListVO>  models =	new	ArrayList<ApplyOutstandingListVO>();


	/*	Column Info	*/
	private  String	 chgTpCd   =  null;
	/*	Column Info	*/
	private  String	 custNm   =  null;
	/*	Column Info	*/
	private  String	 bilToCustCntCd   =  null;
	/*	Column Info	*/
	private  String	 otsSmryCd   =  null;
	/*	Column Info	*/
	private  String	 shpToCustCd   =  null;
	/*	Column Info	*/
	private  String	 blNo   =  null;
	/*	Column Info	*/
	private  String	 otsBalAmt   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 loclBalAmt   =  null;
	/*	Column Info	*/
	private  String	 otsSrcCd   =  null;
	/*	Column Info	*/
	private  String	 dueDt   =  null;
	/*	Column Info	*/
	private  String	 shpToCustSeq   =  null;
	/*	Column Info	*/
	private  String	 rhqCd   =  null;
	/*	Column Info	*/
	private  String	 blCurrCd   =  null;
	/*	Column Info	*/
	private  String	 loclVvdCd   =  null;
	/*	Column Info	*/
	private  String	 bilToCustSeq   =  null;
	/*	Column Info	*/
	private  String	 bilToCustCd   =  null;
	/*	Column Info	*/
	private  String	 invNo   =  null;
	/*	Column Info	*/
	private  String	 bkgNo   =  null;
	/*	Column Info	*/
	private  String	 otsRmk   =  null;
	/*	Column Info	*/
	private  String	 usdBalAmt   =  null;
	/*	Column Info	*/
	private  String	 otsCd   =  null;
	/*	Column Info	*/
	private  String	 shpToCustCntCd   =  null;
	/*	Column Info	*/
	private  String	 otsOfcCd   =  null;
	/*	Column Info	*/
	private  String	 overDue   =  null;
	/*	Column Info	*/
	private  String	 repOtsOfcCd   =  null;
	/*	Column Info	*/
	private  String	 otsRctTmpSeq   =  null;
	/*	Column Info	*/
	private  String	 rctAplyHdrSeq   =  null;
	/*	Column Info	*/
	private  String	 rctAplyFlg   =  null;
	/*	Column Info	*/
	private  String	 ofcCd   =  null;
	/*	Column Info	*/
	private  String	 trnkVvdCd   =  null;
	/*	Column Info	*/
	private  String	 sailArrDt   =  null;
	/*	Column Info	*/
	private  String	 ioBndCd   =  null;
	/*	Column Info	*/
	private  String	 srepCd   =  null;
	/*	Column Info	*/
	private  String	 xchRtTpCd   =  null;
	/*	Column Info	*/
	private  String	 xchRtDt   =  null;
	/*	Column Info	*/
	private  String	 crFlg   =  null;
	/*	Column Info	*/
	private  String	 arFincSrcCd   =  null;
	/*	Column Info	*/
	private  String	 maxArIfNo   =  null;
	/*	Column Info	*/
	private  String	 invDt   =  null;
	/*	Column Info	*/
	private  String	 rctAplyChgCd   =  null;
	/*	Column Info	*/
	private  String	 rctAplySrcCurrCd   =  null;
	/*	Column Info	*/
	private  String	 otsAplyAmt   =  null;
	/*	Column Info	*/
	private  String	 otsXchRt   =  null;
	/*	Column Info	*/
	private  String	 rctAplyXchRt   =  null;
	/*	Column Info	*/
	private  String	 rctCurrCd   =  null;
	/*	Column Info	*/
	private  String	 rctAplyAmt   =  null;
	/*	Column Info	*/
	private  String	 dpPrcsKnt   =  null;
	/*	Column Info	*/
	private  String	 hdrDupFlg   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public ApplyOutstandingListVO(){}

	public ApplyOutstandingListVO(String chgTpCd,String custNm,String bilToCustCntCd,String otsSmryCd,String shpToCustCd,String blNo,String otsBalAmt,String pagerows,String ibflag,String loclBalAmt,String otsSrcCd,String dueDt,String shpToCustSeq,String rhqCd,String blCurrCd,String loclVvdCd,String bilToCustSeq,String bilToCustCd,String invNo,String bkgNo,String otsRmk,String usdBalAmt,String otsCd,String shpToCustCntCd,String otsOfcCd,String overDue,String repOtsOfcCd,String otsRctTmpSeq,String rctAplyHdrSeq,String rctAplyFlg,String ofcCd,String trnkVvdCd,String sailArrDt,String ioBndCd,String srepCd,String xchRtTpCd,String xchRtDt,String crFlg,String arFincSrcCd,String maxArIfNo,String invDt,String rctAplyChgCd,String rctAplySrcCurrCd,String otsAplyAmt,String otsXchRt,String rctAplyXchRt,String rctCurrCd,String rctAplyAmt,String dpPrcsKnt,String hdrDupFlg)	{
		this.chgTpCd  = chgTpCd ;
		this.custNm  = custNm ;
		this.bilToCustCntCd  = bilToCustCntCd ;
		this.otsSmryCd  = otsSmryCd ;
		this.shpToCustCd  = shpToCustCd ;
		this.blNo  = blNo ;
		this.otsBalAmt  = otsBalAmt ;
		this.pagerows  = pagerows ;
		this.ibflag  = ibflag ;
		this.loclBalAmt  = loclBalAmt ;
		this.otsSrcCd  = otsSrcCd ;
		this.dueDt  = dueDt ;
		this.shpToCustSeq  = shpToCustSeq ;
		this.rhqCd  = rhqCd ;
		this.blCurrCd  = blCurrCd ;
		this.loclVvdCd  = loclVvdCd ;
		this.bilToCustSeq  = bilToCustSeq ;
		this.bilToCustCd  = bilToCustCd ;
		this.invNo  = invNo ;
		this.bkgNo  = bkgNo ;
		this.otsRmk  = otsRmk ;
		this.usdBalAmt  = usdBalAmt ;
		this.otsCd  = otsCd ;
		this.shpToCustCntCd  = shpToCustCntCd ;
		this.otsOfcCd  = otsOfcCd ;
		this.overDue  = overDue ;
		this.repOtsOfcCd  = repOtsOfcCd ;
		this.otsRctTmpSeq  = otsRctTmpSeq ;
		this.rctAplyHdrSeq  = rctAplyHdrSeq ;
		this.rctAplyFlg  = rctAplyFlg ;
		this.ofcCd  = ofcCd ;
		this.trnkVvdCd  = trnkVvdCd ;
		this.sailArrDt  = sailArrDt ;
		this.ioBndCd  = ioBndCd ;
		this.srepCd  = srepCd ;
		this.xchRtTpCd  = xchRtTpCd ;
		this.xchRtDt  = xchRtDt ;
		this.crFlg  = crFlg ;
		this.arFincSrcCd  = arFincSrcCd ;
		this.maxArIfNo  = maxArIfNo ;
		this.invDt  = invDt ;
		this.rctAplyChgCd  = rctAplyChgCd ;
		this.rctAplySrcCurrCd  = rctAplySrcCurrCd ;
		this.otsAplyAmt  = otsAplyAmt ;
		this.otsXchRt  = otsXchRt ;
		this.rctAplyXchRt  = rctAplyXchRt ;
		this.rctCurrCd  = rctCurrCd ;
		this.rctAplyAmt  = rctAplyAmt ;
		this.dpPrcsKnt  = dpPrcsKnt ;
		this.hdrDupFlg  = hdrDupFlg ;
	}


	/**
	 * �뚯씠釉�而щ읆����옣��媛믪쓣 Hashtable<"column_name", "value">	濡�諛섑솚
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("chg_tp_cd", getChgTpCd());		
		this.hashColumns.put("cust_nm", getCustNm());		
		this.hashColumns.put("bil_to_cust_cnt_cd", getBilToCustCntCd());		
		this.hashColumns.put("ots_smry_cd", getOtsSmryCd());		
		this.hashColumns.put("shp_to_cust_cd", getShpToCustCd());		
		this.hashColumns.put("bl_no", getBlNo());		
		this.hashColumns.put("ots_bal_amt", getOtsBalAmt());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("locl_bal_amt", getLoclBalAmt());		
		this.hashColumns.put("ots_src_cd", getOtsSrcCd());		
		this.hashColumns.put("due_dt", getDueDt());		
		this.hashColumns.put("shp_to_cust_seq", getShpToCustSeq());		
		this.hashColumns.put("rhq_cd", getRhqCd());		
		this.hashColumns.put("bl_curr_cd", getBlCurrCd());		
		this.hashColumns.put("locl_vvd_cd", getLoclVvdCd());		
		this.hashColumns.put("bil_to_cust_seq", getBilToCustSeq());		
		this.hashColumns.put("bil_to_cust_cd", getBilToCustCd());		
		this.hashColumns.put("inv_no", getInvNo());		
		this.hashColumns.put("bkg_no", getBkgNo());		
		this.hashColumns.put("ots_rmk", getOtsRmk());		
		this.hashColumns.put("usd_bal_amt", getUsdBalAmt());		
		this.hashColumns.put("ots_cd", getOtsCd());		
		this.hashColumns.put("shp_to_cust_cnt_cd", getShpToCustCntCd());		
		this.hashColumns.put("ots_ofc_cd", getOtsOfcCd());		
		this.hashColumns.put("over_due", getOverDue());		
		this.hashColumns.put("rep_ots_ofc_cd", getRepOtsOfcCd());		
		this.hashColumns.put("ots_rct_tmp_seq", getOtsRctTmpSeq());		
		this.hashColumns.put("rct_aply_hdr_seq", getRctAplyHdrSeq());		
		this.hashColumns.put("rct_aply_flg", getRctAplyFlg());		
		this.hashColumns.put("ofc_cd", getOfcCd());		
		this.hashColumns.put("trnk_vvd_cd", getTrnkVvdCd());		
		this.hashColumns.put("sail_arr_dt", getSailArrDt());		
		this.hashColumns.put("io_bnd_cd", getIoBndCd());		
		this.hashColumns.put("srep_cd", getSrepCd());		
		this.hashColumns.put("xch_rt_tp_cd", getXchRtTpCd());		
		this.hashColumns.put("xch_rt_dt", getXchRtDt());		
		this.hashColumns.put("cr_flg", getCrFlg());		
		this.hashColumns.put("ar_finc_src_cd", getArFincSrcCd());		
		this.hashColumns.put("max_ar_if_no", getMaxArIfNo());		
		this.hashColumns.put("inv_dt", getInvDt());		
		this.hashColumns.put("rct_aply_chg_cd", getRctAplyChgCd());		
		this.hashColumns.put("rct_aply_src_curr_cd", getRctAplySrcCurrCd());		
		this.hashColumns.put("ots_aply_amt", getOtsAplyAmt());		
		this.hashColumns.put("ots_xch_rt", getOtsXchRt());		
		this.hashColumns.put("rct_aply_xch_rt", getRctAplyXchRt());		
		this.hashColumns.put("rct_curr_cd", getRctCurrCd());		
		this.hashColumns.put("rct_aply_amt", getRctAplyAmt());		
		this.hashColumns.put("dp_prcs_knt", getDpPrcsKnt());		
		this.hashColumns.put("hdr_dup_flg", getHdrDupFlg());		
		return this.hashColumns;
}

	/**
	 * 而щ읆紐낆뿉	��쓳�섎뒗 硫ㅻ쾭蹂�닔紐낆쓣	��옣�섏뿬 Hashtable<"column_name", "variable"> 濡�諛섑솚
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("chg_tp_cd", "chgTpCd");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("bil_to_cust_cnt_cd", "bilToCustCntCd");
		this.hashFields.put("ots_smry_cd", "otsSmryCd");
		this.hashFields.put("shp_to_cust_cd", "shpToCustCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("ots_bal_amt", "otsBalAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("locl_bal_amt", "loclBalAmt");
		this.hashFields.put("ots_src_cd", "otsSrcCd");
		this.hashFields.put("due_dt", "dueDt");
		this.hashFields.put("shp_to_cust_seq", "shpToCustSeq");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("bl_curr_cd", "blCurrCd");
		this.hashFields.put("locl_vvd_cd", "loclVvdCd");
		this.hashFields.put("bil_to_cust_seq", "bilToCustSeq");
		this.hashFields.put("bil_to_cust_cd", "bilToCustCd");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ots_rmk", "otsRmk");
		this.hashFields.put("usd_bal_amt", "usdBalAmt");
		this.hashFields.put("ots_cd", "otsCd");
		this.hashFields.put("shp_to_cust_cnt_cd", "shpToCustCntCd");
		this.hashFields.put("ots_ofc_cd", "otsOfcCd");
		this.hashFields.put("over_due", "overDue");
		this.hashFields.put("rep_ots_ofc_cd", "repOtsOfcCd");
		this.hashFields.put("ots_rct_tmp_seq", "otsRctTmpSeq");
		this.hashFields.put("rct_aply_hdr_seq", "rctAplyHdrSeq");
		this.hashFields.put("rct_aply_flg", "rctAplyFlg");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("trnk_vvd_cd", "trnkVvdCd");
		this.hashFields.put("sail_arr_dt", "sailArrDt");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("srep_cd", "srepCd");
		this.hashFields.put("xch_rt_tp_cd", "xchRtTpCd");
		this.hashFields.put("xch_rt_dt", "xchRtDt");
		this.hashFields.put("cr_flg", "crFlg");
		this.hashFields.put("ar_finc_src_cd", "arFincSrcCd");
		this.hashFields.put("max_ar_if_no", "maxArIfNo");
		this.hashFields.put("inv_dt", "invDt");
		this.hashFields.put("rct_aply_chg_cd", "rctAplyChgCd");
		this.hashFields.put("rct_aply_src_curr_cd", "rctAplySrcCurrCd");
		this.hashFields.put("ots_aply_amt", "otsAplyAmt");
		this.hashFields.put("ots_xch_rt", "otsXchRt");
		this.hashFields.put("rct_aply_xch_rt", "rctAplyXchRt");
		this.hashFields.put("rct_curr_cd", "rctCurrCd");
		this.hashFields.put("rct_aply_amt", "rctAplyAmt");
		this.hashFields.put("dp_prcs_knt", "dpPrcsKnt");
		this.hashFields.put("hdr_dup_flg", "hdrDupFlg");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  chgTpCd
	*/
	public void	setChgTpCd( String	chgTpCd ) {
		this.chgTpCd =	chgTpCd;
	}
 
	/**
	 * Column Info
	 * @return	chgTpCd
	 */
	 public	 String	getChgTpCd() {
		 return	this.chgTpCd;
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
	* @param  bilToCustCntCd
	*/
	public void	setBilToCustCntCd( String	bilToCustCntCd ) {
		this.bilToCustCntCd =	bilToCustCntCd;
	}
 
	/**
	 * Column Info
	 * @return	bilToCustCntCd
	 */
	 public	 String	getBilToCustCntCd() {
		 return	this.bilToCustCntCd;
	 } 
 	/**
	* Column Info
	* @param  otsSmryCd
	*/
	public void	setOtsSmryCd( String	otsSmryCd ) {
		this.otsSmryCd =	otsSmryCd;
	}
 
	/**
	 * Column Info
	 * @return	otsSmryCd
	 */
	 public	 String	getOtsSmryCd() {
		 return	this.otsSmryCd;
	 } 
 	/**
	* Column Info
	* @param  shpToCustCd
	*/
	public void	setShpToCustCd( String	shpToCustCd ) {
		this.shpToCustCd =	shpToCustCd;
	}
 
	/**
	 * Column Info
	 * @return	shpToCustCd
	 */
	 public	 String	getShpToCustCd() {
		 return	this.shpToCustCd;
	 } 
 	/**
	* Column Info
	* @param  blNo
	*/
	public void	setBlNo( String	blNo ) {
		this.blNo =	blNo;
	}
 
	/**
	 * Column Info
	 * @return	blNo
	 */
	 public	 String	getBlNo() {
		 return	this.blNo;
	 } 
 	/**
	* Column Info
	* @param  otsBalAmt
	*/
	public void	setOtsBalAmt( String	otsBalAmt ) {
		this.otsBalAmt =	otsBalAmt;
	}
 
	/**
	 * Column Info
	 * @return	otsBalAmt
	 */
	 public	 String	getOtsBalAmt() {
		 return	this.otsBalAmt;
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
	* @param  loclBalAmt
	*/
	public void	setLoclBalAmt( String	loclBalAmt ) {
		this.loclBalAmt =	loclBalAmt;
	}
 
	/**
	 * Column Info
	 * @return	loclBalAmt
	 */
	 public	 String	getLoclBalAmt() {
		 return	this.loclBalAmt;
	 } 
 	/**
	* Column Info
	* @param  otsSrcCd
	*/
	public void	setOtsSrcCd( String	otsSrcCd ) {
		this.otsSrcCd =	otsSrcCd;
	}
 
	/**
	 * Column Info
	 * @return	otsSrcCd
	 */
	 public	 String	getOtsSrcCd() {
		 return	this.otsSrcCd;
	 } 
 	/**
	* Column Info
	* @param  dueDt
	*/
	public void	setDueDt( String	dueDt ) {
		this.dueDt =	dueDt;
	}
 
	/**
	 * Column Info
	 * @return	dueDt
	 */
	 public	 String	getDueDt() {
		 return	this.dueDt;
	 } 
 	/**
	* Column Info
	* @param  shpToCustSeq
	*/
	public void	setShpToCustSeq( String	shpToCustSeq ) {
		this.shpToCustSeq =	shpToCustSeq;
	}
 
	/**
	 * Column Info
	 * @return	shpToCustSeq
	 */
	 public	 String	getShpToCustSeq() {
		 return	this.shpToCustSeq;
	 } 
 	/**
	* Column Info
	* @param  rhqCd
	*/
	public void	setRhqCd( String	rhqCd ) {
		this.rhqCd =	rhqCd;
	}
 
	/**
	 * Column Info
	 * @return	rhqCd
	 */
	 public	 String	getRhqCd() {
		 return	this.rhqCd;
	 } 
 	/**
	* Column Info
	* @param  blCurrCd
	*/
	public void	setBlCurrCd( String	blCurrCd ) {
		this.blCurrCd =	blCurrCd;
	}
 
	/**
	 * Column Info
	 * @return	blCurrCd
	 */
	 public	 String	getBlCurrCd() {
		 return	this.blCurrCd;
	 } 
 	/**
	* Column Info
	* @param  loclVvdCd
	*/
	public void	setLoclVvdCd( String	loclVvdCd ) {
		this.loclVvdCd =	loclVvdCd;
	}
 
	/**
	 * Column Info
	 * @return	loclVvdCd
	 */
	 public	 String	getLoclVvdCd() {
		 return	this.loclVvdCd;
	 } 
 	/**
	* Column Info
	* @param  bilToCustSeq
	*/
	public void	setBilToCustSeq( String	bilToCustSeq ) {
		this.bilToCustSeq =	bilToCustSeq;
	}
 
	/**
	 * Column Info
	 * @return	bilToCustSeq
	 */
	 public	 String	getBilToCustSeq() {
		 return	this.bilToCustSeq;
	 } 
 	/**
	* Column Info
	* @param  bilToCustCd
	*/
	public void	setBilToCustCd( String	bilToCustCd ) {
		this.bilToCustCd =	bilToCustCd;
	}
 
	/**
	 * Column Info
	 * @return	bilToCustCd
	 */
	 public	 String	getBilToCustCd() {
		 return	this.bilToCustCd;
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
	* @param  otsRmk
	*/
	public void	setOtsRmk( String	otsRmk ) {
		this.otsRmk =	otsRmk;
	}
 
	/**
	 * Column Info
	 * @return	otsRmk
	 */
	 public	 String	getOtsRmk() {
		 return	this.otsRmk;
	 } 
 	/**
	* Column Info
	* @param  usdBalAmt
	*/
	public void	setUsdBalAmt( String	usdBalAmt ) {
		this.usdBalAmt =	usdBalAmt;
	}
 
	/**
	 * Column Info
	 * @return	usdBalAmt
	 */
	 public	 String	getUsdBalAmt() {
		 return	this.usdBalAmt;
	 } 
 	/**
	* Column Info
	* @param  otsCd
	*/
	public void	setOtsCd( String	otsCd ) {
		this.otsCd =	otsCd;
	}
 
	/**
	 * Column Info
	 * @return	otsCd
	 */
	 public	 String	getOtsCd() {
		 return	this.otsCd;
	 } 
 	/**
	* Column Info
	* @param  shpToCustCntCd
	*/
	public void	setShpToCustCntCd( String	shpToCustCntCd ) {
		this.shpToCustCntCd =	shpToCustCntCd;
	}
 
	/**
	 * Column Info
	 * @return	shpToCustCntCd
	 */
	 public	 String	getShpToCustCntCd() {
		 return	this.shpToCustCntCd;
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
	* @param  overDue
	*/
	public void	setOverDue( String	overDue ) {
		this.overDue =	overDue;
	}
 
	/**
	 * Column Info
	 * @return	overDue
	 */
	 public	 String	getOverDue() {
		 return	this.overDue;
	 } 
 	/**
	* Column Info
	* @param  repOtsOfcCd
	*/
	public void	setRepOtsOfcCd( String	repOtsOfcCd ) {
		this.repOtsOfcCd =	repOtsOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	repOtsOfcCd
	 */
	 public	 String	getRepOtsOfcCd() {
		 return	this.repOtsOfcCd;
	 } 
 	/**
	* Column Info
	* @param  otsRctTmpSeq
	*/
	public void	setOtsRctTmpSeq( String	otsRctTmpSeq ) {
		this.otsRctTmpSeq =	otsRctTmpSeq;
	}
 
	/**
	 * Column Info
	 * @return	otsRctTmpSeq
	 */
	 public	 String	getOtsRctTmpSeq() {
		 return	this.otsRctTmpSeq;
	 } 
 	/**
	* Column Info
	* @param  rctAplyHdrSeq
	*/
	public void	setRctAplyHdrSeq( String	rctAplyHdrSeq ) {
		this.rctAplyHdrSeq =	rctAplyHdrSeq;
	}
 
	/**
	 * Column Info
	 * @return	rctAplyHdrSeq
	 */
	 public	 String	getRctAplyHdrSeq() {
		 return	this.rctAplyHdrSeq;
	 } 
 	/**
	* Column Info
	* @param  rctAplyFlg
	*/
	public void	setRctAplyFlg( String	rctAplyFlg ) {
		this.rctAplyFlg =	rctAplyFlg;
	}
 
	/**
	 * Column Info
	 * @return	rctAplyFlg
	 */
	 public	 String	getRctAplyFlg() {
		 return	this.rctAplyFlg;
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
	 public	 String	getOfcCd() {
		 return	this.ofcCd;
	 } 
 	/**
	* Column Info
	* @param  trnkVvdCd
	*/
	public void	setTrnkVvdCd( String	trnkVvdCd ) {
		this.trnkVvdCd =	trnkVvdCd;
	}
 
	/**
	 * Column Info
	 * @return	trnkVvdCd
	 */
	 public	 String	getTrnkVvdCd() {
		 return	this.trnkVvdCd;
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
	* @param  srepCd
	*/
	public void	setSrepCd( String	srepCd ) {
		this.srepCd =	srepCd;
	}
 
	/**
	 * Column Info
	 * @return	srepCd
	 */
	 public	 String	getSrepCd() {
		 return	this.srepCd;
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
	 public	 String	getXchRtTpCd() {
		 return	this.xchRtTpCd;
	 } 
 	/**
	* Column Info
	* @param  xchRtDt
	*/
	public void	setXchRtDt( String	xchRtDt ) {
		this.xchRtDt =	xchRtDt;
	}
 
	/**
	 * Column Info
	 * @return	xchRtDt
	 */
	 public	 String	getXchRtDt() {
		 return	this.xchRtDt;
	 } 
 	/**
	* Column Info
	* @param  crFlg
	*/
	public void	setCrFlg( String	crFlg ) {
		this.crFlg =	crFlg;
	}
 
	/**
	 * Column Info
	 * @return	crFlg
	 */
	 public	 String	getCrFlg() {
		 return	this.crFlg;
	 } 
 	/**
	* Column Info
	* @param  arFincSrcCd
	*/
	public void	setArFincSrcCd( String	arFincSrcCd ) {
		this.arFincSrcCd =	arFincSrcCd;
	}
 
	/**
	 * Column Info
	 * @return	arFincSrcCd
	 */
	 public	 String	getArFincSrcCd() {
		 return	this.arFincSrcCd;
	 } 
 	/**
	* Column Info
	* @param  maxArIfNo
	*/
	public void	setMaxArIfNo( String	maxArIfNo ) {
		this.maxArIfNo =	maxArIfNo;
	}
 
	/**
	 * Column Info
	 * @return	maxArIfNo
	 */
	 public	 String	getMaxArIfNo() {
		 return	this.maxArIfNo;
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
	* @param  rctAplyChgCd
	*/
	public void	setRctAplyChgCd( String	rctAplyChgCd ) {
		this.rctAplyChgCd =	rctAplyChgCd;
	}
 
	/**
	 * Column Info
	 * @return	rctAplyChgCd
	 */
	 public	 String	getRctAplyChgCd() {
		 return	this.rctAplyChgCd;
	 } 
 	/**
	* Column Info
	* @param  rctAplySrcCurrCd
	*/
	public void	setRctAplySrcCurrCd( String	rctAplySrcCurrCd ) {
		this.rctAplySrcCurrCd =	rctAplySrcCurrCd;
	}
 
	/**
	 * Column Info
	 * @return	rctAplySrcCurrCd
	 */
	 public	 String	getRctAplySrcCurrCd() {
		 return	this.rctAplySrcCurrCd;
	 } 
 	/**
	* Column Info
	* @param  otsAplyAmt
	*/
	public void	setOtsAplyAmt( String	otsAplyAmt ) {
		this.otsAplyAmt =	otsAplyAmt;
	}
 
	/**
	 * Column Info
	 * @return	otsAplyAmt
	 */
	 public	 String	getOtsAplyAmt() {
		 return	this.otsAplyAmt;
	 } 
 	/**
	* Column Info
	* @param  otsXchRt
	*/
	public void	setOtsXchRt( String	otsXchRt ) {
		this.otsXchRt =	otsXchRt;
	}
 
	/**
	 * Column Info
	 * @return	otsXchRt
	 */
	 public	 String	getOtsXchRt() {
		 return	this.otsXchRt;
	 } 
 	/**
	* Column Info
	* @param  rctAplyXchRt
	*/
	public void	setRctAplyXchRt( String	rctAplyXchRt ) {
		this.rctAplyXchRt =	rctAplyXchRt;
	}
 
	/**
	 * Column Info
	 * @return	rctAplyXchRt
	 */
	 public	 String	getRctAplyXchRt() {
		 return	this.rctAplyXchRt;
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
	* @param  rctAplyAmt
	*/
	public void	setRctAplyAmt( String	rctAplyAmt ) {
		this.rctAplyAmt =	rctAplyAmt;
	}
 
	/**
	 * Column Info
	 * @return	rctAplyAmt
	 */
	 public	 String	getRctAplyAmt() {
		 return	this.rctAplyAmt;
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
	* @param  hdrDupFlg
	*/
	public void	setHdrDupFlg( String	hdrDupFlg ) {
		this.hdrDupFlg =	hdrDupFlg;
	}
 
	/**
	 * Column Info
	 * @return	hdrDupFlg
	 */
	 public	 String	getHdrDupFlg() {
		 return	this.hdrDupFlg;
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
		setChgTpCd(JSPUtil.getParameter(request,	prefix + "chg_tp_cd", ""));
		setCustNm(JSPUtil.getParameter(request,	prefix + "cust_nm", ""));
		setBilToCustCntCd(JSPUtil.getParameter(request,	prefix + "bil_to_cust_cnt_cd", ""));
		setOtsSmryCd(JSPUtil.getParameter(request,	prefix + "ots_smry_cd", ""));
		setShpToCustCd(JSPUtil.getParameter(request,	prefix + "shp_to_cust_cd", ""));
		setBlNo(JSPUtil.getParameter(request,	prefix + "bl_no", ""));
		setOtsBalAmt(JSPUtil.getParameter(request,	prefix + "ots_bal_amt", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setLoclBalAmt(JSPUtil.getParameter(request,	prefix + "locl_bal_amt", ""));
		setOtsSrcCd(JSPUtil.getParameter(request,	prefix + "ots_src_cd", ""));
		setDueDt(JSPUtil.getParameter(request,	prefix + "due_dt", ""));
		setShpToCustSeq(JSPUtil.getParameter(request,	prefix + "shp_to_cust_seq", ""));
		setRhqCd(JSPUtil.getParameter(request,	prefix + "rhq_cd", ""));
		setBlCurrCd(JSPUtil.getParameter(request,	prefix + "bl_curr_cd", ""));
		setLoclVvdCd(JSPUtil.getParameter(request,	prefix + "locl_vvd_cd", ""));
		setBilToCustSeq(JSPUtil.getParameter(request,	prefix + "bil_to_cust_seq", ""));
		setBilToCustCd(JSPUtil.getParameter(request,	prefix + "bil_to_cust_cd", ""));
		setInvNo(JSPUtil.getParameter(request,	prefix + "inv_no", ""));
		setBkgNo(JSPUtil.getParameter(request,	prefix + "bkg_no", ""));
		setOtsRmk(JSPUtil.getParameter(request,	prefix + "ots_rmk", ""));
		setUsdBalAmt(JSPUtil.getParameter(request,	prefix + "usd_bal_amt", ""));
		setOtsCd(JSPUtil.getParameter(request,	prefix + "ots_cd", ""));
		setShpToCustCntCd(JSPUtil.getParameter(request,	prefix + "shp_to_cust_cnt_cd", ""));
		setOtsOfcCd(JSPUtil.getParameter(request,	prefix + "ots_ofc_cd", ""));
		setOverDue(JSPUtil.getParameter(request,	prefix + "over_due", ""));
		setRepOtsOfcCd(JSPUtil.getParameter(request,	prefix + "rep_ots_ofc_cd", ""));
		setOtsRctTmpSeq(JSPUtil.getParameter(request,	prefix + "ots_rct_tmp_seq", ""));
		setRctAplyHdrSeq(JSPUtil.getParameter(request,	prefix + "rct_aply_hdr_seq", ""));
		setRctAplyFlg(JSPUtil.getParameter(request,	prefix + "rct_aply_flg", ""));
		setOfcCd(JSPUtil.getParameter(request,	prefix + "ofc_cd", ""));
		setTrnkVvdCd(JSPUtil.getParameter(request,	prefix + "trnk_vvd_cd", ""));
		setSailArrDt(JSPUtil.getParameter(request,	prefix + "sail_arr_dt", ""));
		setIoBndCd(JSPUtil.getParameter(request,	prefix + "io_bnd_cd", ""));
		setSrepCd(JSPUtil.getParameter(request,	prefix + "srep_cd", ""));
		setXchRtTpCd(JSPUtil.getParameter(request,	prefix + "xch_rt_tp_cd", ""));
		setXchRtDt(JSPUtil.getParameter(request,	prefix + "xch_rt_dt", ""));
		setCrFlg(JSPUtil.getParameter(request,	prefix + "cr_flg", ""));
		setArFincSrcCd(JSPUtil.getParameter(request,	prefix + "ar_finc_src_cd", ""));
		setMaxArIfNo(JSPUtil.getParameter(request,	prefix + "max_ar_if_no", ""));
		setInvDt(JSPUtil.getParameter(request,	prefix + "inv_dt", ""));
		setRctAplyChgCd(JSPUtil.getParameter(request,	prefix + "rct_aply_chg_cd", ""));
		setRctAplySrcCurrCd(JSPUtil.getParameter(request,	prefix + "rct_aply_src_curr_cd", ""));
		setOtsAplyAmt(JSPUtil.getParameter(request,	prefix + "ots_aply_amt", ""));
		setOtsXchRt(JSPUtil.getParameter(request,	prefix + "ots_xch_rt", ""));
		setRctAplyXchRt(JSPUtil.getParameter(request,	prefix + "rct_aply_xch_rt", ""));
		setRctCurrCd(JSPUtil.getParameter(request,	prefix + "rct_curr_cd", ""));
		setRctAplyAmt(JSPUtil.getParameter(request,	prefix + "rct_aply_amt", ""));
		setDpPrcsKnt(JSPUtil.getParameter(request,	prefix + "dp_prcs_knt", ""));
		setHdrDupFlg(JSPUtil.getParameter(request,	prefix + "hdr_dup_flg", ""));
	}
	
	/**
	 * Request ���곗씠�곕� VO 諛곗뿴濡�蹂�솚�섏뿬 諛섑솚.
	 * @param request
	 * @return ApplyOutstandingListVO[]
	 */
	public ApplyOutstandingListVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request �섏뼱���щ윭 嫄�DATA瑜�VO Class ���대뒗��
	 * @param request
	 * @param prefix
	 * @return ApplyOutstandingListVO[]
	 */
	public ApplyOutstandingListVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		ApplyOutstandingListVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] chgTpCd =	(JSPUtil.getParameter(request, prefix +	"chg_tp_cd".trim(),	length));
				String[] custNm =	(JSPUtil.getParameter(request, prefix +	"cust_nm".trim(),	length));
				String[] bilToCustCntCd =	(JSPUtil.getParameter(request, prefix +	"bil_to_cust_cnt_cd".trim(),	length));
				String[] otsSmryCd =	(JSPUtil.getParameter(request, prefix +	"ots_smry_cd".trim(),	length));
				String[] shpToCustCd =	(JSPUtil.getParameter(request, prefix +	"shp_to_cust_cd".trim(),	length));
				String[] blNo =	(JSPUtil.getParameter(request, prefix +	"bl_no".trim(),	length));
				String[] otsBalAmt =	(JSPUtil.getParameter(request, prefix +	"ots_bal_amt".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] loclBalAmt =	(JSPUtil.getParameter(request, prefix +	"locl_bal_amt".trim(),	length));
				String[] otsSrcCd =	(JSPUtil.getParameter(request, prefix +	"ots_src_cd".trim(),	length));
				String[] dueDt =	(JSPUtil.getParameter(request, prefix +	"due_dt".trim(),	length));
				String[] shpToCustSeq =	(JSPUtil.getParameter(request, prefix +	"shp_to_cust_seq".trim(),	length));
				String[] rhqCd =	(JSPUtil.getParameter(request, prefix +	"rhq_cd".trim(),	length));
				String[] blCurrCd =	(JSPUtil.getParameter(request, prefix +	"bl_curr_cd".trim(),	length));
				String[] loclVvdCd =	(JSPUtil.getParameter(request, prefix +	"locl_vvd_cd".trim(),	length));
				String[] bilToCustSeq =	(JSPUtil.getParameter(request, prefix +	"bil_to_cust_seq".trim(),	length));
				String[] bilToCustCd =	(JSPUtil.getParameter(request, prefix +	"bil_to_cust_cd".trim(),	length));
				String[] invNo =	(JSPUtil.getParameter(request, prefix +	"inv_no".trim(),	length));
				String[] bkgNo =	(JSPUtil.getParameter(request, prefix +	"bkg_no".trim(),	length));
				String[] otsRmk =	(JSPUtil.getParameter(request, prefix +	"ots_rmk".trim(),	length));
				String[] usdBalAmt =	(JSPUtil.getParameter(request, prefix +	"usd_bal_amt".trim(),	length));
				String[] otsCd =	(JSPUtil.getParameter(request, prefix +	"ots_cd".trim(),	length));
				String[] shpToCustCntCd =	(JSPUtil.getParameter(request, prefix +	"shp_to_cust_cnt_cd".trim(),	length));
				String[] otsOfcCd =	(JSPUtil.getParameter(request, prefix +	"ots_ofc_cd".trim(),	length));
				String[] overDue =	(JSPUtil.getParameter(request, prefix +	"over_due".trim(),	length));
				String[] repOtsOfcCd =	(JSPUtil.getParameter(request, prefix +	"rep_ots_ofc_cd".trim(),	length));
				String[] otsRctTmpSeq =	(JSPUtil.getParameter(request, prefix +	"ots_rct_tmp_seq".trim(),	length));
				String[] rctAplyHdrSeq =	(JSPUtil.getParameter(request, prefix +	"rct_aply_hdr_seq".trim(),	length));
				String[] rctAplyFlg =	(JSPUtil.getParameter(request, prefix +	"rct_aply_flg".trim(),	length));
				String[] ofcCd =	(JSPUtil.getParameter(request, prefix +	"ofc_cd".trim(),	length));
				String[] trnkVvdCd =	(JSPUtil.getParameter(request, prefix +	"trnk_vvd_cd".trim(),	length));
				String[] sailArrDt =	(JSPUtil.getParameter(request, prefix +	"sail_arr_dt".trim(),	length));
				String[] ioBndCd =	(JSPUtil.getParameter(request, prefix +	"io_bnd_cd".trim(),	length));
				String[] srepCd =	(JSPUtil.getParameter(request, prefix +	"srep_cd".trim(),	length));
				String[] xchRtTpCd =	(JSPUtil.getParameter(request, prefix +	"xch_rt_tp_cd".trim(),	length));
				String[] xchRtDt =	(JSPUtil.getParameter(request, prefix +	"xch_rt_dt".trim(),	length));
				String[] crFlg =	(JSPUtil.getParameter(request, prefix +	"cr_flg".trim(),	length));
				String[] arFincSrcCd =	(JSPUtil.getParameter(request, prefix +	"ar_finc_src_cd".trim(),	length));
				String[] maxArIfNo =	(JSPUtil.getParameter(request, prefix +	"max_ar_if_no".trim(),	length));
				String[] invDt =	(JSPUtil.getParameter(request, prefix +	"inv_dt".trim(),	length));
				String[] rctAplyChgCd =	(JSPUtil.getParameter(request, prefix +	"rct_aply_chg_cd".trim(),	length));
				String[] rctAplySrcCurrCd =	(JSPUtil.getParameter(request, prefix +	"rct_aply_src_curr_cd".trim(),	length));
				String[] otsAplyAmt =	(JSPUtil.getParameter(request, prefix +	"ots_aply_amt".trim(),	length));
				String[] otsXchRt =	(JSPUtil.getParameter(request, prefix +	"ots_xch_rt".trim(),	length));
				String[] rctAplyXchRt =	(JSPUtil.getParameter(request, prefix +	"rct_aply_xch_rt".trim(),	length));
				String[] rctCurrCd =	(JSPUtil.getParameter(request, prefix +	"rct_curr_cd".trim(),	length));
				String[] rctAplyAmt =	(JSPUtil.getParameter(request, prefix +	"rct_aply_amt".trim(),	length));
				String[] dpPrcsKnt =	(JSPUtil.getParameter(request, prefix +	"dp_prcs_knt".trim(),	length));
				String[] hdrDupFlg =	(JSPUtil.getParameter(request, prefix +	"hdr_dup_flg".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	ApplyOutstandingListVO();
						if ( chgTpCd[i] !=	null)
						model.setChgTpCd( chgTpCd[i]);
						if ( custNm[i] !=	null)
						model.setCustNm( custNm[i]);
						if ( bilToCustCntCd[i] !=	null)
						model.setBilToCustCntCd( bilToCustCntCd[i]);
						if ( otsSmryCd[i] !=	null)
						model.setOtsSmryCd( otsSmryCd[i]);
						if ( shpToCustCd[i] !=	null)
						model.setShpToCustCd( shpToCustCd[i]);
						if ( blNo[i] !=	null)
						model.setBlNo( blNo[i]);
						if ( otsBalAmt[i] !=	null)
						model.setOtsBalAmt( otsBalAmt[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( loclBalAmt[i] !=	null)
						model.setLoclBalAmt( loclBalAmt[i]);
						if ( otsSrcCd[i] !=	null)
						model.setOtsSrcCd( otsSrcCd[i]);
						if ( dueDt[i] !=	null)
						model.setDueDt( dueDt[i]);
						if ( shpToCustSeq[i] !=	null)
						model.setShpToCustSeq( shpToCustSeq[i]);
						if ( rhqCd[i] !=	null)
						model.setRhqCd( rhqCd[i]);
						if ( blCurrCd[i] !=	null)
						model.setBlCurrCd( blCurrCd[i]);
						if ( loclVvdCd[i] !=	null)
						model.setLoclVvdCd( loclVvdCd[i]);
						if ( bilToCustSeq[i] !=	null)
						model.setBilToCustSeq( bilToCustSeq[i]);
						if ( bilToCustCd[i] !=	null)
						model.setBilToCustCd( bilToCustCd[i]);
						if ( invNo[i] !=	null)
						model.setInvNo( invNo[i]);
						if ( bkgNo[i] !=	null)
						model.setBkgNo( bkgNo[i]);
						if ( otsRmk[i] !=	null)
						model.setOtsRmk( otsRmk[i]);
						if ( usdBalAmt[i] !=	null)
						model.setUsdBalAmt( usdBalAmt[i]);
						if ( otsCd[i] !=	null)
						model.setOtsCd( otsCd[i]);
						if ( shpToCustCntCd[i] !=	null)
						model.setShpToCustCntCd( shpToCustCntCd[i]);
						if ( otsOfcCd[i] !=	null)
						model.setOtsOfcCd( otsOfcCd[i]);
						if ( overDue[i] !=	null)
						model.setOverDue( overDue[i]);
						if ( repOtsOfcCd[i] !=	null)
						model.setRepOtsOfcCd( repOtsOfcCd[i]);
						if ( otsRctTmpSeq[i] !=	null)
						model.setOtsRctTmpSeq( otsRctTmpSeq[i]);
						if ( rctAplyHdrSeq[i] !=	null)
						model.setRctAplyHdrSeq( rctAplyHdrSeq[i]);
						if ( rctAplyFlg[i] !=	null)
						model.setRctAplyFlg( rctAplyFlg[i]);
						if ( ofcCd[i] !=	null)
						model.setOfcCd( ofcCd[i]);
						if ( trnkVvdCd[i] !=	null)
						model.setTrnkVvdCd( trnkVvdCd[i]);
						if ( sailArrDt[i] !=	null)
						model.setSailArrDt( sailArrDt[i]);
						if ( ioBndCd[i] !=	null)
						model.setIoBndCd( ioBndCd[i]);
						if ( srepCd[i] !=	null)
						model.setSrepCd( srepCd[i]);
						if ( xchRtTpCd[i] !=	null)
						model.setXchRtTpCd( xchRtTpCd[i]);
						if ( xchRtDt[i] !=	null)
						model.setXchRtDt( xchRtDt[i]);
						if ( crFlg[i] !=	null)
						model.setCrFlg( crFlg[i]);
						if ( arFincSrcCd[i] !=	null)
						model.setArFincSrcCd( arFincSrcCd[i]);
						if ( maxArIfNo[i] !=	null)
						model.setMaxArIfNo( maxArIfNo[i]);
						if ( invDt[i] !=	null)
						model.setInvDt( invDt[i]);
						if ( rctAplyChgCd[i] !=	null)
						model.setRctAplyChgCd( rctAplyChgCd[i]);
						if ( rctAplySrcCurrCd[i] !=	null)
						model.setRctAplySrcCurrCd( rctAplySrcCurrCd[i]);
						if ( otsAplyAmt[i] !=	null)
						model.setOtsAplyAmt( otsAplyAmt[i]);
						if ( otsXchRt[i] !=	null)
						model.setOtsXchRt( otsXchRt[i]);
						if ( rctAplyXchRt[i] !=	null)
						model.setRctAplyXchRt( rctAplyXchRt[i]);
						if ( rctCurrCd[i] !=	null)
						model.setRctCurrCd( rctCurrCd[i]);
						if ( rctAplyAmt[i] !=	null)
						model.setRctAplyAmt( rctAplyAmt[i]);
						if ( dpPrcsKnt[i] !=	null)
						model.setDpPrcsKnt( dpPrcsKnt[i]);
						if ( hdrDupFlg[i] !=	null)
						model.setHdrDupFlg( hdrDupFlg[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getApplyOutstandingListVOs();
	}

	/**
	 *  VO 諛곗뿴��諛섑솚
	 * @return ApplyOutstandingListVO[]
	 */
	public ApplyOutstandingListVO[]	 getApplyOutstandingListVOs(){
		ApplyOutstandingListVO[] vos = (ApplyOutstandingListVO[])models.toArray(new	ApplyOutstandingListVO[models.size()]);
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
		this.chgTpCd =	this.chgTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm =	this.custNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilToCustCntCd =	this.bilToCustCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsSmryCd =	this.otsSmryCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpToCustCd =	this.shpToCustCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo =	this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsBalAmt =	this.otsBalAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclBalAmt =	this.loclBalAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsSrcCd =	this.otsSrcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dueDt =	this.dueDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpToCustSeq =	this.shpToCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd =	this.rhqCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blCurrCd =	this.blCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclVvdCd =	this.loclVvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilToCustSeq =	this.bilToCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilToCustCd =	this.bilToCustCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo =	this.invNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo =	this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsRmk =	this.otsRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdBalAmt =	this.usdBalAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsCd =	this.otsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpToCustCntCd =	this.shpToCustCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsOfcCd =	this.otsOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overDue =	this.overDue.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repOtsOfcCd =	this.repOtsOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsRctTmpSeq =	this.otsRctTmpSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctAplyHdrSeq =	this.rctAplyHdrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctAplyFlg =	this.rctAplyFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd =	this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkVvdCd =	this.trnkVvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailArrDt =	this.sailArrDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd =	this.ioBndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepCd =	this.srepCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRtTpCd =	this.xchRtTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRtDt =	this.xchRtDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crFlg =	this.crFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arFincSrcCd =	this.arFincSrcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxArIfNo =	this.maxArIfNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDt =	this.invDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctAplyChgCd =	this.rctAplyChgCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctAplySrcCurrCd =	this.rctAplySrcCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsAplyAmt =	this.otsAplyAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsXchRt =	this.otsXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctAplyXchRt =	this.rctAplyXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctCurrCd =	this.rctCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctAplyAmt =	this.rctAplyAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpPrcsKnt =	this.dpPrcsKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrDupFlg =	this.hdrDupFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}