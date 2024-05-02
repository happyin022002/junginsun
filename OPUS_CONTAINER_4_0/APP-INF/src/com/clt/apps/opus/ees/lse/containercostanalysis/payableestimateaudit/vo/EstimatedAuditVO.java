/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : EstimatedAuditVO.java
 *@FileTitle : EstimatedAuditVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.01.29
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2016.01.29  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.ees.lse.containercostanalysis.payableestimateaudit.vo;

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
public class EstimatedAuditVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<EstimatedAuditVO>  models =	new	ArrayList<EstimatedAuditVO>();


	/*	Column Info	*/
	private  String	 opLseDivFlg   =  null;
	/*	Column Info	*/
	private  String	 vslCd   =  null;
	/*	Column Info	*/
	private  String	 acctCode   =  null;
	/*	Column Info	*/
	private  String	 revMonth   =  null;
	/*	Column Info	*/
	private  String	 ttlTrfAmt   =  null;
	/*	Column Info	*/
	private  String	 creDt   =  null;
	/*	Column Info	*/
	private  String	 hirDtAmt   =  null;
	/*	Column Info	*/
	private  String	 estimatedCost   =  null;
	/*	Column Info	*/
	private  String	 sysName   =  null;
	/*	Column Info	*/
	private  String	 periodStdt   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 estBsaQty   =  null;
	/*	Column Info	*/
	private  String	 revDirCd   =  null;
	/*	Column Info	*/
	private  String	 estQty   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 locCd   =  null;
	/*	Column Info	*/
	private  String	 agmtCtyCd   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 updDt   =  null;
	/*	Column Info	*/
	private  String	 tpSz   =  null;
	/*	Column Info	*/
	private  String	 agmtSeq   =  null;
	/*	Column Info	*/
	private  String	 agmtNo   =  null;
	/*	Column Info	*/
	private  String	 skdVoyNo   =  null;
	/*	Column Info	*/
	private  String	 bizUnit   =  null;
	/*	Column Info	*/
	private  String	 custSeq   =  null;
	/*	Column Info	*/
	private  String	 actualCost   =  null;
	/*	Column Info	*/
	private  String	 sltCostAmt   =  null;
	/*	Column Info	*/
	private  String	 skdDirCd   =  null;
	/*	Column Info	*/
	private  String	 accuralAmt   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;
	/*	Column Info	*/
	private  String	 actualMonth   =  null;
	/*	Column Info	*/
	private  String	 seq   =  null;
	/*	Column Info	*/
	private  String	 revVvd   =  null;
	/*	Column Info	*/
	private  String	 periodEddt   =  null;
	/*	Column Info	*/
	private  String	 loclCurrCd   =  null;
	/*	Column Info	*/
	private  String	 actDt   =  null;
	/*	Column Info	*/
	private  String	 actPlcCd   =  null;
	/*	Column Info	*/
	private  String	 slanCd   =  null;
	/*	Column Info	*/
	private  String	 acctDtlCd   =  null;
	/*	Column Info	*/
	private  String	 costActPlcCd   =  null;
	/*	Column Info	*/
	private  String	 lseCtrtNo   =  null;
	/*	Column Info	*/
	private  String	 vndrSeq   =  null;
	/*	Column Info	*/
	private  String	 vndrLglEngNm   =  null;
	/*	Column Info	*/
	private  String	 lsePayChgTpCd   =  null;
	/*	Column Info	*/
	private  String	 skr_acct_cd   =  null;
	/*	Column Info	*/
	private  String	 lstm_cd   =  null;
	/*	Column Info	*/
	private  String	 ifChkFlg   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public EstimatedAuditVO(){}

	public EstimatedAuditVO(String opLseDivFlg,String vslCd,String acctCode,String revMonth,String ttlTrfAmt,String creDt,String hirDtAmt,String estimatedCost,String sysName,String periodStdt,String pagerows,String estBsaQty,String revDirCd,String estQty,String ibflag,String locCd,String agmtCtyCd,String updUsrId,String updDt,String tpSz,String agmtSeq,String agmtNo,String skdVoyNo,String bizUnit,String custSeq,String actualCost,String sltCostAmt,String skdDirCd,String accuralAmt,String creUsrId,String actualMonth,String seq,String revVvd,String periodEddt,String loclCurrCd,String actDt,String actPlcCd,String slanCd,String acctDtlCd,String costActPlcCd,String lseCtrtNo,String vndrSeq,String vndrLglEngNm,String lsePayChgTpCd,String skr_acct_cd,String lstm_cd,String ifChkFlg)	{
		this.opLseDivFlg  = opLseDivFlg ;
		this.vslCd  = vslCd ;
		this.acctCode  = acctCode ;
		this.revMonth  = revMonth ;
		this.ttlTrfAmt  = ttlTrfAmt ;
		this.creDt  = creDt ;
		this.hirDtAmt  = hirDtAmt ;
		this.estimatedCost  = estimatedCost ;
		this.sysName  = sysName ;
		this.periodStdt  = periodStdt ;
		this.pagerows  = pagerows ;
		this.estBsaQty  = estBsaQty ;
		this.revDirCd  = revDirCd ;
		this.estQty  = estQty ;
		this.ibflag  = ibflag ;
		this.locCd  = locCd ;
		this.agmtCtyCd  = agmtCtyCd ;
		this.updUsrId  = updUsrId ;
		this.updDt  = updDt ;
		this.tpSz  = tpSz ;
		this.agmtSeq  = agmtSeq ;
		this.agmtNo  = agmtNo ;
		this.skdVoyNo  = skdVoyNo ;
		this.bizUnit  = bizUnit ;
		this.custSeq  = custSeq ;
		this.actualCost  = actualCost ;
		this.sltCostAmt  = sltCostAmt ;
		this.skdDirCd  = skdDirCd ;
		this.accuralAmt  = accuralAmt ;
		this.creUsrId  = creUsrId ;
		this.actualMonth  = actualMonth ;
		this.seq  = seq ;
		this.revVvd  = revVvd ;
		this.periodEddt  = periodEddt ;
		this.loclCurrCd  = loclCurrCd ;
		this.actDt  = actDt ;
		this.actPlcCd  = actPlcCd ;
		this.slanCd  = slanCd ;
		this.acctDtlCd  = acctDtlCd ;
		this.costActPlcCd  = costActPlcCd ;
		this.lseCtrtNo  = lseCtrtNo ;
		this.vndrSeq  = vndrSeq ;
		this.vndrLglEngNm  = vndrLglEngNm ;
		this.lsePayChgTpCd  = lsePayChgTpCd ;
		this.skr_acct_cd  = skr_acct_cd ;
		this.lstm_cd  = lstm_cd ;
		this.ifChkFlg  = ifChkFlg ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("op_lse_div_flg", getOpLseDivFlg());		
		this.hashColumns.put("vsl_cd", getVslCd());		
		this.hashColumns.put("acct_code", getAcctCode());		
		this.hashColumns.put("rev_month", getRevMonth());		
		this.hashColumns.put("ttl_trf_amt", getTtlTrfAmt());		
		this.hashColumns.put("cre_dt", getCreDt());		
		this.hashColumns.put("hir_dt_amt", getHirDtAmt());		
		this.hashColumns.put("estimated_cost", getEstimatedCost());		
		this.hashColumns.put("sys_name", getSysName());		
		this.hashColumns.put("period_stdt", getPeriodStdt());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("est_bsa_qty", getEstBsaQty());		
		this.hashColumns.put("rev_dir_cd", getRevDirCd());		
		this.hashColumns.put("est_qty", getEstQty());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("loc_cd", getLocCd());		
		this.hashColumns.put("agmt_cty_cd", getAgmtCtyCd());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("upd_dt", getUpdDt());		
		this.hashColumns.put("tp_sz", getTpSz());		
		this.hashColumns.put("agmt_seq", getAgmtSeq());		
		this.hashColumns.put("agmt_no", getAgmtNo());		
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());		
		this.hashColumns.put("biz_unit", getBizUnit());		
		this.hashColumns.put("cust_seq", getCustSeq());		
		this.hashColumns.put("actual_cost", getActualCost());		
		this.hashColumns.put("slt_cost_amt", getSltCostAmt());		
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());		
		this.hashColumns.put("accural_amt", getAccuralAmt());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("actual_month", getActualMonth());		
		this.hashColumns.put("seq", getSeq());		
		this.hashColumns.put("rev_vvd", getRevVvd());		
		this.hashColumns.put("period_eddt", getPeriodEddt());		
		this.hashColumns.put("locl_curr_cd", getLoclCurrCd());		
		this.hashColumns.put("act_dt", getActDt());		
		this.hashColumns.put("act_plc_cd", getActPlcCd());		
		this.hashColumns.put("slan_cd", getSlanCd());		
		this.hashColumns.put("acct_dtl_cd", getAcctDtlCd());		
		this.hashColumns.put("cost_act_plc_cd", getCostActPlcCd());		
		this.hashColumns.put("lse_ctrt_no", getLseCtrtNo());		
		this.hashColumns.put("vndr_seq", getVndrSeq());		
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());		
		this.hashColumns.put("lse_pay_chg_tp_cd", getLsePayChgTpCd());		
		this.hashColumns.put("skr_acct_cd", getSkr_acct_cd());		
		this.hashColumns.put("lstm_cd", getLstm_cd());		
		this.hashColumns.put("if_chk_flg", getIfChkFlg());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("op_lse_div_flg", "opLseDivFlg");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("acct_code", "acctCode");
		this.hashFields.put("rev_month", "revMonth");
		this.hashFields.put("ttl_trf_amt", "ttlTrfAmt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("hir_dt_amt", "hirDtAmt");
		this.hashFields.put("estimated_cost", "estimatedCost");
		this.hashFields.put("sys_name", "sysName");
		this.hashFields.put("period_stdt", "periodStdt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("est_bsa_qty", "estBsaQty");
		this.hashFields.put("rev_dir_cd", "revDirCd");
		this.hashFields.put("est_qty", "estQty");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("agmt_cty_cd", "agmtCtyCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("tp_sz", "tpSz");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("biz_unit", "bizUnit");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("actual_cost", "actualCost");
		this.hashFields.put("slt_cost_amt", "sltCostAmt");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("accural_amt", "accuralAmt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("actual_month", "actualMonth");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("rev_vvd", "revVvd");
		this.hashFields.put("period_eddt", "periodEddt");
		this.hashFields.put("locl_curr_cd", "loclCurrCd");
		this.hashFields.put("act_dt", "actDt");
		this.hashFields.put("act_plc_cd", "actPlcCd");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("acct_dtl_cd", "acctDtlCd");
		this.hashFields.put("cost_act_plc_cd", "costActPlcCd");
		this.hashFields.put("lse_ctrt_no", "lseCtrtNo");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("lse_pay_chg_tp_cd", "lsePayChgTpCd");
		this.hashFields.put("skr_acct_cd", "skr_acct_cd");
		this.hashFields.put("lstm_cd", "lstm_cd");
		this.hashFields.put("if_chk_flg", "ifChkFlg");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  opLseDivFlg
	*/
	public void	setOpLseDivFlg( String	opLseDivFlg ) {
		this.opLseDivFlg =	opLseDivFlg;
	}
 
	/**
	 * Column Info
	 * @return	opLseDivFlg
	 */
	 public	 String	getOpLseDivFlg() {
		 return	this.opLseDivFlg;
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
	* @param  acctCode
	*/
	public void	setAcctCode( String	acctCode ) {
		this.acctCode =	acctCode;
	}
 
	/**
	 * Column Info
	 * @return	acctCode
	 */
	 public	 String	getAcctCode() {
		 return	this.acctCode;
	 } 
 	/**
	* Column Info
	* @param  revMonth
	*/
	public void	setRevMonth( String	revMonth ) {
		this.revMonth =	revMonth;
	}
 
	/**
	 * Column Info
	 * @return	revMonth
	 */
	 public	 String	getRevMonth() {
		 return	this.revMonth;
	 } 
 	/**
	* Column Info
	* @param  ttlTrfAmt
	*/
	public void	setTtlTrfAmt( String	ttlTrfAmt ) {
		this.ttlTrfAmt =	ttlTrfAmt;
	}
 
	/**
	 * Column Info
	 * @return	ttlTrfAmt
	 */
	 public	 String	getTtlTrfAmt() {
		 return	this.ttlTrfAmt;
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
	* @param  hirDtAmt
	*/
	public void	setHirDtAmt( String	hirDtAmt ) {
		this.hirDtAmt =	hirDtAmt;
	}
 
	/**
	 * Column Info
	 * @return	hirDtAmt
	 */
	 public	 String	getHirDtAmt() {
		 return	this.hirDtAmt;
	 } 
 	/**
	* Column Info
	* @param  estimatedCost
	*/
	public void	setEstimatedCost( String	estimatedCost ) {
		this.estimatedCost =	estimatedCost;
	}
 
	/**
	 * Column Info
	 * @return	estimatedCost
	 */
	 public	 String	getEstimatedCost() {
		 return	this.estimatedCost;
	 } 
 	/**
	* Column Info
	* @param  sysName
	*/
	public void	setSysName( String	sysName ) {
		this.sysName =	sysName;
	}
 
	/**
	 * Column Info
	 * @return	sysName
	 */
	 public	 String	getSysName() {
		 return	this.sysName;
	 } 
 	/**
	* Column Info
	* @param  periodStdt
	*/
	public void	setPeriodStdt( String	periodStdt ) {
		this.periodStdt =	periodStdt;
	}
 
	/**
	 * Column Info
	 * @return	periodStdt
	 */
	 public	 String	getPeriodStdt() {
		 return	this.periodStdt;
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
	* @param  estBsaQty
	*/
	public void	setEstBsaQty( String	estBsaQty ) {
		this.estBsaQty =	estBsaQty;
	}
 
	/**
	 * Column Info
	 * @return	estBsaQty
	 */
	 public	 String	getEstBsaQty() {
		 return	this.estBsaQty;
	 } 
 	/**
	* Column Info
	* @param  revDirCd
	*/
	public void	setRevDirCd( String	revDirCd ) {
		this.revDirCd =	revDirCd;
	}
 
	/**
	 * Column Info
	 * @return	revDirCd
	 */
	 public	 String	getRevDirCd() {
		 return	this.revDirCd;
	 } 
 	/**
	* Column Info
	* @param  estQty
	*/
	public void	setEstQty( String	estQty ) {
		this.estQty =	estQty;
	}
 
	/**
	 * Column Info
	 * @return	estQty
	 */
	 public	 String	getEstQty() {
		 return	this.estQty;
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
	* @param  locCd
	*/
	public void	setLocCd( String	locCd ) {
		this.locCd =	locCd;
	}
 
	/**
	 * Column Info
	 * @return	locCd
	 */
	 public	 String	getLocCd() {
		 return	this.locCd;
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
	* @param  tpSz
	*/
	public void	setTpSz( String	tpSz ) {
		this.tpSz =	tpSz;
	}
 
	/**
	 * Column Info
	 * @return	tpSz
	 */
	 public	 String	getTpSz() {
		 return	this.tpSz;
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
	* @param  bizUnit
	*/
	public void	setBizUnit( String	bizUnit ) {
		this.bizUnit =	bizUnit;
	}
 
	/**
	 * Column Info
	 * @return	bizUnit
	 */
	 public	 String	getBizUnit() {
		 return	this.bizUnit;
	 } 
 	/**
	* Column Info
	* @param  custSeq
	*/
	public void	setCustSeq( String	custSeq ) {
		this.custSeq =	custSeq;
	}
 
	/**
	 * Column Info
	 * @return	custSeq
	 */
	 public	 String	getCustSeq() {
		 return	this.custSeq;
	 } 
 	/**
	* Column Info
	* @param  actualCost
	*/
	public void	setActualCost( String	actualCost ) {
		this.actualCost =	actualCost;
	}
 
	/**
	 * Column Info
	 * @return	actualCost
	 */
	 public	 String	getActualCost() {
		 return	this.actualCost;
	 } 
 	/**
	* Column Info
	* @param  sltCostAmt
	*/
	public void	setSltCostAmt( String	sltCostAmt ) {
		this.sltCostAmt =	sltCostAmt;
	}
 
	/**
	 * Column Info
	 * @return	sltCostAmt
	 */
	 public	 String	getSltCostAmt() {
		 return	this.sltCostAmt;
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
	* @param  accuralAmt
	*/
	public void	setAccuralAmt( String	accuralAmt ) {
		this.accuralAmt =	accuralAmt;
	}
 
	/**
	 * Column Info
	 * @return	accuralAmt
	 */
	 public	 String	getAccuralAmt() {
		 return	this.accuralAmt;
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
	* @param  actualMonth
	*/
	public void	setActualMonth( String	actualMonth ) {
		this.actualMonth =	actualMonth;
	}
 
	/**
	 * Column Info
	 * @return	actualMonth
	 */
	 public	 String	getActualMonth() {
		 return	this.actualMonth;
	 } 
 	/**
	* Column Info
	* @param  seq
	*/
	public void	setSeq( String	seq ) {
		this.seq =	seq;
	}
 
	/**
	 * Column Info
	 * @return	seq
	 */
	 public	 String	getSeq() {
		 return	this.seq;
	 } 
 	/**
	* Column Info
	* @param  revVvd
	*/
	public void	setRevVvd( String	revVvd ) {
		this.revVvd =	revVvd;
	}
 
	/**
	 * Column Info
	 * @return	revVvd
	 */
	 public	 String	getRevVvd() {
		 return	this.revVvd;
	 } 
 	/**
	* Column Info
	* @param  periodEddt
	*/
	public void	setPeriodEddt( String	periodEddt ) {
		this.periodEddt =	periodEddt;
	}
 
	/**
	 * Column Info
	 * @return	periodEddt
	 */
	 public	 String	getPeriodEddt() {
		 return	this.periodEddt;
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
	* @param  actDt
	*/
	public void	setActDt( String	actDt ) {
		this.actDt =	actDt;
	}
 
	/**
	 * Column Info
	 * @return	actDt
	 */
	 public	 String	getActDt() {
		 return	this.actDt;
	 } 
 	/**
	* Column Info
	* @param  actPlcCd
	*/
	public void	setActPlcCd( String	actPlcCd ) {
		this.actPlcCd =	actPlcCd;
	}
 
	/**
	 * Column Info
	 * @return	actPlcCd
	 */
	 public	 String	getActPlcCd() {
		 return	this.actPlcCd;
	 } 
 	/**
	* Column Info
	* @param  slanCd
	*/
	public void	setSlanCd( String	slanCd ) {
		this.slanCd =	slanCd;
	}
 
	/**
	 * Column Info
	 * @return	slanCd
	 */
	 public	 String	getSlanCd() {
		 return	this.slanCd;
	 } 
 	/**
	* Column Info
	* @param  acctDtlCd
	*/
	public void	setAcctDtlCd( String	acctDtlCd ) {
		this.acctDtlCd =	acctDtlCd;
	}
 
	/**
	 * Column Info
	 * @return	acctDtlCd
	 */
	 public	 String	getAcctDtlCd() {
		 return	this.acctDtlCd;
	 } 
 	/**
	* Column Info
	* @param  costActPlcCd
	*/
	public void	setCostActPlcCd( String	costActPlcCd ) {
		this.costActPlcCd =	costActPlcCd;
	}
 
	/**
	 * Column Info
	 * @return	costActPlcCd
	 */
	 public	 String	getCostActPlcCd() {
		 return	this.costActPlcCd;
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
	* @param  vndrSeq
	*/
	public void	setVndrSeq( String	vndrSeq ) {
		this.vndrSeq =	vndrSeq;
	}
 
	/**
	 * Column Info
	 * @return	vndrSeq
	 */
	 public	 String	getVndrSeq() {
		 return	this.vndrSeq;
	 } 
 	/**
	* Column Info
	* @param  vndrLglEngNm
	*/
	public void	setVndrLglEngNm( String	vndrLglEngNm ) {
		this.vndrLglEngNm =	vndrLglEngNm;
	}
 
	/**
	 * Column Info
	 * @return	vndrLglEngNm
	 */
	 public	 String	getVndrLglEngNm() {
		 return	this.vndrLglEngNm;
	 } 
 	/**
	* Column Info
	* @param  lsePayChgTpCd
	*/
	public void	setLsePayChgTpCd( String	lsePayChgTpCd ) {
		this.lsePayChgTpCd =	lsePayChgTpCd;
	}
 
	/**
	 * Column Info
	 * @return	lsePayChgTpCd
	 */
	 public	 String	getLsePayChgTpCd() {
		 return	this.lsePayChgTpCd;
	 } 
 	/**
	* Column Info
	* @param  skr_acct_cd
	*/
	public void	setSkr_acct_cd( String	skr_acct_cd ) {
		this.skr_acct_cd =	skr_acct_cd;
	}
 
	/**
	 * Column Info
	 * @return	skr_acct_cd
	 */
	 public	 String	getSkr_acct_cd() {
		 return	this.skr_acct_cd;
	 } 
 	/**
	* Column Info
	* @param  lstm_cd
	*/
	public void	setLstm_cd( String	lstm_cd ) {
		this.lstm_cd =	lstm_cd;
	}
 
	/**
	 * Column Info
	 * @return	lstm_cd
	 */
	 public	 String	getLstm_cd() {
		 return	this.lstm_cd;
	 } 
 	/**
	* Column Info
	* @param  ifChkFlg
	*/
	public void	setIfChkFlg( String	ifChkFlg ) {
		this.ifChkFlg =	ifChkFlg;
	}
 
	/**
	 * Column Info
	 * @return	ifChkFlg
	 */
	 public	 String	getIfChkFlg() {
		 return	this.ifChkFlg;
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
		setOpLseDivFlg(JSPUtil.getParameter(request,	prefix + "op_lse_div_flg", ""));
		setVslCd(JSPUtil.getParameter(request,	prefix + "vsl_cd", ""));
		setAcctCode(JSPUtil.getParameter(request,	prefix + "acct_code", ""));
		setRevMonth(JSPUtil.getParameter(request,	prefix + "rev_month", ""));
		setTtlTrfAmt(JSPUtil.getParameter(request,	prefix + "ttl_trf_amt", ""));
		setCreDt(JSPUtil.getParameter(request,	prefix + "cre_dt", ""));
		setHirDtAmt(JSPUtil.getParameter(request,	prefix + "hir_dt_amt", ""));
		setEstimatedCost(JSPUtil.getParameter(request,	prefix + "estimated_cost", ""));
		setSysName(JSPUtil.getParameter(request,	prefix + "sys_name", ""));
		setPeriodStdt(JSPUtil.getParameter(request,	prefix + "period_stdt", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setEstBsaQty(JSPUtil.getParameter(request,	prefix + "est_bsa_qty", ""));
		setRevDirCd(JSPUtil.getParameter(request,	prefix + "rev_dir_cd", ""));
		setEstQty(JSPUtil.getParameter(request,	prefix + "est_qty", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setLocCd(JSPUtil.getParameter(request,	prefix + "loc_cd", ""));
		setAgmtCtyCd(JSPUtil.getParameter(request,	prefix + "agmt_cty_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request,	prefix + "upd_dt", ""));
		setTpSz(JSPUtil.getParameter(request,	prefix + "tp_sz", ""));
		setAgmtSeq(JSPUtil.getParameter(request,	prefix + "agmt_seq", ""));
		setAgmtNo(JSPUtil.getParameter(request,	prefix + "agmt_no", ""));
		setSkdVoyNo(JSPUtil.getParameter(request,	prefix + "skd_voy_no", ""));
		setBizUnit(JSPUtil.getParameter(request,	prefix + "biz_unit", ""));
		setCustSeq(JSPUtil.getParameter(request,	prefix + "cust_seq", ""));
		setActualCost(JSPUtil.getParameter(request,	prefix + "actual_cost", ""));
		setSltCostAmt(JSPUtil.getParameter(request,	prefix + "slt_cost_amt", ""));
		setSkdDirCd(JSPUtil.getParameter(request,	prefix + "skd_dir_cd", ""));
		setAccuralAmt(JSPUtil.getParameter(request,	prefix + "accural_amt", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setActualMonth(JSPUtil.getParameter(request,	prefix + "actual_month", ""));
		setSeq(JSPUtil.getParameter(request,	prefix + "seq", ""));
		setRevVvd(JSPUtil.getParameter(request,	prefix + "rev_vvd", ""));
		setPeriodEddt(JSPUtil.getParameter(request,	prefix + "period_eddt", ""));
		setLoclCurrCd(JSPUtil.getParameter(request,	prefix + "locl_curr_cd", ""));
		setActDt(JSPUtil.getParameter(request,	prefix + "act_dt", ""));
		setActPlcCd(JSPUtil.getParameter(request,	prefix + "act_plc_cd", ""));
		setSlanCd(JSPUtil.getParameter(request,	prefix + "slan_cd", ""));
		setAcctDtlCd(JSPUtil.getParameter(request,	prefix + "acct_dtl_cd", ""));
		setCostActPlcCd(JSPUtil.getParameter(request,	prefix + "cost_act_plc_cd", ""));
		setLseCtrtNo(JSPUtil.getParameter(request,	prefix + "lse_ctrt_no", ""));
		setVndrSeq(JSPUtil.getParameter(request,	prefix + "vndr_seq", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request,	prefix + "vndr_lgl_eng_nm", ""));
		setLsePayChgTpCd(JSPUtil.getParameter(request,	prefix + "lse_pay_chg_tp_cd", ""));
		setSkr_acct_cd(JSPUtil.getParameter(request,	prefix + "skr_acct_cd", ""));
		setLstm_cd(JSPUtil.getParameter(request,	prefix + "lstm_cd", ""));
		setIfChkFlg(JSPUtil.getParameter(request,	prefix + "if_chk_flg", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EstimatedAuditVO[]
	 */
	public EstimatedAuditVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return EstimatedAuditVO[]
	 */
	public EstimatedAuditVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		EstimatedAuditVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] opLseDivFlg =	(JSPUtil.getParameter(request, prefix +	"op_lse_div_flg".trim(),	length));
				String[] vslCd =	(JSPUtil.getParameter(request, prefix +	"vsl_cd".trim(),	length));
				String[] acctCode =	(JSPUtil.getParameter(request, prefix +	"acct_code".trim(),	length));
				String[] revMonth =	(JSPUtil.getParameter(request, prefix +	"rev_month".trim(),	length));
				String[] ttlTrfAmt =	(JSPUtil.getParameter(request, prefix +	"ttl_trf_amt".trim(),	length));
				String[] creDt =	(JSPUtil.getParameter(request, prefix +	"cre_dt".trim(),	length));
				String[] hirDtAmt =	(JSPUtil.getParameter(request, prefix +	"hir_dt_amt".trim(),	length));
				String[] estimatedCost =	(JSPUtil.getParameter(request, prefix +	"estimated_cost".trim(),	length));
				String[] sysName =	(JSPUtil.getParameter(request, prefix +	"sys_name".trim(),	length));
				String[] periodStdt =	(JSPUtil.getParameter(request, prefix +	"period_stdt".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] estBsaQty =	(JSPUtil.getParameter(request, prefix +	"est_bsa_qty".trim(),	length));
				String[] revDirCd =	(JSPUtil.getParameter(request, prefix +	"rev_dir_cd".trim(),	length));
				String[] estQty =	(JSPUtil.getParameter(request, prefix +	"est_qty".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] locCd =	(JSPUtil.getParameter(request, prefix +	"loc_cd".trim(),	length));
				String[] agmtCtyCd =	(JSPUtil.getParameter(request, prefix +	"agmt_cty_cd".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] updDt =	(JSPUtil.getParameter(request, prefix +	"upd_dt".trim(),	length));
				String[] tpSz =	(JSPUtil.getParameter(request, prefix +	"tp_sz".trim(),	length));
				String[] agmtSeq =	(JSPUtil.getParameter(request, prefix +	"agmt_seq".trim(),	length));
				String[] agmtNo =	(JSPUtil.getParameter(request, prefix +	"agmt_no".trim(),	length));
				String[] skdVoyNo =	(JSPUtil.getParameter(request, prefix +	"skd_voy_no".trim(),	length));
				String[] bizUnit =	(JSPUtil.getParameter(request, prefix +	"biz_unit".trim(),	length));
				String[] custSeq =	(JSPUtil.getParameter(request, prefix +	"cust_seq".trim(),	length));
				String[] actualCost =	(JSPUtil.getParameter(request, prefix +	"actual_cost".trim(),	length));
				String[] sltCostAmt =	(JSPUtil.getParameter(request, prefix +	"slt_cost_amt".trim(),	length));
				String[] skdDirCd =	(JSPUtil.getParameter(request, prefix +	"skd_dir_cd".trim(),	length));
				String[] accuralAmt =	(JSPUtil.getParameter(request, prefix +	"accural_amt".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				String[] actualMonth =	(JSPUtil.getParameter(request, prefix +	"actual_month".trim(),	length));
				String[] seq =	(JSPUtil.getParameter(request, prefix +	"seq".trim(),	length));
				String[] revVvd =	(JSPUtil.getParameter(request, prefix +	"rev_vvd".trim(),	length));
				String[] periodEddt =	(JSPUtil.getParameter(request, prefix +	"period_eddt".trim(),	length));
				String[] loclCurrCd =	(JSPUtil.getParameter(request, prefix +	"locl_curr_cd".trim(),	length));
				String[] actDt =	(JSPUtil.getParameter(request, prefix +	"act_dt".trim(),	length));
				String[] actPlcCd =	(JSPUtil.getParameter(request, prefix +	"act_plc_cd".trim(),	length));
				String[] slanCd =	(JSPUtil.getParameter(request, prefix +	"slan_cd".trim(),	length));
				String[] acctDtlCd =	(JSPUtil.getParameter(request, prefix +	"acct_dtl_cd".trim(),	length));
				String[] costActPlcCd =	(JSPUtil.getParameter(request, prefix +	"cost_act_plc_cd".trim(),	length));
				String[] lseCtrtNo =	(JSPUtil.getParameter(request, prefix +	"lse_ctrt_no".trim(),	length));
				String[] vndrSeq =	(JSPUtil.getParameter(request, prefix +	"vndr_seq".trim(),	length));
				String[] vndrLglEngNm =	(JSPUtil.getParameter(request, prefix +	"vndr_lgl_eng_nm".trim(),	length));
				String[] lsePayChgTpCd =	(JSPUtil.getParameter(request, prefix +	"lse_pay_chg_tp_cd".trim(),	length));
				String[] skr_acct_cd =	(JSPUtil.getParameter(request, prefix +	"skr_acct_cd".trim(),	length));
				String[] lstm_cd =	(JSPUtil.getParameter(request, prefix +	"lstm_cd".trim(),	length));
				String[] ifChkFlg =	(JSPUtil.getParameter(request, prefix +	"if_chk_flg".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	EstimatedAuditVO();
						if ( opLseDivFlg[i] !=	null)
						model.setOpLseDivFlg( opLseDivFlg[i]);
						if ( vslCd[i] !=	null)
						model.setVslCd( vslCd[i]);
						if ( acctCode[i] !=	null)
						model.setAcctCode( acctCode[i]);
						if ( revMonth[i] !=	null)
						model.setRevMonth( revMonth[i]);
						if ( ttlTrfAmt[i] !=	null)
						model.setTtlTrfAmt( ttlTrfAmt[i]);
						if ( creDt[i] !=	null)
						model.setCreDt( creDt[i]);
						if ( hirDtAmt[i] !=	null)
						model.setHirDtAmt( hirDtAmt[i]);
						if ( estimatedCost[i] !=	null)
						model.setEstimatedCost( estimatedCost[i]);
						if ( sysName[i] !=	null)
						model.setSysName( sysName[i]);
						if ( periodStdt[i] !=	null)
						model.setPeriodStdt( periodStdt[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( estBsaQty[i] !=	null)
						model.setEstBsaQty( estBsaQty[i]);
						if ( revDirCd[i] !=	null)
						model.setRevDirCd( revDirCd[i]);
						if ( estQty[i] !=	null)
						model.setEstQty( estQty[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( locCd[i] !=	null)
						model.setLocCd( locCd[i]);
						if ( agmtCtyCd[i] !=	null)
						model.setAgmtCtyCd( agmtCtyCd[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( updDt[i] !=	null)
						model.setUpdDt( updDt[i]);
						if ( tpSz[i] !=	null)
						model.setTpSz( tpSz[i]);
						if ( agmtSeq[i] !=	null)
						model.setAgmtSeq( agmtSeq[i]);
						if ( agmtNo[i] !=	null)
						model.setAgmtNo( agmtNo[i]);
						if ( skdVoyNo[i] !=	null)
						model.setSkdVoyNo( skdVoyNo[i]);
						if ( bizUnit[i] !=	null)
						model.setBizUnit( bizUnit[i]);
						if ( custSeq[i] !=	null)
						model.setCustSeq( custSeq[i]);
						if ( actualCost[i] !=	null)
						model.setActualCost( actualCost[i]);
						if ( sltCostAmt[i] !=	null)
						model.setSltCostAmt( sltCostAmt[i]);
						if ( skdDirCd[i] !=	null)
						model.setSkdDirCd( skdDirCd[i]);
						if ( accuralAmt[i] !=	null)
						model.setAccuralAmt( accuralAmt[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
						if ( actualMonth[i] !=	null)
						model.setActualMonth( actualMonth[i]);
						if ( seq[i] !=	null)
						model.setSeq( seq[i]);
						if ( revVvd[i] !=	null)
						model.setRevVvd( revVvd[i]);
						if ( periodEddt[i] !=	null)
						model.setPeriodEddt( periodEddt[i]);
						if ( loclCurrCd[i] !=	null)
						model.setLoclCurrCd( loclCurrCd[i]);
						if ( actDt[i] !=	null)
						model.setActDt( actDt[i]);
						if ( actPlcCd[i] !=	null)
						model.setActPlcCd( actPlcCd[i]);
						if ( slanCd[i] !=	null)
						model.setSlanCd( slanCd[i]);
						if ( acctDtlCd[i] !=	null)
						model.setAcctDtlCd( acctDtlCd[i]);
						if ( costActPlcCd[i] !=	null)
						model.setCostActPlcCd( costActPlcCd[i]);
						if ( lseCtrtNo[i] !=	null)
						model.setLseCtrtNo( lseCtrtNo[i]);
						if ( vndrSeq[i] !=	null)
						model.setVndrSeq( vndrSeq[i]);
						if ( vndrLglEngNm[i] !=	null)
						model.setVndrLglEngNm( vndrLglEngNm[i]);
						if ( lsePayChgTpCd[i] !=	null)
						model.setLsePayChgTpCd( lsePayChgTpCd[i]);
						if ( skr_acct_cd[i] !=	null)
						model.setSkr_acct_cd( skr_acct_cd[i]);
						if ( lstm_cd[i] !=	null)
						model.setLstm_cd( lstm_cd[i]);
						if ( ifChkFlg[i] !=	null)
						model.setIfChkFlg( ifChkFlg[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getEstimatedAuditVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return EstimatedAuditVO[]
	 */
	public EstimatedAuditVO[]	 getEstimatedAuditVOs(){
		EstimatedAuditVO[] vos = (EstimatedAuditVO[])models.toArray(new	EstimatedAuditVO[models.size()]);
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
		this.opLseDivFlg =	this.opLseDivFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd =	this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCode =	this.acctCode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revMonth =	this.revMonth.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlTrfAmt =	this.ttlTrfAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt =	this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hirDtAmt =	this.hirDtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estimatedCost =	this.estimatedCost.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sysName =	this.sysName.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.periodStdt =	this.periodStdt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estBsaQty =	this.estBsaQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revDirCd =	this.revDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estQty =	this.estQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd =	this.locCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCtyCd =	this.agmtCtyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt =	this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpSz =	this.tpSz.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq =	this.agmtSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo =	this.agmtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo =	this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bizUnit =	this.bizUnit.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq =	this.custSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actualCost =	this.actualCost.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sltCostAmt =	this.sltCostAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd =	this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.accuralAmt =	this.accuralAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actualMonth =	this.actualMonth.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq =	this.seq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revVvd =	this.revVvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.periodEddt =	this.periodEddt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCd =	this.loclCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actDt =	this.actDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actPlcCd =	this.actPlcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd =	this.slanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctDtlCd =	this.acctDtlCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costActPlcCd =	this.costActPlcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lseCtrtNo =	this.lseCtrtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq =	this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm =	this.vndrLglEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lsePayChgTpCd =	this.lsePayChgTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skr_acct_cd =	this.skr_acct_cd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstm_cd =	this.lstm_cd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifChkFlg =	this.ifChkFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}