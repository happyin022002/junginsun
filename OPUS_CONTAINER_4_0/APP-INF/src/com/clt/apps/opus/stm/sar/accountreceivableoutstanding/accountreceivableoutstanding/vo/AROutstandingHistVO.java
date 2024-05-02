/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : AROutstandingHistVO.java
 *@FileTitle : AROutstandingHistVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.11.27
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2014.11.27  
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
public class AROutstandingHistVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<AROutstandingHistVO>  models =	new	ArrayList<AROutstandingHistVO>();


	/*	Column Info	*/
	private  String	 xchRtDt   =  null;
	/*	Column Info	*/
	private  String	 ifDt   =  null;
	/*	Column Info	*/
	private  String	 agnExpnTpCd   =  null;
	/*	Column Info	*/
	private  String	 xchRtTpCd   =  null;
	/*	Column Info	*/
	private  String	 vslCd   =  null;
	/*	Column Info	*/
	private  String	 glDt   =  null;
	/*	Column Info	*/
	private  String	 currCd   =  null;
	/*	Column Info	*/
	private  String	 bilToCustCntCd   =  null;
	/*	Column Info	*/
	private  String	 svcScpCd   =  null;
	/*	Column Info	*/
	private  String	 usdXchRt   =  null;
	/*	Column Info	*/
	private  String	 creDt   =  null;
	/*	Column Info	*/
	private  String	 bkgIoBndCd   =  null;
	/*	Column Info	*/
	private  String	 blNo   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 polCd   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 otsHisTpCd   =  null;
	/*	Column Info	*/
	private  String	 dirCd   =  null;
	/*	Column Info	*/
	private  String	 otsSrcCd   =  null;
	/*	Column Info	*/
	private  String	 otsHisSeq   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 invOfcCd   =  null;
	/*	Column Info	*/
	private  String	 updDt   =  null;
	/*	Column Info	*/
	private  String	 loclXchRt   =  null;
	/*	Column Info	*/
	private  String	 ifNo   =  null;
	/*	Column Info	*/
	private  String	 shpToCustSeq   =  null;
	/*	Column Info	*/
	private  String	 rhqCd   =  null;
	/*	Column Info	*/
	private  String	 bilToCustSeq   =  null;
	/*	Column Info	*/
	private  String	 skdVoyNo   =  null;
	/*	Column Info	*/
	private  String	 podCd   =  null;
	/*	Column Info	*/
	private  String	 invNo   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;
	/*	Column Info	*/
	private  String	 usdAmt   =  null;
	/*	Column Info	*/
	private  String	 otsRmk   =  null;
	/*	Column Info	*/
	private  String	 otsOfcCd   =  null;
	/*	Column Info	*/
	private  String	 shpToCustCntCd   =  null;
	/*	Column Info	*/
	private  String	 otsAmt   =  null;
	/*	Column Info	*/
	private  String	 refNo   =  null;
	/*	Column Info	*/
	private  String	 revVvdCd   =  null;
	/*	Column Info	*/
	private  String	 revTpSrcCd   =  null;
	/*	Column Info	*/
	private  String	 sailDt   =  null;
	/*	Column Info	*/
	private  String	 invCurrCd   =  null;
	/*	Column Info	*/
	private  String	 invLoclXchRt   =  null;
	/*	Column Info	*/
	private  String	 invUsdXchRt   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public AROutstandingHistVO(){}

	public AROutstandingHistVO(String xchRtDt,String ifDt,String agnExpnTpCd,String xchRtTpCd,String vslCd,String glDt,String currCd,String bilToCustCntCd,String svcScpCd,String usdXchRt,String creDt,String bkgIoBndCd,String blNo,String pagerows,String polCd,String ibflag,String otsHisTpCd,String dirCd,String otsSrcCd,String otsHisSeq,String updUsrId,String invOfcCd,String updDt,String loclXchRt,String ifNo,String shpToCustSeq,String rhqCd,String bilToCustSeq,String skdVoyNo,String podCd,String invNo,String creUsrId,String usdAmt,String otsRmk,String otsOfcCd,String shpToCustCntCd,String otsAmt,String refNo,String revVvdCd,String revTpSrcCd,String sailDt,String invCurrCd,String invLoclXchRt,String invUsdXchRt)	{
		this.xchRtDt  = xchRtDt ;
		this.ifDt  = ifDt ;
		this.agnExpnTpCd  = agnExpnTpCd ;
		this.xchRtTpCd  = xchRtTpCd ;
		this.vslCd  = vslCd ;
		this.glDt  = glDt ;
		this.currCd  = currCd ;
		this.bilToCustCntCd  = bilToCustCntCd ;
		this.svcScpCd  = svcScpCd ;
		this.usdXchRt  = usdXchRt ;
		this.creDt  = creDt ;
		this.bkgIoBndCd  = bkgIoBndCd ;
		this.blNo  = blNo ;
		this.pagerows  = pagerows ;
		this.polCd  = polCd ;
		this.ibflag  = ibflag ;
		this.otsHisTpCd  = otsHisTpCd ;
		this.dirCd  = dirCd ;
		this.otsSrcCd  = otsSrcCd ;
		this.otsHisSeq  = otsHisSeq ;
		this.updUsrId  = updUsrId ;
		this.invOfcCd  = invOfcCd ;
		this.updDt  = updDt ;
		this.loclXchRt  = loclXchRt ;
		this.ifNo  = ifNo ;
		this.shpToCustSeq  = shpToCustSeq ;
		this.rhqCd  = rhqCd ;
		this.bilToCustSeq  = bilToCustSeq ;
		this.skdVoyNo  = skdVoyNo ;
		this.podCd  = podCd ;
		this.invNo  = invNo ;
		this.creUsrId  = creUsrId ;
		this.usdAmt  = usdAmt ;
		this.otsRmk  = otsRmk ;
		this.otsOfcCd  = otsOfcCd ;
		this.shpToCustCntCd  = shpToCustCntCd ;
		this.otsAmt  = otsAmt ;
		this.refNo  = refNo ;
		this.revVvdCd  = revVvdCd ;
		this.revTpSrcCd  = revTpSrcCd ;
		this.sailDt  = sailDt ;
		this.invCurrCd  = invCurrCd ;
		this.invLoclXchRt  = invLoclXchRt ;
		this.invUsdXchRt  = invUsdXchRt ;
	}


	/**
	 * �뚯씠釉�而щ읆����옣��媛믪쓣 Hashtable<"column_name", "value">	濡�諛섑솚
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("xch_rt_dt", getXchRtDt());		
		this.hashColumns.put("if_dt", getIfDt());		
		this.hashColumns.put("agn_expn_tp_cd", getAgnExpnTpCd());		
		this.hashColumns.put("xch_rt_tp_cd", getXchRtTpCd());		
		this.hashColumns.put("vsl_cd", getVslCd());		
		this.hashColumns.put("gl_dt", getGlDt());		
		this.hashColumns.put("curr_cd", getCurrCd());		
		this.hashColumns.put("bil_to_cust_cnt_cd", getBilToCustCntCd());		
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());		
		this.hashColumns.put("usd_xch_rt", getUsdXchRt());		
		this.hashColumns.put("cre_dt", getCreDt());		
		this.hashColumns.put("bkg_io_bnd_cd", getBkgIoBndCd());		
		this.hashColumns.put("bl_no", getBlNo());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("pol_cd", getPolCd());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("ots_his_tp_cd", getOtsHisTpCd());		
		this.hashColumns.put("dir_cd", getDirCd());		
		this.hashColumns.put("ots_src_cd", getOtsSrcCd());		
		this.hashColumns.put("ots_his_seq", getOtsHisSeq());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("inv_ofc_cd", getInvOfcCd());		
		this.hashColumns.put("upd_dt", getUpdDt());		
		this.hashColumns.put("locl_xch_rt", getLoclXchRt());		
		this.hashColumns.put("if_no", getIfNo());		
		this.hashColumns.put("shp_to_cust_seq", getShpToCustSeq());		
		this.hashColumns.put("rhq_cd", getRhqCd());		
		this.hashColumns.put("bil_to_cust_seq", getBilToCustSeq());		
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());		
		this.hashColumns.put("pod_cd", getPodCd());		
		this.hashColumns.put("inv_no", getInvNo());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("usd_amt", getUsdAmt());		
		this.hashColumns.put("ots_rmk", getOtsRmk());		
		this.hashColumns.put("ots_ofc_cd", getOtsOfcCd());		
		this.hashColumns.put("shp_to_cust_cnt_cd", getShpToCustCntCd());		
		this.hashColumns.put("ots_amt", getOtsAmt());		
		this.hashColumns.put("ref_no", getRefNo());		
		this.hashColumns.put("rev_vvd_cd", getRevVvdCd());		
		this.hashColumns.put("rev_tp_src_cd", getRevTpSrcCd());		
		this.hashColumns.put("sail_dt", getSailDt());		
		this.hashColumns.put("inv_curr_cd", getInvCurrCd());		
		this.hashColumns.put("inv_locl_xch_rt", getInvLoclXchRt());		
		this.hashColumns.put("inv_usd_xch_rt", getInvUsdXchRt());		
		return this.hashColumns;
}

	/**
	 * 而щ읆紐낆뿉	��쓳�섎뒗 硫ㅻ쾭蹂�닔紐낆쓣	��옣�섏뿬 Hashtable<"column_name", "variable"> 濡�諛섑솚
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("xch_rt_dt", "xchRtDt");
		this.hashFields.put("if_dt", "ifDt");
		this.hashFields.put("agn_expn_tp_cd", "agnExpnTpCd");
		this.hashFields.put("xch_rt_tp_cd", "xchRtTpCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("gl_dt", "glDt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("bil_to_cust_cnt_cd", "bilToCustCntCd");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("usd_xch_rt", "usdXchRt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("bkg_io_bnd_cd", "bkgIoBndCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ots_his_tp_cd", "otsHisTpCd");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("ots_src_cd", "otsSrcCd");
		this.hashFields.put("ots_his_seq", "otsHisSeq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("inv_ofc_cd", "invOfcCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("locl_xch_rt", "loclXchRt");
		this.hashFields.put("if_no", "ifNo");
		this.hashFields.put("shp_to_cust_seq", "shpToCustSeq");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("bil_to_cust_seq", "bilToCustSeq");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("usd_amt", "usdAmt");
		this.hashFields.put("ots_rmk", "otsRmk");
		this.hashFields.put("ots_ofc_cd", "otsOfcCd");
		this.hashFields.put("shp_to_cust_cnt_cd", "shpToCustCntCd");
		this.hashFields.put("ots_amt", "otsAmt");
		this.hashFields.put("ref_no", "refNo");
		this.hashFields.put("rev_vvd_cd", "revVvdCd");
		this.hashFields.put("rev_tp_src_cd", "revTpSrcCd");
		this.hashFields.put("sail_dt", "sailDt");
		this.hashFields.put("inv_curr_cd", "invCurrCd");
		this.hashFields.put("inv_locl_xch_rt", "invLoclXchRt");
		this.hashFields.put("inv_usd_xch_rt", "invUsdXchRt");
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
	* @param  ifDt
	*/
	public void	setIfDt( String	ifDt ) {
		this.ifDt =	ifDt;
	}
 
	/**
	 * Column Info
	 * @return	ifDt
	 */
	 public	 String	getIfDt() {
		 return	this.ifDt;
	 } 
 	/**
	* Column Info
	* @param  agnExpnTpCd
	*/
	public void	setAgnExpnTpCd( String	agnExpnTpCd ) {
		this.agnExpnTpCd =	agnExpnTpCd;
	}
 
	/**
	 * Column Info
	 * @return	agnExpnTpCd
	 */
	 public	 String	getAgnExpnTpCd() {
		 return	this.agnExpnTpCd;
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
	* @param  glDt
	*/
	public void	setGlDt( String	glDt ) {
		this.glDt =	glDt;
	}
 
	/**
	 * Column Info
	 * @return	glDt
	 */
	 public	 String	getGlDt() {
		 return	this.glDt;
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
	* @param  usdXchRt
	*/
	public void	setUsdXchRt( String	usdXchRt ) {
		this.usdXchRt =	usdXchRt;
	}
 
	/**
	 * Column Info
	 * @return	usdXchRt
	 */
	 public	 String	getUsdXchRt() {
		 return	this.usdXchRt;
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
	* @param  bkgIoBndCd
	*/
	public void	setBkgIoBndCd( String	bkgIoBndCd ) {
		this.bkgIoBndCd =	bkgIoBndCd;
	}
 
	/**
	 * Column Info
	 * @return	bkgIoBndCd
	 */
	 public	 String	getBkgIoBndCd() {
		 return	this.bkgIoBndCd;
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
	* @param  otsHisTpCd
	*/
	public void	setOtsHisTpCd( String	otsHisTpCd ) {
		this.otsHisTpCd =	otsHisTpCd;
	}
 
	/**
	 * Column Info
	 * @return	otsHisTpCd
	 */
	 public	 String	getOtsHisTpCd() {
		 return	this.otsHisTpCd;
	 } 
 	/**
	* Column Info
	* @param  dirCd
	*/
	public void	setDirCd( String	dirCd ) {
		this.dirCd =	dirCd;
	}
 
	/**
	 * Column Info
	 * @return	dirCd
	 */
	 public	 String	getDirCd() {
		 return	this.dirCd;
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
	* @param  otsHisSeq
	*/
	public void	setOtsHisSeq( String	otsHisSeq ) {
		this.otsHisSeq =	otsHisSeq;
	}
 
	/**
	 * Column Info
	 * @return	otsHisSeq
	 */
	 public	 String	getOtsHisSeq() {
		 return	this.otsHisSeq;
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
	* @param  loclXchRt
	*/
	public void	setLoclXchRt( String	loclXchRt ) {
		this.loclXchRt =	loclXchRt;
	}
 
	/**
	 * Column Info
	 * @return	loclXchRt
	 */
	 public	 String	getLoclXchRt() {
		 return	this.loclXchRt;
	 } 
 	/**
	* Column Info
	* @param  ifNo
	*/
	public void	setIfNo( String	ifNo ) {
		this.ifNo =	ifNo;
	}
 
	/**
	 * Column Info
	 * @return	ifNo
	 */
	 public	 String	getIfNo() {
		 return	this.ifNo;
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
	* @param  usdAmt
	*/
	public void	setUsdAmt( String	usdAmt ) {
		this.usdAmt =	usdAmt;
	}
 
	/**
	 * Column Info
	 * @return	usdAmt
	 */
	 public	 String	getUsdAmt() {
		 return	this.usdAmt;
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
	* @param  otsAmt
	*/
	public void	setOtsAmt( String	otsAmt ) {
		this.otsAmt =	otsAmt;
	}
 
	/**
	 * Column Info
	 * @return	otsAmt
	 */
	 public	 String	getOtsAmt() {
		 return	this.otsAmt;
	 } 
 	/**
	* Column Info
	* @param  refNo
	*/
	public void	setRefNo( String	refNo ) {
		this.refNo =	refNo;
	}
 
	/**
	 * Column Info
	 * @return	refNo
	 */
	 public	 String	getRefNo() {
		 return	this.refNo;
	 } 
 	/**
	* Column Info
	* @param  revVvdCd
	*/
	public void	setRevVvdCd( String	revVvdCd ) {
		this.revVvdCd =	revVvdCd;
	}
 
	/**
	 * Column Info
	 * @return	revVvdCd
	 */
	 public	 String	getRevVvdCd() {
		 return	this.revVvdCd;
	 } 
 	/**
	* Column Info
	* @param  revTpSrcCd
	*/
	public void	setRevTpSrcCd( String	revTpSrcCd ) {
		this.revTpSrcCd =	revTpSrcCd;
	}
 
	/**
	 * Column Info
	 * @return	revTpSrcCd
	 */
	 public	 String	getRevTpSrcCd() {
		 return	this.revTpSrcCd;
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
	* @param  invCurrCd
	*/
	public void	setInvCurrCd( String	invCurrCd ) {
		this.invCurrCd =	invCurrCd;
	}
 
	/**
	 * Column Info
	 * @return	invCurrCd
	 */
	 public	 String	getInvCurrCd() {
		 return	this.invCurrCd;
	 } 
 	/**
	* Column Info
	* @param  invLoclXchRt
	*/
	public void	setInvLoclXchRt( String	invLoclXchRt ) {
		this.invLoclXchRt =	invLoclXchRt;
	}
 
	/**
	 * Column Info
	 * @return	invLoclXchRt
	 */
	 public	 String	getInvLoclXchRt() {
		 return	this.invLoclXchRt;
	 } 
 	/**
	* Column Info
	* @param  invUsdXchRt
	*/
	public void	setInvUsdXchRt( String	invUsdXchRt ) {
		this.invUsdXchRt =	invUsdXchRt;
	}
 
	/**
	 * Column Info
	 * @return	invUsdXchRt
	 */
	 public	 String	getInvUsdXchRt() {
		 return	this.invUsdXchRt;
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
		setIfDt(JSPUtil.getParameter(request,	prefix + "if_dt", ""));
		setAgnExpnTpCd(JSPUtil.getParameter(request,	prefix + "agn_expn_tp_cd", ""));
		setXchRtTpCd(JSPUtil.getParameter(request,	prefix + "xch_rt_tp_cd", ""));
		setVslCd(JSPUtil.getParameter(request,	prefix + "vsl_cd", ""));
		setGlDt(JSPUtil.getParameter(request,	prefix + "gl_dt", ""));
		setCurrCd(JSPUtil.getParameter(request,	prefix + "curr_cd", ""));
		setBilToCustCntCd(JSPUtil.getParameter(request,	prefix + "bil_to_cust_cnt_cd", ""));
		setSvcScpCd(JSPUtil.getParameter(request,	prefix + "svc_scp_cd", ""));
		setUsdXchRt(JSPUtil.getParameter(request,	prefix + "usd_xch_rt", ""));
		setCreDt(JSPUtil.getParameter(request,	prefix + "cre_dt", ""));
		setBkgIoBndCd(JSPUtil.getParameter(request,	prefix + "bkg_io_bnd_cd", ""));
		setBlNo(JSPUtil.getParameter(request,	prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request,	prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setOtsHisTpCd(JSPUtil.getParameter(request,	prefix + "ots_his_tp_cd", ""));
		setDirCd(JSPUtil.getParameter(request,	prefix + "dir_cd", ""));
		setOtsSrcCd(JSPUtil.getParameter(request,	prefix + "ots_src_cd", ""));
		setOtsHisSeq(JSPUtil.getParameter(request,	prefix + "ots_his_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setInvOfcCd(JSPUtil.getParameter(request,	prefix + "inv_ofc_cd", ""));
		setUpdDt(JSPUtil.getParameter(request,	prefix + "upd_dt", ""));
		setLoclXchRt(JSPUtil.getParameter(request,	prefix + "locl_xch_rt", ""));
		setIfNo(JSPUtil.getParameter(request,	prefix + "if_no", ""));
		setShpToCustSeq(JSPUtil.getParameter(request,	prefix + "shp_to_cust_seq", ""));
		setRhqCd(JSPUtil.getParameter(request,	prefix + "rhq_cd", ""));
		setBilToCustSeq(JSPUtil.getParameter(request,	prefix + "bil_to_cust_seq", ""));
		setSkdVoyNo(JSPUtil.getParameter(request,	prefix + "skd_voy_no", ""));
		setPodCd(JSPUtil.getParameter(request,	prefix + "pod_cd", ""));
		setInvNo(JSPUtil.getParameter(request,	prefix + "inv_no", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setUsdAmt(JSPUtil.getParameter(request,	prefix + "usd_amt", ""));
		setOtsRmk(JSPUtil.getParameter(request,	prefix + "ots_rmk", ""));
		setOtsOfcCd(JSPUtil.getParameter(request,	prefix + "ots_ofc_cd", ""));
		setShpToCustCntCd(JSPUtil.getParameter(request,	prefix + "shp_to_cust_cnt_cd", ""));
		setOtsAmt(JSPUtil.getParameter(request,	prefix + "ots_amt", ""));
		setRefNo(JSPUtil.getParameter(request,	prefix + "ref_no", ""));
		setRevVvdCd(JSPUtil.getParameter(request,	prefix + "rev_vvd_cd", ""));
		setRevTpSrcCd(JSPUtil.getParameter(request,	prefix + "rev_tp_src_cd", ""));
		setSailDt(JSPUtil.getParameter(request,	prefix + "sail_dt", ""));
		setInvCurrCd(JSPUtil.getParameter(request,	prefix + "inv_curr_cd", ""));
		setInvLoclXchRt(JSPUtil.getParameter(request,	prefix + "inv_locl_xch_rt", ""));
		setInvUsdXchRt(JSPUtil.getParameter(request,	prefix + "inv_usd_xch_rt", ""));
	}
	
	/**
	 * Request ���곗씠�곕� VO 諛곗뿴濡�蹂�솚�섏뿬 諛섑솚.
	 * @param request
	 * @return AROutstandingHistVO[]
	 */
	public AROutstandingHistVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request �섏뼱���щ윭 嫄�DATA瑜�VO Class ���대뒗��
	 * @param request
	 * @param prefix
	 * @return AROutstandingHistVO[]
	 */
	public AROutstandingHistVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		AROutstandingHistVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] xchRtDt =	(JSPUtil.getParameter(request, prefix +	"xch_rt_dt".trim(),	length));
				String[] ifDt =	(JSPUtil.getParameter(request, prefix +	"if_dt".trim(),	length));
				String[] agnExpnTpCd =	(JSPUtil.getParameter(request, prefix +	"agn_expn_tp_cd".trim(),	length));
				String[] xchRtTpCd =	(JSPUtil.getParameter(request, prefix +	"xch_rt_tp_cd".trim(),	length));
				String[] vslCd =	(JSPUtil.getParameter(request, prefix +	"vsl_cd".trim(),	length));
				String[] glDt =	(JSPUtil.getParameter(request, prefix +	"gl_dt".trim(),	length));
				String[] currCd =	(JSPUtil.getParameter(request, prefix +	"curr_cd".trim(),	length));
				String[] bilToCustCntCd =	(JSPUtil.getParameter(request, prefix +	"bil_to_cust_cnt_cd".trim(),	length));
				String[] svcScpCd =	(JSPUtil.getParameter(request, prefix +	"svc_scp_cd".trim(),	length));
				String[] usdXchRt =	(JSPUtil.getParameter(request, prefix +	"usd_xch_rt".trim(),	length));
				String[] creDt =	(JSPUtil.getParameter(request, prefix +	"cre_dt".trim(),	length));
				String[] bkgIoBndCd =	(JSPUtil.getParameter(request, prefix +	"bkg_io_bnd_cd".trim(),	length));
				String[] blNo =	(JSPUtil.getParameter(request, prefix +	"bl_no".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] polCd =	(JSPUtil.getParameter(request, prefix +	"pol_cd".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] otsHisTpCd =	(JSPUtil.getParameter(request, prefix +	"ots_his_tp_cd".trim(),	length));
				String[] dirCd =	(JSPUtil.getParameter(request, prefix +	"dir_cd".trim(),	length));
				String[] otsSrcCd =	(JSPUtil.getParameter(request, prefix +	"ots_src_cd".trim(),	length));
				String[] otsHisSeq =	(JSPUtil.getParameter(request, prefix +	"ots_his_seq".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] invOfcCd =	(JSPUtil.getParameter(request, prefix +	"inv_ofc_cd".trim(),	length));
				String[] updDt =	(JSPUtil.getParameter(request, prefix +	"upd_dt".trim(),	length));
				String[] loclXchRt =	(JSPUtil.getParameter(request, prefix +	"locl_xch_rt".trim(),	length));
				String[] ifNo =	(JSPUtil.getParameter(request, prefix +	"if_no".trim(),	length));
				String[] shpToCustSeq =	(JSPUtil.getParameter(request, prefix +	"shp_to_cust_seq".trim(),	length));
				String[] rhqCd =	(JSPUtil.getParameter(request, prefix +	"rhq_cd".trim(),	length));
				String[] bilToCustSeq =	(JSPUtil.getParameter(request, prefix +	"bil_to_cust_seq".trim(),	length));
				String[] skdVoyNo =	(JSPUtil.getParameter(request, prefix +	"skd_voy_no".trim(),	length));
				String[] podCd =	(JSPUtil.getParameter(request, prefix +	"pod_cd".trim(),	length));
				String[] invNo =	(JSPUtil.getParameter(request, prefix +	"inv_no".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				String[] usdAmt =	(JSPUtil.getParameter(request, prefix +	"usd_amt".trim(),	length));
				String[] otsRmk =	(JSPUtil.getParameter(request, prefix +	"ots_rmk".trim(),	length));
				String[] otsOfcCd =	(JSPUtil.getParameter(request, prefix +	"ots_ofc_cd".trim(),	length));
				String[] shpToCustCntCd =	(JSPUtil.getParameter(request, prefix +	"shp_to_cust_cnt_cd".trim(),	length));
				String[] otsAmt =	(JSPUtil.getParameter(request, prefix +	"ots_amt".trim(),	length));
				String[] refNo =	(JSPUtil.getParameter(request, prefix +	"ref_no".trim(),	length));
				String[] revVvdCd =	(JSPUtil.getParameter(request, prefix +	"rev_vvd_cd".trim(),	length));
				String[] revTpSrcCd =	(JSPUtil.getParameter(request, prefix +	"rev_tp_src_cd".trim(),	length));
				String[] sailDt =	(JSPUtil.getParameter(request, prefix +	"sail_dt".trim(),	length));
				String[] invCurrCd =	(JSPUtil.getParameter(request, prefix +	"inv_curr_cd".trim(),	length));
				String[] invLoclXchRt =	(JSPUtil.getParameter(request, prefix +	"inv_locl_xch_rt".trim(),	length));
				String[] invUsdXchRt =	(JSPUtil.getParameter(request, prefix +	"inv_usd_xch_rt".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	AROutstandingHistVO();
						if ( xchRtDt[i] !=	null)
						model.setXchRtDt( xchRtDt[i]);
						if ( ifDt[i] !=	null)
						model.setIfDt( ifDt[i]);
						if ( agnExpnTpCd[i] !=	null)
						model.setAgnExpnTpCd( agnExpnTpCd[i]);
						if ( xchRtTpCd[i] !=	null)
						model.setXchRtTpCd( xchRtTpCd[i]);
						if ( vslCd[i] !=	null)
						model.setVslCd( vslCd[i]);
						if ( glDt[i] !=	null)
						model.setGlDt( glDt[i]);
						if ( currCd[i] !=	null)
						model.setCurrCd( currCd[i]);
						if ( bilToCustCntCd[i] !=	null)
						model.setBilToCustCntCd( bilToCustCntCd[i]);
						if ( svcScpCd[i] !=	null)
						model.setSvcScpCd( svcScpCd[i]);
						if ( usdXchRt[i] !=	null)
						model.setUsdXchRt( usdXchRt[i]);
						if ( creDt[i] !=	null)
						model.setCreDt( creDt[i]);
						if ( bkgIoBndCd[i] !=	null)
						model.setBkgIoBndCd( bkgIoBndCd[i]);
						if ( blNo[i] !=	null)
						model.setBlNo( blNo[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( polCd[i] !=	null)
						model.setPolCd( polCd[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( otsHisTpCd[i] !=	null)
						model.setOtsHisTpCd( otsHisTpCd[i]);
						if ( dirCd[i] !=	null)
						model.setDirCd( dirCd[i]);
						if ( otsSrcCd[i] !=	null)
						model.setOtsSrcCd( otsSrcCd[i]);
						if ( otsHisSeq[i] !=	null)
						model.setOtsHisSeq( otsHisSeq[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( invOfcCd[i] !=	null)
						model.setInvOfcCd( invOfcCd[i]);
						if ( updDt[i] !=	null)
						model.setUpdDt( updDt[i]);
						if ( loclXchRt[i] !=	null)
						model.setLoclXchRt( loclXchRt[i]);
						if ( ifNo[i] !=	null)
						model.setIfNo( ifNo[i]);
						if ( shpToCustSeq[i] !=	null)
						model.setShpToCustSeq( shpToCustSeq[i]);
						if ( rhqCd[i] !=	null)
						model.setRhqCd( rhqCd[i]);
						if ( bilToCustSeq[i] !=	null)
						model.setBilToCustSeq( bilToCustSeq[i]);
						if ( skdVoyNo[i] !=	null)
						model.setSkdVoyNo( skdVoyNo[i]);
						if ( podCd[i] !=	null)
						model.setPodCd( podCd[i]);
						if ( invNo[i] !=	null)
						model.setInvNo( invNo[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
						if ( usdAmt[i] !=	null)
						model.setUsdAmt( usdAmt[i]);
						if ( otsRmk[i] !=	null)
						model.setOtsRmk( otsRmk[i]);
						if ( otsOfcCd[i] !=	null)
						model.setOtsOfcCd( otsOfcCd[i]);
						if ( shpToCustCntCd[i] !=	null)
						model.setShpToCustCntCd( shpToCustCntCd[i]);
						if ( otsAmt[i] !=	null)
						model.setOtsAmt( otsAmt[i]);
						if ( refNo[i] !=	null)
						model.setRefNo( refNo[i]);
						if ( revVvdCd[i] !=	null)
						model.setRevVvdCd( revVvdCd[i]);
						if ( revTpSrcCd[i] !=	null)
						model.setRevTpSrcCd( revTpSrcCd[i]);
						if ( sailDt[i] !=	null)
						model.setSailDt( sailDt[i]);
						if ( invCurrCd[i] !=	null)
						model.setInvCurrCd( invCurrCd[i]);
						if ( invLoclXchRt[i] !=	null)
						model.setInvLoclXchRt( invLoclXchRt[i]);
						if ( invUsdXchRt[i] !=	null)
						model.setInvUsdXchRt( invUsdXchRt[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getAROutstandingHistVOs();
	}

	/**
	 *  VO 諛곗뿴��諛섑솚
	 * @return AROutstandingHistVO[]
	 */
	public AROutstandingHistVO[]	 getAROutstandingHistVOs(){
		AROutstandingHistVO[] vos = (AROutstandingHistVO[])models.toArray(new	AROutstandingHistVO[models.size()]);
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
		this.ifDt =	this.ifDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnExpnTpCd =	this.agnExpnTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRtTpCd =	this.xchRtTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd =	this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glDt =	this.glDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd =	this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilToCustCntCd =	this.bilToCustCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd =	this.svcScpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdXchRt =	this.usdXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt =	this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgIoBndCd =	this.bkgIoBndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo =	this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd =	this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsHisTpCd =	this.otsHisTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd =	this.dirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsSrcCd =	this.otsSrcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsHisSeq =	this.otsHisSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invOfcCd =	this.invOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt =	this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclXchRt =	this.loclXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifNo =	this.ifNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpToCustSeq =	this.shpToCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd =	this.rhqCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilToCustSeq =	this.bilToCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo =	this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd =	this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo =	this.invNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdAmt =	this.usdAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsRmk =	this.otsRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsOfcCd =	this.otsOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpToCustCntCd =	this.shpToCustCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsAmt =	this.otsAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refNo =	this.refNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revVvdCd =	this.revVvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revTpSrcCd =	this.revTpSrcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailDt =	this.sailDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCurrCd =	this.invCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invLoclXchRt =	this.invLoclXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invUsdXchRt =	this.invUsdXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}