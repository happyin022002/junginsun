/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : TroDtlVO.java
 *@FileTitle : TroDtlVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.07.26
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2016.07.26  
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
public class TroDtlVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<TroDtlVO>  models =	new	ArrayList<TroDtlVO>();


	/*	Column Info	*/
	private  String	 dorArrDt   =  null;
	/*	Column Info	*/
	private  String	 cxlFlg   =  null;
	/*	Column Info	*/
	private  String	 creDt   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 pctlNo   =  null;
	/*	Column Info	*/
	private  String	 pkupYdCd   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 cmdtCd   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd   =  null;
	/*	Column Info	*/
	private  String	 del   =  null;
	/*	Column Info	*/
	private  String	 rtnTroFlg   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 pkupLocCd   =  null;
	/*	Column Info	*/
	private  String	 updDt   =  null;
	/*	Column Info	*/
	private  String	 troQty   =  null;
	/*	Column Info	*/
	private  String	 troSubSeq   =  null;
	/*	Column Info	*/
	private  String	 cxlFlgOld   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCdOld   =  null;
	/*	Column Info	*/
	private  String	 troSeq   =  null;
	/*	Column Info	*/
	private  String	 rtnYdCd   =  null;
	/*	Column Info	*/
	private  String	 soUsrNm   =  null;
	/*	Column Info	*/
	private  String	 ioBndCd   =  null;
	/*	Column Info	*/
	private  String	 soCreDt   =  null;
	/*	Column Info	*/
	private  String	 cmdtNm   =  null;
	/*	Column Info	*/
	private  String	 bkgNo   =  null;
	/*	Column Info	*/
	private  String	 rtnLocCd   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;
	/*	Column Info	*/
	private  String	 soCreUsrId   =  null;
	/*	Column Info	*/
	private  String	 trspSoNo   =  null;
	/*	Column Info	*/
	private  String	 dorArrDtHhmi   =  null;
	/*	Column Info	*/
	private  String	 cntrNo   =  null;
	/*	Column Info	*/
	private  String	 troQtyOld   =  null;
	/*	Column Info	*/
	private  String	 frFlg   =  null;
	/*	Column Info	*/
	private  String	 splitRmk   =  null;
	/*	Column Info	*/
	private  String	 trspWoNo   =  null;
	/*	Column Info	*/
	private  String	 trspWoOfcCtyCd   =  null;
	/*	Column Info	*/
	private  String	 trspWoSeq   =  null;
	/*	Column Info	*/
	private  String	 rtnDt   =  null;
	/*	Column Info	*/
	private  String	 bkgTrspModCd   =  null;
	/*	Column Info	*/
	private  String	 dorAddrTpCd   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new HashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new HashMap<String, String>();
 
 
	/**	Constructor	*/
	public TroDtlVO(){}

	public TroDtlVO(String dorArrDt,String cxlFlg,String creDt,String pagerows,String pctlNo,String pkupYdCd,String ibflag,String cmdtCd,String cntrTpszCd,String del,String rtnTroFlg,String updUsrId,String pkupLocCd,String updDt,String troQty,String troSubSeq,String cxlFlgOld,String cntrTpszCdOld,String troSeq,String rtnYdCd,String soUsrNm,String ioBndCd,String soCreDt,String cmdtNm,String bkgNo,String rtnLocCd,String creUsrId,String soCreUsrId,String trspSoNo,String dorArrDtHhmi,String cntrNo,String troQtyOld,String frFlg,String splitRmk,String trspWoNo,String trspWoOfcCtyCd,String trspWoSeq,String rtnDt,String bkgTrspModCd,String dorAddrTpCd)	{
		this.dorArrDt  = dorArrDt ;
		this.cxlFlg  = cxlFlg ;
		this.creDt  = creDt ;
		this.pagerows  = pagerows ;
		this.pctlNo  = pctlNo ;
		this.pkupYdCd  = pkupYdCd ;
		this.ibflag  = ibflag ;
		this.cmdtCd  = cmdtCd ;
		this.cntrTpszCd  = cntrTpszCd ;
		this.del  = del ;
		this.rtnTroFlg  = rtnTroFlg ;
		this.updUsrId  = updUsrId ;
		this.pkupLocCd  = pkupLocCd ;
		this.updDt  = updDt ;
		this.troQty  = troQty ;
		this.troSubSeq  = troSubSeq ;
		this.cxlFlgOld  = cxlFlgOld ;
		this.cntrTpszCdOld  = cntrTpszCdOld ;
		this.troSeq  = troSeq ;
		this.rtnYdCd  = rtnYdCd ;
		this.soUsrNm  = soUsrNm ;
		this.ioBndCd  = ioBndCd ;
		this.soCreDt  = soCreDt ;
		this.cmdtNm  = cmdtNm ;
		this.bkgNo  = bkgNo ;
		this.rtnLocCd  = rtnLocCd ;
		this.creUsrId  = creUsrId ;
		this.soCreUsrId  = soCreUsrId ;
		this.trspSoNo  = trspSoNo ;
		this.dorArrDtHhmi  = dorArrDtHhmi ;
		this.cntrNo  = cntrNo ;
		this.troQtyOld  = troQtyOld ;
		this.frFlg  = frFlg ;
		this.splitRmk  = splitRmk ;
		this.trspWoNo  = trspWoNo ;
		this.trspWoOfcCtyCd  = trspWoOfcCtyCd ;
		this.trspWoSeq  = trspWoSeq ;
		this.rtnDt  = rtnDt ;
		this.bkgTrspModCd  = bkgTrspModCd ;
		this.dorAddrTpCd  = dorAddrTpCd ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dor_arr_dt", getDorArrDt());		
		this.hashColumns.put("cxl_flg", getCxlFlg());		
		this.hashColumns.put("cre_dt", getCreDt());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("pctl_no", getPctlNo());		
		this.hashColumns.put("pkup_yd_cd", getPkupYdCd());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("cmdt_cd", getCmdtCd());		
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());		
		this.hashColumns.put("del", getDel());		
		this.hashColumns.put("rtn_tro_flg", getRtnTroFlg());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("pkup_loc_cd", getPkupLocCd());		
		this.hashColumns.put("upd_dt", getUpdDt());		
		this.hashColumns.put("tro_qty", getTroQty());		
		this.hashColumns.put("tro_sub_seq", getTroSubSeq());		
		this.hashColumns.put("cxl_flg_old", getCxlFlgOld());		
		this.hashColumns.put("cntr_tpsz_cd_old", getCntrTpszCdOld());		
		this.hashColumns.put("tro_seq", getTroSeq());		
		this.hashColumns.put("rtn_yd_cd", getRtnYdCd());		
		this.hashColumns.put("so_usr_nm", getSoUsrNm());		
		this.hashColumns.put("io_bnd_cd", getIoBndCd());		
		this.hashColumns.put("so_cre_dt", getSoCreDt());		
		this.hashColumns.put("cmdt_nm", getCmdtNm());		
		this.hashColumns.put("bkg_no", getBkgNo());		
		this.hashColumns.put("rtn_loc_cd", getRtnLocCd());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("so_cre_usr_id", getSoCreUsrId());		
		this.hashColumns.put("trsp_so_no", getTrspSoNo());		
		this.hashColumns.put("dor_arr_dt_hhmi", getDorArrDtHhmi());		
		this.hashColumns.put("cntr_no", getCntrNo());		
		this.hashColumns.put("tro_qty_old", getTroQtyOld());		
		this.hashColumns.put("fr_flg", getFrFlg());		
		this.hashColumns.put("split_rmk", getSplitRmk());		
		this.hashColumns.put("trsp_wo_no", getTrspWoNo());		
		this.hashColumns.put("trsp_wo_ofc_cty_cd", getTrspWoOfcCtyCd());		
		this.hashColumns.put("trsp_wo_seq", getTrspWoSeq());		
		this.hashColumns.put("rtn_dt", getRtnDt());		
		this.hashColumns.put("bkg_trsp_mod_cd", getBkgTrspModCd());		
		this.hashColumns.put("dor_addr_tp_cd", getDorAddrTpCd());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("dor_arr_dt", "dorArrDt");
		this.hashFields.put("cxl_flg", "cxlFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pctl_no", "pctlNo");
		this.hashFields.put("pkup_yd_cd", "pkupYdCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("del", "del");
		this.hashFields.put("rtn_tro_flg", "rtnTroFlg");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("pkup_loc_cd", "pkupLocCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("tro_qty", "troQty");
		this.hashFields.put("tro_sub_seq", "troSubSeq");
		this.hashFields.put("cxl_flg_old", "cxlFlgOld");
		this.hashFields.put("cntr_tpsz_cd_old", "cntrTpszCdOld");
		this.hashFields.put("tro_seq", "troSeq");
		this.hashFields.put("rtn_yd_cd", "rtnYdCd");
		this.hashFields.put("so_usr_nm", "soUsrNm");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("so_cre_dt", "soCreDt");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("rtn_loc_cd", "rtnLocCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("so_cre_usr_id", "soCreUsrId");
		this.hashFields.put("trsp_so_no", "trspSoNo");
		this.hashFields.put("dor_arr_dt_hhmi", "dorArrDtHhmi");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("tro_qty_old", "troQtyOld");
		this.hashFields.put("fr_flg", "frFlg");
		this.hashFields.put("split_rmk", "splitRmk");
		this.hashFields.put("trsp_wo_no", "trspWoNo");
		this.hashFields.put("trsp_wo_ofc_cty_cd", "trspWoOfcCtyCd");
		this.hashFields.put("trsp_wo_seq", "trspWoSeq");
		this.hashFields.put("rtn_dt", "rtnDt");
		this.hashFields.put("bkg_trsp_mod_cd", "bkgTrspModCd");
		this.hashFields.put("dor_addr_tp_cd", "dorAddrTpCd");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  dorArrDt
	*/
	public void	setDorArrDt( String	dorArrDt ) {
		this.dorArrDt =	dorArrDt;
	}
 
	/**
	 * Column Info
	 * @return	dorArrDt
	 */
	 public	String	getDorArrDt() {
		 return	this.dorArrDt;
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
	* @param  pkupYdCd
	*/
	public void	setPkupYdCd( String	pkupYdCd ) {
		this.pkupYdCd =	pkupYdCd;
	}
 
	/**
	 * Column Info
	 * @return	pkupYdCd
	 */
	 public	String	getPkupYdCd() {
		 return	this.pkupYdCd;
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
	* @param  cmdtCd
	*/
	public void	setCmdtCd( String	cmdtCd ) {
		this.cmdtCd =	cmdtCd;
	}
 
	/**
	 * Column Info
	 * @return	cmdtCd
	 */
	 public	String	getCmdtCd() {
		 return	this.cmdtCd;
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
	 public	String	getCntrTpszCd() {
		 return	this.cntrTpszCd;
	 } 
 	/**
	* Column Info
	* @param  del
	*/
	public void	setDel( String	del ) {
		this.del =	del;
	}
 
	/**
	 * Column Info
	 * @return	del
	 */
	 public	String	getDel() {
		 return	this.del;
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
	* @param  pkupLocCd
	*/
	public void	setPkupLocCd( String	pkupLocCd ) {
		this.pkupLocCd =	pkupLocCd;
	}
 
	/**
	 * Column Info
	 * @return	pkupLocCd
	 */
	 public	String	getPkupLocCd() {
		 return	this.pkupLocCd;
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
	* @param  troQty
	*/
	public void	setTroQty( String	troQty ) {
		this.troQty =	troQty;
	}
 
	/**
	 * Column Info
	 * @return	troQty
	 */
	 public	String	getTroQty() {
		 return	this.troQty;
	 } 
 	/**
	* Column Info
	* @param  troSubSeq
	*/
	public void	setTroSubSeq( String	troSubSeq ) {
		this.troSubSeq =	troSubSeq;
	}
 
	/**
	 * Column Info
	 * @return	troSubSeq
	 */
	 public	String	getTroSubSeq() {
		 return	this.troSubSeq;
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
	* @param  cntrTpszCdOld
	*/
	public void	setCntrTpszCdOld( String	cntrTpszCdOld ) {
		this.cntrTpszCdOld =	cntrTpszCdOld;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCdOld
	 */
	 public	String	getCntrTpszCdOld() {
		 return	this.cntrTpszCdOld;
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
	* @param  rtnYdCd
	*/
	public void	setRtnYdCd( String	rtnYdCd ) {
		this.rtnYdCd =	rtnYdCd;
	}
 
	/**
	 * Column Info
	 * @return	rtnYdCd
	 */
	 public	String	getRtnYdCd() {
		 return	this.rtnYdCd;
	 } 
 	/**
	* Column Info
	* @param  soUsrNm
	*/
	public void	setSoUsrNm( String	soUsrNm ) {
		this.soUsrNm =	soUsrNm;
	}
 
	/**
	 * Column Info
	 * @return	soUsrNm
	 */
	 public	String	getSoUsrNm() {
		 return	this.soUsrNm;
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
	* @param  soCreDt
	*/
	public void	setSoCreDt( String	soCreDt ) {
		this.soCreDt =	soCreDt;
	}
 
	/**
	 * Column Info
	 * @return	soCreDt
	 */
	 public	String	getSoCreDt() {
		 return	this.soCreDt;
	 } 
 	/**
	* Column Info
	* @param  cmdtNm
	*/
	public void	setCmdtNm( String	cmdtNm ) {
		this.cmdtNm =	cmdtNm;
	}
 
	/**
	 * Column Info
	 * @return	cmdtNm
	 */
	 public	String	getCmdtNm() {
		 return	this.cmdtNm;
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
	* @param  rtnLocCd
	*/
	public void	setRtnLocCd( String	rtnLocCd ) {
		this.rtnLocCd =	rtnLocCd;
	}
 
	/**
	 * Column Info
	 * @return	rtnLocCd
	 */
	 public	String	getRtnLocCd() {
		 return	this.rtnLocCd;
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
	* @param  soCreUsrId
	*/
	public void	setSoCreUsrId( String	soCreUsrId ) {
		this.soCreUsrId =	soCreUsrId;
	}
 
	/**
	 * Column Info
	 * @return	soCreUsrId
	 */
	 public	String	getSoCreUsrId() {
		 return	this.soCreUsrId;
	 } 
 	/**
	* Column Info
	* @param  trspSoNo
	*/
	public void	setTrspSoNo( String	trspSoNo ) {
		this.trspSoNo =	trspSoNo;
	}
 
	/**
	 * Column Info
	 * @return	trspSoNo
	 */
	 public	String	getTrspSoNo() {
		 return	this.trspSoNo;
	 } 
 	/**
	* Column Info
	* @param  dorArrDtHhmi
	*/
	public void	setDorArrDtHhmi( String	dorArrDtHhmi ) {
		this.dorArrDtHhmi =	dorArrDtHhmi;
	}
 
	/**
	 * Column Info
	 * @return	dorArrDtHhmi
	 */
	 public	String	getDorArrDtHhmi() {
		 return	this.dorArrDtHhmi;
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
	 public	String	getCntrNo() {
		 return	this.cntrNo;
	 } 
 	/**
	* Column Info
	* @param  troQtyOld
	*/
	public void	setTroQtyOld( String	troQtyOld ) {
		this.troQtyOld =	troQtyOld;
	}
 
	/**
	 * Column Info
	 * @return	troQtyOld
	 */
	 public	String	getTroQtyOld() {
		 return	this.troQtyOld;
	 } 
 	/**
	* Column Info
	* @param  frFlg
	*/
	public void	setFrFlg( String	frFlg ) {
		this.frFlg =	frFlg;
	}
 
	/**
	 * Column Info
	 * @return	frFlg
	 */
	 public	String	getFrFlg() {
		 return	this.frFlg;
	 } 
 	/**
	* Column Info
	* @param  splitRmk
	*/
	public void	setSplitRmk( String	splitRmk ) {
		this.splitRmk =	splitRmk;
	}
 
	/**
	 * Column Info
	 * @return	splitRmk
	 */
	 public	String	getSplitRmk() {
		 return	this.splitRmk;
	 } 
 	/**
	* Column Info
	* @param  trspWoNo
	*/
	public void	setTrspWoNo( String	trspWoNo ) {
		this.trspWoNo =	trspWoNo;
	}
 
	/**
	 * Column Info
	 * @return	trspWoNo
	 */
	 public	String	getTrspWoNo() {
		 return	this.trspWoNo;
	 } 
 	/**
	* Column Info
	* @param  trspWoOfcCtyCd
	*/
	public void	setTrspWoOfcCtyCd( String	trspWoOfcCtyCd ) {
		this.trspWoOfcCtyCd =	trspWoOfcCtyCd;
	}
 
	/**
	 * Column Info
	 * @return	trspWoOfcCtyCd
	 */
	 public	String	getTrspWoOfcCtyCd() {
		 return	this.trspWoOfcCtyCd;
	 } 
 	/**
	* Column Info
	* @param  trspWoSeq
	*/
	public void	setTrspWoSeq( String	trspWoSeq ) {
		this.trspWoSeq =	trspWoSeq;
	}
 
	/**
	 * Column Info
	 * @return	trspWoSeq
	 */
	 public	String	getTrspWoSeq() {
		 return	this.trspWoSeq;
	 } 
 	/**
	* Column Info
	* @param  rtnDt
	*/
	public void	setRtnDt( String	rtnDt ) {
		this.rtnDt =	rtnDt;
	}
 
	/**
	 * Column Info
	 * @return	rtnDt
	 */
	 public	String	getRtnDt() {
		 return	this.rtnDt;
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
	* Column Info
	* @param  dorAddrTpCd
	*/
	public void	setDorAddrTpCd( String	dorAddrTpCd ) {
		this.dorAddrTpCd =	dorAddrTpCd;
	}
 
	/**
	 * Column Info
	 * @return	dorAddrTpCd
	 */
	 public	String	getDorAddrTpCd() {
		 return	this.dorAddrTpCd;
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
		setDorArrDt(JSPUtil.getParameter(request,	prefix + "dor_arr_dt", ""));
		setCxlFlg(JSPUtil.getParameter(request,	prefix + "cxl_flg", ""));
		setCreDt(JSPUtil.getParameter(request,	prefix + "cre_dt", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setPctlNo(JSPUtil.getParameter(request,	prefix + "pctl_no", ""));
		setPkupYdCd(JSPUtil.getParameter(request,	prefix + "pkup_yd_cd", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setCmdtCd(JSPUtil.getParameter(request,	prefix + "cmdt_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd", ""));
		setDel(JSPUtil.getParameter(request,	prefix + "del", ""));
		setRtnTroFlg(JSPUtil.getParameter(request,	prefix + "rtn_tro_flg", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setPkupLocCd(JSPUtil.getParameter(request,	prefix + "pkup_loc_cd", ""));
		setUpdDt(JSPUtil.getParameter(request,	prefix + "upd_dt", ""));
		setTroQty(JSPUtil.getParameter(request,	prefix + "tro_qty", ""));
		setTroSubSeq(JSPUtil.getParameter(request,	prefix + "tro_sub_seq", ""));
		setCxlFlgOld(JSPUtil.getParameter(request,	prefix + "cxl_flg_old", ""));
		setCntrTpszCdOld(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd_old", ""));
		setTroSeq(JSPUtil.getParameter(request,	prefix + "tro_seq", ""));
		setRtnYdCd(JSPUtil.getParameter(request,	prefix + "rtn_yd_cd", ""));
		setSoUsrNm(JSPUtil.getParameter(request,	prefix + "so_usr_nm", ""));
		setIoBndCd(JSPUtil.getParameter(request,	prefix + "io_bnd_cd", ""));
		setSoCreDt(JSPUtil.getParameter(request,	prefix + "so_cre_dt", ""));
		setCmdtNm(JSPUtil.getParameter(request,	prefix + "cmdt_nm", ""));
		setBkgNo(JSPUtil.getParameter(request,	prefix + "bkg_no", ""));
		setRtnLocCd(JSPUtil.getParameter(request,	prefix + "rtn_loc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setSoCreUsrId(JSPUtil.getParameter(request,	prefix + "so_cre_usr_id", ""));
		setTrspSoNo(JSPUtil.getParameter(request,	prefix + "trsp_so_no", ""));
		setDorArrDtHhmi(JSPUtil.getParameter(request,	prefix + "dor_arr_dt_hhmi", ""));
		setCntrNo(JSPUtil.getParameter(request,	prefix + "cntr_no", ""));
		setTroQtyOld(JSPUtil.getParameter(request,	prefix + "tro_qty_old", ""));
		setFrFlg(JSPUtil.getParameter(request,	prefix + "fr_flg", ""));
		setSplitRmk(JSPUtil.getParameter(request,	prefix + "split_rmk", ""));
		setTrspWoNo(JSPUtil.getParameter(request,	prefix + "trsp_wo_no", ""));
		setTrspWoOfcCtyCd(JSPUtil.getParameter(request,	prefix + "trsp_wo_ofc_cty_cd", ""));
		setTrspWoSeq(JSPUtil.getParameter(request,	prefix + "trsp_wo_seq", ""));
		setRtnDt(JSPUtil.getParameter(request,	prefix + "rtn_dt", ""));
		setBkgTrspModCd(JSPUtil.getParameter(request,	prefix + "bkg_trsp_mod_cd", ""));
		setDorAddrTpCd(JSPUtil.getParameter(request,	prefix + "dor_addr_tp_cd", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TroDtlVO[]
	 */
	public TroDtlVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return TroDtlVO[]
	 */
	public TroDtlVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		TroDtlVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] dorArrDt =	(JSPUtil.getParameter(request, prefix +	"dor_arr_dt".trim(),	length));
				String[] cxlFlg =	(JSPUtil.getParameter(request, prefix +	"cxl_flg".trim(),	length));
				String[] creDt =	(JSPUtil.getParameter(request, prefix +	"cre_dt".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] pctlNo =	(JSPUtil.getParameter(request, prefix +	"pctl_no".trim(),	length));
				String[] pkupYdCd =	(JSPUtil.getParameter(request, prefix +	"pkup_yd_cd".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] cmdtCd =	(JSPUtil.getParameter(request, prefix +	"cmdt_cd".trim(),	length));
				String[] cntrTpszCd =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd".trim(),	length));
				String[] del =	(JSPUtil.getParameter(request, prefix +	"del".trim(),	length));
				String[] rtnTroFlg =	(JSPUtil.getParameter(request, prefix +	"rtn_tro_flg".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] pkupLocCd =	(JSPUtil.getParameter(request, prefix +	"pkup_loc_cd".trim(),	length));
				String[] updDt =	(JSPUtil.getParameter(request, prefix +	"upd_dt".trim(),	length));
				String[] troQty =	(JSPUtil.getParameter(request, prefix +	"tro_qty".trim(),	length));
				String[] troSubSeq =	(JSPUtil.getParameter(request, prefix +	"tro_sub_seq".trim(),	length));
				String[] cxlFlgOld =	(JSPUtil.getParameter(request, prefix +	"cxl_flg_old".trim(),	length));
				String[] cntrTpszCdOld =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd_old".trim(),	length));
				String[] troSeq =	(JSPUtil.getParameter(request, prefix +	"tro_seq".trim(),	length));
				String[] rtnYdCd =	(JSPUtil.getParameter(request, prefix +	"rtn_yd_cd".trim(),	length));
				String[] soUsrNm =	(JSPUtil.getParameter(request, prefix +	"so_usr_nm".trim(),	length));
				String[] ioBndCd =	(JSPUtil.getParameter(request, prefix +	"io_bnd_cd".trim(),	length));
				String[] soCreDt =	(JSPUtil.getParameter(request, prefix +	"so_cre_dt".trim(),	length));
				String[] cmdtNm =	(JSPUtil.getParameter(request, prefix +	"cmdt_nm".trim(),	length));
				String[] bkgNo =	(JSPUtil.getParameter(request, prefix +	"bkg_no".trim(),	length));
				String[] rtnLocCd =	(JSPUtil.getParameter(request, prefix +	"rtn_loc_cd".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				String[] soCreUsrId =	(JSPUtil.getParameter(request, prefix +	"so_cre_usr_id".trim(),	length));
				String[] trspSoNo =	(JSPUtil.getParameter(request, prefix +	"trsp_so_no".trim(),	length));
				String[] dorArrDtHhmi =	(JSPUtil.getParameter(request, prefix +	"dor_arr_dt_hhmi".trim(),	length));
				String[] cntrNo =	(JSPUtil.getParameter(request, prefix +	"cntr_no".trim(),	length));
				String[] troQtyOld =	(JSPUtil.getParameter(request, prefix +	"tro_qty_old".trim(),	length));
				String[] frFlg =	(JSPUtil.getParameter(request, prefix +	"fr_flg".trim(),	length));
				String[] splitRmk =	(JSPUtil.getParameter(request, prefix +	"split_rmk".trim(),	length));
				String[] trspWoNo =	(JSPUtil.getParameter(request, prefix +	"trsp_wo_no".trim(),	length));
				String[] trspWoOfcCtyCd =	(JSPUtil.getParameter(request, prefix +	"trsp_wo_ofc_cty_cd".trim(),	length));
				String[] trspWoSeq =	(JSPUtil.getParameter(request, prefix +	"trsp_wo_seq".trim(),	length));
				String[] rtnDt =	(JSPUtil.getParameter(request, prefix +	"rtn_dt".trim(),	length));
				String[] bkgTrspModCd =	(JSPUtil.getParameter(request, prefix +	"bkg_trsp_mod_cd".trim(),	length));
				String[] dorAddrTpCd =	(JSPUtil.getParameter(request, prefix +	"dor_addr_tp_cd".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	TroDtlVO();
						if ( dorArrDt[i] !=	null)
						model.setDorArrDt( dorArrDt[i]);
						if ( cxlFlg[i] !=	null)
						model.setCxlFlg( cxlFlg[i]);
						if ( creDt[i] !=	null)
						model.setCreDt( creDt[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( pctlNo[i] !=	null)
						model.setPctlNo( pctlNo[i]);
						if ( pkupYdCd[i] !=	null)
						model.setPkupYdCd( pkupYdCd[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( cmdtCd[i] !=	null)
						model.setCmdtCd( cmdtCd[i]);
						if ( cntrTpszCd[i] !=	null)
						model.setCntrTpszCd( cntrTpszCd[i]);
						if ( del[i] !=	null)
						model.setDel( del[i]);
						if ( rtnTroFlg[i] !=	null)
						model.setRtnTroFlg( rtnTroFlg[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( pkupLocCd[i] !=	null)
						model.setPkupLocCd( pkupLocCd[i]);
						if ( updDt[i] !=	null)
						model.setUpdDt( updDt[i]);
						if ( troQty[i] !=	null)
						model.setTroQty( troQty[i]);
						if ( troSubSeq[i] !=	null)
						model.setTroSubSeq( troSubSeq[i]);
						if ( cxlFlgOld[i] !=	null)
						model.setCxlFlgOld( cxlFlgOld[i]);
						if ( cntrTpszCdOld[i] !=	null)
						model.setCntrTpszCdOld( cntrTpszCdOld[i]);
						if ( troSeq[i] !=	null)
						model.setTroSeq( troSeq[i]);
						if ( rtnYdCd[i] !=	null)
						model.setRtnYdCd( rtnYdCd[i]);
						if ( soUsrNm[i] !=	null)
						model.setSoUsrNm( soUsrNm[i]);
						if ( ioBndCd[i] !=	null)
						model.setIoBndCd( ioBndCd[i]);
						if ( soCreDt[i] !=	null)
						model.setSoCreDt( soCreDt[i]);
						if ( cmdtNm[i] !=	null)
						model.setCmdtNm( cmdtNm[i]);
						if ( bkgNo[i] !=	null)
						model.setBkgNo( bkgNo[i]);
						if ( rtnLocCd[i] !=	null)
						model.setRtnLocCd( rtnLocCd[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
						if ( soCreUsrId[i] !=	null)
						model.setSoCreUsrId( soCreUsrId[i]);
						if ( trspSoNo[i] !=	null)
						model.setTrspSoNo( trspSoNo[i]);
						if ( dorArrDtHhmi[i] !=	null)
						model.setDorArrDtHhmi( dorArrDtHhmi[i]);
						if ( cntrNo[i] !=	null)
						model.setCntrNo( cntrNo[i]);
						if ( troQtyOld[i] !=	null)
						model.setTroQtyOld( troQtyOld[i]);
						if ( frFlg[i] !=	null)
						model.setFrFlg( frFlg[i]);
						if ( splitRmk[i] !=	null)
						model.setSplitRmk( splitRmk[i]);
						if ( trspWoNo[i] !=	null)
						model.setTrspWoNo( trspWoNo[i]);
						if ( trspWoOfcCtyCd[i] !=	null)
						model.setTrspWoOfcCtyCd( trspWoOfcCtyCd[i]);
						if ( trspWoSeq[i] !=	null)
						model.setTrspWoSeq( trspWoSeq[i]);
						if ( rtnDt[i] !=	null)
						model.setRtnDt( rtnDt[i]);
						if ( bkgTrspModCd[i] !=	null)
						model.setBkgTrspModCd( bkgTrspModCd[i]);
						if ( dorAddrTpCd[i] !=	null)
						model.setDorAddrTpCd( dorAddrTpCd[i]);
					models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getTroDtlVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return TroDtlVO[]
	 */
	public TroDtlVO[]	 getTroDtlVOs(){
		TroDtlVO[] vos = (TroDtlVO[])models.toArray(new	TroDtlVO[models.size()]);
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
		this.dorArrDt =	this.dorArrDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlFlg =	this.cxlFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt =	this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pctlNo =	this.pctlNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupYdCd =	this.pkupYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd =	this.cmdtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd =	this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.del =	this.del.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnTroFlg =	this.rtnTroFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupLocCd =	this.pkupLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt =	this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troQty =	this.troQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troSubSeq =	this.troSubSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlFlgOld =	this.cxlFlgOld.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCdOld =	this.cntrTpszCdOld.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troSeq =	this.troSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnYdCd =	this.rtnYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soUsrNm =	this.soUsrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd =	this.ioBndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soCreDt =	this.soCreDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm =	this.cmdtNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo =	this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnLocCd =	this.rtnLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soCreUsrId =	this.soCreUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoNo =	this.trspSoNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorArrDtHhmi =	this.dorArrDtHhmi.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo =	this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troQtyOld =	this.troQtyOld.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frFlg =	this.frFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splitRmk =	this.splitRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspWoNo =	this.trspWoNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspWoOfcCtyCd =	this.trspWoOfcCtyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspWoSeq =	this.trspWoSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnDt =	this.rtnDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTrspModCd =	this.bkgTrspModCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorAddrTpCd =	this.dorAddrTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}