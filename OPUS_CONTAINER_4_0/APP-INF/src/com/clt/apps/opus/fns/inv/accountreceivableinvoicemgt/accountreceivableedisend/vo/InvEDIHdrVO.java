/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : InvEDIHdrVO.java
 *@FileTitle : InvEDIHdrVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.12.20
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2016.12.20  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo;

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
public class InvEDIHdrVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<InvEDIHdrVO>  models =	new	ArrayList<InvEDIHdrVO>();


	/*	Column Info	*/
	private  String	 porCd   =  null;
	/*	Column Info	*/
	private  String	 vslCd   =  null;
	/*	Column Info	*/
	private  String	 svcScpCd   =  null;
	/*	Column Info	*/
	private  String	 invTtlLoclAmt   =  null;
	/*	Column Info	*/
	private  String	 creDt   =  null;
	/*	Column Info	*/
	private  String	 payCond   =  null;
	/*	Column Info	*/
	private  String	 sailArrDt   =  null;
	/*	Column Info	*/
	private  String	 blNo   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 rfaNo   =  null;
	/*	Column Info	*/
	private  String	 polCd   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 arIfNo   =  null;
	/*	Column Info	*/
	private  String	 scNo   =  null;
	/*	Column Info	*/
	private  String	 actCustCntCd   =  null;
	/*	Column Info	*/
	private  String	 ediHdrSeq   =  null;
	/*	Column Info	*/
	private  String	 ediSndFlg   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 invDt   =  null;
	/*	Column Info	*/
	private  String	 updDt   =  null;
	/*	Column Info	*/
	private  String	 loclCurrCd   =  null;
	/*	Column Info	*/
	private  String	 actCustSeq   =  null;
	/*	Column Info	*/
	private  String	 trnkVvdCd   =  null;
	/*	Column Info	*/
	private  String	 delCd   =  null;
	/*	Column Info	*/
	private  String	 skdVoyNo   =  null;
	/*	Column Info	*/
	private  String	 ioBndCd   =  null;
	/*	Column Info	*/
	private  String	 ediTpCd   =  null;
	/*	Column Info	*/
	private  String	 skdDirCd   =  null;
	/*	Column Info	*/
	private  String	 arOfcCd   =  null;
	/*	Column Info	*/
	private  String	 custCrFlg   =  null;
	/*	Column Info	*/
	private  String	 podCd   =  null;
	/*	Column Info	*/
	private  String	 invNo   =  null;
	/*	Column Info	*/
	private  String	 bkgNo   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;
	/*	Column Info	*/
	private  String	 slanCd   =  null;
	/*	Column Info	*/
	private  String	 blSeq   =  null;
	/*	Column Info	*/
	private  String	 cntrNo   =  null;
	/*	Column Info	*/
	private  String	 bdrIndFlg   =  null;
	/*	Column Info	*/
	private  String	 invDeltDivCd   =  null;
	/*	Column Info	*/
	private  String	 revTpSrcCd   =  null;
	/*	Column Info	*/
	private  String	 ediSndDt   =  null;
	/*	Column Info	*/
	private  String	 ediGrpCd   =  null;
	/*	Column Info	*/
	private  String	 ediReceiverId   =  null;
	/*	Column Info	*/
	private  String	 ediSenderId   =  null;
	/*	Column Info	*/
	private  String	 revTpCd   =  null;
	/*	Column Info	*/
	private  String	 cnmvCycNo   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public InvEDIHdrVO(){}

	public InvEDIHdrVO(String porCd,String vslCd,String svcScpCd,String invTtlLoclAmt,String creDt,String payCond,String sailArrDt,String blNo,String pagerows,String rfaNo,String polCd,String ibflag,String arIfNo,String scNo,String actCustCntCd,String ediHdrSeq,String ediSndFlg,String updUsrId,String invDt,String updDt,String loclCurrCd,String actCustSeq,String trnkVvdCd,String delCd,String skdVoyNo,String ioBndCd,String ediTpCd,String skdDirCd,String arOfcCd,String custCrFlg,String podCd,String invNo,String bkgNo,String creUsrId,String slanCd,String blSeq,String cntrNo,String bdrIndFlg,String invDeltDivCd,String revTpSrcCd,String ediSndDt,String ediGrpCd,String ediReceiverId,String ediSenderId,String revTpCd,String cnmvCycNo)	{
		this.porCd  = porCd ;
		this.vslCd  = vslCd ;
		this.svcScpCd  = svcScpCd ;
		this.invTtlLoclAmt  = invTtlLoclAmt ;
		this.creDt  = creDt ;
		this.payCond  = payCond ;
		this.sailArrDt  = sailArrDt ;
		this.blNo  = blNo ;
		this.pagerows  = pagerows ;
		this.rfaNo  = rfaNo ;
		this.polCd  = polCd ;
		this.ibflag  = ibflag ;
		this.arIfNo  = arIfNo ;
		this.scNo  = scNo ;
		this.actCustCntCd  = actCustCntCd ;
		this.ediHdrSeq  = ediHdrSeq ;
		this.ediSndFlg  = ediSndFlg ;
		this.updUsrId  = updUsrId ;
		this.invDt  = invDt ;
		this.updDt  = updDt ;
		this.loclCurrCd  = loclCurrCd ;
		this.actCustSeq  = actCustSeq ;
		this.trnkVvdCd  = trnkVvdCd ;
		this.delCd  = delCd ;
		this.skdVoyNo  = skdVoyNo ;
		this.ioBndCd  = ioBndCd ;
		this.ediTpCd  = ediTpCd ;
		this.skdDirCd  = skdDirCd ;
		this.arOfcCd  = arOfcCd ;
		this.custCrFlg  = custCrFlg ;
		this.podCd  = podCd ;
		this.invNo  = invNo ;
		this.bkgNo  = bkgNo ;
		this.creUsrId  = creUsrId ;
		this.slanCd  = slanCd ;
		this.blSeq  = blSeq ;
		this.cntrNo  = cntrNo ;
		this.bdrIndFlg  = bdrIndFlg ;
		this.invDeltDivCd  = invDeltDivCd ;
		this.revTpSrcCd  = revTpSrcCd ;
		this.ediSndDt  = ediSndDt ;
		this.ediGrpCd  = ediGrpCd ;
		this.ediReceiverId  = ediReceiverId ;
		this.ediSenderId  = ediSenderId ;
		this.revTpCd  = revTpCd ;
		this.cnmvCycNo  = cnmvCycNo ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());		
		this.hashColumns.put("vsl_cd", getVslCd());		
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());		
		this.hashColumns.put("inv_ttl_locl_amt", getInvTtlLoclAmt());		
		this.hashColumns.put("cre_dt", getCreDt());		
		this.hashColumns.put("pay_cond", getPayCond());		
		this.hashColumns.put("sail_arr_dt", getSailArrDt());		
		this.hashColumns.put("bl_no", getBlNo());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("rfa_no", getRfaNo());		
		this.hashColumns.put("pol_cd", getPolCd());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("ar_if_no", getArIfNo());		
		this.hashColumns.put("sc_no", getScNo());		
		this.hashColumns.put("act_cust_cnt_cd", getActCustCntCd());		
		this.hashColumns.put("edi_hdr_seq", getEdiHdrSeq());		
		this.hashColumns.put("edi_snd_flg", getEdiSndFlg());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("inv_dt", getInvDt());		
		this.hashColumns.put("upd_dt", getUpdDt());		
		this.hashColumns.put("locl_curr_cd", getLoclCurrCd());		
		this.hashColumns.put("act_cust_seq", getActCustSeq());		
		this.hashColumns.put("trnk_vvd_cd", getTrnkVvdCd());		
		this.hashColumns.put("del_cd", getDelCd());		
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());		
		this.hashColumns.put("io_bnd_cd", getIoBndCd());		
		this.hashColumns.put("edi_tp_cd", getEdiTpCd());		
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());		
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());		
		this.hashColumns.put("cust_cr_flg", getCustCrFlg());		
		this.hashColumns.put("pod_cd", getPodCd());		
		this.hashColumns.put("inv_no", getInvNo());		
		this.hashColumns.put("bkg_no", getBkgNo());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("slan_cd", getSlanCd());		
		this.hashColumns.put("bl_seq", getBlSeq());		
		this.hashColumns.put("cntr_no", getCntrNo());		
		this.hashColumns.put("bdr_ind_flg", getBdrIndFlg());		
		this.hashColumns.put("inv_delt_div_cd", getInvDeltDivCd());		
		this.hashColumns.put("rev_tp_src_cd", getRevTpSrcCd());		
		this.hashColumns.put("edi_snd_dt", getEdiSndDt());		
		this.hashColumns.put("edi_grp_cd", getEdiGrpCd());		
		this.hashColumns.put("edi_receiver_id", getEdiReceiverId());		
		this.hashColumns.put("edi_sender_id", getEdiSenderId());		
		this.hashColumns.put("rev_tp_cd", getRevTpCd());		
		this.hashColumns.put("cnmv_cyc_no", getCnmvCycNo());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("inv_ttl_locl_amt", "invTtlLoclAmt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("pay_cond", "payCond");
		this.hashFields.put("sail_arr_dt", "sailArrDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ar_if_no", "arIfNo");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("act_cust_cnt_cd", "actCustCntCd");
		this.hashFields.put("edi_hdr_seq", "ediHdrSeq");
		this.hashFields.put("edi_snd_flg", "ediSndFlg");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("inv_dt", "invDt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("locl_curr_cd", "loclCurrCd");
		this.hashFields.put("act_cust_seq", "actCustSeq");
		this.hashFields.put("trnk_vvd_cd", "trnkVvdCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("edi_tp_cd", "ediTpCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("cust_cr_flg", "custCrFlg");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("bl_seq", "blSeq");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("bdr_ind_flg", "bdrIndFlg");
		this.hashFields.put("inv_delt_div_cd", "invDeltDivCd");
		this.hashFields.put("rev_tp_src_cd", "revTpSrcCd");
		this.hashFields.put("edi_snd_dt", "ediSndDt");
		this.hashFields.put("edi_grp_cd", "ediGrpCd");
		this.hashFields.put("edi_receiver_id", "ediReceiverId");
		this.hashFields.put("edi_sender_id", "ediSenderId");
		this.hashFields.put("rev_tp_cd", "revTpCd");
		this.hashFields.put("cnmv_cyc_no", "cnmvCycNo");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
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
	* @param  invTtlLoclAmt
	*/
	public void	setInvTtlLoclAmt( String	invTtlLoclAmt ) {
		this.invTtlLoclAmt =	invTtlLoclAmt;
	}
 
	/**
	 * Column Info
	 * @return	invTtlLoclAmt
	 */
	 public	 String	getInvTtlLoclAmt() {
		 return	this.invTtlLoclAmt;
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
	* @param  payCond
	*/
	public void	setPayCond( String	payCond ) {
		this.payCond =	payCond;
	}
 
	/**
	 * Column Info
	 * @return	payCond
	 */
	 public	 String	getPayCond() {
		 return	this.payCond;
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
	* @param  rfaNo
	*/
	public void	setRfaNo( String	rfaNo ) {
		this.rfaNo =	rfaNo;
	}
 
	/**
	 * Column Info
	 * @return	rfaNo
	 */
	 public	 String	getRfaNo() {
		 return	this.rfaNo;
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
	* @param  arIfNo
	*/
	public void	setArIfNo( String	arIfNo ) {
		this.arIfNo =	arIfNo;
	}
 
	/**
	 * Column Info
	 * @return	arIfNo
	 */
	 public	 String	getArIfNo() {
		 return	this.arIfNo;
	 } 
 	/**
	* Column Info
	* @param  scNo
	*/
	public void	setScNo( String	scNo ) {
		this.scNo =	scNo;
	}
 
	/**
	 * Column Info
	 * @return	scNo
	 */
	 public	 String	getScNo() {
		 return	this.scNo;
	 } 
 	/**
	* Column Info
	* @param  actCustCntCd
	*/
	public void	setActCustCntCd( String	actCustCntCd ) {
		this.actCustCntCd =	actCustCntCd;
	}
 
	/**
	 * Column Info
	 * @return	actCustCntCd
	 */
	 public	 String	getActCustCntCd() {
		 return	this.actCustCntCd;
	 } 
 	/**
	* Column Info
	* @param  ediHdrSeq
	*/
	public void	setEdiHdrSeq( String	ediHdrSeq ) {
		this.ediHdrSeq =	ediHdrSeq;
	}
 
	/**
	 * Column Info
	 * @return	ediHdrSeq
	 */
	 public	 String	getEdiHdrSeq() {
		 return	this.ediHdrSeq;
	 } 
 	/**
	* Column Info
	* @param  ediSndFlg
	*/
	public void	setEdiSndFlg( String	ediSndFlg ) {
		this.ediSndFlg =	ediSndFlg;
	}
 
	/**
	 * Column Info
	 * @return	ediSndFlg
	 */
	 public	 String	getEdiSndFlg() {
		 return	this.ediSndFlg;
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
	* @param  actCustSeq
	*/
	public void	setActCustSeq( String	actCustSeq ) {
		this.actCustSeq =	actCustSeq;
	}
 
	/**
	 * Column Info
	 * @return	actCustSeq
	 */
	 public	 String	getActCustSeq() {
		 return	this.actCustSeq;
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
	* @param  ediTpCd
	*/
	public void	setEdiTpCd( String	ediTpCd ) {
		this.ediTpCd =	ediTpCd;
	}
 
	/**
	 * Column Info
	 * @return	ediTpCd
	 */
	 public	 String	getEdiTpCd() {
		 return	this.ediTpCd;
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
	* @param  arOfcCd
	*/
	public void	setArOfcCd( String	arOfcCd ) {
		this.arOfcCd =	arOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	arOfcCd
	 */
	 public	 String	getArOfcCd() {
		 return	this.arOfcCd;
	 } 
 	/**
	* Column Info
	* @param  custCrFlg
	*/
	public void	setCustCrFlg( String	custCrFlg ) {
		this.custCrFlg =	custCrFlg;
	}
 
	/**
	 * Column Info
	 * @return	custCrFlg
	 */
	 public	 String	getCustCrFlg() {
		 return	this.custCrFlg;
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
	* @param  blSeq
	*/
	public void	setBlSeq( String	blSeq ) {
		this.blSeq =	blSeq;
	}
 
	/**
	 * Column Info
	 * @return	blSeq
	 */
	 public	 String	getBlSeq() {
		 return	this.blSeq;
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
	* @param  bdrIndFlg
	*/
	public void	setBdrIndFlg( String	bdrIndFlg ) {
		this.bdrIndFlg =	bdrIndFlg;
	}
 
	/**
	 * Column Info
	 * @return	bdrIndFlg
	 */
	 public	 String	getBdrIndFlg() {
		 return	this.bdrIndFlg;
	 } 
 	/**
	* Column Info
	* @param  invDeltDivCd
	*/
	public void	setInvDeltDivCd( String	invDeltDivCd ) {
		this.invDeltDivCd =	invDeltDivCd;
	}
 
	/**
	 * Column Info
	 * @return	invDeltDivCd
	 */
	 public	 String	getInvDeltDivCd() {
		 return	this.invDeltDivCd;
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
	* @param  ediSndDt
	*/
	public void	setEdiSndDt( String	ediSndDt ) {
		this.ediSndDt =	ediSndDt;
	}
 
	/**
	 * Column Info
	 * @return	ediSndDt
	 */
	 public	 String	getEdiSndDt() {
		 return	this.ediSndDt;
	 } 
 	/**
	* Column Info
	* @param  ediGrpCd
	*/
	public void	setEdiGrpCd( String	ediGrpCd ) {
		this.ediGrpCd =	ediGrpCd;
	}
 
	/**
	 * Column Info
	 * @return	ediGrpCd
	 */
	 public	 String	getEdiGrpCd() {
		 return	this.ediGrpCd;
	 } 
 	/**
	* Column Info
	* @param  ediReceiverId
	*/
	public void	setEdiReceiverId( String	ediReceiverId ) {
		this.ediReceiverId =	ediReceiverId;
	}
 
	/**
	 * Column Info
	 * @return	ediReceiverId
	 */
	 public	 String	getEdiReceiverId() {
		 return	this.ediReceiverId;
	 } 
 	/**
	* Column Info
	* @param  ediSenderId
	*/
	public void	setEdiSenderId( String	ediSenderId ) {
		this.ediSenderId =	ediSenderId;
	}
 
	/**
	 * Column Info
	 * @return	ediSenderId
	 */
	 public	 String	getEdiSenderId() {
		 return	this.ediSenderId;
	 } 
 	/**
	* Column Info
	* @param  revTpCd
	*/
	public void	setRevTpCd( String	revTpCd ) {
		this.revTpCd =	revTpCd;
	}
 
	/**
	 * Column Info
	 * @return	revTpCd
	 */
	 public	 String	getRevTpCd() {
		 return	this.revTpCd;
	 } 
 	/**
	* Column Info
	* @param  cnmvCycNo
	*/
	public void	setCnmvCycNo( String	cnmvCycNo ) {
		this.cnmvCycNo =	cnmvCycNo;
	}
 
	/**
	 * Column Info
	 * @return	cnmvCycNo
	 */
	 public	 String	getCnmvCycNo() {
		 return	this.cnmvCycNo;
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
		setPorCd(JSPUtil.getParameter(request,	prefix + "por_cd", ""));
		setVslCd(JSPUtil.getParameter(request,	prefix + "vsl_cd", ""));
		setSvcScpCd(JSPUtil.getParameter(request,	prefix + "svc_scp_cd", ""));
		setInvTtlLoclAmt(JSPUtil.getParameter(request,	prefix + "inv_ttl_locl_amt", ""));
		setCreDt(JSPUtil.getParameter(request,	prefix + "cre_dt", ""));
		setPayCond(JSPUtil.getParameter(request,	prefix + "pay_cond", ""));
		setSailArrDt(JSPUtil.getParameter(request,	prefix + "sail_arr_dt", ""));
		setBlNo(JSPUtil.getParameter(request,	prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setRfaNo(JSPUtil.getParameter(request,	prefix + "rfa_no", ""));
		setPolCd(JSPUtil.getParameter(request,	prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setArIfNo(JSPUtil.getParameter(request,	prefix + "ar_if_no", ""));
		setScNo(JSPUtil.getParameter(request,	prefix + "sc_no", ""));
		setActCustCntCd(JSPUtil.getParameter(request,	prefix + "act_cust_cnt_cd", ""));
		setEdiHdrSeq(JSPUtil.getParameter(request,	prefix + "edi_hdr_seq", ""));
		setEdiSndFlg(JSPUtil.getParameter(request,	prefix + "edi_snd_flg", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setInvDt(JSPUtil.getParameter(request,	prefix + "inv_dt", ""));
		setUpdDt(JSPUtil.getParameter(request,	prefix + "upd_dt", ""));
		setLoclCurrCd(JSPUtil.getParameter(request,	prefix + "locl_curr_cd", ""));
		setActCustSeq(JSPUtil.getParameter(request,	prefix + "act_cust_seq", ""));
		setTrnkVvdCd(JSPUtil.getParameter(request,	prefix + "trnk_vvd_cd", ""));
		setDelCd(JSPUtil.getParameter(request,	prefix + "del_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request,	prefix + "skd_voy_no", ""));
		setIoBndCd(JSPUtil.getParameter(request,	prefix + "io_bnd_cd", ""));
		setEdiTpCd(JSPUtil.getParameter(request,	prefix + "edi_tp_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request,	prefix + "skd_dir_cd", ""));
		setArOfcCd(JSPUtil.getParameter(request,	prefix + "ar_ofc_cd", ""));
		setCustCrFlg(JSPUtil.getParameter(request,	prefix + "cust_cr_flg", ""));
		setPodCd(JSPUtil.getParameter(request,	prefix + "pod_cd", ""));
		setInvNo(JSPUtil.getParameter(request,	prefix + "inv_no", ""));
		setBkgNo(JSPUtil.getParameter(request,	prefix + "bkg_no", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setSlanCd(JSPUtil.getParameter(request,	prefix + "slan_cd", ""));
		setBlSeq(JSPUtil.getParameter(request,	prefix + "bl_seq", ""));
		setCntrNo(JSPUtil.getParameter(request,	prefix + "cntr_no", ""));
		setBdrIndFlg(JSPUtil.getParameter(request,	prefix + "bdr_ind_flg", ""));
		setInvDeltDivCd(JSPUtil.getParameter(request,	prefix + "inv_delt_div_cd", ""));
		setRevTpSrcCd(JSPUtil.getParameter(request,	prefix + "rev_tp_src_cd", ""));
		setEdiSndDt(JSPUtil.getParameter(request,	prefix + "edi_snd_dt", ""));
		setEdiGrpCd(JSPUtil.getParameter(request,	prefix + "edi_grp_cd", ""));
		setEdiReceiverId(JSPUtil.getParameter(request,	prefix + "edi_receiver_id", ""));
		setEdiSenderId(JSPUtil.getParameter(request,	prefix + "edi_sender_id", ""));
		setRevTpCd(JSPUtil.getParameter(request,	prefix + "rev_tp_cd", ""));
		setCnmvCycNo(JSPUtil.getParameter(request,	prefix + "cnmv_cyc_no", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvEDIHdrVO[]
	 */
	public InvEDIHdrVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return InvEDIHdrVO[]
	 */
	public InvEDIHdrVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		InvEDIHdrVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] porCd =	(JSPUtil.getParameter(request, prefix +	"por_cd".trim(),	length));
				String[] vslCd =	(JSPUtil.getParameter(request, prefix +	"vsl_cd".trim(),	length));
				String[] svcScpCd =	(JSPUtil.getParameter(request, prefix +	"svc_scp_cd".trim(),	length));
				String[] invTtlLoclAmt =	(JSPUtil.getParameter(request, prefix +	"inv_ttl_locl_amt".trim(),	length));
				String[] creDt =	(JSPUtil.getParameter(request, prefix +	"cre_dt".trim(),	length));
				String[] payCond =	(JSPUtil.getParameter(request, prefix +	"pay_cond".trim(),	length));
				String[] sailArrDt =	(JSPUtil.getParameter(request, prefix +	"sail_arr_dt".trim(),	length));
				String[] blNo =	(JSPUtil.getParameter(request, prefix +	"bl_no".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] rfaNo =	(JSPUtil.getParameter(request, prefix +	"rfa_no".trim(),	length));
				String[] polCd =	(JSPUtil.getParameter(request, prefix +	"pol_cd".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] arIfNo =	(JSPUtil.getParameter(request, prefix +	"ar_if_no".trim(),	length));
				String[] scNo =	(JSPUtil.getParameter(request, prefix +	"sc_no".trim(),	length));
				String[] actCustCntCd =	(JSPUtil.getParameter(request, prefix +	"act_cust_cnt_cd".trim(),	length));
				String[] ediHdrSeq =	(JSPUtil.getParameter(request, prefix +	"edi_hdr_seq".trim(),	length));
				String[] ediSndFlg =	(JSPUtil.getParameter(request, prefix +	"edi_snd_flg".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] invDt =	(JSPUtil.getParameter(request, prefix +	"inv_dt".trim(),	length));
				String[] updDt =	(JSPUtil.getParameter(request, prefix +	"upd_dt".trim(),	length));
				String[] loclCurrCd =	(JSPUtil.getParameter(request, prefix +	"locl_curr_cd".trim(),	length));
				String[] actCustSeq =	(JSPUtil.getParameter(request, prefix +	"act_cust_seq".trim(),	length));
				String[] trnkVvdCd =	(JSPUtil.getParameter(request, prefix +	"trnk_vvd_cd".trim(),	length));
				String[] delCd =	(JSPUtil.getParameter(request, prefix +	"del_cd".trim(),	length));
				String[] skdVoyNo =	(JSPUtil.getParameter(request, prefix +	"skd_voy_no".trim(),	length));
				String[] ioBndCd =	(JSPUtil.getParameter(request, prefix +	"io_bnd_cd".trim(),	length));
				String[] ediTpCd =	(JSPUtil.getParameter(request, prefix +	"edi_tp_cd".trim(),	length));
				String[] skdDirCd =	(JSPUtil.getParameter(request, prefix +	"skd_dir_cd".trim(),	length));
				String[] arOfcCd =	(JSPUtil.getParameter(request, prefix +	"ar_ofc_cd".trim(),	length));
				String[] custCrFlg =	(JSPUtil.getParameter(request, prefix +	"cust_cr_flg".trim(),	length));
				String[] podCd =	(JSPUtil.getParameter(request, prefix +	"pod_cd".trim(),	length));
				String[] invNo =	(JSPUtil.getParameter(request, prefix +	"inv_no".trim(),	length));
				String[] bkgNo =	(JSPUtil.getParameter(request, prefix +	"bkg_no".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				String[] slanCd =	(JSPUtil.getParameter(request, prefix +	"slan_cd".trim(),	length));
				String[] blSeq =	(JSPUtil.getParameter(request, prefix +	"bl_seq".trim(),	length));
				String[] cntrNo =	(JSPUtil.getParameter(request, prefix +	"cntr_no".trim(),	length));
				String[] bdrIndFlg =	(JSPUtil.getParameter(request, prefix +	"bdr_ind_flg".trim(),	length));
				String[] invDeltDivCd =	(JSPUtil.getParameter(request, prefix +	"inv_delt_div_cd".trim(),	length));
				String[] revTpSrcCd =	(JSPUtil.getParameter(request, prefix +	"rev_tp_src_cd".trim(),	length));
				String[] ediSndDt =	(JSPUtil.getParameter(request, prefix +	"edi_snd_dt".trim(),	length));
				String[] ediGrpCd =	(JSPUtil.getParameter(request, prefix +	"edi_grp_cd".trim(),	length));
				String[] ediReceiverId =	(JSPUtil.getParameter(request, prefix +	"edi_receiver_id".trim(),	length));
				String[] ediSenderId =	(JSPUtil.getParameter(request, prefix +	"edi_sender_id".trim(),	length));
				String[] revTpCd =	(JSPUtil.getParameter(request, prefix +	"rev_tp_cd".trim(),	length));
				String[] cnmvCycNo =	(JSPUtil.getParameter(request, prefix +	"cnmv_cyc_no".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	InvEDIHdrVO();
						if ( porCd[i] !=	null)
						model.setPorCd( porCd[i]);
						if ( vslCd[i] !=	null)
						model.setVslCd( vslCd[i]);
						if ( svcScpCd[i] !=	null)
						model.setSvcScpCd( svcScpCd[i]);
						if ( invTtlLoclAmt[i] !=	null)
						model.setInvTtlLoclAmt( invTtlLoclAmt[i]);
						if ( creDt[i] !=	null)
						model.setCreDt( creDt[i]);
						if ( payCond[i] !=	null)
						model.setPayCond( payCond[i]);
						if ( sailArrDt[i] !=	null)
						model.setSailArrDt( sailArrDt[i]);
						if ( blNo[i] !=	null)
						model.setBlNo( blNo[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( rfaNo[i] !=	null)
						model.setRfaNo( rfaNo[i]);
						if ( polCd[i] !=	null)
						model.setPolCd( polCd[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( arIfNo[i] !=	null)
						model.setArIfNo( arIfNo[i]);
						if ( scNo[i] !=	null)
						model.setScNo( scNo[i]);
						if ( actCustCntCd[i] !=	null)
						model.setActCustCntCd( actCustCntCd[i]);
						if ( ediHdrSeq[i] !=	null)
						model.setEdiHdrSeq( ediHdrSeq[i]);
						if ( ediSndFlg[i] !=	null)
						model.setEdiSndFlg( ediSndFlg[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( invDt[i] !=	null)
						model.setInvDt( invDt[i]);
						if ( updDt[i] !=	null)
						model.setUpdDt( updDt[i]);
						if ( loclCurrCd[i] !=	null)
						model.setLoclCurrCd( loclCurrCd[i]);
						if ( actCustSeq[i] !=	null)
						model.setActCustSeq( actCustSeq[i]);
						if ( trnkVvdCd[i] !=	null)
						model.setTrnkVvdCd( trnkVvdCd[i]);
						if ( delCd[i] !=	null)
						model.setDelCd( delCd[i]);
						if ( skdVoyNo[i] !=	null)
						model.setSkdVoyNo( skdVoyNo[i]);
						if ( ioBndCd[i] !=	null)
						model.setIoBndCd( ioBndCd[i]);
						if ( ediTpCd[i] !=	null)
						model.setEdiTpCd( ediTpCd[i]);
						if ( skdDirCd[i] !=	null)
						model.setSkdDirCd( skdDirCd[i]);
						if ( arOfcCd[i] !=	null)
						model.setArOfcCd( arOfcCd[i]);
						if ( custCrFlg[i] !=	null)
						model.setCustCrFlg( custCrFlg[i]);
						if ( podCd[i] !=	null)
						model.setPodCd( podCd[i]);
						if ( invNo[i] !=	null)
						model.setInvNo( invNo[i]);
						if ( bkgNo[i] !=	null)
						model.setBkgNo( bkgNo[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
						if ( slanCd[i] !=	null)
						model.setSlanCd( slanCd[i]);
						if ( blSeq[i] !=	null)
						model.setBlSeq( blSeq[i]);
						if ( cntrNo[i] !=	null)
						model.setCntrNo( cntrNo[i]);
						if ( bdrIndFlg[i] !=	null)
						model.setBdrIndFlg( bdrIndFlg[i]);
						if ( invDeltDivCd[i] !=	null)
						model.setInvDeltDivCd( invDeltDivCd[i]);
						if ( revTpSrcCd[i] !=	null)
						model.setRevTpSrcCd( revTpSrcCd[i]);
						if ( ediSndDt[i] !=	null)
						model.setEdiSndDt( ediSndDt[i]);
						if ( ediGrpCd[i] !=	null)
						model.setEdiGrpCd( ediGrpCd[i]);
						if ( ediReceiverId[i] !=	null)
						model.setEdiReceiverId( ediReceiverId[i]);
						if ( ediSenderId[i] !=	null)
						model.setEdiSenderId( ediSenderId[i]);
						if ( revTpCd[i] !=	null)
						model.setRevTpCd( revTpCd[i]);
						if ( cnmvCycNo[i] !=	null)
						model.setCnmvCycNo( cnmvCycNo[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getInvEDIHdrVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return InvEDIHdrVO[]
	 */
	public InvEDIHdrVO[]	 getInvEDIHdrVOs(){
		InvEDIHdrVO[] vos = (InvEDIHdrVO[])models.toArray(new	InvEDIHdrVO[models.size()]);
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
		this.porCd =	this.porCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd =	this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd =	this.svcScpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTtlLoclAmt =	this.invTtlLoclAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt =	this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payCond =	this.payCond.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailArrDt =	this.sailArrDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo =	this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo =	this.rfaNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd =	this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfNo =	this.arIfNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo =	this.scNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustCntCd =	this.actCustCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediHdrSeq =	this.ediHdrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndFlg =	this.ediSndFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDt =	this.invDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt =	this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCd =	this.loclCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustSeq =	this.actCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkVvdCd =	this.trnkVvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd =	this.delCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo =	this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd =	this.ioBndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediTpCd =	this.ediTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd =	this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd =	this.arOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCrFlg =	this.custCrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd =	this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo =	this.invNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo =	this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd =	this.slanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSeq =	this.blSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo =	this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrIndFlg =	this.bdrIndFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDeltDivCd =	this.invDeltDivCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revTpSrcCd =	this.revTpSrcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndDt =	this.ediSndDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediGrpCd =	this.ediGrpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediReceiverId =	this.ediReceiverId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSenderId =	this.ediSenderId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revTpCd =	this.revTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvCycNo =	this.cnmvCycNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}