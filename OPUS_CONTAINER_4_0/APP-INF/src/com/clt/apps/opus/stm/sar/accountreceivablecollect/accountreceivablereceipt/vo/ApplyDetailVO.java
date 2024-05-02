/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ApplyDetailVO.java
 *@FileTitle : ApplyDetailVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.06.30
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2015.06.30  
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
 * - 관련	Event에서	작성,	서버실행요청시	PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author 
 * @since J2EE 1.6
 * @see	..
 */
public class ApplyDetailVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<ApplyDetailVO>  models =	new	ArrayList<ApplyDetailVO>();


	/*	Column Info	*/
	private  String	 rctAplyDt   =  null;
	/*	Column Info	*/
	private  String	 creDt   =  null;
	/*	Column Info	*/
	private  String	 blNo   =  null;
	/*	Column Info	*/
	private  String	 rctAplyChgCd   =  null;
	/*	Column Info	*/
	private  String	 otsBalAmt   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 dpPrcsKnt   =  null;
	/*	Column Info	*/
	private  String	 rctCurrCd   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 vndrNo   =  null;
	/*	Column Info	*/
	private  String	 rctAplyAmt   =  null;
	/*	Column Info	*/
	private  String	 rctSeq   =  null;
	/*	Column Info	*/
	private  String	 rctAplySrcCurrCd   =  null;
	/*	Column Info	*/
	private  String	 wrtfCd   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 updDt   =  null;
	/*	Column Info	*/
	private  String	 apIfCd   =  null;
	/*	Column Info	*/
	private  String	 apOfcCd   =  null;
	/*	Column Info	*/
	private  String	 otsAplyAmt   =  null;
	/*	Column Info	*/
	private  String	 rctAplyHdrSeq   =  null;
	/*	Column Info	*/
	private  String	 rctAplyXchRt   =  null;
	/*	Column Info	*/
	private  String	 invNo   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;
	/*	Column Info	*/
	private  String	 otsOfcCd   =  null;
	/*	Column Info	*/
	private  String	 rctAplyDtlSeq   =  null;
	/*	Column Info	*/
	private  String	 rctAplyFlg   =  null;
	/*	Column Info	*/
	private  String	 rctAplyGlDt   =  null;
	/*	Column Info	*/
	private  String	 payAcctCd   =  null;
	/*	Column Info	*/
	private  String	 apGlDt   =  null;
	/*	Column Info	*/
	private  String	 otsXchRt   =  null;
	/*	Column Info	*/
	private  String	 apRmk   =  null;
	/*	Column Info	*/
	private  String	 wrtfRmk   =  null;
	/*	Column Info	*/
	private  String	 ttlAplyAmt   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public ApplyDetailVO(){}

	public ApplyDetailVO(String rctAplyDt,String creDt,String blNo,String rctAplyChgCd,String otsBalAmt,String pagerows,String dpPrcsKnt,String rctCurrCd,String ibflag,String vndrNo,String rctAplyAmt,String rctSeq,String rctAplySrcCurrCd,String wrtfCd,String updUsrId,String updDt,String apIfCd,String apOfcCd,String otsAplyAmt,String rctAplyHdrSeq,String rctAplyXchRt,String invNo,String creUsrId,String otsOfcCd,String rctAplyDtlSeq,String rctAplyFlg,String rctAplyGlDt,String payAcctCd,String apGlDt,String otsXchRt,String apRmk,String wrtfRmk,String ttlAplyAmt)	{
		this.rctAplyDt  = rctAplyDt ;
		this.creDt  = creDt ;
		this.blNo  = blNo ;
		this.rctAplyChgCd  = rctAplyChgCd ;
		this.otsBalAmt  = otsBalAmt ;
		this.pagerows  = pagerows ;
		this.dpPrcsKnt  = dpPrcsKnt ;
		this.rctCurrCd  = rctCurrCd ;
		this.ibflag  = ibflag ;
		this.vndrNo  = vndrNo ;
		this.rctAplyAmt  = rctAplyAmt ;
		this.rctSeq  = rctSeq ;
		this.rctAplySrcCurrCd  = rctAplySrcCurrCd ;
		this.wrtfCd  = wrtfCd ;
		this.updUsrId  = updUsrId ;
		this.updDt  = updDt ;
		this.apIfCd  = apIfCd ;
		this.apOfcCd  = apOfcCd ;
		this.otsAplyAmt  = otsAplyAmt ;
		this.rctAplyHdrSeq  = rctAplyHdrSeq ;
		this.rctAplyXchRt  = rctAplyXchRt ;
		this.invNo  = invNo ;
		this.creUsrId  = creUsrId ;
		this.otsOfcCd  = otsOfcCd ;
		this.rctAplyDtlSeq  = rctAplyDtlSeq ;
		this.rctAplyFlg  = rctAplyFlg ;
		this.rctAplyGlDt  = rctAplyGlDt ;
		this.payAcctCd  = payAcctCd ;
		this.apGlDt  = apGlDt ;
		this.otsXchRt  = otsXchRt ;
		this.apRmk  = apRmk ;
		this.wrtfRmk  = wrtfRmk ;
		this.ttlAplyAmt  = ttlAplyAmt ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rct_aply_dt", getRctAplyDt());		
		this.hashColumns.put("cre_dt", getCreDt());		
		this.hashColumns.put("bl_no", getBlNo());		
		this.hashColumns.put("rct_aply_chg_cd", getRctAplyChgCd());		
		this.hashColumns.put("ots_bal_amt", getOtsBalAmt());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("dp_prcs_knt", getDpPrcsKnt());		
		this.hashColumns.put("rct_curr_cd", getRctCurrCd());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("vndr_no", getVndrNo());		
		this.hashColumns.put("rct_aply_amt", getRctAplyAmt());		
		this.hashColumns.put("rct_seq", getRctSeq());		
		this.hashColumns.put("rct_aply_src_curr_cd", getRctAplySrcCurrCd());		
		this.hashColumns.put("wrtf_cd", getWrtfCd());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("upd_dt", getUpdDt());		
		this.hashColumns.put("ap_if_cd", getApIfCd());		
		this.hashColumns.put("ap_ofc_cd", getApOfcCd());		
		this.hashColumns.put("ots_aply_amt", getOtsAplyAmt());		
		this.hashColumns.put("rct_aply_hdr_seq", getRctAplyHdrSeq());		
		this.hashColumns.put("rct_aply_xch_rt", getRctAplyXchRt());		
		this.hashColumns.put("inv_no", getInvNo());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("ots_ofc_cd", getOtsOfcCd());		
		this.hashColumns.put("rct_aply_dtl_seq", getRctAplyDtlSeq());		
		this.hashColumns.put("rct_aply_flg", getRctAplyFlg());		
		this.hashColumns.put("rct_aply_gl_dt", getRctAplyGlDt());		
		this.hashColumns.put("pay_acct_cd", getPayAcctCd());		
		this.hashColumns.put("ap_gl_dt", getApGlDt());		
		this.hashColumns.put("ots_xch_rt", getOtsXchRt());		
		this.hashColumns.put("ap_rmk", getApRmk());		
		this.hashColumns.put("wrtf_rmk", getWrtfRmk());		
		this.hashColumns.put("ttl_aply_amt", getTtlAplyAmt());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("rct_aply_dt", "rctAplyDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("rct_aply_chg_cd", "rctAplyChgCd");
		this.hashFields.put("ots_bal_amt", "otsBalAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dp_prcs_knt", "dpPrcsKnt");
		this.hashFields.put("rct_curr_cd", "rctCurrCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vndr_no", "vndrNo");
		this.hashFields.put("rct_aply_amt", "rctAplyAmt");
		this.hashFields.put("rct_seq", "rctSeq");
		this.hashFields.put("rct_aply_src_curr_cd", "rctAplySrcCurrCd");
		this.hashFields.put("wrtf_cd", "wrtfCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("ap_if_cd", "apIfCd");
		this.hashFields.put("ap_ofc_cd", "apOfcCd");
		this.hashFields.put("ots_aply_amt", "otsAplyAmt");
		this.hashFields.put("rct_aply_hdr_seq", "rctAplyHdrSeq");
		this.hashFields.put("rct_aply_xch_rt", "rctAplyXchRt");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ots_ofc_cd", "otsOfcCd");
		this.hashFields.put("rct_aply_dtl_seq", "rctAplyDtlSeq");
		this.hashFields.put("rct_aply_flg", "rctAplyFlg");
		this.hashFields.put("rct_aply_gl_dt", "rctAplyGlDt");
		this.hashFields.put("pay_acct_cd", "payAcctCd");
		this.hashFields.put("ap_gl_dt", "apGlDt");
		this.hashFields.put("ots_xch_rt", "otsXchRt");
		this.hashFields.put("ap_rmk", "apRmk");
		this.hashFields.put("wrtf_rmk", "wrtfRmk");
		this.hashFields.put("ttl_aply_amt", "ttlAplyAmt");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  rctAplyDt
	*/
	public void	setRctAplyDt( String	rctAplyDt ) {
		this.rctAplyDt =	rctAplyDt;
	}
 
	/**
	 * Column Info
	 * @return	rctAplyDt
	 */
	 public	 String	getRctAplyDt() {
		 return	this.rctAplyDt;
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
	* @param  wrtfCd
	*/
	public void	setWrtfCd( String	wrtfCd ) {
		this.wrtfCd =	wrtfCd;
	}
 
	/**
	 * Column Info
	 * @return	wrtfCd
	 */
	 public	 String	getWrtfCd() {
		 return	this.wrtfCd;
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
	* @param  apIfCd
	*/
	public void	setApIfCd( String	apIfCd ) {
		this.apIfCd =	apIfCd;
	}
 
	/**
	 * Column Info
	 * @return	apIfCd
	 */
	 public	 String	getApIfCd() {
		 return	this.apIfCd;
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
	* @param  rctAplyGlDt
	*/
	public void	setRctAplyGlDt( String	rctAplyGlDt ) {
		this.rctAplyGlDt =	rctAplyGlDt;
	}
 
	/**
	 * Column Info
	 * @return	rctAplyGlDt
	 */
	 public	 String	getRctAplyGlDt() {
		 return	this.rctAplyGlDt;
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
	* @param  wrtfRmk
	*/
	public void	setWrtfRmk( String	wrtfRmk ) {
		this.wrtfRmk =	wrtfRmk;
	}
 
	/**
	 * Column Info
	 * @return	wrtfRmk
	 */
	 public	 String	getWrtfRmk() {
		 return	this.wrtfRmk;
	 } 
 	/**
	* Column Info
	* @param  ttlAplyAmt
	*/
	public void	setTtlAplyAmt( String	ttlAplyAmt ) {
		this.ttlAplyAmt =	ttlAplyAmt;
	}
 
	/**
	 * Column Info
	 * @return	ttlAplyAmt
	 */
	 public	 String	getTtlAplyAmt() {
		 return	this.ttlAplyAmt;
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
		setRctAplyDt(JSPUtil.getParameter(request,	prefix + "rct_aply_dt", ""));
		setCreDt(JSPUtil.getParameter(request,	prefix + "cre_dt", ""));
		setBlNo(JSPUtil.getParameter(request,	prefix + "bl_no", ""));
		setRctAplyChgCd(JSPUtil.getParameter(request,	prefix + "rct_aply_chg_cd", ""));
		setOtsBalAmt(JSPUtil.getParameter(request,	prefix + "ots_bal_amt", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setDpPrcsKnt(JSPUtil.getParameter(request,	prefix + "dp_prcs_knt", ""));
		setRctCurrCd(JSPUtil.getParameter(request,	prefix + "rct_curr_cd", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setVndrNo(JSPUtil.getParameter(request,	prefix + "vndr_no", ""));
		setRctAplyAmt(JSPUtil.getParameter(request,	prefix + "rct_aply_amt", ""));
		setRctSeq(JSPUtil.getParameter(request,	prefix + "rct_seq", ""));
		setRctAplySrcCurrCd(JSPUtil.getParameter(request,	prefix + "rct_aply_src_curr_cd", ""));
		setWrtfCd(JSPUtil.getParameter(request,	prefix + "wrtf_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request,	prefix + "upd_dt", ""));
		setApIfCd(JSPUtil.getParameter(request,	prefix + "ap_if_cd", ""));
		setApOfcCd(JSPUtil.getParameter(request,	prefix + "ap_ofc_cd", ""));
		setOtsAplyAmt(JSPUtil.getParameter(request,	prefix + "ots_aply_amt", ""));
		setRctAplyHdrSeq(JSPUtil.getParameter(request,	prefix + "rct_aply_hdr_seq", ""));
		setRctAplyXchRt(JSPUtil.getParameter(request,	prefix + "rct_aply_xch_rt", ""));
		setInvNo(JSPUtil.getParameter(request,	prefix + "inv_no", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setOtsOfcCd(JSPUtil.getParameter(request,	prefix + "ots_ofc_cd", ""));
		setRctAplyDtlSeq(JSPUtil.getParameter(request,	prefix + "rct_aply_dtl_seq", ""));
		setRctAplyFlg(JSPUtil.getParameter(request,	prefix + "rct_aply_flg", ""));
		setRctAplyGlDt(JSPUtil.getParameter(request,	prefix + "rct_aply_gl_dt", ""));
		setPayAcctCd(JSPUtil.getParameter(request,	prefix + "pay_acct_cd", ""));
		setApGlDt(JSPUtil.getParameter(request,	prefix + "ap_gl_dt", ""));
		setOtsXchRt(JSPUtil.getParameter(request,	prefix + "ots_xch_rt", ""));
		setApRmk(JSPUtil.getParameter(request,	prefix + "ap_rmk", ""));
		setWrtfRmk(JSPUtil.getParameter(request,	prefix + "wrtf_rmk", ""));
		setTtlAplyAmt(JSPUtil.getParameter(request,	prefix + "ttl_aply_amt", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ApplyDetailVO[]
	 */
	public ApplyDetailVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return ApplyDetailVO[]
	 */
	public ApplyDetailVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		ApplyDetailVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] rctAplyDt =	(JSPUtil.getParameter(request, prefix +	"rct_aply_dt".trim(),	length));
				String[] creDt =	(JSPUtil.getParameter(request, prefix +	"cre_dt".trim(),	length));
				String[] blNo =	(JSPUtil.getParameter(request, prefix +	"bl_no".trim(),	length));
				String[] rctAplyChgCd =	(JSPUtil.getParameter(request, prefix +	"rct_aply_chg_cd".trim(),	length));
				String[] otsBalAmt =	(JSPUtil.getParameter(request, prefix +	"ots_bal_amt".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] dpPrcsKnt =	(JSPUtil.getParameter(request, prefix +	"dp_prcs_knt".trim(),	length));
				String[] rctCurrCd =	(JSPUtil.getParameter(request, prefix +	"rct_curr_cd".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] vndrNo =	(JSPUtil.getParameter(request, prefix +	"vndr_no".trim(),	length));
				String[] rctAplyAmt =	(JSPUtil.getParameter(request, prefix +	"rct_aply_amt".trim(),	length));
				String[] rctSeq =	(JSPUtil.getParameter(request, prefix +	"rct_seq".trim(),	length));
				String[] rctAplySrcCurrCd =	(JSPUtil.getParameter(request, prefix +	"rct_aply_src_curr_cd".trim(),	length));
				String[] wrtfCd =	(JSPUtil.getParameter(request, prefix +	"wrtf_cd".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] updDt =	(JSPUtil.getParameter(request, prefix +	"upd_dt".trim(),	length));
				String[] apIfCd =	(JSPUtil.getParameter(request, prefix +	"ap_if_cd".trim(),	length));
				String[] apOfcCd =	(JSPUtil.getParameter(request, prefix +	"ap_ofc_cd".trim(),	length));
				String[] otsAplyAmt =	(JSPUtil.getParameter(request, prefix +	"ots_aply_amt".trim(),	length));
				String[] rctAplyHdrSeq =	(JSPUtil.getParameter(request, prefix +	"rct_aply_hdr_seq".trim(),	length));
				String[] rctAplyXchRt =	(JSPUtil.getParameter(request, prefix +	"rct_aply_xch_rt".trim(),	length));
				String[] invNo =	(JSPUtil.getParameter(request, prefix +	"inv_no".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				String[] otsOfcCd =	(JSPUtil.getParameter(request, prefix +	"ots_ofc_cd".trim(),	length));
				String[] rctAplyDtlSeq =	(JSPUtil.getParameter(request, prefix +	"rct_aply_dtl_seq".trim(),	length));
				String[] rctAplyFlg =	(JSPUtil.getParameter(request, prefix +	"rct_aply_flg".trim(),	length));
				String[] rctAplyGlDt =	(JSPUtil.getParameter(request, prefix +	"rct_aply_gl_dt".trim(),	length));
				String[] payAcctCd =	(JSPUtil.getParameter(request, prefix +	"pay_acct_cd".trim(),	length));
				String[] apGlDt =	(JSPUtil.getParameter(request, prefix +	"ap_gl_dt".trim(),	length));
				String[] otsXchRt =	(JSPUtil.getParameter(request, prefix +	"ots_xch_rt".trim(),	length));
				String[] apRmk =	(JSPUtil.getParameter(request, prefix +	"ap_rmk".trim(),	length));
				String[] wrtfRmk =	(JSPUtil.getParameter(request, prefix +	"wrtf_rmk".trim(),	length));
				String[] ttlAplyAmt =	(JSPUtil.getParameter(request, prefix +	"ttl_aply_amt".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	ApplyDetailVO();
						if ( rctAplyDt[i] !=	null)
						model.setRctAplyDt( rctAplyDt[i]);
						if ( creDt[i] !=	null)
						model.setCreDt( creDt[i]);
						if ( blNo[i] !=	null)
						model.setBlNo( blNo[i]);
						if ( rctAplyChgCd[i] !=	null)
						model.setRctAplyChgCd( rctAplyChgCd[i]);
						if ( otsBalAmt[i] !=	null)
						model.setOtsBalAmt( otsBalAmt[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( dpPrcsKnt[i] !=	null)
						model.setDpPrcsKnt( dpPrcsKnt[i]);
						if ( rctCurrCd[i] !=	null)
						model.setRctCurrCd( rctCurrCd[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( vndrNo[i] !=	null)
						model.setVndrNo( vndrNo[i]);
						if ( rctAplyAmt[i] !=	null)
						model.setRctAplyAmt( rctAplyAmt[i]);
						if ( rctSeq[i] !=	null)
						model.setRctSeq( rctSeq[i]);
						if ( rctAplySrcCurrCd[i] !=	null)
						model.setRctAplySrcCurrCd( rctAplySrcCurrCd[i]);
						if ( wrtfCd[i] !=	null)
						model.setWrtfCd( wrtfCd[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( updDt[i] !=	null)
						model.setUpdDt( updDt[i]);
						if ( apIfCd[i] !=	null)
						model.setApIfCd( apIfCd[i]);
						if ( apOfcCd[i] !=	null)
						model.setApOfcCd( apOfcCd[i]);
						if ( otsAplyAmt[i] !=	null)
						model.setOtsAplyAmt( otsAplyAmt[i]);
						if ( rctAplyHdrSeq[i] !=	null)
						model.setRctAplyHdrSeq( rctAplyHdrSeq[i]);
						if ( rctAplyXchRt[i] !=	null)
						model.setRctAplyXchRt( rctAplyXchRt[i]);
						if ( invNo[i] !=	null)
						model.setInvNo( invNo[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
						if ( otsOfcCd[i] !=	null)
						model.setOtsOfcCd( otsOfcCd[i]);
						if ( rctAplyDtlSeq[i] !=	null)
						model.setRctAplyDtlSeq( rctAplyDtlSeq[i]);
						if ( rctAplyFlg[i] !=	null)
						model.setRctAplyFlg( rctAplyFlg[i]);
						if ( rctAplyGlDt[i] !=	null)
						model.setRctAplyGlDt( rctAplyGlDt[i]);
						if ( payAcctCd[i] !=	null)
						model.setPayAcctCd( payAcctCd[i]);
						if ( apGlDt[i] !=	null)
						model.setApGlDt( apGlDt[i]);
						if ( otsXchRt[i] !=	null)
						model.setOtsXchRt( otsXchRt[i]);
						if ( apRmk[i] !=	null)
						model.setApRmk( apRmk[i]);
						if ( wrtfRmk[i] !=	null)
						model.setWrtfRmk( wrtfRmk[i]);
						if ( ttlAplyAmt[i] !=	null)
						model.setTtlAplyAmt( ttlAplyAmt[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getApplyDetailVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return ApplyDetailVO[]
	 */
	public ApplyDetailVO[]	 getApplyDetailVOs(){
		ApplyDetailVO[] vos = (ApplyDetailVO[])models.toArray(new	ApplyDetailVO[models.size()]);
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
		this.rctAplyDt =	this.rctAplyDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt =	this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo =	this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctAplyChgCd =	this.rctAplyChgCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsBalAmt =	this.otsBalAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpPrcsKnt =	this.dpPrcsKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctCurrCd =	this.rctCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNo =	this.vndrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctAplyAmt =	this.rctAplyAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctSeq =	this.rctSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctAplySrcCurrCd =	this.rctAplySrcCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wrtfCd =	this.wrtfCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt =	this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apIfCd =	this.apIfCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apOfcCd =	this.apOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsAplyAmt =	this.otsAplyAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctAplyHdrSeq =	this.rctAplyHdrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctAplyXchRt =	this.rctAplyXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo =	this.invNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsOfcCd =	this.otsOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctAplyDtlSeq =	this.rctAplyDtlSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctAplyFlg =	this.rctAplyFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctAplyGlDt =	this.rctAplyGlDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payAcctCd =	this.payAcctCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apGlDt =	this.apGlDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsXchRt =	this.otsXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apRmk =	this.apRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wrtfRmk =	this.wrtfRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlAplyAmt =	this.ttlAplyAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}