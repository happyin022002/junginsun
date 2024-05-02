/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : WorkOrderBFIManagementVO.java
 *@FileTitle : WorkOrderBFIManagementVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.11.18
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2014.11.18  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.esd.trs.workordermanage.workordermanagement.vo;

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
public class WorkOrderBFIManagementVO	extends	 AbstractValueObject {

	private	 static final long serialVersionUID = 1L;

	private	 Collection<WorkOrderBFIManagementVO>  models =	new	ArrayList<WorkOrderBFIManagementVO>();

	/*	Column Info	*/
	private  String	 updDt   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 creDt   =  null;
	/*	Column Info	*/
	private  String	 trsChk   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 creOfcCd   =  null;
	/*	Column Info	*/
	private  String	 fmDt   =  null;
	/*	Column Info	*/
	private  String	 toDt   =  null;
	/*	Column Info	*/
	private  String	 woVndrSeq   =  null;
	/*	Column Info	*/
	private  String	 vndrLglEngNm   =  null;
	/*	Column Info	*/
	private  String	 vndrEml   =  null;
	/*	Column Info	*/
	private  String	 todayDt   =  null;
	/*	Column Info	*/
	private  String	 cntcPsonNm   =  null;
	/*	Column Info	*/
	private  String	 trspWoNo   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCd   =  null;
	/*	Column Info	*/
	private  String	 fmNodCd   =  null;
	/*	Column Info	*/
	private  String	 viaNodCd   =  null;
	/*	Column Info	*/
	private  String	 toNodCd   =  null;
	/*	Column Info	*/
	private  String	 dorNodCd   =  null;
	private  String	 dorNodNm   =  null;
	/*	Column Info	*/
	private  String	 dorNodPlnDt   =  null;
	/*	Column Info	*/
	private  String	 lstNodPlnDt   =  null;
	/*	Column Info	*/
	private  String	 currCd   =  null;
	/*	Column Info	*/
	private  String	 bzcAmtDesc   =  null;
	/*	Column Info	*/
	private  String	 negoAmtDesc   =  null;
	/*	Column Info	*/
	private  String	 fuelScgAmtDesc   =  null;
	/*	Column Info	*/
	private  String	 etcAddAmtDesc   =  null;
	/*	Column Info	*/
	private  String	 bzcAmt   =  null;
	/*	Column Info	*/
	private  String	 negoAmt   =  null;
	/*	Column Info	*/
	private  String	 fuelScgAmt   =  null;
	/*	Column Info	*/
	private  String	 etcAddAmt   =  null;
	/*	Column Info	*/
	private  String	 eqNo   =  null;
	/*	Column Info	*/
	private  String	 cgoTpCd   =  null;
	/*	Column Info	*/
	private  String	 trsSubStsCd   =  null;
	/*	Column Info	*/
	private  String	 vndrSeq   =  null;
	/*	Column Info	*/
	private  String	 tempNotSp   =  null;

	/* Down Excel For Invoice */
	private  String	 trspSoNo   =  null;
	private  String	 invNo   =  null;
	private  String	 totInvAmt   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public WorkOrderBFIManagementVO(){}

	public WorkOrderBFIManagementVO(String updDt,String creUsrId,String ibflag,String creDt,String trsChk,String updUsrId,String pagerows,String creOfcCd,String fmDt,String toDt,String woVndrSeq,String vndrLglEngNm,String vndrEml,String todayDt,String cntcPsonNm,String trspWoNo,String eqTpszCd,String fmNodCd,String viaNodCd,String toNodCd,String dorNodCd,String	dorNodNm,String dorNodPlnDt,String lstNodPlnDt,String currCd,String bzcAmtDesc,String negoAmtDesc,String fuelScgAmtDesc,String etcAddAmtDesc,String bzcAmt,String negoAmt,String fuelScgAmt,String etcAddAmt,String eqNo,String cgoTpCd,String trsSubStsCd,String vndrSeq,String tempNotSp, String trspSoNo, String invNo, String totInvAmt) {
		this.updDt  = updDt ;
		this.creUsrId  = creUsrId ;
		this.ibflag  = ibflag ;
		this.creDt  = creDt ;
		this.trsChk  = trsChk ;
		this.updUsrId  = updUsrId ;
		this.pagerows  = pagerows ;
		this.creOfcCd  = creOfcCd ;
		this.fmDt  = fmDt ;
		this.toDt  = toDt ;
		this.woVndrSeq  = woVndrSeq ;
		this.vndrLglEngNm  = vndrLglEngNm ;
		this.vndrEml  = vndrEml ;
		this.todayDt  = todayDt ;
		this.cntcPsonNm  = cntcPsonNm ;
		this.trspWoNo  = trspWoNo ;
		this.eqTpszCd  = eqTpszCd ;
		this.fmNodCd  = fmNodCd ;
		this.viaNodCd  = viaNodCd ;
		this.toNodCd  = toNodCd ;
		this.dorNodCd  = dorNodCd ;
		this.dorNodNm = dorNodNm;
		this.dorNodPlnDt  = dorNodPlnDt ;
		this.lstNodPlnDt  = lstNodPlnDt ;
		this.currCd  = currCd ;
		this.bzcAmtDesc  = bzcAmtDesc ;
		this.negoAmtDesc  = negoAmtDesc ;
		this.fuelScgAmtDesc  = fuelScgAmtDesc ;
		this.etcAddAmtDesc  = etcAddAmtDesc ;
		this.bzcAmt  = bzcAmt ;
		this.negoAmt  = negoAmt ;
		this.fuelScgAmt  = fuelScgAmt ;
		this.etcAddAmt  = etcAddAmt ;
		this.eqNo  = eqNo ;
		this.cgoTpCd  = cgoTpCd ;
		this.trsSubStsCd  = trsSubStsCd ;
		this.vndrSeq  = vndrSeq ;
		this.tempNotSp  = tempNotSp ;
		/* Down Excel For Invoice */
		this.trspSoNo   =  trspSoNo;
		this.invNo   =  invNo;
		this.totInvAmt = totInvAmt;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("trs_chk", getTrsChk());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("fm_dt", getFmDt());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("wo_vndr_seq", getWoVndrSeq());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("vndr_eml", getVndrEml());
		this.hashColumns.put("today_dt", getTodayDt());
		this.hashColumns.put("cntc_pson_nm", getCntcPsonNm());
		this.hashColumns.put("trsp_wo_no", getTrspWoNo());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("fm_nod_cd", getFmNodCd());
		this.hashColumns.put("via_nod_cd", getViaNodCd());
		this.hashColumns.put("to_nod_cd", getToNodCd());
		this.hashColumns.put("dor_nod_cd", getDorNodCd());
		this.hashColumns.put("dor_nod_nm", getDorNodNm());
		this.hashColumns.put("dor_nod_pln_dt", getDorNodPlnDt());
		this.hashColumns.put("lst_nod_pln_dt", getLstNodPlnDt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("bzc_amt_desc", getBzcAmtDesc());
		this.hashColumns.put("nego_amt_desc", getNegoAmtDesc());
		this.hashColumns.put("fuel_scg_amt_desc", getFuelScgAmtDesc());
		this.hashColumns.put("etc_add_amt_desc", getEtcAddAmtDesc());
		this.hashColumns.put("bzc_amt", getBzcAmt());
		this.hashColumns.put("nego_amt", getNegoAmt());
		this.hashColumns.put("fuel_scg_amt", getFuelScgAmt());
		this.hashColumns.put("etc_add_amt", getEtcAddAmt());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("cgo_tp_cd", getCgoTpCd());
		this.hashColumns.put("trs_sub_sts_cd", getTrsSubStsCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("temp_not_sp", getTempNotSp());
		/* Down Excel For Invoice */
		this.hashColumns.put("trsp_so_no", getTrspSoNo());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("tot_inv_amt", getTotInvAmt());
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("trs_chk", "trsChk");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("fm_dt", "fmDt");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("wo_vndr_seq", "woVndrSeq");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("vndr_eml", "vndrEml");
		this.hashFields.put("today_dt", "todayDt");
		this.hashFields.put("cntc_pson_nm", "cntcPsonNm");
		this.hashFields.put("trsp_wo_no", "trspWoNo");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("fm_nod_cd", "fmNodCd");
		this.hashFields.put("via_nod_cd", "viaNodCd");
		this.hashFields.put("to_nod_cd", "toNodCd");
		this.hashFields.put("dor_nod_cd", "dorNodCd");
		this.hashFields.put("dor_nod_nm", "dorNodNm");
		this.hashFields.put("dor_nod_pln_dt", "dorNodPlnDt");
		this.hashFields.put("lst_nod_pln_dt", "lstNodPlnDt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("bzc_amt_desc", "bzcAmtDesc");
		this.hashFields.put("nego_amt_desc", "negoAmtDesc");
		this.hashFields.put("fuel_scg_amt_desc", "fuelScgAmtDesc");
		this.hashFields.put("etc_add_amt_desc", "etcAddAmtDesc");
		this.hashFields.put("bzc_amt", "bzcAmt");
		this.hashFields.put("nego_amt", "negoAmt");
		this.hashFields.put("fuel_scg_amt", "fuelScgAmt");
		this.hashFields.put("etc_add_amt", "etcAddAmt");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("cgo_tp_cd", "cgoTpCd");
		this.hashFields.put("trs_sub_sts_cd", "trsSubStsCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("temp_not_sp", "tempNotSp");
		/* Down Excel For Invoice */
		this.hashFields.put("trsp_so_no", "trspSoNo");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("tot_inv_amt", "totInvAmt");
		return this.hashFields;
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
	* @param  trsChk
	*/
	public void	setTrsChk( String	trsChk ) {
		this.trsChk =	trsChk;
	}
 
	/**
	 * Column Info
	 * @return	trsChk
	 */
	 public	 String	getTrsChk() {
		 return	this.trsChk;
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
	* @param  creOfcCd
	*/
	public void	setCreOfcCd( String	creOfcCd ) {
		this.creOfcCd =	creOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	creOfcCd
	 */
	 public	 String	getCreOfcCd() {
		 return	this.creOfcCd;
	 } 
 	/**
	* Column Info
	* @param  fmDt
	*/
	public void	setFmDt( String	fmDt ) {
		this.fmDt =	fmDt;
	}
 
	/**
	 * Column Info
	 * @return	fmDt
	 */
	 public	 String	getFmDt() {
		 return	this.fmDt;
	 } 
 	/**
	* Column Info
	* @param  toDt
	*/
	public void	setToDt( String	toDt ) {
		this.toDt =	toDt;
	}
 
	/**
	 * Column Info
	 * @return	toDt
	 */
	 public	 String	getToDt() {
		 return	this.toDt;
	 } 
 	/**
	* Column Info
	* @param  woVndrSeq
	*/
	public void	setWoVndrSeq( String	woVndrSeq ) {
		this.woVndrSeq =	woVndrSeq;
	}
 
	/**
	 * Column Info
	 * @return	woVndrSeq
	 */
	 public	 String	getWoVndrSeq() {
		 return	this.woVndrSeq;
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
	* @param  vndrEml
	*/
	public void	setVndrEml( String	vndrEml ) {
		this.vndrEml =	vndrEml;
	}
 
	/**
	 * Column Info
	 * @return	vndrEml
	 */
	 public	 String	getVndrEml() {
		 return	this.vndrEml;
	 } 
 	/**
	* Column Info
	* @param  todayDt
	*/
	public void	setTodayDt( String	todayDt ) {
		this.todayDt =	todayDt;
	}
 
	/**
	 * Column Info
	 * @return	todayDt
	 */
	 public	 String	getTodayDt() {
		 return	this.todayDt;
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
	 public	 String	getCntcPsonNm() {
		 return	this.cntcPsonNm;
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
	 public	 String	getTrspWoNo() {
		 return	this.trspWoNo;
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
	* @param  fmNodCd
	*/
	public void	setFmNodCd( String	fmNodCd ) {
		this.fmNodCd =	fmNodCd;
	}
 
	/**
	 * Column Info
	 * @return	fmNodCd
	 */
	 public	 String	getFmNodCd() {
		 return	this.fmNodCd;
	 } 
 	/**
	* Column Info
	* @param  viaNodCd
	*/
	public void	setViaNodCd( String	viaNodCd ) {
		this.viaNodCd =	viaNodCd;
	}
 
	/**
	 * Column Info
	 * @return	viaNodCd
	 */
	 public	 String	getViaNodCd() {
		 return	this.viaNodCd;
	 } 
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
	* @param  dorNodCd
	*/
	public void	setDorNodCd( String	dorNodCd ) {
		this.dorNodCd =	dorNodCd;
	}
 
	/**
	 * Column Info
	 * @return	dorNodCd
	 */
	 public	 String	getDorNodCd() {
		 return	this.dorNodCd;
	 } 
 	/**
	* Column Info
	* @param  dorNodPlnDt
	*/
	public void	setDorNodPlnDt( String	dorNodPlnDt ) {
		this.dorNodPlnDt =	dorNodPlnDt;
	}
 
	/**
	 * Column Info
	 * @return	dorNodPlnDt
	 */
	 public	 String	getDorNodPlnDt() {
		 return	this.dorNodPlnDt;
	 } 
 	/**
	* Column Info
	* @param  lstNodPlnDt
	*/
	public void	setLstNodPlnDt( String	lstNodPlnDt ) {
		this.lstNodPlnDt =	lstNodPlnDt;
	}
 
	/**
	 * Column Info
	 * @return	lstNodPlnDt
	 */
	 public	 String	getLstNodPlnDt() {
		 return	this.lstNodPlnDt;
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
	* @param  bzcAmtDesc
	*/
	public void	setBzcAmtDesc( String	bzcAmtDesc ) {
		this.bzcAmtDesc =	bzcAmtDesc;
	}
 
	/**
	 * Column Info
	 * @return	bzcAmtDesc
	 */
	 public	 String	getBzcAmtDesc() {
		 return	this.bzcAmtDesc;
	 } 
 	/**
	* Column Info
	* @param  negoAmtDesc
	*/
	public void	setNegoAmtDesc( String	negoAmtDesc ) {
		this.negoAmtDesc =	negoAmtDesc;
	}
 
	/**
	 * Column Info
	 * @return	negoAmtDesc
	 */
	 public	 String	getNegoAmtDesc() {
		 return	this.negoAmtDesc;
	 } 
 	/**
	* Column Info
	* @param  fuelScgAmtDesc
	*/
	public void	setFuelScgAmtDesc( String	fuelScgAmtDesc ) {
		this.fuelScgAmtDesc =	fuelScgAmtDesc;
	}
 
	/**
	 * Column Info
	 * @return	fuelScgAmtDesc
	 */
	 public	 String	getFuelScgAmtDesc() {
		 return	this.fuelScgAmtDesc;
	 } 
 	/**
	* Column Info
	* @param  etcAddAmtDesc
	*/
	public void	setEtcAddAmtDesc( String	etcAddAmtDesc ) {
		this.etcAddAmtDesc =	etcAddAmtDesc;
	}
 
	/**
	 * Column Info
	 * @return	etcAddAmtDesc
	 */
	 public	 String	getEtcAddAmtDesc() {
		 return	this.etcAddAmtDesc;
	 } 
 	/**
	* Column Info
	* @param  bzcAmt
	*/
	public void	setBzcAmt( String	bzcAmt ) {
		this.bzcAmt =	bzcAmt;
	}
 
	/**
	 * Column Info
	 * @return	bzcAmt
	 */
	 public	 String	getBzcAmt() {
		 return	this.bzcAmt;
	 } 
 	/**
	* Column Info
	* @param  negoAmt
	*/
	public void	setNegoAmt( String	negoAmt ) {
		this.negoAmt =	negoAmt;
	}
 
	/**
	 * Column Info
	 * @return	negoAmt
	 */
	 public	 String	getNegoAmt() {
		 return	this.negoAmt;
	 } 
 	/**
	* Column Info
	* @param  fuelScgAmt
	*/
	public void	setFuelScgAmt( String	fuelScgAmt ) {
		this.fuelScgAmt =	fuelScgAmt;
	}
 
	/**
	 * Column Info
	 * @return	fuelScgAmt
	 */
	 public	 String	getFuelScgAmt() {
		 return	this.fuelScgAmt;
	 } 
 	/**
	* Column Info
	* @param  etcAddAmt
	*/
	public void	setEtcAddAmt( String	etcAddAmt ) {
		this.etcAddAmt =	etcAddAmt;
	}
 
	/**
	 * Column Info
	 * @return	etcAddAmt
	 */
	 public	 String	getEtcAddAmt() {
		 return	this.etcAddAmt;
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
	* @param  cgoTpCd
	*/
	public void	setCgoTpCd( String	cgoTpCd ) {
		this.cgoTpCd =	cgoTpCd;
	}
 
	/**
	 * Column Info
	 * @return	cgoTpCd
	 */
	 public	 String	getCgoTpCd() {
		 return	this.cgoTpCd;
	 } 
 	/**
	* Column Info
	* @param  trsSubStsCd
	*/
	public void	setTrsSubStsCd( String	trsSubStsCd ) {
		this.trsSubStsCd =	trsSubStsCd;
	}
 
	/**
	 * Column Info
	 * @return	trsSubStsCd
	 */
	 public	 String	getTrsSubStsCd() {
		 return	this.trsSubStsCd;
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
	* @param  tempNotSp
	*/
	public void	setTempNotSp( String	tempNotSp ) {
		this.tempNotSp =	tempNotSp;
	}
 
	/**
	 * Column Info
	 * @return	tempNotSp
	 */
	 public	 String	getTempNotSp() {
		 return	this.tempNotSp;
	 } 

	public String getTrspSoNo() {
		return trspSoNo;
	}
	
	public void setTrspSoNo(String trspSoNo) {
		this.trspSoNo = trspSoNo;
	}
	
	public String getInvNo() {
		return invNo;
	}
	
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}
	
	public String getTotInvAmt() {
		return totInvAmt;
	}
	
	public void setTotInvAmt(String totInvAmt) {
		this.totInvAmt = totInvAmt;
	}

	public String getDorNodNm() {
		return dorNodNm;
	}

	public void setDorNodNm(String dorNodNm) {
		this.dorNodNm = dorNodNm;
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
		setUpdDt(JSPUtil.getParameter(request,	prefix + "upd_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setCreDt(JSPUtil.getParameter(request,	prefix + "cre_dt", ""));
		setTrsChk(JSPUtil.getParameter(request,	prefix + "trs_chk", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setCreOfcCd(JSPUtil.getParameter(request,	prefix + "cre_ofc_cd", ""));
		setFmDt(JSPUtil.getParameter(request,	prefix + "fm_dt", ""));
		setToDt(JSPUtil.getParameter(request,	prefix + "to_dt", ""));
		setWoVndrSeq(JSPUtil.getParameter(request,	prefix + "wo_vndr_seq", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request,	prefix + "vndr_lgl_eng_nm", ""));
		setVndrEml(JSPUtil.getParameter(request,	prefix + "vndr_eml", ""));
		setTodayDt(JSPUtil.getParameter(request,	prefix + "today_dt", ""));
		setCntcPsonNm(JSPUtil.getParameter(request,	prefix + "cntc_pson_nm", ""));
		setTrspWoNo(JSPUtil.getParameter(request,	prefix + "trsp_wo_no", ""));
		setEqTpszCd(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd", ""));
		setFmNodCd(JSPUtil.getParameter(request,	prefix + "fm_nod_cd", ""));
		setViaNodCd(JSPUtil.getParameter(request,	prefix + "via_nod_cd", ""));
		setToNodCd(JSPUtil.getParameter(request,	prefix + "to_nod_cd", ""));
		setDorNodCd(JSPUtil.getParameter(request,	prefix + "dor_nod_cd", ""));
		setDorNodNm(JSPUtil.getParameter(request,	prefix + "dor_nod_nm", ""));
		setDorNodPlnDt(JSPUtil.getParameter(request,	prefix + "dor_nod_pln_dt", ""));
		setLstNodPlnDt(JSPUtil.getParameter(request,	prefix + "lst_nod_pln_dt", ""));
		setCurrCd(JSPUtil.getParameter(request,	prefix + "curr_cd", ""));
		setBzcAmtDesc(JSPUtil.getParameter(request,	prefix + "bzc_amt_desc", ""));
		setNegoAmtDesc(JSPUtil.getParameter(request,	prefix + "nego_amt_desc", ""));
		setFuelScgAmtDesc(JSPUtil.getParameter(request,	prefix + "fuel_scg_amt_desc", ""));
		setEtcAddAmtDesc(JSPUtil.getParameter(request,	prefix + "etc_add_amt_desc", ""));
		setBzcAmt(JSPUtil.getParameter(request,	prefix + "bzc_amt", ""));
		setNegoAmt(JSPUtil.getParameter(request,	prefix + "nego_amt", ""));
		setFuelScgAmt(JSPUtil.getParameter(request,	prefix + "fuel_scg_amt", ""));
		setEtcAddAmt(JSPUtil.getParameter(request,	prefix + "etc_add_amt", ""));
		setEqNo(JSPUtil.getParameter(request,	prefix + "eq_no", ""));
		setCgoTpCd(JSPUtil.getParameter(request,	prefix + "cgo_tp_cd", ""));
		setTrsSubStsCd(JSPUtil.getParameter(request,	prefix + "trs_sub_sts_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request,	prefix + "vndr_seq", ""));
		setTempNotSp(JSPUtil.getParameter(request,	prefix + "temp_not_sp", ""));
		/* Down Excel For Invoice */
		setTrspSoNo(JSPUtil.getParameter(request,	prefix + "trsp_so_no", ""));
		setInvNo(JSPUtil.getParameter(request,	prefix + "inv_no", ""));
		setTotInvAmt(JSPUtil.getParameter(request,	prefix + "tot_inv_amt", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return WorkOrderBFIManagementVO[]
	 */
	public WorkOrderBFIManagementVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return WorkOrderBFIManagementVO[]
	 */
	public WorkOrderBFIManagementVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		WorkOrderBFIManagementVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] updDt =	(JSPUtil.getParameter(request, prefix +	"upd_dt".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] creDt =	(JSPUtil.getParameter(request, prefix +	"cre_dt".trim(),	length));
				String[] trsChk =	(JSPUtil.getParameter(request, prefix +	"trs_chk".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] creOfcCd =	(JSPUtil.getParameter(request, prefix +	"cre_ofc_cd".trim(),	length));
				String[] fmDt =	(JSPUtil.getParameter(request, prefix +	"fm_dt".trim(),	length));
				String[] toDt =	(JSPUtil.getParameter(request, prefix +	"to_dt".trim(),	length));
				String[] woVndrSeq =	(JSPUtil.getParameter(request, prefix +	"wo_vndr_seq".trim(),	length));
				String[] vndrLglEngNm =	(JSPUtil.getParameter(request, prefix +	"vndr_lgl_eng_nm".trim(),	length));
				String[] vndrEml =	(JSPUtil.getParameter(request, prefix +	"vndr_eml".trim(),	length));
				String[] todayDt =	(JSPUtil.getParameter(request, prefix +	"today_dt".trim(),	length));
				String[] cntcPsonNm =	(JSPUtil.getParameter(request, prefix +	"cntc_pson_nm".trim(),	length));
				String[] trspWoNo =	(JSPUtil.getParameter(request, prefix +	"trsp_wo_no".trim(),	length));
				String[] eqTpszCd =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd".trim(),	length));
				String[] fmNodCd =	(JSPUtil.getParameter(request, prefix +	"fm_nod_cd".trim(),	length));
				String[] viaNodCd =	(JSPUtil.getParameter(request, prefix +	"via_nod_cd".trim(),	length));
				String[] toNodCd =	(JSPUtil.getParameter(request, prefix +	"to_nod_cd".trim(),	length));
				String[] dorNodCd =	(JSPUtil.getParameter(request, prefix +	"dor_nod_cd".trim(),	length));
				String[] dorNodNm =	(JSPUtil.getParameter(request, prefix +	"dor_nod_nm".trim(),	length));
				String[] dorNodPlnDt =	(JSPUtil.getParameter(request, prefix +	"dor_nod_pln_dt".trim(),	length));
				String[] lstNodPlnDt =	(JSPUtil.getParameter(request, prefix +	"lst_nod_pln_dt".trim(),	length));
				String[] currCd =	(JSPUtil.getParameter(request, prefix +	"curr_cd".trim(),	length));
				String[] bzcAmtDesc =	(JSPUtil.getParameter(request, prefix +	"bzc_amt_desc".trim(),	length));
				String[] negoAmtDesc =	(JSPUtil.getParameter(request, prefix +	"nego_amt_desc".trim(),	length));
				String[] fuelScgAmtDesc =	(JSPUtil.getParameter(request, prefix +	"fuel_scg_amt_desc".trim(),	length));
				String[] etcAddAmtDesc =	(JSPUtil.getParameter(request, prefix +	"etc_add_amt_desc".trim(),	length));
				String[] bzcAmt =	(JSPUtil.getParameter(request, prefix +	"bzc_amt".trim(),	length));
				String[] negoAmt =	(JSPUtil.getParameter(request, prefix +	"nego_amt".trim(),	length));
				String[] fuelScgAmt =	(JSPUtil.getParameter(request, prefix +	"fuel_scg_amt".trim(),	length));
				String[] etcAddAmt =	(JSPUtil.getParameter(request, prefix +	"etc_add_amt".trim(),	length));
				String[] eqNo =	(JSPUtil.getParameter(request, prefix +	"eq_no".trim(),	length));
				String[] cgoTpCd =	(JSPUtil.getParameter(request, prefix +	"cgo_tp_cd".trim(),	length));
				String[] trsSubStsCd =	(JSPUtil.getParameter(request, prefix +	"trs_sub_sts_cd".trim(),	length));
				String[] vndrSeq =	(JSPUtil.getParameter(request, prefix +	"vndr_seq".trim(),	length));
				String[] tempNotSp =	(JSPUtil.getParameter(request, prefix +	"temp_not_sp".trim(),	length));
				/* Down Excel For Invoice */
				String[] trspSoNo =	(JSPUtil.getParameter(request, prefix +	"trsp_so_no".trim(),	length));
				String[] invNo =	(JSPUtil.getParameter(request, prefix +	"inv_no".trim(),	length));
				String[] totInvAmt =	(JSPUtil.getParameter(request, prefix +	"tot_inv_amt".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	WorkOrderBFIManagementVO();
						if ( updDt[i] !=	null)
						model.setUpdDt( updDt[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( creDt[i] !=	null)
						model.setCreDt( creDt[i]);
						if ( trsChk[i] !=	null)
						model.setTrsChk( trsChk[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( creOfcCd[i] !=	null)
						model.setCreOfcCd( creOfcCd[i]);
						if ( fmDt[i] !=	null)
						model.setFmDt( fmDt[i]);
						if ( toDt[i] !=	null)
						model.setToDt( toDt[i]);
						if ( woVndrSeq[i] !=	null)
						model.setWoVndrSeq( woVndrSeq[i]);
						if ( vndrLglEngNm[i] !=	null)
						model.setVndrLglEngNm( vndrLglEngNm[i]);
						if ( vndrEml[i] !=	null)
						model.setVndrEml( vndrEml[i]);
						if ( todayDt[i] !=	null)
						model.setTodayDt( todayDt[i]);
						if ( cntcPsonNm[i] !=	null)
						model.setCntcPsonNm( cntcPsonNm[i]);
						if ( trspWoNo[i] !=	null)
						model.setTrspWoNo( trspWoNo[i]);
						if ( eqTpszCd[i] !=	null)
						model.setEqTpszCd( eqTpszCd[i]);
						if ( fmNodCd[i] !=	null)
						model.setFmNodCd( fmNodCd[i]);
						if ( viaNodCd[i] !=	null)
						model.setViaNodCd( viaNodCd[i]);
						if ( toNodCd[i] !=	null)
						model.setToNodCd( toNodCd[i]);
						if ( dorNodCd[i] !=	null)
						model.setDorNodCd( dorNodCd[i]);
						if ( dorNodNm[i] !=	null)
						model.setDorNodNm( dorNodNm[i]);
						if ( dorNodPlnDt[i] !=	null)
						model.setDorNodPlnDt( dorNodPlnDt[i]);
						if ( lstNodPlnDt[i] !=	null)
						model.setLstNodPlnDt( lstNodPlnDt[i]);
						if ( currCd[i] !=	null)
						model.setCurrCd( currCd[i]);
						if ( bzcAmtDesc[i] !=	null)
						model.setBzcAmtDesc( bzcAmtDesc[i]);
						if ( negoAmtDesc[i] !=	null)
						model.setNegoAmtDesc( negoAmtDesc[i]);
						if ( fuelScgAmtDesc[i] !=	null)
						model.setFuelScgAmtDesc( fuelScgAmtDesc[i]);
						if ( etcAddAmtDesc[i] !=	null)
						model.setEtcAddAmtDesc( etcAddAmtDesc[i]);
						if ( bzcAmt[i] !=	null)
						model.setBzcAmt( bzcAmt[i]);
						if ( negoAmt[i] !=	null)
						model.setNegoAmt( negoAmt[i]);
						if ( fuelScgAmt[i] !=	null)
						model.setFuelScgAmt( fuelScgAmt[i]);
						if ( etcAddAmt[i] !=	null)
						model.setEtcAddAmt( etcAddAmt[i]);
						if ( eqNo[i] !=	null)
						model.setEqNo( eqNo[i]);
						if ( cgoTpCd[i] !=	null)
						model.setCgoTpCd( cgoTpCd[i]);
						if ( trsSubStsCd[i] !=	null)
						model.setTrsSubStsCd( trsSubStsCd[i]);
						if ( vndrSeq[i] !=	null)
						model.setVndrSeq( vndrSeq[i]);
						if ( tempNotSp[i] !=	null)
						model.setTempNotSp( tempNotSp[i]);
						/* Down Excel For Invoice */
						if ( trspSoNo[i] !=	null)
						model.setTrspSoNo( trspSoNo[i]);
						if ( invNo[i] !=	null)
						model.setInvNo( invNo[i]);
						if ( totInvAmt[i] !=	null)
						model.setTotInvAmt( totInvAmt[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getWorkOrderBFIManagementVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return WorkOrderBFIManagementVO[]
	 */
	public WorkOrderBFIManagementVO[]	 getWorkOrderBFIManagementVOs(){
		WorkOrderBFIManagementVO[] vos = (WorkOrderBFIManagementVO[])models.toArray(new	WorkOrderBFIManagementVO[models.size()]);
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
		this.updDt =	this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt =	this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsChk =	this.trsChk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd =	this.creOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDt =	this.fmDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt =	this.toDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woVndrSeq =	this.woVndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm =	this.vndrLglEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrEml =	this.vndrEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.todayDt =	this.todayDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPsonNm =	this.cntcPsonNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspWoNo =	this.trspWoNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd =	this.eqTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmNodCd =	this.fmNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viaNodCd =	this.viaNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toNodCd =	this.toNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorNodCd =	this.dorNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorNodNm =	this.dorNodNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorNodPlnDt =	this.dorNodPlnDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstNodPlnDt =	this.lstNodPlnDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd =	this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcAmtDesc =	this.bzcAmtDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.negoAmtDesc =	this.negoAmtDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fuelScgAmtDesc =	this.fuelScgAmtDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etcAddAmtDesc =	this.etcAddAmtDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcAmt =	this.bzcAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.negoAmt =	this.negoAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fuelScgAmt =	this.fuelScgAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etcAddAmt =	this.etcAddAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo =	this.eqNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoTpCd =	this.cgoTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsSubStsCd =	this.trsSubStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq =	this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tempNotSp =	this.tempNotSp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		/* Down Excel For Invoice */
		this.trspSoNo =	this.trspSoNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo =	this.invNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totInvAmt =	this.totInvAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}