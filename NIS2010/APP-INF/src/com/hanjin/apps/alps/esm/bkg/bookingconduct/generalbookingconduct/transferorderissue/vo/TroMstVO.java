/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : TroMstVO.java
 *@FileTitle : TroMstVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.07.27
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2016.07.27  
 * 1.0 Creation
=========================================================*/

package	 com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

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
public class TroMstVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<TroMstVO>  models =	new	ArrayList<TroMstVO>();


	/*	Column Info	*/
	private  String	 rqstUsrId   =  null;
	/*	Column Info	*/
	private  String	 soActCustNo   =  null;
	/*	Column Info	*/
	private  String	 znCd   =  null;
	/*	Column Info	*/
	private  String	 cxlFlg   =  null;
	/*	Column Info	*/
	private  String	 creDt   =  null;
	/*	Column Info	*/
	private  String	 ownrTrkFlg   =  null;
	/*	Column Info	*/
	private  String	 cntcPhnNo   =  null;
	/*	Column Info	*/
	private  String	 pctlNo   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 soActCustSeq   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 cntcPsonNm   =  null;
	/*	Column Info	*/
	private  String	 cntcFaxNo   =  null;
	/*	Column Info	*/
	private  String	 actShprPhnNo   =  null;
	/*	Column Info	*/
	private  String	 rtnTroFlg   =  null;
	/*	Column Info	*/
	private  String	 rcvTermCd   =  null;
	/*	Column Info	*/
	private  String	 cntcMphnNo   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 updDt   =  null;
	/*	Column Info	*/
	private  String	 rqstDt   =  null;
	/*	Column Info	*/
	private  String	 cxlFlgOld   =  null;
	/*	Column Info	*/
	private  String	 dorPstNo   =  null;
	/*	Column Info	*/
	private  String	 soFlg   =  null;
	/*	Column Info	*/
	private  String	 troSeq   =  null;
	/*	Column Info	*/
	private  String	 cfmDt   =  null;
	/*	Column Info	*/
	private  String	 dorLocCd   =  null;
	/*	Column Info	*/
	private  String	 ioBndCd   =  null;
	/*	Column Info	*/
	private  String	 cfmFlg   =  null;
	/*	Column Info	*/
	private  String	 returnCyNo   =  null;
	/*	Column Info	*/
	private  String	 bkgNo   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;
	/*	Column Info	*/
	private  String	 diffRmk   =  null;
	/*	Column Info	*/
	private  String	 bizRgstNo   =  null;
	/*	Column Info	*/
	private  String	 ackStsCd   =  null;
	/*	Column Info	*/
	private  String	 cfmFlgOld   =  null;
	/*	Column Info	*/
	private  String	 pickupCyNo   =  null;
	/*	Column Info	*/
	private  String	 actShprCntCd   =  null;
	/*	Column Info	*/
	private  String	 actShprNm   =  null;
	/*	Column Info	*/
	private  String	 actShprAddr   =  null;
	/*	Column Info	*/
	private  String	 actShprSeq   =  null;
	/*	Column Info	*/
	private  String	 isEur   =  null;
	/*	Column Info	*/
	private  String	 bkgTrspModCd   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new HashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new HashMap<String, String>();
 
 
	/**	Constructor	*/
	public TroMstVO(){}

	public TroMstVO(String rqstUsrId,String soActCustNo,String znCd,String cxlFlg,String creDt,String ownrTrkFlg,String cntcPhnNo,String pctlNo,String pagerows,String soActCustSeq,String ibflag,String cntcPsonNm,String cntcFaxNo,String actShprPhnNo,String rtnTroFlg,String rcvTermCd,String cntcMphnNo,String updUsrId,String updDt,String rqstDt,String cxlFlgOld,String dorPstNo,String soFlg,String troSeq,String cfmDt,String dorLocCd,String ioBndCd,String cfmFlg,String returnCyNo,String bkgNo,String creUsrId,String diffRmk,String bizRgstNo,String ackStsCd,String cfmFlgOld,String pickupCyNo,String actShprCntCd,String actShprNm,String actShprAddr,String actShprSeq,String isEur,String bkgTrspModCd)	{
		this.rqstUsrId  = rqstUsrId ;
		this.soActCustNo  = soActCustNo ;
		this.znCd  = znCd ;
		this.cxlFlg  = cxlFlg ;
		this.creDt  = creDt ;
		this.ownrTrkFlg  = ownrTrkFlg ;
		this.cntcPhnNo  = cntcPhnNo ;
		this.pctlNo  = pctlNo ;
		this.pagerows  = pagerows ;
		this.soActCustSeq  = soActCustSeq ;
		this.ibflag  = ibflag ;
		this.cntcPsonNm  = cntcPsonNm ;
		this.cntcFaxNo  = cntcFaxNo ;
		this.actShprPhnNo  = actShprPhnNo ;
		this.rtnTroFlg  = rtnTroFlg ;
		this.rcvTermCd  = rcvTermCd ;
		this.cntcMphnNo  = cntcMphnNo ;
		this.updUsrId  = updUsrId ;
		this.updDt  = updDt ;
		this.rqstDt  = rqstDt ;
		this.cxlFlgOld  = cxlFlgOld ;
		this.dorPstNo  = dorPstNo ;
		this.soFlg  = soFlg ;
		this.troSeq  = troSeq ;
		this.cfmDt  = cfmDt ;
		this.dorLocCd  = dorLocCd ;
		this.ioBndCd  = ioBndCd ;
		this.cfmFlg  = cfmFlg ;
		this.returnCyNo  = returnCyNo ;
		this.bkgNo  = bkgNo ;
		this.creUsrId  = creUsrId ;
		this.diffRmk  = diffRmk ;
		this.bizRgstNo  = bizRgstNo ;
		this.ackStsCd  = ackStsCd ;
		this.cfmFlgOld  = cfmFlgOld ;
		this.pickupCyNo  = pickupCyNo ;
		this.actShprCntCd  = actShprCntCd ;
		this.actShprNm  = actShprNm ;
		this.actShprAddr  = actShprAddr ;
		this.actShprSeq  = actShprSeq ;
		this.isEur  = isEur ;
		this.bkgTrspModCd  = bkgTrspModCd ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rqst_usr_id", getRqstUsrId());		
		this.hashColumns.put("so_act_cust_no", getSoActCustNo());		
		this.hashColumns.put("zn_cd", getZnCd());		
		this.hashColumns.put("cxl_flg", getCxlFlg());		
		this.hashColumns.put("cre_dt", getCreDt());		
		this.hashColumns.put("ownr_trk_flg", getOwnrTrkFlg());		
		this.hashColumns.put("cntc_phn_no", getCntcPhnNo());		
		this.hashColumns.put("pctl_no", getPctlNo());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("so_act_cust_seq", getSoActCustSeq());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("cntc_pson_nm", getCntcPsonNm());		
		this.hashColumns.put("cntc_fax_no", getCntcFaxNo());		
		this.hashColumns.put("act_shpr_phn_no", getActShprPhnNo());		
		this.hashColumns.put("rtn_tro_flg", getRtnTroFlg());		
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());		
		this.hashColumns.put("cntc_mphn_no", getCntcMphnNo());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("upd_dt", getUpdDt());		
		this.hashColumns.put("rqst_dt", getRqstDt());		
		this.hashColumns.put("cxl_flg_old", getCxlFlgOld());		
		this.hashColumns.put("dor_pst_no", getDorPstNo());		
		this.hashColumns.put("so_flg", getSoFlg());		
		this.hashColumns.put("tro_seq", getTroSeq());		
		this.hashColumns.put("cfm_dt", getCfmDt());		
		this.hashColumns.put("dor_loc_cd", getDorLocCd());		
		this.hashColumns.put("io_bnd_cd", getIoBndCd());		
		this.hashColumns.put("cfm_flg", getCfmFlg());		
		this.hashColumns.put("return_cy_no", getReturnCyNo());		
		this.hashColumns.put("bkg_no", getBkgNo());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("diff_rmk", getDiffRmk());		
		this.hashColumns.put("biz_rgst_no", getBizRgstNo());		
		this.hashColumns.put("ack_sts_cd", getAckStsCd());		
		this.hashColumns.put("cfm_flg_old", getCfmFlgOld());		
		this.hashColumns.put("pickup_cy_no", getPickupCyNo());		
		this.hashColumns.put("act_shpr_cnt_cd", getActShprCntCd());		
		this.hashColumns.put("act_shpr_nm", getActShprNm());		
		this.hashColumns.put("act_shpr_addr", getActShprAddr());		
		this.hashColumns.put("act_shpr_seq", getActShprSeq());		
		this.hashColumns.put("is_eur", getIsEur());		
		this.hashColumns.put("bkg_trsp_mod_cd", getBkgTrspModCd());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("rqst_usr_id", "rqstUsrId");
		this.hashFields.put("so_act_cust_no", "soActCustNo");
		this.hashFields.put("zn_cd", "znCd");
		this.hashFields.put("cxl_flg", "cxlFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("ownr_trk_flg", "ownrTrkFlg");
		this.hashFields.put("cntc_phn_no", "cntcPhnNo");
		this.hashFields.put("pctl_no", "pctlNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("so_act_cust_seq", "soActCustSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntc_pson_nm", "cntcPsonNm");
		this.hashFields.put("cntc_fax_no", "cntcFaxNo");
		this.hashFields.put("act_shpr_phn_no", "actShprPhnNo");
		this.hashFields.put("rtn_tro_flg", "rtnTroFlg");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("cntc_mphn_no", "cntcMphnNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("rqst_dt", "rqstDt");
		this.hashFields.put("cxl_flg_old", "cxlFlgOld");
		this.hashFields.put("dor_pst_no", "dorPstNo");
		this.hashFields.put("so_flg", "soFlg");
		this.hashFields.put("tro_seq", "troSeq");
		this.hashFields.put("cfm_dt", "cfmDt");
		this.hashFields.put("dor_loc_cd", "dorLocCd");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("cfm_flg", "cfmFlg");
		this.hashFields.put("return_cy_no", "returnCyNo");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("biz_rgst_no", "bizRgstNo");
		this.hashFields.put("ack_sts_cd", "ackStsCd");
		this.hashFields.put("cfm_flg_old", "cfmFlgOld");
		this.hashFields.put("pickup_cy_no", "pickupCyNo");
		this.hashFields.put("act_shpr_cnt_cd", "actShprCntCd");
		this.hashFields.put("act_shpr_nm", "actShprNm");
		this.hashFields.put("act_shpr_addr", "actShprAddr");
		this.hashFields.put("act_shpr_seq", "actShprSeq");
		this.hashFields.put("is_eur", "isEur");
		this.hashFields.put("bkg_trsp_mod_cd", "bkgTrspModCd");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  rqstUsrId
	*/
	public void	setRqstUsrId( String	rqstUsrId ) {
		this.rqstUsrId =	rqstUsrId;
	}
 
	/**
	 * Column Info
	 * @return	rqstUsrId
	 */
	 public	String	getRqstUsrId() {
		 return	this.rqstUsrId;
	 } 
 	/**
	* Column Info
	* @param  soActCustNo
	*/
	public void	setSoActCustNo( String	soActCustNo ) {
		this.soActCustNo =	soActCustNo;
	}
 
	/**
	 * Column Info
	 * @return	soActCustNo
	 */
	 public	String	getSoActCustNo() {
		 return	this.soActCustNo;
	 } 
 	/**
	* Column Info
	* @param  znCd
	*/
	public void	setZnCd( String	znCd ) {
		this.znCd =	znCd;
	}
 
	/**
	 * Column Info
	 * @return	znCd
	 */
	 public	String	getZnCd() {
		 return	this.znCd;
	 } 
 	/**
	* Column Info
	* @param  cxlFlg
	*/
	public void	setCxlFlg( String	cxlFlg ) {
		this.cxlFlg =	cxlFlg;
	}
 
	/**
	 * Column Info
	 * @return	cxlFlg
	 */
	 public	String	getCxlFlg() {
		 return	this.cxlFlg;
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
	 public	String	getCreDt() {
		 return	this.creDt;
	 } 
 	/**
	* Column Info
	* @param  ownrTrkFlg
	*/
	public void	setOwnrTrkFlg( String	ownrTrkFlg ) {
		this.ownrTrkFlg =	ownrTrkFlg;
	}
 
	/**
	 * Column Info
	 * @return	ownrTrkFlg
	 */
	 public	String	getOwnrTrkFlg() {
		 return	this.ownrTrkFlg;
	 } 
 	/**
	* Column Info
	* @param  cntcPhnNo
	*/
	public void	setCntcPhnNo( String	cntcPhnNo ) {
		this.cntcPhnNo =	cntcPhnNo;
	}
 
	/**
	 * Column Info
	 * @return	cntcPhnNo
	 */
	 public	String	getCntcPhnNo() {
		 return	this.cntcPhnNo;
	 } 
 	/**
	* Column Info
	* @param  pctlNo
	*/
	public void	setPctlNo( String	pctlNo ) {
		this.pctlNo =	pctlNo;
	}
 
	/**
	 * Column Info
	 * @return	pctlNo
	 */
	 public	String	getPctlNo() {
		 return	this.pctlNo;
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
	 public	String	getPagerows() {
		 return	this.pagerows;
	 } 
 	/**
	* Column Info
	* @param  soActCustSeq
	*/
	public void	setSoActCustSeq( String	soActCustSeq ) {
		this.soActCustSeq =	soActCustSeq;
	}
 
	/**
	 * Column Info
	 * @return	soActCustSeq
	 */
	 public	String	getSoActCustSeq() {
		 return	this.soActCustSeq;
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
	 public	String	getIbflag() {
		 return	this.ibflag;
	 } 
 	/**
	* Column Info
	* @param  cntcPsonNm
	*/
	public void	setCntcPsonNm( String	cntcPsonNm ) {
		this.cntcPsonNm =	cntcPsonNm;
	}
 
	/**
	 * Column Info
	 * @return	cntcPsonNm
	 */
	 public	String	getCntcPsonNm() {
		 return	this.cntcPsonNm;
	 } 
 	/**
	* Column Info
	* @param  cntcFaxNo
	*/
	public void	setCntcFaxNo( String	cntcFaxNo ) {
		this.cntcFaxNo =	cntcFaxNo;
	}
 
	/**
	 * Column Info
	 * @return	cntcFaxNo
	 */
	 public	String	getCntcFaxNo() {
		 return	this.cntcFaxNo;
	 } 
 	/**
	* Column Info
	* @param  actShprPhnNo
	*/
	public void	setActShprPhnNo( String	actShprPhnNo ) {
		this.actShprPhnNo =	actShprPhnNo;
	}
 
	/**
	 * Column Info
	 * @return	actShprPhnNo
	 */
	 public	String	getActShprPhnNo() {
		 return	this.actShprPhnNo;
	 } 
 	/**
	* Column Info
	* @param  rtnTroFlg
	*/
	public void	setRtnTroFlg( String	rtnTroFlg ) {
		this.rtnTroFlg =	rtnTroFlg;
	}
 
	/**
	 * Column Info
	 * @return	rtnTroFlg
	 */
	 public	String	getRtnTroFlg() {
		 return	this.rtnTroFlg;
	 } 
 	/**
	* Column Info
	* @param  rcvTermCd
	*/
	public void	setRcvTermCd( String	rcvTermCd ) {
		this.rcvTermCd =	rcvTermCd;
	}
 
	/**
	 * Column Info
	 * @return	rcvTermCd
	 */
	 public	String	getRcvTermCd() {
		 return	this.rcvTermCd;
	 } 
 	/**
	* Column Info
	* @param  cntcMphnNo
	*/
	public void	setCntcMphnNo( String	cntcMphnNo ) {
		this.cntcMphnNo =	cntcMphnNo;
	}
 
	/**
	 * Column Info
	 * @return	cntcMphnNo
	 */
	 public	String	getCntcMphnNo() {
		 return	this.cntcMphnNo;
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
	 public	String	getUpdUsrId() {
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
	 public	String	getUpdDt() {
		 return	this.updDt;
	 } 
 	/**
	* Column Info
	* @param  rqstDt
	*/
	public void	setRqstDt( String	rqstDt ) {
		this.rqstDt =	rqstDt;
	}
 
	/**
	 * Column Info
	 * @return	rqstDt
	 */
	 public	String	getRqstDt() {
		 return	this.rqstDt;
	 } 
 	/**
	* Column Info
	* @param  cxlFlgOld
	*/
	public void	setCxlFlgOld( String	cxlFlgOld ) {
		this.cxlFlgOld =	cxlFlgOld;
	}
 
	/**
	 * Column Info
	 * @return	cxlFlgOld
	 */
	 public	String	getCxlFlgOld() {
		 return	this.cxlFlgOld;
	 } 
 	/**
	* Column Info
	* @param  dorPstNo
	*/
	public void	setDorPstNo( String	dorPstNo ) {
		this.dorPstNo =	dorPstNo;
	}
 
	/**
	 * Column Info
	 * @return	dorPstNo
	 */
	 public	String	getDorPstNo() {
		 return	this.dorPstNo;
	 } 
 	/**
	* Column Info
	* @param  soFlg
	*/
	public void	setSoFlg( String	soFlg ) {
		this.soFlg =	soFlg;
	}
 
	/**
	 * Column Info
	 * @return	soFlg
	 */
	 public	String	getSoFlg() {
		 return	this.soFlg;
	 } 
 	/**
	* Column Info
	* @param  troSeq
	*/
	public void	setTroSeq( String	troSeq ) {
		this.troSeq =	troSeq;
	}
 
	/**
	 * Column Info
	 * @return	troSeq
	 */
	 public	String	getTroSeq() {
		 return	this.troSeq;
	 } 
 	/**
	* Column Info
	* @param  cfmDt
	*/
	public void	setCfmDt( String	cfmDt ) {
		this.cfmDt =	cfmDt;
	}
 
	/**
	 * Column Info
	 * @return	cfmDt
	 */
	 public	String	getCfmDt() {
		 return	this.cfmDt;
	 } 
 	/**
	* Column Info
	* @param  dorLocCd
	*/
	public void	setDorLocCd( String	dorLocCd ) {
		this.dorLocCd =	dorLocCd;
	}
 
	/**
	 * Column Info
	 * @return	dorLocCd
	 */
	 public	String	getDorLocCd() {
		 return	this.dorLocCd;
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
	 public	String	getIoBndCd() {
		 return	this.ioBndCd;
	 } 
 	/**
	* Column Info
	* @param  cfmFlg
	*/
	public void	setCfmFlg( String	cfmFlg ) {
		this.cfmFlg =	cfmFlg;
	}
 
	/**
	 * Column Info
	 * @return	cfmFlg
	 */
	 public	String	getCfmFlg() {
		 return	this.cfmFlg;
	 } 
 	/**
	* Column Info
	* @param  returnCyNo
	*/
	public void	setReturnCyNo( String	returnCyNo ) {
		this.returnCyNo =	returnCyNo;
	}
 
	/**
	 * Column Info
	 * @return	returnCyNo
	 */
	 public	String	getReturnCyNo() {
		 return	this.returnCyNo;
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
	 public	String	getBkgNo() {
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
	 public	String	getCreUsrId() {
		 return	this.creUsrId;
	 } 
 	/**
	* Column Info
	* @param  diffRmk
	*/
	public void	setDiffRmk( String	diffRmk ) {
		this.diffRmk =	diffRmk;
	}
 
	/**
	 * Column Info
	 * @return	diffRmk
	 */
	 public	String	getDiffRmk() {
		 return	this.diffRmk;
	 } 
 	/**
	* Column Info
	* @param  bizRgstNo
	*/
	public void	setBizRgstNo( String	bizRgstNo ) {
		this.bizRgstNo =	bizRgstNo;
	}
 
	/**
	 * Column Info
	 * @return	bizRgstNo
	 */
	 public	String	getBizRgstNo() {
		 return	this.bizRgstNo;
	 } 
 	/**
	* Column Info
	* @param  ackStsCd
	*/
	public void	setAckStsCd( String	ackStsCd ) {
		this.ackStsCd =	ackStsCd;
	}
 
	/**
	 * Column Info
	 * @return	ackStsCd
	 */
	 public	String	getAckStsCd() {
		 return	this.ackStsCd;
	 } 
 	/**
	* Column Info
	* @param  cfmFlgOld
	*/
	public void	setCfmFlgOld( String	cfmFlgOld ) {
		this.cfmFlgOld =	cfmFlgOld;
	}
 
	/**
	 * Column Info
	 * @return	cfmFlgOld
	 */
	 public	String	getCfmFlgOld() {
		 return	this.cfmFlgOld;
	 } 
 	/**
	* Column Info
	* @param  pickupCyNo
	*/
	public void	setPickupCyNo( String	pickupCyNo ) {
		this.pickupCyNo =	pickupCyNo;
	}
 
	/**
	 * Column Info
	 * @return	pickupCyNo
	 */
	 public	String	getPickupCyNo() {
		 return	this.pickupCyNo;
	 } 
 	/**
	* Column Info
	* @param  actShprCntCd
	*/
	public void	setActShprCntCd( String	actShprCntCd ) {
		this.actShprCntCd =	actShprCntCd;
	}
 
	/**
	 * Column Info
	 * @return	actShprCntCd
	 */
	 public	String	getActShprCntCd() {
		 return	this.actShprCntCd;
	 } 
 	/**
	* Column Info
	* @param  actShprNm
	*/
	public void	setActShprNm( String	actShprNm ) {
		this.actShprNm =	actShprNm;
	}
 
	/**
	 * Column Info
	 * @return	actShprNm
	 */
	 public	String	getActShprNm() {
		 return	this.actShprNm;
	 } 
 	/**
	* Column Info
	* @param  actShprAddr
	*/
	public void	setActShprAddr( String	actShprAddr ) {
		this.actShprAddr =	actShprAddr;
	}
 
	/**
	 * Column Info
	 * @return	actShprAddr
	 */
	 public	String	getActShprAddr() {
		 return	this.actShprAddr;
	 } 
 	/**
	* Column Info
	* @param  actShprSeq
	*/
	public void	setActShprSeq( String	actShprSeq ) {
		this.actShprSeq =	actShprSeq;
	}
 
	/**
	 * Column Info
	 * @return	actShprSeq
	 */
	 public	String	getActShprSeq() {
		 return	this.actShprSeq;
	 } 
 	/**
	* Column Info
	* @param  isEur
	*/
	public void	setIsEur( String	isEur ) {
		this.isEur =	isEur;
	}
 
	/**
	 * Column Info
	 * @return	isEur
	 */
	 public	String	getIsEur() {
		 return	this.isEur;
	 } 
 	/**
	* Column Info
	* @param  bkgTrspModCd
	*/
	public void	setBkgTrspModCd( String	bkgTrspModCd ) {
		this.bkgTrspModCd =	bkgTrspModCd;
	}
 
	/**
	 * Column Info
	 * @return	bkgTrspModCd
	 */
	 public	String	getBkgTrspModCd() {
		 return	this.bkgTrspModCd;
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
		setRqstUsrId(JSPUtil.getParameter(request,	prefix + "rqst_usr_id", ""));
		setSoActCustNo(JSPUtil.getParameter(request,	prefix + "so_act_cust_no", ""));
		setZnCd(JSPUtil.getParameter(request,	prefix + "zn_cd", ""));
		setCxlFlg(JSPUtil.getParameter(request,	prefix + "cxl_flg", ""));
		setCreDt(JSPUtil.getParameter(request,	prefix + "cre_dt", ""));
		setOwnrTrkFlg(JSPUtil.getParameter(request,	prefix + "ownr_trk_flg", ""));
		setCntcPhnNo(JSPUtil.getParameter(request,	prefix + "cntc_phn_no", ""));
		setPctlNo(JSPUtil.getParameter(request,	prefix + "pctl_no", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setSoActCustSeq(JSPUtil.getParameter(request,	prefix + "so_act_cust_seq", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setCntcPsonNm(JSPUtil.getParameter(request,	prefix + "cntc_pson_nm", ""));
		setCntcFaxNo(JSPUtil.getParameter(request,	prefix + "cntc_fax_no", ""));
		setActShprPhnNo(JSPUtil.getParameter(request,	prefix + "act_shpr_phn_no", ""));
		setRtnTroFlg(JSPUtil.getParameter(request,	prefix + "rtn_tro_flg", ""));
		setRcvTermCd(JSPUtil.getParameter(request,	prefix + "rcv_term_cd", ""));
		setCntcMphnNo(JSPUtil.getParameter(request,	prefix + "cntc_mphn_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request,	prefix + "upd_dt", ""));
		setRqstDt(JSPUtil.getParameter(request,	prefix + "rqst_dt", ""));
		setCxlFlgOld(JSPUtil.getParameter(request,	prefix + "cxl_flg_old", ""));
		setDorPstNo(JSPUtil.getParameter(request,	prefix + "dor_pst_no", ""));
		setSoFlg(JSPUtil.getParameter(request,	prefix + "so_flg", ""));
		setTroSeq(JSPUtil.getParameter(request,	prefix + "tro_seq", ""));
		setCfmDt(JSPUtil.getParameter(request,	prefix + "cfm_dt", ""));
		setDorLocCd(JSPUtil.getParameter(request,	prefix + "dor_loc_cd", ""));
		setIoBndCd(JSPUtil.getParameter(request,	prefix + "io_bnd_cd", ""));
		setCfmFlg(JSPUtil.getParameter(request,	prefix + "cfm_flg", ""));
		setReturnCyNo(JSPUtil.getParameter(request,	prefix + "return_cy_no", ""));
		setBkgNo(JSPUtil.getParameter(request,	prefix + "bkg_no", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setDiffRmk(JSPUtil.getParameter(request,	prefix + "diff_rmk", ""));
		setBizRgstNo(JSPUtil.getParameter(request,	prefix + "biz_rgst_no", ""));
		setAckStsCd(JSPUtil.getParameter(request,	prefix + "ack_sts_cd", ""));
		setCfmFlgOld(JSPUtil.getParameter(request,	prefix + "cfm_flg_old", ""));
		setPickupCyNo(JSPUtil.getParameter(request,	prefix + "pickup_cy_no", ""));
		setActShprCntCd(JSPUtil.getParameter(request,	prefix + "act_shpr_cnt_cd", ""));
		setActShprNm(JSPUtil.getParameter(request,	prefix + "act_shpr_nm", ""));
		setActShprAddr(JSPUtil.getParameter(request,	prefix + "act_shpr_addr", ""));
		setActShprSeq(JSPUtil.getParameter(request,	prefix + "act_shpr_seq", ""));
		setIsEur(JSPUtil.getParameter(request,	prefix + "is_eur", ""));
		setBkgTrspModCd(JSPUtil.getParameter(request,	prefix + "bkg_trsp_mod_cd", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TroMstVO[]
	 */
	public TroMstVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return TroMstVO[]
	 */
	public TroMstVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		TroMstVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] rqstUsrId =	(JSPUtil.getParameter(request, prefix +	"rqst_usr_id".trim(),	length));
				String[] soActCustNo =	(JSPUtil.getParameter(request, prefix +	"so_act_cust_no".trim(),	length));
				String[] znCd =	(JSPUtil.getParameter(request, prefix +	"zn_cd".trim(),	length));
				String[] cxlFlg =	(JSPUtil.getParameter(request, prefix +	"cxl_flg".trim(),	length));
				String[] creDt =	(JSPUtil.getParameter(request, prefix +	"cre_dt".trim(),	length));
				String[] ownrTrkFlg =	(JSPUtil.getParameter(request, prefix +	"ownr_trk_flg".trim(),	length));
				String[] cntcPhnNo =	(JSPUtil.getParameter(request, prefix +	"cntc_phn_no".trim(),	length));
				String[] pctlNo =	(JSPUtil.getParameter(request, prefix +	"pctl_no".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] soActCustSeq =	(JSPUtil.getParameter(request, prefix +	"so_act_cust_seq".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] cntcPsonNm =	(JSPUtil.getParameter(request, prefix +	"cntc_pson_nm".trim(),	length));
				String[] cntcFaxNo =	(JSPUtil.getParameter(request, prefix +	"cntc_fax_no".trim(),	length));
				String[] actShprPhnNo =	(JSPUtil.getParameter(request, prefix +	"act_shpr_phn_no".trim(),	length));
				String[] rtnTroFlg =	(JSPUtil.getParameter(request, prefix +	"rtn_tro_flg".trim(),	length));
				String[] rcvTermCd =	(JSPUtil.getParameter(request, prefix +	"rcv_term_cd".trim(),	length));
				String[] cntcMphnNo =	(JSPUtil.getParameter(request, prefix +	"cntc_mphn_no".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] updDt =	(JSPUtil.getParameter(request, prefix +	"upd_dt".trim(),	length));
				String[] rqstDt =	(JSPUtil.getParameter(request, prefix +	"rqst_dt".trim(),	length));
				String[] cxlFlgOld =	(JSPUtil.getParameter(request, prefix +	"cxl_flg_old".trim(),	length));
				String[] dorPstNo =	(JSPUtil.getParameter(request, prefix +	"dor_pst_no".trim(),	length));
				String[] soFlg =	(JSPUtil.getParameter(request, prefix +	"so_flg".trim(),	length));
				String[] troSeq =	(JSPUtil.getParameter(request, prefix +	"tro_seq".trim(),	length));
				String[] cfmDt =	(JSPUtil.getParameter(request, prefix +	"cfm_dt".trim(),	length));
				String[] dorLocCd =	(JSPUtil.getParameter(request, prefix +	"dor_loc_cd".trim(),	length));
				String[] ioBndCd =	(JSPUtil.getParameter(request, prefix +	"io_bnd_cd".trim(),	length));
				String[] cfmFlg =	(JSPUtil.getParameter(request, prefix +	"cfm_flg".trim(),	length));
				String[] returnCyNo =	(JSPUtil.getParameter(request, prefix +	"return_cy_no".trim(),	length));
				String[] bkgNo =	(JSPUtil.getParameter(request, prefix +	"bkg_no".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				String[] diffRmk =	(JSPUtil.getParameter(request, prefix +	"diff_rmk".trim(),	length));
				String[] bizRgstNo =	(JSPUtil.getParameter(request, prefix +	"biz_rgst_no".trim(),	length));
				String[] ackStsCd =	(JSPUtil.getParameter(request, prefix +	"ack_sts_cd".trim(),	length));
				String[] cfmFlgOld =	(JSPUtil.getParameter(request, prefix +	"cfm_flg_old".trim(),	length));
				String[] pickupCyNo =	(JSPUtil.getParameter(request, prefix +	"pickup_cy_no".trim(),	length));
				String[] actShprCntCd =	(JSPUtil.getParameter(request, prefix +	"act_shpr_cnt_cd".trim(),	length));
				String[] actShprNm =	(JSPUtil.getParameter(request, prefix +	"act_shpr_nm".trim(),	length));
				String[] actShprAddr =	(JSPUtil.getParameter(request, prefix +	"act_shpr_addr".trim(),	length));
				String[] actShprSeq =	(JSPUtil.getParameter(request, prefix +	"act_shpr_seq".trim(),	length));
				String[] isEur =	(JSPUtil.getParameter(request, prefix +	"is_eur".trim(),	length));
				String[] bkgTrspModCd =	(JSPUtil.getParameter(request, prefix +	"bkg_trsp_mod_cd".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	TroMstVO();
						if ( rqstUsrId[i] !=	null)
						model.setRqstUsrId( rqstUsrId[i]);
						if ( soActCustNo[i] !=	null)
						model.setSoActCustNo( soActCustNo[i]);
						if ( znCd[i] !=	null)
						model.setZnCd( znCd[i]);
						if ( cxlFlg[i] !=	null)
						model.setCxlFlg( cxlFlg[i]);
						if ( creDt[i] !=	null)
						model.setCreDt( creDt[i]);
						if ( ownrTrkFlg[i] !=	null)
						model.setOwnrTrkFlg( ownrTrkFlg[i]);
						if ( cntcPhnNo[i] !=	null)
						model.setCntcPhnNo( cntcPhnNo[i]);
						if ( pctlNo[i] !=	null)
						model.setPctlNo( pctlNo[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( soActCustSeq[i] !=	null)
						model.setSoActCustSeq( soActCustSeq[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( cntcPsonNm[i] !=	null)
						model.setCntcPsonNm( cntcPsonNm[i]);
						if ( cntcFaxNo[i] !=	null)
						model.setCntcFaxNo( cntcFaxNo[i]);
						if ( actShprPhnNo[i] !=	null)
						model.setActShprPhnNo( actShprPhnNo[i]);
						if ( rtnTroFlg[i] !=	null)
						model.setRtnTroFlg( rtnTroFlg[i]);
						if ( rcvTermCd[i] !=	null)
						model.setRcvTermCd( rcvTermCd[i]);
						if ( cntcMphnNo[i] !=	null)
						model.setCntcMphnNo( cntcMphnNo[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( updDt[i] !=	null)
						model.setUpdDt( updDt[i]);
						if ( rqstDt[i] !=	null)
						model.setRqstDt( rqstDt[i]);
						if ( cxlFlgOld[i] !=	null)
						model.setCxlFlgOld( cxlFlgOld[i]);
						if ( dorPstNo[i] !=	null)
						model.setDorPstNo( dorPstNo[i]);
						if ( soFlg[i] !=	null)
						model.setSoFlg( soFlg[i]);
						if ( troSeq[i] !=	null)
						model.setTroSeq( troSeq[i]);
						if ( cfmDt[i] !=	null)
						model.setCfmDt( cfmDt[i]);
						if ( dorLocCd[i] !=	null)
						model.setDorLocCd( dorLocCd[i]);
						if ( ioBndCd[i] !=	null)
						model.setIoBndCd( ioBndCd[i]);
						if ( cfmFlg[i] !=	null)
						model.setCfmFlg( cfmFlg[i]);
						if ( returnCyNo[i] !=	null)
						model.setReturnCyNo( returnCyNo[i]);
						if ( bkgNo[i] !=	null)
						model.setBkgNo( bkgNo[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
						if ( diffRmk[i] !=	null)
						model.setDiffRmk( diffRmk[i]);
						if ( bizRgstNo[i] !=	null)
						model.setBizRgstNo( bizRgstNo[i]);
						if ( ackStsCd[i] !=	null)
						model.setAckStsCd( ackStsCd[i]);
						if ( cfmFlgOld[i] !=	null)
						model.setCfmFlgOld( cfmFlgOld[i]);
						if ( pickupCyNo[i] !=	null)
						model.setPickupCyNo( pickupCyNo[i]);
						if ( actShprCntCd[i] !=	null)
						model.setActShprCntCd( actShprCntCd[i]);
						if ( actShprNm[i] !=	null)
						model.setActShprNm( actShprNm[i]);
						if ( actShprAddr[i] !=	null)
						model.setActShprAddr( actShprAddr[i]);
						if ( actShprSeq[i] !=	null)
						model.setActShprSeq( actShprSeq[i]);
						if ( isEur[i] !=	null)
						model.setIsEur( isEur[i]);
						if ( bkgTrspModCd[i] !=	null)
						model.setBkgTrspModCd( bkgTrspModCd[i]);
					models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getTroMstVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return TroMstVO[]
	 */
	public TroMstVO[]	 getTroMstVOs(){
		TroMstVO[] vos = (TroMstVO[])models.toArray(new	TroMstVO[models.size()]);
		return vos;
		}

	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	}
	

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void	unDataFormat(){
		this.rqstUsrId =	this.rqstUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soActCustNo =	this.soActCustNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.znCd =	this.znCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlFlg =	this.cxlFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt =	this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownrTrkFlg =	this.ownrTrkFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPhnNo =	this.cntcPhnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pctlNo =	this.pctlNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soActCustSeq =	this.soActCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPsonNm =	this.cntcPsonNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcFaxNo =	this.cntcFaxNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actShprPhnNo =	this.actShprPhnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnTroFlg =	this.rtnTroFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd =	this.rcvTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcMphnNo =	this.cntcMphnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt =	this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstDt =	this.rqstDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlFlgOld =	this.cxlFlgOld.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorPstNo =	this.dorPstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soFlg =	this.soFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troSeq =	this.troSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmDt =	this.cfmDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorLocCd =	this.dorLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd =	this.ioBndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmFlg =	this.cfmFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.returnCyNo =	this.returnCyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo =	this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk =	this.diffRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bizRgstNo =	this.bizRgstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ackStsCd =	this.ackStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmFlgOld =	this.cfmFlgOld.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pickupCyNo =	this.pickupCyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actShprCntCd =	this.actShprCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actShprNm =	this.actShprNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actShprAddr =	this.actShprAddr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actShprSeq =	this.actShprSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isEur =	this.isEur.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTrspModCd =	this.bkgTrspModCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}