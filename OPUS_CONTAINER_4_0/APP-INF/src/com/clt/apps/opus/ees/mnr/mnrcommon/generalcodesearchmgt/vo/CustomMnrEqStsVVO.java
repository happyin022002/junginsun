/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : CustomMnrEqStsVVO.java
 *@FileTitle : CustomMnrEqStsVVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.11.03
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2014.11.03  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo;

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
public class CustomMnrEqStsVVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<CustomMnrEqStsVVO>  models =	new	ArrayList<CustomMnrEqStsVVO>();


	/*	Column Info	*/
	private  String	 rprCostAmt   =  null;
	/*	Column Info	*/
	private  String	 mnrHngrTrfOtrDesc   =  null;
	/*	Column Info	*/
	private  String	 hngrFlgYd   =  null;
	/*	Column Info	*/
	private  String	 manuDt   =  null;
	/*	Column Info	*/
	private  String	 dppAmt   =  null;
	/*	Column Info	*/
	private  String	 spName   =  null;
	/*	Column Info	*/
	private  String	 mtrlNm   =  null;
	/*	Column Info	*/
	private  String	 mkrNm   =  null;
	/*	Column Info	*/
	private  String	 rprType   =  null;
	/*	Column Info	*/
	private  String	 crntYdCd   =  null;
	/*	Column Info	*/
	private  String	 rprYd   =  null;
	/*	Column Info	*/
	private  String	 immExt   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 dvCur   =  null;
	/*	Column Info	*/
	private  String	 barAtchKnt   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 hngrRckCd   =  null;
	/*	Column Info	*/
	private  String	 eqNo   =  null;
	/*	Column Info	*/
	private  String	 mnrLostHngrQty   =  null;
	/*	Column Info	*/
	private  String	 mnrDispHngrQty   =  null;
	/*	Column Info	*/
	private  String	 lstmCd   =  null;
	/*	Column Info	*/
	private  String	 mdlNm   =  null;
	/*	Column Info	*/
	private  String	 barTpCd   =  null;
	/*	Column Info	*/
	private  String	 status   =  null;
	/*	Column Info	*/
	private  String	 mvmtCd   =  null;
	/*	Column Info	*/
	private  String	 dspFlag   =  null;
	/*	Column Info	*/
	private  String	 cost   =  null;
	/*	Column Info	*/
	private  String	 actInvtQty   =  null;
	/*	Column Info	*/
	private  String	 eqType   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCd   =  null;
	/*	Column Info	*/
	private  String	 flgRmk   =  null;
	/*	Column Info	*/
	private  String	 dvValue   =  null;
	/*	Column Info	*/
	private  String	 dmgFlag   =  null;
	/*	Column Info	*/
	private  String	 rprDt   =  null;
	/*	Column Info	*/
	private  String	 offHire   =  null;
	/*	Column Info	*/
	private  String	 hngrFlgDt   =  null;
	/*	Column Info	*/
	private  String	 mnrHngrDmgQty   =  null;
	/*	Column Info	*/
	private  String	 mnrHngrTrfCd   =  null;
	/*	Column Info	*/
	private  String	 lessorNm   =  null;
	/*	Column Info	*/
	private  String	 totalLossDate   =  null;
	/*	Column Info	*/
	private  String	 mvmtDt   =  null;
	/*	Column Info	*/
	private  String	 mtrlCd   =  null;
	/*	Column Info	*/
	private  String	 rstrUsgLblNm   =  null;
	/* Column Info */
	private String lessorCd = null;
	/* Column Info */
	private String actInd = null;
	/*	Column Info	*/
	private  String	 rstrUsgLblTp   =  null;
	/*	Column Info	*/
	private  String	 rstrUsgLblVal   =  null;
	/*	Column Info	*/
	private  String	 cntrStsCd   =  null;
	
	
	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public CustomMnrEqStsVVO(){}

	public CustomMnrEqStsVVO(String rprCostAmt,String mnrHngrTrfOtrDesc,String hngrFlgYd,String manuDt,String dppAmt,String spName,String mtrlNm,String mkrNm,String rprType,String crntYdCd,String rprYd,String immExt,String pagerows,String dvCur,String barAtchKnt,String ibflag,String hngrRckCd,String eqNo,String mnrLostHngrQty,String mnrDispHngrQty,String lstmCd,String mdlNm,String barTpCd,String status,String mvmtCd,String dspFlag,String cost,String actInvtQty,String eqType,String eqTpszCd,String flgRmk,String dvValue,String dmgFlag,String rprDt,String offHire,String hngrFlgDt,String mnrHngrDmgQty,String mnrHngrTrfCd,String lessorNm,String totalLossDate,String mvmtDt,String mtrlCd,String rstrUsgLblNm, String lessorCd, String actInd, String rstrUsgLblTp, String rstrUsgLblVal, String cntrStsCd)	{
		this.rprCostAmt  = rprCostAmt ;
		this.mnrHngrTrfOtrDesc  = mnrHngrTrfOtrDesc ;
		this.hngrFlgYd  = hngrFlgYd ;
		this.manuDt  = manuDt ;
		this.dppAmt  = dppAmt ;
		this.spName  = spName ;
		this.mtrlNm  = mtrlNm ;
		this.mkrNm  = mkrNm ;
		this.rprType  = rprType ;
		this.crntYdCd  = crntYdCd ;
		this.rprYd  = rprYd ;
		this.immExt  = immExt ;
		this.pagerows  = pagerows ;
		this.dvCur  = dvCur ;
		this.barAtchKnt  = barAtchKnt ;
		this.ibflag  = ibflag ;
		this.hngrRckCd  = hngrRckCd ;
		this.eqNo  = eqNo ;
		this.mnrLostHngrQty  = mnrLostHngrQty ;
		this.mnrDispHngrQty  = mnrDispHngrQty ;
		this.lstmCd  = lstmCd ;
		this.mdlNm  = mdlNm ;
		this.barTpCd  = barTpCd ;
		this.status  = status ;
		this.mvmtCd  = mvmtCd ;
		this.dspFlag  = dspFlag ;
		this.cost  = cost ;
		this.actInvtQty  = actInvtQty ;
		this.eqType  = eqType ;
		this.eqTpszCd  = eqTpszCd ;
		this.flgRmk  = flgRmk ;
		this.dvValue  = dvValue ;
		this.dmgFlag  = dmgFlag ;
		this.rprDt  = rprDt ;
		this.offHire  = offHire ;
		this.hngrFlgDt  = hngrFlgDt ;
		this.mnrHngrDmgQty  = mnrHngrDmgQty ;
		this.mnrHngrTrfCd  = mnrHngrTrfCd ;
		this.lessorNm  = lessorNm ;
		this.totalLossDate  = totalLossDate ;
		this.mvmtDt  = mvmtDt ;
		this.mtrlCd  = mtrlCd ;
		this.rstrUsgLblNm  = rstrUsgLblNm ;
		this.lessorCd = lessorCd;
		this.actInd = actInd;
		this.rstrUsgLblTp = rstrUsgLblTp;
		this.rstrUsgLblVal = rstrUsgLblVal;
		this.cntrStsCd = cntrStsCd;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rpr_cost_amt", getRprCostAmt());		
		this.hashColumns.put("mnr_hngr_trf_otr_desc", getMnrHngrTrfOtrDesc());		
		this.hashColumns.put("hngr_flg_yd", getHngrFlgYd());		
		this.hashColumns.put("manu_dt", getManuDt());		
		this.hashColumns.put("dpp_amt", getDppAmt());		
		this.hashColumns.put("sp_name", getSpName());		
		this.hashColumns.put("mtrl_nm", getMtrlNm());		
		this.hashColumns.put("mkr_nm", getMkrNm());		
		this.hashColumns.put("rpr_type", getRprType());		
		this.hashColumns.put("crnt_yd_cd", getCrntYdCd());		
		this.hashColumns.put("rpr_yd", getRprYd());		
		this.hashColumns.put("imm_ext", getImmExt());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("dv_cur", getDvCur());		
		this.hashColumns.put("bar_atch_knt", getBarAtchKnt());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("hngr_rck_cd", getHngrRckCd());		
		this.hashColumns.put("eq_no", getEqNo());		
		this.hashColumns.put("mnr_lost_hngr_qty", getMnrLostHngrQty());		
		this.hashColumns.put("mnr_disp_hngr_qty", getMnrDispHngrQty());		
		this.hashColumns.put("lstm_cd", getLstmCd());		
		this.hashColumns.put("mdl_nm", getMdlNm());		
		this.hashColumns.put("bar_tp_cd", getBarTpCd());		
		this.hashColumns.put("status", getStatus());		
		this.hashColumns.put("mvmt_cd", getMvmtCd());		
		this.hashColumns.put("dsp_flag", getDspFlag());		
		this.hashColumns.put("cost", getCost());		
		this.hashColumns.put("act_invt_qty", getActInvtQty());		
		this.hashColumns.put("eq_type", getEqType());		
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());		
		this.hashColumns.put("flg_rmk", getFlgRmk());		
		this.hashColumns.put("dv_value", getDvValue());		
		this.hashColumns.put("dmg_flag", getDmgFlag());		
		this.hashColumns.put("rpr_dt", getRprDt());		
		this.hashColumns.put("off_hire", getOffHire());		
		this.hashColumns.put("hngr_flg_dt", getHngrFlgDt());		
		this.hashColumns.put("mnr_hngr_dmg_qty", getMnrHngrDmgQty());		
		this.hashColumns.put("mnr_hngr_trf_cd", getMnrHngrTrfCd());		
		this.hashColumns.put("lessor_nm", getLessorNm());		
		this.hashColumns.put("total_loss_date", getTotalLossDate());		
		this.hashColumns.put("mvmt_dt", getMvmtDt());		
		this.hashColumns.put("mtrl_cd", getMtrlCd());		
		this.hashColumns.put("rstr_usg_lbl_nm", getRstrUsgLblNm());
		this.hashColumns.put("lessor_cd", getLessorCd());
		this.hashColumns.put("act_ind", getActInd());
		this.hashColumns.put("rstr_usg_lbl_tp", getRstrUsgLblTp());
		this.hashColumns.put("rstr_usg_lbl_val", getRstrUsgLblVal());
		this.hashColumns.put("cntr_sts_cd", getCntrStsCd());
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("rpr_cost_amt", "rprCostAmt");
		this.hashFields.put("mnr_hngr_trf_otr_desc", "mnrHngrTrfOtrDesc");
		this.hashFields.put("hngr_flg_yd", "hngrFlgYd");
		this.hashFields.put("manu_dt", "manuDt");
		this.hashFields.put("dpp_amt", "dppAmt");
		this.hashFields.put("sp_name", "spName");
		this.hashFields.put("mtrl_nm", "mtrlNm");
		this.hashFields.put("mkr_nm", "mkrNm");
		this.hashFields.put("rpr_type", "rprType");
		this.hashFields.put("crnt_yd_cd", "crntYdCd");
		this.hashFields.put("rpr_yd", "rprYd");
		this.hashFields.put("imm_ext", "immExt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dv_cur", "dvCur");
		this.hashFields.put("bar_atch_knt", "barAtchKnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("hngr_rck_cd", "hngrRckCd");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("mnr_lost_hngr_qty", "mnrLostHngrQty");
		this.hashFields.put("mnr_disp_hngr_qty", "mnrDispHngrQty");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("mdl_nm", "mdlNm");
		this.hashFields.put("bar_tp_cd", "barTpCd");
		this.hashFields.put("status", "status");
		this.hashFields.put("mvmt_cd", "mvmtCd");
		this.hashFields.put("dsp_flag", "dspFlag");
		this.hashFields.put("cost", "cost");
		this.hashFields.put("act_invt_qty", "actInvtQty");
		this.hashFields.put("eq_type", "eqType");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("flg_rmk", "flgRmk");
		this.hashFields.put("dv_value", "dvValue");
		this.hashFields.put("dmg_flag", "dmgFlag");
		this.hashFields.put("rpr_dt", "rprDt");
		this.hashFields.put("off_hire", "offHire");
		this.hashFields.put("hngr_flg_dt", "hngrFlgDt");
		this.hashFields.put("mnr_hngr_dmg_qty", "mnrHngrDmgQty");
		this.hashFields.put("mnr_hngr_trf_cd", "mnrHngrTrfCd");
		this.hashFields.put("lessor_nm", "lessorNm");
		this.hashFields.put("total_loss_date", "totalLossDate");
		this.hashFields.put("mvmt_dt", "mvmtDt");
		this.hashFields.put("mtrl_cd", "mtrlCd");
		this.hashFields.put("rstr_usg_lbl_nm", "rstrUsgLblNm");
		this.hashFields.put("lessor_cd", "lessorCd");
		this.hashFields.put("act_ind", "actInd");
		this.hashFields.put("rstr_usg_lbl_tp", "rstrUsgLblTp");
		this.hashFields.put("rstr_usg_lbl_val", "rstrUsgLblVal");
		this.hashFields.put("cntr_sts_cd", "cntrStsCd");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  rprCostAmt
	*/
	public void	setRprCostAmt( String	rprCostAmt ) {
		this.rprCostAmt =	rprCostAmt;
	}
 
	/**
	 * Column Info
	 * @return	rprCostAmt
	 */
	 public	 String	getRprCostAmt() {
		 return	this.rprCostAmt;
	 } 
 	/**
	* Column Info
	* @param  mnrHngrTrfOtrDesc
	*/
	public void	setMnrHngrTrfOtrDesc( String	mnrHngrTrfOtrDesc ) {
		this.mnrHngrTrfOtrDesc =	mnrHngrTrfOtrDesc;
	}
 
	/**
	 * Column Info
	 * @return	mnrHngrTrfOtrDesc
	 */
	 public	 String	getMnrHngrTrfOtrDesc() {
		 return	this.mnrHngrTrfOtrDesc;
	 } 
 	/**
	* Column Info
	* @param  hngrFlgYd
	*/
	public void	setHngrFlgYd( String	hngrFlgYd ) {
		this.hngrFlgYd =	hngrFlgYd;
	}
 
	/**
	 * Column Info
	 * @return	hngrFlgYd
	 */
	 public	 String	getHngrFlgYd() {
		 return	this.hngrFlgYd;
	 } 
 	/**
	* Column Info
	* @param  manuDt
	*/
	public void	setManuDt( String	manuDt ) {
		this.manuDt =	manuDt;
	}
 
	/**
	 * Column Info
	 * @return	manuDt
	 */
	 public	 String	getManuDt() {
		 return	this.manuDt;
	 } 
 	/**
	* Column Info
	* @param  dppAmt
	*/
	public void	setDppAmt( String	dppAmt ) {
		this.dppAmt =	dppAmt;
	}
 
	/**
	 * Column Info
	 * @return	dppAmt
	 */
	 public	 String	getDppAmt() {
		 return	this.dppAmt;
	 } 
 	/**
	* Column Info
	* @param  spName
	*/
	public void	setSpName( String	spName ) {
		this.spName =	spName;
	}
 
	/**
	 * Column Info
	 * @return	spName
	 */
	 public	 String	getSpName() {
		 return	this.spName;
	 } 
 	/**
	* Column Info
	* @param  mtrlNm
	*/
	public void	setMtrlNm( String	mtrlNm ) {
		this.mtrlNm =	mtrlNm;
	}
 
	/**
	 * Column Info
	 * @return	mtrlNm
	 */
	 public	 String	getMtrlNm() {
		 return	this.mtrlNm;
	 } 
 	/**
	* Column Info
	* @param  mkrNm
	*/
	public void	setMkrNm( String	mkrNm ) {
		this.mkrNm =	mkrNm;
	}
 
	/**
	 * Column Info
	 * @return	mkrNm
	 */
	 public	 String	getMkrNm() {
		 return	this.mkrNm;
	 } 
 	/**
	* Column Info
	* @param  rprType
	*/
	public void	setRprType( String	rprType ) {
		this.rprType =	rprType;
	}
 
	/**
	 * Column Info
	 * @return	rprType
	 */
	 public	 String	getRprType() {
		 return	this.rprType;
	 } 
 	/**
	* Column Info
	* @param  crntYdCd
	*/
	public void	setCrntYdCd( String	crntYdCd ) {
		this.crntYdCd =	crntYdCd;
	}
 
	/**
	 * Column Info
	 * @return	crntYdCd
	 */
	 public	 String	getCrntYdCd() {
		 return	this.crntYdCd;
	 } 
 	/**
	* Column Info
	* @param  rprYd
	*/
	public void	setRprYd( String	rprYd ) {
		this.rprYd =	rprYd;
	}
 
	/**
	 * Column Info
	 * @return	rprYd
	 */
	 public	 String	getRprYd() {
		 return	this.rprYd;
	 } 
 	/**
	* Column Info
	* @param  immExt
	*/
	public void	setImmExt( String	immExt ) {
		this.immExt =	immExt;
	}
 
	/**
	 * Column Info
	 * @return	immExt
	 */
	 public	 String	getImmExt() {
		 return	this.immExt;
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
	* @param  dvCur
	*/
	public void	setDvCur( String	dvCur ) {
		this.dvCur =	dvCur;
	}
 
	/**
	 * Column Info
	 * @return	dvCur
	 */
	 public	 String	getDvCur() {
		 return	this.dvCur;
	 } 
 	/**
	* Column Info
	* @param  barAtchKnt
	*/
	public void	setBarAtchKnt( String	barAtchKnt ) {
		this.barAtchKnt =	barAtchKnt;
	}
 
	/**
	 * Column Info
	 * @return	barAtchKnt
	 */
	 public	 String	getBarAtchKnt() {
		 return	this.barAtchKnt;
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
	* @param  hngrRckCd
	*/
	public void	setHngrRckCd( String	hngrRckCd ) {
		this.hngrRckCd =	hngrRckCd;
	}
 
	/**
	 * Column Info
	 * @return	hngrRckCd
	 */
	 public	 String	getHngrRckCd() {
		 return	this.hngrRckCd;
	 } 
 	/**
	* Column Info
	* @param  eqNo
	*/
	public void	setEqNo( String	eqNo ) {
		this.eqNo =	eqNo;
	}
 
	/**
	 * Column Info
	 * @return	eqNo
	 */
	 public	 String	getEqNo() {
		 return	this.eqNo;
	 } 
 	/**
	* Column Info
	* @param  mnrLostHngrQty
	*/
	public void	setMnrLostHngrQty( String	mnrLostHngrQty ) {
		this.mnrLostHngrQty =	mnrLostHngrQty;
	}
 
	/**
	 * Column Info
	 * @return	mnrLostHngrQty
	 */
	 public	 String	getMnrLostHngrQty() {
		 return	this.mnrLostHngrQty;
	 } 
 	/**
	* Column Info
	* @param  mnrDispHngrQty
	*/
	public void	setMnrDispHngrQty( String	mnrDispHngrQty ) {
		this.mnrDispHngrQty =	mnrDispHngrQty;
	}
 
	/**
	 * Column Info
	 * @return	mnrDispHngrQty
	 */
	 public	 String	getMnrDispHngrQty() {
		 return	this.mnrDispHngrQty;
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
	* @param  mdlNm
	*/
	public void	setMdlNm( String	mdlNm ) {
		this.mdlNm =	mdlNm;
	}
 
	/**
	 * Column Info
	 * @return	mdlNm
	 */
	 public	 String	getMdlNm() {
		 return	this.mdlNm;
	 } 
 	/**
	* Column Info
	* @param  barTpCd
	*/
	public void	setBarTpCd( String	barTpCd ) {
		this.barTpCd =	barTpCd;
	}
 
	/**
	 * Column Info
	 * @return	barTpCd
	 */
	 public	 String	getBarTpCd() {
		 return	this.barTpCd;
	 } 
 	/**
	* Column Info
	* @param  status
	*/
	public void	setStatus( String	status ) {
		this.status =	status;
	}
 
	/**
	 * Column Info
	 * @return	status
	 */
	 public	 String	getStatus() {
		 return	this.status;
	 } 
 	/**
	* Column Info
	* @param  mvmtCd
	*/
	public void	setMvmtCd( String	mvmtCd ) {
		this.mvmtCd =	mvmtCd;
	}
 
	/**
	 * Column Info
	 * @return	mvmtCd
	 */
	 public	 String	getMvmtCd() {
		 return	this.mvmtCd;
	 } 
 	/**
	* Column Info
	* @param  dspFlag
	*/
	public void	setDspFlag( String	dspFlag ) {
		this.dspFlag =	dspFlag;
	}
 
	/**
	 * Column Info
	 * @return	dspFlag
	 */
	 public	 String	getDspFlag() {
		 return	this.dspFlag;
	 } 
 	/**
	* Column Info
	* @param  cost
	*/
	public void	setCost( String	cost ) {
		this.cost =	cost;
	}
 
	/**
	 * Column Info
	 * @return	cost
	 */
	 public	 String	getCost() {
		 return	this.cost;
	 } 
 	/**
	* Column Info
	* @param  actInvtQty
	*/
	public void	setActInvtQty( String	actInvtQty ) {
		this.actInvtQty =	actInvtQty;
	}
 
	/**
	 * Column Info
	 * @return	actInvtQty
	 */
	 public	 String	getActInvtQty() {
		 return	this.actInvtQty;
	 } 
 	/**
	* Column Info
	* @param  eqType
	*/
	public void	setEqType( String	eqType ) {
		this.eqType =	eqType;
	}
 
	/**
	 * Column Info
	 * @return	eqType
	 */
	 public	 String	getEqType() {
		 return	this.eqType;
	 } 
 	/**
	* Column Info
	* @param  eqTpszCd
	*/
	public void	setEqTpszCd( String	eqTpszCd ) {
		this.eqTpszCd =	eqTpszCd;
	}
 
	/**
	 * Column Info
	 * @return	eqTpszCd
	 */
	 public	 String	getEqTpszCd() {
		 return	this.eqTpszCd;
	 } 
 	/**
	* Column Info
	* @param  flgRmk
	*/
	public void	setFlgRmk( String	flgRmk ) {
		this.flgRmk =	flgRmk;
	}
 
	/**
	 * Column Info
	 * @return	flgRmk
	 */
	 public	 String	getFlgRmk() {
		 return	this.flgRmk;
	 } 
 	/**
	* Column Info
	* @param  dvValue
	*/
	public void	setDvValue( String	dvValue ) {
		this.dvValue =	dvValue;
	}
 
	/**
	 * Column Info
	 * @return	dvValue
	 */
	 public	 String	getDvValue() {
		 return	this.dvValue;
	 } 
 	/**
	* Column Info
	* @param  dmgFlag
	*/
	public void	setDmgFlag( String	dmgFlag ) {
		this.dmgFlag =	dmgFlag;
	}
 
	/**
	 * Column Info
	 * @return	dmgFlag
	 */
	 public	 String	getDmgFlag() {
		 return	this.dmgFlag;
	 } 
 	/**
	* Column Info
	* @param  rprDt
	*/
	public void	setRprDt( String	rprDt ) {
		this.rprDt =	rprDt;
	}
 
	/**
	 * Column Info
	 * @return	rprDt
	 */
	 public	 String	getRprDt() {
		 return	this.rprDt;
	 } 
 	/**
	* Column Info
	* @param  offHire
	*/
	public void	setOffHire( String	offHire ) {
		this.offHire =	offHire;
	}
 
	/**
	 * Column Info
	 * @return	offHire
	 */
	 public	 String	getOffHire() {
		 return	this.offHire;
	 } 
 	/**
	* Column Info
	* @param  hngrFlgDt
	*/
	public void	setHngrFlgDt( String	hngrFlgDt ) {
		this.hngrFlgDt =	hngrFlgDt;
	}
 
	/**
	 * Column Info
	 * @return	hngrFlgDt
	 */
	 public	 String	getHngrFlgDt() {
		 return	this.hngrFlgDt;
	 } 
 	/**
	* Column Info
	* @param  mnrHngrDmgQty
	*/
	public void	setMnrHngrDmgQty( String	mnrHngrDmgQty ) {
		this.mnrHngrDmgQty =	mnrHngrDmgQty;
	}
 
	/**
	 * Column Info
	 * @return	mnrHngrDmgQty
	 */
	 public	 String	getMnrHngrDmgQty() {
		 return	this.mnrHngrDmgQty;
	 } 
 	/**
	* Column Info
	* @param  mnrHngrTrfCd
	*/
	public void	setMnrHngrTrfCd( String	mnrHngrTrfCd ) {
		this.mnrHngrTrfCd =	mnrHngrTrfCd;
	}
 
	/**
	 * Column Info
	 * @return	mnrHngrTrfCd
	 */
	 public	 String	getMnrHngrTrfCd() {
		 return	this.mnrHngrTrfCd;
	 } 
 	/**
	* Column Info
	* @param  lessorNm
	*/
	public void	setLessorNm( String	lessorNm ) {
		this.lessorNm =	lessorNm;
	}
 
	/**
	 * Column Info
	 * @return	lessorNm
	 */
	 public	 String	getLessorNm() {
		 return	this.lessorNm;
	 } 
 	/**
	* Column Info
	* @param  totalLossDate
	*/
	public void	setTotalLossDate( String	totalLossDate ) {
		this.totalLossDate =	totalLossDate;
	}
 
	/**
	 * Column Info
	 * @return	totalLossDate
	 */
	 public	 String	getTotalLossDate() {
		 return	this.totalLossDate;
	 } 
 	/**
	* Column Info
	* @param  mvmtDt
	*/
	public void	setMvmtDt( String	mvmtDt ) {
		this.mvmtDt =	mvmtDt;
	}
 
	/**
	 * Column Info
	 * @return	mvmtDt
	 */
	 public	 String	getMvmtDt() {
		 return	this.mvmtDt;
	 } 
 	/**
	* Column Info
	* @param  mtrlCd
	*/
	public void	setMtrlCd( String	mtrlCd ) {
		this.mtrlCd =	mtrlCd;
	}
 
	/**
	 * Column Info
	 * @return	mtrlCd
	 */
	 public	 String	getMtrlCd() {
		 return	this.mtrlCd;
	 } 
 	/**
	* Column Info
	* @param  rstrUsgLblNm
	*/
	public void	setRstrUsgLblNm( String	rstrUsgLblNm ) {
		this.rstrUsgLblNm =	rstrUsgLblNm;
	}
 
	/**
	 * Column Info
	 * @return	rstrUsgLblNm
	 */
	 public	 String	getRstrUsgLblNm() {
		 return	this.rstrUsgLblNm;
	 } 
	 
	/**
	 * Column Info
	 * @return lessorCd
	 */
	public String getLessorCd() {
		return this.lessorCd;
	}

	/**
	 * Column Info
	 * @param lessorCd
	 */
	public void setLessorCd(String lessorCd) {
		this.lessorCd = lessorCd;
	}
	
	/**
	 * Column Info
	 * @return actInd
	 */
	public String getActInd() {
		return actInd;
	}

	/**
	 * Column Info
	 * @return actInd
	 */
	public void setActInd(String actInd) {
		this.actInd = actInd;
	}
	
	public String getRstrUsgLblTp() {
		return rstrUsgLblTp;
	}

	public void setRstrUsgLblTp(String rstrUsgLblTp) {
		this.rstrUsgLblTp = rstrUsgLblTp;
	}

	public String getRstrUsgLblVal() {
		return rstrUsgLblVal;
	}

	public void setRstrUsgLblVal(String rstrUsgLblVal) {
		this.rstrUsgLblVal = rstrUsgLblVal;
	}
	
	public String getCntrStsCd() {
		return cntrStsCd;
	}

	public void setCntrStsCd(String cntrStsCd) {
		this.cntrStsCd = cntrStsCd;
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
		setRprCostAmt(JSPUtil.getParameter(request,	prefix + "rpr_cost_amt", ""));
		setMnrHngrTrfOtrDesc(JSPUtil.getParameter(request,	prefix + "mnr_hngr_trf_otr_desc", ""));
		setHngrFlgYd(JSPUtil.getParameter(request,	prefix + "hngr_flg_yd", ""));
		setManuDt(JSPUtil.getParameter(request,	prefix + "manu_dt", ""));
		setDppAmt(JSPUtil.getParameter(request,	prefix + "dpp_amt", ""));
		setSpName(JSPUtil.getParameter(request,	prefix + "sp_name", ""));
		setMtrlNm(JSPUtil.getParameter(request,	prefix + "mtrl_nm", ""));
		setMkrNm(JSPUtil.getParameter(request,	prefix + "mkr_nm", ""));
		setRprType(JSPUtil.getParameter(request,	prefix + "rpr_type", ""));
		setCrntYdCd(JSPUtil.getParameter(request,	prefix + "crnt_yd_cd", ""));
		setRprYd(JSPUtil.getParameter(request,	prefix + "rpr_yd", ""));
		setImmExt(JSPUtil.getParameter(request,	prefix + "imm_ext", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setDvCur(JSPUtil.getParameter(request,	prefix + "dv_cur", ""));
		setBarAtchKnt(JSPUtil.getParameter(request,	prefix + "bar_atch_knt", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setHngrRckCd(JSPUtil.getParameter(request,	prefix + "hngr_rck_cd", ""));
		setEqNo(JSPUtil.getParameter(request,	prefix + "eq_no", ""));
		setMnrLostHngrQty(JSPUtil.getParameter(request,	prefix + "mnr_lost_hngr_qty", ""));
		setMnrDispHngrQty(JSPUtil.getParameter(request,	prefix + "mnr_disp_hngr_qty", ""));
		setLstmCd(JSPUtil.getParameter(request,	prefix + "lstm_cd", ""));
		setMdlNm(JSPUtil.getParameter(request,	prefix + "mdl_nm", ""));
		setBarTpCd(JSPUtil.getParameter(request,	prefix + "bar_tp_cd", ""));
		setStatus(JSPUtil.getParameter(request,	prefix + "status", ""));
		setMvmtCd(JSPUtil.getParameter(request,	prefix + "mvmt_cd", ""));
		setDspFlag(JSPUtil.getParameter(request,	prefix + "dsp_flag", ""));
		setCost(JSPUtil.getParameter(request,	prefix + "cost", ""));
		setActInvtQty(JSPUtil.getParameter(request,	prefix + "act_invt_qty", ""));
		setEqType(JSPUtil.getParameter(request,	prefix + "eq_type", ""));
		setEqTpszCd(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd", ""));
		setFlgRmk(JSPUtil.getParameter(request,	prefix + "flg_rmk", ""));
		setDvValue(JSPUtil.getParameter(request,	prefix + "dv_value", ""));
		setDmgFlag(JSPUtil.getParameter(request,	prefix + "dmg_flag", ""));
		setRprDt(JSPUtil.getParameter(request,	prefix + "rpr_dt", ""));
		setOffHire(JSPUtil.getParameter(request,	prefix + "off_hire", ""));
		setHngrFlgDt(JSPUtil.getParameter(request,	prefix + "hngr_flg_dt", ""));
		setMnrHngrDmgQty(JSPUtil.getParameter(request,	prefix + "mnr_hngr_dmg_qty", ""));
		setMnrHngrTrfCd(JSPUtil.getParameter(request,	prefix + "mnr_hngr_trf_cd", ""));
		setLessorNm(JSPUtil.getParameter(request,	prefix + "lessor_nm", ""));
		setTotalLossDate(JSPUtil.getParameter(request,	prefix + "total_loss_date", ""));
		setMvmtDt(JSPUtil.getParameter(request,	prefix + "mvmt_dt", ""));
		setMtrlCd(JSPUtil.getParameter(request,	prefix + "mtrl_cd", ""));
		setRstrUsgLblNm(JSPUtil.getParameter(request,	prefix + "rstr_usg_lbl_nm", ""));
		setLessorCd(JSPUtil.getParameter(request, prefix + "lessor_cd", ""));
		setActInd(JSPUtil.getParameter(request, prefix + "act_ind", ""));
		setRstrUsgLblTp(JSPUtil.getParameter(request, prefix + "rstr_usg_lbl_tp", ""));
		setRstrUsgLblVal(JSPUtil.getParameter(request, prefix + "rstr_usg_lbl_val", ""));
		setCntrStsCd(JSPUtil.getParameter(request, prefix + "cntr_sts_cd", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomMnrEqStsVVO[]
	 */
	public CustomMnrEqStsVVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return CustomMnrEqStsVVO[]
	 */
	public CustomMnrEqStsVVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		CustomMnrEqStsVVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] rprCostAmt =	(JSPUtil.getParameter(request, prefix +	"rpr_cost_amt".trim(),	length));
				String[] mnrHngrTrfOtrDesc =	(JSPUtil.getParameter(request, prefix +	"mnr_hngr_trf_otr_desc".trim(),	length));
				String[] hngrFlgYd =	(JSPUtil.getParameter(request, prefix +	"hngr_flg_yd".trim(),	length));
				String[] manuDt =	(JSPUtil.getParameter(request, prefix +	"manu_dt".trim(),	length));
				String[] dppAmt =	(JSPUtil.getParameter(request, prefix +	"dpp_amt".trim(),	length));
				String[] spName =	(JSPUtil.getParameter(request, prefix +	"sp_name".trim(),	length));
				String[] mtrlNm =	(JSPUtil.getParameter(request, prefix +	"mtrl_nm".trim(),	length));
				String[] mkrNm =	(JSPUtil.getParameter(request, prefix +	"mkr_nm".trim(),	length));
				String[] rprType =	(JSPUtil.getParameter(request, prefix +	"rpr_type".trim(),	length));
				String[] crntYdCd =	(JSPUtil.getParameter(request, prefix +	"crnt_yd_cd".trim(),	length));
				String[] rprYd =	(JSPUtil.getParameter(request, prefix +	"rpr_yd".trim(),	length));
				String[] immExt =	(JSPUtil.getParameter(request, prefix +	"imm_ext".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] dvCur =	(JSPUtil.getParameter(request, prefix +	"dv_cur".trim(),	length));
				String[] barAtchKnt =	(JSPUtil.getParameter(request, prefix +	"bar_atch_knt".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] hngrRckCd =	(JSPUtil.getParameter(request, prefix +	"hngr_rck_cd".trim(),	length));
				String[] eqNo =	(JSPUtil.getParameter(request, prefix +	"eq_no".trim(),	length));
				String[] mnrLostHngrQty =	(JSPUtil.getParameter(request, prefix +	"mnr_lost_hngr_qty".trim(),	length));
				String[] mnrDispHngrQty =	(JSPUtil.getParameter(request, prefix +	"mnr_disp_hngr_qty".trim(),	length));
				String[] lstmCd =	(JSPUtil.getParameter(request, prefix +	"lstm_cd".trim(),	length));
				String[] mdlNm =	(JSPUtil.getParameter(request, prefix +	"mdl_nm".trim(),	length));
				String[] barTpCd =	(JSPUtil.getParameter(request, prefix +	"bar_tp_cd".trim(),	length));
				String[] status =	(JSPUtil.getParameter(request, prefix +	"status".trim(),	length));
				String[] mvmtCd =	(JSPUtil.getParameter(request, prefix +	"mvmt_cd".trim(),	length));
				String[] dspFlag =	(JSPUtil.getParameter(request, prefix +	"dsp_flag".trim(),	length));
				String[] cost =	(JSPUtil.getParameter(request, prefix +	"cost".trim(),	length));
				String[] actInvtQty =	(JSPUtil.getParameter(request, prefix +	"act_invt_qty".trim(),	length));
				String[] eqType =	(JSPUtil.getParameter(request, prefix +	"eq_type".trim(),	length));
				String[] eqTpszCd =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd".trim(),	length));
				String[] flgRmk =	(JSPUtil.getParameter(request, prefix +	"flg_rmk".trim(),	length));
				String[] dvValue =	(JSPUtil.getParameter(request, prefix +	"dv_value".trim(),	length));
				String[] dmgFlag =	(JSPUtil.getParameter(request, prefix +	"dmg_flag".trim(),	length));
				String[] rprDt =	(JSPUtil.getParameter(request, prefix +	"rpr_dt".trim(),	length));
				String[] offHire =	(JSPUtil.getParameter(request, prefix +	"off_hire".trim(),	length));
				String[] hngrFlgDt =	(JSPUtil.getParameter(request, prefix +	"hngr_flg_dt".trim(),	length));
				String[] mnrHngrDmgQty =	(JSPUtil.getParameter(request, prefix +	"mnr_hngr_dmg_qty".trim(),	length));
				String[] mnrHngrTrfCd =	(JSPUtil.getParameter(request, prefix +	"mnr_hngr_trf_cd".trim(),	length));
				String[] lessorNm =	(JSPUtil.getParameter(request, prefix +	"lessor_nm".trim(),	length));
				String[] totalLossDate =	(JSPUtil.getParameter(request, prefix +	"total_loss_date".trim(),	length));
				String[] mvmtDt =	(JSPUtil.getParameter(request, prefix +	"mvmt_dt".trim(),	length));
				String[] mtrlCd =	(JSPUtil.getParameter(request, prefix +	"mtrl_cd".trim(),	length));
				String[] rstrUsgLblNm =	(JSPUtil.getParameter(request, prefix +	"rstr_usg_lbl_nm".trim(),	length));
				String[] lessorCd = (JSPUtil.getParameter(request, prefix	+ "lessor_cd", length));
				String[] actInd = (JSPUtil.getParameter(request, prefix	+ "act_ind", length));
				String[] rstrUsgLblTp = (JSPUtil.getParameter(request, prefix	+ "rstr_usg_lbl_tp", length));
				String[] rstrUsgLblVal = (JSPUtil.getParameter(request, prefix	+ "rstr_usg_lbl_val", length));
				String[] cntrStsCd = (JSPUtil.getParameter(request, prefix	+ "cntr_sts_cd", length));
				
				for	(int i = 0;	i <	length;	i++) {
					model =	new	CustomMnrEqStsVVO();
						if ( rprCostAmt[i] !=	null)
						model.setRprCostAmt( rprCostAmt[i]);
						if ( mnrHngrTrfOtrDesc[i] !=	null)
						model.setMnrHngrTrfOtrDesc( mnrHngrTrfOtrDesc[i]);
						if ( hngrFlgYd[i] !=	null)
						model.setHngrFlgYd( hngrFlgYd[i]);
						if ( manuDt[i] !=	null)
						model.setManuDt( manuDt[i]);
						if ( dppAmt[i] !=	null)
						model.setDppAmt( dppAmt[i]);
						if ( spName[i] !=	null)
						model.setSpName( spName[i]);
						if ( mtrlNm[i] !=	null)
						model.setMtrlNm( mtrlNm[i]);
						if ( mkrNm[i] !=	null)
						model.setMkrNm( mkrNm[i]);
						if ( rprType[i] !=	null)
						model.setRprType( rprType[i]);
						if ( crntYdCd[i] !=	null)
						model.setCrntYdCd( crntYdCd[i]);
						if ( rprYd[i] !=	null)
						model.setRprYd( rprYd[i]);
						if ( immExt[i] !=	null)
						model.setImmExt( immExt[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( dvCur[i] !=	null)
						model.setDvCur( dvCur[i]);
						if ( barAtchKnt[i] !=	null)
						model.setBarAtchKnt( barAtchKnt[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( hngrRckCd[i] !=	null)
						model.setHngrRckCd( hngrRckCd[i]);
						if ( eqNo[i] !=	null)
						model.setEqNo( eqNo[i]);
						if ( mnrLostHngrQty[i] !=	null)
						model.setMnrLostHngrQty( mnrLostHngrQty[i]);
						if ( mnrDispHngrQty[i] !=	null)
						model.setMnrDispHngrQty( mnrDispHngrQty[i]);
						if ( lstmCd[i] !=	null)
						model.setLstmCd( lstmCd[i]);
						if ( mdlNm[i] !=	null)
						model.setMdlNm( mdlNm[i]);
						if ( barTpCd[i] !=	null)
						model.setBarTpCd( barTpCd[i]);
						if ( status[i] !=	null)
						model.setStatus( status[i]);
						if ( mvmtCd[i] !=	null)
						model.setMvmtCd( mvmtCd[i]);
						if ( dspFlag[i] !=	null)
						model.setDspFlag( dspFlag[i]);
						if ( cost[i] !=	null)
						model.setCost( cost[i]);
						if ( actInvtQty[i] !=	null)
						model.setActInvtQty( actInvtQty[i]);
						if ( eqType[i] !=	null)
						model.setEqType( eqType[i]);
						if ( eqTpszCd[i] !=	null)
						model.setEqTpszCd( eqTpszCd[i]);
						if ( flgRmk[i] !=	null)
						model.setFlgRmk( flgRmk[i]);
						if ( dvValue[i] !=	null)
						model.setDvValue( dvValue[i]);
						if ( dmgFlag[i] !=	null)
						model.setDmgFlag( dmgFlag[i]);
						if ( rprDt[i] !=	null)
						model.setRprDt( rprDt[i]);
						if ( offHire[i] !=	null)
						model.setOffHire( offHire[i]);
						if ( hngrFlgDt[i] !=	null)
						model.setHngrFlgDt( hngrFlgDt[i]);
						if ( mnrHngrDmgQty[i] !=	null)
						model.setMnrHngrDmgQty( mnrHngrDmgQty[i]);
						if ( mnrHngrTrfCd[i] !=	null)
						model.setMnrHngrTrfCd( mnrHngrTrfCd[i]);
						if ( lessorNm[i] !=	null)
						model.setLessorNm( lessorNm[i]);
						if ( totalLossDate[i] !=	null)
						model.setTotalLossDate( totalLossDate[i]);
						if ( mvmtDt[i] !=	null)
						model.setMvmtDt( mvmtDt[i]);
						if ( mtrlCd[i] !=	null)
						model.setMtrlCd( mtrlCd[i]);
						if ( rstrUsgLblNm[i] !=	null)
						model.setRstrUsgLblNm( rstrUsgLblNm[i]);
						if (lessorCd[i] != null)
						model.setLessorCd(lessorCd[i]);
						if (actInd[i] != null)
						model.setActInd(actInd[i]);
						if (rstrUsgLblTp[i] != null)
						model.setRstrUsgLblTp(rstrUsgLblTp[i]);
						if (rstrUsgLblVal[i] != null)
						model.setRstrUsgLblVal(rstrUsgLblVal[i]);
						if (cntrStsCd[i] != null)
						model.setCntrStsCd(cntrStsCd[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getCustomMnrEqStsVVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return CustomMnrEqStsVVO[]
	 */
	public CustomMnrEqStsVVO[]	 getCustomMnrEqStsVVOs(){
		CustomMnrEqStsVVO[] vos = (CustomMnrEqStsVVO[])models.toArray(new	CustomMnrEqStsVVO[models.size()]);
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
		this.rprCostAmt =	this.rprCostAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrHngrTrfOtrDesc =	this.mnrHngrTrfOtrDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hngrFlgYd =	this.hngrFlgYd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.manuDt =	this.manuDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dppAmt =	this.dppAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spName =	this.spName.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtrlNm =	this.mtrlNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mkrNm =	this.mkrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprType =	this.rprType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntYdCd =	this.crntYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprYd =	this.rprYd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.immExt =	this.immExt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dvCur =	this.dvCur.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.barAtchKnt =	this.barAtchKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hngrRckCd =	this.hngrRckCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo =	this.eqNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrLostHngrQty =	this.mnrLostHngrQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrDispHngrQty =	this.mnrDispHngrQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd =	this.lstmCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mdlNm =	this.mdlNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.barTpCd =	this.barTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.status =	this.status.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtCd =	this.mvmtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dspFlag =	this.dspFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cost =	this.cost.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actInvtQty =	this.actInvtQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqType =	this.eqType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd =	this.eqTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flgRmk =	this.flgRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dvValue =	this.dvValue.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmgFlag =	this.dmgFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprDt =	this.rprDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offHire =	this.offHire.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hngrFlgDt =	this.hngrFlgDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrHngrDmgQty =	this.mnrHngrDmgQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrHngrTrfCd =	this.mnrHngrTrfCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lessorNm =	this.lessorNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalLossDate =	this.totalLossDate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtDt =	this.mvmtDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtrlCd =	this.mtrlCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rstrUsgLblNm =	this.rstrUsgLblNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lessorCd = this.lessorCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actInd = this.actInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rstrUsgLblTp = this.rstrUsgLblTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rstrUsgLblVal = this.rstrUsgLblVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrStsCd = this.cntrStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}