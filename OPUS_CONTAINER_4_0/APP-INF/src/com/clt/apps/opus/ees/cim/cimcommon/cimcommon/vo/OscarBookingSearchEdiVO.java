/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : OscarBookingSearchEdiVO.java
 *@FileTitle : OscarBookingSearchEdiVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.11.03
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2015.11.03  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.ees.cim.cimcommon.cimcommon.vo;

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
public class OscarBookingSearchEdiVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<OscarBookingSearchEdiVO>  models =	new	ArrayList<OscarBookingSearchEdiVO>();


	/*	Column Info	*/
	private  String	 dpSeq   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 creLoclDt   =  null;
	/*	Column Info	*/
	private  String	 cntrNo   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd   =  null;
	/*	Column Info	*/
	private  String	 ediMvmtStsCd   =  null;
	/*	Column Info	*/
	private  String	 evntYdCd   =  null;
	/*	Column Info	*/
	private  String	 evntDt   =  null;
	/*	Column Info	*/
	private  String	 mvmtEdiRmk   =  null;
	/*	Column Info	*/
	private  String	 ediGateIoCd   =  null;
	/*	Column Info	*/
	private  String	 mvmtEdiSghtCd   =  null;
	/*	Column Info	*/
	private  String	 cntrFullStsCd   =  null;
	/*	Column Info	*/
	private  String	 rcvTp   =  null;
	/*	Column Info	*/
	private  String	 bkgNo   =  null;
	/*	Column Info	*/
	private  String	 blNo   =  null;
	/*	Column Info	*/
	private  String	 callSgnLloyd   =  null;
	/*	Column Info	*/
	private  String	 callSgnNo   =  null;
	/*	Column Info	*/
	private  String	 lloydNo   =  null;
	/*	Column Info	*/
	private  int	 iPage   =  0;
	/*	Column Info	*/
	private  String	 idxCreLoclDt   =  null;
	/*	Column Info	*/
	private  String	 mvmtEdiMsgAreaCd   =  null;
	/*	Column Info	*/
	private  String	 mvmtEdiRsltCd   =  null;
	/*	Column Info	*/
	private  String	 idxCreLoclFmDt   =  null;
	/*	Column Info	*/
	private  String	 idxCreLoclToDt   =  null;
	/*	Column Info	*/
	private  String	 sMessage   =  null;
	/*	Column Info	*/
	private  String	 pDate1   =  null;
	/*	Column Info	*/
	private  String	 pDate2   =  null;
	/*	Column Info	*/
	private  String	 pDate3   =  null;
	/*	Column Info	*/
	private  String	 eventReceive1   =  null;
	/*	Column Info	*/
	private  String	 eventReceive2   =  null;
	/*	Column Info	*/
	private  String	 bkgBl   =  null;
	/*	Column Info	*/
	private  String	 tmlNm   =  null;
	/*	Column Info	*/
	private  String	 fltFileRefNo   =  null;
	/*	Column Info	*/
	private  String	 pCntrno   =  null;
	/*	Column Info	*/
	private  String	 checkDigit   =  null;
	/*	Column Info	*/
	private  String	 lccCd   =  null;
	/*	Column Info	*/
	private  String	 rccCd   =  null;
	/*	Column Info	*/
	private  String	 mvmtEdiMsgTpId   =  null;
	/*	Column Info	*/
	private  String	 rtyKnt   =  null;
	/*	Column Info	*/
	private  String	 pYard1   =  null;
	/*	Column Info	*/
	private  String	 pYard2   =  null;
	/*	Column Info	*/
	private  String	 vvdCombo   =  null;
	/*	Column Info	*/
	private  String	 vvdValue   =  null;
	/*	Column Info	*/
	private  String	 startNo   =  null;
	/*	Column Info	*/
	private  String	 endNo   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public OscarBookingSearchEdiVO(){}

	public OscarBookingSearchEdiVO(String dpSeq,String ibflag,String pagerows,String creLoclDt,String cntrNo,String cntrTpszCd,String ediMvmtStsCd,String evntYdCd,String evntDt,String mvmtEdiRmk,String ediGateIoCd,String mvmtEdiSghtCd,String cntrFullStsCd,String rcvTp,String bkgNo,String blNo,String callSgnLloyd,String callSgnNo,String lloydNo,String iPage,String idxCreLoclDt,String mvmtEdiMsgAreaCd,String mvmtEdiRsltCd,String idxCreLoclFmDt,String idxCreLoclToDt,String sMessage,String pDate1,String pDate2,String pDate3,String eventReceive1,String eventReceive2,String bkgBl,String tmlNm,String fltFileRefNo,String pCntrno,String checkDigit,String lccCd,String rccCd,String mvmtEdiMsgTpId,String rtyKnt,String pYard1,String pYard2,String vvdCombo,String vvdValue,String startNo,String endNo)	{
		this.dpSeq  = dpSeq ;
		this.ibflag  = ibflag ;
		this.pagerows  = pagerows ;
		this.creLoclDt  = creLoclDt ;
		this.cntrNo  = cntrNo ;
		this.cntrTpszCd  = cntrTpszCd ;
		this.ediMvmtStsCd  = ediMvmtStsCd ;
		this.evntYdCd  = evntYdCd ;
		this.evntDt  = evntDt ;
		this.mvmtEdiRmk  = mvmtEdiRmk ;
		this.ediGateIoCd  = ediGateIoCd ;
		this.mvmtEdiSghtCd  = mvmtEdiSghtCd ;
		this.cntrFullStsCd  = cntrFullStsCd ;
		this.rcvTp  = rcvTp ;
		this.bkgNo  = bkgNo ;
		this.blNo  = blNo ;
		this.callSgnLloyd  = callSgnLloyd ;
		this.callSgnNo  = callSgnNo ;
		this.lloydNo  = lloydNo ;
		this.idxCreLoclDt  = idxCreLoclDt ;
		this.mvmtEdiMsgAreaCd  = mvmtEdiMsgAreaCd ;
		this.mvmtEdiRsltCd  = mvmtEdiRsltCd ;
		this.idxCreLoclFmDt  = idxCreLoclFmDt ;
		this.idxCreLoclToDt  = idxCreLoclToDt ;
		this.sMessage  = sMessage ;
		this.pDate1  = pDate1 ;
		this.pDate2  = pDate2 ;
		this.pDate3  = pDate3 ;
		this.eventReceive1  = eventReceive1 ;
		this.eventReceive2  = eventReceive2 ;
		this.bkgBl  = bkgBl ;
		this.tmlNm  = tmlNm ;
		this.fltFileRefNo  = fltFileRefNo ;
		this.pCntrno  = pCntrno ;
		this.checkDigit  = checkDigit ;
		this.lccCd  = lccCd ;
		this.rccCd  = rccCd ;
		this.mvmtEdiMsgTpId  = mvmtEdiMsgTpId ;
		this.rtyKnt  = rtyKnt ;
		this.pYard1  = pYard1 ;
		this.pYard2  = pYard2 ;
		this.vvdCombo  = vvdCombo ;
		this.vvdValue  = vvdValue ;
		this.startNo  = startNo ;
		this.endNo  = endNo ;
	}


	/**
	 * �뚯씠釉�而щ읆����옣��媛믪쓣 Hashtable<"column_name", "value">	濡�諛섑솚
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dp_seq", getDpSeq());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("cre_locl_dt", getCreLoclDt());		
		this.hashColumns.put("cntr_no", getCntrNo());		
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());		
		this.hashColumns.put("edi_mvmt_sts_cd", getEdiMvmtStsCd());		
		this.hashColumns.put("evnt_yd_cd", getEvntYdCd());		
		this.hashColumns.put("evnt_dt", getEvntDt());		
		this.hashColumns.put("mvmt_edi_rmk", getMvmtEdiRmk());		
		this.hashColumns.put("edi_gate_io_cd", getEdiGateIoCd());		
		this.hashColumns.put("mvmt_edi_sght_cd", getMvmtEdiSghtCd());		
		this.hashColumns.put("cntr_full_sts_cd", getCntrFullStsCd());		
		this.hashColumns.put("rcv_tp", getRcvTp());		
		this.hashColumns.put("bkg_no", getBkgNo());		
		this.hashColumns.put("bl_no", getBlNo());		
		this.hashColumns.put("call_sgn_lloyd", getCallSgnLloyd());		
		this.hashColumns.put("call_sgn_no", getCallSgnNo());		
		this.hashColumns.put("lloyd_no", getLloydNo());		
		this.hashColumns.put("idx_cre_locl_dt", getIdxCreLoclDt());		
		this.hashColumns.put("mvmt_edi_msg_area_cd", getMvmtEdiMsgAreaCd());		
		this.hashColumns.put("mvmt_edi_rslt_cd", getMvmtEdiRsltCd());		
		this.hashColumns.put("idx_cre_locl_fm_dt", getIdxCreLoclFmDt());		
		this.hashColumns.put("idx_cre_locl_to_dt", getIdxCreLoclToDt());		
		this.hashColumns.put("s_message", getSMessage());		
		this.hashColumns.put("p_date1", getPDate1());		
		this.hashColumns.put("p_date2", getPDate2());		
		this.hashColumns.put("p_date3", getPDate3());		
		this.hashColumns.put("event_receive1", getEventReceive1());		
		this.hashColumns.put("event_receive2", getEventReceive2());		
		this.hashColumns.put("bkg_bl", getBkgBl());		
		this.hashColumns.put("tml_nm", getTmlNm());		
		this.hashColumns.put("flt_file_ref_no", getFltFileRefNo());		
		this.hashColumns.put("p_cntrno", getPCntrno());		
		this.hashColumns.put("check_digit", getCheckDigit());		
		this.hashColumns.put("lcc_cd", getLccCd());		
		this.hashColumns.put("rcc_cd", getRccCd());		
		this.hashColumns.put("mvmt_edi_msg_tp_id", getMvmtEdiMsgTpId());		
		this.hashColumns.put("rty_knt", getRtyKnt());		
		this.hashColumns.put("p_yard1", getPYard1());		
		this.hashColumns.put("p_yard2", getPYard2());		
		this.hashColumns.put("vvd_combo", getVvdCombo());		
		this.hashColumns.put("vvd_value", getVvdValue());		
		this.hashColumns.put("start_no", getStartNo());		
		this.hashColumns.put("end_no", getEndNo());		
		return this.hashColumns;
}

	/**
	 * 而щ읆紐낆뿉	��쓳�섎뒗 硫ㅻ쾭蹂�닔紐낆쓣	��옣�섏뿬 Hashtable<"column_name", "variable"> 濡�諛섑솚
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("dp_seq", "dpSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cre_locl_dt", "creLoclDt");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("edi_mvmt_sts_cd", "ediMvmtStsCd");
		this.hashFields.put("evnt_yd_cd", "evntYdCd");
		this.hashFields.put("evnt_dt", "evntDt");
		this.hashFields.put("mvmt_edi_rmk", "mvmtEdiRmk");
		this.hashFields.put("edi_gate_io_cd", "ediGateIoCd");
		this.hashFields.put("mvmt_edi_sght_cd", "mvmtEdiSghtCd");
		this.hashFields.put("cntr_full_sts_cd", "cntrFullStsCd");
		this.hashFields.put("rcv_tp", "rcvTp");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("call_sgn_lloyd", "callSgnLloyd");
		this.hashFields.put("call_sgn_no", "callSgnNo");
		this.hashFields.put("lloyd_no", "lloydNo");
		this.hashFields.put("i_page", "iPage");
		this.hashFields.put("idx_cre_locl_dt", "idxCreLoclDt");
		this.hashFields.put("mvmt_edi_msg_area_cd", "mvmtEdiMsgAreaCd");
		this.hashFields.put("mvmt_edi_rslt_cd", "mvmtEdiRsltCd");
		this.hashFields.put("idx_cre_locl_fm_dt", "idxCreLoclFmDt");
		this.hashFields.put("idx_cre_locl_to_dt", "idxCreLoclToDt");
		this.hashFields.put("s_message", "sMessage");
		this.hashFields.put("p_date1", "pDate1");
		this.hashFields.put("p_date2", "pDate2");
		this.hashFields.put("p_date3", "pDate3");
		this.hashFields.put("event_receive1", "eventReceive1");
		this.hashFields.put("event_receive2", "eventReceive2");
		this.hashFields.put("bkg_bl", "bkgBl");
		this.hashFields.put("tml_nm", "tmlNm");
		this.hashFields.put("flt_file_ref_no", "fltFileRefNo");
		this.hashFields.put("p_cntrno", "pCntrno");
		this.hashFields.put("check_digit", "checkDigit");
		this.hashFields.put("lcc_cd", "lccCd");
		this.hashFields.put("rcc_cd", "rccCd");
		this.hashFields.put("mvmt_edi_msg_tp_id", "mvmtEdiMsgTpId");
		this.hashFields.put("rty_knt", "rtyKnt");
		this.hashFields.put("p_yard1", "pYard1");
		this.hashFields.put("p_yard2", "pYard2");
		this.hashFields.put("vvd_combo", "vvdCombo");
		this.hashFields.put("vvd_value", "vvdValue");
		this.hashFields.put("start_no", "startNo");
		this.hashFields.put("end_no", "endNo");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  dpSeq
	*/
	public void	setDpSeq( String	dpSeq ) {
		this.dpSeq =	dpSeq;
	}
 
	/**
	 * Column Info
	 * @return	dpSeq
	 */
	 public	 String	getDpSeq() {
		 return	this.dpSeq;
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
	* @param  creLoclDt
	*/
	public void	setCreLoclDt( String	creLoclDt ) {
		this.creLoclDt =	creLoclDt;
	}
 
	/**
	 * Column Info
	 * @return	creLoclDt
	 */
	 public	 String	getCreLoclDt() {
		 return	this.creLoclDt;
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
	* @param  ediMvmtStsCd
	*/
	public void	setEdiMvmtStsCd( String	ediMvmtStsCd ) {
		this.ediMvmtStsCd =	ediMvmtStsCd;
	}
 
	/**
	 * Column Info
	 * @return	ediMvmtStsCd
	 */
	 public	 String	getEdiMvmtStsCd() {
		 return	this.ediMvmtStsCd;
	 } 
 	/**
	* Column Info
	* @param  evntYdCd
	*/
	public void	setEvntYdCd( String	evntYdCd ) {
		this.evntYdCd =	evntYdCd;
	}
 
	/**
	 * Column Info
	 * @return	evntYdCd
	 */
	 public	 String	getEvntYdCd() {
		 return	this.evntYdCd;
	 } 
 	/**
	* Column Info
	* @param  evntDt
	*/
	public void	setEvntDt( String	evntDt ) {
		this.evntDt =	evntDt;
	}
 
	/**
	 * Column Info
	 * @return	evntDt
	 */
	 public	 String	getEvntDt() {
		 return	this.evntDt;
	 } 
 	/**
	* Column Info
	* @param  mvmtEdiRmk
	*/
	public void	setMvmtEdiRmk( String	mvmtEdiRmk ) {
		this.mvmtEdiRmk =	mvmtEdiRmk;
	}
 
	/**
	 * Column Info
	 * @return	mvmtEdiRmk
	 */
	 public	 String	getMvmtEdiRmk() {
		 return	this.mvmtEdiRmk;
	 } 
 	/**
	* Column Info
	* @param  ediGateIoCd
	*/
	public void	setEdiGateIoCd( String	ediGateIoCd ) {
		this.ediGateIoCd =	ediGateIoCd;
	}
 
	/**
	 * Column Info
	 * @return	ediGateIoCd
	 */
	 public	 String	getEdiGateIoCd() {
		 return	this.ediGateIoCd;
	 } 
 	/**
	* Column Info
	* @param  mvmtEdiSghtCd
	*/
	public void	setMvmtEdiSghtCd( String	mvmtEdiSghtCd ) {
		this.mvmtEdiSghtCd =	mvmtEdiSghtCd;
	}
 
	/**
	 * Column Info
	 * @return	mvmtEdiSghtCd
	 */
	 public	 String	getMvmtEdiSghtCd() {
		 return	this.mvmtEdiSghtCd;
	 } 
 	/**
	* Column Info
	* @param  cntrFullStsCd
	*/
	public void	setCntrFullStsCd( String	cntrFullStsCd ) {
		this.cntrFullStsCd =	cntrFullStsCd;
	}
 
	/**
	 * Column Info
	 * @return	cntrFullStsCd
	 */
	 public	 String	getCntrFullStsCd() {
		 return	this.cntrFullStsCd;
	 } 
 	/**
	* Column Info
	* @param  rcvTp
	*/
	public void	setRcvTp( String	rcvTp ) {
		this.rcvTp =	rcvTp;
	}
 
	/**
	 * Column Info
	 * @return	rcvTp
	 */
	 public	 String	getRcvTp() {
		 return	this.rcvTp;
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
	* @param  callSgnLloyd
	*/
	public void	setCallSgnLloyd( String	callSgnLloyd ) {
		this.callSgnLloyd =	callSgnLloyd;
	}
 
	/**
	 * Column Info
	 * @return	callSgnLloyd
	 */
	 public	 String	getCallSgnLloyd() {
		 return	this.callSgnLloyd;
	 } 
 	/**
	* Column Info
	* @param  callSgnNo
	*/
	public void	setCallSgnNo( String	callSgnNo ) {
		this.callSgnNo =	callSgnNo;
	}
 
	/**
	 * Column Info
	 * @return	callSgnNo
	 */
	 public	 String	getCallSgnNo() {
		 return	this.callSgnNo;
	 } 
 	/**
	* Column Info
	* @param  lloydNo
	*/
	public void	setLloydNo( String	lloydNo ) {
		this.lloydNo =	lloydNo;
	}
 
	/**
	 * Column Info
	 * @return	lloydNo
	 */
	 public	 String	getLloydNo() {
		 return	this.lloydNo;
	 } 
 	/**
	* Column Info
	* @param  iPage
	*/
	public void	setIPage( int	iPage ) {
		this.iPage =	iPage;
	}
 
	/**
	 * Column Info
	 * @return	iPage
	 */
	 public	 int	getIPage() {
		 return	this.iPage;
	 } 
 	/**
	* Column Info
	* @param  idxCreLoclDt
	*/
	public void	setIdxCreLoclDt( String	idxCreLoclDt ) {
		this.idxCreLoclDt =	idxCreLoclDt;
	}
 
	/**
	 * Column Info
	 * @return	idxCreLoclDt
	 */
	 public	 String	getIdxCreLoclDt() {
		 return	this.idxCreLoclDt;
	 } 
 	/**
	* Column Info
	* @param  mvmtEdiMsgAreaCd
	*/
	public void	setMvmtEdiMsgAreaCd( String	mvmtEdiMsgAreaCd ) {
		this.mvmtEdiMsgAreaCd =	mvmtEdiMsgAreaCd;
	}
 
	/**
	 * Column Info
	 * @return	mvmtEdiMsgAreaCd
	 */
	 public	 String	getMvmtEdiMsgAreaCd() {
		 return	this.mvmtEdiMsgAreaCd;
	 } 
 	/**
	* Column Info
	* @param  mvmtEdiRsltCd
	*/
	public void	setMvmtEdiRsltCd( String	mvmtEdiRsltCd ) {
		this.mvmtEdiRsltCd =	mvmtEdiRsltCd;
	}
 
	/**
	 * Column Info
	 * @return	mvmtEdiRsltCd
	 */
	 public	 String	getMvmtEdiRsltCd() {
		 return	this.mvmtEdiRsltCd;
	 } 
 	/**
	* Column Info
	* @param  idxCreLoclFmDt
	*/
	public void	setIdxCreLoclFmDt( String	idxCreLoclFmDt ) {
		this.idxCreLoclFmDt =	idxCreLoclFmDt;
	}
 
	/**
	 * Column Info
	 * @return	idxCreLoclFmDt
	 */
	 public	 String	getIdxCreLoclFmDt() {
		 return	this.idxCreLoclFmDt;
	 } 
 	/**
	* Column Info
	* @param  idxCreLoclToDt
	*/
	public void	setIdxCreLoclToDt( String	idxCreLoclToDt ) {
		this.idxCreLoclToDt =	idxCreLoclToDt;
	}
 
	/**
	 * Column Info
	 * @return	idxCreLoclToDt
	 */
	 public	 String	getIdxCreLoclToDt() {
		 return	this.idxCreLoclToDt;
	 } 
 	/**
	* Column Info
	* @param  sMessage
	*/
	public void	setSMessage( String	sMessage ) {
		this.sMessage =	sMessage;
	}
 
	/**
	 * Column Info
	 * @return	sMessage
	 */
	 public	 String	getSMessage() {
		 return	this.sMessage;
	 } 
 	/**
	* Column Info
	* @param  pDate1
	*/
	public void	setPDate1( String	pDate1 ) {
		this.pDate1 =	pDate1;
	}
 
	/**
	 * Column Info
	 * @return	pDate1
	 */
	 public	 String	getPDate1() {
		 return	this.pDate1;
	 } 
 	/**
	* Column Info
	* @param  pDate2
	*/
	public void	setPDate2( String	pDate2 ) {
		this.pDate2 =	pDate2;
	}
 
	/**
	 * Column Info
	 * @return	pDate2
	 */
	 public	 String	getPDate2() {
		 return	this.pDate2;
	 } 
 	/**
	* Column Info
	* @param  pDate3
	*/
	public void	setPDate3( String	pDate3 ) {
		this.pDate3 =	pDate3;
	}
 
	/**
	 * Column Info
	 * @return	pDate3
	 */
	 public	 String	getPDate3() {
		 return	this.pDate3;
	 } 
 	/**
	* Column Info
	* @param  eventReceive1
	*/
	public void	setEventReceive1( String	eventReceive1 ) {
		this.eventReceive1 =	eventReceive1;
	}
 
	/**
	 * Column Info
	 * @return	eventReceive1
	 */
	 public	 String	getEventReceive1() {
		 return	this.eventReceive1;
	 } 
 	/**
	* Column Info
	* @param  eventReceive2
	*/
	public void	setEventReceive2( String	eventReceive2 ) {
		this.eventReceive2 =	eventReceive2;
	}
 
	/**
	 * Column Info
	 * @return	eventReceive2
	 */
	 public	 String	getEventReceive2() {
		 return	this.eventReceive2;
	 } 
 	/**
	* Column Info
	* @param  bkgBl
	*/
	public void	setBkgBl( String	bkgBl ) {
		this.bkgBl =	bkgBl;
	}
 
	/**
	 * Column Info
	 * @return	bkgBl
	 */
	 public	 String	getBkgBl() {
		 return	this.bkgBl;
	 } 
 	/**
	* Column Info
	* @param  tmlNm
	*/
	public void	setTmlNm( String	tmlNm ) {
		this.tmlNm =	tmlNm;
	}
 
	/**
	 * Column Info
	 * @return	tmlNm
	 */
	 public	 String	getTmlNm() {
		 return	this.tmlNm;
	 } 
 	/**
	* Column Info
	* @param  fltFileRefNo
	*/
	public void	setFltFileRefNo( String	fltFileRefNo ) {
		this.fltFileRefNo =	fltFileRefNo;
	}
 
	/**
	 * Column Info
	 * @return	fltFileRefNo
	 */
	 public	 String	getFltFileRefNo() {
		 return	this.fltFileRefNo;
	 } 
 	/**
	* Column Info
	* @param  pCntrno
	*/
	public void	setPCntrno( String	pCntrno ) {
		this.pCntrno =	pCntrno;
	}
 
	/**
	 * Column Info
	 * @return	pCntrno
	 */
	 public	 String	getPCntrno() {
		 return	this.pCntrno;
	 } 
 	/**
	* Column Info
	* @param  checkDigit
	*/
	public void	setCheckDigit( String	checkDigit ) {
		this.checkDigit =	checkDigit;
	}
 
	/**
	 * Column Info
	 * @return	checkDigit
	 */
	 public	 String	getCheckDigit() {
		 return	this.checkDigit;
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
	* @param  mvmtEdiMsgTpId
	*/
	public void	setMvmtEdiMsgTpId( String	mvmtEdiMsgTpId ) {
		this.mvmtEdiMsgTpId =	mvmtEdiMsgTpId;
	}
 
	/**
	 * Column Info
	 * @return	mvmtEdiMsgTpId
	 */
	 public	 String	getMvmtEdiMsgTpId() {
		 return	this.mvmtEdiMsgTpId;
	 } 
 	/**
	* Column Info
	* @param  rtyKnt
	*/
	public void	setRtyKnt( String	rtyKnt ) {
		this.rtyKnt =	rtyKnt;
	}
 
	/**
	 * Column Info
	 * @return	rtyKnt
	 */
	 public	 String	getRtyKnt() {
		 return	this.rtyKnt;
	 } 
 	/**
	* Column Info
	* @param  pYard1
	*/
	public void	setPYard1( String	pYard1 ) {
		this.pYard1 =	pYard1;
	}
 
	/**
	 * Column Info
	 * @return	pYard1
	 */
	 public	 String	getPYard1() {
		 return	this.pYard1;
	 } 
 	/**
	* Column Info
	* @param  pYard2
	*/
	public void	setPYard2( String	pYard2 ) {
		this.pYard2 =	pYard2;
	}
 
	/**
	 * Column Info
	 * @return	pYard2
	 */
	 public	 String	getPYard2() {
		 return	this.pYard2;
	 } 
 	/**
	* Column Info
	* @param  vvdCombo
	*/
	public void	setVvdCombo( String	vvdCombo ) {
		this.vvdCombo =	vvdCombo;
	}
 
	/**
	 * Column Info
	 * @return	vvdCombo
	 */
	 public	 String	getVvdCombo() {
		 return	this.vvdCombo;
	 } 
 	/**
	* Column Info
	* @param  vvdValue
	*/
	public void	setVvdValue( String	vvdValue ) {
		this.vvdValue =	vvdValue;
	}
 
	/**
	 * Column Info
	 * @return	vvdValue
	 */
	 public	 String	getVvdValue() {
		 return	this.vvdValue;
	 } 
 	/**
	* Column Info
	* @param  startNo
	*/
	public void	setStartNo( String	startNo ) {
		this.startNo =	startNo;
	}
 
	/**
	 * Column Info
	 * @return	startNo
	 */
	 public	 String	getStartNo() {
		 return	this.startNo;
	 } 
 	/**
	* Column Info
	* @param  endNo
	*/
	public void	setEndNo( String	endNo ) {
		this.endNo =	endNo;
	}
 
	/**
	 * Column Info
	 * @return	endNo
	 */
	 public	 String	getEndNo() {
		 return	this.endNo;
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
		setDpSeq(JSPUtil.getParameter(request,	prefix + "dp_seq", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setCreLoclDt(JSPUtil.getParameter(request,	prefix + "cre_locl_dt", ""));
		setCntrNo(JSPUtil.getParameter(request,	prefix + "cntr_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd", ""));
		setEdiMvmtStsCd(JSPUtil.getParameter(request,	prefix + "edi_mvmt_sts_cd", ""));
		setEvntYdCd(JSPUtil.getParameter(request,	prefix + "evnt_yd_cd", ""));
		setEvntDt(JSPUtil.getParameter(request,	prefix + "evnt_dt", ""));
		setMvmtEdiRmk(JSPUtil.getParameter(request,	prefix + "mvmt_edi_rmk", ""));
		setEdiGateIoCd(JSPUtil.getParameter(request,	prefix + "edi_gate_io_cd", ""));
		setMvmtEdiSghtCd(JSPUtil.getParameter(request,	prefix + "mvmt_edi_sght_cd", ""));
		setCntrFullStsCd(JSPUtil.getParameter(request,	prefix + "cntr_full_sts_cd", ""));
		setRcvTp(JSPUtil.getParameter(request,	prefix + "rcv_tp", ""));
		setBkgNo(JSPUtil.getParameter(request,	prefix + "bkg_no", ""));
		setBlNo(JSPUtil.getParameter(request,	prefix + "bl_no", ""));
		setCallSgnLloyd(JSPUtil.getParameter(request,	prefix + "call_sgn_lloyd", ""));
		setCallSgnNo(JSPUtil.getParameter(request,	prefix + "call_sgn_no", ""));
		setLloydNo(JSPUtil.getParameter(request,	prefix + "lloyd_no", ""));
		setIPage(JSPUtil.getParameterAsInt(request,	prefix + "iPage", 1));
		setIdxCreLoclDt(JSPUtil.getParameter(request,	prefix + "idx_cre_locl_dt", ""));
		setMvmtEdiMsgAreaCd(JSPUtil.getParameter(request,	prefix + "mvmt_edi_msg_area_cd", ""));
		setMvmtEdiRsltCd(JSPUtil.getParameter(request,	prefix + "mvmt_edi_rslt_cd", ""));
		setIdxCreLoclFmDt(JSPUtil.getParameter(request,	prefix + "idx_cre_locl_fm_dt", ""));
		setIdxCreLoclToDt(JSPUtil.getParameter(request,	prefix + "idx_cre_locl_to_dt", ""));
		setSMessage(JSPUtil.getParameter(request,	prefix + "s_message", ""));
		setPDate1(JSPUtil.getParameter(request,	prefix + "p_date1", ""));
		setPDate2(JSPUtil.getParameter(request,	prefix + "p_date2", ""));
		setPDate3(JSPUtil.getParameter(request,	prefix + "p_date3", ""));
		setEventReceive1(JSPUtil.getParameter(request,	prefix + "event_receive1", ""));
		setEventReceive2(JSPUtil.getParameter(request,	prefix + "event_receive2", ""));
		setBkgBl(JSPUtil.getParameter(request,	prefix + "bkg_bl", ""));
		setTmlNm(JSPUtil.getParameter(request,	prefix + "tml_nm", ""));
		setFltFileRefNo(JSPUtil.getParameter(request,	prefix + "flt_file_ref_no", ""));
		setPCntrno(JSPUtil.getParameter(request,	prefix + "p_cntrno", ""));
		setCheckDigit(JSPUtil.getParameter(request,	prefix + "check_digit", ""));
		setLccCd(JSPUtil.getParameter(request,	prefix + "lcc_cd", ""));
		setRccCd(JSPUtil.getParameter(request,	prefix + "rcc_cd", ""));
		setMvmtEdiMsgTpId(JSPUtil.getParameter(request,	prefix + "mvmt_edi_msg_tp_id", ""));
		setRtyKnt(JSPUtil.getParameter(request,	prefix + "rty_knt", ""));
		setPYard1(JSPUtil.getParameter(request,	prefix + "p_yard1", ""));
		setPYard2(JSPUtil.getParameter(request,	prefix + "p_yard2", ""));
		setVvdCombo(JSPUtil.getParameter(request,	prefix + "vvd_combo", ""));
		setVvdValue(JSPUtil.getParameter(request,	prefix + "vvd_value", ""));
		setStartNo(JSPUtil.getParameter(request,	prefix + "start_no", ""));
		setEndNo(JSPUtil.getParameter(request,	prefix + "end_no", ""));
	}
	
	/**
	 * Request ���곗씠�곕� VO 諛곗뿴濡�蹂�솚�섏뿬 諛섑솚.
	 * @param request
	 * @return OscarBookingSearchEdiVO[]
	 */
	public OscarBookingSearchEdiVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request �섏뼱���щ윭 嫄�DATA瑜�VO Class ���대뒗��
	 * @param request
	 * @param prefix
	 * @return OscarBookingSearchEdiVO[]
	 */
	public OscarBookingSearchEdiVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		OscarBookingSearchEdiVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] dpSeq =	(JSPUtil.getParameter(request, prefix +	"dp_seq".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] creLoclDt =	(JSPUtil.getParameter(request, prefix +	"cre_locl_dt".trim(),	length));
				String[] cntrNo =	(JSPUtil.getParameter(request, prefix +	"cntr_no".trim(),	length));
				String[] cntrTpszCd =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd".trim(),	length));
				String[] ediMvmtStsCd =	(JSPUtil.getParameter(request, prefix +	"edi_mvmt_sts_cd".trim(),	length));
				String[] evntYdCd =	(JSPUtil.getParameter(request, prefix +	"evnt_yd_cd".trim(),	length));
				String[] evntDt =	(JSPUtil.getParameter(request, prefix +	"evnt_dt".trim(),	length));
				String[] mvmtEdiRmk =	(JSPUtil.getParameter(request, prefix +	"mvmt_edi_rmk".trim(),	length));
				String[] ediGateIoCd =	(JSPUtil.getParameter(request, prefix +	"edi_gate_io_cd".trim(),	length));
				String[] mvmtEdiSghtCd =	(JSPUtil.getParameter(request, prefix +	"mvmt_edi_sght_cd".trim(),	length));
				String[] cntrFullStsCd =	(JSPUtil.getParameter(request, prefix +	"cntr_full_sts_cd".trim(),	length));
				String[] rcvTp =	(JSPUtil.getParameter(request, prefix +	"rcv_tp".trim(),	length));
				String[] bkgNo =	(JSPUtil.getParameter(request, prefix +	"bkg_no".trim(),	length));
				String[] blNo =	(JSPUtil.getParameter(request, prefix +	"bl_no".trim(),	length));
				String[] callSgnLloyd =	(JSPUtil.getParameter(request, prefix +	"call_sgn_lloyd".trim(),	length));
				String[] callSgnNo =	(JSPUtil.getParameter(request, prefix +	"call_sgn_no".trim(),	length));
				String[] lloydNo =	(JSPUtil.getParameter(request, prefix +	"lloyd_no".trim(),	length));
				String[] iPage =	(JSPUtil.getParameter(request, prefix +	"i_page".trim(),	length));
				String[] idxCreLoclDt =	(JSPUtil.getParameter(request, prefix +	"idx_cre_locl_dt".trim(),	length));
				String[] mvmtEdiMsgAreaCd =	(JSPUtil.getParameter(request, prefix +	"mvmt_edi_msg_area_cd".trim(),	length));
				String[] mvmtEdiRsltCd =	(JSPUtil.getParameter(request, prefix +	"mvmt_edi_rslt_cd".trim(),	length));
				String[] idxCreLoclFmDt =	(JSPUtil.getParameter(request, prefix +	"idx_cre_locl_fm_dt".trim(),	length));
				String[] idxCreLoclToDt =	(JSPUtil.getParameter(request, prefix +	"idx_cre_locl_to_dt".trim(),	length));
				String[] sMessage =	(JSPUtil.getParameter(request, prefix +	"s_message".trim(),	length));
				String[] pDate1 =	(JSPUtil.getParameter(request, prefix +	"p_date1".trim(),	length));
				String[] pDate2 =	(JSPUtil.getParameter(request, prefix +	"p_date2".trim(),	length));
				String[] pDate3 =	(JSPUtil.getParameter(request, prefix +	"p_date3".trim(),	length));
				String[] eventReceive1 =	(JSPUtil.getParameter(request, prefix +	"event_receive1".trim(),	length));
				String[] eventReceive2 =	(JSPUtil.getParameter(request, prefix +	"event_receive2".trim(),	length));
				String[] bkgBl =	(JSPUtil.getParameter(request, prefix +	"bkg_bl".trim(),	length));
				String[] tmlNm =	(JSPUtil.getParameter(request, prefix +	"tml_nm".trim(),	length));
				String[] fltFileRefNo =	(JSPUtil.getParameter(request, prefix +	"flt_file_ref_no".trim(),	length));
				String[] pCntrno =	(JSPUtil.getParameter(request, prefix +	"p_cntrno".trim(),	length));
				String[] checkDigit =	(JSPUtil.getParameter(request, prefix +	"check_digit".trim(),	length));
				String[] lccCd =	(JSPUtil.getParameter(request, prefix +	"lcc_cd".trim(),	length));
				String[] rccCd =	(JSPUtil.getParameter(request, prefix +	"rcc_cd".trim(),	length));
				String[] mvmtEdiMsgTpId =	(JSPUtil.getParameter(request, prefix +	"mvmt_edi_msg_tp_id".trim(),	length));
				String[] rtyKnt =	(JSPUtil.getParameter(request, prefix +	"rty_knt".trim(),	length));
				String[] pYard1 =	(JSPUtil.getParameter(request, prefix +	"p_yard1".trim(),	length));
				String[] pYard2 =	(JSPUtil.getParameter(request, prefix +	"p_yard2".trim(),	length));
				String[] vvdCombo =	(JSPUtil.getParameter(request, prefix +	"vvd_combo".trim(),	length));
				String[] vvdValue =	(JSPUtil.getParameter(request, prefix +	"vvd_value".trim(),	length));
				String[] startNo =	(JSPUtil.getParameter(request, prefix +	"start_no".trim(),	length));
				String[] endNo =	(JSPUtil.getParameter(request, prefix +	"end_no".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	OscarBookingSearchEdiVO();
						if ( dpSeq[i] !=	null)
						model.setDpSeq( dpSeq[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( creLoclDt[i] !=	null)
						model.setCreLoclDt( creLoclDt[i]);
						if ( cntrNo[i] !=	null)
						model.setCntrNo( cntrNo[i]);
						if ( cntrTpszCd[i] !=	null)
						model.setCntrTpszCd( cntrTpszCd[i]);
						if ( ediMvmtStsCd[i] !=	null)
						model.setEdiMvmtStsCd( ediMvmtStsCd[i]);
						if ( evntYdCd[i] !=	null)
						model.setEvntYdCd( evntYdCd[i]);
						if ( evntDt[i] !=	null)
						model.setEvntDt( evntDt[i]);
						if ( mvmtEdiRmk[i] !=	null)
						model.setMvmtEdiRmk( mvmtEdiRmk[i]);
						if ( ediGateIoCd[i] !=	null)
						model.setEdiGateIoCd( ediGateIoCd[i]);
						if ( mvmtEdiSghtCd[i] !=	null)
						model.setMvmtEdiSghtCd( mvmtEdiSghtCd[i]);
						if ( cntrFullStsCd[i] !=	null)
						model.setCntrFullStsCd( cntrFullStsCd[i]);
						if ( rcvTp[i] !=	null)
						model.setRcvTp( rcvTp[i]);
						if ( bkgNo[i] !=	null)
						model.setBkgNo( bkgNo[i]);
						if ( blNo[i] !=	null)
						model.setBlNo( blNo[i]);
						if ( callSgnLloyd[i] !=	null)
						model.setCallSgnLloyd( callSgnLloyd[i]);
						if ( callSgnNo[i] !=	null)
						model.setCallSgnNo( callSgnNo[i]);
						if ( lloydNo[i] !=	null)
						model.setLloydNo( lloydNo[i]);
						if ( idxCreLoclDt[i] !=	null)
						model.setIdxCreLoclDt( idxCreLoclDt[i]);
						if ( mvmtEdiMsgAreaCd[i] !=	null)
						model.setMvmtEdiMsgAreaCd( mvmtEdiMsgAreaCd[i]);
						if ( mvmtEdiRsltCd[i] !=	null)
						model.setMvmtEdiRsltCd( mvmtEdiRsltCd[i]);
						if ( idxCreLoclFmDt[i] !=	null)
						model.setIdxCreLoclFmDt( idxCreLoclFmDt[i]);
						if ( idxCreLoclToDt[i] !=	null)
						model.setIdxCreLoclToDt( idxCreLoclToDt[i]);
						if ( sMessage[i] !=	null)
						model.setSMessage( sMessage[i]);
						if ( pDate1[i] !=	null)
						model.setPDate1( pDate1[i]);
						if ( pDate2[i] !=	null)
						model.setPDate2( pDate2[i]);
						if ( pDate3[i] !=	null)
						model.setPDate3( pDate3[i]);
						if ( eventReceive1[i] !=	null)
						model.setEventReceive1( eventReceive1[i]);
						if ( eventReceive2[i] !=	null)
						model.setEventReceive2( eventReceive2[i]);
						if ( bkgBl[i] !=	null)
						model.setBkgBl( bkgBl[i]);
						if ( tmlNm[i] !=	null)
						model.setTmlNm( tmlNm[i]);
						if ( fltFileRefNo[i] !=	null)
						model.setFltFileRefNo( fltFileRefNo[i]);
						if ( pCntrno[i] !=	null)
						model.setPCntrno( pCntrno[i]);
						if ( checkDigit[i] !=	null)
						model.setCheckDigit( checkDigit[i]);
						if ( lccCd[i] !=	null)
						model.setLccCd( lccCd[i]);
						if ( rccCd[i] !=	null)
						model.setRccCd( rccCd[i]);
						if ( mvmtEdiMsgTpId[i] !=	null)
						model.setMvmtEdiMsgTpId( mvmtEdiMsgTpId[i]);
						if ( rtyKnt[i] !=	null)
						model.setRtyKnt( rtyKnt[i]);
						if ( pYard1[i] !=	null)
						model.setPYard1( pYard1[i]);
						if ( pYard2[i] !=	null)
						model.setPYard2( pYard2[i]);
						if ( vvdCombo[i] !=	null)
						model.setVvdCombo( vvdCombo[i]);
						if ( vvdValue[i] !=	null)
						model.setVvdValue( vvdValue[i]);
						if ( startNo[i] !=	null)
						model.setStartNo( startNo[i]);
						if ( endNo[i] !=	null)
						model.setEndNo( endNo[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getOscarBookingSearchEdiVOs();
	}

	/**
	 *  VO 諛곗뿴��諛섑솚
	 * @return OscarBookingSearchEdiVO[]
	 */
	public OscarBookingSearchEdiVO[]	 getOscarBookingSearchEdiVOs(){
		OscarBookingSearchEdiVO[] vos = (OscarBookingSearchEdiVO[])models.toArray(new	OscarBookingSearchEdiVO[models.size()]);
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
		this.dpSeq =	this.dpSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creLoclDt =	this.creLoclDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo =	this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd =	this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediMvmtStsCd =	this.ediMvmtStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntYdCd =	this.evntYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntDt =	this.evntDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiRmk =	this.mvmtEdiRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediGateIoCd =	this.ediGateIoCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiSghtCd =	this.mvmtEdiSghtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrFullStsCd =	this.cntrFullStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTp =	this.rcvTp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo =	this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo =	this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callSgnLloyd =	this.callSgnLloyd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callSgnNo =	this.callSgnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lloydNo =	this.lloydNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idxCreLoclDt =	this.idxCreLoclDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiMsgAreaCd =	this.mvmtEdiMsgAreaCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiRsltCd =	this.mvmtEdiRsltCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idxCreLoclFmDt =	this.idxCreLoclFmDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idxCreLoclToDt =	this.idxCreLoclToDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sMessage =	this.sMessage.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDate1 =	this.pDate1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDate2 =	this.pDate2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDate3 =	this.pDate3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eventReceive1 =	this.eventReceive1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eventReceive2 =	this.eventReceive2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgBl =	this.bkgBl.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlNm =	this.tmlNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fltFileRefNo =	this.fltFileRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pCntrno =	this.pCntrno.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.checkDigit =	this.checkDigit.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lccCd =	this.lccCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rccCd =	this.rccCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiMsgTpId =	this.mvmtEdiMsgTpId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtyKnt =	this.rtyKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pYard1 =	this.pYard1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pYard2 =	this.pYard2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCombo =	this.vvdCombo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdValue =	this.vvdValue.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.startNo =	this.startNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endNo =	this.endNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}