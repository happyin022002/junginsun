/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : PayableRentalCostCreatVO.java
 *@FileTitle : PayableRentalCostCreatVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.03.10
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2016.03.10  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.vo;

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
public class PayableRentalCostCreatVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<PayableRentalCostCreatVO>  models =	new	ArrayList<PayableRentalCostCreatVO>();


	/*	Column Info	*/
	private  String	 agmtNo   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 payRntlCostAmt   =  null;
	/*	Column Info	*/
	private  String	 invNo   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 effDt   =  null;
	/*	Column Info	*/
	private  String	 lseCtrtNo   =  null;
	/*	Column Info	*/
	private  String	 agmtLstVerSeq   =  null;
	/*	Column Info	*/
	private  String	 refNo   =  null;
	/*	Column Info	*/
	private  String	 chgStsCd   =  null;
	/*	Column Info	*/
	private  String	 expDt   =  null;
	/*	Column Info	*/
	private  String	 lstmCd   =  null;
	/*	Column Info	*/
	private  String	 comTtlChgAmt   =  null;
	/*	Column Info	*/
	private  String	 crTtlAmt   =  null;
	/*	Column Info	*/
	private  String	 invTtlChgAmt   =  null;
	/*	Column Info	*/
	private  String	 currCd   =  null;
	/*	Column Info	*/
	private  String	 agmtCtyCd   =  null;
	/*	Column Info	*/
	private  String	 agmtSeq   =  null;
	/*	Column Info	*/
	private  String	 chgSeq   =  null;
	/*	Column Info	*/
	private  String	 invFilFlg   =  null;
	/*	Column Info	*/
	private  String	 creDt   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;
	/*	Column Info	*/
	private  String	 ifRgstNo   =  null;
	/*	Column Info	*/
	private  String	 invRcvDt   =  null;
	/*	Column Info	*/
	private  String	 invIssDt   =  null;
	/*	Column Info	*/
	private  String	 invEffDt   =  null;
	/*	Column Info	*/
	private  String	 offcCd   =  null;
	/*	Column Info	*/
	private  String	 invRmk   =  null;
	/*	Column Info	*/
	private  String	 vndrTermNm   =  null;
	/*	Column Info	*/
	private  String	 invOfcCd   =  null;
	/*	Column Info	*/
	private  String	 costOfcCd   =  null;
	/*	Column Info	*/
	private  String	 payVndrSeq   =  null;
	/*	Column Info	*/
	private  String	 invVatAmt   =  null;
	/*	Column Info	*/
	private  String	 whldTaxAmt   =  null;
	/*	Column Info	*/
	private  String	 pdmAmt   =  null;
	/*	Column Info	*/
	private  String	 lsePayTpCd   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public PayableRentalCostCreatVO(){}

	public PayableRentalCostCreatVO(String agmtNo,String pagerows,String payRntlCostAmt,String invNo,String ibflag,String effDt,String lseCtrtNo,String agmtLstVerSeq,String refNo,String chgStsCd,String expDt,String lstmCd,String comTtlChgAmt,String crTtlAmt,String invTtlChgAmt,String currCd,String agmtCtyCd,String agmtSeq,String chgSeq,String invFilFlg,String creDt,String creUsrId,String ifRgstNo,String invRcvDt,String invIssDt,String invEffDt,String offcCd,String invRmk,String vndrTermNm,String invOfcCd,String costOfcCd,String payVndrSeq,String invVatAmt,String whldTaxAmt,String pdmAmt,String lsePayTpCd)	{
		this.agmtNo  = agmtNo ;
		this.pagerows  = pagerows ;
		this.payRntlCostAmt  = payRntlCostAmt ;
		this.invNo  = invNo ;
		this.ibflag  = ibflag ;
		this.effDt  = effDt ;
		this.lseCtrtNo  = lseCtrtNo ;
		this.agmtLstVerSeq  = agmtLstVerSeq ;
		this.refNo  = refNo ;
		this.chgStsCd  = chgStsCd ;
		this.expDt  = expDt ;
		this.lstmCd  = lstmCd ;
		this.comTtlChgAmt  = comTtlChgAmt ;
		this.crTtlAmt  = crTtlAmt ;
		this.invTtlChgAmt  = invTtlChgAmt ;
		this.currCd  = currCd ;
		this.agmtCtyCd  = agmtCtyCd ;
		this.agmtSeq  = agmtSeq ;
		this.chgSeq  = chgSeq ;
		this.invFilFlg  = invFilFlg ;
		this.creDt  = creDt ;
		this.creUsrId  = creUsrId ;
		this.ifRgstNo  = ifRgstNo ;
		this.invRcvDt  = invRcvDt ;
		this.invIssDt  = invIssDt ;
		this.invEffDt  = invEffDt ;
		this.offcCd  = offcCd ;
		this.invRmk  = invRmk ;
		this.vndrTermNm  = vndrTermNm ;
		this.invOfcCd  = invOfcCd ;
		this.costOfcCd  = costOfcCd ;
		this.payVndrSeq  = payVndrSeq ;
		this.invVatAmt  = invVatAmt ;
		this.whldTaxAmt  = whldTaxAmt ;
		this.pdmAmt  = pdmAmt ;
		this.lsePayTpCd  = lsePayTpCd ;
	}


	/**
	 * �뚯씠釉�而щ읆����옣��媛믪쓣 Hashtable<"column_name", "value">	濡�諛섑솚
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("agmt_no", getAgmtNo());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("pay_rntl_cost_amt", getPayRntlCostAmt());		
		this.hashColumns.put("inv_no", getInvNo());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("eff_dt", getEffDt());		
		this.hashColumns.put("lse_ctrt_no", getLseCtrtNo());		
		this.hashColumns.put("agmt_lst_ver_seq", getAgmtLstVerSeq());		
		this.hashColumns.put("ref_no", getRefNo());		
		this.hashColumns.put("chg_sts_cd", getChgStsCd());		
		this.hashColumns.put("exp_dt", getExpDt());		
		this.hashColumns.put("lstm_cd", getLstmCd());		
		this.hashColumns.put("com_ttl_chg_amt", getComTtlChgAmt());		
		this.hashColumns.put("cr_ttl_amt", getCrTtlAmt());		
		this.hashColumns.put("inv_ttl_chg_amt", getInvTtlChgAmt());		
		this.hashColumns.put("curr_cd", getCurrCd());		
		this.hashColumns.put("agmt_cty_cd", getAgmtCtyCd());		
		this.hashColumns.put("agmt_seq", getAgmtSeq());		
		this.hashColumns.put("chg_seq", getChgSeq());		
		this.hashColumns.put("inv_fil_flg", getInvFilFlg());		
		this.hashColumns.put("cre_dt", getCreDt());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("if_rgst_no", getIfRgstNo());		
		this.hashColumns.put("inv_rcv_dt", getInvRcvDt());		
		this.hashColumns.put("inv_iss_dt", getInvIssDt());		
		this.hashColumns.put("inv_eff_dt", getInvEffDt());		
		this.hashColumns.put("offc_cd", getOffcCd());		
		this.hashColumns.put("inv_rmk", getInvRmk());		
		this.hashColumns.put("vndr_term_nm", getVndrTermNm());		
		this.hashColumns.put("inv_ofc_cd", getInvOfcCd());		
		this.hashColumns.put("cost_ofc_cd", getCostOfcCd());		
		this.hashColumns.put("pay_vndr_seq", getPayVndrSeq());		
		this.hashColumns.put("inv_vat_amt", getInvVatAmt());		
		this.hashColumns.put("whld_tax_amt", getWhldTaxAmt());		
		this.hashColumns.put("pdm_amt", getPdmAmt());		
		this.hashColumns.put("lse_pay_tp_cd", getLsePayTpCd());		
		return this.hashColumns;
}

	/**
	 * 而щ읆紐낆뿉	��쓳�섎뒗 硫ㅻ쾭蹂�닔紐낆쓣	��옣�섏뿬 Hashtable<"column_name", "variable"> 濡�諛섑솚
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pay_rntl_cost_amt", "payRntlCostAmt");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("lse_ctrt_no", "lseCtrtNo");
		this.hashFields.put("agmt_lst_ver_seq", "agmtLstVerSeq");
		this.hashFields.put("ref_no", "refNo");
		this.hashFields.put("chg_sts_cd", "chgStsCd");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("com_ttl_chg_amt", "comTtlChgAmt");
		this.hashFields.put("cr_ttl_amt", "crTtlAmt");
		this.hashFields.put("inv_ttl_chg_amt", "invTtlChgAmt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("agmt_cty_cd", "agmtCtyCd");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("chg_seq", "chgSeq");
		this.hashFields.put("inv_fil_flg", "invFilFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("if_rgst_no", "ifRgstNo");
		this.hashFields.put("inv_rcv_dt", "invRcvDt");
		this.hashFields.put("inv_iss_dt", "invIssDt");
		this.hashFields.put("inv_eff_dt", "invEffDt");
		this.hashFields.put("offc_cd", "offcCd");
		this.hashFields.put("inv_rmk", "invRmk");
		this.hashFields.put("vndr_term_nm", "vndrTermNm");
		this.hashFields.put("inv_ofc_cd", "invOfcCd");
		this.hashFields.put("cost_ofc_cd", "costOfcCd");
		this.hashFields.put("pay_vndr_seq", "payVndrSeq");
		this.hashFields.put("inv_vat_amt", "invVatAmt");
		this.hashFields.put("whld_tax_amt", "whldTaxAmt");
		this.hashFields.put("pdm_amt", "pdmAmt");
		this.hashFields.put("lse_pay_tp_cd", "lsePayTpCd");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  agmtNo
	*/
	public void	setAgmtNo( String	agmtNo ) {
		this.agmtNo =	agmtNo;
	}
 
	/**
	 * Column Info
	 * @return	agmtNo
	 */
	 public	 String	getAgmtNo() {
		 return	this.agmtNo;
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
	* @param  payRntlCostAmt
	*/
	public void	setPayRntlCostAmt( String	payRntlCostAmt ) {
		this.payRntlCostAmt =	payRntlCostAmt;
	}
 
	/**
	 * Column Info
	 * @return	payRntlCostAmt
	 */
	 public	 String	getPayRntlCostAmt() {
		 return	this.payRntlCostAmt;
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
	* @param  effDt
	*/
	public void	setEffDt( String	effDt ) {
		this.effDt =	effDt;
	}
 
	/**
	 * Column Info
	 * @return	effDt
	 */
	 public	 String	getEffDt() {
		 return	this.effDt;
	 } 
 	/**
	* Column Info
	* @param  lseCtrtNo
	*/
	public void	setLseCtrtNo( String	lseCtrtNo ) {
		this.lseCtrtNo =	lseCtrtNo;
	}
 
	/**
	 * Column Info
	 * @return	lseCtrtNo
	 */
	 public	 String	getLseCtrtNo() {
		 return	this.lseCtrtNo;
	 } 
 	/**
	* Column Info
	* @param  agmtLstVerSeq
	*/
	public void	setAgmtLstVerSeq( String	agmtLstVerSeq ) {
		this.agmtLstVerSeq =	agmtLstVerSeq;
	}
 
	/**
	 * Column Info
	 * @return	agmtLstVerSeq
	 */
	 public	 String	getAgmtLstVerSeq() {
		 return	this.agmtLstVerSeq;
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
	* @param  chgStsCd
	*/
	public void	setChgStsCd( String	chgStsCd ) {
		this.chgStsCd =	chgStsCd;
	}
 
	/**
	 * Column Info
	 * @return	chgStsCd
	 */
	 public	 String	getChgStsCd() {
		 return	this.chgStsCd;
	 } 
 	/**
	* Column Info
	* @param  expDt
	*/
	public void	setExpDt( String	expDt ) {
		this.expDt =	expDt;
	}
 
	/**
	 * Column Info
	 * @return	expDt
	 */
	 public	 String	getExpDt() {
		 return	this.expDt;
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
	* @param  comTtlChgAmt
	*/
	public void	setComTtlChgAmt( String	comTtlChgAmt ) {
		this.comTtlChgAmt =	comTtlChgAmt;
	}
 
	/**
	 * Column Info
	 * @return	comTtlChgAmt
	 */
	 public	 String	getComTtlChgAmt() {
		 return	this.comTtlChgAmt;
	 } 
 	/**
	* Column Info
	* @param  crTtlAmt
	*/
	public void	setCrTtlAmt( String	crTtlAmt ) {
		this.crTtlAmt =	crTtlAmt;
	}
 
	/**
	 * Column Info
	 * @return	crTtlAmt
	 */
	 public	 String	getCrTtlAmt() {
		 return	this.crTtlAmt;
	 } 
 	/**
	* Column Info
	* @param  invTtlChgAmt
	*/
	public void	setInvTtlChgAmt( String	invTtlChgAmt ) {
		this.invTtlChgAmt =	invTtlChgAmt;
	}
 
	/**
	 * Column Info
	 * @return	invTtlChgAmt
	 */
	 public	 String	getInvTtlChgAmt() {
		 return	this.invTtlChgAmt;
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
	* @param  chgSeq
	*/
	public void	setChgSeq( String	chgSeq ) {
		this.chgSeq =	chgSeq;
	}
 
	/**
	 * Column Info
	 * @return	chgSeq
	 */
	 public	 String	getChgSeq() {
		 return	this.chgSeq;
	 } 
 	/**
	* Column Info
	* @param  invFilFlg
	*/
	public void	setInvFilFlg( String	invFilFlg ) {
		this.invFilFlg =	invFilFlg;
	}
 
	/**
	 * Column Info
	 * @return	invFilFlg
	 */
	 public	 String	getInvFilFlg() {
		 return	this.invFilFlg;
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
	* @param  ifRgstNo
	*/
	public void	setIfRgstNo( String	ifRgstNo ) {
		this.ifRgstNo =	ifRgstNo;
	}
 
	/**
	 * Column Info
	 * @return	ifRgstNo
	 */
	 public	 String	getIfRgstNo() {
		 return	this.ifRgstNo;
	 } 
 	/**
	* Column Info
	* @param  invRcvDt
	*/
	public void	setInvRcvDt( String	invRcvDt ) {
		this.invRcvDt =	invRcvDt;
	}
 
	/**
	 * Column Info
	 * @return	invRcvDt
	 */
	 public	 String	getInvRcvDt() {
		 return	this.invRcvDt;
	 } 
 	/**
	* Column Info
	* @param  invIssDt
	*/
	public void	setInvIssDt( String	invIssDt ) {
		this.invIssDt =	invIssDt;
	}
 
	/**
	 * Column Info
	 * @return	invIssDt
	 */
	 public	 String	getInvIssDt() {
		 return	this.invIssDt;
	 } 
 	/**
	* Column Info
	* @param  invEffDt
	*/
	public void	setInvEffDt( String	invEffDt ) {
		this.invEffDt =	invEffDt;
	}
 
	/**
	 * Column Info
	 * @return	invEffDt
	 */
	 public	 String	getInvEffDt() {
		 return	this.invEffDt;
	 } 
 	/**
	* Column Info
	* @param  offcCd
	*/
	public void	setOffcCd( String	offcCd ) {
		this.offcCd =	offcCd;
	}
 
	/**
	 * Column Info
	 * @return	offcCd
	 */
	 public	 String	getOffcCd() {
		 return	this.offcCd;
	 } 
 	/**
	* Column Info
	* @param  invRmk
	*/
	public void	setInvRmk( String	invRmk ) {
		this.invRmk =	invRmk;
	}
 
	/**
	 * Column Info
	 * @return	invRmk
	 */
	 public	 String	getInvRmk() {
		 return	this.invRmk;
	 } 
 	/**
	* Column Info
	* @param  vndrTermNm
	*/
	public void	setVndrTermNm( String	vndrTermNm ) {
		this.vndrTermNm =	vndrTermNm;
	}
 
	/**
	 * Column Info
	 * @return	vndrTermNm
	 */
	 public	 String	getVndrTermNm() {
		 return	this.vndrTermNm;
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
	* @param  costOfcCd
	*/
	public void	setCostOfcCd( String	costOfcCd ) {
		this.costOfcCd =	costOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	costOfcCd
	 */
	 public	 String	getCostOfcCd() {
		 return	this.costOfcCd;
	 } 
 	/**
	* Column Info
	* @param  payVndrSeq
	*/
	public void	setPayVndrSeq( String	payVndrSeq ) {
		this.payVndrSeq =	payVndrSeq;
	}
 
	/**
	 * Column Info
	 * @return	payVndrSeq
	 */
	 public	 String	getPayVndrSeq() {
		 return	this.payVndrSeq;
	 } 
 	/**
	* Column Info
	* @param  invVatAmt
	*/
	public void	setInvVatAmt( String	invVatAmt ) {
		this.invVatAmt =	invVatAmt;
	}
 
	/**
	 * Column Info
	 * @return	invVatAmt
	 */
	 public	 String	getInvVatAmt() {
		 return	this.invVatAmt;
	 } 
 	/**
	* Column Info
	* @param  whldTaxAmt
	*/
	public void	setWhldTaxAmt( String	whldTaxAmt ) {
		this.whldTaxAmt =	whldTaxAmt;
	}
 
	/**
	 * Column Info
	 * @return	whldTaxAmt
	 */
	 public	 String	getWhldTaxAmt() {
		 return	this.whldTaxAmt;
	 } 
 	/**
	* Column Info
	* @param  pdmAmt
	*/
	public void	setPdmAmt( String	pdmAmt ) {
		this.pdmAmt =	pdmAmt;
	}
 
	/**
	 * Column Info
	 * @return	pdmAmt
	 */
	 public	 String	getPdmAmt() {
		 return	this.pdmAmt;
	 } 
 	/**
	* Column Info
	* @param  lsePayTpCd
	*/
	public void	setLsePayTpCd( String	lsePayTpCd ) {
		this.lsePayTpCd =	lsePayTpCd;
	}
 
	/**
	 * Column Info
	 * @return	lsePayTpCd
	 */
	 public	 String	getLsePayTpCd() {
		 return	this.lsePayTpCd;
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
		setAgmtNo(JSPUtil.getParameter(request,	prefix + "agmt_no", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setPayRntlCostAmt(JSPUtil.getParameter(request,	prefix + "pay_rntl_cost_amt", ""));
		setInvNo(JSPUtil.getParameter(request,	prefix + "inv_no", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request,	prefix + "eff_dt", ""));
		setLseCtrtNo(JSPUtil.getParameter(request,	prefix + "lse_ctrt_no", ""));
		setAgmtLstVerSeq(JSPUtil.getParameter(request,	prefix + "agmt_lst_ver_seq", ""));
		setRefNo(JSPUtil.getParameter(request,	prefix + "ref_no", ""));
		setChgStsCd(JSPUtil.getParameter(request,	prefix + "chg_sts_cd", ""));
		setExpDt(JSPUtil.getParameter(request,	prefix + "exp_dt", ""));
		setLstmCd(JSPUtil.getParameter(request,	prefix + "lstm_cd", ""));
		setComTtlChgAmt(JSPUtil.getParameter(request,	prefix + "com_ttl_chg_amt", ""));
		setCrTtlAmt(JSPUtil.getParameter(request,	prefix + "cr_ttl_amt", ""));
		setInvTtlChgAmt(JSPUtil.getParameter(request,	prefix + "inv_ttl_chg_amt", ""));
		setCurrCd(JSPUtil.getParameter(request,	prefix + "curr_cd", ""));
		setAgmtCtyCd(JSPUtil.getParameter(request,	prefix + "agmt_cty_cd", ""));
		setAgmtSeq(JSPUtil.getParameter(request,	prefix + "agmt_seq", ""));
		setChgSeq(JSPUtil.getParameter(request,	prefix + "chg_seq", ""));
		setInvFilFlg(JSPUtil.getParameter(request,	prefix + "inv_fil_flg", ""));
		setCreDt(JSPUtil.getParameter(request,	prefix + "cre_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setIfRgstNo(JSPUtil.getParameter(request,	prefix + "if_rgst_no", ""));
		setInvRcvDt(JSPUtil.getParameter(request,	prefix + "inv_rcv_dt", ""));
		setInvIssDt(JSPUtil.getParameter(request,	prefix + "inv_iss_dt", ""));
		setInvEffDt(JSPUtil.getParameter(request,	prefix + "inv_eff_dt", ""));
		setOffcCd(JSPUtil.getParameter(request,	prefix + "offc_cd", ""));
		setInvRmk(JSPUtil.getParameter(request,	prefix + "inv_rmk", ""));
		setVndrTermNm(JSPUtil.getParameter(request,	prefix + "vndr_term_nm", ""));
		setInvOfcCd(JSPUtil.getParameter(request,	prefix + "inv_ofc_cd", ""));
		setCostOfcCd(JSPUtil.getParameter(request,	prefix + "cost_ofc_cd", ""));
		setPayVndrSeq(JSPUtil.getParameter(request,	prefix + "pay_vndr_seq", ""));
		setInvVatAmt(JSPUtil.getParameter(request,	prefix + "inv_vat_amt", ""));
		setWhldTaxAmt(JSPUtil.getParameter(request,	prefix + "whld_tax_amt", ""));
		setPdmAmt(JSPUtil.getParameter(request,	prefix + "pdm_amt", ""));
		setLsePayTpCd(JSPUtil.getParameter(request,	prefix + "lse_pay_tp_cd", ""));
	}
	
	/**
	 * Request ���곗씠�곕� VO 諛곗뿴濡�蹂�솚�섏뿬 諛섑솚.
	 * @param request
	 * @return PayableRentalCostCreatVO[]
	 */
	public PayableRentalCostCreatVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request �섏뼱���щ윭 嫄�DATA瑜�VO Class ���대뒗��
	 * @param request
	 * @param prefix
	 * @return PayableRentalCostCreatVO[]
	 */
	public PayableRentalCostCreatVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		PayableRentalCostCreatVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] agmtNo =	(JSPUtil.getParameter(request, prefix +	"agmt_no".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] payRntlCostAmt =	(JSPUtil.getParameter(request, prefix +	"pay_rntl_cost_amt".trim(),	length));
				String[] invNo =	(JSPUtil.getParameter(request, prefix +	"inv_no".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] effDt =	(JSPUtil.getParameter(request, prefix +	"eff_dt".trim(),	length));
				String[] lseCtrtNo =	(JSPUtil.getParameter(request, prefix +	"lse_ctrt_no".trim(),	length));
				String[] agmtLstVerSeq =	(JSPUtil.getParameter(request, prefix +	"agmt_lst_ver_seq".trim(),	length));
				String[] refNo =	(JSPUtil.getParameter(request, prefix +	"ref_no".trim(),	length));
				String[] chgStsCd =	(JSPUtil.getParameter(request, prefix +	"chg_sts_cd".trim(),	length));
				String[] expDt =	(JSPUtil.getParameter(request, prefix +	"exp_dt".trim(),	length));
				String[] lstmCd =	(JSPUtil.getParameter(request, prefix +	"lstm_cd".trim(),	length));
				String[] comTtlChgAmt =	(JSPUtil.getParameter(request, prefix +	"com_ttl_chg_amt".trim(),	length));
				String[] crTtlAmt =	(JSPUtil.getParameter(request, prefix +	"cr_ttl_amt".trim(),	length));
				String[] invTtlChgAmt =	(JSPUtil.getParameter(request, prefix +	"inv_ttl_chg_amt".trim(),	length));
				String[] currCd =	(JSPUtil.getParameter(request, prefix +	"curr_cd".trim(),	length));
				String[] agmtCtyCd =	(JSPUtil.getParameter(request, prefix +	"agmt_cty_cd".trim(),	length));
				String[] agmtSeq =	(JSPUtil.getParameter(request, prefix +	"agmt_seq".trim(),	length));
				String[] chgSeq =	(JSPUtil.getParameter(request, prefix +	"chg_seq".trim(),	length));
				String[] invFilFlg =	(JSPUtil.getParameter(request, prefix +	"inv_fil_flg".trim(),	length));
				String[] creDt =	(JSPUtil.getParameter(request, prefix +	"cre_dt".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				String[] ifRgstNo =	(JSPUtil.getParameter(request, prefix +	"if_rgst_no".trim(),	length));
				String[] invRcvDt =	(JSPUtil.getParameter(request, prefix +	"inv_rcv_dt".trim(),	length));
				String[] invIssDt =	(JSPUtil.getParameter(request, prefix +	"inv_iss_dt".trim(),	length));
				String[] invEffDt =	(JSPUtil.getParameter(request, prefix +	"inv_eff_dt".trim(),	length));
				String[] offcCd =	(JSPUtil.getParameter(request, prefix +	"offc_cd".trim(),	length));
				String[] invRmk =	(JSPUtil.getParameter(request, prefix +	"inv_rmk".trim(),	length));
				String[] vndrTermNm =	(JSPUtil.getParameter(request, prefix +	"vndr_term_nm".trim(),	length));
				String[] invOfcCd =	(JSPUtil.getParameter(request, prefix +	"inv_ofc_cd".trim(),	length));
				String[] costOfcCd =	(JSPUtil.getParameter(request, prefix +	"cost_ofc_cd".trim(),	length));
				String[] payVndrSeq =	(JSPUtil.getParameter(request, prefix +	"pay_vndr_seq".trim(),	length));
				String[] invVatAmt =	(JSPUtil.getParameter(request, prefix +	"inv_vat_amt".trim(),	length));
				String[] whldTaxAmt =	(JSPUtil.getParameter(request, prefix +	"whld_tax_amt".trim(),	length));
				String[] pdmAmt =	(JSPUtil.getParameter(request, prefix +	"pdm_amt".trim(),	length));
				String[] lsePayTpCd =	(JSPUtil.getParameter(request, prefix +	"lse_pay_tp_cd".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	PayableRentalCostCreatVO();
						if ( agmtNo[i] !=	null)
						model.setAgmtNo( agmtNo[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( payRntlCostAmt[i] !=	null)
						model.setPayRntlCostAmt( payRntlCostAmt[i]);
						if ( invNo[i] !=	null)
						model.setInvNo( invNo[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( effDt[i] !=	null)
						model.setEffDt( effDt[i]);
						if ( lseCtrtNo[i] !=	null)
						model.setLseCtrtNo( lseCtrtNo[i]);
						if ( agmtLstVerSeq[i] !=	null)
						model.setAgmtLstVerSeq( agmtLstVerSeq[i]);
						if ( refNo[i] !=	null)
						model.setRefNo( refNo[i]);
						if ( chgStsCd[i] !=	null)
						model.setChgStsCd( chgStsCd[i]);
						if ( expDt[i] !=	null)
						model.setExpDt( expDt[i]);
						if ( lstmCd[i] !=	null)
						model.setLstmCd( lstmCd[i]);
						if ( comTtlChgAmt[i] !=	null)
						model.setComTtlChgAmt( comTtlChgAmt[i]);
						if ( crTtlAmt[i] !=	null)
						model.setCrTtlAmt( crTtlAmt[i]);
						if ( invTtlChgAmt[i] !=	null)
						model.setInvTtlChgAmt( invTtlChgAmt[i]);
						if ( currCd[i] !=	null)
						model.setCurrCd( currCd[i]);
						if ( agmtCtyCd[i] !=	null)
						model.setAgmtCtyCd( agmtCtyCd[i]);
						if ( agmtSeq[i] !=	null)
						model.setAgmtSeq( agmtSeq[i]);
						if ( chgSeq[i] !=	null)
						model.setChgSeq( chgSeq[i]);
						if ( invFilFlg[i] !=	null)
						model.setInvFilFlg( invFilFlg[i]);
						if ( creDt[i] !=	null)
						model.setCreDt( creDt[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
						if ( ifRgstNo[i] !=	null)
						model.setIfRgstNo( ifRgstNo[i]);
						if ( invRcvDt[i] !=	null)
						model.setInvRcvDt( invRcvDt[i]);
						if ( invIssDt[i] !=	null)
						model.setInvIssDt( invIssDt[i]);
						if ( invEffDt[i] !=	null)
						model.setInvEffDt( invEffDt[i]);
						if ( offcCd[i] !=	null)
						model.setOffcCd( offcCd[i]);
						if ( invRmk[i] !=	null)
						model.setInvRmk( invRmk[i]);
						if ( vndrTermNm[i] !=	null)
						model.setVndrTermNm( vndrTermNm[i]);
						if ( invOfcCd[i] !=	null)
						model.setInvOfcCd( invOfcCd[i]);
						if ( costOfcCd[i] !=	null)
						model.setCostOfcCd( costOfcCd[i]);
						if ( payVndrSeq[i] !=	null)
						model.setPayVndrSeq( payVndrSeq[i]);
						if ( invVatAmt[i] !=	null)
						model.setInvVatAmt( invVatAmt[i]);
						if ( whldTaxAmt[i] !=	null)
						model.setWhldTaxAmt( whldTaxAmt[i]);
						if ( pdmAmt[i] !=	null)
						model.setPdmAmt( pdmAmt[i]);
						if ( lsePayTpCd[i] !=	null)
						model.setLsePayTpCd( lsePayTpCd[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getPayableRentalCostCreatVOs();
	}

	/**
	 *  VO 諛곗뿴��諛섑솚
	 * @return PayableRentalCostCreatVO[]
	 */
	public PayableRentalCostCreatVO[]	 getPayableRentalCostCreatVOs(){
		PayableRentalCostCreatVO[] vos = (PayableRentalCostCreatVO[])models.toArray(new	PayableRentalCostCreatVO[models.size()]);
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
		this.agmtNo =	this.agmtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payRntlCostAmt =	this.payRntlCostAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo =	this.invNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt =	this.effDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lseCtrtNo =	this.lseCtrtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtLstVerSeq =	this.agmtLstVerSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refNo =	this.refNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgStsCd =	this.chgStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt =	this.expDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd =	this.lstmCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comTtlChgAmt =	this.comTtlChgAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crTtlAmt =	this.crTtlAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTtlChgAmt =	this.invTtlChgAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd =	this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCtyCd =	this.agmtCtyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq =	this.agmtSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgSeq =	this.chgSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invFilFlg =	this.invFilFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt =	this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifRgstNo =	this.ifRgstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRcvDt =	this.invRcvDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIssDt =	this.invIssDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invEffDt =	this.invEffDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offcCd =	this.offcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRmk =	this.invRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrTermNm =	this.vndrTermNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invOfcCd =	this.invOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costOfcCd =	this.costOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payVndrSeq =	this.payVndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invVatAmt =	this.invVatAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whldTaxAmt =	this.whldTaxAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pdmAmt =	this.pdmAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lsePayTpCd =	this.lsePayTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}