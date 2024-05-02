/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ReceivableChargeDetailVO.java
 *@FileTitle : ReceivableChargeDetailVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.12.12
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2016.12.12  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.ees.lse.containerrentalcost.receivablerentalcost.vo;

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
public class ReceivableChargeDetailVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<ReceivableChargeDetailVO>  models =	new	ArrayList<ReceivableChargeDetailVO>();


	/*	Column Info	*/
	private  String	 offhLocCd   =  null;
	/*	Column Info	*/
	private  String	 onhDt   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 pkupChgFlg   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 costYrmon   =  null;
	/*	Column Info	*/
	private  String	 costAmt   =  null;
	/*	Column Info	*/
	private  String	 bilDys   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd   =  null;
	/*	Column Info	*/
	private  String	 agmtCtyCd   =  null;
	/*	Column Info	*/
	private  String	 bilToDt   =  null;
	/*	Column Info	*/
	private  String	 offhDt   =  null;
	/*	Column Info	*/
	private  String	 lstmCd   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 rcvRntlSeq   =  null;
	/*	Column Info	*/
	private  String	 rcvRntlDtlSeq   =  null;
	/*	Column Info	*/
	private  String	 bilFmDt   =  null;
	/*	Column Info	*/
	private  String	 agmtSeq   =  null;
	/*	Column Info	*/
	private  String	 lseRcvChgTpCd   =  null;
	/*	Column Info	*/
	private  String	 lftChgAmt   =  null;
	/*	Column Info	*/
	private  String	 onhLocCd   =  null;
	/*	Column Info	*/
	private  String	 ttlDys   =  null;
	/*	Column Info	*/
	private  String	 ofcCd   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;
	/*	Column Info	*/
	private  String	 freeDys   =  null;
	/*	Column Info	*/
	private  String	 cntrNo   =  null;
	/*	Column Info	*/
	private  String	 pkupChgAmt   =  null;
	/*	Column Info	*/
	private  String	 lonChgFlg   =  null;
	/*	Column Info	*/
	private  String	 lofChgFlg   =  null;
	/*	Column Info	*/
	private  String	 chgRtAmt   =  null;
	/*	Column Info	*/
	private  String	 crAmt   =  null;
	/*	Column Info	*/
	private  String	 gtiChgFlg   =  null;
	/*	Column Info	*/
	private  String	 gtiChgAmt   =  null;
	/*	Column Info	*/
	private  String	 gtoChgFlg   =  null;
	/*	Column Info	*/
	private  String	 gtoChgAmt   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public ReceivableChargeDetailVO(){}

	public ReceivableChargeDetailVO(String offhLocCd,String onhDt,String pagerows,String pkupChgFlg,String ibflag,String costYrmon,String costAmt,String bilDys,String cntrTpszCd,String agmtCtyCd,String bilToDt,String offhDt,String lstmCd,String updUsrId,String rcvRntlSeq,String rcvRntlDtlSeq,String bilFmDt,String agmtSeq,String lseRcvChgTpCd,String lftChgAmt,String onhLocCd,String ttlDys,String ofcCd,String creUsrId,String freeDys,String cntrNo,String pkupChgAmt,String lonChgFlg,String lofChgFlg,String chgRtAmt,String crAmt,String gtiChgFlg,String gtiChgAmt,String gtoChgFlg,String gtoChgAmt)	{
		this.offhLocCd  = offhLocCd ;
		this.onhDt  = onhDt ;
		this.pagerows  = pagerows ;
		this.pkupChgFlg  = pkupChgFlg ;
		this.ibflag  = ibflag ;
		this.costYrmon  = costYrmon ;
		this.costAmt  = costAmt ;
		this.bilDys  = bilDys ;
		this.cntrTpszCd  = cntrTpszCd ;
		this.agmtCtyCd  = agmtCtyCd ;
		this.bilToDt  = bilToDt ;
		this.offhDt  = offhDt ;
		this.lstmCd  = lstmCd ;
		this.updUsrId  = updUsrId ;
		this.rcvRntlSeq  = rcvRntlSeq ;
		this.rcvRntlDtlSeq  = rcvRntlDtlSeq ;
		this.bilFmDt  = bilFmDt ;
		this.agmtSeq  = agmtSeq ;
		this.lseRcvChgTpCd  = lseRcvChgTpCd ;
		this.lftChgAmt  = lftChgAmt ;
		this.onhLocCd  = onhLocCd ;
		this.ttlDys  = ttlDys ;
		this.ofcCd  = ofcCd ;
		this.creUsrId  = creUsrId ;
		this.freeDys  = freeDys ;
		this.cntrNo  = cntrNo ;
		this.pkupChgAmt  = pkupChgAmt ;
		this.lonChgFlg  = lonChgFlg ;
		this.lofChgFlg  = lofChgFlg ;
		this.chgRtAmt  = chgRtAmt ;
		this.crAmt  = crAmt ;
		this.gtiChgFlg  = gtiChgFlg ;
		this.gtiChgAmt  = gtiChgAmt ;
		this.gtoChgFlg  = gtoChgFlg ;
		this.gtoChgAmt  = gtoChgAmt ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("offh_loc_cd", getOffhLocCd());		
		this.hashColumns.put("onh_dt", getOnhDt());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("pkup_chg_flg", getPkupChgFlg());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("cost_yrmon", getCostYrmon());		
		this.hashColumns.put("cost_amt", getCostAmt());		
		this.hashColumns.put("bil_dys", getBilDys());		
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());		
		this.hashColumns.put("agmt_cty_cd", getAgmtCtyCd());		
		this.hashColumns.put("bil_to_dt", getBilToDt());		
		this.hashColumns.put("offh_dt", getOffhDt());		
		this.hashColumns.put("lstm_cd", getLstmCd());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("rcv_rntl_seq", getRcvRntlSeq());		
		this.hashColumns.put("rcv_rntl_dtl_seq", getRcvRntlDtlSeq());		
		this.hashColumns.put("bil_fm_dt", getBilFmDt());		
		this.hashColumns.put("agmt_seq", getAgmtSeq());		
		this.hashColumns.put("lse_rcv_chg_tp_cd", getLseRcvChgTpCd());		
		this.hashColumns.put("lft_chg_amt", getLftChgAmt());		
		this.hashColumns.put("onh_loc_cd", getOnhLocCd());		
		this.hashColumns.put("ttl_dys", getTtlDys());		
		this.hashColumns.put("ofc_cd", getOfcCd());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("free_dys", getFreeDys());		
		this.hashColumns.put("cntr_no", getCntrNo());		
		this.hashColumns.put("pkup_chg_amt", getPkupChgAmt());		
		this.hashColumns.put("lon_chg_flg", getLonChgFlg());		
		this.hashColumns.put("lof_chg_flg", getLofChgFlg());		
		this.hashColumns.put("chg_rt_amt", getChgRtAmt());		
		this.hashColumns.put("cr_amt", getCrAmt());		
		this.hashColumns.put("gti_chg_flg", getGtiChgFlg());		
		this.hashColumns.put("gti_chg_amt", getGtiChgAmt());		
		this.hashColumns.put("gto_chg_flg", getGtoChgFlg());		
		this.hashColumns.put("gto_chg_amt", getGtoChgAmt());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("offh_loc_cd", "offhLocCd");
		this.hashFields.put("onh_dt", "onhDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pkup_chg_flg", "pkupChgFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("cost_amt", "costAmt");
		this.hashFields.put("bil_dys", "bilDys");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("agmt_cty_cd", "agmtCtyCd");
		this.hashFields.put("bil_to_dt", "bilToDt");
		this.hashFields.put("offh_dt", "offhDt");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("rcv_rntl_seq", "rcvRntlSeq");
		this.hashFields.put("rcv_rntl_dtl_seq", "rcvRntlDtlSeq");
		this.hashFields.put("bil_fm_dt", "bilFmDt");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("lse_rcv_chg_tp_cd", "lseRcvChgTpCd");
		this.hashFields.put("lft_chg_amt", "lftChgAmt");
		this.hashFields.put("onh_loc_cd", "onhLocCd");
		this.hashFields.put("ttl_dys", "ttlDys");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("free_dys", "freeDys");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("pkup_chg_amt", "pkupChgAmt");
		this.hashFields.put("lon_chg_flg", "lonChgFlg");
		this.hashFields.put("lof_chg_flg", "lofChgFlg");
		this.hashFields.put("chg_rt_amt", "chgRtAmt");
		this.hashFields.put("cr_amt", "crAmt");
		this.hashFields.put("gti_chg_flg", "gtiChgFlg");
		this.hashFields.put("gti_chg_amt", "gtiChgAmt");
		this.hashFields.put("gto_chg_flg", "gtoChgFlg");
		this.hashFields.put("gto_chg_amt", "gtoChgAmt");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  offhLocCd
	*/
	public void	setOffhLocCd( String	offhLocCd ) {
		this.offhLocCd =	offhLocCd;
	}
 
	/**
	 * Column Info
	 * @return	offhLocCd
	 */
	 public	 String	getOffhLocCd() {
		 return	this.offhLocCd;
	 } 
 	/**
	* Column Info
	* @param  onhDt
	*/
	public void	setOnhDt( String	onhDt ) {
		this.onhDt =	onhDt;
	}
 
	/**
	 * Column Info
	 * @return	onhDt
	 */
	 public	 String	getOnhDt() {
		 return	this.onhDt;
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
	* @param  pkupChgFlg
	*/
	public void	setPkupChgFlg( String	pkupChgFlg ) {
		this.pkupChgFlg =	pkupChgFlg;
	}
 
	/**
	 * Column Info
	 * @return	pkupChgFlg
	 */
	 public	 String	getPkupChgFlg() {
		 return	this.pkupChgFlg;
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
	* @param  costYrmon
	*/
	public void	setCostYrmon( String	costYrmon ) {
		this.costYrmon =	costYrmon;
	}
 
	/**
	 * Column Info
	 * @return	costYrmon
	 */
	 public	 String	getCostYrmon() {
		 return	this.costYrmon;
	 } 
 	/**
	* Column Info
	* @param  costAmt
	*/
	public void	setCostAmt( String	costAmt ) {
		this.costAmt =	costAmt;
	}
 
	/**
	 * Column Info
	 * @return	costAmt
	 */
	 public	 String	getCostAmt() {
		 return	this.costAmt;
	 } 
 	/**
	* Column Info
	* @param  bilDys
	*/
	public void	setBilDys( String	bilDys ) {
		this.bilDys =	bilDys;
	}
 
	/**
	 * Column Info
	 * @return	bilDys
	 */
	 public	 String	getBilDys() {
		 return	this.bilDys;
	 } 
 	/**
	* Column Info
	* @param  cntrTpszCd
	*/
	public void	setCntrTpszCd( String	cntrTpszCd ) {
		this.cntrTpszCd =	cntrTpszCd;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd
	 */
	 public	 String	getCntrTpszCd() {
		 return	this.cntrTpszCd;
	 } 
 	/**
	* Column Info
	* @param  agmtCtyCd
	*/
	public void	setAgmtCtyCd( String	agmtCtyCd ) {
		this.agmtCtyCd =	agmtCtyCd;
	}
 
	/**
	 * Column Info
	 * @return	agmtCtyCd
	 */
	 public	 String	getAgmtCtyCd() {
		 return	this.agmtCtyCd;
	 } 
 	/**
	* Column Info
	* @param  bilToDt
	*/
	public void	setBilToDt( String	bilToDt ) {
		this.bilToDt =	bilToDt;
	}
 
	/**
	 * Column Info
	 * @return	bilToDt
	 */
	 public	 String	getBilToDt() {
		 return	this.bilToDt;
	 } 
 	/**
	* Column Info
	* @param  offhDt
	*/
	public void	setOffhDt( String	offhDt ) {
		this.offhDt =	offhDt;
	}
 
	/**
	 * Column Info
	 * @return	offhDt
	 */
	 public	 String	getOffhDt() {
		 return	this.offhDt;
	 } 
 	/**
	* Column Info
	* @param  lstmCd
	*/
	public void	setLstmCd( String	lstmCd ) {
		this.lstmCd =	lstmCd;
	}
 
	/**
	 * Column Info
	 * @return	lstmCd
	 */
	 public	 String	getLstmCd() {
		 return	this.lstmCd;
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
	* @param  rcvRntlSeq
	*/
	public void	setRcvRntlSeq( String	rcvRntlSeq ) {
		this.rcvRntlSeq =	rcvRntlSeq;
	}
 
	/**
	 * Column Info
	 * @return	rcvRntlSeq
	 */
	 public	 String	getRcvRntlSeq() {
		 return	this.rcvRntlSeq;
	 } 
 	/**
	* Column Info
	* @param  rcvRntlDtlSeq
	*/
	public void	setRcvRntlDtlSeq( String	rcvRntlDtlSeq ) {
		this.rcvRntlDtlSeq =	rcvRntlDtlSeq;
	}
 
	/**
	 * Column Info
	 * @return	rcvRntlDtlSeq
	 */
	 public	 String	getRcvRntlDtlSeq() {
		 return	this.rcvRntlDtlSeq;
	 } 
 	/**
	* Column Info
	* @param  bilFmDt
	*/
	public void	setBilFmDt( String	bilFmDt ) {
		this.bilFmDt =	bilFmDt;
	}
 
	/**
	 * Column Info
	 * @return	bilFmDt
	 */
	 public	 String	getBilFmDt() {
		 return	this.bilFmDt;
	 } 
 	/**
	* Column Info
	* @param  agmtSeq
	*/
	public void	setAgmtSeq( String	agmtSeq ) {
		this.agmtSeq =	agmtSeq;
	}
 
	/**
	 * Column Info
	 * @return	agmtSeq
	 */
	 public	 String	getAgmtSeq() {
		 return	this.agmtSeq;
	 } 
 	/**
	* Column Info
	* @param  lseRcvChgTpCd
	*/
	public void	setLseRcvChgTpCd( String	lseRcvChgTpCd ) {
		this.lseRcvChgTpCd =	lseRcvChgTpCd;
	}
 
	/**
	 * Column Info
	 * @return	lseRcvChgTpCd
	 */
	 public	 String	getLseRcvChgTpCd() {
		 return	this.lseRcvChgTpCd;
	 } 
 	/**
	* Column Info
	* @param  lftChgAmt
	*/
	public void	setLftChgAmt( String	lftChgAmt ) {
		this.lftChgAmt =	lftChgAmt;
	}
 
	/**
	 * Column Info
	 * @return	lftChgAmt
	 */
	 public	 String	getLftChgAmt() {
		 return	this.lftChgAmt;
	 } 
 	/**
	* Column Info
	* @param  onhLocCd
	*/
	public void	setOnhLocCd( String	onhLocCd ) {
		this.onhLocCd =	onhLocCd;
	}
 
	/**
	 * Column Info
	 * @return	onhLocCd
	 */
	 public	 String	getOnhLocCd() {
		 return	this.onhLocCd;
	 } 
 	/**
	* Column Info
	* @param  ttlDys
	*/
	public void	setTtlDys( String	ttlDys ) {
		this.ttlDys =	ttlDys;
	}
 
	/**
	 * Column Info
	 * @return	ttlDys
	 */
	 public	 String	getTtlDys() {
		 return	this.ttlDys;
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
	* @param  freeDys
	*/
	public void	setFreeDys( String	freeDys ) {
		this.freeDys =	freeDys;
	}
 
	/**
	 * Column Info
	 * @return	freeDys
	 */
	 public	 String	getFreeDys() {
		 return	this.freeDys;
	 } 
 	/**
	* Column Info
	* @param  cntrNo
	*/
	public void	setCntrNo( String	cntrNo ) {
		this.cntrNo =	cntrNo;
	}
 
	/**
	 * Column Info
	 * @return	cntrNo
	 */
	 public	 String	getCntrNo() {
		 return	this.cntrNo;
	 } 
 	/**
	* Column Info
	* @param  pkupChgAmt
	*/
	public void	setPkupChgAmt( String	pkupChgAmt ) {
		this.pkupChgAmt =	pkupChgAmt;
	}
 
	/**
	 * Column Info
	 * @return	pkupChgAmt
	 */
	 public	 String	getPkupChgAmt() {
		 return	this.pkupChgAmt;
	 } 
 	/**
	* Column Info
	* @param  lonChgFlg
	*/
	public void	setLonChgFlg( String	lonChgFlg ) {
		this.lonChgFlg =	lonChgFlg;
	}
 
	/**
	 * Column Info
	 * @return	lonChgFlg
	 */
	 public	 String	getLonChgFlg() {
		 return	this.lonChgFlg;
	 } 
 	/**
	* Column Info
	* @param  lofChgFlg
	*/
	public void	setLofChgFlg( String	lofChgFlg ) {
		this.lofChgFlg =	lofChgFlg;
	}
 
	/**
	 * Column Info
	 * @return	lofChgFlg
	 */
	 public	 String	getLofChgFlg() {
		 return	this.lofChgFlg;
	 } 
 	/**
	* Column Info
	* @param  chgRtAmt
	*/
	public void	setChgRtAmt( String	chgRtAmt ) {
		this.chgRtAmt =	chgRtAmt;
	}
 
	/**
	 * Column Info
	 * @return	chgRtAmt
	 */
	 public	 String	getChgRtAmt() {
		 return	this.chgRtAmt;
	 } 
 	/**
	* Column Info
	* @param  crAmt
	*/
	public void	setCrAmt( String	crAmt ) {
		this.crAmt =	crAmt;
	}
 
	/**
	 * Column Info
	 * @return	crAmt
	 */
	 public	 String	getCrAmt() {
		 return	this.crAmt;
	 } 
 	/**
	* Column Info
	* @param  gtiChgFlg
	*/
	public void	setGtiChgFlg( String	gtiChgFlg ) {
		this.gtiChgFlg =	gtiChgFlg;
	}
 
	/**
	 * Column Info
	 * @return	gtiChgFlg
	 */
	 public	 String	getGtiChgFlg() {
		 return	this.gtiChgFlg;
	 } 
 	/**
	* Column Info
	* @param  gtiChgAmt
	*/
	public void	setGtiChgAmt( String	gtiChgAmt ) {
		this.gtiChgAmt =	gtiChgAmt;
	}
 
	/**
	 * Column Info
	 * @return	gtiChgAmt
	 */
	 public	 String	getGtiChgAmt() {
		 return	this.gtiChgAmt;
	 } 
 	/**
	* Column Info
	* @param  gtoChgFlg
	*/
	public void	setGtoChgFlg( String	gtoChgFlg ) {
		this.gtoChgFlg =	gtoChgFlg;
	}
 
	/**
	 * Column Info
	 * @return	gtoChgFlg
	 */
	 public	 String	getGtoChgFlg() {
		 return	this.gtoChgFlg;
	 } 
 	/**
	* Column Info
	* @param  gtoChgAmt
	*/
	public void	setGtoChgAmt( String	gtoChgAmt ) {
		this.gtoChgAmt =	gtoChgAmt;
	}
 
	/**
	 * Column Info
	 * @return	gtoChgAmt
	 */
	 public	 String	getGtoChgAmt() {
		 return	this.gtoChgAmt;
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
		setOffhLocCd(JSPUtil.getParameter(request,	prefix + "offh_loc_cd", ""));
		setOnhDt(JSPUtil.getParameter(request,	prefix + "onh_dt", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setPkupChgFlg(JSPUtil.getParameter(request,	prefix + "pkup_chg_flg", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setCostYrmon(JSPUtil.getParameter(request,	prefix + "cost_yrmon", ""));
		setCostAmt(JSPUtil.getParameter(request,	prefix + "cost_amt", ""));
		setBilDys(JSPUtil.getParameter(request,	prefix + "bil_dys", ""));
		setCntrTpszCd(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd", ""));
		setAgmtCtyCd(JSPUtil.getParameter(request,	prefix + "agmt_cty_cd", ""));
		setBilToDt(JSPUtil.getParameter(request,	prefix + "bil_to_dt", ""));
		setOffhDt(JSPUtil.getParameter(request,	prefix + "offh_dt", ""));
		setLstmCd(JSPUtil.getParameter(request,	prefix + "lstm_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setRcvRntlSeq(JSPUtil.getParameter(request,	prefix + "rcv_rntl_seq", ""));
		setRcvRntlDtlSeq(JSPUtil.getParameter(request,	prefix + "rcv_rntl_dtl_seq", ""));
		setBilFmDt(JSPUtil.getParameter(request,	prefix + "bil_fm_dt", ""));
		setAgmtSeq(JSPUtil.getParameter(request,	prefix + "agmt_seq", ""));
		setLseRcvChgTpCd(JSPUtil.getParameter(request,	prefix + "lse_rcv_chg_tp_cd", ""));
		setLftChgAmt(JSPUtil.getParameter(request,	prefix + "lft_chg_amt", ""));
		setOnhLocCd(JSPUtil.getParameter(request,	prefix + "onh_loc_cd", ""));
		setTtlDys(JSPUtil.getParameter(request,	prefix + "ttl_dys", ""));
		setOfcCd(JSPUtil.getParameter(request,	prefix + "ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setFreeDys(JSPUtil.getParameter(request,	prefix + "free_dys", ""));
		setCntrNo(JSPUtil.getParameter(request,	prefix + "cntr_no", ""));
		setPkupChgAmt(JSPUtil.getParameter(request,	prefix + "pkup_chg_amt", ""));
		setLonChgFlg(JSPUtil.getParameter(request,	prefix + "lon_chg_flg", ""));
		setLofChgFlg(JSPUtil.getParameter(request,	prefix + "lof_chg_flg", ""));
		setChgRtAmt(JSPUtil.getParameter(request,	prefix + "chg_rt_amt", ""));
		setCrAmt(JSPUtil.getParameter(request,	prefix + "cr_amt", ""));
		setGtiChgFlg(JSPUtil.getParameter(request,	prefix + "gti_chg_flg", ""));
		setGtiChgAmt(JSPUtil.getParameter(request,	prefix + "gti_chg_amt", ""));
		setGtoChgFlg(JSPUtil.getParameter(request,	prefix + "gto_chg_flg", ""));
		setGtoChgAmt(JSPUtil.getParameter(request,	prefix + "gto_chg_amt", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ReceivableChargeDetailVO[]
	 */
	public ReceivableChargeDetailVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return ReceivableChargeDetailVO[]
	 */
	public ReceivableChargeDetailVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		ReceivableChargeDetailVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] offhLocCd =	(JSPUtil.getParameter(request, prefix +	"offh_loc_cd".trim(),	length));
				String[] onhDt =	(JSPUtil.getParameter(request, prefix +	"onh_dt".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] pkupChgFlg =	(JSPUtil.getParameter(request, prefix +	"pkup_chg_flg".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] costYrmon =	(JSPUtil.getParameter(request, prefix +	"cost_yrmon".trim(),	length));
				String[] costAmt =	(JSPUtil.getParameter(request, prefix +	"cost_amt".trim(),	length));
				String[] bilDys =	(JSPUtil.getParameter(request, prefix +	"bil_dys".trim(),	length));
				String[] cntrTpszCd =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd".trim(),	length));
				String[] agmtCtyCd =	(JSPUtil.getParameter(request, prefix +	"agmt_cty_cd".trim(),	length));
				String[] bilToDt =	(JSPUtil.getParameter(request, prefix +	"bil_to_dt".trim(),	length));
				String[] offhDt =	(JSPUtil.getParameter(request, prefix +	"offh_dt".trim(),	length));
				String[] lstmCd =	(JSPUtil.getParameter(request, prefix +	"lstm_cd".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] rcvRntlSeq =	(JSPUtil.getParameter(request, prefix +	"rcv_rntl_seq".trim(),	length));
				String[] rcvRntlDtlSeq =	(JSPUtil.getParameter(request, prefix +	"rcv_rntl_dtl_seq".trim(),	length));
				String[] bilFmDt =	(JSPUtil.getParameter(request, prefix +	"bil_fm_dt".trim(),	length));
				String[] agmtSeq =	(JSPUtil.getParameter(request, prefix +	"agmt_seq".trim(),	length));
				String[] lseRcvChgTpCd =	(JSPUtil.getParameter(request, prefix +	"lse_rcv_chg_tp_cd".trim(),	length));
				String[] lftChgAmt =	(JSPUtil.getParameter(request, prefix +	"lft_chg_amt".trim(),	length));
				String[] onhLocCd =	(JSPUtil.getParameter(request, prefix +	"onh_loc_cd".trim(),	length));
				String[] ttlDys =	(JSPUtil.getParameter(request, prefix +	"ttl_dys".trim(),	length));
				String[] ofcCd =	(JSPUtil.getParameter(request, prefix +	"ofc_cd".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				String[] freeDys =	(JSPUtil.getParameter(request, prefix +	"free_dys".trim(),	length));
				String[] cntrNo =	(JSPUtil.getParameter(request, prefix +	"cntr_no".trim(),	length));
				String[] pkupChgAmt =	(JSPUtil.getParameter(request, prefix +	"pkup_chg_amt".trim(),	length));
				String[] lonChgFlg =	(JSPUtil.getParameter(request, prefix +	"lon_chg_flg".trim(),	length));
				String[] lofChgFlg =	(JSPUtil.getParameter(request, prefix +	"lof_chg_flg".trim(),	length));
				String[] chgRtAmt =	(JSPUtil.getParameter(request, prefix +	"chg_rt_amt".trim(),	length));
				String[] crAmt =	(JSPUtil.getParameter(request, prefix +	"cr_amt".trim(),	length));
				String[] gtiChgFlg =	(JSPUtil.getParameter(request, prefix +	"gti_chg_flg".trim(),	length));
				String[] gtiChgAmt =	(JSPUtil.getParameter(request, prefix +	"gti_chg_amt".trim(),	length));
				String[] gtoChgFlg =	(JSPUtil.getParameter(request, prefix +	"gto_chg_flg".trim(),	length));
				String[] gtoChgAmt =	(JSPUtil.getParameter(request, prefix +	"gto_chg_amt".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	ReceivableChargeDetailVO();
						if ( offhLocCd[i] !=	null)
						model.setOffhLocCd( offhLocCd[i]);
						if ( onhDt[i] !=	null)
						model.setOnhDt( onhDt[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( pkupChgFlg[i] !=	null)
						model.setPkupChgFlg( pkupChgFlg[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( costYrmon[i] !=	null)
						model.setCostYrmon( costYrmon[i]);
						if ( costAmt[i] !=	null)
						model.setCostAmt( costAmt[i]);
						if ( bilDys[i] !=	null)
						model.setBilDys( bilDys[i]);
						if ( cntrTpszCd[i] !=	null)
						model.setCntrTpszCd( cntrTpszCd[i]);
						if ( agmtCtyCd[i] !=	null)
						model.setAgmtCtyCd( agmtCtyCd[i]);
						if ( bilToDt[i] !=	null)
						model.setBilToDt( bilToDt[i]);
						if ( offhDt[i] !=	null)
						model.setOffhDt( offhDt[i]);
						if ( lstmCd[i] !=	null)
						model.setLstmCd( lstmCd[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( rcvRntlSeq[i] !=	null)
						model.setRcvRntlSeq( rcvRntlSeq[i]);
						if ( rcvRntlDtlSeq[i] !=	null)
						model.setRcvRntlDtlSeq( rcvRntlDtlSeq[i]);
						if ( bilFmDt[i] !=	null)
						model.setBilFmDt( bilFmDt[i]);
						if ( agmtSeq[i] !=	null)
						model.setAgmtSeq( agmtSeq[i]);
						if ( lseRcvChgTpCd[i] !=	null)
						model.setLseRcvChgTpCd( lseRcvChgTpCd[i]);
						if ( lftChgAmt[i] !=	null)
						model.setLftChgAmt( lftChgAmt[i]);
						if ( onhLocCd[i] !=	null)
						model.setOnhLocCd( onhLocCd[i]);
						if ( ttlDys[i] !=	null)
						model.setTtlDys( ttlDys[i]);
						if ( ofcCd[i] !=	null)
						model.setOfcCd( ofcCd[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
						if ( freeDys[i] !=	null)
						model.setFreeDys( freeDys[i]);
						if ( cntrNo[i] !=	null)
						model.setCntrNo( cntrNo[i]);
						if ( pkupChgAmt[i] !=	null)
						model.setPkupChgAmt( pkupChgAmt[i]);
						if ( lonChgFlg[i] !=	null)
						model.setLonChgFlg( lonChgFlg[i]);
						if ( lofChgFlg[i] !=	null)
						model.setLofChgFlg( lofChgFlg[i]);
						if ( chgRtAmt[i] !=	null)
						model.setChgRtAmt( chgRtAmt[i]);
						if ( crAmt[i] !=	null)
						model.setCrAmt( crAmt[i]);
						if ( gtiChgFlg[i] !=	null)
						model.setGtiChgFlg( gtiChgFlg[i]);
						if ( gtiChgAmt[i] !=	null)
						model.setGtiChgAmt( gtiChgAmt[i]);
						if ( gtoChgFlg[i] !=	null)
						model.setGtoChgFlg( gtoChgFlg[i]);
						if ( gtoChgAmt[i] !=	null)
						model.setGtoChgAmt( gtoChgAmt[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getReceivableChargeDetailVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return ReceivableChargeDetailVO[]
	 */
	public ReceivableChargeDetailVO[]	 getReceivableChargeDetailVOs(){
		ReceivableChargeDetailVO[] vos = (ReceivableChargeDetailVO[])models.toArray(new	ReceivableChargeDetailVO[models.size()]);
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
		this.offhLocCd =	this.offhLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhDt =	this.onhDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupChgFlg =	this.pkupChgFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon =	this.costYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costAmt =	this.costAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilDys =	this.bilDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd =	this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCtyCd =	this.agmtCtyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilToDt =	this.bilToDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offhDt =	this.offhDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd =	this.lstmCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvRntlSeq =	this.rcvRntlSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvRntlDtlSeq =	this.rcvRntlDtlSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilFmDt =	this.bilFmDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq =	this.agmtSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lseRcvChgTpCd =	this.lseRcvChgTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lftChgAmt =	this.lftChgAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhLocCd =	this.onhLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlDys =	this.ttlDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd =	this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.freeDys =	this.freeDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo =	this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupChgAmt =	this.pkupChgAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lonChgFlg =	this.lonChgFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lofChgFlg =	this.lofChgFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgRtAmt =	this.chgRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crAmt =	this.crAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gtiChgFlg =	this.gtiChgFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gtiChgAmt =	this.gtiChgAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gtoChgFlg =	this.gtoChgFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gtoChgAmt =	this.gtoChgAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}