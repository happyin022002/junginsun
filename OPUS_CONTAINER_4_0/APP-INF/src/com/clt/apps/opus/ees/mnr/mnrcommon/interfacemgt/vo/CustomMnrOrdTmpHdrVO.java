/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : CustomMnrOrdTmpHdrVO.java
 *@FileTitle : CustomMnrOrdTmpHdrVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.11.26
 *@LastModifier : 박광석
 *@LastVersion : 1.0
 * 2014.11.26 박광석 
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo;

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
 * @author 박광석
 * @since J2EE 1.6
 * @see	..
 */
public class CustomMnrOrdTmpHdrVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<CustomMnrOrdTmpHdrVO>  models =	new	ArrayList<CustomMnrOrdTmpHdrVO>();


	/*	Column Info	*/
	private  String	 vslCd   =  null;
	/*	Column Info	*/
	private  String	 currCd   =  null;
	/*	Column Info	*/
	private  String	 mnrGrpTpCd   =  null;
	/*	Column Info	*/
	private  String	 creDt   =  null;
	/*	Column Info	*/
	private  String	 mnrWoTpCd   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 sprPrtBrthDt   =  null;
	/*	Column Info	*/
	private  String	 mnrOrdOfcCtyCd   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 mnrAgmtAmt   =  null;
	/*	Column Info	*/
	private  String	 costCd   =  null;
	/*	Column Info	*/
	private  String	 sprPrtSplDt   =  null;
	/*	Column Info	*/
	private  String	 mnrWrkAmt   =  null;
	/*	Column Info	*/
	private  String	 invAmt   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 updDt   =  null;
	/*	Column Info	*/
	private  String	 costOfcCd   =  null;
	/*	Column Info	*/
	private  String	 agmtSeq   =  null;
	/*	Column Info	*/
	private  String	 agmtNo   =  null;
	/*	Column Info	*/
	private  String	 sprPrtSplTpCd   =  null;
	/*	Column Info	*/
	private  String	 skdVoyNo   =  null;
	/*	Column Info	*/
	private  String	 eqKndCd   =  null;
	/*	Column Info	*/
	private  String	 trsmModCd   =  null;
	/*	Column Info	*/
	private  String	 skdDirCd   =  null;
	/*	Column Info	*/
	private  String	 ordHdrRmk   =  null;
	/*	Column Info	*/
	private  String	 sprPrtSplYdCd   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;
	/*	Column Info	*/
	private  String	 mnrInpDt   =  null;
	/*	Column Info	*/
	private  String	 mnrOrdSeq   =  null;
	/*	Column Info	*/
	private  String	 vndrSeq   =  null;
	/*	Column Info	*/
	private  String	 agmtOfcCtyCd   =  null;
	/*	Column Info	*/
	private  String	 mnrOrdSndDt   =  null;
	/*	Column Info	*/
	private  String	 ordIssOfcCd   =  null;
	/*	Column Info	*/
	private  String	 fileSeq   =  null;
	/*	Column Info	*/
	private  String	 agmtVerNo   =  null;
	/*	Column Info	*/
	private  String	 ifTrcSeq   =  null;
	/*	Column Info	*/
	private  String	 mnrRcvOrdInvTmpSeq   =  null;
	/*	Column Info	*/
	private  String	 invNo   =  null;
	/*	Column Info	*/
	private  String	 vatAmt   =  null;
	/*	Column Info	*/
	private  String	 InvWhldTaxAmt   =  null;
	/*	Column Info	*/
	private  String	 rcvDt   =  null;
	/*	Column Info	*/
	private  String	 invCfmDt   =  null;
	/*	Column Info	*/
	private  String	 vrfyRsltDesc   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public CustomMnrOrdTmpHdrVO(){}

	public CustomMnrOrdTmpHdrVO(String vslCd,String currCd,String mnrGrpTpCd,String creDt,String mnrWoTpCd,String pagerows,String sprPrtBrthDt,String mnrOrdOfcCtyCd,String ibflag,String mnrAgmtAmt,String costCd,String sprPrtSplDt,String mnrWrkAmt,String invAmt,String updUsrId,String updDt,String costOfcCd,String agmtSeq,String agmtNo,String sprPrtSplTpCd,String skdVoyNo,String eqKndCd,String trsmModCd,String skdDirCd,String ordHdrRmk,String sprPrtSplYdCd,String creUsrId,String mnrInpDt,String mnrOrdSeq,String vndrSeq,String agmtOfcCtyCd,String mnrOrdSndDt,String ordIssOfcCd,String fileSeq,String agmtVerNo,String ifTrcSeq,String mnrRcvOrdInvTmpSeq,String invNo,String vatAmt,String InvWhldTaxAmt,String rcvDt,String invCfmDt,String vrfyRsltDesc)	{
		this.vslCd  = vslCd ;
		this.currCd  = currCd ;
		this.mnrGrpTpCd  = mnrGrpTpCd ;
		this.creDt  = creDt ;
		this.mnrWoTpCd  = mnrWoTpCd ;
		this.pagerows  = pagerows ;
		this.sprPrtBrthDt  = sprPrtBrthDt ;
		this.mnrOrdOfcCtyCd  = mnrOrdOfcCtyCd ;
		this.ibflag  = ibflag ;
		this.mnrAgmtAmt  = mnrAgmtAmt ;
		this.costCd  = costCd ;
		this.sprPrtSplDt  = sprPrtSplDt ;
		this.mnrWrkAmt  = mnrWrkAmt ;
		this.invAmt  = invAmt ;
		this.updUsrId  = updUsrId ;
		this.updDt  = updDt ;
		this.costOfcCd  = costOfcCd ;
		this.agmtSeq  = agmtSeq ;
		this.agmtNo  = agmtNo ;
		this.sprPrtSplTpCd  = sprPrtSplTpCd ;
		this.skdVoyNo  = skdVoyNo ;
		this.eqKndCd  = eqKndCd ;
		this.trsmModCd  = trsmModCd ;
		this.skdDirCd  = skdDirCd ;
		this.ordHdrRmk  = ordHdrRmk ;
		this.sprPrtSplYdCd  = sprPrtSplYdCd ;
		this.creUsrId  = creUsrId ;
		this.mnrInpDt  = mnrInpDt ;
		this.mnrOrdSeq  = mnrOrdSeq ;
		this.vndrSeq  = vndrSeq ;
		this.agmtOfcCtyCd  = agmtOfcCtyCd ;
		this.mnrOrdSndDt  = mnrOrdSndDt ;
		this.ordIssOfcCd  = ordIssOfcCd ;
		this.fileSeq  = fileSeq ;
		this.agmtVerNo  = agmtVerNo ;
		this.ifTrcSeq  = ifTrcSeq ;
		this.mnrRcvOrdInvTmpSeq  = mnrRcvOrdInvTmpSeq ;
		this.invNo  = invNo ;
		this.vatAmt  = vatAmt ;
		this.InvWhldTaxAmt  = InvWhldTaxAmt ;
		this.rcvDt  = rcvDt ;
		this.invCfmDt  = invCfmDt ;
		this.vrfyRsltDesc  = vrfyRsltDesc ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());		
		this.hashColumns.put("curr_cd", getCurrCd());		
		this.hashColumns.put("mnr_grp_tp_cd", getMnrGrpTpCd());		
		this.hashColumns.put("cre_dt", getCreDt());		
		this.hashColumns.put("mnr_wo_tp_cd", getMnrWoTpCd());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("spr_prt_brth_dt", getSprPrtBrthDt());		
		this.hashColumns.put("mnr_ord_ofc_cty_cd", getMnrOrdOfcCtyCd());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("mnr_agmt_amt", getMnrAgmtAmt());		
		this.hashColumns.put("cost_cd", getCostCd());		
		this.hashColumns.put("spr_prt_spl_dt", getSprPrtSplDt());		
		this.hashColumns.put("mnr_wrk_amt", getMnrWrkAmt());		
		this.hashColumns.put("inv_amt", getInvAmt());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("upd_dt", getUpdDt());		
		this.hashColumns.put("cost_ofc_cd", getCostOfcCd());		
		this.hashColumns.put("agmt_seq", getAgmtSeq());		
		this.hashColumns.put("agmt_no", getAgmtNo());		
		this.hashColumns.put("spr_prt_spl_tp_cd", getSprPrtSplTpCd());		
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());		
		this.hashColumns.put("eq_knd_cd", getEqKndCd());		
		this.hashColumns.put("trsm_mod_cd", getTrsmModCd());		
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());		
		this.hashColumns.put("ord_hdr_rmk", getOrdHdrRmk());		
		this.hashColumns.put("spr_prt_spl_yd_cd", getSprPrtSplYdCd());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("mnr_inp_dt", getMnrInpDt());		
		this.hashColumns.put("mnr_ord_seq", getMnrOrdSeq());		
		this.hashColumns.put("vndr_seq", getVndrSeq());		
		this.hashColumns.put("agmt_ofc_cty_cd", getAgmtOfcCtyCd());		
		this.hashColumns.put("mnr_ord_snd_dt", getMnrOrdSndDt());		
		this.hashColumns.put("ord_iss_ofc_cd", getOrdIssOfcCd());		
		this.hashColumns.put("file_seq", getFileSeq());		
		this.hashColumns.put("agmt_ver_no", getAgmtVerNo());		
		this.hashColumns.put("if_trc_seq", getIfTrcSeq());		
		this.hashColumns.put("mnr_rcv_ord_inv_tmp_seq", getMnrRcvOrdInvTmpSeq());		
		this.hashColumns.put("inv_no", getInvNo());		
		this.hashColumns.put("vat_amt", getVatAmt());		
		this.hashColumns.put("inv_whld_tax_amt", getInvWhldTaxAmt());		
		this.hashColumns.put("rcv_dt", getRcvDt());		
		this.hashColumns.put("inv_cfm_dt", getInvCfmDt());		
		this.hashColumns.put("vrfy_rslt_desc", getVrfyRsltDesc());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("mnr_grp_tp_cd", "mnrGrpTpCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("mnr_wo_tp_cd", "mnrWoTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("spr_prt_brth_dt", "sprPrtBrthDt");
		this.hashFields.put("mnr_ord_ofc_cty_cd", "mnrOrdOfcCtyCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mnr_agmt_amt", "mnrAgmtAmt");
		this.hashFields.put("cost_cd", "costCd");
		this.hashFields.put("spr_prt_spl_dt", "sprPrtSplDt");
		this.hashFields.put("mnr_wrk_amt", "mnrWrkAmt");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cost_ofc_cd", "costOfcCd");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("spr_prt_spl_tp_cd", "sprPrtSplTpCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("trsm_mod_cd", "trsmModCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("ord_hdr_rmk", "ordHdrRmk");
		this.hashFields.put("spr_prt_spl_yd_cd", "sprPrtSplYdCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("mnr_inp_dt", "mnrInpDt");
		this.hashFields.put("mnr_ord_seq", "mnrOrdSeq");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("agmt_ofc_cty_cd", "agmtOfcCtyCd");
		this.hashFields.put("mnr_ord_snd_dt", "mnrOrdSndDt");
		this.hashFields.put("ord_iss_ofc_cd", "ordIssOfcCd");
		this.hashFields.put("file_seq", "fileSeq");
		this.hashFields.put("agmt_ver_no", "agmtVerNo");
		this.hashFields.put("if_trc_seq", "ifTrcSeq");
		this.hashFields.put("mnr_rcv_ord_inv_tmp_seq", "mnrRcvOrdInvTmpSeq");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("vat_amt", "vatAmt");
		this.hashFields.put("inv_whld_tax_amt", "InvWhldTaxAmt");
		this.hashFields.put("rcv_dt", "rcvDt");
		this.hashFields.put("inv_cfm_dt", "invCfmDt");
		this.hashFields.put("vrfy_rslt_desc", "vrfyRsltDesc");
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
	* @param  mnrGrpTpCd
	*/
	public void	setMnrGrpTpCd( String	mnrGrpTpCd ) {
		this.mnrGrpTpCd =	mnrGrpTpCd;
	}
 
	/**
	 * Column Info
	 * @return	mnrGrpTpCd
	 */
	 public	 String	getMnrGrpTpCd() {
		 return	this.mnrGrpTpCd;
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
	* @param  mnrWoTpCd
	*/
	public void	setMnrWoTpCd( String	mnrWoTpCd ) {
		this.mnrWoTpCd =	mnrWoTpCd;
	}
 
	/**
	 * Column Info
	 * @return	mnrWoTpCd
	 */
	 public	 String	getMnrWoTpCd() {
		 return	this.mnrWoTpCd;
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
	* @param  sprPrtBrthDt
	*/
	public void	setSprPrtBrthDt( String	sprPrtBrthDt ) {
		this.sprPrtBrthDt =	sprPrtBrthDt;
	}
 
	/**
	 * Column Info
	 * @return	sprPrtBrthDt
	 */
	 public	 String	getSprPrtBrthDt() {
		 return	this.sprPrtBrthDt;
	 } 
 	/**
	* Column Info
	* @param  mnrOrdOfcCtyCd
	*/
	public void	setMnrOrdOfcCtyCd( String	mnrOrdOfcCtyCd ) {
		this.mnrOrdOfcCtyCd =	mnrOrdOfcCtyCd;
	}
 
	/**
	 * Column Info
	 * @return	mnrOrdOfcCtyCd
	 */
	 public	 String	getMnrOrdOfcCtyCd() {
		 return	this.mnrOrdOfcCtyCd;
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
	* @param  mnrAgmtAmt
	*/
	public void	setMnrAgmtAmt( String	mnrAgmtAmt ) {
		this.mnrAgmtAmt =	mnrAgmtAmt;
	}
 
	/**
	 * Column Info
	 * @return	mnrAgmtAmt
	 */
	 public	 String	getMnrAgmtAmt() {
		 return	this.mnrAgmtAmt;
	 } 
 	/**
	* Column Info
	* @param  costCd
	*/
	public void	setCostCd( String	costCd ) {
		this.costCd =	costCd;
	}
 
	/**
	 * Column Info
	 * @return	costCd
	 */
	 public	 String	getCostCd() {
		 return	this.costCd;
	 } 
 	/**
	* Column Info
	* @param  sprPrtSplDt
	*/
	public void	setSprPrtSplDt( String	sprPrtSplDt ) {
		this.sprPrtSplDt =	sprPrtSplDt;
	}
 
	/**
	 * Column Info
	 * @return	sprPrtSplDt
	 */
	 public	 String	getSprPrtSplDt() {
		 return	this.sprPrtSplDt;
	 } 
 	/**
	* Column Info
	* @param  mnrWrkAmt
	*/
	public void	setMnrWrkAmt( String	mnrWrkAmt ) {
		this.mnrWrkAmt =	mnrWrkAmt;
	}
 
	/**
	 * Column Info
	 * @return	mnrWrkAmt
	 */
	 public	 String	getMnrWrkAmt() {
		 return	this.mnrWrkAmt;
	 } 
 	/**
	* Column Info
	* @param  invAmt
	*/
	public void	setInvAmt( String	invAmt ) {
		this.invAmt =	invAmt;
	}
 
	/**
	 * Column Info
	 * @return	invAmt
	 */
	 public	 String	getInvAmt() {
		 return	this.invAmt;
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
	* @param  sprPrtSplTpCd
	*/
	public void	setSprPrtSplTpCd( String	sprPrtSplTpCd ) {
		this.sprPrtSplTpCd =	sprPrtSplTpCd;
	}
 
	/**
	 * Column Info
	 * @return	sprPrtSplTpCd
	 */
	 public	 String	getSprPrtSplTpCd() {
		 return	this.sprPrtSplTpCd;
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
	* @param  eqKndCd
	*/
	public void	setEqKndCd( String	eqKndCd ) {
		this.eqKndCd =	eqKndCd;
	}
 
	/**
	 * Column Info
	 * @return	eqKndCd
	 */
	 public	 String	getEqKndCd() {
		 return	this.eqKndCd;
	 } 
 	/**
	* Column Info
	* @param  trsmModCd
	*/
	public void	setTrsmModCd( String	trsmModCd ) {
		this.trsmModCd =	trsmModCd;
	}
 
	/**
	 * Column Info
	 * @return	trsmModCd
	 */
	 public	 String	getTrsmModCd() {
		 return	this.trsmModCd;
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
	* @param  ordHdrRmk
	*/
	public void	setOrdHdrRmk( String	ordHdrRmk ) {
		this.ordHdrRmk =	ordHdrRmk;
	}
 
	/**
	 * Column Info
	 * @return	ordHdrRmk
	 */
	 public	 String	getOrdHdrRmk() {
		 return	this.ordHdrRmk;
	 } 
 	/**
	* Column Info
	* @param  sprPrtSplYdCd
	*/
	public void	setSprPrtSplYdCd( String	sprPrtSplYdCd ) {
		this.sprPrtSplYdCd =	sprPrtSplYdCd;
	}
 
	/**
	 * Column Info
	 * @return	sprPrtSplYdCd
	 */
	 public	 String	getSprPrtSplYdCd() {
		 return	this.sprPrtSplYdCd;
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
	* @param  mnrInpDt
	*/
	public void	setMnrInpDt( String	mnrInpDt ) {
		this.mnrInpDt =	mnrInpDt;
	}
 
	/**
	 * Column Info
	 * @return	mnrInpDt
	 */
	 public	 String	getMnrInpDt() {
		 return	this.mnrInpDt;
	 } 
 	/**
	* Column Info
	* @param  mnrOrdSeq
	*/
	public void	setMnrOrdSeq( String	mnrOrdSeq ) {
		this.mnrOrdSeq =	mnrOrdSeq;
	}
 
	/**
	 * Column Info
	 * @return	mnrOrdSeq
	 */
	 public	 String	getMnrOrdSeq() {
		 return	this.mnrOrdSeq;
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
	* @param  agmtOfcCtyCd
	*/
	public void	setAgmtOfcCtyCd( String	agmtOfcCtyCd ) {
		this.agmtOfcCtyCd =	agmtOfcCtyCd;
	}
 
	/**
	 * Column Info
	 * @return	agmtOfcCtyCd
	 */
	 public	 String	getAgmtOfcCtyCd() {
		 return	this.agmtOfcCtyCd;
	 } 
 	/**
	* Column Info
	* @param  mnrOrdSndDt
	*/
	public void	setMnrOrdSndDt( String	mnrOrdSndDt ) {
		this.mnrOrdSndDt =	mnrOrdSndDt;
	}
 
	/**
	 * Column Info
	 * @return	mnrOrdSndDt
	 */
	 public	 String	getMnrOrdSndDt() {
		 return	this.mnrOrdSndDt;
	 } 
 	/**
	* Column Info
	* @param  ordIssOfcCd
	*/
	public void	setOrdIssOfcCd( String	ordIssOfcCd ) {
		this.ordIssOfcCd =	ordIssOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	ordIssOfcCd
	 */
	 public	 String	getOrdIssOfcCd() {
		 return	this.ordIssOfcCd;
	 } 
 	/**
	* Column Info
	* @param  fileSeq
	*/
	public void	setFileSeq( String	fileSeq ) {
		this.fileSeq =	fileSeq;
	}
 
	/**
	 * Column Info
	 * @return	fileSeq
	 */
	 public	 String	getFileSeq() {
		 return	this.fileSeq;
	 } 
 	/**
	* Column Info
	* @param  agmtVerNo
	*/
	public void	setAgmtVerNo( String	agmtVerNo ) {
		this.agmtVerNo =	agmtVerNo;
	}
 
	/**
	 * Column Info
	 * @return	agmtVerNo
	 */
	 public	 String	getAgmtVerNo() {
		 return	this.agmtVerNo;
	 } 
 	/**
	* Column Info
	* @param  ifTrcSeq
	*/
	public void	setIfTrcSeq( String	ifTrcSeq ) {
		this.ifTrcSeq =	ifTrcSeq;
	}
 
	/**
	 * Column Info
	 * @return	ifTrcSeq
	 */
	 public	 String	getIfTrcSeq() {
		 return	this.ifTrcSeq;
	 } 
 	/**
	* Column Info
	* @param  mnrRcvOrdInvTmpSeq
	*/
	public void	setMnrRcvOrdInvTmpSeq( String	mnrRcvOrdInvTmpSeq ) {
		this.mnrRcvOrdInvTmpSeq =	mnrRcvOrdInvTmpSeq;
	}
 
	/**
	 * Column Info
	 * @return	mnrRcvOrdInvTmpSeq
	 */
	 public	 String	getMnrRcvOrdInvTmpSeq() {
		 return	this.mnrRcvOrdInvTmpSeq;
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
	* @param  vatAmt
	*/
	public void	setVatAmt( String	vatAmt ) {
		this.vatAmt =	vatAmt;
	}
 
	/**
	 * Column Info
	 * @return	vatAmt
	 */
	 public	 String	getVatAmt() {
		 return	this.vatAmt;
	 } 
 	/**
	* Column Info
	* @param  InvWhldTaxAmt
	*/
	public void	setInvWhldTaxAmt( String	InvWhldTaxAmt ) {
		this.InvWhldTaxAmt =	InvWhldTaxAmt;
	}
 
	/**
	 * Column Info
	 * @return	InvWhldTaxAmt
	 */
	 public	 String	getInvWhldTaxAmt() {
		 return	this.InvWhldTaxAmt;
	 } 
 	/**
	* Column Info
	* @param  rcvDt
	*/
	public void	setRcvDt( String	rcvDt ) {
		this.rcvDt =	rcvDt;
	}
 
	/**
	 * Column Info
	 * @return	rcvDt
	 */
	 public	 String	getRcvDt() {
		 return	this.rcvDt;
	 } 
 	/**
	* Column Info
	* @param  invCfmDt
	*/
	public void	setInvCfmDt( String	invCfmDt ) {
		this.invCfmDt =	invCfmDt;
	}
 
	/**
	 * Column Info
	 * @return	invCfmDt
	 */
	 public	 String	getInvCfmDt() {
		 return	this.invCfmDt;
	 } 
 	/**
	* Column Info
	* @param  vrfyRsltDesc
	*/
	public void	setVrfyRsltDesc( String	vrfyRsltDesc ) {
		this.vrfyRsltDesc =	vrfyRsltDesc;
	}
 
	/**
	 * Column Info
	 * @return	vrfyRsltDesc
	 */
	 public	 String	getVrfyRsltDesc() {
		 return	this.vrfyRsltDesc;
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
		setVslCd(JSPUtil.getParameter(request,	prefix + "vsl_cd", ""));
		setCurrCd(JSPUtil.getParameter(request,	prefix + "curr_cd", ""));
		setMnrGrpTpCd(JSPUtil.getParameter(request,	prefix + "mnr_grp_tp_cd", ""));
		setCreDt(JSPUtil.getParameter(request,	prefix + "cre_dt", ""));
		setMnrWoTpCd(JSPUtil.getParameter(request,	prefix + "mnr_wo_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setSprPrtBrthDt(JSPUtil.getParameter(request,	prefix + "spr_prt_brth_dt", ""));
		setMnrOrdOfcCtyCd(JSPUtil.getParameter(request,	prefix + "mnr_ord_ofc_cty_cd", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setMnrAgmtAmt(JSPUtil.getParameter(request,	prefix + "mnr_agmt_amt", ""));
		setCostCd(JSPUtil.getParameter(request,	prefix + "cost_cd", ""));
		setSprPrtSplDt(JSPUtil.getParameter(request,	prefix + "spr_prt_spl_dt", ""));
		setMnrWrkAmt(JSPUtil.getParameter(request,	prefix + "mnr_wrk_amt", ""));
		setInvAmt(JSPUtil.getParameter(request,	prefix + "inv_amt", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request,	prefix + "upd_dt", ""));
		setCostOfcCd(JSPUtil.getParameter(request,	prefix + "cost_ofc_cd", ""));
		setAgmtSeq(JSPUtil.getParameter(request,	prefix + "agmt_seq", ""));
		setAgmtNo(JSPUtil.getParameter(request,	prefix + "agmt_no", ""));
		setSprPrtSplTpCd(JSPUtil.getParameter(request,	prefix + "spr_prt_spl_tp_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request,	prefix + "skd_voy_no", ""));
		setEqKndCd(JSPUtil.getParameter(request,	prefix + "eq_knd_cd", ""));
		setTrsmModCd(JSPUtil.getParameter(request,	prefix + "trsm_mod_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request,	prefix + "skd_dir_cd", ""));
		setOrdHdrRmk(JSPUtil.getParameter(request,	prefix + "ord_hdr_rmk", ""));
		setSprPrtSplYdCd(JSPUtil.getParameter(request,	prefix + "spr_prt_spl_yd_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setMnrInpDt(JSPUtil.getParameter(request,	prefix + "mnr_inp_dt", ""));
		setMnrOrdSeq(JSPUtil.getParameter(request,	prefix + "mnr_ord_seq", ""));
		setVndrSeq(JSPUtil.getParameter(request,	prefix + "vndr_seq", ""));
		setAgmtOfcCtyCd(JSPUtil.getParameter(request,	prefix + "agmt_ofc_cty_cd", ""));
		setMnrOrdSndDt(JSPUtil.getParameter(request,	prefix + "mnr_ord_snd_dt", ""));
		setOrdIssOfcCd(JSPUtil.getParameter(request,	prefix + "ord_iss_ofc_cd", ""));
		setFileSeq(JSPUtil.getParameter(request,	prefix + "file_seq", ""));
		setAgmtVerNo(JSPUtil.getParameter(request,	prefix + "agmt_ver_no", ""));
		setIfTrcSeq(JSPUtil.getParameter(request,	prefix + "if_trc_seq", ""));
		setMnrRcvOrdInvTmpSeq(JSPUtil.getParameter(request,	prefix + "mnr_rcv_ord_inv_tmp_seq", ""));
		setInvNo(JSPUtil.getParameter(request,	prefix + "inv_no", ""));
		setVatAmt(JSPUtil.getParameter(request,	prefix + "vat_amt", ""));
		setInvWhldTaxAmt(JSPUtil.getParameter(request,	prefix + "inv_whld_tax_amt", ""));
		setRcvDt(JSPUtil.getParameter(request,	prefix + "rcv_dt", ""));
		setInvCfmDt(JSPUtil.getParameter(request,	prefix + "inv_cfm_dt", ""));
		setVrfyRsltDesc(JSPUtil.getParameter(request,	prefix + "vrfy_rslt_desc", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomMnrOrdTmpHdrVO[]
	 */
	public CustomMnrOrdTmpHdrVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return CustomMnrOrdTmpHdrVO[]
	 */
	public CustomMnrOrdTmpHdrVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		CustomMnrOrdTmpHdrVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] vslCd =	(JSPUtil.getParameter(request, prefix +	"vsl_cd".trim(),	length));
				String[] currCd =	(JSPUtil.getParameter(request, prefix +	"curr_cd".trim(),	length));
				String[] mnrGrpTpCd =	(JSPUtil.getParameter(request, prefix +	"mnr_grp_tp_cd".trim(),	length));
				String[] creDt =	(JSPUtil.getParameter(request, prefix +	"cre_dt".trim(),	length));
				String[] mnrWoTpCd =	(JSPUtil.getParameter(request, prefix +	"mnr_wo_tp_cd".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] sprPrtBrthDt =	(JSPUtil.getParameter(request, prefix +	"spr_prt_brth_dt".trim(),	length));
				String[] mnrOrdOfcCtyCd =	(JSPUtil.getParameter(request, prefix +	"mnr_ord_ofc_cty_cd".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] mnrAgmtAmt =	(JSPUtil.getParameter(request, prefix +	"mnr_agmt_amt".trim(),	length));
				String[] costCd =	(JSPUtil.getParameter(request, prefix +	"cost_cd".trim(),	length));
				String[] sprPrtSplDt =	(JSPUtil.getParameter(request, prefix +	"spr_prt_spl_dt".trim(),	length));
				String[] mnrWrkAmt =	(JSPUtil.getParameter(request, prefix +	"mnr_wrk_amt".trim(),	length));
				String[] invAmt =	(JSPUtil.getParameter(request, prefix +	"inv_amt".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] updDt =	(JSPUtil.getParameter(request, prefix +	"upd_dt".trim(),	length));
				String[] costOfcCd =	(JSPUtil.getParameter(request, prefix +	"cost_ofc_cd".trim(),	length));
				String[] agmtSeq =	(JSPUtil.getParameter(request, prefix +	"agmt_seq".trim(),	length));
				String[] agmtNo =	(JSPUtil.getParameter(request, prefix +	"agmt_no".trim(),	length));
				String[] sprPrtSplTpCd =	(JSPUtil.getParameter(request, prefix +	"spr_prt_spl_tp_cd".trim(),	length));
				String[] skdVoyNo =	(JSPUtil.getParameter(request, prefix +	"skd_voy_no".trim(),	length));
				String[] eqKndCd =	(JSPUtil.getParameter(request, prefix +	"eq_knd_cd".trim(),	length));
				String[] trsmModCd =	(JSPUtil.getParameter(request, prefix +	"trsm_mod_cd".trim(),	length));
				String[] skdDirCd =	(JSPUtil.getParameter(request, prefix +	"skd_dir_cd".trim(),	length));
				String[] ordHdrRmk =	(JSPUtil.getParameter(request, prefix +	"ord_hdr_rmk".trim(),	length));
				String[] sprPrtSplYdCd =	(JSPUtil.getParameter(request, prefix +	"spr_prt_spl_yd_cd".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				String[] mnrInpDt =	(JSPUtil.getParameter(request, prefix +	"mnr_inp_dt".trim(),	length));
				String[] mnrOrdSeq =	(JSPUtil.getParameter(request, prefix +	"mnr_ord_seq".trim(),	length));
				String[] vndrSeq =	(JSPUtil.getParameter(request, prefix +	"vndr_seq".trim(),	length));
				String[] agmtOfcCtyCd =	(JSPUtil.getParameter(request, prefix +	"agmt_ofc_cty_cd".trim(),	length));
				String[] mnrOrdSndDt =	(JSPUtil.getParameter(request, prefix +	"mnr_ord_snd_dt".trim(),	length));
				String[] ordIssOfcCd =	(JSPUtil.getParameter(request, prefix +	"ord_iss_ofc_cd".trim(),	length));
				String[] fileSeq =	(JSPUtil.getParameter(request, prefix +	"file_seq".trim(),	length));
				String[] agmtVerNo =	(JSPUtil.getParameter(request, prefix +	"agmt_ver_no".trim(),	length));
				String[] ifTrcSeq =	(JSPUtil.getParameter(request, prefix +	"if_trc_seq".trim(),	length));
				String[] mnrRcvOrdInvTmpSeq =	(JSPUtil.getParameter(request, prefix +	"mnr_rcv_ord_inv_tmp_seq".trim(),	length));
				String[] invNo =	(JSPUtil.getParameter(request, prefix +	"inv_no".trim(),	length));
				String[] vatAmt =	(JSPUtil.getParameter(request, prefix +	"vat_amt".trim(),	length));
				String[] InvWhldTaxAmt =	(JSPUtil.getParameter(request, prefix +	"inv_whld_tax_amt".trim(),	length));
				String[] rcvDt =	(JSPUtil.getParameter(request, prefix +	"rcv_dt".trim(),	length));
				String[] invCfmDt =	(JSPUtil.getParameter(request, prefix +	"inv_cfm_dt".trim(),	length));
				String[] vrfyRsltDesc =	(JSPUtil.getParameter(request, prefix +	"vrfy_rslt_desc".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	CustomMnrOrdTmpHdrVO();
						if ( vslCd[i] !=	null)
						model.setVslCd( vslCd[i]);
						if ( currCd[i] !=	null)
						model.setCurrCd( currCd[i]);
						if ( mnrGrpTpCd[i] !=	null)
						model.setMnrGrpTpCd( mnrGrpTpCd[i]);
						if ( creDt[i] !=	null)
						model.setCreDt( creDt[i]);
						if ( mnrWoTpCd[i] !=	null)
						model.setMnrWoTpCd( mnrWoTpCd[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( sprPrtBrthDt[i] !=	null)
						model.setSprPrtBrthDt( sprPrtBrthDt[i]);
						if ( mnrOrdOfcCtyCd[i] !=	null)
						model.setMnrOrdOfcCtyCd( mnrOrdOfcCtyCd[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( mnrAgmtAmt[i] !=	null)
						model.setMnrAgmtAmt( mnrAgmtAmt[i]);
						if ( costCd[i] !=	null)
						model.setCostCd( costCd[i]);
						if ( sprPrtSplDt[i] !=	null)
						model.setSprPrtSplDt( sprPrtSplDt[i]);
						if ( mnrWrkAmt[i] !=	null)
						model.setMnrWrkAmt( mnrWrkAmt[i]);
						if ( invAmt[i] !=	null)
						model.setInvAmt( invAmt[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( updDt[i] !=	null)
						model.setUpdDt( updDt[i]);
						if ( costOfcCd[i] !=	null)
						model.setCostOfcCd( costOfcCd[i]);
						if ( agmtSeq[i] !=	null)
						model.setAgmtSeq( agmtSeq[i]);
						if ( agmtNo[i] !=	null)
						model.setAgmtNo( agmtNo[i]);
						if ( sprPrtSplTpCd[i] !=	null)
						model.setSprPrtSplTpCd( sprPrtSplTpCd[i]);
						if ( skdVoyNo[i] !=	null)
						model.setSkdVoyNo( skdVoyNo[i]);
						if ( eqKndCd[i] !=	null)
						model.setEqKndCd( eqKndCd[i]);
						if ( trsmModCd[i] !=	null)
						model.setTrsmModCd( trsmModCd[i]);
						if ( skdDirCd[i] !=	null)
						model.setSkdDirCd( skdDirCd[i]);
						if ( ordHdrRmk[i] !=	null)
						model.setOrdHdrRmk( ordHdrRmk[i]);
						if ( sprPrtSplYdCd[i] !=	null)
						model.setSprPrtSplYdCd( sprPrtSplYdCd[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
						if ( mnrInpDt[i] !=	null)
						model.setMnrInpDt( mnrInpDt[i]);
						if ( mnrOrdSeq[i] !=	null)
						model.setMnrOrdSeq( mnrOrdSeq[i]);
						if ( vndrSeq[i] !=	null)
						model.setVndrSeq( vndrSeq[i]);
						if ( agmtOfcCtyCd[i] !=	null)
						model.setAgmtOfcCtyCd( agmtOfcCtyCd[i]);
						if ( mnrOrdSndDt[i] !=	null)
						model.setMnrOrdSndDt( mnrOrdSndDt[i]);
						if ( ordIssOfcCd[i] !=	null)
						model.setOrdIssOfcCd( ordIssOfcCd[i]);
						if ( fileSeq[i] !=	null)
						model.setFileSeq( fileSeq[i]);
						if ( agmtVerNo[i] !=	null)
						model.setAgmtVerNo( agmtVerNo[i]);
						if ( ifTrcSeq[i] !=	null)
						model.setIfTrcSeq( ifTrcSeq[i]);
						if ( mnrRcvOrdInvTmpSeq[i] !=	null)
						model.setMnrRcvOrdInvTmpSeq( mnrRcvOrdInvTmpSeq[i]);
						if ( invNo[i] !=	null)
						model.setInvNo( invNo[i]);
						if ( vatAmt[i] !=	null)
						model.setVatAmt( vatAmt[i]);
						if ( InvWhldTaxAmt[i] !=	null)
						model.setInvWhldTaxAmt( InvWhldTaxAmt[i]);
						if ( rcvDt[i] !=	null)
						model.setRcvDt( rcvDt[i]);
						if ( invCfmDt[i] !=	null)
						model.setInvCfmDt( invCfmDt[i]);
						if ( vrfyRsltDesc[i] !=	null)
						model.setVrfyRsltDesc( vrfyRsltDesc[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getCustomMnrOrdTmpHdrVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return CustomMnrOrdTmpHdrVO[]
	 */
	public CustomMnrOrdTmpHdrVO[]	 getCustomMnrOrdTmpHdrVOs(){
		CustomMnrOrdTmpHdrVO[] vos = (CustomMnrOrdTmpHdrVO[])models.toArray(new	CustomMnrOrdTmpHdrVO[models.size()]);
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
		this.vslCd =	this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd =	this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrGrpTpCd =	this.mnrGrpTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt =	this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrWoTpCd =	this.mnrWoTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprPrtBrthDt =	this.sprPrtBrthDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrOrdOfcCtyCd =	this.mnrOrdOfcCtyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrAgmtAmt =	this.mnrAgmtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costCd =	this.costCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprPrtSplDt =	this.sprPrtSplDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrWrkAmt =	this.mnrWrkAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt =	this.invAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt =	this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costOfcCd =	this.costOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq =	this.agmtSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo =	this.agmtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprPrtSplTpCd =	this.sprPrtSplTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo =	this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd =	this.eqKndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsmModCd =	this.trsmModCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd =	this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ordHdrRmk =	this.ordHdrRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprPrtSplYdCd =	this.sprPrtSplYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrInpDt =	this.mnrInpDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrOrdSeq =	this.mnrOrdSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq =	this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtOfcCtyCd =	this.agmtOfcCtyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrOrdSndDt =	this.mnrOrdSndDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ordIssOfcCd =	this.ordIssOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSeq =	this.fileSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtVerNo =	this.agmtVerNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifTrcSeq =	this.ifTrcSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrRcvOrdInvTmpSeq =	this.mnrRcvOrdInvTmpSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo =	this.invNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vatAmt =	this.vatAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.InvWhldTaxAmt =	this.InvWhldTaxAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDt =	this.rcvDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCfmDt =	this.invCfmDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vrfyRsltDesc =	this.vrfyRsltDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}