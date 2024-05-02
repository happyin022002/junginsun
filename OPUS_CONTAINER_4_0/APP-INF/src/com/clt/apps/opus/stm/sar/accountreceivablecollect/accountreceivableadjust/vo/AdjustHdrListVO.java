/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : AdjustHdrListVO.java
 *@FileTitle : AdjustHdrListVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.01.14
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2015.01.14  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo;

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
public class AdjustHdrListVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<AdjustHdrListVO>  models =	new	ArrayList<AdjustHdrListVO>();


	/*	Column Info	*/
	private  String	 xchRtDt   =  null;
	/*	Column Info	*/
	private  String	 otsAdjSeq   =  null;
	/*	Column Info	*/
	private  String	 xchRtTpCd   =  null;
	/*	Column Info	*/
	private  String	 adjKeyNo   =  null;
	/*	Column Info	*/
	private  String	 bilToCustCntCd   =  null;
	/*	Column Info	*/
	private  String	 arFincSrcCd   =  null;
	/*	Column Info	*/
	private  String	 shpBilToCustCd   =  null;
	/*	Column Info	*/
	private  String	 srepCd   =  null;
	/*	Column Info	*/
	private  String	 blNo   =  null;
	/*	Column Info	*/
	private  String	 sailArrDt   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 vndrNo   =  null;
	/*	Column Info	*/
	private  String	 gainAndLssAmt   =  null;
	/*	Column Info	*/
	private  String	 adjNo   =  null;
	/*	Column Info	*/
	private  String	 adjTpCd   =  null;
	/*	Column Info	*/
	private  String	 dueDt   =  null;
	/*	Column Info	*/
	private  String	 apCrsCurrAmt   =  null;
	/*	Column Info	*/
	private  String	 rvsFlg   =  null;
	/*	Column Info	*/
	private  String	 apCurrCd   =  null;
	/*	Column Info	*/
	private  String	 invOfcCd   =  null;
	/*	Column Info	*/
	private  String	 adjRmk   =  null;
	/*	Column Info	*/
	private  String	 apOfcCd   =  null;
	/*	Column Info	*/
	private  String	 rhqCd   =  null;
	/*	Column Info	*/
	private  String	 loclVvdCd   =  null;
	/*	Column Info	*/
	private  String	 trnkVvdCd   =  null;
	/*	Column Info	*/
	private  String	 bilToCustSeq   =  null;
	/*	Column Info	*/
	private  String	 crFlg   =  null;
	/*	Column Info	*/
	private  String	 ioBndCd   =  null;
	/*	Column Info	*/
	private  String	 bilToCustCd   =  null;
	/*	Column Info	*/
	private  String	 invNo   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;
	/*	Column Info	*/
	private  String	 otsRmk   =  null;
	/*	Column Info	*/
	private  String	 bkgNo   =  null;
	/*	Column Info	*/
	private  String	 chgAdjTpCd   =  null;
	/*	Column Info	*/
	private  String	 maxArIfNo   =  null;
	/*	Column Info	*/
	private  String	 otsHdrKey   =  null;
	/*	Column Info	*/
	private  String	 asaNo   =  null;
	/*	Column Info	*/
	private  String	 apGlDt   =  null;
	/*	Column Info	*/
	private  String	 payAcctCd   =  null;
	/*	Column Info	*/
	private  String	 apRmk   =  null;
	/*	Column Info	*/
	private  String	 adjDt   =  null;
	/*	Column Info	*/
	private  String	 adjOfcCd   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public AdjustHdrListVO(){}

	public AdjustHdrListVO(String xchRtDt,String otsAdjSeq,String xchRtTpCd,String adjKeyNo,String bilToCustCntCd,String arFincSrcCd,String shpBilToCustCd,String srepCd,String blNo,String sailArrDt,String pagerows,String ibflag,String vndrNo,String gainAndLssAmt,String adjNo,String adjTpCd,String dueDt,String apCrsCurrAmt,String rvsFlg,String apCurrCd,String invOfcCd,String adjRmk,String apOfcCd,String rhqCd,String loclVvdCd,String trnkVvdCd,String bilToCustSeq,String crFlg,String ioBndCd,String bilToCustCd,String invNo,String creUsrId,String otsRmk,String bkgNo,String chgAdjTpCd,String maxArIfNo,String otsHdrKey,String asaNo,String apGlDt,String payAcctCd,String apRmk,String adjDt,String adjOfcCd)	{
		this.xchRtDt  = xchRtDt ;
		this.otsAdjSeq  = otsAdjSeq ;
		this.xchRtTpCd  = xchRtTpCd ;
		this.adjKeyNo  = adjKeyNo ;
		this.bilToCustCntCd  = bilToCustCntCd ;
		this.arFincSrcCd  = arFincSrcCd ;
		this.shpBilToCustCd  = shpBilToCustCd ;
		this.srepCd  = srepCd ;
		this.blNo  = blNo ;
		this.sailArrDt  = sailArrDt ;
		this.pagerows  = pagerows ;
		this.ibflag  = ibflag ;
		this.vndrNo  = vndrNo ;
		this.gainAndLssAmt  = gainAndLssAmt ;
		this.adjNo  = adjNo ;
		this.adjTpCd  = adjTpCd ;
		this.dueDt  = dueDt ;
		this.apCrsCurrAmt  = apCrsCurrAmt ;
		this.rvsFlg  = rvsFlg ;
		this.apCurrCd  = apCurrCd ;
		this.invOfcCd  = invOfcCd ;
		this.adjRmk  = adjRmk ;
		this.apOfcCd  = apOfcCd ;
		this.rhqCd  = rhqCd ;
		this.loclVvdCd  = loclVvdCd ;
		this.trnkVvdCd  = trnkVvdCd ;
		this.bilToCustSeq  = bilToCustSeq ;
		this.crFlg  = crFlg ;
		this.ioBndCd  = ioBndCd ;
		this.bilToCustCd  = bilToCustCd ;
		this.invNo  = invNo ;
		this.creUsrId  = creUsrId ;
		this.otsRmk  = otsRmk ;
		this.bkgNo  = bkgNo ;
		this.chgAdjTpCd  = chgAdjTpCd ;
		this.maxArIfNo  = maxArIfNo ;
		this.otsHdrKey  = otsHdrKey ;
		this.asaNo  = asaNo ;
		this.apGlDt  = apGlDt ;
		this.payAcctCd  = payAcctCd ;
		this.apRmk  = apRmk ;
		this.adjDt  = adjDt ;
		this.adjOfcCd  = adjOfcCd ;
	}


	/**
	 * �뚯씠釉�而щ읆����옣��媛믪쓣 Hashtable<"column_name", "value">	濡�諛섑솚
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("xch_rt_dt", getXchRtDt());		
		this.hashColumns.put("ots_adj_seq", getOtsAdjSeq());		
		this.hashColumns.put("xch_rt_tp_cd", getXchRtTpCd());		
		this.hashColumns.put("adj_key_no", getAdjKeyNo());		
		this.hashColumns.put("bil_to_cust_cnt_cd", getBilToCustCntCd());		
		this.hashColumns.put("ar_finc_src_cd", getArFincSrcCd());		
		this.hashColumns.put("shp_bil_to_cust_cd", getShpBilToCustCd());		
		this.hashColumns.put("srep_cd", getSrepCd());		
		this.hashColumns.put("bl_no", getBlNo());		
		this.hashColumns.put("sail_arr_dt", getSailArrDt());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("vndr_no", getVndrNo());		
		this.hashColumns.put("gain_and_lss_amt", getGainAndLssAmt());		
		this.hashColumns.put("adj_no", getAdjNo());		
		this.hashColumns.put("adj_tp_cd", getAdjTpCd());		
		this.hashColumns.put("due_dt", getDueDt());		
		this.hashColumns.put("ap_crs_curr_amt", getApCrsCurrAmt());		
		this.hashColumns.put("rvs_flg", getRvsFlg());		
		this.hashColumns.put("ap_curr_cd", getApCurrCd());		
		this.hashColumns.put("inv_ofc_cd", getInvOfcCd());		
		this.hashColumns.put("adj_rmk", getAdjRmk());		
		this.hashColumns.put("ap_ofc_cd", getApOfcCd());		
		this.hashColumns.put("rhq_cd", getRhqCd());		
		this.hashColumns.put("locl_vvd_cd", getLoclVvdCd());		
		this.hashColumns.put("trnk_vvd_cd", getTrnkVvdCd());		
		this.hashColumns.put("bil_to_cust_seq", getBilToCustSeq());		
		this.hashColumns.put("cr_flg", getCrFlg());		
		this.hashColumns.put("io_bnd_cd", getIoBndCd());		
		this.hashColumns.put("bil_to_cust_cd", getBilToCustCd());		
		this.hashColumns.put("inv_no", getInvNo());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("ots_rmk", getOtsRmk());		
		this.hashColumns.put("bkg_no", getBkgNo());		
		this.hashColumns.put("chg_adj_tp_cd", getChgAdjTpCd());		
		this.hashColumns.put("max_ar_if_no", getMaxArIfNo());		
		this.hashColumns.put("ots_hdr_key", getOtsHdrKey());		
		this.hashColumns.put("asa_no", getAsaNo());		
		this.hashColumns.put("ap_gl_dt", getApGlDt());		
		this.hashColumns.put("pay_acct_cd", getPayAcctCd());		
		this.hashColumns.put("ap_rmk", getApRmk());		
		this.hashColumns.put("adj_dt", getAdjDt());		
		this.hashColumns.put("adj_ofc_cd", getAdjOfcCd());		
		return this.hashColumns;
}

	/**
	 * 而щ읆紐낆뿉	��쓳�섎뒗 硫ㅻ쾭蹂�닔紐낆쓣	��옣�섏뿬 Hashtable<"column_name", "variable"> 濡�諛섑솚
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("xch_rt_dt", "xchRtDt");
		this.hashFields.put("ots_adj_seq", "otsAdjSeq");
		this.hashFields.put("xch_rt_tp_cd", "xchRtTpCd");
		this.hashFields.put("adj_key_no", "adjKeyNo");
		this.hashFields.put("bil_to_cust_cnt_cd", "bilToCustCntCd");
		this.hashFields.put("ar_finc_src_cd", "arFincSrcCd");
		this.hashFields.put("shp_bil_to_cust_cd", "shpBilToCustCd");
		this.hashFields.put("srep_cd", "srepCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("sail_arr_dt", "sailArrDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vndr_no", "vndrNo");
		this.hashFields.put("gain_and_lss_amt", "gainAndLssAmt");
		this.hashFields.put("adj_no", "adjNo");
		this.hashFields.put("adj_tp_cd", "adjTpCd");
		this.hashFields.put("due_dt", "dueDt");
		this.hashFields.put("ap_crs_curr_amt", "apCrsCurrAmt");
		this.hashFields.put("rvs_flg", "rvsFlg");
		this.hashFields.put("ap_curr_cd", "apCurrCd");
		this.hashFields.put("inv_ofc_cd", "invOfcCd");
		this.hashFields.put("adj_rmk", "adjRmk");
		this.hashFields.put("ap_ofc_cd", "apOfcCd");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("locl_vvd_cd", "loclVvdCd");
		this.hashFields.put("trnk_vvd_cd", "trnkVvdCd");
		this.hashFields.put("bil_to_cust_seq", "bilToCustSeq");
		this.hashFields.put("cr_flg", "crFlg");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("bil_to_cust_cd", "bilToCustCd");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ots_rmk", "otsRmk");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("chg_adj_tp_cd", "chgAdjTpCd");
		this.hashFields.put("max_ar_if_no", "maxArIfNo");
		this.hashFields.put("ots_hdr_key", "otsHdrKey");
		this.hashFields.put("asa_no", "asaNo");
		this.hashFields.put("ap_gl_dt", "apGlDt");
		this.hashFields.put("pay_acct_cd", "payAcctCd");
		this.hashFields.put("ap_rmk", "apRmk");
		this.hashFields.put("adj_dt", "adjDt");
		this.hashFields.put("adj_ofc_cd", "adjOfcCd");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
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
	* @param  otsAdjSeq
	*/
	public void	setOtsAdjSeq( String	otsAdjSeq ) {
		this.otsAdjSeq =	otsAdjSeq;
	}
 
	/**
	 * Column Info
	 * @return	otsAdjSeq
	 */
	 public	 String	getOtsAdjSeq() {
		 return	this.otsAdjSeq;
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
	* @param  adjKeyNo
	*/
	public void	setAdjKeyNo( String	adjKeyNo ) {
		this.adjKeyNo =	adjKeyNo;
	}
 
	/**
	 * Column Info
	 * @return	adjKeyNo
	 */
	 public	 String	getAdjKeyNo() {
		 return	this.adjKeyNo;
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
	* @param  shpBilToCustCd
	*/
	public void	setShpBilToCustCd( String	shpBilToCustCd ) {
		this.shpBilToCustCd =	shpBilToCustCd;
	}
 
	/**
	 * Column Info
	 * @return	shpBilToCustCd
	 */
	 public	 String	getShpBilToCustCd() {
		 return	this.shpBilToCustCd;
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
	* @param  vndrNo
	*/
	public void	setVndrNo( String	vndrNo ) {
		this.vndrNo =	vndrNo;
	}
 
	/**
	 * Column Info
	 * @return	vndrNo
	 */
	 public	 String	getVndrNo() {
		 return	this.vndrNo;
	 } 
 	/**
	* Column Info
	* @param  gainAndLssAmt
	*/
	public void	setGainAndLssAmt( String	gainAndLssAmt ) {
		this.gainAndLssAmt =	gainAndLssAmt;
	}
 
	/**
	 * Column Info
	 * @return	gainAndLssAmt
	 */
	 public	 String	getGainAndLssAmt() {
		 return	this.gainAndLssAmt;
	 } 
 	/**
	* Column Info
	* @param  adjNo
	*/
	public void	setAdjNo( String	adjNo ) {
		this.adjNo =	adjNo;
	}
 
	/**
	 * Column Info
	 * @return	adjNo
	 */
	 public	 String	getAdjNo() {
		 return	this.adjNo;
	 } 
 	/**
	* Column Info
	* @param  adjTpCd
	*/
	public void	setAdjTpCd( String	adjTpCd ) {
		this.adjTpCd =	adjTpCd;
	}
 
	/**
	 * Column Info
	 * @return	adjTpCd
	 */
	 public	 String	getAdjTpCd() {
		 return	this.adjTpCd;
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
	* @param  apCrsCurrAmt
	*/
	public void	setApCrsCurrAmt( String	apCrsCurrAmt ) {
		this.apCrsCurrAmt =	apCrsCurrAmt;
	}
 
	/**
	 * Column Info
	 * @return	apCrsCurrAmt
	 */
	 public	 String	getApCrsCurrAmt() {
		 return	this.apCrsCurrAmt;
	 } 
 	/**
	* Column Info
	* @param  rvsFlg
	*/
	public void	setRvsFlg( String	rvsFlg ) {
		this.rvsFlg =	rvsFlg;
	}
 
	/**
	 * Column Info
	 * @return	rvsFlg
	 */
	 public	 String	getRvsFlg() {
		 return	this.rvsFlg;
	 } 
 	/**
	* Column Info
	* @param  apCurrCd
	*/
	public void	setApCurrCd( String	apCurrCd ) {
		this.apCurrCd =	apCurrCd;
	}
 
	/**
	 * Column Info
	 * @return	apCurrCd
	 */
	 public	 String	getApCurrCd() {
		 return	this.apCurrCd;
	 } 
 	/**
	* Column Info
	* @param  invOfcCd
	*/
	public void	setInvOfcCd( String	invOfcCd ) {
		this.invOfcCd =	invOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	invOfcCd
	 */
	 public	 String	getInvOfcCd() {
		 return	this.invOfcCd;
	 } 
 	/**
	* Column Info
	* @param  adjRmk
	*/
	public void	setAdjRmk( String	adjRmk ) {
		this.adjRmk =	adjRmk;
	}
 
	/**
	 * Column Info
	 * @return	adjRmk
	 */
	 public	 String	getAdjRmk() {
		 return	this.adjRmk;
	 } 
 	/**
	* Column Info
	* @param  apOfcCd
	*/
	public void	setApOfcCd( String	apOfcCd ) {
		this.apOfcCd =	apOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	apOfcCd
	 */
	 public	 String	getApOfcCd() {
		 return	this.apOfcCd;
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
	* @param  chgAdjTpCd
	*/
	public void	setChgAdjTpCd( String	chgAdjTpCd ) {
		this.chgAdjTpCd =	chgAdjTpCd;
	}
 
	/**
	 * Column Info
	 * @return	chgAdjTpCd
	 */
	 public	 String	getChgAdjTpCd() {
		 return	this.chgAdjTpCd;
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
	* @param  otsHdrKey
	*/
	public void	setOtsHdrKey( String	otsHdrKey ) {
		this.otsHdrKey =	otsHdrKey;
	}
 
	/**
	 * Column Info
	 * @return	otsHdrKey
	 */
	 public	 String	getOtsHdrKey() {
		 return	this.otsHdrKey;
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
	* @param  apGlDt
	*/
	public void	setApGlDt( String	apGlDt ) {
		this.apGlDt =	apGlDt;
	}
 
	/**
	 * Column Info
	 * @return	apGlDt
	 */
	 public	 String	getApGlDt() {
		 return	this.apGlDt;
	 } 
 	/**
	* Column Info
	* @param  payAcctCd
	*/
	public void	setPayAcctCd( String	payAcctCd ) {
		this.payAcctCd =	payAcctCd;
	}
 
	/**
	 * Column Info
	 * @return	payAcctCd
	 */
	 public	 String	getPayAcctCd() {
		 return	this.payAcctCd;
	 } 
 	/**
	* Column Info
	* @param  apRmk
	*/
	public void	setApRmk( String	apRmk ) {
		this.apRmk =	apRmk;
	}
 
	/**
	 * Column Info
	 * @return	apRmk
	 */
	 public	 String	getApRmk() {
		 return	this.apRmk;
	 } 
 	/**
	* Column Info
	* @param  adjDt
	*/
	public void	setAdjDt( String	adjDt ) {
		this.adjDt =	adjDt;
	}
 
	/**
	 * Column Info
	 * @return	adjDt
	 */
	 public	 String	getAdjDt() {
		 return	this.adjDt;
	 } 
 	/**
	* Column Info
	* @param  adjOfcCd
	*/
	public void	setAdjOfcCd( String	adjOfcCd ) {
		this.adjOfcCd =	adjOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	adjOfcCd
	 */
	 public	 String	getAdjOfcCd() {
		 return	this.adjOfcCd;
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
		setXchRtDt(JSPUtil.getParameter(request,	prefix + "xch_rt_dt", ""));
		setOtsAdjSeq(JSPUtil.getParameter(request,	prefix + "ots_adj_seq", ""));
		setXchRtTpCd(JSPUtil.getParameter(request,	prefix + "xch_rt_tp_cd", ""));
		setAdjKeyNo(JSPUtil.getParameter(request,	prefix + "adj_key_no", ""));
		setBilToCustCntCd(JSPUtil.getParameter(request,	prefix + "bil_to_cust_cnt_cd", ""));
		setArFincSrcCd(JSPUtil.getParameter(request,	prefix + "ar_finc_src_cd", ""));
		setShpBilToCustCd(JSPUtil.getParameter(request,	prefix + "shp_bil_to_cust_cd", ""));
		setSrepCd(JSPUtil.getParameter(request,	prefix + "srep_cd", ""));
		setBlNo(JSPUtil.getParameter(request,	prefix + "bl_no", ""));
		setSailArrDt(JSPUtil.getParameter(request,	prefix + "sail_arr_dt", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setVndrNo(JSPUtil.getParameter(request,	prefix + "vndr_no", ""));
		setGainAndLssAmt(JSPUtil.getParameter(request,	prefix + "gain_and_lss_amt", ""));
		setAdjNo(JSPUtil.getParameter(request,	prefix + "adj_no", ""));
		setAdjTpCd(JSPUtil.getParameter(request,	prefix + "adj_tp_cd", ""));
		setDueDt(JSPUtil.getParameter(request,	prefix + "due_dt", ""));
		setApCrsCurrAmt(JSPUtil.getParameter(request,	prefix + "ap_crs_curr_amt", ""));
		setRvsFlg(JSPUtil.getParameter(request,	prefix + "rvs_flg", ""));
		setApCurrCd(JSPUtil.getParameter(request,	prefix + "ap_curr_cd", ""));
		setInvOfcCd(JSPUtil.getParameter(request,	prefix + "inv_ofc_cd", ""));
		setAdjRmk(JSPUtil.getParameter(request,	prefix + "adj_rmk", ""));
		setApOfcCd(JSPUtil.getParameter(request,	prefix + "ap_ofc_cd", ""));
		setRhqCd(JSPUtil.getParameter(request,	prefix + "rhq_cd", ""));
		setLoclVvdCd(JSPUtil.getParameter(request,	prefix + "locl_vvd_cd", ""));
		setTrnkVvdCd(JSPUtil.getParameter(request,	prefix + "trnk_vvd_cd", ""));
		setBilToCustSeq(JSPUtil.getParameter(request,	prefix + "bil_to_cust_seq", ""));
		setCrFlg(JSPUtil.getParameter(request,	prefix + "cr_flg", ""));
		setIoBndCd(JSPUtil.getParameter(request,	prefix + "io_bnd_cd", ""));
		setBilToCustCd(JSPUtil.getParameter(request,	prefix + "bil_to_cust_cd", ""));
		setInvNo(JSPUtil.getParameter(request,	prefix + "inv_no", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setOtsRmk(JSPUtil.getParameter(request,	prefix + "ots_rmk", ""));
		setBkgNo(JSPUtil.getParameter(request,	prefix + "bkg_no", ""));
		setChgAdjTpCd(JSPUtil.getParameter(request,	prefix + "chg_adj_tp_cd", ""));
		setMaxArIfNo(JSPUtil.getParameter(request,	prefix + "max_ar_if_no", ""));
		setOtsHdrKey(JSPUtil.getParameter(request,	prefix + "ots_hdr_key", ""));
		setAsaNo(JSPUtil.getParameter(request,	prefix + "asa_no", ""));
		setApGlDt(JSPUtil.getParameter(request,	prefix + "ap_gl_dt", ""));
		setPayAcctCd(JSPUtil.getParameter(request,	prefix + "pay_acct_cd", ""));
		setApRmk(JSPUtil.getParameter(request,	prefix + "ap_rmk", ""));
		setAdjDt(JSPUtil.getParameter(request,	prefix + "adj_dt", ""));
		setAdjOfcCd(JSPUtil.getParameter(request,	prefix + "adj_ofc_cd", ""));
	}
	
	/**
	 * Request ���곗씠�곕� VO 諛곗뿴濡�蹂�솚�섏뿬 諛섑솚.
	 * @param request
	 * @return AdjustHdrListVO[]
	 */
	public AdjustHdrListVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request �섏뼱���щ윭 嫄�DATA瑜�VO Class ���대뒗��
	 * @param request
	 * @param prefix
	 * @return AdjustHdrListVO[]
	 */
	public AdjustHdrListVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		AdjustHdrListVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] xchRtDt =	(JSPUtil.getParameter(request, prefix +	"xch_rt_dt".trim(),	length));
				String[] otsAdjSeq =	(JSPUtil.getParameter(request, prefix +	"ots_adj_seq".trim(),	length));
				String[] xchRtTpCd =	(JSPUtil.getParameter(request, prefix +	"xch_rt_tp_cd".trim(),	length));
				String[] adjKeyNo =	(JSPUtil.getParameter(request, prefix +	"adj_key_no".trim(),	length));
				String[] bilToCustCntCd =	(JSPUtil.getParameter(request, prefix +	"bil_to_cust_cnt_cd".trim(),	length));
				String[] arFincSrcCd =	(JSPUtil.getParameter(request, prefix +	"ar_finc_src_cd".trim(),	length));
				String[] shpBilToCustCd =	(JSPUtil.getParameter(request, prefix +	"shp_bil_to_cust_cd".trim(),	length));
				String[] srepCd =	(JSPUtil.getParameter(request, prefix +	"srep_cd".trim(),	length));
				String[] blNo =	(JSPUtil.getParameter(request, prefix +	"bl_no".trim(),	length));
				String[] sailArrDt =	(JSPUtil.getParameter(request, prefix +	"sail_arr_dt".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] vndrNo =	(JSPUtil.getParameter(request, prefix +	"vndr_no".trim(),	length));
				String[] gainAndLssAmt =	(JSPUtil.getParameter(request, prefix +	"gain_and_lss_amt".trim(),	length));
				String[] adjNo =	(JSPUtil.getParameter(request, prefix +	"adj_no".trim(),	length));
				String[] adjTpCd =	(JSPUtil.getParameter(request, prefix +	"adj_tp_cd".trim(),	length));
				String[] dueDt =	(JSPUtil.getParameter(request, prefix +	"due_dt".trim(),	length));
				String[] apCrsCurrAmt =	(JSPUtil.getParameter(request, prefix +	"ap_crs_curr_amt".trim(),	length));
				String[] rvsFlg =	(JSPUtil.getParameter(request, prefix +	"rvs_flg".trim(),	length));
				String[] apCurrCd =	(JSPUtil.getParameter(request, prefix +	"ap_curr_cd".trim(),	length));
				String[] invOfcCd =	(JSPUtil.getParameter(request, prefix +	"inv_ofc_cd".trim(),	length));
				String[] adjRmk =	(JSPUtil.getParameter(request, prefix +	"adj_rmk".trim(),	length));
				String[] apOfcCd =	(JSPUtil.getParameter(request, prefix +	"ap_ofc_cd".trim(),	length));
				String[] rhqCd =	(JSPUtil.getParameter(request, prefix +	"rhq_cd".trim(),	length));
				String[] loclVvdCd =	(JSPUtil.getParameter(request, prefix +	"locl_vvd_cd".trim(),	length));
				String[] trnkVvdCd =	(JSPUtil.getParameter(request, prefix +	"trnk_vvd_cd".trim(),	length));
				String[] bilToCustSeq =	(JSPUtil.getParameter(request, prefix +	"bil_to_cust_seq".trim(),	length));
				String[] crFlg =	(JSPUtil.getParameter(request, prefix +	"cr_flg".trim(),	length));
				String[] ioBndCd =	(JSPUtil.getParameter(request, prefix +	"io_bnd_cd".trim(),	length));
				String[] bilToCustCd =	(JSPUtil.getParameter(request, prefix +	"bil_to_cust_cd".trim(),	length));
				String[] invNo =	(JSPUtil.getParameter(request, prefix +	"inv_no".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				String[] otsRmk =	(JSPUtil.getParameter(request, prefix +	"ots_rmk".trim(),	length));
				String[] bkgNo =	(JSPUtil.getParameter(request, prefix +	"bkg_no".trim(),	length));
				String[] chgAdjTpCd =	(JSPUtil.getParameter(request, prefix +	"chg_adj_tp_cd".trim(),	length));
				String[] maxArIfNo =	(JSPUtil.getParameter(request, prefix +	"max_ar_if_no".trim(),	length));
				String[] otsHdrKey =	(JSPUtil.getParameter(request, prefix +	"ots_hdr_key".trim(),	length));
				String[] asaNo =	(JSPUtil.getParameter(request, prefix +	"asa_no".trim(),	length));
				String[] apGlDt =	(JSPUtil.getParameter(request, prefix +	"ap_gl_dt".trim(),	length));
				String[] payAcctCd =	(JSPUtil.getParameter(request, prefix +	"pay_acct_cd".trim(),	length));
				String[] apRmk =	(JSPUtil.getParameter(request, prefix +	"ap_rmk".trim(),	length));
				String[] adjDt =	(JSPUtil.getParameter(request, prefix +	"adj_dt".trim(),	length));
				String[] adjOfcCd =	(JSPUtil.getParameter(request, prefix +	"adj_ofc_cd".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	AdjustHdrListVO();
						if ( xchRtDt[i] !=	null)
						model.setXchRtDt( xchRtDt[i]);
						if ( otsAdjSeq[i] !=	null)
						model.setOtsAdjSeq( otsAdjSeq[i]);
						if ( xchRtTpCd[i] !=	null)
						model.setXchRtTpCd( xchRtTpCd[i]);
						if ( adjKeyNo[i] !=	null)
						model.setAdjKeyNo( adjKeyNo[i]);
						if ( bilToCustCntCd[i] !=	null)
						model.setBilToCustCntCd( bilToCustCntCd[i]);
						if ( arFincSrcCd[i] !=	null)
						model.setArFincSrcCd( arFincSrcCd[i]);
						if ( shpBilToCustCd[i] !=	null)
						model.setShpBilToCustCd( shpBilToCustCd[i]);
						if ( srepCd[i] !=	null)
						model.setSrepCd( srepCd[i]);
						if ( blNo[i] !=	null)
						model.setBlNo( blNo[i]);
						if ( sailArrDt[i] !=	null)
						model.setSailArrDt( sailArrDt[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( vndrNo[i] !=	null)
						model.setVndrNo( vndrNo[i]);
						if ( gainAndLssAmt[i] !=	null)
						model.setGainAndLssAmt( gainAndLssAmt[i]);
						if ( adjNo[i] !=	null)
						model.setAdjNo( adjNo[i]);
						if ( adjTpCd[i] !=	null)
						model.setAdjTpCd( adjTpCd[i]);
						if ( dueDt[i] !=	null)
						model.setDueDt( dueDt[i]);
						if ( apCrsCurrAmt[i] !=	null)
						model.setApCrsCurrAmt( apCrsCurrAmt[i]);
						if ( rvsFlg[i] !=	null)
						model.setRvsFlg( rvsFlg[i]);
						if ( apCurrCd[i] !=	null)
						model.setApCurrCd( apCurrCd[i]);
						if ( invOfcCd[i] !=	null)
						model.setInvOfcCd( invOfcCd[i]);
						if ( adjRmk[i] !=	null)
						model.setAdjRmk( adjRmk[i]);
						if ( apOfcCd[i] !=	null)
						model.setApOfcCd( apOfcCd[i]);
						if ( rhqCd[i] !=	null)
						model.setRhqCd( rhqCd[i]);
						if ( loclVvdCd[i] !=	null)
						model.setLoclVvdCd( loclVvdCd[i]);
						if ( trnkVvdCd[i] !=	null)
						model.setTrnkVvdCd( trnkVvdCd[i]);
						if ( bilToCustSeq[i] !=	null)
						model.setBilToCustSeq( bilToCustSeq[i]);
						if ( crFlg[i] !=	null)
						model.setCrFlg( crFlg[i]);
						if ( ioBndCd[i] !=	null)
						model.setIoBndCd( ioBndCd[i]);
						if ( bilToCustCd[i] !=	null)
						model.setBilToCustCd( bilToCustCd[i]);
						if ( invNo[i] !=	null)
						model.setInvNo( invNo[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
						if ( otsRmk[i] !=	null)
						model.setOtsRmk( otsRmk[i]);
						if ( bkgNo[i] !=	null)
						model.setBkgNo( bkgNo[i]);
						if ( chgAdjTpCd[i] !=	null)
						model.setChgAdjTpCd( chgAdjTpCd[i]);
						if ( maxArIfNo[i] !=	null)
						model.setMaxArIfNo( maxArIfNo[i]);
						if ( otsHdrKey[i] !=	null)
						model.setOtsHdrKey( otsHdrKey[i]);
						if ( asaNo[i] !=	null)
						model.setAsaNo( asaNo[i]);
						if ( apGlDt[i] !=	null)
						model.setApGlDt( apGlDt[i]);
						if ( payAcctCd[i] !=	null)
						model.setPayAcctCd( payAcctCd[i]);
						if ( apRmk[i] !=	null)
						model.setApRmk( apRmk[i]);
						if ( adjDt[i] !=	null)
						model.setAdjDt( adjDt[i]);
						if ( adjOfcCd[i] !=	null)
						model.setAdjOfcCd( adjOfcCd[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getAdjustHdrListVOs();
	}

	/**
	 *  VO 諛곗뿴��諛섑솚
	 * @return AdjustHdrListVO[]
	 */
	public AdjustHdrListVO[]	 getAdjustHdrListVOs(){
		AdjustHdrListVO[] vos = (AdjustHdrListVO[])models.toArray(new	AdjustHdrListVO[models.size()]);
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
		this.xchRtDt =	this.xchRtDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsAdjSeq =	this.otsAdjSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRtTpCd =	this.xchRtTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjKeyNo =	this.adjKeyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilToCustCntCd =	this.bilToCustCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arFincSrcCd =	this.arFincSrcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpBilToCustCd =	this.shpBilToCustCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepCd =	this.srepCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo =	this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailArrDt =	this.sailArrDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNo =	this.vndrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gainAndLssAmt =	this.gainAndLssAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjNo =	this.adjNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjTpCd =	this.adjTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dueDt =	this.dueDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apCrsCurrAmt =	this.apCrsCurrAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvsFlg =	this.rvsFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apCurrCd =	this.apCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invOfcCd =	this.invOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjRmk =	this.adjRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apOfcCd =	this.apOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd =	this.rhqCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclVvdCd =	this.loclVvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkVvdCd =	this.trnkVvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilToCustSeq =	this.bilToCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crFlg =	this.crFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd =	this.ioBndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilToCustCd =	this.bilToCustCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo =	this.invNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsRmk =	this.otsRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo =	this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAdjTpCd =	this.chgAdjTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxArIfNo =	this.maxArIfNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsHdrKey =	this.otsHdrKey.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asaNo =	this.asaNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apGlDt =	this.apGlDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payAcctCd =	this.payAcctCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apRmk =	this.apRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjDt =	this.adjDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjOfcCd =	this.adjOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}