/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ReceivableApplVO.java
 *@FileTitle : ReceivableApplVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.11.04
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2014.11.04  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo;

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
public class ReceivableApplVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<ReceivableApplVO>  models =	new	ArrayList<ReceivableApplVO>();


	/*	Column Info	*/
	private  String	 aplyFmRcvApplSeq   =  null;
	/*	Column Info	*/
	private  String	 chgTpCd   =  null;
	/*	Column Info	*/
	private  String	 rcvApplStsCd   =  null;
	/*	Column Info	*/
	private  String	 rcvApplTpCd   =  null;
	/*	Column Info	*/
	private  String	 glDt   =  null;
	/*	Column Info	*/
	private  String	 aplyToAcctAmt   =  null;
	/*	Column Info	*/
	private  String	 rctTermDys   =  null;
	/*	Column Info	*/
	private  String	 aplyAmt   =  null;
	/*	Column Info	*/
	private  String	 creDt   =  null;
	/*	Column Info	*/
	private  String	 rcvApplRmk   =  null;
	/*	Column Info	*/
	private  String	 acctXchRtLvl   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 aplyFmAcctAmt   =  null;
	/*	Column Info	*/
	private  String	 rcvApplSeq   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 convXchRt   =  null;
	/*	Column Info	*/
	private  String	 acctXchRtDt   =  null;
	/*	Column Info	*/
	private  String	 rctSeq   =  null;
	/*	Column Info	*/
	private  String	 glTrnsSeq   =  null;
	/*	Column Info	*/
	private  String	 otsHisSeq   =  null;
	/*	Column Info	*/
	private  String	 rctDpsDt   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 updDt   =  null;
	/*	Column Info	*/
	private  String	 dpFlg   =  null;
	/*	Column Info	*/
	private  String	 rcvCdCmbSeq   =  null;
	/*	Column Info	*/
	private  String	 acctMtxSeq   =  null;
	/*	Column Info	*/
	private  String	 glTrnsDt   =  null;
	/*	Column Info	*/
	private  String	 rvsGlDt   =  null;
	/*	Column Info	*/
	private  String	 otsToRctXchRt   =  null;
	/*	Column Info	*/
	private  String	 tgtRcvApplSeq   =  null;
	/*	Column Info	*/
	private  String	 rctCxlDt   =  null;
	/*	Column Info	*/
	private  String	 orzSeq   =  null;
	/*	Column Info	*/
	private  String	 wrtfTpCd   =  null;
	/*	Column Info	*/
	private  String	 aplyFmAmt   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;
	/*	Column Info	*/
	private  String	 rctAplyDtlSeq   =  null;
	/*	Column Info	*/
	private  String	 rctDt   =  null;
	/*	Column Info	*/
	private  String	 legrSeq   =  null;
	/*	Column Info	*/
	private  String	 apRmk   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public ReceivableApplVO(){}

	public ReceivableApplVO(String aplyFmRcvApplSeq,String chgTpCd,String rcvApplStsCd,String rcvApplTpCd,String glDt,String aplyToAcctAmt,String rctTermDys,String aplyAmt,String creDt,String rcvApplRmk,String acctXchRtLvl,String pagerows,String aplyFmAcctAmt,String rcvApplSeq,String ibflag,String convXchRt,String acctXchRtDt,String rctSeq,String glTrnsSeq,String otsHisSeq,String rctDpsDt,String updUsrId,String updDt,String dpFlg,String rcvCdCmbSeq,String acctMtxSeq,String glTrnsDt,String rvsGlDt,String otsToRctXchRt,String tgtRcvApplSeq,String rctCxlDt,String orzSeq,String wrtfTpCd,String aplyFmAmt,String creUsrId,String rctAplyDtlSeq,String rctDt,String legrSeq,String apRmk)	{
		this.aplyFmRcvApplSeq  = aplyFmRcvApplSeq ;
		this.chgTpCd  = chgTpCd ;
		this.rcvApplStsCd  = rcvApplStsCd ;
		this.rcvApplTpCd  = rcvApplTpCd ;
		this.glDt  = glDt ;
		this.aplyToAcctAmt  = aplyToAcctAmt ;
		this.rctTermDys  = rctTermDys ;
		this.aplyAmt  = aplyAmt ;
		this.creDt  = creDt ;
		this.rcvApplRmk  = rcvApplRmk ;
		this.acctXchRtLvl  = acctXchRtLvl ;
		this.pagerows  = pagerows ;
		this.aplyFmAcctAmt  = aplyFmAcctAmt ;
		this.rcvApplSeq  = rcvApplSeq ;
		this.ibflag  = ibflag ;
		this.convXchRt  = convXchRt ;
		this.acctXchRtDt  = acctXchRtDt ;
		this.rctSeq  = rctSeq ;
		this.glTrnsSeq  = glTrnsSeq ;
		this.otsHisSeq  = otsHisSeq ;
		this.rctDpsDt  = rctDpsDt ;
		this.updUsrId  = updUsrId ;
		this.updDt  = updDt ;
		this.dpFlg  = dpFlg ;
		this.rcvCdCmbSeq  = rcvCdCmbSeq ;
		this.acctMtxSeq  = acctMtxSeq ;
		this.glTrnsDt  = glTrnsDt ;
		this.rvsGlDt  = rvsGlDt ;
		this.otsToRctXchRt  = otsToRctXchRt ;
		this.tgtRcvApplSeq  = tgtRcvApplSeq ;
		this.rctCxlDt  = rctCxlDt ;
		this.orzSeq  = orzSeq ;
		this.wrtfTpCd  = wrtfTpCd ;
		this.aplyFmAmt  = aplyFmAmt ;
		this.creUsrId  = creUsrId ;
		this.rctAplyDtlSeq  = rctAplyDtlSeq ;
		this.rctDt  = rctDt ;
		this.legrSeq  = legrSeq ;
		this.apRmk  = apRmk ;
	}


	/**
	 * �뚯씠釉�而щ읆����옣��媛믪쓣 Hashtable<"column_name", "value">	濡�諛섑솚
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("aply_fm_rcv_appl_seq", getAplyFmRcvApplSeq());		
		this.hashColumns.put("chg_tp_cd", getChgTpCd());		
		this.hashColumns.put("rcv_appl_sts_cd", getRcvApplStsCd());		
		this.hashColumns.put("rcv_appl_tp_cd", getRcvApplTpCd());		
		this.hashColumns.put("gl_dt", getGlDt());		
		this.hashColumns.put("aply_to_acct_amt", getAplyToAcctAmt());		
		this.hashColumns.put("rct_term_dys", getRctTermDys());		
		this.hashColumns.put("aply_amt", getAplyAmt());		
		this.hashColumns.put("cre_dt", getCreDt());		
		this.hashColumns.put("rcv_appl_rmk", getRcvApplRmk());		
		this.hashColumns.put("acct_xch_rt_lvl", getAcctXchRtLvl());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("aply_fm_acct_amt", getAplyFmAcctAmt());		
		this.hashColumns.put("rcv_appl_seq", getRcvApplSeq());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("conv_xch_rt", getConvXchRt());		
		this.hashColumns.put("acct_xch_rt_dt", getAcctXchRtDt());		
		this.hashColumns.put("rct_seq", getRctSeq());		
		this.hashColumns.put("gl_trns_seq", getGlTrnsSeq());		
		this.hashColumns.put("ots_his_seq", getOtsHisSeq());		
		this.hashColumns.put("rct_dps_dt", getRctDpsDt());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("upd_dt", getUpdDt());		
		this.hashColumns.put("dp_flg", getDpFlg());		
		this.hashColumns.put("rcv_cd_cmb_seq", getRcvCdCmbSeq());		
		this.hashColumns.put("acct_mtx_seq", getAcctMtxSeq());		
		this.hashColumns.put("gl_trns_dt", getGlTrnsDt());		
		this.hashColumns.put("rvs_gl_dt", getRvsGlDt());		
		this.hashColumns.put("ots_to_rct_xch_rt", getOtsToRctXchRt());		
		this.hashColumns.put("tgt_rcv_appl_seq", getTgtRcvApplSeq());		
		this.hashColumns.put("rct_cxl_dt", getRctCxlDt());		
		this.hashColumns.put("orz_seq", getOrzSeq());		
		this.hashColumns.put("wrtf_tp_cd", getWrtfTpCd());		
		this.hashColumns.put("aply_fm_amt", getAplyFmAmt());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("rct_aply_dtl_seq", getRctAplyDtlSeq());		
		this.hashColumns.put("rct_dt", getRctDt());		
		this.hashColumns.put("legr_seq", getLegrSeq());		
		this.hashColumns.put("ap_rmk", getApRmk());		
		return this.hashColumns;
}

	/**
	 * 而щ읆紐낆뿉	��쓳�섎뒗 硫ㅻ쾭蹂�닔紐낆쓣	��옣�섏뿬 Hashtable<"column_name", "variable"> 濡�諛섑솚
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("aply_fm_rcv_appl_seq", "aplyFmRcvApplSeq");
		this.hashFields.put("chg_tp_cd", "chgTpCd");
		this.hashFields.put("rcv_appl_sts_cd", "rcvApplStsCd");
		this.hashFields.put("rcv_appl_tp_cd", "rcvApplTpCd");
		this.hashFields.put("gl_dt", "glDt");
		this.hashFields.put("aply_to_acct_amt", "aplyToAcctAmt");
		this.hashFields.put("rct_term_dys", "rctTermDys");
		this.hashFields.put("aply_amt", "aplyAmt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("rcv_appl_rmk", "rcvApplRmk");
		this.hashFields.put("acct_xch_rt_lvl", "acctXchRtLvl");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("aply_fm_acct_amt", "aplyFmAcctAmt");
		this.hashFields.put("rcv_appl_seq", "rcvApplSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("conv_xch_rt", "convXchRt");
		this.hashFields.put("acct_xch_rt_dt", "acctXchRtDt");
		this.hashFields.put("rct_seq", "rctSeq");
		this.hashFields.put("gl_trns_seq", "glTrnsSeq");
		this.hashFields.put("ots_his_seq", "otsHisSeq");
		this.hashFields.put("rct_dps_dt", "rctDpsDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("dp_flg", "dpFlg");
		this.hashFields.put("rcv_cd_cmb_seq", "rcvCdCmbSeq");
		this.hashFields.put("acct_mtx_seq", "acctMtxSeq");
		this.hashFields.put("gl_trns_dt", "glTrnsDt");
		this.hashFields.put("rvs_gl_dt", "rvsGlDt");
		this.hashFields.put("ots_to_rct_xch_rt", "otsToRctXchRt");
		this.hashFields.put("tgt_rcv_appl_seq", "tgtRcvApplSeq");
		this.hashFields.put("rct_cxl_dt", "rctCxlDt");
		this.hashFields.put("orz_seq", "orzSeq");
		this.hashFields.put("wrtf_tp_cd", "wrtfTpCd");
		this.hashFields.put("aply_fm_amt", "aplyFmAmt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("rct_aply_dtl_seq", "rctAplyDtlSeq");
		this.hashFields.put("rct_dt", "rctDt");
		this.hashFields.put("legr_seq", "legrSeq");
		this.hashFields.put("ap_rmk", "apRmk");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  aplyFmRcvApplSeq
	*/
	public void	setAplyFmRcvApplSeq( String	aplyFmRcvApplSeq ) {
		this.aplyFmRcvApplSeq =	aplyFmRcvApplSeq;
	}
 
	/**
	 * Column Info
	 * @return	aplyFmRcvApplSeq
	 */
	 public	 String	getAplyFmRcvApplSeq() {
		 return	this.aplyFmRcvApplSeq;
	 } 
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
	* @param  rcvApplStsCd
	*/
	public void	setRcvApplStsCd( String	rcvApplStsCd ) {
		this.rcvApplStsCd =	rcvApplStsCd;
	}
 
	/**
	 * Column Info
	 * @return	rcvApplStsCd
	 */
	 public	 String	getRcvApplStsCd() {
		 return	this.rcvApplStsCd;
	 } 
 	/**
	* Column Info
	* @param  rcvApplTpCd
	*/
	public void	setRcvApplTpCd( String	rcvApplTpCd ) {
		this.rcvApplTpCd =	rcvApplTpCd;
	}
 
	/**
	 * Column Info
	 * @return	rcvApplTpCd
	 */
	 public	 String	getRcvApplTpCd() {
		 return	this.rcvApplTpCd;
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
	* @param  aplyToAcctAmt
	*/
	public void	setAplyToAcctAmt( String	aplyToAcctAmt ) {
		this.aplyToAcctAmt =	aplyToAcctAmt;
	}
 
	/**
	 * Column Info
	 * @return	aplyToAcctAmt
	 */
	 public	 String	getAplyToAcctAmt() {
		 return	this.aplyToAcctAmt;
	 } 
 	/**
	* Column Info
	* @param  rctTermDys
	*/
	public void	setRctTermDys( String	rctTermDys ) {
		this.rctTermDys =	rctTermDys;
	}
 
	/**
	 * Column Info
	 * @return	rctTermDys
	 */
	 public	 String	getRctTermDys() {
		 return	this.rctTermDys;
	 } 
 	/**
	* Column Info
	* @param  aplyAmt
	*/
	public void	setAplyAmt( String	aplyAmt ) {
		this.aplyAmt =	aplyAmt;
	}
 
	/**
	 * Column Info
	 * @return	aplyAmt
	 */
	 public	 String	getAplyAmt() {
		 return	this.aplyAmt;
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
	* @param  rcvApplRmk
	*/
	public void	setRcvApplRmk( String	rcvApplRmk ) {
		this.rcvApplRmk =	rcvApplRmk;
	}
 
	/**
	 * Column Info
	 * @return	rcvApplRmk
	 */
	 public	 String	getRcvApplRmk() {
		 return	this.rcvApplRmk;
	 } 
 	/**
	* Column Info
	* @param  acctXchRtLvl
	*/
	public void	setAcctXchRtLvl( String	acctXchRtLvl ) {
		this.acctXchRtLvl =	acctXchRtLvl;
	}
 
	/**
	 * Column Info
	 * @return	acctXchRtLvl
	 */
	 public	 String	getAcctXchRtLvl() {
		 return	this.acctXchRtLvl;
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
	* @param  aplyFmAcctAmt
	*/
	public void	setAplyFmAcctAmt( String	aplyFmAcctAmt ) {
		this.aplyFmAcctAmt =	aplyFmAcctAmt;
	}
 
	/**
	 * Column Info
	 * @return	aplyFmAcctAmt
	 */
	 public	 String	getAplyFmAcctAmt() {
		 return	this.aplyFmAcctAmt;
	 } 
 	/**
	* Column Info
	* @param  rcvApplSeq
	*/
	public void	setRcvApplSeq( String	rcvApplSeq ) {
		this.rcvApplSeq =	rcvApplSeq;
	}
 
	/**
	 * Column Info
	 * @return	rcvApplSeq
	 */
	 public	 String	getRcvApplSeq() {
		 return	this.rcvApplSeq;
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
	* @param  convXchRt
	*/
	public void	setConvXchRt( String	convXchRt ) {
		this.convXchRt =	convXchRt;
	}
 
	/**
	 * Column Info
	 * @return	convXchRt
	 */
	 public	 String	getConvXchRt() {
		 return	this.convXchRt;
	 } 
 	/**
	* Column Info
	* @param  acctXchRtDt
	*/
	public void	setAcctXchRtDt( String	acctXchRtDt ) {
		this.acctXchRtDt =	acctXchRtDt;
	}
 
	/**
	 * Column Info
	 * @return	acctXchRtDt
	 */
	 public	 String	getAcctXchRtDt() {
		 return	this.acctXchRtDt;
	 } 
 	/**
	* Column Info
	* @param  rctSeq
	*/
	public void	setRctSeq( String	rctSeq ) {
		this.rctSeq =	rctSeq;
	}
 
	/**
	 * Column Info
	 * @return	rctSeq
	 */
	 public	 String	getRctSeq() {
		 return	this.rctSeq;
	 } 
 	/**
	* Column Info
	* @param  glTrnsSeq
	*/
	public void	setGlTrnsSeq( String	glTrnsSeq ) {
		this.glTrnsSeq =	glTrnsSeq;
	}
 
	/**
	 * Column Info
	 * @return	glTrnsSeq
	 */
	 public	 String	getGlTrnsSeq() {
		 return	this.glTrnsSeq;
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
	* @param  rctDpsDt
	*/
	public void	setRctDpsDt( String	rctDpsDt ) {
		this.rctDpsDt =	rctDpsDt;
	}
 
	/**
	 * Column Info
	 * @return	rctDpsDt
	 */
	 public	 String	getRctDpsDt() {
		 return	this.rctDpsDt;
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
	* @param  dpFlg
	*/
	public void	setDpFlg( String	dpFlg ) {
		this.dpFlg =	dpFlg;
	}
 
	/**
	 * Column Info
	 * @return	dpFlg
	 */
	 public	 String	getDpFlg() {
		 return	this.dpFlg;
	 } 
 	/**
	* Column Info
	* @param  rcvCdCmbSeq
	*/
	public void	setRcvCdCmbSeq( String	rcvCdCmbSeq ) {
		this.rcvCdCmbSeq =	rcvCdCmbSeq;
	}
 
	/**
	 * Column Info
	 * @return	rcvCdCmbSeq
	 */
	 public	 String	getRcvCdCmbSeq() {
		 return	this.rcvCdCmbSeq;
	 } 
 	/**
	* Column Info
	* @param  acctMtxSeq
	*/
	public void	setAcctMtxSeq( String	acctMtxSeq ) {
		this.acctMtxSeq =	acctMtxSeq;
	}
 
	/**
	 * Column Info
	 * @return	acctMtxSeq
	 */
	 public	 String	getAcctMtxSeq() {
		 return	this.acctMtxSeq;
	 } 
 	/**
	* Column Info
	* @param  glTrnsDt
	*/
	public void	setGlTrnsDt( String	glTrnsDt ) {
		this.glTrnsDt =	glTrnsDt;
	}
 
	/**
	 * Column Info
	 * @return	glTrnsDt
	 */
	 public	 String	getGlTrnsDt() {
		 return	this.glTrnsDt;
	 } 
 	/**
	* Column Info
	* @param  rvsGlDt
	*/
	public void	setRvsGlDt( String	rvsGlDt ) {
		this.rvsGlDt =	rvsGlDt;
	}
 
	/**
	 * Column Info
	 * @return	rvsGlDt
	 */
	 public	 String	getRvsGlDt() {
		 return	this.rvsGlDt;
	 } 
 	/**
	* Column Info
	* @param  otsToRctXchRt
	*/
	public void	setOtsToRctXchRt( String	otsToRctXchRt ) {
		this.otsToRctXchRt =	otsToRctXchRt;
	}
 
	/**
	 * Column Info
	 * @return	otsToRctXchRt
	 */
	 public	 String	getOtsToRctXchRt() {
		 return	this.otsToRctXchRt;
	 } 
 	/**
	* Column Info
	* @param  tgtRcvApplSeq
	*/
	public void	setTgtRcvApplSeq( String	tgtRcvApplSeq ) {
		this.tgtRcvApplSeq =	tgtRcvApplSeq;
	}
 
	/**
	 * Column Info
	 * @return	tgtRcvApplSeq
	 */
	 public	 String	getTgtRcvApplSeq() {
		 return	this.tgtRcvApplSeq;
	 } 
 	/**
	* Column Info
	* @param  rctCxlDt
	*/
	public void	setRctCxlDt( String	rctCxlDt ) {
		this.rctCxlDt =	rctCxlDt;
	}
 
	/**
	 * Column Info
	 * @return	rctCxlDt
	 */
	 public	 String	getRctCxlDt() {
		 return	this.rctCxlDt;
	 } 
 	/**
	* Column Info
	* @param  orzSeq
	*/
	public void	setOrzSeq( String	orzSeq ) {
		this.orzSeq =	orzSeq;
	}
 
	/**
	 * Column Info
	 * @return	orzSeq
	 */
	 public	 String	getOrzSeq() {
		 return	this.orzSeq;
	 } 
 	/**
	* Column Info
	* @param  wrtfTpCd
	*/
	public void	setWrtfTpCd( String	wrtfTpCd ) {
		this.wrtfTpCd =	wrtfTpCd;
	}
 
	/**
	 * Column Info
	 * @return	wrtfTpCd
	 */
	 public	 String	getWrtfTpCd() {
		 return	this.wrtfTpCd;
	 } 
 	/**
	* Column Info
	* @param  aplyFmAmt
	*/
	public void	setAplyFmAmt( String	aplyFmAmt ) {
		this.aplyFmAmt =	aplyFmAmt;
	}
 
	/**
	 * Column Info
	 * @return	aplyFmAmt
	 */
	 public	 String	getAplyFmAmt() {
		 return	this.aplyFmAmt;
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
	* @param  rctAplyDtlSeq
	*/
	public void	setRctAplyDtlSeq( String	rctAplyDtlSeq ) {
		this.rctAplyDtlSeq =	rctAplyDtlSeq;
	}
 
	/**
	 * Column Info
	 * @return	rctAplyDtlSeq
	 */
	 public	 String	getRctAplyDtlSeq() {
		 return	this.rctAplyDtlSeq;
	 } 
 	/**
	* Column Info
	* @param  rctDt
	*/
	public void	setRctDt( String	rctDt ) {
		this.rctDt =	rctDt;
	}
 
	/**
	 * Column Info
	 * @return	rctDt
	 */
	 public	 String	getRctDt() {
		 return	this.rctDt;
	 } 
 	/**
	* Column Info
	* @param  legrSeq
	*/
	public void	setLegrSeq( String	legrSeq ) {
		this.legrSeq =	legrSeq;
	}
 
	/**
	 * Column Info
	 * @return	legrSeq
	 */
	 public	 String	getLegrSeq() {
		 return	this.legrSeq;
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
		setAplyFmRcvApplSeq(JSPUtil.getParameter(request,	prefix + "aply_fm_rcv_appl_seq", ""));
		setChgTpCd(JSPUtil.getParameter(request,	prefix + "chg_tp_cd", ""));
		setRcvApplStsCd(JSPUtil.getParameter(request,	prefix + "rcv_appl_sts_cd", ""));
		setRcvApplTpCd(JSPUtil.getParameter(request,	prefix + "rcv_appl_tp_cd", ""));
		setGlDt(JSPUtil.getParameter(request,	prefix + "gl_dt", ""));
		setAplyToAcctAmt(JSPUtil.getParameter(request,	prefix + "aply_to_acct_amt", ""));
		setRctTermDys(JSPUtil.getParameter(request,	prefix + "rct_term_dys", ""));
		setAplyAmt(JSPUtil.getParameter(request,	prefix + "aply_amt", ""));
		setCreDt(JSPUtil.getParameter(request,	prefix + "cre_dt", ""));
		setRcvApplRmk(JSPUtil.getParameter(request,	prefix + "rcv_appl_rmk", ""));
		setAcctXchRtLvl(JSPUtil.getParameter(request,	prefix + "acct_xch_rt_lvl", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setAplyFmAcctAmt(JSPUtil.getParameter(request,	prefix + "aply_fm_acct_amt", ""));
		setRcvApplSeq(JSPUtil.getParameter(request,	prefix + "rcv_appl_seq", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setConvXchRt(JSPUtil.getParameter(request,	prefix + "conv_xch_rt", ""));
		setAcctXchRtDt(JSPUtil.getParameter(request,	prefix + "acct_xch_rt_dt", ""));
		setRctSeq(JSPUtil.getParameter(request,	prefix + "rct_seq", ""));
		setGlTrnsSeq(JSPUtil.getParameter(request,	prefix + "gl_trns_seq", ""));
		setOtsHisSeq(JSPUtil.getParameter(request,	prefix + "ots_his_seq", ""));
		setRctDpsDt(JSPUtil.getParameter(request,	prefix + "rct_dps_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request,	prefix + "upd_dt", ""));
		setDpFlg(JSPUtil.getParameter(request,	prefix + "dp_flg", ""));
		setRcvCdCmbSeq(JSPUtil.getParameter(request,	prefix + "rcv_cd_cmb_seq", ""));
		setAcctMtxSeq(JSPUtil.getParameter(request,	prefix + "acct_mtx_seq", ""));
		setGlTrnsDt(JSPUtil.getParameter(request,	prefix + "gl_trns_dt", ""));
		setRvsGlDt(JSPUtil.getParameter(request,	prefix + "rvs_gl_dt", ""));
		setOtsToRctXchRt(JSPUtil.getParameter(request,	prefix + "ots_to_rct_xch_rt", ""));
		setTgtRcvApplSeq(JSPUtil.getParameter(request,	prefix + "tgt_rcv_appl_seq", ""));
		setRctCxlDt(JSPUtil.getParameter(request,	prefix + "rct_cxl_dt", ""));
		setOrzSeq(JSPUtil.getParameter(request,	prefix + "orz_seq", ""));
		setWrtfTpCd(JSPUtil.getParameter(request,	prefix + "wrtf_tp_cd", ""));
		setAplyFmAmt(JSPUtil.getParameter(request,	prefix + "aply_fm_amt", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setRctAplyDtlSeq(JSPUtil.getParameter(request,	prefix + "rct_aply_dtl_seq", ""));
		setRctDt(JSPUtil.getParameter(request,	prefix + "rct_dt", ""));
		setLegrSeq(JSPUtil.getParameter(request,	prefix + "legr_seq", ""));
		setApRmk(JSPUtil.getParameter(request,	prefix + "ap_rmk", ""));
	}
	
	/**
	 * Request ���곗씠�곕� VO 諛곗뿴濡�蹂�솚�섏뿬 諛섑솚.
	 * @param request
	 * @return ReceivableApplVO[]
	 */
	public ReceivableApplVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request �섏뼱���щ윭 嫄�DATA瑜�VO Class ���대뒗��
	 * @param request
	 * @param prefix
	 * @return ReceivableApplVO[]
	 */
	public ReceivableApplVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		ReceivableApplVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] aplyFmRcvApplSeq =	(JSPUtil.getParameter(request, prefix +	"aply_fm_rcv_appl_seq".trim(),	length));
				String[] chgTpCd =	(JSPUtil.getParameter(request, prefix +	"chg_tp_cd".trim(),	length));
				String[] rcvApplStsCd =	(JSPUtil.getParameter(request, prefix +	"rcv_appl_sts_cd".trim(),	length));
				String[] rcvApplTpCd =	(JSPUtil.getParameter(request, prefix +	"rcv_appl_tp_cd".trim(),	length));
				String[] glDt =	(JSPUtil.getParameter(request, prefix +	"gl_dt".trim(),	length));
				String[] aplyToAcctAmt =	(JSPUtil.getParameter(request, prefix +	"aply_to_acct_amt".trim(),	length));
				String[] rctTermDys =	(JSPUtil.getParameter(request, prefix +	"rct_term_dys".trim(),	length));
				String[] aplyAmt =	(JSPUtil.getParameter(request, prefix +	"aply_amt".trim(),	length));
				String[] creDt =	(JSPUtil.getParameter(request, prefix +	"cre_dt".trim(),	length));
				String[] rcvApplRmk =	(JSPUtil.getParameter(request, prefix +	"rcv_appl_rmk".trim(),	length));
				String[] acctXchRtLvl =	(JSPUtil.getParameter(request, prefix +	"acct_xch_rt_lvl".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] aplyFmAcctAmt =	(JSPUtil.getParameter(request, prefix +	"aply_fm_acct_amt".trim(),	length));
				String[] rcvApplSeq =	(JSPUtil.getParameter(request, prefix +	"rcv_appl_seq".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] convXchRt =	(JSPUtil.getParameter(request, prefix +	"conv_xch_rt".trim(),	length));
				String[] acctXchRtDt =	(JSPUtil.getParameter(request, prefix +	"acct_xch_rt_dt".trim(),	length));
				String[] rctSeq =	(JSPUtil.getParameter(request, prefix +	"rct_seq".trim(),	length));
				String[] glTrnsSeq =	(JSPUtil.getParameter(request, prefix +	"gl_trns_seq".trim(),	length));
				String[] otsHisSeq =	(JSPUtil.getParameter(request, prefix +	"ots_his_seq".trim(),	length));
				String[] rctDpsDt =	(JSPUtil.getParameter(request, prefix +	"rct_dps_dt".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] updDt =	(JSPUtil.getParameter(request, prefix +	"upd_dt".trim(),	length));
				String[] dpFlg =	(JSPUtil.getParameter(request, prefix +	"dp_flg".trim(),	length));
				String[] rcvCdCmbSeq =	(JSPUtil.getParameter(request, prefix +	"rcv_cd_cmb_seq".trim(),	length));
				String[] acctMtxSeq =	(JSPUtil.getParameter(request, prefix +	"acct_mtx_seq".trim(),	length));
				String[] glTrnsDt =	(JSPUtil.getParameter(request, prefix +	"gl_trns_dt".trim(),	length));
				String[] rvsGlDt =	(JSPUtil.getParameter(request, prefix +	"rvs_gl_dt".trim(),	length));
				String[] otsToRctXchRt =	(JSPUtil.getParameter(request, prefix +	"ots_to_rct_xch_rt".trim(),	length));
				String[] tgtRcvApplSeq =	(JSPUtil.getParameter(request, prefix +	"tgt_rcv_appl_seq".trim(),	length));
				String[] rctCxlDt =	(JSPUtil.getParameter(request, prefix +	"rct_cxl_dt".trim(),	length));
				String[] orzSeq =	(JSPUtil.getParameter(request, prefix +	"orz_seq".trim(),	length));
				String[] wrtfTpCd =	(JSPUtil.getParameter(request, prefix +	"wrtf_tp_cd".trim(),	length));
				String[] aplyFmAmt =	(JSPUtil.getParameter(request, prefix +	"aply_fm_amt".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				String[] rctAplyDtlSeq =	(JSPUtil.getParameter(request, prefix +	"rct_aply_dtl_seq".trim(),	length));
				String[] rctDt =	(JSPUtil.getParameter(request, prefix +	"rct_dt".trim(),	length));
				String[] legrSeq =	(JSPUtil.getParameter(request, prefix +	"legr_seq".trim(),	length));
				String[] apRmk =	(JSPUtil.getParameter(request, prefix +	"ap_rmk".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	ReceivableApplVO();
						if ( aplyFmRcvApplSeq[i] !=	null)
						model.setAplyFmRcvApplSeq( aplyFmRcvApplSeq[i]);
						if ( chgTpCd[i] !=	null)
						model.setChgTpCd( chgTpCd[i]);
						if ( rcvApplStsCd[i] !=	null)
						model.setRcvApplStsCd( rcvApplStsCd[i]);
						if ( rcvApplTpCd[i] !=	null)
						model.setRcvApplTpCd( rcvApplTpCd[i]);
						if ( glDt[i] !=	null)
						model.setGlDt( glDt[i]);
						if ( aplyToAcctAmt[i] !=	null)
						model.setAplyToAcctAmt( aplyToAcctAmt[i]);
						if ( rctTermDys[i] !=	null)
						model.setRctTermDys( rctTermDys[i]);
						if ( aplyAmt[i] !=	null)
						model.setAplyAmt( aplyAmt[i]);
						if ( creDt[i] !=	null)
						model.setCreDt( creDt[i]);
						if ( rcvApplRmk[i] !=	null)
						model.setRcvApplRmk( rcvApplRmk[i]);
						if ( acctXchRtLvl[i] !=	null)
						model.setAcctXchRtLvl( acctXchRtLvl[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( aplyFmAcctAmt[i] !=	null)
						model.setAplyFmAcctAmt( aplyFmAcctAmt[i]);
						if ( rcvApplSeq[i] !=	null)
						model.setRcvApplSeq( rcvApplSeq[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( convXchRt[i] !=	null)
						model.setConvXchRt( convXchRt[i]);
						if ( acctXchRtDt[i] !=	null)
						model.setAcctXchRtDt( acctXchRtDt[i]);
						if ( rctSeq[i] !=	null)
						model.setRctSeq( rctSeq[i]);
						if ( glTrnsSeq[i] !=	null)
						model.setGlTrnsSeq( glTrnsSeq[i]);
						if ( otsHisSeq[i] !=	null)
						model.setOtsHisSeq( otsHisSeq[i]);
						if ( rctDpsDt[i] !=	null)
						model.setRctDpsDt( rctDpsDt[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( updDt[i] !=	null)
						model.setUpdDt( updDt[i]);
						if ( dpFlg[i] !=	null)
						model.setDpFlg( dpFlg[i]);
						if ( rcvCdCmbSeq[i] !=	null)
						model.setRcvCdCmbSeq( rcvCdCmbSeq[i]);
						if ( acctMtxSeq[i] !=	null)
						model.setAcctMtxSeq( acctMtxSeq[i]);
						if ( glTrnsDt[i] !=	null)
						model.setGlTrnsDt( glTrnsDt[i]);
						if ( rvsGlDt[i] !=	null)
						model.setRvsGlDt( rvsGlDt[i]);
						if ( otsToRctXchRt[i] !=	null)
						model.setOtsToRctXchRt( otsToRctXchRt[i]);
						if ( tgtRcvApplSeq[i] !=	null)
						model.setTgtRcvApplSeq( tgtRcvApplSeq[i]);
						if ( rctCxlDt[i] !=	null)
						model.setRctCxlDt( rctCxlDt[i]);
						if ( orzSeq[i] !=	null)
						model.setOrzSeq( orzSeq[i]);
						if ( wrtfTpCd[i] !=	null)
						model.setWrtfTpCd( wrtfTpCd[i]);
						if ( aplyFmAmt[i] !=	null)
						model.setAplyFmAmt( aplyFmAmt[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
						if ( rctAplyDtlSeq[i] !=	null)
						model.setRctAplyDtlSeq( rctAplyDtlSeq[i]);
						if ( rctDt[i] !=	null)
						model.setRctDt( rctDt[i]);
						if ( legrSeq[i] !=	null)
						model.setLegrSeq( legrSeq[i]);
						if ( apRmk[i] !=	null)
						model.setApRmk( apRmk[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getReceivableApplVOs();
	}

	/**
	 *  VO 諛곗뿴��諛섑솚
	 * @return ReceivableApplVO[]
	 */
	public ReceivableApplVO[]	 getReceivableApplVOs(){
		ReceivableApplVO[] vos = (ReceivableApplVO[])models.toArray(new	ReceivableApplVO[models.size()]);
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
		this.aplyFmRcvApplSeq =	this.aplyFmRcvApplSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgTpCd =	this.chgTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvApplStsCd =	this.rcvApplStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvApplTpCd =	this.rcvApplTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glDt =	this.glDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aplyToAcctAmt =	this.aplyToAcctAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctTermDys =	this.rctTermDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aplyAmt =	this.aplyAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt =	this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvApplRmk =	this.rcvApplRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctXchRtLvl =	this.acctXchRtLvl.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aplyFmAcctAmt =	this.aplyFmAcctAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvApplSeq =	this.rcvApplSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.convXchRt =	this.convXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctXchRtDt =	this.acctXchRtDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctSeq =	this.rctSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glTrnsSeq =	this.glTrnsSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsHisSeq =	this.otsHisSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctDpsDt =	this.rctDpsDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt =	this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpFlg =	this.dpFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvCdCmbSeq =	this.rcvCdCmbSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctMtxSeq =	this.acctMtxSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glTrnsDt =	this.glTrnsDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvsGlDt =	this.rvsGlDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsToRctXchRt =	this.otsToRctXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tgtRcvApplSeq =	this.tgtRcvApplSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctCxlDt =	this.rctCxlDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orzSeq =	this.orzSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wrtfTpCd =	this.wrtfTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aplyFmAmt =	this.aplyFmAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctAplyDtlSeq =	this.rctAplyDtlSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctDt =	this.rctDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.legrSeq =	this.legrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apRmk =	this.apRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}