/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : SarOtsRctTmpVO.java
 *@FileTitle : SarOtsRctTmpVO
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
public class SarOtsRctTmpVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<SarOtsRctTmpVO>  models =	new	ArrayList<SarOtsRctTmpVO>();


	/*	Column Info	*/
	private  String	 xchRtDt   =  null;
	/*	Column Info	*/
	private  String	 xchRtTpCd   =  null;
	/*	Column Info	*/
	private  String	 bilToCustCntCd   =  null;
	/*	Column Info	*/
	private  String	 creDt   =  null;
	/*	Column Info	*/
	private  String	 arFincSrcCd   =  null;
	/*	Column Info	*/
	private  String	 blNo   =  null;
	/*	Column Info	*/
	private  String	 sailArrDt   =  null;
	/*	Column Info	*/
	private  String	 srepCd   =  null;
	/*	Column Info	*/
	private  String	 otsBalAmt   =  null;
	/*	Column Info	*/
	private  String	 rctAplyChgCd   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 dpPrcsKnt   =  null;
	/*	Column Info	*/
	private  String	 rctCurrCd   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 rctAplyAmt   =  null;
	/*	Column Info	*/
	private  String	 otsRctTmpSeq   =  null;
	/*	Column Info	*/
	private  String	 rctAplySrcCurrCd   =  null;
	/*	Column Info	*/
	private  String	 dueDt   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 invDt   =  null;
	/*	Column Info	*/
	private  String	 updDt   =  null;
	/*	Column Info	*/
	private  String	 rhqCd   =  null;
	/*	Column Info	*/
	private  String	 otsAplyAmt   =  null;
	/*	Column Info	*/
	private  String	 loclVvdCd   =  null;
	/*	Column Info	*/
	private  String	 trnkVvdCd   =  null;
	/*	Column Info	*/
	private  String	 rctAplyHdrSeq   =  null;
	/*	Column Info	*/
	private  String	 bilToCustSeq   =  null;
	/*	Column Info	*/
	private  String	 ioBndCd   =  null;
	/*	Column Info	*/
	private  String	 crFlg   =  null;
	/*	Column Info	*/
	private  String	 rctAplyXchRt   =  null;
	/*	Column Info	*/
	private  String	 invNo   =  null;
	/*	Column Info	*/
	private  String	 ofcCd   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;
	/*	Column Info	*/
	private  String	 bkgNo   =  null;
	/*	Column Info	*/
	private  String	 otsRmk   =  null;
	/*	Column Info	*/
	private  String	 maxArIfNo   =  null;
	/*	Column Info	*/
	private  String	 otsOfcCd   =  null;
	/*	Column Info	*/
	private  String	 rctAplyFlg   =  null;
	/*	Column Info	*/
	private  String	 otsXchRt   =  null;
	/*	Column Info	*/
	private  String	 hdrDupFlg   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public SarOtsRctTmpVO(){}

	public SarOtsRctTmpVO(String xchRtDt,String xchRtTpCd,String bilToCustCntCd,String creDt,String arFincSrcCd,String blNo,String sailArrDt,String srepCd,String otsBalAmt,String rctAplyChgCd,String pagerows,String dpPrcsKnt,String rctCurrCd,String ibflag,String rctAplyAmt,String otsRctTmpSeq,String rctAplySrcCurrCd,String dueDt,String updUsrId,String invDt,String updDt,String rhqCd,String otsAplyAmt,String loclVvdCd,String trnkVvdCd,String rctAplyHdrSeq,String bilToCustSeq,String ioBndCd,String crFlg,String rctAplyXchRt,String invNo,String ofcCd,String creUsrId,String bkgNo,String otsRmk,String maxArIfNo,String otsOfcCd,String rctAplyFlg,String otsXchRt,String hdrDupFlg)	{
		this.xchRtDt  = xchRtDt ;
		this.xchRtTpCd  = xchRtTpCd ;
		this.bilToCustCntCd  = bilToCustCntCd ;
		this.creDt  = creDt ;
		this.arFincSrcCd  = arFincSrcCd ;
		this.blNo  = blNo ;
		this.sailArrDt  = sailArrDt ;
		this.srepCd  = srepCd ;
		this.otsBalAmt  = otsBalAmt ;
		this.rctAplyChgCd  = rctAplyChgCd ;
		this.pagerows  = pagerows ;
		this.dpPrcsKnt  = dpPrcsKnt ;
		this.rctCurrCd  = rctCurrCd ;
		this.ibflag  = ibflag ;
		this.rctAplyAmt  = rctAplyAmt ;
		this.otsRctTmpSeq  = otsRctTmpSeq ;
		this.rctAplySrcCurrCd  = rctAplySrcCurrCd ;
		this.dueDt  = dueDt ;
		this.updUsrId  = updUsrId ;
		this.invDt  = invDt ;
		this.updDt  = updDt ;
		this.rhqCd  = rhqCd ;
		this.otsAplyAmt  = otsAplyAmt ;
		this.loclVvdCd  = loclVvdCd ;
		this.trnkVvdCd  = trnkVvdCd ;
		this.rctAplyHdrSeq  = rctAplyHdrSeq ;
		this.bilToCustSeq  = bilToCustSeq ;
		this.ioBndCd  = ioBndCd ;
		this.crFlg  = crFlg ;
		this.rctAplyXchRt  = rctAplyXchRt ;
		this.invNo  = invNo ;
		this.ofcCd  = ofcCd ;
		this.creUsrId  = creUsrId ;
		this.bkgNo  = bkgNo ;
		this.otsRmk  = otsRmk ;
		this.maxArIfNo  = maxArIfNo ;
		this.otsOfcCd  = otsOfcCd ;
		this.rctAplyFlg  = rctAplyFlg ;
		this.otsXchRt  = otsXchRt ;
		this.hdrDupFlg  = hdrDupFlg ;
	}


	/**
	 * �뚯씠釉�而щ읆����옣��媛믪쓣 Hashtable<"column_name", "value">	濡�諛섑솚
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("xch_rt_dt", getXchRtDt());		
		this.hashColumns.put("xch_rt_tp_cd", getXchRtTpCd());		
		this.hashColumns.put("bil_to_cust_cnt_cd", getBilToCustCntCd());		
		this.hashColumns.put("cre_dt", getCreDt());		
		this.hashColumns.put("ar_finc_src_cd", getArFincSrcCd());		
		this.hashColumns.put("bl_no", getBlNo());		
		this.hashColumns.put("sail_arr_dt", getSailArrDt());		
		this.hashColumns.put("srep_cd", getSrepCd());		
		this.hashColumns.put("ots_bal_amt", getOtsBalAmt());		
		this.hashColumns.put("rct_aply_chg_cd", getRctAplyChgCd());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("dp_prcs_knt", getDpPrcsKnt());		
		this.hashColumns.put("rct_curr_cd", getRctCurrCd());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("rct_aply_amt", getRctAplyAmt());		
		this.hashColumns.put("ots_rct_tmp_seq", getOtsRctTmpSeq());		
		this.hashColumns.put("rct_aply_src_curr_cd", getRctAplySrcCurrCd());		
		this.hashColumns.put("due_dt", getDueDt());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("inv_dt", getInvDt());		
		this.hashColumns.put("upd_dt", getUpdDt());		
		this.hashColumns.put("rhq_cd", getRhqCd());		
		this.hashColumns.put("ots_aply_amt", getOtsAplyAmt());		
		this.hashColumns.put("locl_vvd_cd", getLoclVvdCd());		
		this.hashColumns.put("trnk_vvd_cd", getTrnkVvdCd());		
		this.hashColumns.put("rct_aply_hdr_seq", getRctAplyHdrSeq());		
		this.hashColumns.put("bil_to_cust_seq", getBilToCustSeq());		
		this.hashColumns.put("io_bnd_cd", getIoBndCd());		
		this.hashColumns.put("cr_flg", getCrFlg());		
		this.hashColumns.put("rct_aply_xch_rt", getRctAplyXchRt());		
		this.hashColumns.put("inv_no", getInvNo());		
		this.hashColumns.put("ofc_cd", getOfcCd());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("bkg_no", getBkgNo());		
		this.hashColumns.put("ots_rmk", getOtsRmk());		
		this.hashColumns.put("max_ar_if_no", getMaxArIfNo());		
		this.hashColumns.put("ots_ofc_cd", getOtsOfcCd());		
		this.hashColumns.put("rct_aply_flg", getRctAplyFlg());		
		this.hashColumns.put("ots_xch_rt", getOtsXchRt());		
		this.hashColumns.put("hdr_dup_flg", getHdrDupFlg());		
		return this.hashColumns;
}

	/**
	 * 而щ읆紐낆뿉	��쓳�섎뒗 硫ㅻ쾭蹂�닔紐낆쓣	��옣�섏뿬 Hashtable<"column_name", "variable"> 濡�諛섑솚
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("xch_rt_dt", "xchRtDt");
		this.hashFields.put("xch_rt_tp_cd", "xchRtTpCd");
		this.hashFields.put("bil_to_cust_cnt_cd", "bilToCustCntCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("ar_finc_src_cd", "arFincSrcCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("sail_arr_dt", "sailArrDt");
		this.hashFields.put("srep_cd", "srepCd");
		this.hashFields.put("ots_bal_amt", "otsBalAmt");
		this.hashFields.put("rct_aply_chg_cd", "rctAplyChgCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dp_prcs_knt", "dpPrcsKnt");
		this.hashFields.put("rct_curr_cd", "rctCurrCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rct_aply_amt", "rctAplyAmt");
		this.hashFields.put("ots_rct_tmp_seq", "otsRctTmpSeq");
		this.hashFields.put("rct_aply_src_curr_cd", "rctAplySrcCurrCd");
		this.hashFields.put("due_dt", "dueDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("inv_dt", "invDt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("ots_aply_amt", "otsAplyAmt");
		this.hashFields.put("locl_vvd_cd", "loclVvdCd");
		this.hashFields.put("trnk_vvd_cd", "trnkVvdCd");
		this.hashFields.put("rct_aply_hdr_seq", "rctAplyHdrSeq");
		this.hashFields.put("bil_to_cust_seq", "bilToCustSeq");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("cr_flg", "crFlg");
		this.hashFields.put("rct_aply_xch_rt", "rctAplyXchRt");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ots_rmk", "otsRmk");
		this.hashFields.put("max_ar_if_no", "maxArIfNo");
		this.hashFields.put("ots_ofc_cd", "otsOfcCd");
		this.hashFields.put("rct_aply_flg", "rctAplyFlg");
		this.hashFields.put("ots_xch_rt", "otsXchRt");
		this.hashFields.put("hdr_dup_flg", "hdrDupFlg");
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
		setXchRtDt(JSPUtil.getParameter(request,	prefix + "xch_rt_dt", ""));
		setXchRtTpCd(JSPUtil.getParameter(request,	prefix + "xch_rt_tp_cd", ""));
		setBilToCustCntCd(JSPUtil.getParameter(request,	prefix + "bil_to_cust_cnt_cd", ""));
		setCreDt(JSPUtil.getParameter(request,	prefix + "cre_dt", ""));
		setArFincSrcCd(JSPUtil.getParameter(request,	prefix + "ar_finc_src_cd", ""));
		setBlNo(JSPUtil.getParameter(request,	prefix + "bl_no", ""));
		setSailArrDt(JSPUtil.getParameter(request,	prefix + "sail_arr_dt", ""));
		setSrepCd(JSPUtil.getParameter(request,	prefix + "srep_cd", ""));
		setOtsBalAmt(JSPUtil.getParameter(request,	prefix + "ots_bal_amt", ""));
		setRctAplyChgCd(JSPUtil.getParameter(request,	prefix + "rct_aply_chg_cd", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setDpPrcsKnt(JSPUtil.getParameter(request,	prefix + "dp_prcs_knt", ""));
		setRctCurrCd(JSPUtil.getParameter(request,	prefix + "rct_curr_cd", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setRctAplyAmt(JSPUtil.getParameter(request,	prefix + "rct_aply_amt", ""));
		setOtsRctTmpSeq(JSPUtil.getParameter(request,	prefix + "ots_rct_tmp_seq", ""));
		setRctAplySrcCurrCd(JSPUtil.getParameter(request,	prefix + "rct_aply_src_curr_cd", ""));
		setDueDt(JSPUtil.getParameter(request,	prefix + "due_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setInvDt(JSPUtil.getParameter(request,	prefix + "inv_dt", ""));
		setUpdDt(JSPUtil.getParameter(request,	prefix + "upd_dt", ""));
		setRhqCd(JSPUtil.getParameter(request,	prefix + "rhq_cd", ""));
		setOtsAplyAmt(JSPUtil.getParameter(request,	prefix + "ots_aply_amt", ""));
		setLoclVvdCd(JSPUtil.getParameter(request,	prefix + "locl_vvd_cd", ""));
		setTrnkVvdCd(JSPUtil.getParameter(request,	prefix + "trnk_vvd_cd", ""));
		setRctAplyHdrSeq(JSPUtil.getParameter(request,	prefix + "rct_aply_hdr_seq", ""));
		setBilToCustSeq(JSPUtil.getParameter(request,	prefix + "bil_to_cust_seq", ""));
		setIoBndCd(JSPUtil.getParameter(request,	prefix + "io_bnd_cd", ""));
		setCrFlg(JSPUtil.getParameter(request,	prefix + "cr_flg", ""));
		setRctAplyXchRt(JSPUtil.getParameter(request,	prefix + "rct_aply_xch_rt", ""));
		setInvNo(JSPUtil.getParameter(request,	prefix + "inv_no", ""));
		setOfcCd(JSPUtil.getParameter(request,	prefix + "ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setBkgNo(JSPUtil.getParameter(request,	prefix + "bkg_no", ""));
		setOtsRmk(JSPUtil.getParameter(request,	prefix + "ots_rmk", ""));
		setMaxArIfNo(JSPUtil.getParameter(request,	prefix + "max_ar_if_no", ""));
		setOtsOfcCd(JSPUtil.getParameter(request,	prefix + "ots_ofc_cd", ""));
		setRctAplyFlg(JSPUtil.getParameter(request,	prefix + "rct_aply_flg", ""));
		setOtsXchRt(JSPUtil.getParameter(request,	prefix + "ots_xch_rt", ""));
		setHdrDupFlg(JSPUtil.getParameter(request,	prefix + "hdr_dup_flg", ""));
	}
	
	/**
	 * Request ���곗씠�곕� VO 諛곗뿴濡�蹂�솚�섏뿬 諛섑솚.
	 * @param request
	 * @return SarOtsRctTmpVO[]
	 */
	public SarOtsRctTmpVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request �섏뼱���щ윭 嫄�DATA瑜�VO Class ���대뒗��
	 * @param request
	 * @param prefix
	 * @return SarOtsRctTmpVO[]
	 */
	public SarOtsRctTmpVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		SarOtsRctTmpVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] xchRtDt =	(JSPUtil.getParameter(request, prefix +	"xch_rt_dt".trim(),	length));
				String[] xchRtTpCd =	(JSPUtil.getParameter(request, prefix +	"xch_rt_tp_cd".trim(),	length));
				String[] bilToCustCntCd =	(JSPUtil.getParameter(request, prefix +	"bil_to_cust_cnt_cd".trim(),	length));
				String[] creDt =	(JSPUtil.getParameter(request, prefix +	"cre_dt".trim(),	length));
				String[] arFincSrcCd =	(JSPUtil.getParameter(request, prefix +	"ar_finc_src_cd".trim(),	length));
				String[] blNo =	(JSPUtil.getParameter(request, prefix +	"bl_no".trim(),	length));
				String[] sailArrDt =	(JSPUtil.getParameter(request, prefix +	"sail_arr_dt".trim(),	length));
				String[] srepCd =	(JSPUtil.getParameter(request, prefix +	"srep_cd".trim(),	length));
				String[] otsBalAmt =	(JSPUtil.getParameter(request, prefix +	"ots_bal_amt".trim(),	length));
				String[] rctAplyChgCd =	(JSPUtil.getParameter(request, prefix +	"rct_aply_chg_cd".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] dpPrcsKnt =	(JSPUtil.getParameter(request, prefix +	"dp_prcs_knt".trim(),	length));
				String[] rctCurrCd =	(JSPUtil.getParameter(request, prefix +	"rct_curr_cd".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] rctAplyAmt =	(JSPUtil.getParameter(request, prefix +	"rct_aply_amt".trim(),	length));
				String[] otsRctTmpSeq =	(JSPUtil.getParameter(request, prefix +	"ots_rct_tmp_seq".trim(),	length));
				String[] rctAplySrcCurrCd =	(JSPUtil.getParameter(request, prefix +	"rct_aply_src_curr_cd".trim(),	length));
				String[] dueDt =	(JSPUtil.getParameter(request, prefix +	"due_dt".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] invDt =	(JSPUtil.getParameter(request, prefix +	"inv_dt".trim(),	length));
				String[] updDt =	(JSPUtil.getParameter(request, prefix +	"upd_dt".trim(),	length));
				String[] rhqCd =	(JSPUtil.getParameter(request, prefix +	"rhq_cd".trim(),	length));
				String[] otsAplyAmt =	(JSPUtil.getParameter(request, prefix +	"ots_aply_amt".trim(),	length));
				String[] loclVvdCd =	(JSPUtil.getParameter(request, prefix +	"locl_vvd_cd".trim(),	length));
				String[] trnkVvdCd =	(JSPUtil.getParameter(request, prefix +	"trnk_vvd_cd".trim(),	length));
				String[] rctAplyHdrSeq =	(JSPUtil.getParameter(request, prefix +	"rct_aply_hdr_seq".trim(),	length));
				String[] bilToCustSeq =	(JSPUtil.getParameter(request, prefix +	"bil_to_cust_seq".trim(),	length));
				String[] ioBndCd =	(JSPUtil.getParameter(request, prefix +	"io_bnd_cd".trim(),	length));
				String[] crFlg =	(JSPUtil.getParameter(request, prefix +	"cr_flg".trim(),	length));
				String[] rctAplyXchRt =	(JSPUtil.getParameter(request, prefix +	"rct_aply_xch_rt".trim(),	length));
				String[] invNo =	(JSPUtil.getParameter(request, prefix +	"inv_no".trim(),	length));
				String[] ofcCd =	(JSPUtil.getParameter(request, prefix +	"ofc_cd".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				String[] bkgNo =	(JSPUtil.getParameter(request, prefix +	"bkg_no".trim(),	length));
				String[] otsRmk =	(JSPUtil.getParameter(request, prefix +	"ots_rmk".trim(),	length));
				String[] maxArIfNo =	(JSPUtil.getParameter(request, prefix +	"max_ar_if_no".trim(),	length));
				String[] otsOfcCd =	(JSPUtil.getParameter(request, prefix +	"ots_ofc_cd".trim(),	length));
				String[] rctAplyFlg =	(JSPUtil.getParameter(request, prefix +	"rct_aply_flg".trim(),	length));
				String[] otsXchRt =	(JSPUtil.getParameter(request, prefix +	"ots_xch_rt".trim(),	length));
				String[] hdrDupFlg =	(JSPUtil.getParameter(request, prefix +	"hdr_dup_flg".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	SarOtsRctTmpVO();
						if ( xchRtDt[i] !=	null)
						model.setXchRtDt( xchRtDt[i]);
						if ( xchRtTpCd[i] !=	null)
						model.setXchRtTpCd( xchRtTpCd[i]);
						if ( bilToCustCntCd[i] !=	null)
						model.setBilToCustCntCd( bilToCustCntCd[i]);
						if ( creDt[i] !=	null)
						model.setCreDt( creDt[i]);
						if ( arFincSrcCd[i] !=	null)
						model.setArFincSrcCd( arFincSrcCd[i]);
						if ( blNo[i] !=	null)
						model.setBlNo( blNo[i]);
						if ( sailArrDt[i] !=	null)
						model.setSailArrDt( sailArrDt[i]);
						if ( srepCd[i] !=	null)
						model.setSrepCd( srepCd[i]);
						if ( otsBalAmt[i] !=	null)
						model.setOtsBalAmt( otsBalAmt[i]);
						if ( rctAplyChgCd[i] !=	null)
						model.setRctAplyChgCd( rctAplyChgCd[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( dpPrcsKnt[i] !=	null)
						model.setDpPrcsKnt( dpPrcsKnt[i]);
						if ( rctCurrCd[i] !=	null)
						model.setRctCurrCd( rctCurrCd[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( rctAplyAmt[i] !=	null)
						model.setRctAplyAmt( rctAplyAmt[i]);
						if ( otsRctTmpSeq[i] !=	null)
						model.setOtsRctTmpSeq( otsRctTmpSeq[i]);
						if ( rctAplySrcCurrCd[i] !=	null)
						model.setRctAplySrcCurrCd( rctAplySrcCurrCd[i]);
						if ( dueDt[i] !=	null)
						model.setDueDt( dueDt[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( invDt[i] !=	null)
						model.setInvDt( invDt[i]);
						if ( updDt[i] !=	null)
						model.setUpdDt( updDt[i]);
						if ( rhqCd[i] !=	null)
						model.setRhqCd( rhqCd[i]);
						if ( otsAplyAmt[i] !=	null)
						model.setOtsAplyAmt( otsAplyAmt[i]);
						if ( loclVvdCd[i] !=	null)
						model.setLoclVvdCd( loclVvdCd[i]);
						if ( trnkVvdCd[i] !=	null)
						model.setTrnkVvdCd( trnkVvdCd[i]);
						if ( rctAplyHdrSeq[i] !=	null)
						model.setRctAplyHdrSeq( rctAplyHdrSeq[i]);
						if ( bilToCustSeq[i] !=	null)
						model.setBilToCustSeq( bilToCustSeq[i]);
						if ( ioBndCd[i] !=	null)
						model.setIoBndCd( ioBndCd[i]);
						if ( crFlg[i] !=	null)
						model.setCrFlg( crFlg[i]);
						if ( rctAplyXchRt[i] !=	null)
						model.setRctAplyXchRt( rctAplyXchRt[i]);
						if ( invNo[i] !=	null)
						model.setInvNo( invNo[i]);
						if ( ofcCd[i] !=	null)
						model.setOfcCd( ofcCd[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
						if ( bkgNo[i] !=	null)
						model.setBkgNo( bkgNo[i]);
						if ( otsRmk[i] !=	null)
						model.setOtsRmk( otsRmk[i]);
						if ( maxArIfNo[i] !=	null)
						model.setMaxArIfNo( maxArIfNo[i]);
						if ( otsOfcCd[i] !=	null)
						model.setOtsOfcCd( otsOfcCd[i]);
						if ( rctAplyFlg[i] !=	null)
						model.setRctAplyFlg( rctAplyFlg[i]);
						if ( otsXchRt[i] !=	null)
						model.setOtsXchRt( otsXchRt[i]);
						if ( hdrDupFlg[i] !=	null)
						model.setHdrDupFlg( hdrDupFlg[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getSarOtsRctTmpVOs();
	}

	/**
	 *  VO 諛곗뿴��諛섑솚
	 * @return SarOtsRctTmpVO[]
	 */
	public SarOtsRctTmpVO[]	 getSarOtsRctTmpVOs(){
		SarOtsRctTmpVO[] vos = (SarOtsRctTmpVO[])models.toArray(new	SarOtsRctTmpVO[models.size()]);
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
		this.xchRtTpCd =	this.xchRtTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilToCustCntCd =	this.bilToCustCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt =	this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arFincSrcCd =	this.arFincSrcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo =	this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailArrDt =	this.sailArrDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepCd =	this.srepCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsBalAmt =	this.otsBalAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctAplyChgCd =	this.rctAplyChgCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpPrcsKnt =	this.dpPrcsKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctCurrCd =	this.rctCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctAplyAmt =	this.rctAplyAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsRctTmpSeq =	this.otsRctTmpSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctAplySrcCurrCd =	this.rctAplySrcCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dueDt =	this.dueDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDt =	this.invDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt =	this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd =	this.rhqCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsAplyAmt =	this.otsAplyAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclVvdCd =	this.loclVvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkVvdCd =	this.trnkVvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctAplyHdrSeq =	this.rctAplyHdrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilToCustSeq =	this.bilToCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd =	this.ioBndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crFlg =	this.crFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctAplyXchRt =	this.rctAplyXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo =	this.invNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd =	this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo =	this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsRmk =	this.otsRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxArIfNo =	this.maxArIfNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsOfcCd =	this.otsOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctAplyFlg =	this.rctAplyFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsXchRt =	this.otsXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrDupFlg =	this.hdrDupFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}