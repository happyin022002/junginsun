/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : FaTargetListVO.java
 *@FileTitle : FaTargetListVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.11.14
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2014.11.14  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo;

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
public class FaTargetListVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<FaTargetListVO>  models =	new	ArrayList<FaTargetListVO>();


	/*	Column Info	*/
	private  String	 cntrAqzAmt   =  null;
	/*	Column Info	*/
	private  String	 cntrSpecNo   =  null;
	/*	Column Info	*/
	private  String	 ieflg   =  null;
	/*	Column Info	*/
	private  String	 creDt   =  null;
	/*	Column Info	*/
	private  String	 lotPlnYr   =  null;
	/*	Column Info	*/
	private  String	 lotSeq   =  null;
	/*	Column Info	*/
	private  String	 ceflg   =  null;
	/*	Column Info	*/
	private  String	 lotLocCd   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 ueflg   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 aeflg   =  null;
	/*	Column Info	*/
	private  String	 hidType   =  null;
	/*	Column Info	*/
	private  String	 agmtCtyCd   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd   =  null;
	/*	Column Info	*/
	private  String	 cntrQty   =  null;
	/*	Column Info	*/
	private  String	 deflg   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 acctQtyMzdCd   =  null;
	/*	Column Info	*/
	private  String	 lotNo   =  null;
	/*	Column Info	*/
	private  String	 agmtSeq   =  null;
	/*	Column Info	*/
	private  String	 faIfGrpSeq   =  null;
	/*	Column Info	*/
	private  String	 agmtNo   =  null;
	/*	Column Info	*/
	private  String	 serRange   =  null;
	/*	Column Info	*/
	private  String	 faIfTpCd   =  null;
	/*	Column Info	*/
	private  String	 deYrmon   =  null;
	/*	Column Info	*/
	private  String	 cntrCurrCd   =  null;
	/*	Column Info	*/
	private  String	 cntrInvstNo   =  null;
	/*	Column Info	*/
	private  String	 faIfGrpStsCd   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;
	/*	Column Info	*/
	private  String	 termCngSeq   =  null;
	/*	Column Info	*/
	private  String	 faIfDt   =  null;
	/*	Column Info	*/
	private  String	 beflg   =  null;
	/*	Column Info	*/
	private  String	 vndrAbbrNm   =  null;
	/*	Column Info	*/
	private  String	 actQty   =  null;
	/*	Column Info	*/
	private  String	 vndrSeq   =  null;
	/*	Column Info	*/
	private  String	 vndrLglEngNm   =  null;
	/*	Column Info	*/
	private  String	 orgAgmtNo   =  null;
	/*	Column Info	*/
	private  String	 orgVndrSeq   =  null;
	/*	Column Info	*/
	private  String	 orgVndrLglEngNm   =  null;
	/*	Column Info	*/
	private  String	 snRng   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public FaTargetListVO(){}

	public FaTargetListVO(String cntrAqzAmt,String cntrSpecNo,String ieflg,String creDt,String lotPlnYr,String lotSeq,String ceflg,String lotLocCd,String pagerows,String ueflg,String ibflag,String aeflg,String hidType,String agmtCtyCd,String cntrTpszCd,String cntrQty,String deflg,String updUsrId,String acctQtyMzdCd,String lotNo,String agmtSeq,String faIfGrpSeq,String agmtNo,String serRange,String faIfTpCd,String deYrmon,String cntrCurrCd,String cntrInvstNo,String faIfGrpStsCd,String creUsrId,String termCngSeq,String faIfDt,String beflg,String vndrAbbrNm,String actQty,String vndrSeq,String vndrLglEngNm,String orgAgmtNo,String orgVndrSeq,String orgVndrLglEngNm,String snRng)	{
		this.cntrAqzAmt  = cntrAqzAmt ;
		this.cntrSpecNo  = cntrSpecNo ;
		this.ieflg  = ieflg ;
		this.creDt  = creDt ;
		this.lotPlnYr  = lotPlnYr ;
		this.lotSeq  = lotSeq ;
		this.ceflg  = ceflg ;
		this.lotLocCd  = lotLocCd ;
		this.pagerows  = pagerows ;
		this.ueflg  = ueflg ;
		this.ibflag  = ibflag ;
		this.aeflg  = aeflg ;
		this.hidType  = hidType ;
		this.agmtCtyCd  = agmtCtyCd ;
		this.cntrTpszCd  = cntrTpszCd ;
		this.cntrQty  = cntrQty ;
		this.deflg  = deflg ;
		this.updUsrId  = updUsrId ;
		this.acctQtyMzdCd  = acctQtyMzdCd ;
		this.lotNo  = lotNo ;
		this.agmtSeq  = agmtSeq ;
		this.faIfGrpSeq  = faIfGrpSeq ;
		this.agmtNo  = agmtNo ;
		this.serRange  = serRange ;
		this.faIfTpCd  = faIfTpCd ;
		this.deYrmon  = deYrmon ;
		this.cntrCurrCd  = cntrCurrCd ;
		this.cntrInvstNo  = cntrInvstNo ;
		this.faIfGrpStsCd  = faIfGrpStsCd ;
		this.creUsrId  = creUsrId ;
		this.termCngSeq  = termCngSeq ;
		this.faIfDt  = faIfDt ;
		this.beflg  = beflg ;
		this.vndrAbbrNm  = vndrAbbrNm ;
		this.actQty  = actQty ;
		this.vndrSeq  = vndrSeq ;
		this.vndrLglEngNm  = vndrLglEngNm ;
		this.orgAgmtNo  = orgAgmtNo ;
		this.orgVndrSeq  = orgVndrSeq ;
		this.orgVndrLglEngNm  = orgVndrLglEngNm ;
		this.snRng  = snRng ;
	}


	/**
	 * �뚯씠釉�而щ읆����옣��媛믪쓣 Hashtable<"column_name", "value">	濡�諛섑솚
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr_aqz_amt", getCntrAqzAmt());		
		this.hashColumns.put("cntr_spec_no", getCntrSpecNo());		
		this.hashColumns.put("ieflg", getIeflg());		
		this.hashColumns.put("cre_dt", getCreDt());		
		this.hashColumns.put("lot_pln_yr", getLotPlnYr());		
		this.hashColumns.put("lot_seq", getLotSeq());		
		this.hashColumns.put("ceflg", getCeflg());		
		this.hashColumns.put("lot_loc_cd", getLotLocCd());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("ueflg", getUeflg());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("aeflg", getAeflg());		
		this.hashColumns.put("hid_type", getHidType());		
		this.hashColumns.put("agmt_cty_cd", getAgmtCtyCd());		
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());		
		this.hashColumns.put("cntr_qty", getCntrQty());		
		this.hashColumns.put("deflg", getDeflg());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("acct_qty_mzd_cd", getAcctQtyMzdCd());		
		this.hashColumns.put("lot_no", getLotNo());		
		this.hashColumns.put("agmt_seq", getAgmtSeq());		
		this.hashColumns.put("fa_if_grp_seq", getFaIfGrpSeq());		
		this.hashColumns.put("agmt_no", getAgmtNo());		
		this.hashColumns.put("ser_range", getSerRange());		
		this.hashColumns.put("fa_if_tp_cd", getFaIfTpCd());		
		this.hashColumns.put("de_yrmon", getDeYrmon());		
		this.hashColumns.put("cntr_curr_cd", getCntrCurrCd());		
		this.hashColumns.put("cntr_invst_no", getCntrInvstNo());		
		this.hashColumns.put("fa_if_grp_sts_cd", getFaIfGrpStsCd());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("term_cng_seq", getTermCngSeq());		
		this.hashColumns.put("fa_if_dt", getFaIfDt());		
		this.hashColumns.put("beflg", getBeflg());		
		this.hashColumns.put("vndr_abbr_nm", getVndrAbbrNm());		
		this.hashColumns.put("act_qty", getActQty());		
		this.hashColumns.put("vndr_seq", getVndrSeq());		
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());		
		this.hashColumns.put("org_agmt_no", getOrgAgmtNo());		
		this.hashColumns.put("org_vndr_seq", getOrgVndrSeq());		
		this.hashColumns.put("org_vndr_lgl_eng_nm", getOrgVndrLglEngNm());		
		this.hashColumns.put("sn_rng", getSnRng());		
		return this.hashColumns;
}

	/**
	 * 而щ읆紐낆뿉	��쓳�섎뒗 硫ㅻ쾭蹂�닔紐낆쓣	��옣�섏뿬 Hashtable<"column_name", "variable"> 濡�諛섑솚
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("cntr_aqz_amt", "cntrAqzAmt");
		this.hashFields.put("cntr_spec_no", "cntrSpecNo");
		this.hashFields.put("ieflg", "ieflg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("lot_pln_yr", "lotPlnYr");
		this.hashFields.put("lot_seq", "lotSeq");
		this.hashFields.put("ceflg", "ceflg");
		this.hashFields.put("lot_loc_cd", "lotLocCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ueflg", "ueflg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("aeflg", "aeflg");
		this.hashFields.put("hid_type", "hidType");
		this.hashFields.put("agmt_cty_cd", "agmtCtyCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("cntr_qty", "cntrQty");
		this.hashFields.put("deflg", "deflg");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("acct_qty_mzd_cd", "acctQtyMzdCd");
		this.hashFields.put("lot_no", "lotNo");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("fa_if_grp_seq", "faIfGrpSeq");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("ser_range", "serRange");
		this.hashFields.put("fa_if_tp_cd", "faIfTpCd");
		this.hashFields.put("de_yrmon", "deYrmon");
		this.hashFields.put("cntr_curr_cd", "cntrCurrCd");
		this.hashFields.put("cntr_invst_no", "cntrInvstNo");
		this.hashFields.put("fa_if_grp_sts_cd", "faIfGrpStsCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("term_cng_seq", "termCngSeq");
		this.hashFields.put("fa_if_dt", "faIfDt");
		this.hashFields.put("beflg", "beflg");
		this.hashFields.put("vndr_abbr_nm", "vndrAbbrNm");
		this.hashFields.put("act_qty", "actQty");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("org_agmt_no", "orgAgmtNo");
		this.hashFields.put("org_vndr_seq", "orgVndrSeq");
		this.hashFields.put("org_vndr_lgl_eng_nm", "orgVndrLglEngNm");
		this.hashFields.put("sn_rng", "snRng");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  cntrAqzAmt
	*/
	public void	setCntrAqzAmt( String	cntrAqzAmt ) {
		this.cntrAqzAmt =	cntrAqzAmt;
	}
 
	/**
	 * Column Info
	 * @return	cntrAqzAmt
	 */
	 public	 String	getCntrAqzAmt() {
		 return	this.cntrAqzAmt;
	 } 
 	/**
	* Column Info
	* @param  cntrSpecNo
	*/
	public void	setCntrSpecNo( String	cntrSpecNo ) {
		this.cntrSpecNo =	cntrSpecNo;
	}
 
	/**
	 * Column Info
	 * @return	cntrSpecNo
	 */
	 public	 String	getCntrSpecNo() {
		 return	this.cntrSpecNo;
	 } 
 	/**
	* Column Info
	* @param  ieflg
	*/
	public void	setIeflg( String	ieflg ) {
		this.ieflg =	ieflg;
	}
 
	/**
	 * Column Info
	 * @return	ieflg
	 */
	 public	 String	getIeflg() {
		 return	this.ieflg;
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
	* @param  lotPlnYr
	*/
	public void	setLotPlnYr( String	lotPlnYr ) {
		this.lotPlnYr =	lotPlnYr;
	}
 
	/**
	 * Column Info
	 * @return	lotPlnYr
	 */
	 public	 String	getLotPlnYr() {
		 return	this.lotPlnYr;
	 } 
 	/**
	* Column Info
	* @param  lotSeq
	*/
	public void	setLotSeq( String	lotSeq ) {
		this.lotSeq =	lotSeq;
	}
 
	/**
	 * Column Info
	 * @return	lotSeq
	 */
	 public	 String	getLotSeq() {
		 return	this.lotSeq;
	 } 
 	/**
	* Column Info
	* @param  ceflg
	*/
	public void	setCeflg( String	ceflg ) {
		this.ceflg =	ceflg;
	}
 
	/**
	 * Column Info
	 * @return	ceflg
	 */
	 public	 String	getCeflg() {
		 return	this.ceflg;
	 } 
 	/**
	* Column Info
	* @param  lotLocCd
	*/
	public void	setLotLocCd( String	lotLocCd ) {
		this.lotLocCd =	lotLocCd;
	}
 
	/**
	 * Column Info
	 * @return	lotLocCd
	 */
	 public	 String	getLotLocCd() {
		 return	this.lotLocCd;
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
	* @param  ueflg
	*/
	public void	setUeflg( String	ueflg ) {
		this.ueflg =	ueflg;
	}
 
	/**
	 * Column Info
	 * @return	ueflg
	 */
	 public	 String	getUeflg() {
		 return	this.ueflg;
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
	* @param  aeflg
	*/
	public void	setAeflg( String	aeflg ) {
		this.aeflg =	aeflg;
	}
 
	/**
	 * Column Info
	 * @return	aeflg
	 */
	 public	 String	getAeflg() {
		 return	this.aeflg;
	 } 
 	/**
	* Column Info
	* @param  hidType
	*/
	public void	setHidType( String	hidType ) {
		this.hidType =	hidType;
	}
 
	/**
	 * Column Info
	 * @return	hidType
	 */
	 public	 String	getHidType() {
		 return	this.hidType;
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
	* @param  cntrQty
	*/
	public void	setCntrQty( String	cntrQty ) {
		this.cntrQty =	cntrQty;
	}
 
	/**
	 * Column Info
	 * @return	cntrQty
	 */
	 public	 String	getCntrQty() {
		 return	this.cntrQty;
	 } 
 	/**
	* Column Info
	* @param  deflg
	*/
	public void	setDeflg( String	deflg ) {
		this.deflg =	deflg;
	}
 
	/**
	 * Column Info
	 * @return	deflg
	 */
	 public	 String	getDeflg() {
		 return	this.deflg;
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
	* @param  acctQtyMzdCd
	*/
	public void	setAcctQtyMzdCd( String	acctQtyMzdCd ) {
		this.acctQtyMzdCd =	acctQtyMzdCd;
	}
 
	/**
	 * Column Info
	 * @return	acctQtyMzdCd
	 */
	 public	 String	getAcctQtyMzdCd() {
		 return	this.acctQtyMzdCd;
	 } 
 	/**
	* Column Info
	* @param  lotNo
	*/
	public void	setLotNo( String	lotNo ) {
		this.lotNo =	lotNo;
	}
 
	/**
	 * Column Info
	 * @return	lotNo
	 */
	 public	 String	getLotNo() {
		 return	this.lotNo;
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
	* @param  faIfGrpSeq
	*/
	public void	setFaIfGrpSeq( String	faIfGrpSeq ) {
		this.faIfGrpSeq =	faIfGrpSeq;
	}
 
	/**
	 * Column Info
	 * @return	faIfGrpSeq
	 */
	 public	 String	getFaIfGrpSeq() {
		 return	this.faIfGrpSeq;
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
	* @param  serRange
	*/
	public void	setSerRange( String	serRange ) {
		this.serRange =	serRange;
	}
 
	/**
	 * Column Info
	 * @return	serRange
	 */
	 public	 String	getSerRange() {
		 return	this.serRange;
	 } 
 	/**
	* Column Info
	* @param  faIfTpCd
	*/
	public void	setFaIfTpCd( String	faIfTpCd ) {
		this.faIfTpCd =	faIfTpCd;
	}
 
	/**
	 * Column Info
	 * @return	faIfTpCd
	 */
	 public	 String	getFaIfTpCd() {
		 return	this.faIfTpCd;
	 } 
 	/**
	* Column Info
	* @param  deYrmon
	*/
	public void	setDeYrmon( String	deYrmon ) {
		this.deYrmon =	deYrmon;
	}
 
	/**
	 * Column Info
	 * @return	deYrmon
	 */
	 public	 String	getDeYrmon() {
		 return	this.deYrmon;
	 } 
 	/**
	* Column Info
	* @param  cntrCurrCd
	*/
	public void	setCntrCurrCd( String	cntrCurrCd ) {
		this.cntrCurrCd =	cntrCurrCd;
	}
 
	/**
	 * Column Info
	 * @return	cntrCurrCd
	 */
	 public	 String	getCntrCurrCd() {
		 return	this.cntrCurrCd;
	 } 
 	/**
	* Column Info
	* @param  cntrInvstNo
	*/
	public void	setCntrInvstNo( String	cntrInvstNo ) {
		this.cntrInvstNo =	cntrInvstNo;
	}
 
	/**
	 * Column Info
	 * @return	cntrInvstNo
	 */
	 public	 String	getCntrInvstNo() {
		 return	this.cntrInvstNo;
	 } 
 	/**
	* Column Info
	* @param  faIfGrpStsCd
	*/
	public void	setFaIfGrpStsCd( String	faIfGrpStsCd ) {
		this.faIfGrpStsCd =	faIfGrpStsCd;
	}
 
	/**
	 * Column Info
	 * @return	faIfGrpStsCd
	 */
	 public	 String	getFaIfGrpStsCd() {
		 return	this.faIfGrpStsCd;
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
	* @param  termCngSeq
	*/
	public void	setTermCngSeq( String	termCngSeq ) {
		this.termCngSeq =	termCngSeq;
	}
 
	/**
	 * Column Info
	 * @return	termCngSeq
	 */
	 public	 String	getTermCngSeq() {
		 return	this.termCngSeq;
	 } 
 	/**
	* Column Info
	* @param  faIfDt
	*/
	public void	setFaIfDt( String	faIfDt ) {
		this.faIfDt =	faIfDt;
	}
 
	/**
	 * Column Info
	 * @return	faIfDt
	 */
	 public	 String	getFaIfDt() {
		 return	this.faIfDt;
	 } 
 	/**
	* Column Info
	* @param  beflg
	*/
	public void	setBeflg( String	beflg ) {
		this.beflg =	beflg;
	}
 
	/**
	 * Column Info
	 * @return	beflg
	 */
	 public	 String	getBeflg() {
		 return	this.beflg;
	 } 
 	/**
	* Column Info
	* @param  vndrAbbrNm
	*/
	public void	setVndrAbbrNm( String	vndrAbbrNm ) {
		this.vndrAbbrNm =	vndrAbbrNm;
	}
 
	/**
	 * Column Info
	 * @return	vndrAbbrNm
	 */
	 public	 String	getVndrAbbrNm() {
		 return	this.vndrAbbrNm;
	 } 
 	/**
	* Column Info
	* @param  actQty
	*/
	public void	setActQty( String	actQty ) {
		this.actQty =	actQty;
	}
 
	/**
	 * Column Info
	 * @return	actQty
	 */
	 public	 String	getActQty() {
		 return	this.actQty;
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
	* @param  orgAgmtNo
	*/
	public void	setOrgAgmtNo( String	orgAgmtNo ) {
		this.orgAgmtNo =	orgAgmtNo;
	}
 
	/**
	 * Column Info
	 * @return	orgAgmtNo
	 */
	 public	 String	getOrgAgmtNo() {
		 return	this.orgAgmtNo;
	 } 
 	/**
	* Column Info
	* @param  orgVndrSeq
	*/
	public void	setOrgVndrSeq( String	orgVndrSeq ) {
		this.orgVndrSeq =	orgVndrSeq;
	}
 
	/**
	 * Column Info
	 * @return	orgVndrSeq
	 */
	 public	 String	getOrgVndrSeq() {
		 return	this.orgVndrSeq;
	 } 
 	/**
	* Column Info
	* @param  orgVndrLglEngNm
	*/
	public void	setOrgVndrLglEngNm( String	orgVndrLglEngNm ) {
		this.orgVndrLglEngNm =	orgVndrLglEngNm;
	}
 
	/**
	 * Column Info
	 * @return	orgVndrLglEngNm
	 */
	 public	 String	getOrgVndrLglEngNm() {
		 return	this.orgVndrLglEngNm;
	 } 
 	/**
	* Column Info
	* @param  snRng
	*/
	public void	setSnRng( String	snRng ) {
		this.snRng =	snRng;
	}
 
	/**
	 * Column Info
	 * @return	snRng
	 */
	 public	 String	getSnRng() {
		 return	this.snRng;
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
		setCntrAqzAmt(JSPUtil.getParameter(request,	prefix + "cntr_aqz_amt", ""));
		setCntrSpecNo(JSPUtil.getParameter(request,	prefix + "cntr_spec_no", ""));
		setIeflg(JSPUtil.getParameter(request,	prefix + "ieflg", ""));
		setCreDt(JSPUtil.getParameter(request,	prefix + "cre_dt", ""));
		setLotPlnYr(JSPUtil.getParameter(request,	prefix + "lot_pln_yr", ""));
		setLotSeq(JSPUtil.getParameter(request,	prefix + "lot_seq", ""));
		setCeflg(JSPUtil.getParameter(request,	prefix + "ceflg", ""));
		setLotLocCd(JSPUtil.getParameter(request,	prefix + "lot_loc_cd", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setUeflg(JSPUtil.getParameter(request,	prefix + "ueflg", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setAeflg(JSPUtil.getParameter(request,	prefix + "aeflg", ""));
		setHidType(JSPUtil.getParameter(request,	prefix + "hid_type", ""));
		setAgmtCtyCd(JSPUtil.getParameter(request,	prefix + "agmt_cty_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd", ""));
		setCntrQty(JSPUtil.getParameter(request,	prefix + "cntr_qty", ""));
		setDeflg(JSPUtil.getParameter(request,	prefix + "deflg", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setAcctQtyMzdCd(JSPUtil.getParameter(request,	prefix + "acct_qty_mzd_cd", ""));
		setLotNo(JSPUtil.getParameter(request,	prefix + "lot_no", ""));
		setAgmtSeq(JSPUtil.getParameter(request,	prefix + "agmt_seq", ""));
		setFaIfGrpSeq(JSPUtil.getParameter(request,	prefix + "fa_if_grp_seq", ""));
		setAgmtNo(JSPUtil.getParameter(request,	prefix + "agmt_no", ""));
		setSerRange(JSPUtil.getParameter(request,	prefix + "ser_range", ""));
		setFaIfTpCd(JSPUtil.getParameter(request,	prefix + "fa_if_tp_cd", ""));
		setDeYrmon(JSPUtil.getParameter(request,	prefix + "de_yrmon", ""));
		setCntrCurrCd(JSPUtil.getParameter(request,	prefix + "cntr_curr_cd", ""));
		setCntrInvstNo(JSPUtil.getParameter(request,	prefix + "cntr_invst_no", ""));
		setFaIfGrpStsCd(JSPUtil.getParameter(request,	prefix + "fa_if_grp_sts_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setTermCngSeq(JSPUtil.getParameter(request,	prefix + "term_cng_seq", ""));
		setFaIfDt(JSPUtil.getParameter(request,	prefix + "fa_if_dt", ""));
		setBeflg(JSPUtil.getParameter(request,	prefix + "beflg", ""));
		setVndrAbbrNm(JSPUtil.getParameter(request,	prefix + "vndr_abbr_nm", ""));
		setActQty(JSPUtil.getParameter(request,	prefix + "act_qty", ""));
		setVndrSeq(JSPUtil.getParameter(request,	prefix + "vndr_seq", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request,	prefix + "vndr_lgl_eng_nm", ""));
		setOrgAgmtNo(JSPUtil.getParameter(request,	prefix + "org_agmt_no", ""));
		setOrgVndrSeq(JSPUtil.getParameter(request,	prefix + "org_vndr_seq", ""));
		setOrgVndrLglEngNm(JSPUtil.getParameter(request,	prefix + "org_vndr_lgl_eng_nm", ""));
		setSnRng(JSPUtil.getParameter(request,	prefix + "sn_rng", ""));
	}
	
	/**
	 * Request ���곗씠�곕� VO 諛곗뿴濡�蹂�솚�섏뿬 諛섑솚.
	 * @param request
	 * @return FaTargetListVO[]
	 */
	public FaTargetListVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request �섏뼱���щ윭 嫄�DATA瑜�VO Class ���대뒗��
	 * @param request
	 * @param prefix
	 * @return FaTargetListVO[]
	 */
	public FaTargetListVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		FaTargetListVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] cntrAqzAmt =	(JSPUtil.getParameter(request, prefix +	"cntr_aqz_amt".trim(),	length));
				String[] cntrSpecNo =	(JSPUtil.getParameter(request, prefix +	"cntr_spec_no".trim(),	length));
				String[] ieflg =	(JSPUtil.getParameter(request, prefix +	"ieflg".trim(),	length));
				String[] creDt =	(JSPUtil.getParameter(request, prefix +	"cre_dt".trim(),	length));
				String[] lotPlnYr =	(JSPUtil.getParameter(request, prefix +	"lot_pln_yr".trim(),	length));
				String[] lotSeq =	(JSPUtil.getParameter(request, prefix +	"lot_seq".trim(),	length));
				String[] ceflg =	(JSPUtil.getParameter(request, prefix +	"ceflg".trim(),	length));
				String[] lotLocCd =	(JSPUtil.getParameter(request, prefix +	"lot_loc_cd".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] ueflg =	(JSPUtil.getParameter(request, prefix +	"ueflg".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] aeflg =	(JSPUtil.getParameter(request, prefix +	"aeflg".trim(),	length));
				String[] hidType =	(JSPUtil.getParameter(request, prefix +	"hid_type".trim(),	length));
				String[] agmtCtyCd =	(JSPUtil.getParameter(request, prefix +	"agmt_cty_cd".trim(),	length));
				String[] cntrTpszCd =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd".trim(),	length));
				String[] cntrQty =	(JSPUtil.getParameter(request, prefix +	"cntr_qty".trim(),	length));
				String[] deflg =	(JSPUtil.getParameter(request, prefix +	"deflg".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] acctQtyMzdCd =	(JSPUtil.getParameter(request, prefix +	"acct_qty_mzd_cd".trim(),	length));
				String[] lotNo =	(JSPUtil.getParameter(request, prefix +	"lot_no".trim(),	length));
				String[] agmtSeq =	(JSPUtil.getParameter(request, prefix +	"agmt_seq".trim(),	length));
				String[] faIfGrpSeq =	(JSPUtil.getParameter(request, prefix +	"fa_if_grp_seq".trim(),	length));
				String[] agmtNo =	(JSPUtil.getParameter(request, prefix +	"agmt_no".trim(),	length));
				String[] serRange =	(JSPUtil.getParameter(request, prefix +	"ser_range".trim(),	length));
				String[] faIfTpCd =	(JSPUtil.getParameter(request, prefix +	"fa_if_tp_cd".trim(),	length));
				String[] deYrmon =	(JSPUtil.getParameter(request, prefix +	"de_yrmon".trim(),	length));
				String[] cntrCurrCd =	(JSPUtil.getParameter(request, prefix +	"cntr_curr_cd".trim(),	length));
				String[] cntrInvstNo =	(JSPUtil.getParameter(request, prefix +	"cntr_invst_no".trim(),	length));
				String[] faIfGrpStsCd =	(JSPUtil.getParameter(request, prefix +	"fa_if_grp_sts_cd".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				String[] termCngSeq =	(JSPUtil.getParameter(request, prefix +	"term_cng_seq".trim(),	length));
				String[] faIfDt =	(JSPUtil.getParameter(request, prefix +	"fa_if_dt".trim(),	length));
				String[] beflg =	(JSPUtil.getParameter(request, prefix +	"beflg".trim(),	length));
				String[] vndrAbbrNm =	(JSPUtil.getParameter(request, prefix +	"vndr_abbr_nm".trim(),	length));
				String[] actQty =	(JSPUtil.getParameter(request, prefix +	"act_qty".trim(),	length));
				String[] vndrSeq =	(JSPUtil.getParameter(request, prefix +	"vndr_seq".trim(),	length));
				String[] vndrLglEngNm =	(JSPUtil.getParameter(request, prefix +	"vndr_lgl_eng_nm".trim(),	length));
				String[] orgAgmtNo =	(JSPUtil.getParameter(request, prefix +	"org_agmt_no".trim(),	length));
				String[] orgVndrSeq =	(JSPUtil.getParameter(request, prefix +	"org_vndr_seq".trim(),	length));
				String[] orgVndrLglEngNm =	(JSPUtil.getParameter(request, prefix +	"org_vndr_lgl_eng_nm".trim(),	length));
				String[] snRng =	(JSPUtil.getParameter(request, prefix +	"sn_rng".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	FaTargetListVO();
						if ( cntrAqzAmt[i] !=	null)
						model.setCntrAqzAmt( cntrAqzAmt[i]);
						if ( cntrSpecNo[i] !=	null)
						model.setCntrSpecNo( cntrSpecNo[i]);
						if ( ieflg[i] !=	null)
						model.setIeflg( ieflg[i]);
						if ( creDt[i] !=	null)
						model.setCreDt( creDt[i]);
						if ( lotPlnYr[i] !=	null)
						model.setLotPlnYr( lotPlnYr[i]);
						if ( lotSeq[i] !=	null)
						model.setLotSeq( lotSeq[i]);
						if ( ceflg[i] !=	null)
						model.setCeflg( ceflg[i]);
						if ( lotLocCd[i] !=	null)
						model.setLotLocCd( lotLocCd[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( ueflg[i] !=	null)
						model.setUeflg( ueflg[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( aeflg[i] !=	null)
						model.setAeflg( aeflg[i]);
						if ( hidType[i] !=	null)
						model.setHidType( hidType[i]);
						if ( agmtCtyCd[i] !=	null)
						model.setAgmtCtyCd( agmtCtyCd[i]);
						if ( cntrTpszCd[i] !=	null)
						model.setCntrTpszCd( cntrTpszCd[i]);
						if ( cntrQty[i] !=	null)
						model.setCntrQty( cntrQty[i]);
						if ( deflg[i] !=	null)
						model.setDeflg( deflg[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( acctQtyMzdCd[i] !=	null)
						model.setAcctQtyMzdCd( acctQtyMzdCd[i]);
						if ( lotNo[i] !=	null)
						model.setLotNo( lotNo[i]);
						if ( agmtSeq[i] !=	null)
						model.setAgmtSeq( agmtSeq[i]);
						if ( faIfGrpSeq[i] !=	null)
						model.setFaIfGrpSeq( faIfGrpSeq[i]);
						if ( agmtNo[i] !=	null)
						model.setAgmtNo( agmtNo[i]);
						if ( serRange[i] !=	null)
						model.setSerRange( serRange[i]);
						if ( faIfTpCd[i] !=	null)
						model.setFaIfTpCd( faIfTpCd[i]);
						if ( deYrmon[i] !=	null)
						model.setDeYrmon( deYrmon[i]);
						if ( cntrCurrCd[i] !=	null)
						model.setCntrCurrCd( cntrCurrCd[i]);
						if ( cntrInvstNo[i] !=	null)
						model.setCntrInvstNo( cntrInvstNo[i]);
						if ( faIfGrpStsCd[i] !=	null)
						model.setFaIfGrpStsCd( faIfGrpStsCd[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
						if ( termCngSeq[i] !=	null)
						model.setTermCngSeq( termCngSeq[i]);
						if ( faIfDt[i] !=	null)
						model.setFaIfDt( faIfDt[i]);
						if ( beflg[i] !=	null)
						model.setBeflg( beflg[i]);
						if ( vndrAbbrNm[i] !=	null)
						model.setVndrAbbrNm( vndrAbbrNm[i]);
						if ( actQty[i] !=	null)
						model.setActQty( actQty[i]);
						if ( vndrSeq[i] !=	null)
						model.setVndrSeq( vndrSeq[i]);
						if ( vndrLglEngNm[i] !=	null)
						model.setVndrLglEngNm( vndrLglEngNm[i]);
						if ( orgAgmtNo[i] !=	null)
						model.setOrgAgmtNo( orgAgmtNo[i]);
						if ( orgVndrSeq[i] !=	null)
						model.setOrgVndrSeq( orgVndrSeq[i]);
						if ( orgVndrLglEngNm[i] !=	null)
						model.setOrgVndrLglEngNm( orgVndrLglEngNm[i]);
						if ( snRng[i] !=	null)
						model.setSnRng( snRng[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getFaTargetListVOs();
	}

	/**
	 *  VO 諛곗뿴��諛섑솚
	 * @return FaTargetListVO[]
	 */
	public FaTargetListVO[]	 getFaTargetListVOs(){
		FaTargetListVO[] vos = (FaTargetListVO[])models.toArray(new	FaTargetListVO[models.size()]);
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
		this.cntrAqzAmt =	this.cntrAqzAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSpecNo =	this.cntrSpecNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ieflg =	this.ieflg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt =	this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lotPlnYr =	this.lotPlnYr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lotSeq =	this.lotSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ceflg =	this.ceflg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lotLocCd =	this.lotLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ueflg =	this.ueflg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aeflg =	this.aeflg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidType =	this.hidType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCtyCd =	this.agmtCtyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd =	this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrQty =	this.cntrQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deflg =	this.deflg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctQtyMzdCd =	this.acctQtyMzdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lotNo =	this.lotNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq =	this.agmtSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faIfGrpSeq =	this.faIfGrpSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo =	this.agmtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.serRange =	this.serRange.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faIfTpCd =	this.faIfTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deYrmon =	this.deYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCurrCd =	this.cntrCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrInvstNo =	this.cntrInvstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faIfGrpStsCd =	this.faIfGrpStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.termCngSeq =	this.termCngSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faIfDt =	this.faIfDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.beflg =	this.beflg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrAbbrNm =	this.vndrAbbrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actQty =	this.actQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq =	this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm =	this.vndrLglEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgAgmtNo =	this.orgAgmtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgVndrSeq =	this.orgVndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgVndrLglEngNm =	this.orgVndrLglEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.snRng =	this.snRng.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}