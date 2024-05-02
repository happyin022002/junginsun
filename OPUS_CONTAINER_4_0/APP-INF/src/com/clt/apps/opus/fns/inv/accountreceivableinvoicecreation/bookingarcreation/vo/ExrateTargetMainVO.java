/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ExrateTargetMainVO.java
 *@FileTitle : ExrateTargetMainVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.03.16
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2015.03.16  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo;

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
public class ExrateTargetMainVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<ExrateTargetMainVO>  models =	new	ArrayList<ExrateTargetMainVO>();


	/*	Column Info	*/
	private  String	 vslCd   =  null;
	/*	Column Info	*/
	private  String	 svcScpCd   =  null;
	/*	Column Info	*/
	private  String	 invCustSeq   =  null;
	/*	Column Info	*/
	private  String	 loclCurrCd   =  null;
	/*	Column Info	*/
	private  String	 trfRtAmt   =  null;
	/*	Column Info	*/
	private  String	 skdVoyNo   =  null;
	/*	Column Info	*/
	private  String	 ioBndCd   =  null;
	/*	Column Info	*/
	private  String	 arOfcCd   =  null;
	/*	Column Info	*/
	private  String	 skdDirCd   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 sailDt   =  null;
	/*	Column Info	*/
	private  String	 podCd   =  null;
	/*	Column Info	*/
	private  String	 bkgNo   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 polCd   =  null;
	/*	Column Info	*/
	private  String	 invCustCntCd   =  null;
	/*	Column Info	*/
	private  String	 arIfNo   =  null;
	/*	Column Info	*/
	private  String	 chgAmt   =  null;
	/*	Column Info	*/
	private  String	 blInvCfmDt   =  null;
	/*	Column Info	*/
	private  String	 issFlg   =  null;
	/*	Column Info	*/
	private  String	 actCustCntCd   =  null;
	/*	Column Info	*/
	private  String	 actCustSeq   =  null;
	/*	Column Info	*/
	private  String	 sailArrDt   =  null;
	/*	Column Info	*/
	private  String	 blSrcNo   =  null;
	/*	Column Info	*/
	private  String	 revTpCd   =  null;
	/*	Column Info	*/
	private  String	 revSrcCd   =  null;
	/*	Column Info	*/
	private  String	 otsSmryCd   =  null;
	/*	Column Info	*/
	private  String	 dmdtArInvIssFlg   =  null;
	/*	Column Info	*/
	private  String	 invClrFlg   =  null;
	/*	Column Info	*/
	private  String	 xchRtUsdTpCd   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public ExrateTargetMainVO(){}

	public ExrateTargetMainVO(String vslCd,String svcScpCd,String invCustSeq,String loclCurrCd,String trfRtAmt,String skdVoyNo,String ioBndCd,String arOfcCd,String skdDirCd,String pagerows,String sailDt,String podCd,String bkgNo,String ibflag,String polCd,String invCustCntCd,String arIfNo,String chgAmt,String blInvCfmDt,String issFlg,String actCustCntCd,String actCustSeq,String sailArrDt,String blSrcNo,String revTpCd,String revSrcCd,String otsSmryCd,String dmdtArInvIssFlg,String invClrFlg,String xchRtUsdTpCd)	{
		this.vslCd  = vslCd ;
		this.svcScpCd  = svcScpCd ;
		this.invCustSeq  = invCustSeq ;
		this.loclCurrCd  = loclCurrCd ;
		this.trfRtAmt  = trfRtAmt ;
		this.skdVoyNo  = skdVoyNo ;
		this.ioBndCd  = ioBndCd ;
		this.arOfcCd  = arOfcCd ;
		this.skdDirCd  = skdDirCd ;
		this.pagerows  = pagerows ;
		this.sailDt  = sailDt ;
		this.podCd  = podCd ;
		this.bkgNo  = bkgNo ;
		this.ibflag  = ibflag ;
		this.polCd  = polCd ;
		this.invCustCntCd  = invCustCntCd ;
		this.arIfNo  = arIfNo ;
		this.chgAmt  = chgAmt ;
		this.blInvCfmDt  = blInvCfmDt ;
		this.issFlg  = issFlg ;
		this.actCustCntCd  = actCustCntCd ;
		this.actCustSeq  = actCustSeq ;
		this.sailArrDt  = sailArrDt ;
		this.blSrcNo  = blSrcNo ;
		this.revTpCd  = revTpCd ;
		this.revSrcCd  = revSrcCd ;
		this.otsSmryCd  = otsSmryCd ;
		this.dmdtArInvIssFlg  = dmdtArInvIssFlg ;
		this.invClrFlg  = invClrFlg ;
		this.xchRtUsdTpCd  = xchRtUsdTpCd ;
	}


	/**
	 * �뚯씠釉�而щ읆����옣��媛믪쓣 Hashtable<"column_name", "value">	濡�諛섑솚
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());		
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());		
		this.hashColumns.put("inv_cust_seq", getInvCustSeq());		
		this.hashColumns.put("locl_curr_cd", getLoclCurrCd());		
		this.hashColumns.put("trf_rt_amt", getTrfRtAmt());		
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());		
		this.hashColumns.put("io_bnd_cd", getIoBndCd());		
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());		
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("sail_dt", getSailDt());		
		this.hashColumns.put("pod_cd", getPodCd());		
		this.hashColumns.put("bkg_no", getBkgNo());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("pol_cd", getPolCd());		
		this.hashColumns.put("inv_cust_cnt_cd", getInvCustCntCd());		
		this.hashColumns.put("ar_if_no", getArIfNo());		
		this.hashColumns.put("chg_amt", getChgAmt());		
		this.hashColumns.put("bl_inv_cfm_dt", getBlInvCfmDt());		
		this.hashColumns.put("iss_flg", getIssFlg());		
		this.hashColumns.put("act_cust_cnt_cd", getActCustCntCd());		
		this.hashColumns.put("act_cust_seq", getActCustSeq());		
		this.hashColumns.put("sail_arr_dt", getSailArrDt());		
		this.hashColumns.put("bl_src_no", getBlSrcNo());		
		this.hashColumns.put("rev_tp_cd", getRevTpCd());		
		this.hashColumns.put("rev_src_cd", getRevSrcCd());		
		this.hashColumns.put("ots_smry_cd", getOtsSmryCd());		
		this.hashColumns.put("dmdt_ar_inv_iss_flg", getDmdtArInvIssFlg());		
		this.hashColumns.put("inv_clr_flg", getInvClrFlg());		
		this.hashColumns.put("xch_rt_usd_tp_cd", getXchRtUsdTpCd());		
		return this.hashColumns;
}

	/**
	 * 而щ읆紐낆뿉	��쓳�섎뒗 硫ㅻ쾭蹂�닔紐낆쓣	��옣�섏뿬 Hashtable<"column_name", "variable"> 濡�諛섑솚
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("inv_cust_seq", "invCustSeq");
		this.hashFields.put("locl_curr_cd", "loclCurrCd");
		this.hashFields.put("trf_rt_amt", "trfRtAmt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sail_dt", "sailDt");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("inv_cust_cnt_cd", "invCustCntCd");
		this.hashFields.put("ar_if_no", "arIfNo");
		this.hashFields.put("chg_amt", "chgAmt");
		this.hashFields.put("bl_inv_cfm_dt", "blInvCfmDt");
		this.hashFields.put("iss_flg", "issFlg");
		this.hashFields.put("act_cust_cnt_cd", "actCustCntCd");
		this.hashFields.put("act_cust_seq", "actCustSeq");
		this.hashFields.put("sail_arr_dt", "sailArrDt");
		this.hashFields.put("bl_src_no", "blSrcNo");
		this.hashFields.put("rev_tp_cd", "revTpCd");
		this.hashFields.put("rev_src_cd", "revSrcCd");
		this.hashFields.put("ots_smry_cd", "otsSmryCd");
		this.hashFields.put("dmdt_ar_inv_iss_flg", "dmdtArInvIssFlg");
		this.hashFields.put("inv_clr_flg", "invClrFlg");
		this.hashFields.put("xch_rt_usd_tp_cd", "xchRtUsdTpCd");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  vslCd
	*/
	public void	setVslCd( String	vslCd ) {
		this.vslCd =	vslCd;
	}
 
	/**
	 * Column Info
	 * @return	vslCd
	 */
	 public	 String	getVslCd() {
		 return	this.vslCd;
	 } 
 	/**
	* Column Info
	* @param  svcScpCd
	*/
	public void	setSvcScpCd( String	svcScpCd ) {
		this.svcScpCd =	svcScpCd;
	}
 
	/**
	 * Column Info
	 * @return	svcScpCd
	 */
	 public	 String	getSvcScpCd() {
		 return	this.svcScpCd;
	 } 
 	/**
	* Column Info
	* @param  invCustSeq
	*/
	public void	setInvCustSeq( String	invCustSeq ) {
		this.invCustSeq =	invCustSeq;
	}
 
	/**
	 * Column Info
	 * @return	invCustSeq
	 */
	 public	 String	getInvCustSeq() {
		 return	this.invCustSeq;
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
	* @param  skdVoyNo
	*/
	public void	setSkdVoyNo( String	skdVoyNo ) {
		this.skdVoyNo =	skdVoyNo;
	}
 
	/**
	 * Column Info
	 * @return	skdVoyNo
	 */
	 public	 String	getSkdVoyNo() {
		 return	this.skdVoyNo;
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
	* @param  skdDirCd
	*/
	public void	setSkdDirCd( String	skdDirCd ) {
		this.skdDirCd =	skdDirCd;
	}
 
	/**
	 * Column Info
	 * @return	skdDirCd
	 */
	 public	 String	getSkdDirCd() {
		 return	this.skdDirCd;
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
	* @param  sailDt
	*/
	public void	setSailDt( String	sailDt ) {
		this.sailDt =	sailDt;
	}
 
	/**
	 * Column Info
	 * @return	sailDt
	 */
	 public	 String	getSailDt() {
		 return	this.sailDt;
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
	* @param  invCustCntCd
	*/
	public void	setInvCustCntCd( String	invCustCntCd ) {
		this.invCustCntCd =	invCustCntCd;
	}
 
	/**
	 * Column Info
	 * @return	invCustCntCd
	 */
	 public	 String	getInvCustCntCd() {
		 return	this.invCustCntCd;
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
	* @param  blInvCfmDt
	*/
	public void	setBlInvCfmDt( String	blInvCfmDt ) {
		this.blInvCfmDt =	blInvCfmDt;
	}
 
	/**
	 * Column Info
	 * @return	blInvCfmDt
	 */
	 public	 String	getBlInvCfmDt() {
		 return	this.blInvCfmDt;
	 } 
 	/**
	* Column Info
	* @param  issFlg
	*/
	public void	setIssFlg( String	issFlg ) {
		this.issFlg =	issFlg;
	}
 
	/**
	 * Column Info
	 * @return	issFlg
	 */
	 public	 String	getIssFlg() {
		 return	this.issFlg;
	 } 
 	/**
	* Column Info
	* @param  actCustCntCd
	*/
	public void	setActCustCntCd( String	actCustCntCd ) {
		this.actCustCntCd =	actCustCntCd;
	}
 
	/**
	 * Column Info
	 * @return	actCustCntCd
	 */
	 public	 String	getActCustCntCd() {
		 return	this.actCustCntCd;
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
	* @param  revSrcCd
	*/
	public void	setRevSrcCd( String	revSrcCd ) {
		this.revSrcCd =	revSrcCd;
	}
 
	/**
	 * Column Info
	 * @return	revSrcCd
	 */
	 public	 String	getRevSrcCd() {
		 return	this.revSrcCd;
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
	* @param  dmdtArInvIssFlg
	*/
	public void	setDmdtArInvIssFlg( String	dmdtArInvIssFlg ) {
		this.dmdtArInvIssFlg =	dmdtArInvIssFlg;
	}
 
	/**
	 * Column Info
	 * @return	dmdtArInvIssFlg
	 */
	 public	 String	getDmdtArInvIssFlg() {
		 return	this.dmdtArInvIssFlg;
	 } 
 	/**
	* Column Info
	* @param  invClrFlg
	*/
	public void	setInvClrFlg( String	invClrFlg ) {
		this.invClrFlg =	invClrFlg;
	}
 
	/**
	 * Column Info
	 * @return	invClrFlg
	 */
	 public	 String	getInvClrFlg() {
		 return	this.invClrFlg;
	 } 
 	/**
	* Column Info
	* @param  xchRtUsdTpCd
	*/
	public void	setXchRtUsdTpCd( String	xchRtUsdTpCd ) {
		this.xchRtUsdTpCd =	xchRtUsdTpCd;
	}
 
	/**
	 * Column Info
	 * @return	xchRtUsdTpCd
	 */
	 public	 String	getXchRtUsdTpCd() {
		 return	this.xchRtUsdTpCd;
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
		setVslCd(JSPUtil.getParameter(request,	prefix + "vsl_cd", ""));
		setSvcScpCd(JSPUtil.getParameter(request,	prefix + "svc_scp_cd", ""));
		setInvCustSeq(JSPUtil.getParameter(request,	prefix + "inv_cust_seq", ""));
		setLoclCurrCd(JSPUtil.getParameter(request,	prefix + "locl_curr_cd", ""));
		setTrfRtAmt(JSPUtil.getParameter(request,	prefix + "trf_rt_amt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request,	prefix + "skd_voy_no", ""));
		setIoBndCd(JSPUtil.getParameter(request,	prefix + "io_bnd_cd", ""));
		setArOfcCd(JSPUtil.getParameter(request,	prefix + "ar_ofc_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request,	prefix + "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setSailDt(JSPUtil.getParameter(request,	prefix + "sail_dt", ""));
		setPodCd(JSPUtil.getParameter(request,	prefix + "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request,	prefix + "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request,	prefix + "pol_cd", ""));
		setInvCustCntCd(JSPUtil.getParameter(request,	prefix + "inv_cust_cnt_cd", ""));
		setArIfNo(JSPUtil.getParameter(request,	prefix + "ar_if_no", ""));
		setChgAmt(JSPUtil.getParameter(request,	prefix + "chg_amt", ""));
		setBlInvCfmDt(JSPUtil.getParameter(request,	prefix + "bl_inv_cfm_dt", ""));
		setIssFlg(JSPUtil.getParameter(request,	prefix + "iss_flg", ""));
		setActCustCntCd(JSPUtil.getParameter(request,	prefix + "act_cust_cnt_cd", ""));
		setActCustSeq(JSPUtil.getParameter(request,	prefix + "act_cust_seq", ""));
		setSailArrDt(JSPUtil.getParameter(request,	prefix + "sail_arr_dt", ""));
		setBlSrcNo(JSPUtil.getParameter(request,	prefix + "bl_src_no", ""));
		setRevTpCd(JSPUtil.getParameter(request,	prefix + "rev_tp_cd", ""));
		setRevSrcCd(JSPUtil.getParameter(request,	prefix + "rev_src_cd", ""));
		setOtsSmryCd(JSPUtil.getParameter(request,	prefix + "ots_smry_cd", ""));
		setDmdtArInvIssFlg(JSPUtil.getParameter(request,	prefix + "dmdt_ar_inv_iss_flg", ""));
		setInvClrFlg(JSPUtil.getParameter(request,	prefix + "inv_clr_flg", ""));
		setXchRtUsdTpCd(JSPUtil.getParameter(request,	prefix + "xch_rt_usd_tp_cd", ""));
	}
	
	/**
	 * Request ���곗씠�곕� VO 諛곗뿴濡�蹂�솚�섏뿬 諛섑솚.
	 * @param request
	 * @return ExrateTargetMainVO[]
	 */
	public ExrateTargetMainVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request �섏뼱���щ윭 嫄�DATA瑜�VO Class ���대뒗��
	 * @param request
	 * @param prefix
	 * @return ExrateTargetMainVO[]
	 */
	public ExrateTargetMainVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		ExrateTargetMainVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] vslCd =	(JSPUtil.getParameter(request, prefix +	"vsl_cd".trim(),	length));
				String[] svcScpCd =	(JSPUtil.getParameter(request, prefix +	"svc_scp_cd".trim(),	length));
				String[] invCustSeq =	(JSPUtil.getParameter(request, prefix +	"inv_cust_seq".trim(),	length));
				String[] loclCurrCd =	(JSPUtil.getParameter(request, prefix +	"locl_curr_cd".trim(),	length));
				String[] trfRtAmt =	(JSPUtil.getParameter(request, prefix +	"trf_rt_amt".trim(),	length));
				String[] skdVoyNo =	(JSPUtil.getParameter(request, prefix +	"skd_voy_no".trim(),	length));
				String[] ioBndCd =	(JSPUtil.getParameter(request, prefix +	"io_bnd_cd".trim(),	length));
				String[] arOfcCd =	(JSPUtil.getParameter(request, prefix +	"ar_ofc_cd".trim(),	length));
				String[] skdDirCd =	(JSPUtil.getParameter(request, prefix +	"skd_dir_cd".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] sailDt =	(JSPUtil.getParameter(request, prefix +	"sail_dt".trim(),	length));
				String[] podCd =	(JSPUtil.getParameter(request, prefix +	"pod_cd".trim(),	length));
				String[] bkgNo =	(JSPUtil.getParameter(request, prefix +	"bkg_no".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] polCd =	(JSPUtil.getParameter(request, prefix +	"pol_cd".trim(),	length));
				String[] invCustCntCd =	(JSPUtil.getParameter(request, prefix +	"inv_cust_cnt_cd".trim(),	length));
				String[] arIfNo =	(JSPUtil.getParameter(request, prefix +	"ar_if_no".trim(),	length));
				String[] chgAmt =	(JSPUtil.getParameter(request, prefix +	"chg_amt".trim(),	length));
				String[] blInvCfmDt =	(JSPUtil.getParameter(request, prefix +	"bl_inv_cfm_dt".trim(),	length));
				String[] issFlg =	(JSPUtil.getParameter(request, prefix +	"iss_flg".trim(),	length));
				String[] actCustCntCd =	(JSPUtil.getParameter(request, prefix +	"act_cust_cnt_cd".trim(),	length));
				String[] actCustSeq =	(JSPUtil.getParameter(request, prefix +	"act_cust_seq".trim(),	length));
				String[] sailArrDt =	(JSPUtil.getParameter(request, prefix +	"sail_arr_dt".trim(),	length));
				String[] blSrcNo =	(JSPUtil.getParameter(request, prefix +	"bl_src_no".trim(),	length));
				String[] revTpCd =	(JSPUtil.getParameter(request, prefix +	"rev_tp_cd".trim(),	length));
				String[] revSrcCd =	(JSPUtil.getParameter(request, prefix +	"rev_src_cd".trim(),	length));
				String[] otsSmryCd =	(JSPUtil.getParameter(request, prefix +	"ots_smry_cd".trim(),	length));
				String[] dmdtArInvIssFlg =	(JSPUtil.getParameter(request, prefix +	"dmdt_ar_inv_iss_flg".trim(),	length));
				String[] invClrFlg =	(JSPUtil.getParameter(request, prefix +	"inv_clr_flg".trim(),	length));
				String[] xchRtUsdTpCd =	(JSPUtil.getParameter(request, prefix +	"xch_rt_usd_tp_cd".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	ExrateTargetMainVO();
						if ( vslCd[i] !=	null)
						model.setVslCd( vslCd[i]);
						if ( svcScpCd[i] !=	null)
						model.setSvcScpCd( svcScpCd[i]);
						if ( invCustSeq[i] !=	null)
						model.setInvCustSeq( invCustSeq[i]);
						if ( loclCurrCd[i] !=	null)
						model.setLoclCurrCd( loclCurrCd[i]);
						if ( trfRtAmt[i] !=	null)
						model.setTrfRtAmt( trfRtAmt[i]);
						if ( skdVoyNo[i] !=	null)
						model.setSkdVoyNo( skdVoyNo[i]);
						if ( ioBndCd[i] !=	null)
						model.setIoBndCd( ioBndCd[i]);
						if ( arOfcCd[i] !=	null)
						model.setArOfcCd( arOfcCd[i]);
						if ( skdDirCd[i] !=	null)
						model.setSkdDirCd( skdDirCd[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( sailDt[i] !=	null)
						model.setSailDt( sailDt[i]);
						if ( podCd[i] !=	null)
						model.setPodCd( podCd[i]);
						if ( bkgNo[i] !=	null)
						model.setBkgNo( bkgNo[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( polCd[i] !=	null)
						model.setPolCd( polCd[i]);
						if ( invCustCntCd[i] !=	null)
						model.setInvCustCntCd( invCustCntCd[i]);
						if ( arIfNo[i] !=	null)
						model.setArIfNo( arIfNo[i]);
						if ( chgAmt[i] !=	null)
						model.setChgAmt( chgAmt[i]);
						if ( blInvCfmDt[i] !=	null)
						model.setBlInvCfmDt( blInvCfmDt[i]);
						if ( issFlg[i] !=	null)
						model.setIssFlg( issFlg[i]);
						if ( actCustCntCd[i] !=	null)
						model.setActCustCntCd( actCustCntCd[i]);
						if ( actCustSeq[i] !=	null)
						model.setActCustSeq( actCustSeq[i]);
						if ( sailArrDt[i] !=	null)
						model.setSailArrDt( sailArrDt[i]);
						if ( blSrcNo[i] !=	null)
						model.setBlSrcNo( blSrcNo[i]);
						if ( revTpCd[i] !=	null)
						model.setRevTpCd( revTpCd[i]);
						if ( revSrcCd[i] !=	null)
						model.setRevSrcCd( revSrcCd[i]);
						if ( otsSmryCd[i] !=	null)
						model.setOtsSmryCd( otsSmryCd[i]);
						if ( dmdtArInvIssFlg[i] !=	null)
						model.setDmdtArInvIssFlg( dmdtArInvIssFlg[i]);
						if ( invClrFlg[i] !=	null)
						model.setInvClrFlg( invClrFlg[i]);
						if ( xchRtUsdTpCd[i] !=	null)
						model.setXchRtUsdTpCd( xchRtUsdTpCd[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getExrateTargetMainVOs();
	}

	/**
	 *  VO 諛곗뿴��諛섑솚
	 * @return ExrateTargetMainVO[]
	 */
	public ExrateTargetMainVO[]	 getExrateTargetMainVOs(){
		ExrateTargetMainVO[] vos = (ExrateTargetMainVO[])models.toArray(new	ExrateTargetMainVO[models.size()]);
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
		this.vslCd =	this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd =	this.svcScpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCustSeq =	this.invCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCd =	this.loclCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfRtAmt =	this.trfRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo =	this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd =	this.ioBndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd =	this.arOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd =	this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailDt =	this.sailDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd =	this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo =	this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd =	this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCustCntCd =	this.invCustCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfNo =	this.arIfNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmt =	this.chgAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blInvCfmDt =	this.blInvCfmDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issFlg =	this.issFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustCntCd =	this.actCustCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustSeq =	this.actCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailArrDt =	this.sailArrDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSrcNo =	this.blSrcNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revTpCd =	this.revTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revSrcCd =	this.revSrcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsSmryCd =	this.otsSmryCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtArInvIssFlg =	this.dmdtArInvIssFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invClrFlg =	this.invClrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRtUsdTpCd =	this.xchRtUsdTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}