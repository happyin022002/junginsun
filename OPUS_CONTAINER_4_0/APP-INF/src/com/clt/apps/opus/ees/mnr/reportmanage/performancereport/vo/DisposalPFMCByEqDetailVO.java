/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : DisposalPFMCByEqDetailVO.java
 *@FileTitle : DisposalPFMCByEqDetailVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.11.12
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2014.11.12  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo;

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
public class DisposalPFMCByEqDetailVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<DisposalPFMCByEqDetailVO>  models =	new	ArrayList<DisposalPFMCByEqDetailVO>();


	/*	Column Info	*/
	private  String	 rprCostAmt   =  null;
	/*	Column Info	*/
	private  String	 manuDt   =  null;
	/*	Column Info	*/
	private  String	 dispSoldDt   =  null;
	/*	Column Info	*/
	private  String	 currCd   =  null;
	/*	Column Info	*/
	private  String	 custNm   =  null;
	/*	Column Info	*/
	private  String	 pEndEvntDt   =  null;
	/*	Column Info	*/
	private  String	 pLocCd   =  null;
	/*	Column Info	*/
	private  String	 aproOfcCd   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 locCd   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 eqNo   =  null;
	/*	Column Info	*/
	private  String	 pLocTp   =  null;
	/*	Column Info	*/
	private  String	 partAmt   =  null;
	/*	Column Info	*/
	private  String	 dispUtPrc   =  null;
	/*	Column Info	*/
	private  String	 pChkUsd   =  null;
	/*	Column Info	*/
	private  String	 dispRsnCd   =  null;
	/*	Column Info	*/
	private  String	 dispTrfUtPrc   =  null;
	/*	Column Info	*/
	private  String	 dispTpCd   =  null;
	/*	Column Info	*/
	private  String	 calPartAmt   =  null;
	/*	Column Info	*/
	private  String	 dispNo   =  null;
	/*	Column Info	*/
	private  String	 rhqCd   =  null;
	/*	Column Info	*/
	private  String	 pStrEvntDt   =  null;
	/*	Column Info	*/
	private  String	 rccCd   =  null;
	/*	Column Info	*/
	private  String	 dispDtlSeq   =  null;
	/*	Column Info	*/
	private  String	 eqKndCd   =  null;
	/*	Column Info	*/
	private  String	 pDispTpCd   =  null;
	/*	Column Info	*/
	private  String	 pDispRsnCd   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCd   =  null;
	/*	Column Info	*/
	private  String	 dispVrfyTpCd   =  null;
	/*	Column Info	*/
	private  String	 pCustCd   =  null;
	/*	Column Info	*/
	private  String	 lccCd   =  null;
	/*	Column Info	*/
	private  String	 sccCd   =  null;
	/*	Column Info	*/
	private  String	 dispYdCd   =  null;
	/*	Column Info	*/
	private  String	 pVndrNm   =  null;
	/*	Column Info	*/
	private  String	 custCd   =  null;
	/*	Column Info	*/
	private  String	 pEqKndCd   =  null;
	/*	Column Info	*/
	private  String	 rqstOfcCd   =  null;
	/*	Column Info	*/
	private  String	 dispVrfyTpNm   =  null;
	/*	Column Info	*/
	private  String	 asetKnd   =  null;
	/*	Column Info	*/
	private  String	 lessorNm   =  null;
	/*	Column Info	*/
	private  String	 lstmCd   =  null;
	/*	Column Info	*/
	private  String	 rstrUsgLblNm   =  null;
	/*	Column Info	*/
	private  String	 dispStsCd   =  null;
	/*	Column Info	*/
	private  String	 invNo   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 updDt   =  null;
	/*	Column Info	*/
	private  String	 rstrUsgLblTp   =  null;
	/*	Column Info	*/
	private  String	 rstrUsgLblVal   =  null;
	/*	Column Info	*/
	private  String	 rstrUsgLbl   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public DisposalPFMCByEqDetailVO(){}

	public DisposalPFMCByEqDetailVO(String rprCostAmt,String manuDt,String dispSoldDt,String currCd,String custNm,String pEndEvntDt,String pLocCd,String aproOfcCd,String pagerows,String locCd,String ibflag,String eqNo,String pLocTp,String partAmt,String dispUtPrc,String pChkUsd,String dispRsnCd,String dispTrfUtPrc,String dispTpCd,String calPartAmt,String dispNo,String rhqCd,String pStrEvntDt,String rccCd,String dispDtlSeq,String eqKndCd,String pDispTpCd,String pDispRsnCd,String eqTpszCd,String dispVrfyTpCd,String pCustCd,String lccCd,String sccCd,String dispYdCd,String pVndrNm,String custCd,String pEqKndCd,String rqstOfcCd,String dispVrfyTpNm,String asetKnd,String lessorNm,String lstmCd,String rstrUsgLblNm,String dispStsCd,String invNo,String updUsrId,String updDt,String rstrUsgLblTp,String rstrUsgLblVal,String rstrUsgLbl)	{
		this.rprCostAmt  = rprCostAmt ;
		this.manuDt  = manuDt ;
		this.dispSoldDt  = dispSoldDt ;
		this.currCd  = currCd ;
		this.custNm  = custNm ;
		this.pEndEvntDt  = pEndEvntDt ;
		this.pLocCd  = pLocCd ;
		this.aproOfcCd  = aproOfcCd ;
		this.pagerows  = pagerows ;
		this.locCd  = locCd ;
		this.ibflag  = ibflag ;
		this.eqNo  = eqNo ;
		this.pLocTp  = pLocTp ;
		this.partAmt  = partAmt ;
		this.dispUtPrc  = dispUtPrc ;
		this.pChkUsd  = pChkUsd ;
		this.dispRsnCd  = dispRsnCd ;
		this.dispTrfUtPrc  = dispTrfUtPrc ;
		this.dispTpCd  = dispTpCd ;
		this.calPartAmt  = calPartAmt ;
		this.dispNo  = dispNo ;
		this.rhqCd  = rhqCd ;
		this.pStrEvntDt  = pStrEvntDt ;
		this.rccCd  = rccCd ;
		this.dispDtlSeq  = dispDtlSeq ;
		this.eqKndCd  = eqKndCd ;
		this.pDispTpCd  = pDispTpCd ;
		this.pDispRsnCd  = pDispRsnCd ;
		this.eqTpszCd  = eqTpszCd ;
		this.dispVrfyTpCd  = dispVrfyTpCd ;
		this.pCustCd  = pCustCd ;
		this.lccCd  = lccCd ;
		this.sccCd  = sccCd ;
		this.dispYdCd  = dispYdCd ;
		this.pVndrNm  = pVndrNm ;
		this.custCd  = custCd ;
		this.pEqKndCd  = pEqKndCd ;
		this.rqstOfcCd  = rqstOfcCd ;
		this.dispVrfyTpNm  = dispVrfyTpNm ;
		this.asetKnd  = asetKnd ;
		this.lessorNm  = lessorNm ;
		this.lstmCd  = lstmCd ;
		this.rstrUsgLblNm  = rstrUsgLblNm ;
		this.dispStsCd  = dispStsCd ;
		this.invNo  = invNo ;
		this.updUsrId  = updUsrId ;
		this.updDt  = updDt ;
		this.rstrUsgLblTp = rstrUsgLblTp;
		this.rstrUsgLblVal = rstrUsgLblVal;
		this.rstrUsgLbl = rstrUsgLbl;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rpr_cost_amt", getRprCostAmt());		
		this.hashColumns.put("manu_dt", getManuDt());		
		this.hashColumns.put("disp_sold_dt", getDispSoldDt());		
		this.hashColumns.put("curr_cd", getCurrCd());		
		this.hashColumns.put("cust_nm", getCustNm());		
		this.hashColumns.put("p_end_evnt_dt", getPEndEvntDt());		
		this.hashColumns.put("p_loc_cd", getPLocCd());		
		this.hashColumns.put("apro_ofc_cd", getAproOfcCd());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("loc_cd", getLocCd());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("eq_no", getEqNo());		
		this.hashColumns.put("p_loc_tp", getPLocTp());		
		this.hashColumns.put("part_amt", getPartAmt());		
		this.hashColumns.put("disp_ut_prc", getDispUtPrc());		
		this.hashColumns.put("p_chk_usd", getPChkUsd());		
		this.hashColumns.put("disp_rsn_cd", getDispRsnCd());		
		this.hashColumns.put("disp_trf_ut_prc", getDispTrfUtPrc());		
		this.hashColumns.put("disp_tp_cd", getDispTpCd());		
		this.hashColumns.put("cal_part_amt", getCalPartAmt());		
		this.hashColumns.put("disp_no", getDispNo());		
		this.hashColumns.put("rhq_cd", getRhqCd());		
		this.hashColumns.put("p_str_evnt_dt", getPStrEvntDt());		
		this.hashColumns.put("rcc_cd", getRccCd());		
		this.hashColumns.put("disp_dtl_seq", getDispDtlSeq());		
		this.hashColumns.put("eq_knd_cd", getEqKndCd());		
		this.hashColumns.put("p_disp_tp_cd", getPDispTpCd());		
		this.hashColumns.put("p_disp_rsn_cd", getPDispRsnCd());		
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());		
		this.hashColumns.put("disp_vrfy_tp_cd", getDispVrfyTpCd());		
		this.hashColumns.put("p_cust_cd", getPCustCd());		
		this.hashColumns.put("lcc_cd", getLccCd());		
		this.hashColumns.put("scc_cd", getSccCd());		
		this.hashColumns.put("disp_yd_cd", getDispYdCd());		
		this.hashColumns.put("p_vndr_nm", getPVndrNm());		
		this.hashColumns.put("cust_cd", getCustCd());		
		this.hashColumns.put("p_eq_knd_cd", getPEqKndCd());		
		this.hashColumns.put("rqst_ofc_cd", getRqstOfcCd());		
		this.hashColumns.put("disp_vrfy_tp_nm", getDispVrfyTpNm());		
		this.hashColumns.put("aset_knd", getAsetKnd());		
		this.hashColumns.put("lessor_nm", getLessorNm());		
		this.hashColumns.put("lstm_cd", getLstmCd());		
		this.hashColumns.put("rstr_usg_lbl_nm", getRstrUsgLblNm());		
		this.hashColumns.put("disp_sts_cd", getDispStsCd());		
		this.hashColumns.put("inv_no", getInvNo());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("upd_dt", getUpdDt());		
		this.hashColumns.put("rstr_usg_lbl_tp", getRstrUsgLblTp());	
		this.hashColumns.put("rstr_usg_lbl_val", getRstrUsgLblVal());
		this.hashColumns.put("rstr_usg_lbl", getRstrUsgLbl());
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("rpr_cost_amt", "rprCostAmt");
		this.hashFields.put("manu_dt", "manuDt");
		this.hashFields.put("disp_sold_dt", "dispSoldDt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("p_end_evnt_dt", "pEndEvntDt");
		this.hashFields.put("p_loc_cd", "pLocCd");
		this.hashFields.put("apro_ofc_cd", "aproOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("p_loc_tp", "pLocTp");
		this.hashFields.put("part_amt", "partAmt");
		this.hashFields.put("disp_ut_prc", "dispUtPrc");
		this.hashFields.put("p_chk_usd", "pChkUsd");
		this.hashFields.put("disp_rsn_cd", "dispRsnCd");
		this.hashFields.put("disp_trf_ut_prc", "dispTrfUtPrc");
		this.hashFields.put("disp_tp_cd", "dispTpCd");
		this.hashFields.put("cal_part_amt", "calPartAmt");
		this.hashFields.put("disp_no", "dispNo");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("p_str_evnt_dt", "pStrEvntDt");
		this.hashFields.put("rcc_cd", "rccCd");
		this.hashFields.put("disp_dtl_seq", "dispDtlSeq");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("p_disp_tp_cd", "pDispTpCd");
		this.hashFields.put("p_disp_rsn_cd", "pDispRsnCd");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("disp_vrfy_tp_cd", "dispVrfyTpCd");
		this.hashFields.put("p_cust_cd", "pCustCd");
		this.hashFields.put("lcc_cd", "lccCd");
		this.hashFields.put("scc_cd", "sccCd");
		this.hashFields.put("disp_yd_cd", "dispYdCd");
		this.hashFields.put("p_vndr_nm", "pVndrNm");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("p_eq_knd_cd", "pEqKndCd");
		this.hashFields.put("rqst_ofc_cd", "rqstOfcCd");
		this.hashFields.put("disp_vrfy_tp_nm", "dispVrfyTpNm");
		this.hashFields.put("aset_knd", "asetKnd");
		this.hashFields.put("lessor_nm", "lessorNm");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("rstr_usg_lbl_nm", "rstrUsgLblNm");
		this.hashFields.put("disp_sts_cd", "dispStsCd");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("rstr_usg_lbl_tp", "rstrUsgLblTp");
		this.hashFields.put("rstr_usg_lbl_val", "rstrUsgLblVal");
		this.hashFields.put("rstr_usg_lbl", "rstrUsgLbl");
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
	* @param  dispSoldDt
	*/
	public void	setDispSoldDt( String	dispSoldDt ) {
		this.dispSoldDt =	dispSoldDt;
	}
 
	/**
	 * Column Info
	 * @return	dispSoldDt
	 */
	 public	 String	getDispSoldDt() {
		 return	this.dispSoldDt;
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
	* @param  custNm
	*/
	public void	setCustNm( String	custNm ) {
		this.custNm =	custNm;
	}
 
	/**
	 * Column Info
	 * @return	custNm
	 */
	 public	 String	getCustNm() {
		 return	this.custNm;
	 } 
 	/**
	* Column Info
	* @param  pEndEvntDt
	*/
	public void	setPEndEvntDt( String	pEndEvntDt ) {
		this.pEndEvntDt =	pEndEvntDt;
	}
 
	/**
	 * Column Info
	 * @return	pEndEvntDt
	 */
	 public	 String	getPEndEvntDt() {
		 return	this.pEndEvntDt;
	 } 
 	/**
	* Column Info
	* @param  pLocCd
	*/
	public void	setPLocCd( String	pLocCd ) {
		this.pLocCd =	pLocCd;
	}
 
	/**
	 * Column Info
	 * @return	pLocCd
	 */
	 public	 String	getPLocCd() {
		 return	this.pLocCd;
	 } 
 	/**
	* Column Info
	* @param  aproOfcCd
	*/
	public void	setAproOfcCd( String	aproOfcCd ) {
		this.aproOfcCd =	aproOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	aproOfcCd
	 */
	 public	 String	getAproOfcCd() {
		 return	this.aproOfcCd;
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
	* @param  pLocTp
	*/
	public void	setPLocTp( String	pLocTp ) {
		this.pLocTp =	pLocTp;
	}
 
	/**
	 * Column Info
	 * @return	pLocTp
	 */
	 public	 String	getPLocTp() {
		 return	this.pLocTp;
	 } 
 	/**
	* Column Info
	* @param  partAmt
	*/
	public void	setPartAmt( String	partAmt ) {
		this.partAmt =	partAmt;
	}
 
	/**
	 * Column Info
	 * @return	partAmt
	 */
	 public	 String	getPartAmt() {
		 return	this.partAmt;
	 } 
 	/**
	* Column Info
	* @param  dispUtPrc
	*/
	public void	setDispUtPrc( String	dispUtPrc ) {
		this.dispUtPrc =	dispUtPrc;
	}
 
	/**
	 * Column Info
	 * @return	dispUtPrc
	 */
	 public	 String	getDispUtPrc() {
		 return	this.dispUtPrc;
	 } 
 	/**
	* Column Info
	* @param  pChkUsd
	*/
	public void	setPChkUsd( String	pChkUsd ) {
		this.pChkUsd =	pChkUsd;
	}
 
	/**
	 * Column Info
	 * @return	pChkUsd
	 */
	 public	 String	getPChkUsd() {
		 return	this.pChkUsd;
	 } 
 	/**
	* Column Info
	* @param  dispRsnCd
	*/
	public void	setDispRsnCd( String	dispRsnCd ) {
		this.dispRsnCd =	dispRsnCd;
	}
 
	/**
	 * Column Info
	 * @return	dispRsnCd
	 */
	 public	 String	getDispRsnCd() {
		 return	this.dispRsnCd;
	 } 
 	/**
	* Column Info
	* @param  dispTrfUtPrc
	*/
	public void	setDispTrfUtPrc( String	dispTrfUtPrc ) {
		this.dispTrfUtPrc =	dispTrfUtPrc;
	}
 
	/**
	 * Column Info
	 * @return	dispTrfUtPrc
	 */
	 public	 String	getDispTrfUtPrc() {
		 return	this.dispTrfUtPrc;
	 } 
 	/**
	* Column Info
	* @param  dispTpCd
	*/
	public void	setDispTpCd( String	dispTpCd ) {
		this.dispTpCd =	dispTpCd;
	}
 
	/**
	 * Column Info
	 * @return	dispTpCd
	 */
	 public	 String	getDispTpCd() {
		 return	this.dispTpCd;
	 } 
 	/**
	* Column Info
	* @param  calPartAmt
	*/
	public void	setCalPartAmt( String	calPartAmt ) {
		this.calPartAmt =	calPartAmt;
	}
 
	/**
	 * Column Info
	 * @return	calPartAmt
	 */
	 public	 String	getCalPartAmt() {
		 return	this.calPartAmt;
	 } 
 	/**
	* Column Info
	* @param  dispNo
	*/
	public void	setDispNo( String	dispNo ) {
		this.dispNo =	dispNo;
	}
 
	/**
	 * Column Info
	 * @return	dispNo
	 */
	 public	 String	getDispNo() {
		 return	this.dispNo;
	 } 
 	/**
	* Column Info
	* @param  rhqCd
	*/
	public void	setRhqCd( String	rhqCd ) {
		this.rhqCd =	rhqCd;
	}
 
	/**
	 * Column Info
	 * @return	rhqCd
	 */
	 public	 String	getRhqCd() {
		 return	this.rhqCd;
	 } 
 	/**
	* Column Info
	* @param  pStrEvntDt
	*/
	public void	setPStrEvntDt( String	pStrEvntDt ) {
		this.pStrEvntDt =	pStrEvntDt;
	}
 
	/**
	 * Column Info
	 * @return	pStrEvntDt
	 */
	 public	 String	getPStrEvntDt() {
		 return	this.pStrEvntDt;
	 } 
 	/**
	* Column Info
	* @param  rccCd
	*/
	public void	setRccCd( String	rccCd ) {
		this.rccCd =	rccCd;
	}
 
	/**
	 * Column Info
	 * @return	rccCd
	 */
	 public	 String	getRccCd() {
		 return	this.rccCd;
	 } 
 	/**
	* Column Info
	* @param  dispDtlSeq
	*/
	public void	setDispDtlSeq( String	dispDtlSeq ) {
		this.dispDtlSeq =	dispDtlSeq;
	}
 
	/**
	 * Column Info
	 * @return	dispDtlSeq
	 */
	 public	 String	getDispDtlSeq() {
		 return	this.dispDtlSeq;
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
	* @param  pDispTpCd
	*/
	public void	setPDispTpCd( String	pDispTpCd ) {
		this.pDispTpCd =	pDispTpCd;
	}
 
	/**
	 * Column Info
	 * @return	pDispTpCd
	 */
	 public	 String	getPDispTpCd() {
		 return	this.pDispTpCd;
	 } 
 	/**
	* Column Info
	* @param  pDispRsnCd
	*/
	public void	setPDispRsnCd( String	pDispRsnCd ) {
		this.pDispRsnCd =	pDispRsnCd;
	}
 
	/**
	 * Column Info
	 * @return	pDispRsnCd
	 */
	 public	 String	getPDispRsnCd() {
		 return	this.pDispRsnCd;
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
	* @param  dispVrfyTpCd
	*/
	public void	setDispVrfyTpCd( String	dispVrfyTpCd ) {
		this.dispVrfyTpCd =	dispVrfyTpCd;
	}
 
	/**
	 * Column Info
	 * @return	dispVrfyTpCd
	 */
	 public	 String	getDispVrfyTpCd() {
		 return	this.dispVrfyTpCd;
	 } 
 	/**
	* Column Info
	* @param  pCustCd
	*/
	public void	setPCustCd( String	pCustCd ) {
		this.pCustCd =	pCustCd;
	}
 
	/**
	 * Column Info
	 * @return	pCustCd
	 */
	 public	 String	getPCustCd() {
		 return	this.pCustCd;
	 } 
 	/**
	* Column Info
	* @param  lccCd
	*/
	public void	setLccCd( String	lccCd ) {
		this.lccCd =	lccCd;
	}
 
	/**
	 * Column Info
	 * @return	lccCd
	 */
	 public	 String	getLccCd() {
		 return	this.lccCd;
	 } 
 	/**
	* Column Info
	* @param  sccCd
	*/
	public void	setSccCd( String	sccCd ) {
		this.sccCd =	sccCd;
	}
 
	/**
	 * Column Info
	 * @return	sccCd
	 */
	 public	 String	getSccCd() {
		 return	this.sccCd;
	 } 
 	/**
	* Column Info
	* @param  dispYdCd
	*/
	public void	setDispYdCd( String	dispYdCd ) {
		this.dispYdCd =	dispYdCd;
	}
 
	/**
	 * Column Info
	 * @return	dispYdCd
	 */
	 public	 String	getDispYdCd() {
		 return	this.dispYdCd;
	 } 
 	/**
	* Column Info
	* @param  pVndrNm
	*/
	public void	setPVndrNm( String	pVndrNm ) {
		this.pVndrNm =	pVndrNm;
	}
 
	/**
	 * Column Info
	 * @return	pVndrNm
	 */
	 public	 String	getPVndrNm() {
		 return	this.pVndrNm;
	 } 
 	/**
	* Column Info
	* @param  custCd
	*/
	public void	setCustCd( String	custCd ) {
		this.custCd =	custCd;
	}
 
	/**
	 * Column Info
	 * @return	custCd
	 */
	 public	 String	getCustCd() {
		 return	this.custCd;
	 } 
 	/**
	* Column Info
	* @param  pEqKndCd
	*/
	public void	setPEqKndCd( String	pEqKndCd ) {
		this.pEqKndCd =	pEqKndCd;
	}
 
	/**
	 * Column Info
	 * @return	pEqKndCd
	 */
	 public	 String	getPEqKndCd() {
		 return	this.pEqKndCd;
	 } 
 	/**
	* Column Info
	* @param  rqstOfcCd
	*/
	public void	setRqstOfcCd( String	rqstOfcCd ) {
		this.rqstOfcCd =	rqstOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	rqstOfcCd
	 */
	 public	 String	getRqstOfcCd() {
		 return	this.rqstOfcCd;
	 } 
 	/**
	* Column Info
	* @param  dispVrfyTpNm
	*/
	public void	setDispVrfyTpNm( String	dispVrfyTpNm ) {
		this.dispVrfyTpNm =	dispVrfyTpNm;
	}
 
	/**
	 * Column Info
	 * @return	dispVrfyTpNm
	 */
	 public	 String	getDispVrfyTpNm() {
		 return	this.dispVrfyTpNm;
	 } 
 	/**
	* Column Info
	* @param  asetKnd
	*/
	public void	setAsetKnd( String	asetKnd ) {
		this.asetKnd =	asetKnd;
	}
 
	/**
	 * Column Info
	 * @return	asetKnd
	 */
	 public	 String	getAsetKnd() {
		 return	this.asetKnd;
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
	* @param  dispStsCd
	*/
	public void	setDispStsCd( String	dispStsCd ) {
		this.dispStsCd =	dispStsCd;
	}
 
	/**
	 * Column Info
	 * @return	dispStsCd
	 */
	 public	 String	getDispStsCd() {
		 return	this.dispStsCd;
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
	
	public String getRstrUsgLbl() {
		return rstrUsgLbl;
	}

	public void setRstrUsgLbl(String rstrUsgLbl) {
		this.rstrUsgLbl = rstrUsgLbl;
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
		setManuDt(JSPUtil.getParameter(request,	prefix + "manu_dt", ""));
		setDispSoldDt(JSPUtil.getParameter(request,	prefix + "disp_sold_dt", ""));
		setCurrCd(JSPUtil.getParameter(request,	prefix + "curr_cd", ""));
		setCustNm(JSPUtil.getParameter(request,	prefix + "cust_nm", ""));
		setPEndEvntDt(JSPUtil.getParameter(request,	prefix + "p_end_evnt_dt", ""));
		setPLocCd(JSPUtil.getParameter(request,	prefix + "p_loc_cd", ""));
		setAproOfcCd(JSPUtil.getParameter(request,	prefix + "apro_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setLocCd(JSPUtil.getParameter(request,	prefix + "loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request,	prefix + "eq_no", ""));
		setPLocTp(JSPUtil.getParameter(request,	prefix + "p_loc_tp", ""));
		setPartAmt(JSPUtil.getParameter(request,	prefix + "part_amt", ""));
		setDispUtPrc(JSPUtil.getParameter(request,	prefix + "disp_ut_prc", ""));
		setPChkUsd(JSPUtil.getParameter(request,	prefix + "p_chk_usd", ""));
		setDispRsnCd(JSPUtil.getParameter(request,	prefix + "disp_rsn_cd", ""));
		setDispTrfUtPrc(JSPUtil.getParameter(request,	prefix + "disp_trf_ut_prc", ""));
		setDispTpCd(JSPUtil.getParameter(request,	prefix + "disp_tp_cd", ""));
		setCalPartAmt(JSPUtil.getParameter(request,	prefix + "cal_part_amt", ""));
		setDispNo(JSPUtil.getParameter(request,	prefix + "disp_no", ""));
		setRhqCd(JSPUtil.getParameter(request,	prefix + "rhq_cd", ""));
		setPStrEvntDt(JSPUtil.getParameter(request,	prefix + "p_str_evnt_dt", ""));
		setRccCd(JSPUtil.getParameter(request,	prefix + "rcc_cd", ""));
		setDispDtlSeq(JSPUtil.getParameter(request,	prefix + "disp_dtl_seq", ""));
		setEqKndCd(JSPUtil.getParameter(request,	prefix + "eq_knd_cd", ""));
		setPDispTpCd(JSPUtil.getParameter(request,	prefix + "p_disp_tp_cd", ""));
		setPDispRsnCd(JSPUtil.getParameter(request,	prefix + "p_disp_rsn_cd", ""));
		setEqTpszCd(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd", ""));
		setDispVrfyTpCd(JSPUtil.getParameter(request,	prefix + "disp_vrfy_tp_cd", ""));
		setPCustCd(JSPUtil.getParameter(request,	prefix + "p_cust_cd", ""));
		setLccCd(JSPUtil.getParameter(request,	prefix + "lcc_cd", ""));
		setSccCd(JSPUtil.getParameter(request,	prefix + "scc_cd", ""));
		setDispYdCd(JSPUtil.getParameter(request,	prefix + "disp_yd_cd", ""));
		setPVndrNm(JSPUtil.getParameter(request,	prefix + "p_vndr_nm", ""));
		setCustCd(JSPUtil.getParameter(request,	prefix + "cust_cd", ""));
		setPEqKndCd(JSPUtil.getParameter(request,	prefix + "p_eq_knd_cd", ""));
		setRqstOfcCd(JSPUtil.getParameter(request,	prefix + "rqst_ofc_cd", ""));
		setDispVrfyTpNm(JSPUtil.getParameter(request,	prefix + "disp_vrfy_tp_nm", ""));
		setAsetKnd(JSPUtil.getParameter(request,	prefix + "aset_knd", ""));
		setLessorNm(JSPUtil.getParameter(request,	prefix + "lessor_nm", ""));
		setLstmCd(JSPUtil.getParameter(request,	prefix + "lstm_cd", ""));
		setRstrUsgLblNm(JSPUtil.getParameter(request,	prefix + "rstr_usg_lbl_nm", ""));
		setDispStsCd(JSPUtil.getParameter(request,	prefix + "disp_sts_cd", ""));
		setInvNo(JSPUtil.getParameter(request,	prefix + "inv_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request,	prefix + "upd_dt", ""));
		setRstrUsgLblTp(JSPUtil.getParameter(request,	prefix + "rstr_usg_lbl_tp", ""));
		setRstrUsgLblVal(JSPUtil.getParameter(request,	prefix + "rstr_usg_lbl_val", ""));
		setRstrUsgLbl(JSPUtil.getParameter(request,	prefix + "rstr_usg_lbl", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DisposalPFMCByEqDetailVO[]
	 */
	public DisposalPFMCByEqDetailVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return DisposalPFMCByEqDetailVO[]
	 */
	public DisposalPFMCByEqDetailVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		DisposalPFMCByEqDetailVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] rprCostAmt =	(JSPUtil.getParameter(request, prefix +	"rpr_cost_amt".trim(),	length));
				String[] manuDt =	(JSPUtil.getParameter(request, prefix +	"manu_dt".trim(),	length));
				String[] dispSoldDt =	(JSPUtil.getParameter(request, prefix +	"disp_sold_dt".trim(),	length));
				String[] currCd =	(JSPUtil.getParameter(request, prefix +	"curr_cd".trim(),	length));
				String[] custNm =	(JSPUtil.getParameter(request, prefix +	"cust_nm".trim(),	length));
				String[] pEndEvntDt =	(JSPUtil.getParameter(request, prefix +	"p_end_evnt_dt".trim(),	length));
				String[] pLocCd =	(JSPUtil.getParameter(request, prefix +	"p_loc_cd".trim(),	length));
				String[] aproOfcCd =	(JSPUtil.getParameter(request, prefix +	"apro_ofc_cd".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] locCd =	(JSPUtil.getParameter(request, prefix +	"loc_cd".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] eqNo =	(JSPUtil.getParameter(request, prefix +	"eq_no".trim(),	length));
				String[] pLocTp =	(JSPUtil.getParameter(request, prefix +	"p_loc_tp".trim(),	length));
				String[] partAmt =	(JSPUtil.getParameter(request, prefix +	"part_amt".trim(),	length));
				String[] dispUtPrc =	(JSPUtil.getParameter(request, prefix +	"disp_ut_prc".trim(),	length));
				String[] pChkUsd =	(JSPUtil.getParameter(request, prefix +	"p_chk_usd".trim(),	length));
				String[] dispRsnCd =	(JSPUtil.getParameter(request, prefix +	"disp_rsn_cd".trim(),	length));
				String[] dispTrfUtPrc =	(JSPUtil.getParameter(request, prefix +	"disp_trf_ut_prc".trim(),	length));
				String[] dispTpCd =	(JSPUtil.getParameter(request, prefix +	"disp_tp_cd".trim(),	length));
				String[] calPartAmt =	(JSPUtil.getParameter(request, prefix +	"cal_part_amt".trim(),	length));
				String[] dispNo =	(JSPUtil.getParameter(request, prefix +	"disp_no".trim(),	length));
				String[] rhqCd =	(JSPUtil.getParameter(request, prefix +	"rhq_cd".trim(),	length));
				String[] pStrEvntDt =	(JSPUtil.getParameter(request, prefix +	"p_str_evnt_dt".trim(),	length));
				String[] rccCd =	(JSPUtil.getParameter(request, prefix +	"rcc_cd".trim(),	length));
				String[] dispDtlSeq =	(JSPUtil.getParameter(request, prefix +	"disp_dtl_seq".trim(),	length));
				String[] eqKndCd =	(JSPUtil.getParameter(request, prefix +	"eq_knd_cd".trim(),	length));
				String[] pDispTpCd =	(JSPUtil.getParameter(request, prefix +	"p_disp_tp_cd".trim(),	length));
				String[] pDispRsnCd =	(JSPUtil.getParameter(request, prefix +	"p_disp_rsn_cd".trim(),	length));
				String[] eqTpszCd =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd".trim(),	length));
				String[] dispVrfyTpCd =	(JSPUtil.getParameter(request, prefix +	"disp_vrfy_tp_cd".trim(),	length));
				String[] pCustCd =	(JSPUtil.getParameter(request, prefix +	"p_cust_cd".trim(),	length));
				String[] lccCd =	(JSPUtil.getParameter(request, prefix +	"lcc_cd".trim(),	length));
				String[] sccCd =	(JSPUtil.getParameter(request, prefix +	"scc_cd".trim(),	length));
				String[] dispYdCd =	(JSPUtil.getParameter(request, prefix +	"disp_yd_cd".trim(),	length));
				String[] pVndrNm =	(JSPUtil.getParameter(request, prefix +	"p_vndr_nm".trim(),	length));
				String[] custCd =	(JSPUtil.getParameter(request, prefix +	"cust_cd".trim(),	length));
				String[] pEqKndCd =	(JSPUtil.getParameter(request, prefix +	"p_eq_knd_cd".trim(),	length));
				String[] rqstOfcCd =	(JSPUtil.getParameter(request, prefix +	"rqst_ofc_cd".trim(),	length));
				String[] dispVrfyTpNm =	(JSPUtil.getParameter(request, prefix +	"disp_vrfy_tp_nm".trim(),	length));
				String[] asetKnd =	(JSPUtil.getParameter(request, prefix +	"aset_knd".trim(),	length));
				String[] lessorNm =	(JSPUtil.getParameter(request, prefix +	"lessor_nm".trim(),	length));
				String[] lstmCd =	(JSPUtil.getParameter(request, prefix +	"lstm_cd".trim(),	length));
				String[] rstrUsgLblNm =	(JSPUtil.getParameter(request, prefix +	"rstr_usg_lbl_nm".trim(),	length));
				String[] dispStsCd =	(JSPUtil.getParameter(request, prefix +	"disp_sts_cd".trim(),	length));
				String[] invNo =	(JSPUtil.getParameter(request, prefix +	"inv_no".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] updDt =	(JSPUtil.getParameter(request, prefix +	"upd_dt".trim(),	length));
				String[] rstrUsgLblTp =	(JSPUtil.getParameter(request, prefix +	"rstr_usg_lbl_tp".trim(),	length));
				String[] rstrUsgLblVal = (JSPUtil.getParameter(request, prefix +	"rstr_usg_lbl_val".trim(),	length));
				String[] rstrUsgLbl = (JSPUtil.getParameter(request, prefix +	"rstr_usg_lbl".trim(),	length));
				
				for	(int i = 0;	i <	length;	i++) {
					model =	new	DisposalPFMCByEqDetailVO();
						if ( rprCostAmt[i] !=	null)
						model.setRprCostAmt( rprCostAmt[i]);
						if ( manuDt[i] !=	null)
						model.setManuDt( manuDt[i]);
						if ( dispSoldDt[i] !=	null)
						model.setDispSoldDt( dispSoldDt[i]);
						if ( currCd[i] !=	null)
						model.setCurrCd( currCd[i]);
						if ( custNm[i] !=	null)
						model.setCustNm( custNm[i]);
						if ( pEndEvntDt[i] !=	null)
						model.setPEndEvntDt( pEndEvntDt[i]);
						if ( pLocCd[i] !=	null)
						model.setPLocCd( pLocCd[i]);
						if ( aproOfcCd[i] !=	null)
						model.setAproOfcCd( aproOfcCd[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( locCd[i] !=	null)
						model.setLocCd( locCd[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( eqNo[i] !=	null)
						model.setEqNo( eqNo[i]);
						if ( pLocTp[i] !=	null)
						model.setPLocTp( pLocTp[i]);
						if ( partAmt[i] !=	null)
						model.setPartAmt( partAmt[i]);
						if ( dispUtPrc[i] !=	null)
						model.setDispUtPrc( dispUtPrc[i]);
						if ( pChkUsd[i] !=	null)
						model.setPChkUsd( pChkUsd[i]);
						if ( dispRsnCd[i] !=	null)
						model.setDispRsnCd( dispRsnCd[i]);
						if ( dispTrfUtPrc[i] !=	null)
						model.setDispTrfUtPrc( dispTrfUtPrc[i]);
						if ( dispTpCd[i] !=	null)
						model.setDispTpCd( dispTpCd[i]);
						if ( calPartAmt[i] !=	null)
						model.setCalPartAmt( calPartAmt[i]);
						if ( dispNo[i] !=	null)
						model.setDispNo( dispNo[i]);
						if ( rhqCd[i] !=	null)
						model.setRhqCd( rhqCd[i]);
						if ( pStrEvntDt[i] !=	null)
						model.setPStrEvntDt( pStrEvntDt[i]);
						if ( rccCd[i] !=	null)
						model.setRccCd( rccCd[i]);
						if ( dispDtlSeq[i] !=	null)
						model.setDispDtlSeq( dispDtlSeq[i]);
						if ( eqKndCd[i] !=	null)
						model.setEqKndCd( eqKndCd[i]);
						if ( pDispTpCd[i] !=	null)
						model.setPDispTpCd( pDispTpCd[i]);
						if ( pDispRsnCd[i] !=	null)
						model.setPDispRsnCd( pDispRsnCd[i]);
						if ( eqTpszCd[i] !=	null)
						model.setEqTpszCd( eqTpszCd[i]);
						if ( dispVrfyTpCd[i] !=	null)
						model.setDispVrfyTpCd( dispVrfyTpCd[i]);
						if ( pCustCd[i] !=	null)
						model.setPCustCd( pCustCd[i]);
						if ( lccCd[i] !=	null)
						model.setLccCd( lccCd[i]);
						if ( sccCd[i] !=	null)
						model.setSccCd( sccCd[i]);
						if ( dispYdCd[i] !=	null)
						model.setDispYdCd( dispYdCd[i]);
						if ( pVndrNm[i] !=	null)
						model.setPVndrNm( pVndrNm[i]);
						if ( custCd[i] !=	null)
						model.setCustCd( custCd[i]);
						if ( pEqKndCd[i] !=	null)
						model.setPEqKndCd( pEqKndCd[i]);
						if ( rqstOfcCd[i] !=	null)
						model.setRqstOfcCd( rqstOfcCd[i]);
						if ( dispVrfyTpNm[i] !=	null)
						model.setDispVrfyTpNm( dispVrfyTpNm[i]);
						if ( asetKnd[i] !=	null)
						model.setAsetKnd( asetKnd[i]);
						if ( lessorNm[i] !=	null)
						model.setLessorNm( lessorNm[i]);
						if ( lstmCd[i] !=	null)
						model.setLstmCd( lstmCd[i]);
						if ( rstrUsgLblNm[i] !=	null)
						model.setRstrUsgLblNm( rstrUsgLblNm[i]);
						if ( dispStsCd[i] !=	null)
						model.setDispStsCd( dispStsCd[i]);
						if ( invNo[i] !=	null)
						model.setInvNo( invNo[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( updDt[i] !=	null)
						model.setUpdDt( updDt[i]);
						if ( rstrUsgLblTp[i] !=	null)
						model.setRstrUsgLblTp( rstrUsgLblTp[i]);
						if ( rstrUsgLblVal[i] !=	null)
						model.setRstrUsgLblVal( rstrUsgLblVal[i]);
						if ( rstrUsgLbl[i] !=	null)
						model.setRstrUsgLbl( rstrUsgLbl[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getDisposalPFMCByEqDetailVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return DisposalPFMCByEqDetailVO[]
	 */
	public DisposalPFMCByEqDetailVO[]	 getDisposalPFMCByEqDetailVOs(){
		DisposalPFMCByEqDetailVO[] vos = (DisposalPFMCByEqDetailVO[])models.toArray(new	DisposalPFMCByEqDetailVO[models.size()]);
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
		this.manuDt =	this.manuDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispSoldDt =	this.dispSoldDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd =	this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm =	this.custNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pEndEvntDt =	this.pEndEvntDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pLocCd =	this.pLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproOfcCd =	this.aproOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd =	this.locCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo =	this.eqNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pLocTp =	this.pLocTp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.partAmt =	this.partAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispUtPrc =	this.dispUtPrc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pChkUsd =	this.pChkUsd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispRsnCd =	this.dispRsnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispTrfUtPrc =	this.dispTrfUtPrc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispTpCd =	this.dispTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calPartAmt =	this.calPartAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispNo =	this.dispNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd =	this.rhqCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pStrEvntDt =	this.pStrEvntDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rccCd =	this.rccCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispDtlSeq =	this.dispDtlSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd =	this.eqKndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDispTpCd =	this.pDispTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDispRsnCd =	this.pDispRsnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd =	this.eqTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispVrfyTpCd =	this.dispVrfyTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pCustCd =	this.pCustCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lccCd =	this.lccCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sccCd =	this.sccCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispYdCd =	this.dispYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pVndrNm =	this.pVndrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd =	this.custCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pEqKndCd =	this.pEqKndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstOfcCd =	this.rqstOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispVrfyTpNm =	this.dispVrfyTpNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asetKnd =	this.asetKnd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lessorNm =	this.lessorNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd =	this.lstmCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rstrUsgLblNm =	this.rstrUsgLblNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispStsCd =	this.dispStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo =	this.invNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt =	this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rstrUsgLblTp =	this.rstrUsgLblTp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rstrUsgLblVal = this.rstrUsgLblVal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rstrUsgLbl = this.rstrUsgLbl.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}