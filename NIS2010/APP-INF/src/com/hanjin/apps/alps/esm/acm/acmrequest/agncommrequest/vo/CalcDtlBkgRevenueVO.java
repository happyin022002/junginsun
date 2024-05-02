/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : CalcDtlBkgRevenueVO.java
 *@FileTitle : CalcDtlBkgRevenueVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2017.08.25
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2017.08.25  
 * 1.0 Creation
=========================================================*/

package	 com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.vo;

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
public class CalcDtlBkgRevenueVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<CalcDtlBkgRevenueVO>  models =	new	ArrayList<CalcDtlBkgRevenueVO>();


	/*	Column Info	*/
	private  String	 toNodCd   =  null;
	/*	Column Info	*/
	private  String	 porCd   =  null;
	/*	Column Info	*/
	private  String	 currCd   =  null;
	/*	Column Info	*/
	private  String	 usdChgAmt   =  null;
	/*	Column Info	*/
	private  String	 pstPortCd   =  null;
	/*	Column Info	*/
	private  String	 chgCd   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 agnCd   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 polCd   =  null;
	/*	Column Info	*/
	private  String	 usdUcAmt   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd   =  null;
	/*	Column Info	*/
	private  String	 chgAmt   =  null;
	/*	Column Info	*/
	private  String	 chgDdctAmt   =  null;
	/*	Column Info	*/
	private  String	 payIfAmt   =  null;
	/*	Column Info	*/
	private  String	 rcvDeTermCd   =  null;
	/*	Column Info	*/
	private  String	 acTpCd   =  null;
	/*	Column Info	*/
	private  String	 prePortCd   =  null;
	/*	Column Info	*/
	private  String	 crntRevAmt   =  null;
	/*	Column Info	*/
	private  String	 commRt   =  null;
	/*	Column Info	*/
	private  String	 commFxAmt   =  null;
	/*	Column Info	*/
	private  String	 delCd   =  null;
	/*	Column Info	*/
	private  String	 stndCostNm   =  null;
	/*	Column Info	*/
	private  String	 ioBndCd   =  null;
	/*	Column Info	*/
	private  String	 chgDdctPayAmt   =  null;
	/*	Column Info	*/
	private  String	 podCd   =  null;
	/*	Column Info	*/
	private  String	 bkgNo   =  null;
	/*	Column Info	*/
	private  String	 acSeq   =  null;
	/*	Column Info	*/
	private  String	 ifAmt   =  null;
	/*	Column Info	*/
	private  String	 opCntrQty   =  null;
	/*	Column Info	*/
	private  String	 nodCd   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszQty   =  null;
	/*	Column Info	*/
	private  String	 brkgFlg   =  null;
	/*	Column Info	*/
	private  String	 crsFlg   =  null;
	/*	Column Info	*/
	private  String	 chgUtAmt   =  null;
	/*	Column Info	*/
	private  String	 chgCommRt   =  null;
	/*	Column Info	*/
	private  String	 chgCommCurrCd   =  null;
	/*	Column Info	*/
	private  String	 payCommAmt   =  null;
	/*	Column Info	*/
	private  String	 commAmt   =  null;
	/*	Column Info	*/
	private  String	 ratUtCd   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public CalcDtlBkgRevenueVO(){}

	public CalcDtlBkgRevenueVO(String toNodCd,String porCd,String currCd,String usdChgAmt,String pstPortCd,String chgCd,String pagerows,String agnCd,String ibflag,String polCd,String usdUcAmt,String cntrTpszCd,String chgAmt,String chgDdctAmt,String payIfAmt,String rcvDeTermCd,String acTpCd,String prePortCd,String crntRevAmt,String commRt,String commFxAmt,String delCd,String stndCostNm,String ioBndCd,String chgDdctPayAmt,String podCd,String bkgNo,String acSeq,String ifAmt,String opCntrQty,String nodCd,String cntrTpszQty,String brkgFlg,String crsFlg,String chgUtAmt,String chgCommRt,String chgCommCurrCd,String payCommAmt,String commAmt,String ratUtCd)	{
		this.toNodCd  = toNodCd ;
		this.porCd  = porCd ;
		this.currCd  = currCd ;
		this.usdChgAmt  = usdChgAmt ;
		this.pstPortCd  = pstPortCd ;
		this.chgCd  = chgCd ;
		this.pagerows  = pagerows ;
		this.agnCd  = agnCd ;
		this.ibflag  = ibflag ;
		this.polCd  = polCd ;
		this.usdUcAmt  = usdUcAmt ;
		this.cntrTpszCd  = cntrTpszCd ;
		this.chgAmt  = chgAmt ;
		this.chgDdctAmt  = chgDdctAmt ;
		this.payIfAmt  = payIfAmt ;
		this.rcvDeTermCd  = rcvDeTermCd ;
		this.acTpCd  = acTpCd ;
		this.prePortCd  = prePortCd ;
		this.crntRevAmt  = crntRevAmt ;
		this.commRt  = commRt ;
		this.commFxAmt  = commFxAmt ;
		this.delCd  = delCd ;
		this.stndCostNm  = stndCostNm ;
		this.ioBndCd  = ioBndCd ;
		this.chgDdctPayAmt  = chgDdctPayAmt ;
		this.podCd  = podCd ;
		this.bkgNo  = bkgNo ;
		this.acSeq  = acSeq ;
		this.ifAmt  = ifAmt ;
		this.opCntrQty  = opCntrQty ;
		this.nodCd  = nodCd ;
		this.cntrTpszQty  = cntrTpszQty ;
		this.brkgFlg  = brkgFlg ;
		this.crsFlg  = crsFlg ;
		this.chgUtAmt  = chgUtAmt ;
		this.chgCommRt  = chgCommRt ;
		this.chgCommCurrCd  = chgCommCurrCd ;
		this.payCommAmt  = payCommAmt ;
		this.commAmt  = commAmt ;
		this.ratUtCd  = ratUtCd ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_nod_cd", getToNodCd());		
		this.hashColumns.put("por_cd", getPorCd());		
		this.hashColumns.put("curr_cd", getCurrCd());		
		this.hashColumns.put("usd_chg_amt", getUsdChgAmt());		
		this.hashColumns.put("pst_port_cd", getPstPortCd());		
		this.hashColumns.put("chg_cd", getChgCd());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("agn_cd", getAgnCd());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("pol_cd", getPolCd());		
		this.hashColumns.put("usd_uc_amt", getUsdUcAmt());		
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());		
		this.hashColumns.put("chg_amt", getChgAmt());		
		this.hashColumns.put("chg_ddct_amt", getChgDdctAmt());		
		this.hashColumns.put("pay_if_amt", getPayIfAmt());		
		this.hashColumns.put("rcv_de_term_cd", getRcvDeTermCd());		
		this.hashColumns.put("ac_tp_cd", getAcTpCd());		
		this.hashColumns.put("pre_port_cd", getPrePortCd());		
		this.hashColumns.put("crnt_rev_amt", getCrntRevAmt());		
		this.hashColumns.put("comm_rt", getCommRt());		
		this.hashColumns.put("comm_fx_amt", getCommFxAmt());		
		this.hashColumns.put("del_cd", getDelCd());		
		this.hashColumns.put("stnd_cost_nm", getStndCostNm());		
		this.hashColumns.put("io_bnd_cd", getIoBndCd());		
		this.hashColumns.put("chg_ddct_pay_amt", getChgDdctPayAmt());		
		this.hashColumns.put("pod_cd", getPodCd());		
		this.hashColumns.put("bkg_no", getBkgNo());		
		this.hashColumns.put("ac_seq", getAcSeq());		
		this.hashColumns.put("if_amt", getIfAmt());		
		this.hashColumns.put("op_cntr_qty", getOpCntrQty());		
		this.hashColumns.put("nod_cd", getNodCd());		
		this.hashColumns.put("cntr_tpsz_qty", getCntrTpszQty());		
		this.hashColumns.put("brkg_flg", getBrkgFlg());		
		this.hashColumns.put("crs_flg", getCrsFlg());		
		this.hashColumns.put("chg_ut_amt", getChgUtAmt());		
		this.hashColumns.put("chg_comm_rt", getChgCommRt());		
		this.hashColumns.put("chg_comm_curr_cd", getChgCommCurrCd());		
		this.hashColumns.put("pay_comm_amt", getPayCommAmt());		
		this.hashColumns.put("comm_amt", getCommAmt());		
		this.hashColumns.put("rat_ut_cd", getRatUtCd());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("to_nod_cd", "toNodCd");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("usd_chg_amt", "usdChgAmt");
		this.hashFields.put("pst_port_cd", "pstPortCd");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("agn_cd", "agnCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("usd_uc_amt", "usdUcAmt");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("chg_amt", "chgAmt");
		this.hashFields.put("chg_ddct_amt", "chgDdctAmt");
		this.hashFields.put("pay_if_amt", "payIfAmt");
		this.hashFields.put("rcv_de_term_cd", "rcvDeTermCd");
		this.hashFields.put("ac_tp_cd", "acTpCd");
		this.hashFields.put("pre_port_cd", "prePortCd");
		this.hashFields.put("crnt_rev_amt", "crntRevAmt");
		this.hashFields.put("comm_rt", "commRt");
		this.hashFields.put("comm_fx_amt", "commFxAmt");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("stnd_cost_nm", "stndCostNm");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("chg_ddct_pay_amt", "chgDdctPayAmt");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ac_seq", "acSeq");
		this.hashFields.put("if_amt", "ifAmt");
		this.hashFields.put("op_cntr_qty", "opCntrQty");
		this.hashFields.put("nod_cd", "nodCd");
		this.hashFields.put("cntr_tpsz_qty", "cntrTpszQty");
		this.hashFields.put("brkg_flg", "brkgFlg");
		this.hashFields.put("crs_flg", "crsFlg");
		this.hashFields.put("chg_ut_amt", "chgUtAmt");
		this.hashFields.put("chg_comm_rt", "chgCommRt");
		this.hashFields.put("chg_comm_curr_cd", "chgCommCurrCd");
		this.hashFields.put("pay_comm_amt", "payCommAmt");
		this.hashFields.put("comm_amt", "commAmt");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  toNodCd
	*/
	public void	setToNodCd( String	toNodCd ) {
		this.toNodCd =	toNodCd;
	}
 
	/**
	 * Column Info
	 * @return	toNodCd
	 */
	 public	 String	getToNodCd() {
		 return	this.toNodCd;
	 } 
 	/**
	* Column Info
	* @param  porCd
	*/
	public void	setPorCd( String	porCd ) {
		this.porCd =	porCd;
	}
 
	/**
	 * Column Info
	 * @return	porCd
	 */
	 public	 String	getPorCd() {
		 return	this.porCd;
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
	* @param  usdChgAmt
	*/
	public void	setUsdChgAmt( String	usdChgAmt ) {
		this.usdChgAmt =	usdChgAmt;
	}
 
	/**
	 * Column Info
	 * @return	usdChgAmt
	 */
	 public	 String	getUsdChgAmt() {
		 return	this.usdChgAmt;
	 } 
 	/**
	* Column Info
	* @param  pstPortCd
	*/
	public void	setPstPortCd( String	pstPortCd ) {
		this.pstPortCd =	pstPortCd;
	}
 
	/**
	 * Column Info
	 * @return	pstPortCd
	 */
	 public	 String	getPstPortCd() {
		 return	this.pstPortCd;
	 } 
 	/**
	* Column Info
	* @param  chgCd
	*/
	public void	setChgCd( String	chgCd ) {
		this.chgCd =	chgCd;
	}
 
	/**
	 * Column Info
	 * @return	chgCd
	 */
	 public	 String	getChgCd() {
		 return	this.chgCd;
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
	* @param  agnCd
	*/
	public void	setAgnCd( String	agnCd ) {
		this.agnCd =	agnCd;
	}
 
	/**
	 * Column Info
	 * @return	agnCd
	 */
	 public	 String	getAgnCd() {
		 return	this.agnCd;
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
	* @param  usdUcAmt
	*/
	public void	setUsdUcAmt( String	usdUcAmt ) {
		this.usdUcAmt =	usdUcAmt;
	}
 
	/**
	 * Column Info
	 * @return	usdUcAmt
	 */
	 public	 String	getUsdUcAmt() {
		 return	this.usdUcAmt;
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
	* @param  chgDdctAmt
	*/
	public void	setChgDdctAmt( String	chgDdctAmt ) {
		this.chgDdctAmt =	chgDdctAmt;
	}
 
	/**
	 * Column Info
	 * @return	chgDdctAmt
	 */
	 public	 String	getChgDdctAmt() {
		 return	this.chgDdctAmt;
	 } 
 	/**
	* Column Info
	* @param  payIfAmt
	*/
	public void	setPayIfAmt( String	payIfAmt ) {
		this.payIfAmt =	payIfAmt;
	}
 
	/**
	 * Column Info
	 * @return	payIfAmt
	 */
	 public	 String	getPayIfAmt() {
		 return	this.payIfAmt;
	 } 
 	/**
	* Column Info
	* @param  rcvDeTermCd
	*/
	public void	setRcvDeTermCd( String	rcvDeTermCd ) {
		this.rcvDeTermCd =	rcvDeTermCd;
	}
 
	/**
	 * Column Info
	 * @return	rcvDeTermCd
	 */
	 public	 String	getRcvDeTermCd() {
		 return	this.rcvDeTermCd;
	 } 
 	/**
	* Column Info
	* @param  acTpCd
	*/
	public void	setAcTpCd( String	acTpCd ) {
		this.acTpCd =	acTpCd;
	}
 
	/**
	 * Column Info
	 * @return	acTpCd
	 */
	 public	 String	getAcTpCd() {
		 return	this.acTpCd;
	 } 
 	/**
	* Column Info
	* @param  prePortCd
	*/
	public void	setPrePortCd( String	prePortCd ) {
		this.prePortCd =	prePortCd;
	}
 
	/**
	 * Column Info
	 * @return	prePortCd
	 */
	 public	 String	getPrePortCd() {
		 return	this.prePortCd;
	 } 
 	/**
	* Column Info
	* @param  crntRevAmt
	*/
	public void	setCrntRevAmt( String	crntRevAmt ) {
		this.crntRevAmt =	crntRevAmt;
	}
 
	/**
	 * Column Info
	 * @return	crntRevAmt
	 */
	 public	 String	getCrntRevAmt() {
		 return	this.crntRevAmt;
	 } 
 	/**
	* Column Info
	* @param  commRt
	*/
	public void	setCommRt( String	commRt ) {
		this.commRt =	commRt;
	}
 
	/**
	 * Column Info
	 * @return	commRt
	 */
	 public	 String	getCommRt() {
		 return	this.commRt;
	 } 
 	/**
	* Column Info
	* @param  commFxAmt
	*/
	public void	setCommFxAmt( String	commFxAmt ) {
		this.commFxAmt =	commFxAmt;
	}
 
	/**
	 * Column Info
	 * @return	commFxAmt
	 */
	 public	 String	getCommFxAmt() {
		 return	this.commFxAmt;
	 } 
 	/**
	* Column Info
	* @param  delCd
	*/
	public void	setDelCd( String	delCd ) {
		this.delCd =	delCd;
	}
 
	/**
	 * Column Info
	 * @return	delCd
	 */
	 public	 String	getDelCd() {
		 return	this.delCd;
	 } 
 	/**
	* Column Info
	* @param  stndCostNm
	*/
	public void	setStndCostNm( String	stndCostNm ) {
		this.stndCostNm =	stndCostNm;
	}
 
	/**
	 * Column Info
	 * @return	stndCostNm
	 */
	 public	 String	getStndCostNm() {
		 return	this.stndCostNm;
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
	* @param  chgDdctPayAmt
	*/
	public void	setChgDdctPayAmt( String	chgDdctPayAmt ) {
		this.chgDdctPayAmt =	chgDdctPayAmt;
	}
 
	/**
	 * Column Info
	 * @return	chgDdctPayAmt
	 */
	 public	 String	getChgDdctPayAmt() {
		 return	this.chgDdctPayAmt;
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
	* @param  acSeq
	*/
	public void	setAcSeq( String	acSeq ) {
		this.acSeq =	acSeq;
	}
 
	/**
	 * Column Info
	 * @return	acSeq
	 */
	 public	 String	getAcSeq() {
		 return	this.acSeq;
	 } 
 	/**
	* Column Info
	* @param  ifAmt
	*/
	public void	setIfAmt( String	ifAmt ) {
		this.ifAmt =	ifAmt;
	}
 
	/**
	 * Column Info
	 * @return	ifAmt
	 */
	 public	 String	getIfAmt() {
		 return	this.ifAmt;
	 } 
 	/**
	* Column Info
	* @param  opCntrQty
	*/
	public void	setOpCntrQty( String	opCntrQty ) {
		this.opCntrQty =	opCntrQty;
	}
 
	/**
	 * Column Info
	 * @return	opCntrQty
	 */
	 public	 String	getOpCntrQty() {
		 return	this.opCntrQty;
	 } 
 	/**
	* Column Info
	* @param  nodCd
	*/
	public void	setNodCd( String	nodCd ) {
		this.nodCd =	nodCd;
	}
 
	/**
	 * Column Info
	 * @return	nodCd
	 */
	 public	 String	getNodCd() {
		 return	this.nodCd;
	 } 
 	/**
	* Column Info
	* @param  cntrTpszQty
	*/
	public void	setCntrTpszQty( String	cntrTpszQty ) {
		this.cntrTpszQty =	cntrTpszQty;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszQty
	 */
	 public	 String	getCntrTpszQty() {
		 return	this.cntrTpszQty;
	 } 
 	/**
	* Column Info
	* @param  brkgFlg
	*/
	public void	setBrkgFlg( String	brkgFlg ) {
		this.brkgFlg =	brkgFlg;
	}
 
	/**
	 * Column Info
	 * @return	brkgFlg
	 */
	 public	 String	getBrkgFlg() {
		 return	this.brkgFlg;
	 } 
 	/**
	* Column Info
	* @param  crsFlg
	*/
	public void	setCrsFlg( String	crsFlg ) {
		this.crsFlg =	crsFlg;
	}
 
	/**
	 * Column Info
	 * @return	crsFlg
	 */
	 public	 String	getCrsFlg() {
		 return	this.crsFlg;
	 } 
 	/**
	* Column Info
	* @param  chgUtAmt
	*/
	public void	setChgUtAmt( String	chgUtAmt ) {
		this.chgUtAmt =	chgUtAmt;
	}
 
	/**
	 * Column Info
	 * @return	chgUtAmt
	 */
	 public	 String	getChgUtAmt() {
		 return	this.chgUtAmt;
	 } 
 	/**
	* Column Info
	* @param  chgCommRt
	*/
	public void	setChgCommRt( String	chgCommRt ) {
		this.chgCommRt =	chgCommRt;
	}
 
	/**
	 * Column Info
	 * @return	chgCommRt
	 */
	 public	 String	getChgCommRt() {
		 return	this.chgCommRt;
	 } 
 	/**
	* Column Info
	* @param  chgCommCurrCd
	*/
	public void	setChgCommCurrCd( String	chgCommCurrCd ) {
		this.chgCommCurrCd =	chgCommCurrCd;
	}
 
	/**
	 * Column Info
	 * @return	chgCommCurrCd
	 */
	 public	 String	getChgCommCurrCd() {
		 return	this.chgCommCurrCd;
	 } 
 	/**
	* Column Info
	* @param  payCommAmt
	*/
	public void	setPayCommAmt( String	payCommAmt ) {
		this.payCommAmt =	payCommAmt;
	}
 
	/**
	 * Column Info
	 * @return	payCommAmt
	 */
	 public	 String	getPayCommAmt() {
		 return	this.payCommAmt;
	 } 
 	/**
	* Column Info
	* @param  commAmt
	*/
	public void	setCommAmt( String	commAmt ) {
		this.commAmt =	commAmt;
	}
 
	/**
	 * Column Info
	 * @return	commAmt
	 */
	 public	 String	getCommAmt() {
		 return	this.commAmt;
	 } 
 	/**
	* Column Info
	* @param  ratUtCd
	*/
	public void	setRatUtCd( String	ratUtCd ) {
		this.ratUtCd =	ratUtCd;
	}
 
	/**
	 * Column Info
	 * @return	ratUtCd
	 */
	 public	 String	getRatUtCd() {
		 return	this.ratUtCd;
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
		setToNodCd(JSPUtil.getParameter(request,	prefix + "to_nod_cd", ""));
		setPorCd(JSPUtil.getParameter(request,	prefix + "por_cd", ""));
		setCurrCd(JSPUtil.getParameter(request,	prefix + "curr_cd", ""));
		setUsdChgAmt(JSPUtil.getParameter(request,	prefix + "usd_chg_amt", ""));
		setPstPortCd(JSPUtil.getParameter(request,	prefix + "pst_port_cd", ""));
		setChgCd(JSPUtil.getParameter(request,	prefix + "chg_cd", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setAgnCd(JSPUtil.getParameter(request,	prefix + "agn_cd", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request,	prefix + "pol_cd", ""));
		setUsdUcAmt(JSPUtil.getParameter(request,	prefix + "usd_uc_amt", ""));
		setCntrTpszCd(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd", ""));
		setChgAmt(JSPUtil.getParameter(request,	prefix + "chg_amt", ""));
		setChgDdctAmt(JSPUtil.getParameter(request,	prefix + "chg_ddct_amt", ""));
		setPayIfAmt(JSPUtil.getParameter(request,	prefix + "pay_if_amt", ""));
		setRcvDeTermCd(JSPUtil.getParameter(request,	prefix + "rcv_de_term_cd", ""));
		setAcTpCd(JSPUtil.getParameter(request,	prefix + "ac_tp_cd", ""));
		setPrePortCd(JSPUtil.getParameter(request,	prefix + "pre_port_cd", ""));
		setCrntRevAmt(JSPUtil.getParameter(request,	prefix + "crnt_rev_amt", ""));
		setCommRt(JSPUtil.getParameter(request,	prefix + "comm_rt", ""));
		setCommFxAmt(JSPUtil.getParameter(request,	prefix + "comm_fx_amt", ""));
		setDelCd(JSPUtil.getParameter(request,	prefix + "del_cd", ""));
		setStndCostNm(JSPUtil.getParameter(request,	prefix + "stnd_cost_nm", ""));
		setIoBndCd(JSPUtil.getParameter(request,	prefix + "io_bnd_cd", ""));
		setChgDdctPayAmt(JSPUtil.getParameter(request,	prefix + "chg_ddct_pay_amt", ""));
		setPodCd(JSPUtil.getParameter(request,	prefix + "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request,	prefix + "bkg_no", ""));
		setAcSeq(JSPUtil.getParameter(request,	prefix + "ac_seq", ""));
		setIfAmt(JSPUtil.getParameter(request,	prefix + "if_amt", ""));
		setOpCntrQty(JSPUtil.getParameter(request,	prefix + "op_cntr_qty", ""));
		setNodCd(JSPUtil.getParameter(request,	prefix + "nod_cd", ""));
		setCntrTpszQty(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_qty", ""));
		setBrkgFlg(JSPUtil.getParameter(request,	prefix + "brkg_flg", ""));
		setCrsFlg(JSPUtil.getParameter(request,	prefix + "crs_flg", ""));
		setChgUtAmt(JSPUtil.getParameter(request,	prefix + "chg_ut_amt", ""));
		setChgCommRt(JSPUtil.getParameter(request,	prefix + "chg_comm_rt", ""));
		setChgCommCurrCd(JSPUtil.getParameter(request,	prefix + "chg_comm_curr_cd", ""));
		setPayCommAmt(JSPUtil.getParameter(request,	prefix + "pay_comm_amt", ""));
		setCommAmt(JSPUtil.getParameter(request,	prefix + "comm_amt", ""));
		setRatUtCd(JSPUtil.getParameter(request,	prefix + "rat_ut_cd", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CalcDtlBkgRevenueVO[]
	 */
	public CalcDtlBkgRevenueVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return CalcDtlBkgRevenueVO[]
	 */
	public CalcDtlBkgRevenueVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		CalcDtlBkgRevenueVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] toNodCd =	(JSPUtil.getParameter(request, prefix +	"to_nod_cd".trim(),	length));
				String[] porCd =	(JSPUtil.getParameter(request, prefix +	"por_cd".trim(),	length));
				String[] currCd =	(JSPUtil.getParameter(request, prefix +	"curr_cd".trim(),	length));
				String[] usdChgAmt =	(JSPUtil.getParameter(request, prefix +	"usd_chg_amt".trim(),	length));
				String[] pstPortCd =	(JSPUtil.getParameter(request, prefix +	"pst_port_cd".trim(),	length));
				String[] chgCd =	(JSPUtil.getParameter(request, prefix +	"chg_cd".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] agnCd =	(JSPUtil.getParameter(request, prefix +	"agn_cd".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] polCd =	(JSPUtil.getParameter(request, prefix +	"pol_cd".trim(),	length));
				String[] usdUcAmt =	(JSPUtil.getParameter(request, prefix +	"usd_uc_amt".trim(),	length));
				String[] cntrTpszCd =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd".trim(),	length));
				String[] chgAmt =	(JSPUtil.getParameter(request, prefix +	"chg_amt".trim(),	length));
				String[] chgDdctAmt =	(JSPUtil.getParameter(request, prefix +	"chg_ddct_amt".trim(),	length));
				String[] payIfAmt =	(JSPUtil.getParameter(request, prefix +	"pay_if_amt".trim(),	length));
				String[] rcvDeTermCd =	(JSPUtil.getParameter(request, prefix +	"rcv_de_term_cd".trim(),	length));
				String[] acTpCd =	(JSPUtil.getParameter(request, prefix +	"ac_tp_cd".trim(),	length));
				String[] prePortCd =	(JSPUtil.getParameter(request, prefix +	"pre_port_cd".trim(),	length));
				String[] crntRevAmt =	(JSPUtil.getParameter(request, prefix +	"crnt_rev_amt".trim(),	length));
				String[] commRt =	(JSPUtil.getParameter(request, prefix +	"comm_rt".trim(),	length));
				String[] commFxAmt =	(JSPUtil.getParameter(request, prefix +	"comm_fx_amt".trim(),	length));
				String[] delCd =	(JSPUtil.getParameter(request, prefix +	"del_cd".trim(),	length));
				String[] stndCostNm =	(JSPUtil.getParameter(request, prefix +	"stnd_cost_nm".trim(),	length));
				String[] ioBndCd =	(JSPUtil.getParameter(request, prefix +	"io_bnd_cd".trim(),	length));
				String[] chgDdctPayAmt =	(JSPUtil.getParameter(request, prefix +	"chg_ddct_pay_amt".trim(),	length));
				String[] podCd =	(JSPUtil.getParameter(request, prefix +	"pod_cd".trim(),	length));
				String[] bkgNo =	(JSPUtil.getParameter(request, prefix +	"bkg_no".trim(),	length));
				String[] acSeq =	(JSPUtil.getParameter(request, prefix +	"ac_seq".trim(),	length));
				String[] ifAmt =	(JSPUtil.getParameter(request, prefix +	"if_amt".trim(),	length));
				String[] opCntrQty =	(JSPUtil.getParameter(request, prefix +	"op_cntr_qty".trim(),	length));
				String[] nodCd =	(JSPUtil.getParameter(request, prefix +	"nod_cd".trim(),	length));
				String[] cntrTpszQty =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_qty".trim(),	length));
				String[] brkgFlg =	(JSPUtil.getParameter(request, prefix +	"brkg_flg".trim(),	length));
				String[] crsFlg =	(JSPUtil.getParameter(request, prefix +	"crs_flg".trim(),	length));
				String[] chgUtAmt =	(JSPUtil.getParameter(request, prefix +	"chg_ut_amt".trim(),	length));
				String[] chgCommRt =	(JSPUtil.getParameter(request, prefix +	"chg_comm_rt".trim(),	length));
				String[] chgCommCurrCd =	(JSPUtil.getParameter(request, prefix +	"chg_comm_curr_cd".trim(),	length));
				String[] payCommAmt =	(JSPUtil.getParameter(request, prefix +	"pay_comm_amt".trim(),	length));
				String[] commAmt =	(JSPUtil.getParameter(request, prefix +	"comm_amt".trim(),	length));
				String[] ratUtCd =	(JSPUtil.getParameter(request, prefix +	"rat_ut_cd".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	CalcDtlBkgRevenueVO();
						if ( toNodCd[i] !=	null)
						model.setToNodCd( toNodCd[i]);
						if ( porCd[i] !=	null)
						model.setPorCd( porCd[i]);
						if ( currCd[i] !=	null)
						model.setCurrCd( currCd[i]);
						if ( usdChgAmt[i] !=	null)
						model.setUsdChgAmt( usdChgAmt[i]);
						if ( pstPortCd[i] !=	null)
						model.setPstPortCd( pstPortCd[i]);
						if ( chgCd[i] !=	null)
						model.setChgCd( chgCd[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( agnCd[i] !=	null)
						model.setAgnCd( agnCd[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( polCd[i] !=	null)
						model.setPolCd( polCd[i]);
						if ( usdUcAmt[i] !=	null)
						model.setUsdUcAmt( usdUcAmt[i]);
						if ( cntrTpszCd[i] !=	null)
						model.setCntrTpszCd( cntrTpszCd[i]);
						if ( chgAmt[i] !=	null)
						model.setChgAmt( chgAmt[i]);
						if ( chgDdctAmt[i] !=	null)
						model.setChgDdctAmt( chgDdctAmt[i]);
						if ( payIfAmt[i] !=	null)
						model.setPayIfAmt( payIfAmt[i]);
						if ( rcvDeTermCd[i] !=	null)
						model.setRcvDeTermCd( rcvDeTermCd[i]);
						if ( acTpCd[i] !=	null)
						model.setAcTpCd( acTpCd[i]);
						if ( prePortCd[i] !=	null)
						model.setPrePortCd( prePortCd[i]);
						if ( crntRevAmt[i] !=	null)
						model.setCrntRevAmt( crntRevAmt[i]);
						if ( commRt[i] !=	null)
						model.setCommRt( commRt[i]);
						if ( commFxAmt[i] !=	null)
						model.setCommFxAmt( commFxAmt[i]);
						if ( delCd[i] !=	null)
						model.setDelCd( delCd[i]);
						if ( stndCostNm[i] !=	null)
						model.setStndCostNm( stndCostNm[i]);
						if ( ioBndCd[i] !=	null)
						model.setIoBndCd( ioBndCd[i]);
						if ( chgDdctPayAmt[i] !=	null)
						model.setChgDdctPayAmt( chgDdctPayAmt[i]);
						if ( podCd[i] !=	null)
						model.setPodCd( podCd[i]);
						if ( bkgNo[i] !=	null)
						model.setBkgNo( bkgNo[i]);
						if ( acSeq[i] !=	null)
						model.setAcSeq( acSeq[i]);
						if ( ifAmt[i] !=	null)
						model.setIfAmt( ifAmt[i]);
						if ( opCntrQty[i] !=	null)
						model.setOpCntrQty( opCntrQty[i]);
						if ( nodCd[i] !=	null)
						model.setNodCd( nodCd[i]);
						if ( cntrTpszQty[i] !=	null)
						model.setCntrTpszQty( cntrTpszQty[i]);
						if ( brkgFlg[i] !=	null)
						model.setBrkgFlg( brkgFlg[i]);
						if ( crsFlg[i] !=	null)
						model.setCrsFlg( crsFlg[i]);
						if ( chgUtAmt[i] !=	null)
						model.setChgUtAmt( chgUtAmt[i]);
						if ( chgCommRt[i] !=	null)
						model.setChgCommRt( chgCommRt[i]);
						if ( chgCommCurrCd[i] !=	null)
						model.setChgCommCurrCd( chgCommCurrCd[i]);
						if ( payCommAmt[i] !=	null)
						model.setPayCommAmt( payCommAmt[i]);
						if ( commAmt[i] !=	null)
						model.setCommAmt( commAmt[i]);
						if ( ratUtCd[i] !=	null)
						model.setRatUtCd( ratUtCd[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getCalcDtlBkgRevenueVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return CalcDtlBkgRevenueVO[]
	 */
	public CalcDtlBkgRevenueVO[]	 getCalcDtlBkgRevenueVOs(){
		CalcDtlBkgRevenueVO[] vos = (CalcDtlBkgRevenueVO[])models.toArray(new	CalcDtlBkgRevenueVO[models.size()]);
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
		this.toNodCd =	this.toNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd =	this.porCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd =	this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdChgAmt =	this.usdChgAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pstPortCd =	this.pstPortCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd =	this.chgCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnCd =	this.agnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd =	this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdUcAmt =	this.usdUcAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd =	this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmt =	this.chgAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgDdctAmt =	this.chgDdctAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payIfAmt =	this.payIfAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDeTermCd =	this.rcvDeTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acTpCd =	this.acTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prePortCd =	this.prePortCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntRevAmt =	this.crntRevAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commRt =	this.commRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commFxAmt =	this.commFxAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd =	this.delCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndCostNm =	this.stndCostNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd =	this.ioBndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgDdctPayAmt =	this.chgDdctPayAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd =	this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo =	this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acSeq =	this.acSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifAmt =	this.ifAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opCntrQty =	this.opCntrQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodCd =	this.nodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszQty =	this.cntrTpszQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brkgFlg =	this.brkgFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crsFlg =	this.crsFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgUtAmt =	this.chgUtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCommRt =	this.chgCommRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCommCurrCd =	this.chgCommCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payCommAmt =	this.payCommAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commAmt =	this.commAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd =	this.ratUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}