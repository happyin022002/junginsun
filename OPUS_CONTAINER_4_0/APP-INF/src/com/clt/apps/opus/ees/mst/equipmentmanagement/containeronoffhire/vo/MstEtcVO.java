/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : MstEtcVO.java
 *@FileTitle : MstEtcVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.01.08
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2016.01.08 
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
public class MstEtcVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<MstEtcVO>  models =	new	ArrayList<MstEtcVO>();


	/*	Column Info	*/
	private  String	 cntrNo2   =  null;
	/*	Column Info	*/
	private  String	 cntrNo3   =  null;
	/*	Column Info	*/
	private  String	 gubun   =  null;
	/*	Column Info	*/
	private  String	 fmSerNo   =  null;
	/*	Column Info	*/
	private  String	 stsEvntYdCd   =  null;
	/*	Column Info	*/
	private  String	 lotPlnYr   =  null;
	/*	Column Info	*/
	private  String	 lotSeq   =  null;
	/*	Column Info	*/
	private  String	 lotLocCd   =  null;
	/*	Column Info	*/
	private  String	 cntrNo0   =  null;
	/*	Column Info	*/
	private  String	 cntrNo1   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 pickUpDueDate   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 hidType   =  null;
	/*	Column Info	*/
	private  String	 lotCntrPfxCd   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd   =  null;
	/*	Column Info	*/
	private  String	 agmtCtyCd   =  null;
	/*	Column Info	*/
	private  String	 toSerNo   =  null;
	/*	Column Info	*/
	private  String	 lstmCd   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 ifCd   =  null;
	/*	Column Info	*/
	private  String	 lotNo   =  null;
	/*	Column Info	*/
	private  String	 agmtSeq   =  null;
	/*	Column Info	*/
	private  String	 approvalVol   =  null;
	/*	Column Info	*/
	private  String	 hireDate   =  null;
	/*	Column Info	*/
	private  String	 agmtNo   =  null;
	/*	Column Info	*/
	private  String	 approvalNo   =  null;
	/*	Column Info	*/
	private  String	 ctype   =  null;
	/*	Column Info	*/
	private  String	 deYrmon   =  null;
	/*	Column Info	*/
	private  String	 mftDt   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;
	/*	Column Info	*/
	private  String	 pickUpVol   =  null;
	/*	Column Info	*/
	private  String	 serialRange   =  null;
	/*	Column Info	*/
	private  String	 vndrSeq   =  null;
	/*	Column Info	*/
	private  String	 cntrNo   =  null;
	/*	Column Info	*/
	private  String	 refNo   =  null;
	/*	Column Info	*/
	private  String	 vndrAbbrNm   =  null;
	/*	Column Info	*/
	private  String	 cntrMtrlCd   =  null;
	/*	Column Info	*/
	private  String	 rfTpCd   =  null;
	/*	Column Info	*/
	private  String	 code   =  null;
	/*	Column Info	*/
	private  String	 codeNm   =  null;
	/*	Column Info	*/
	private  String	 termCngSeq   =  null;
	/*	Column Info	*/
	private  String	 rfHumidCtrlValCd   =  null;
	/*	Column Info	*/
	private  String	 rfCmprCtnt   =  null;
	/*	Column Info	*/
	private  String	 lotCntrTpszCd   =  null;
	/*	Column Info	*/
	private  String	 cntrSpecNo   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCd   =  null;
	/*	Column Info	*/
	private  String	 onYdCd   =  null;
	/*	Column Info	*/
	private  String	 offYdCd   =  null;
	/*	Column Info	*/
	private  String	 cntrGrsWgt   =  null;
	/*	Column Info	*/
	private  String	 tareWgt   =  null;
	
	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public MstEtcVO(){}

	public MstEtcVO(String cntrNo2,String cntrNo3,String gubun,String fmSerNo,String stsEvntYdCd,String lotPlnYr,String lotSeq,String lotLocCd,String cntrNo0,String cntrNo1,String pagerows,String pickUpDueDate,String ibflag,String hidType,String lotCntrPfxCd,String cntrTpszCd,String agmtCtyCd,String toSerNo,String lstmCd,String updUsrId,String ifCd,String lotNo,String agmtSeq,String approvalVol,String hireDate,String agmtNo,String approvalNo,String ctype,String deYrmon,String mftDt,String creUsrId,String pickUpVol,String serialRange,String vndrSeq,String cntrNo,String refNo,String vndrAbbrNm,String cntrMtrlCd,String rfTpCd,String code,String codeNm,String termCngSeq,String rfHumidCtrlValCd,String rfCmprCtnt,String lotCntrTpszCd,String cntrSpecNo,String eqTpszCd,String onYdCd,String offYdCd, String cntrGrsWgt, String tareWgt )	{
		this.cntrNo2  = cntrNo2 ;
		this.cntrNo3  = cntrNo3 ;
		this.gubun  = gubun ;
		this.fmSerNo  = fmSerNo ;
		this.stsEvntYdCd  = stsEvntYdCd ;
		this.lotPlnYr  = lotPlnYr ;
		this.lotSeq  = lotSeq ;
		this.lotLocCd  = lotLocCd ;
		this.cntrNo0  = cntrNo0 ;
		this.cntrNo1  = cntrNo1 ;
		this.pagerows  = pagerows ;
		this.pickUpDueDate  = pickUpDueDate ;
		this.ibflag  = ibflag ;
		this.hidType  = hidType ;
		this.lotCntrPfxCd  = lotCntrPfxCd ;
		this.cntrTpszCd  = cntrTpszCd ;
		this.agmtCtyCd  = agmtCtyCd ;
		this.toSerNo  = toSerNo ;
		this.lstmCd  = lstmCd ;
		this.updUsrId  = updUsrId ;
		this.ifCd  = ifCd ;
		this.lotNo  = lotNo ;
		this.agmtSeq  = agmtSeq ;
		this.approvalVol  = approvalVol ;
		this.hireDate  = hireDate ;
		this.agmtNo  = agmtNo ;
		this.approvalNo  = approvalNo ;
		this.ctype  = ctype ;
		this.deYrmon  = deYrmon ;
		this.mftDt  = mftDt ;
		this.creUsrId  = creUsrId ;
		this.pickUpVol  = pickUpVol ;
		this.serialRange  = serialRange ;
		this.vndrSeq  = vndrSeq ;
		this.cntrNo  = cntrNo ;
		this.refNo  = refNo ;
		this.vndrAbbrNm  = vndrAbbrNm ;
		this.cntrMtrlCd  = cntrMtrlCd ;
		this.rfTpCd  = rfTpCd ;
		this.code  = code ;
		this.codeNm  = codeNm ;
		this.termCngSeq  = termCngSeq ;
		this.rfHumidCtrlValCd  = rfHumidCtrlValCd ;
		this.rfCmprCtnt  = rfCmprCtnt ;
		this.lotCntrTpszCd  = lotCntrTpszCd ;
		this.cntrSpecNo  = cntrSpecNo ;
		this.eqTpszCd  = eqTpszCd ;
		this.onYdCd  = onYdCd ;
		this.offYdCd  = offYdCd ;
		this.cntrGrsWgt  = cntrGrsWgt ;
		this.tareWgt  = tareWgt ;
	}


	/**
	 * �뚯씠釉�而щ읆����옣��媛믪쓣 Hashtable<"column_name", "value">	濡�諛섑솚
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr_no2", getCntrNo2());		
		this.hashColumns.put("cntr_no3", getCntrNo3());		
		this.hashColumns.put("gubun", getGubun());		
		this.hashColumns.put("fm_ser_no", getFmSerNo());		
		this.hashColumns.put("sts_evnt_yd_cd", getStsEvntYdCd());		
		this.hashColumns.put("lot_pln_yr", getLotPlnYr());		
		this.hashColumns.put("lot_seq", getLotSeq());		
		this.hashColumns.put("lot_loc_cd", getLotLocCd());		
		this.hashColumns.put("cntr_no0", getCntrNo0());		
		this.hashColumns.put("cntr_no1", getCntrNo1());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("pick_up_due_date", getPickUpDueDate());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("hid_type", getHidType());		
		this.hashColumns.put("lot_cntr_pfx_cd", getLotCntrPfxCd());		
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());		
		this.hashColumns.put("agmt_cty_cd", getAgmtCtyCd());		
		this.hashColumns.put("to_ser_no", getToSerNo());		
		this.hashColumns.put("lstm_cd", getLstmCd());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("if_cd", getIfCd());		
		this.hashColumns.put("lot_no", getLotNo());		
		this.hashColumns.put("agmt_seq", getAgmtSeq());		
		this.hashColumns.put("approval_vol", getApprovalVol());		
		this.hashColumns.put("hire_date", getHireDate());		
		this.hashColumns.put("agmt_no", getAgmtNo());		
		this.hashColumns.put("approval_no", getApprovalNo());		
		this.hashColumns.put("ctype", getCtype());		
		this.hashColumns.put("de_yrmon", getDeYrmon());		
		this.hashColumns.put("mft_dt", getMftDt());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("pick_up_vol", getPickUpVol());		
		this.hashColumns.put("serial_range", getSerialRange());		
		this.hashColumns.put("vndr_seq", getVndrSeq());		
		this.hashColumns.put("cntr_no", getCntrNo());		
		this.hashColumns.put("ref_no", getRefNo());		
		this.hashColumns.put("vndr_abbr_nm", getVndrAbbrNm());		
		this.hashColumns.put("cntr_mtrl_cd", getCntrMtrlCd());		
		this.hashColumns.put("rf_tp_cd", getRfTpCd());		
		this.hashColumns.put("code", getCode());		
		this.hashColumns.put("code_nm", getCodeNm());		
		this.hashColumns.put("term_cng_seq", getTermCngSeq());		
		this.hashColumns.put("rf_humid_ctrl_val_cd", getRfHumidCtrlValCd());		
		this.hashColumns.put("rf_cmpr_ctnt", getRfCmprCtnt());		
		this.hashColumns.put("lot_cntr_tpsz_cd", getLotCntrTpszCd());		
		this.hashColumns.put("cntr_spec_no", getCntrSpecNo());		
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());		
		this.hashColumns.put("on_yd_cd", getOnYdCd());		
		this.hashColumns.put("off_yd_cd", getOffYdCd());	
		this.hashColumns.put("cntr_grs_wgt", getCntrGrsWgt());		
		this.hashColumns.put("tare_wgt", getTareWgt());		
		return this.hashColumns;
}

	/**
	 * 而щ읆紐낆뿉	��쓳�섎뒗 硫ㅻ쾭蹂�닔紐낆쓣	��옣�섏뿬 Hashtable<"column_name", "variable"> 濡�諛섑솚
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("cntr_no2", "cntrNo2");
		this.hashFields.put("cntr_no3", "cntrNo3");
		this.hashFields.put("gubun", "gubun");
		this.hashFields.put("fm_ser_no", "fmSerNo");
		this.hashFields.put("sts_evnt_yd_cd", "stsEvntYdCd");
		this.hashFields.put("lot_pln_yr", "lotPlnYr");
		this.hashFields.put("lot_seq", "lotSeq");
		this.hashFields.put("lot_loc_cd", "lotLocCd");
		this.hashFields.put("cntr_no0", "cntrNo0");
		this.hashFields.put("cntr_no1", "cntrNo1");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pick_up_due_date", "pickUpDueDate");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("hid_type", "hidType");
		this.hashFields.put("lot_cntr_pfx_cd", "lotCntrPfxCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("agmt_cty_cd", "agmtCtyCd");
		this.hashFields.put("to_ser_no", "toSerNo");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("if_cd", "ifCd");
		this.hashFields.put("lot_no", "lotNo");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("approval_vol", "approvalVol");
		this.hashFields.put("hire_date", "hireDate");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("approval_no", "approvalNo");
		this.hashFields.put("ctype", "ctype");
		this.hashFields.put("de_yrmon", "deYrmon");
		this.hashFields.put("mft_dt", "mftDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("pick_up_vol", "pickUpVol");
		this.hashFields.put("serial_range", "serialRange");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("ref_no", "refNo");
		this.hashFields.put("vndr_abbr_nm", "vndrAbbrNm");
		this.hashFields.put("cntr_mtrl_cd", "cntrMtrlCd");
		this.hashFields.put("rf_tp_cd", "rfTpCd");
		this.hashFields.put("code", "code");
		this.hashFields.put("code_nm", "codeNm");
		this.hashFields.put("term_cng_seq", "termCngSeq");
		this.hashFields.put("rf_humid_ctrl_val_cd", "rfHumidCtrlValCd");
		this.hashFields.put("rf_cmpr_ctnt", "rfCmprCtnt");
		this.hashFields.put("lot_cntr_tpsz_cd", "lotCntrTpszCd");
		this.hashFields.put("cntr_spec_no", "cntrSpecNo");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("on_yd_cd", "onYdCd");
		this.hashFields.put("off_yd_cd", "offYdCd");
		this.hashFields.put("cntr_grs_wgt", "cntrGrsWgt");
		this.hashFields.put("tare_wgt", "tareWgt");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  cntrNo2
	*/
	public void	setCntrNo2( String	cntrNo2 ) {
		this.cntrNo2 =	cntrNo2;
	}
 
	/**
	 * Column Info
	 * @return	cntrNo2
	 */
	 public	 String	getCntrNo2() {
		 return	this.cntrNo2;
	 } 
 	/**
	* Column Info
	* @param  cntrNo3
	*/
	public void	setCntrNo3( String	cntrNo3 ) {
		this.cntrNo3 =	cntrNo3;
	}
 
	/**
	 * Column Info
	 * @return	cntrNo3
	 */
	 public	 String	getCntrNo3() {
		 return	this.cntrNo3;
	 } 
 	/**
	* Column Info
	* @param  gubun
	*/
	public void	setGubun( String	gubun ) {
		this.gubun =	gubun;
	}
 
	/**
	 * Column Info
	 * @return	gubun
	 */
	 public	 String	getGubun() {
		 return	this.gubun;
	 } 
 	/**
	* Column Info
	* @param  fmSerNo
	*/
	public void	setFmSerNo( String	fmSerNo ) {
		this.fmSerNo =	fmSerNo;
	}
 
	/**
	 * Column Info
	 * @return	fmSerNo
	 */
	 public	 String	getFmSerNo() {
		 return	this.fmSerNo;
	 } 
 	/**
	* Column Info
	* @param  stsEvntYdCd
	*/
	public void	setStsEvntYdCd( String	stsEvntYdCd ) {
		this.stsEvntYdCd =	stsEvntYdCd;
	}
 
	/**
	 * Column Info
	 * @return	stsEvntYdCd
	 */
	 public	 String	getStsEvntYdCd() {
		 return	this.stsEvntYdCd;
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
	* @param  cntrNo0
	*/
	public void	setCntrNo0( String	cntrNo0 ) {
		this.cntrNo0 =	cntrNo0;
	}
 
	/**
	 * Column Info
	 * @return	cntrNo0
	 */
	 public	 String	getCntrNo0() {
		 return	this.cntrNo0;
	 } 
 	/**
	* Column Info
	* @param  cntrNo1
	*/
	public void	setCntrNo1( String	cntrNo1 ) {
		this.cntrNo1 =	cntrNo1;
	}
 
	/**
	 * Column Info
	 * @return	cntrNo1
	 */
	 public	 String	getCntrNo1() {
		 return	this.cntrNo1;
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
	* @param  pickUpDueDate
	*/
	public void	setPickUpDueDate( String	pickUpDueDate ) {
		this.pickUpDueDate =	pickUpDueDate;
	}
 
	/**
	 * Column Info
	 * @return	pickUpDueDate
	 */
	 public	 String	getPickUpDueDate() {
		 return	this.pickUpDueDate;
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
	* @param  lotCntrPfxCd
	*/
	public void	setLotCntrPfxCd( String	lotCntrPfxCd ) {
		this.lotCntrPfxCd =	lotCntrPfxCd;
	}
 
	/**
	 * Column Info
	 * @return	lotCntrPfxCd
	 */
	 public	 String	getLotCntrPfxCd() {
		 return	this.lotCntrPfxCd;
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
	* @param  toSerNo
	*/
	public void	setToSerNo( String	toSerNo ) {
		this.toSerNo =	toSerNo;
	}
 
	/**
	 * Column Info
	 * @return	toSerNo
	 */
	 public	 String	getToSerNo() {
		 return	this.toSerNo;
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
	* @param  ifCd
	*/
	public void	setIfCd( String	ifCd ) {
		this.ifCd =	ifCd;
	}
 
	/**
	 * Column Info
	 * @return	ifCd
	 */
	 public	 String	getIfCd() {
		 return	this.ifCd;
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
	* @param  approvalVol
	*/
	public void	setApprovalVol( String	approvalVol ) {
		this.approvalVol =	approvalVol;
	}
 
	/**
	 * Column Info
	 * @return	approvalVol
	 */
	 public	 String	getApprovalVol() {
		 return	this.approvalVol;
	 } 
 	/**
	* Column Info
	* @param  hireDate
	*/
	public void	setHireDate( String	hireDate ) {
		this.hireDate =	hireDate;
	}
 
	/**
	 * Column Info
	 * @return	hireDate
	 */
	 public	 String	getHireDate() {
		 return	this.hireDate;
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
	* @param  approvalNo
	*/
	public void	setApprovalNo( String	approvalNo ) {
		this.approvalNo =	approvalNo;
	}
 
	/**
	 * Column Info
	 * @return	approvalNo
	 */
	 public	 String	getApprovalNo() {
		 return	this.approvalNo;
	 } 
 	/**
	* Column Info
	* @param  ctype
	*/
	public void	setCtype( String	ctype ) {
		this.ctype =	ctype;
	}
 
	/**
	 * Column Info
	 * @return	ctype
	 */
	 public	 String	getCtype() {
		 return	this.ctype;
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
	* @param  mftDt
	*/
	public void	setMftDt( String	mftDt ) {
		this.mftDt =	mftDt;
	}
 
	/**
	 * Column Info
	 * @return	mftDt
	 */
	 public	 String	getMftDt() {
		 return	this.mftDt;
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
	* @param  pickUpVol
	*/
	public void	setPickUpVol( String	pickUpVol ) {
		this.pickUpVol =	pickUpVol;
	}
 
	/**
	 * Column Info
	 * @return	pickUpVol
	 */
	 public	 String	getPickUpVol() {
		 return	this.pickUpVol;
	 } 
 	/**
	* Column Info
	* @param  serialRange
	*/
	public void	setSerialRange( String	serialRange ) {
		this.serialRange =	serialRange;
	}
 
	/**
	 * Column Info
	 * @return	serialRange
	 */
	 public	 String	getSerialRange() {
		 return	this.serialRange;
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
	* @param  refNo
	*/
	public void	setRefNo( String	refNo ) {
		this.refNo =	refNo;
	}
 
	/**
	 * Column Info
	 * @return	refNo
	 */
	 public	 String	getRefNo() {
		 return	this.refNo;
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
	* @param  cntrMtrlCd
	*/
	public void	setCntrMtrlCd( String	cntrMtrlCd ) {
		this.cntrMtrlCd =	cntrMtrlCd;
	}
 
	/**
	 * Column Info
	 * @return	cntrMtrlCd
	 */
	 public	 String	getCntrMtrlCd() {
		 return	this.cntrMtrlCd;
	 } 
 	/**
	* Column Info
	* @param  rfTpCd
	*/
	public void	setRfTpCd( String	rfTpCd ) {
		this.rfTpCd =	rfTpCd;
	}
 
	/**
	 * Column Info
	 * @return	rfTpCd
	 */
	 public	 String	getRfTpCd() {
		 return	this.rfTpCd;
	 } 
 	/**
	* Column Info
	* @param  code
	*/
	public void	setCode( String	code ) {
		this.code =	code;
	}
 
	/**
	 * Column Info
	 * @return	code
	 */
	 public	 String	getCode() {
		 return	this.code;
	 } 
 	/**
	* Column Info
	* @param  codeNm
	*/
	public void	setCodeNm( String	codeNm ) {
		this.codeNm =	codeNm;
	}
 
	/**
	 * Column Info
	 * @return	codeNm
	 */
	 public	 String	getCodeNm() {
		 return	this.codeNm;
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
	* @param  rfHumidCtrlValCd
	*/
	public void	setRfHumidCtrlValCd( String	rfHumidCtrlValCd ) {
		this.rfHumidCtrlValCd =	rfHumidCtrlValCd;
	}
 
	/**
	 * Column Info
	 * @return	rfHumidCtrlValCd
	 */
	 public	 String	getRfHumidCtrlValCd() {
		 return	this.rfHumidCtrlValCd;
	 } 
 	/**
	* Column Info
	* @param  rfCmprCtnt
	*/
	public void	setRfCmprCtnt( String	rfCmprCtnt ) {
		this.rfCmprCtnt =	rfCmprCtnt;
	}
 
	/**
	 * Column Info
	 * @return	rfCmprCtnt
	 */
	 public	 String	getRfCmprCtnt() {
		 return	this.rfCmprCtnt;
	 } 
 	/**
	* Column Info
	* @param  lotCntrTpszCd
	*/
	public void	setLotCntrTpszCd( String	lotCntrTpszCd ) {
		this.lotCntrTpszCd =	lotCntrTpszCd;
	}
 
	/**
	 * Column Info
	 * @return	lotCntrTpszCd
	 */
	 public	 String	getLotCntrTpszCd() {
		 return	this.lotCntrTpszCd;
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
	* @param  onYdCd
	*/
	public void	setOnYdCd( String	onYdCd ) {
		this.onYdCd =	onYdCd;
	}
 
	/**
	 * Column Info
	 * @return	onYdCd
	 */
	 public	 String	getOnYdCd() {
		 return	this.onYdCd;
	 } 
 	/**
	* Column Info
	* @param  offYdCd
	*/
	public void	setOffYdCd( String	offYdCd ) {
		this.offYdCd =	offYdCd;
	}
 
	/**
	 * Column Info
	 * @return	offYdCd
	 */
	 public	 String	getOffYdCd() {
		 return	this.offYdCd;
	 } 
	 /**
	  * Column Info
	  * @param  cntrGrsWgt
	  */
	 public void setCntrGrsWgt( String	cntrGrsWgt ) {
		this.cntrGrsWgt =	cntrGrsWgt;
	 }
	 
	 /**
	   * Column Info
	   * @return	cntrGrsWgt
	 */
	 public	 String	getCntrGrsWgt() {
		 return	this.cntrGrsWgt;
	 }
	 /**
	   * Column Info
	   * @param  tareWgt
	 */
	 public void	setTareWgt( String	tareWgt ) {
	 	this.tareWgt =	tareWgt;
	 }
		 
	 /**
	   * Column Info
	   * @return	tareWgt
	  */
	 public	 String	getTareWgt() {
			 return	this.tareWgt;
	 }
	 
    /**
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
		setCntrNo2(JSPUtil.getParameter(request,	prefix + "cntr_no2", ""));
		setCntrNo3(JSPUtil.getParameter(request,	prefix + "cntr_no3", ""));
		setGubun(JSPUtil.getParameter(request,	prefix + "gubun", ""));
		setFmSerNo(JSPUtil.getParameter(request,	prefix + "fm_ser_no", ""));
		setStsEvntYdCd(JSPUtil.getParameter(request,	prefix + "sts_evnt_yd_cd", ""));
		setLotPlnYr(JSPUtil.getParameter(request,	prefix + "lot_pln_yr", ""));
		setLotSeq(JSPUtil.getParameter(request,	prefix + "lot_seq", ""));
		setLotLocCd(JSPUtil.getParameter(request,	prefix + "lot_loc_cd", ""));
		setCntrNo0(JSPUtil.getParameter(request,	prefix + "cntr_no0", ""));
		setCntrNo1(JSPUtil.getParameter(request,	prefix + "cntr_no1", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setPickUpDueDate(JSPUtil.getParameter(request,	prefix + "pick_up_due_date", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setHidType(JSPUtil.getParameter(request,	prefix + "hid_type", ""));
		setLotCntrPfxCd(JSPUtil.getParameter(request,	prefix + "lot_cntr_pfx_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd", ""));
		setAgmtCtyCd(JSPUtil.getParameter(request,	prefix + "agmt_cty_cd", ""));
		setToSerNo(JSPUtil.getParameter(request,	prefix + "to_ser_no", ""));
		setLstmCd(JSPUtil.getParameter(request,	prefix + "lstm_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setIfCd(JSPUtil.getParameter(request,	prefix + "if_cd", ""));
		setLotNo(JSPUtil.getParameter(request,	prefix + "lot_no", ""));
		setAgmtSeq(JSPUtil.getParameter(request,	prefix + "agmt_seq", ""));
		setApprovalVol(JSPUtil.getParameter(request,	prefix + "approval_vol", ""));
		setHireDate(JSPUtil.getParameter(request,	prefix + "hire_date", ""));
		setAgmtNo(JSPUtil.getParameter(request,	prefix + "agmt_no", ""));
		setApprovalNo(JSPUtil.getParameter(request,	prefix + "approval_no", ""));
		setCtype(JSPUtil.getParameter(request,	prefix + "ctype", ""));
		setDeYrmon(JSPUtil.getParameter(request,	prefix + "de_yrmon", ""));
		setMftDt(JSPUtil.getParameter(request,	prefix + "mft_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setPickUpVol(JSPUtil.getParameter(request,	prefix + "pick_up_vol", ""));
		setSerialRange(JSPUtil.getParameter(request,	prefix + "serial_range", ""));
		setVndrSeq(JSPUtil.getParameter(request,	prefix + "vndr_seq", ""));
		setCntrNo(JSPUtil.getParameter(request,	prefix + "cntr_no", ""));
		setRefNo(JSPUtil.getParameter(request,	prefix + "ref_no", ""));
		setVndrAbbrNm(JSPUtil.getParameter(request,	prefix + "vndr_abbr_nm", ""));
		setCntrMtrlCd(JSPUtil.getParameter(request,	prefix + "cntr_mtrl_cd", ""));
		setRfTpCd(JSPUtil.getParameter(request,	prefix + "rf_tp_cd", ""));
		setCode(JSPUtil.getParameter(request,	prefix + "code", ""));
		setCodeNm(JSPUtil.getParameter(request,	prefix + "code_nm", ""));
		setTermCngSeq(JSPUtil.getParameter(request,	prefix + "term_cng_seq", ""));
		setRfHumidCtrlValCd(JSPUtil.getParameter(request,	prefix + "rf_humid_ctrl_val_cd", ""));
		setRfCmprCtnt(JSPUtil.getParameter(request,	prefix + "rf_cmpr_ctnt", ""));
		setLotCntrTpszCd(JSPUtil.getParameter(request,	prefix + "lot_cntr_tpsz_cd", ""));
		setCntrSpecNo(JSPUtil.getParameter(request,	prefix + "cntr_spec_no", ""));
		setEqTpszCd(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd", ""));
		setOnYdCd(JSPUtil.getParameter(request,	prefix + "on_yd_cd", ""));
		setOffYdCd(JSPUtil.getParameter(request,	prefix + "off_yd_cd", ""));
		setCntrGrsWgt(JSPUtil.getParameter(request,	prefix + "cntr_grs_wgt", ""));
		setTareWgt(JSPUtil.getParameter(request,	prefix + "tare_wgt", ""));
	}
	
	/**
	 * Request ���곗씠�곕� VO 諛곗뿴濡�蹂�솚�섏뿬 諛섑솚.
	 * @param request
	 * @return MstEtcVO[]
	 */
	public MstEtcVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request �섏뼱���щ윭 嫄�DATA瑜�VO Class ���대뒗��
	 * @param request
	 * @param prefix
	 * @return MstEtcVO[]
	 */
	public MstEtcVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		MstEtcVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] cntrNo2 =	(JSPUtil.getParameter(request, prefix +	"cntr_no2".trim(),	length));
				String[] cntrNo3 =	(JSPUtil.getParameter(request, prefix +	"cntr_no3".trim(),	length));
				String[] gubun =	(JSPUtil.getParameter(request, prefix +	"gubun".trim(),	length));
				String[] fmSerNo =	(JSPUtil.getParameter(request, prefix +	"fm_ser_no".trim(),	length));
				String[] stsEvntYdCd =	(JSPUtil.getParameter(request, prefix +	"sts_evnt_yd_cd".trim(),	length));
				String[] lotPlnYr =	(JSPUtil.getParameter(request, prefix +	"lot_pln_yr".trim(),	length));
				String[] lotSeq =	(JSPUtil.getParameter(request, prefix +	"lot_seq".trim(),	length));
				String[] lotLocCd =	(JSPUtil.getParameter(request, prefix +	"lot_loc_cd".trim(),	length));
				String[] cntrNo0 =	(JSPUtil.getParameter(request, prefix +	"cntr_no0".trim(),	length));
				String[] cntrNo1 =	(JSPUtil.getParameter(request, prefix +	"cntr_no1".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] pickUpDueDate =	(JSPUtil.getParameter(request, prefix +	"pick_up_due_date".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] hidType =	(JSPUtil.getParameter(request, prefix +	"hid_type".trim(),	length));
				String[] lotCntrPfxCd =	(JSPUtil.getParameter(request, prefix +	"lot_cntr_pfx_cd".trim(),	length));
				String[] cntrTpszCd =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd".trim(),	length));
				String[] agmtCtyCd =	(JSPUtil.getParameter(request, prefix +	"agmt_cty_cd".trim(),	length));
				String[] toSerNo =	(JSPUtil.getParameter(request, prefix +	"to_ser_no".trim(),	length));
				String[] lstmCd =	(JSPUtil.getParameter(request, prefix +	"lstm_cd".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] ifCd =	(JSPUtil.getParameter(request, prefix +	"if_cd".trim(),	length));
				String[] lotNo =	(JSPUtil.getParameter(request, prefix +	"lot_no".trim(),	length));
				String[] agmtSeq =	(JSPUtil.getParameter(request, prefix +	"agmt_seq".trim(),	length));
				String[] approvalVol =	(JSPUtil.getParameter(request, prefix +	"approval_vol".trim(),	length));
				String[] hireDate =	(JSPUtil.getParameter(request, prefix +	"hire_date".trim(),	length));
				String[] agmtNo =	(JSPUtil.getParameter(request, prefix +	"agmt_no".trim(),	length));
				String[] approvalNo =	(JSPUtil.getParameter(request, prefix +	"approval_no".trim(),	length));
				String[] ctype =	(JSPUtil.getParameter(request, prefix +	"ctype".trim(),	length));
				String[] deYrmon =	(JSPUtil.getParameter(request, prefix +	"de_yrmon".trim(),	length));
				String[] mftDt =	(JSPUtil.getParameter(request, prefix +	"mft_dt".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				String[] pickUpVol =	(JSPUtil.getParameter(request, prefix +	"pick_up_vol".trim(),	length));
				String[] serialRange =	(JSPUtil.getParameter(request, prefix +	"serial_range".trim(),	length));
				String[] vndrSeq =	(JSPUtil.getParameter(request, prefix +	"vndr_seq".trim(),	length));
				String[] cntrNo =	(JSPUtil.getParameter(request, prefix +	"cntr_no".trim(),	length));
				String[] refNo =	(JSPUtil.getParameter(request, prefix +	"ref_no".trim(),	length));
				String[] vndrAbbrNm =	(JSPUtil.getParameter(request, prefix +	"vndr_abbr_nm".trim(),	length));
				String[] cntrMtrlCd =	(JSPUtil.getParameter(request, prefix +	"cntr_mtrl_cd".trim(),	length));
				String[] rfTpCd =	(JSPUtil.getParameter(request, prefix +	"rf_tp_cd".trim(),	length));
				String[] code =	(JSPUtil.getParameter(request, prefix +	"code".trim(),	length));
				String[] codeNm =	(JSPUtil.getParameter(request, prefix +	"code_nm".trim(),	length));
				String[] termCngSeq =	(JSPUtil.getParameter(request, prefix +	"term_cng_seq".trim(),	length));
				String[] rfHumidCtrlValCd =	(JSPUtil.getParameter(request, prefix +	"rf_humid_ctrl_val_cd".trim(),	length));
				String[] rfCmprCtnt =	(JSPUtil.getParameter(request, prefix +	"rf_cmpr_ctnt".trim(),	length));
				String[] lotCntrTpszCd =	(JSPUtil.getParameter(request, prefix +	"lot_cntr_tpsz_cd".trim(),	length));
				String[] cntrSpecNo =	(JSPUtil.getParameter(request, prefix +	"cntr_spec_no".trim(),	length));
				String[] eqTpszCd =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd".trim(),	length));
				String[] onYdCd =	(JSPUtil.getParameter(request, prefix +	"on_yd_cd".trim(),	length));
				String[] offYdCd =	(JSPUtil.getParameter(request, prefix +	"off_yd_cd".trim(),	length));
				String[] cntrGrsWgt =	(JSPUtil.getParameter(request, prefix +	"cntr_grs_wgt".trim(),	length));
				String[] tareWgt =	(JSPUtil.getParameter(request, prefix +	"tare_wgt".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	MstEtcVO();
						if ( cntrNo2[i] !=	null)
						model.setCntrNo2( cntrNo2[i]);
						if ( cntrNo3[i] !=	null)
						model.setCntrNo3( cntrNo3[i]);
						if ( gubun[i] !=	null)
						model.setGubun( gubun[i]);
						if ( fmSerNo[i] !=	null)
						model.setFmSerNo( fmSerNo[i]);
						if ( stsEvntYdCd[i] !=	null)
						model.setStsEvntYdCd( stsEvntYdCd[i]);
						if ( lotPlnYr[i] !=	null)
						model.setLotPlnYr( lotPlnYr[i]);
						if ( lotSeq[i] !=	null)
						model.setLotSeq( lotSeq[i]);
						if ( lotLocCd[i] !=	null)
						model.setLotLocCd( lotLocCd[i]);
						if ( cntrNo0[i] !=	null)
						model.setCntrNo0( cntrNo0[i]);
						if ( cntrNo1[i] !=	null)
						model.setCntrNo1( cntrNo1[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( pickUpDueDate[i] !=	null)
						model.setPickUpDueDate( pickUpDueDate[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( hidType[i] !=	null)
						model.setHidType( hidType[i]);
						if ( lotCntrPfxCd[i] !=	null)
						model.setLotCntrPfxCd( lotCntrPfxCd[i]);
						if ( cntrTpszCd[i] !=	null)
						model.setCntrTpszCd( cntrTpszCd[i]);
						if ( agmtCtyCd[i] !=	null)
						model.setAgmtCtyCd( agmtCtyCd[i]);
						if ( toSerNo[i] !=	null)
						model.setToSerNo( toSerNo[i]);
						if ( lstmCd[i] !=	null)
						model.setLstmCd( lstmCd[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( ifCd[i] !=	null)
						model.setIfCd( ifCd[i]);
						if ( lotNo[i] !=	null)
						model.setLotNo( lotNo[i]);
						if ( agmtSeq[i] !=	null)
						model.setAgmtSeq( agmtSeq[i]);
						if ( approvalVol[i] !=	null)
						model.setApprovalVol( approvalVol[i]);
						if ( hireDate[i] !=	null)
						model.setHireDate( hireDate[i]);
						if ( agmtNo[i] !=	null)
						model.setAgmtNo( agmtNo[i]);
						if ( approvalNo[i] !=	null)
						model.setApprovalNo( approvalNo[i]);
						if ( ctype[i] !=	null)
						model.setCtype( ctype[i]);
						if ( deYrmon[i] !=	null)
						model.setDeYrmon( deYrmon[i]);
						if ( mftDt[i] !=	null)
						model.setMftDt( mftDt[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
						if ( pickUpVol[i] !=	null)
						model.setPickUpVol( pickUpVol[i]);
						if ( serialRange[i] !=	null)
						model.setSerialRange( serialRange[i]);
						if ( vndrSeq[i] !=	null)
						model.setVndrSeq( vndrSeq[i]);
						if ( cntrNo[i] !=	null)
						model.setCntrNo( cntrNo[i]);
						if ( refNo[i] !=	null)
						model.setRefNo( refNo[i]);
						if ( vndrAbbrNm[i] !=	null)
						model.setVndrAbbrNm( vndrAbbrNm[i]);
						if ( cntrMtrlCd[i] !=	null)
						model.setCntrMtrlCd( cntrMtrlCd[i]);
						if ( rfTpCd[i] !=	null)
						model.setRfTpCd( rfTpCd[i]);
						if ( code[i] !=	null)
						model.setCode( code[i]);
						if ( codeNm[i] !=	null)
						model.setCodeNm( codeNm[i]);
						if ( termCngSeq[i] !=	null)
						model.setTermCngSeq( termCngSeq[i]);
						if ( rfHumidCtrlValCd[i] !=	null)
						model.setRfHumidCtrlValCd( rfHumidCtrlValCd[i]);
						if ( rfCmprCtnt[i] !=	null)
						model.setRfCmprCtnt( rfCmprCtnt[i]);
						if ( lotCntrTpszCd[i] !=	null)
						model.setLotCntrTpszCd( lotCntrTpszCd[i]);
						if ( cntrSpecNo[i] !=	null)
						model.setCntrSpecNo( cntrSpecNo[i]);
						if ( eqTpszCd[i] !=	null)
						model.setEqTpszCd( eqTpszCd[i]);
						if ( onYdCd[i] !=	null)
						model.setOnYdCd( onYdCd[i]);
						if ( offYdCd[i] !=	null)
						model.setOffYdCd( offYdCd[i]);
						if ( cntrGrsWgt[i] !=	null)
						model.setCntrGrsWgt( cntrGrsWgt[i]);
						if ( tareWgt[i] !=	null)
						model.setTareWgt( tareWgt[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getMstEtcVOs();
	}

	/**
	 *  VO 諛곗뿴��諛섑솚
	 * @return MstEtcVO[]
	 */
	public MstEtcVO[]	 getMstEtcVOs(){
		MstEtcVO[] vos = (MstEtcVO[])models.toArray(new	MstEtcVO[models.size()]);
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
		this.cntrNo2 =	this.cntrNo2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo3 =	this.cntrNo3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gubun =	this.gubun.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmSerNo =	this.fmSerNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsEvntYdCd =	this.stsEvntYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lotPlnYr =	this.lotPlnYr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lotSeq =	this.lotSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lotLocCd =	this.lotLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo0 =	this.cntrNo0.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo1 =	this.cntrNo1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pickUpDueDate =	this.pickUpDueDate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidType =	this.hidType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lotCntrPfxCd =	this.lotCntrPfxCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd =	this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCtyCd =	this.agmtCtyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toSerNo =	this.toSerNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd =	this.lstmCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifCd =	this.ifCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lotNo =	this.lotNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq =	this.agmtSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.approvalVol =	this.approvalVol.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hireDate =	this.hireDate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo =	this.agmtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.approvalNo =	this.approvalNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctype =	this.ctype.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deYrmon =	this.deYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mftDt =	this.mftDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pickUpVol =	this.pickUpVol.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.serialRange =	this.serialRange.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq =	this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo =	this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refNo =	this.refNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrAbbrNm =	this.vndrAbbrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMtrlCd =	this.cntrMtrlCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfTpCd =	this.rfTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.code =	this.code.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codeNm =	this.codeNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.termCngSeq =	this.termCngSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfHumidCtrlValCd =	this.rfHumidCtrlValCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfCmprCtnt =	this.rfCmprCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lotCntrTpszCd =	this.lotCntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSpecNo =	this.cntrSpecNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd =	this.eqTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onYdCd =	this.onYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offYdCd =	this.offYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrGrsWgt =	this.cntrGrsWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tareWgt =	this.tareWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}