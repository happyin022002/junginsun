/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ArrNtcCustListVO.java
*@FileTitle : ArrNtcCustListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.14
*@LastModifier : 박성호
*@LastVersion : 1.0
* 2009.12.14 박성호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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
public class ArrNtcCustListVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<ArrNtcCustListVO>  models =	new	ArrayList<ArrNtcCustListVO>();


	/*	Column Info	*/
	private  String	 eml4   =  null;
	/*	Column Info	*/
	private  String	 eml5   =  null;
	/*	Column Info	*/
	private  String	 evaluationYn   =  null;
	/*	Column Info	*/
	private  String	 custNm   =  null;
	/*	Column Info	*/
	private  String	 custCntcTpCd   =  null;
	/*	Column Info	*/
	private  String	 ibCmdtFlg   =  null;
	/*	Column Info	*/
	private  String	 rowCount   =  null;
	/*	Column Info	*/
	private  String	 blNo   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 ntcEml   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 scNo   =  null;
	/*	Column Info	*/
	private  String	 fax5   =  null;
	/*	Column Info	*/
	private  String	 fax4   =  null;
	/*	Column Info	*/
	private  String	 fax3   =  null;
	/*	Column Info	*/
	private  String	 custFaxNo   =  null;
	/*	Column Info	*/
	private  String	 fax2   =  null;
	/*	Column Info	*/
	private  String	 fax1   =  null;
	/*	Column Info	*/
	private  String	 bkgCustTpCd   =  null;
	/*	Column Info	*/
	private  String	 eml1   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 eml3   =  null;
	/*	Column Info	*/
	private  String	 custCntCd   =  null;
	/*	Column Info	*/
	private  String	 isAn   =  null;
	/*	Column Info	*/
	private  String	 valCd   =  null;
	/*	Column Info	*/
	private  String	 eml2   =  null;
	/*	Column Info	*/
	private  String	 delCd   =  null;
	/*	Column Info	*/
	private  String	 custAddr   =  null;
	/*	Column Info	*/
	private  String	 custSeq   =  null;
	/*	Column Info	*/
	private  String	 custEml   =  null;
	/*	Column Info	*/
	private  String	 vvd   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;
	/*	Column Info	*/
	private  String	 bkgNo   =  null;
	/*	Column Info	*/
	private  String	 vslInfoSetFlg   =  null;
	/*	Column Info	*/
	private  String	 custCd   =  null;
	/*	Column Info	*/
	private  String	 isValidated   =  null;
	/*	Column Info	*/
	private  String	 faxNo   =  null;
	/*	Column Info	*/
	private  String	 chgDpFlg   =  null;
	/*	Column Info	*/
	private  String	 faxSndFlg1   =  null;
	/*	Column Info	*/
	private  String	 faxSndFlg2   =  null;
	/*	Column Info	*/
	private  String	 faxSndFlg3   =  null;
	/*	Column Info	*/
	private  String	 faxSndFlg4   =  null;
	/*	Column Info	*/
	private  String	 faxSndFlg5   =  null;
	/*	Column Info	*/
	private  String	 emlSndFlg1   =  null;
	/*	Column Info	*/
	private  String	 emlSndFlg2   =  null;
	/*	Column Info	*/
	private  String	 emlSndFlg3   =  null;
	/*	Column Info	*/
	private  String	 emlSndFlg4   =  null;
	/*	Column Info	*/
	private  String	 emlSndFlg5   =  null;
	/*	Column Info	*/
	private  String	 frtTermCd   =  null;
	/*	Column Info	*/
	private  String	 fax6   =  null;
	/*	Column Info	*/
	private  String	 fax7   =  null;
	/*	Column Info	*/
	private  String	 eml6   =  null;
	/*	Column Info	*/
	private  String	 eml7   =  null;
	/*	Column Info	*/
	private  String	 faxSndFlg6   =  null;
	/*	Column Info	*/
	private  String	 faxSndFlg7   =  null;
	/*	Column Info	*/
	private  String	 emlSndFlg6   =  null;
	/*	Column Info	*/
	private  String	 emlSndFlg7   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public ArrNtcCustListVO(){}

	public ArrNtcCustListVO(String eml4,String eml5,String evaluationYn,String custNm,String custCntcTpCd,String ibCmdtFlg,String rowCount,String blNo,String pagerows,String ntcEml,String ibflag,String scNo,String fax5,String fax4,String fax3,String custFaxNo,String fax2,String fax1,String bkgCustTpCd,String eml1,String updUsrId,String eml3,String custCntCd,String isAn,String valCd,String eml2,String delCd,String custAddr,String custSeq,String custEml,String vvd,String creUsrId,String bkgNo,String vslInfoSetFlg,String custCd,String isValidated,String faxNo,String chgDpFlg,String faxSndFlg1,String faxSndFlg2,String faxSndFlg3,String faxSndFlg4,String faxSndFlg5,String emlSndFlg1,String emlSndFlg2,String emlSndFlg3,String emlSndFlg4,String emlSndFlg5,String frtTermCd,String fax6,String fax7,String eml6,String eml7,String faxSndFlg6,String faxSndFlg7,String emlSndFlg6,String emlSndFlg7)	{
		this.eml4  = eml4 ;
		this.eml5  = eml5 ;
		this.evaluationYn  = evaluationYn ;
		this.custNm  = custNm ;
		this.custCntcTpCd  = custCntcTpCd ;
		this.ibCmdtFlg  = ibCmdtFlg ;
		this.rowCount  = rowCount ;
		this.blNo  = blNo ;
		this.pagerows  = pagerows ;
		this.ntcEml  = ntcEml ;
		this.ibflag  = ibflag ;
		this.scNo  = scNo ;
		this.fax5  = fax5 ;
		this.fax4  = fax4 ;
		this.fax3  = fax3 ;
		this.custFaxNo  = custFaxNo ;
		this.fax2  = fax2 ;
		this.fax1  = fax1 ;
		this.bkgCustTpCd  = bkgCustTpCd ;
		this.eml1  = eml1 ;
		this.updUsrId  = updUsrId ;
		this.eml3  = eml3 ;
		this.custCntCd  = custCntCd ;
		this.isAn  = isAn ;
		this.valCd  = valCd ;
		this.eml2  = eml2 ;
		this.delCd  = delCd ;
		this.custAddr  = custAddr ;
		this.custSeq  = custSeq ;
		this.custEml  = custEml ;
		this.vvd  = vvd ;
		this.creUsrId  = creUsrId ;
		this.bkgNo  = bkgNo ;
		this.vslInfoSetFlg  = vslInfoSetFlg ;
		this.custCd  = custCd ;
		this.isValidated  = isValidated ;
		this.faxNo  = faxNo ;
		this.chgDpFlg  = chgDpFlg ;
		this.faxSndFlg1  = faxSndFlg1 ;
		this.faxSndFlg2  = faxSndFlg2 ;
		this.faxSndFlg3  = faxSndFlg3 ;
		this.faxSndFlg4  = faxSndFlg4 ;
		this.faxSndFlg5  = faxSndFlg5 ;
		this.emlSndFlg1  = emlSndFlg1 ;
		this.emlSndFlg2  = emlSndFlg2 ;
		this.emlSndFlg3  = emlSndFlg3 ;
		this.emlSndFlg4  = emlSndFlg4 ;
		this.emlSndFlg5  = emlSndFlg5 ;
		this.frtTermCd  = frtTermCd ;
		this.fax6  = fax6 ;
		this.fax7  = fax7 ;
		this.eml6  = eml6 ;
		this.eml7  = eml7 ;
		this.faxSndFlg6  = faxSndFlg6 ;
		this.faxSndFlg7  = faxSndFlg7 ;
		this.emlSndFlg6  = emlSndFlg6 ;
		this.emlSndFlg7  = emlSndFlg7 ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("eml4", getEml4());		
		this.hashColumns.put("eml5", getEml5());		
		this.hashColumns.put("evaluation_yn", getEvaluationYn());		
		this.hashColumns.put("cust_nm", getCustNm());		
		this.hashColumns.put("cust_cntc_tp_cd", getCustCntcTpCd());		
		this.hashColumns.put("ib_cmdt_flg", getIbCmdtFlg());		
		this.hashColumns.put("row_count", getRowCount());		
		this.hashColumns.put("bl_no", getBlNo());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("ntc_eml", getNtcEml());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("sc_no", getScNo());		
		this.hashColumns.put("fax5", getFax5());		
		this.hashColumns.put("fax4", getFax4());		
		this.hashColumns.put("fax3", getFax3());		
		this.hashColumns.put("cust_fax_no", getCustFaxNo());		
		this.hashColumns.put("fax2", getFax2());		
		this.hashColumns.put("fax1", getFax1());		
		this.hashColumns.put("bkg_cust_tp_cd", getBkgCustTpCd());		
		this.hashColumns.put("eml1", getEml1());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("eml3", getEml3());		
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());		
		this.hashColumns.put("is_an", getIsAn());		
		this.hashColumns.put("val_cd", getValCd());		
		this.hashColumns.put("eml2", getEml2());		
		this.hashColumns.put("del_cd", getDelCd());		
		this.hashColumns.put("cust_addr", getCustAddr());		
		this.hashColumns.put("cust_seq", getCustSeq());		
		this.hashColumns.put("cust_eml", getCustEml());		
		this.hashColumns.put("vvd", getVvd());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("bkg_no", getBkgNo());		
		this.hashColumns.put("vsl_info_set_flg", getVslInfoSetFlg());		
		this.hashColumns.put("cust_cd", getCustCd());		
		this.hashColumns.put("is_validated", getIsValidated());		
		this.hashColumns.put("fax_no", getFaxNo());		
		this.hashColumns.put("chg_dp_flg", getChgDpFlg());		
		this.hashColumns.put("fax_snd_flg1", getFaxSndFlg1());		
		this.hashColumns.put("fax_snd_flg2", getFaxSndFlg2());		
		this.hashColumns.put("fax_snd_flg3", getFaxSndFlg3());		
		this.hashColumns.put("fax_snd_flg4", getFaxSndFlg4());		
		this.hashColumns.put("fax_snd_flg5", getFaxSndFlg5());		
		this.hashColumns.put("eml_snd_flg1", getEmlSndFlg1());		
		this.hashColumns.put("eml_snd_flg2", getEmlSndFlg2());		
		this.hashColumns.put("eml_snd_flg3", getEmlSndFlg3());		
		this.hashColumns.put("eml_snd_flg4", getEmlSndFlg4());		
		this.hashColumns.put("eml_snd_flg5", getEmlSndFlg5());		
		this.hashColumns.put("frt_term_cd", getFrtTermCd());		
		this.hashColumns.put("fax6", getFax6());		
		this.hashColumns.put("fax7", getFax7());		
		this.hashColumns.put("eml6", getEml6());		
		this.hashColumns.put("eml7", getEml7());		
		this.hashColumns.put("fax_snd_flg6", getFaxSndFlg6());		
		this.hashColumns.put("fax_snd_flg7", getFaxSndFlg7());		
		this.hashColumns.put("eml_snd_flg6", getEmlSndFlg6());		
		this.hashColumns.put("eml_snd_flg7", getEmlSndFlg7());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("eml4", "eml4");
		this.hashFields.put("eml5", "eml5");
		this.hashFields.put("evaluation_yn", "evaluationYn");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("cust_cntc_tp_cd", "custCntcTpCd");
		this.hashFields.put("ib_cmdt_flg", "ibCmdtFlg");
		this.hashFields.put("row_count", "rowCount");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ntc_eml", "ntcEml");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("fax5", "fax5");
		this.hashFields.put("fax4", "fax4");
		this.hashFields.put("fax3", "fax3");
		this.hashFields.put("cust_fax_no", "custFaxNo");
		this.hashFields.put("fax2", "fax2");
		this.hashFields.put("fax1", "fax1");
		this.hashFields.put("bkg_cust_tp_cd", "bkgCustTpCd");
		this.hashFields.put("eml1", "eml1");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("eml3", "eml3");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("is_an", "isAn");
		this.hashFields.put("val_cd", "valCd");
		this.hashFields.put("eml2", "eml2");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("cust_addr", "custAddr");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("cust_eml", "custEml");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("vsl_info_set_flg", "vslInfoSetFlg");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("is_validated", "isValidated");
		this.hashFields.put("fax_no", "faxNo");
		this.hashFields.put("chg_dp_flg", "chgDpFlg");
		this.hashFields.put("fax_snd_flg1", "faxSndFlg1");
		this.hashFields.put("fax_snd_flg2", "faxSndFlg2");
		this.hashFields.put("fax_snd_flg3", "faxSndFlg3");
		this.hashFields.put("fax_snd_flg4", "faxSndFlg4");
		this.hashFields.put("fax_snd_flg5", "faxSndFlg5");
		this.hashFields.put("eml_snd_flg1", "emlSndFlg1");
		this.hashFields.put("eml_snd_flg2", "emlSndFlg2");
		this.hashFields.put("eml_snd_flg3", "emlSndFlg3");
		this.hashFields.put("eml_snd_flg4", "emlSndFlg4");
		this.hashFields.put("eml_snd_flg5", "emlSndFlg5");
		this.hashFields.put("frt_term_cd", "frtTermCd");
		this.hashFields.put("fax6", "fax6");
		this.hashFields.put("fax7", "fax7");
		this.hashFields.put("eml6", "eml6");
		this.hashFields.put("eml7", "eml7");
		this.hashFields.put("fax_snd_flg6", "faxSndFlg6");
		this.hashFields.put("fax_snd_flg7", "faxSndFlg7");
		this.hashFields.put("eml_snd_flg6", "emlSndFlg6");
		this.hashFields.put("eml_snd_flg7", "emlSndFlg7");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  eml4
	*/
	public void	setEml4( String	eml4 ) {
		this.eml4 =	eml4;
	}
 
	/**
	 * Column Info
	 * @return	eml4
	 */
	 public	 String	getEml4() {
		 return	this.eml4;
	 } 
 	/**
	* Column Info
	* @param  eml5
	*/
	public void	setEml5( String	eml5 ) {
		this.eml5 =	eml5;
	}
 
	/**
	 * Column Info
	 * @return	eml5
	 */
	 public	 String	getEml5() {
		 return	this.eml5;
	 } 
 	/**
	* Column Info
	* @param  evaluationYn
	*/
	public void	setEvaluationYn( String	evaluationYn ) {
		this.evaluationYn =	evaluationYn;
	}
 
	/**
	 * Column Info
	 * @return	evaluationYn
	 */
	 public	 String	getEvaluationYn() {
		 return	this.evaluationYn;
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
	* @param  custCntcTpCd
	*/
	public void	setCustCntcTpCd( String	custCntcTpCd ) {
		this.custCntcTpCd =	custCntcTpCd;
	}
 
	/**
	 * Column Info
	 * @return	custCntcTpCd
	 */
	 public	 String	getCustCntcTpCd() {
		 return	this.custCntcTpCd;
	 } 
 	/**
	* Column Info
	* @param  ibCmdtFlg
	*/
	public void	setIbCmdtFlg( String	ibCmdtFlg ) {
		this.ibCmdtFlg =	ibCmdtFlg;
	}
 
	/**
	 * Column Info
	 * @return	ibCmdtFlg
	 */
	 public	 String	getIbCmdtFlg() {
		 return	this.ibCmdtFlg;
	 } 
 	/**
	* Column Info
	* @param  rowCount
	*/
	public void	setRowCount( String	rowCount ) {
		this.rowCount =	rowCount;
	}
 
	/**
	 * Column Info
	 * @return	rowCount
	 */
	 public	 String	getRowCount() {
		 return	this.rowCount;
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
	* @param  ntcEml
	*/
	public void	setNtcEml( String	ntcEml ) {
		this.ntcEml =	ntcEml;
	}
 
	/**
	 * Column Info
	 * @return	ntcEml
	 */
	 public	 String	getNtcEml() {
		 return	this.ntcEml;
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
	* @param  fax5
	*/
	public void	setFax5( String	fax5 ) {
		this.fax5 =	fax5;
	}
 
	/**
	 * Column Info
	 * @return	fax5
	 */
	 public	 String	getFax5() {
		 return	this.fax5;
	 } 
 	/**
	* Column Info
	* @param  fax4
	*/
	public void	setFax4( String	fax4 ) {
		this.fax4 =	fax4;
	}
 
	/**
	 * Column Info
	 * @return	fax4
	 */
	 public	 String	getFax4() {
		 return	this.fax4;
	 } 
 	/**
	* Column Info
	* @param  fax3
	*/
	public void	setFax3( String	fax3 ) {
		this.fax3 =	fax3;
	}
 
	/**
	 * Column Info
	 * @return	fax3
	 */
	 public	 String	getFax3() {
		 return	this.fax3;
	 } 
 	/**
	* Column Info
	* @param  custFaxNo
	*/
	public void	setCustFaxNo( String	custFaxNo ) {
		this.custFaxNo =	custFaxNo;
	}
 
	/**
	 * Column Info
	 * @return	custFaxNo
	 */
	 public	 String	getCustFaxNo() {
		 return	this.custFaxNo;
	 } 
 	/**
	* Column Info
	* @param  fax2
	*/
	public void	setFax2( String	fax2 ) {
		this.fax2 =	fax2;
	}
 
	/**
	 * Column Info
	 * @return	fax2
	 */
	 public	 String	getFax2() {
		 return	this.fax2;
	 } 
 	/**
	* Column Info
	* @param  fax1
	*/
	public void	setFax1( String	fax1 ) {
		this.fax1 =	fax1;
	}
 
	/**
	 * Column Info
	 * @return	fax1
	 */
	 public	 String	getFax1() {
		 return	this.fax1;
	 } 
 	/**
	* Column Info
	* @param  bkgCustTpCd
	*/
	public void	setBkgCustTpCd( String	bkgCustTpCd ) {
		this.bkgCustTpCd =	bkgCustTpCd;
	}
 
	/**
	 * Column Info
	 * @return	bkgCustTpCd
	 */
	 public	 String	getBkgCustTpCd() {
		 return	this.bkgCustTpCd;
	 } 
 	/**
	* Column Info
	* @param  eml1
	*/
	public void	setEml1( String	eml1 ) {
		this.eml1 =	eml1;
	}
 
	/**
	 * Column Info
	 * @return	eml1
	 */
	 public	 String	getEml1() {
		 return	this.eml1;
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
	* @param  eml3
	*/
	public void	setEml3( String	eml3 ) {
		this.eml3 =	eml3;
	}
 
	/**
	 * Column Info
	 * @return	eml3
	 */
	 public	 String	getEml3() {
		 return	this.eml3;
	 } 
 	/**
	* Column Info
	* @param  custCntCd
	*/
	public void	setCustCntCd( String	custCntCd ) {
		this.custCntCd =	custCntCd;
	}
 
	/**
	 * Column Info
	 * @return	custCntCd
	 */
	 public	 String	getCustCntCd() {
		 return	this.custCntCd;
	 } 
 	/**
	* Column Info
	* @param  isAn
	*/
	public void	setIsAn( String	isAn ) {
		this.isAn =	isAn;
	}
 
	/**
	 * Column Info
	 * @return	isAn
	 */
	 public	 String	getIsAn() {
		 return	this.isAn;
	 } 
 	/**
	* Column Info
	* @param  valCd
	*/
	public void	setValCd( String	valCd ) {
		this.valCd =	valCd;
	}
 
	/**
	 * Column Info
	 * @return	valCd
	 */
	 public	 String	getValCd() {
		 return	this.valCd;
	 } 
 	/**
	* Column Info
	* @param  eml2
	*/
	public void	setEml2( String	eml2 ) {
		this.eml2 =	eml2;
	}
 
	/**
	 * Column Info
	 * @return	eml2
	 */
	 public	 String	getEml2() {
		 return	this.eml2;
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
	* @param  custAddr
	*/
	public void	setCustAddr( String	custAddr ) {
		this.custAddr =	custAddr;
	}
 
	/**
	 * Column Info
	 * @return	custAddr
	 */
	 public	 String	getCustAddr() {
		 return	this.custAddr;
	 } 
 	/**
	* Column Info
	* @param  custSeq
	*/
	public void	setCustSeq( String	custSeq ) {
		this.custSeq =	custSeq;
	}
 
	/**
	 * Column Info
	 * @return	custSeq
	 */
	 public	 String	getCustSeq() {
		 return	this.custSeq;
	 } 
 	/**
	* Column Info
	* @param  custEml
	*/
	public void	setCustEml( String	custEml ) {
		this.custEml =	custEml;
	}
 
	/**
	 * Column Info
	 * @return	custEml
	 */
	 public	 String	getCustEml() {
		 return	this.custEml;
	 } 
 	/**
	* Column Info
	* @param  vvd
	*/
	public void	setVvd( String	vvd ) {
		this.vvd =	vvd;
	}
 
	/**
	 * Column Info
	 * @return	vvd
	 */
	 public	 String	getVvd() {
		 return	this.vvd;
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
	* @param  vslInfoSetFlg
	*/
	public void	setVslInfoSetFlg( String	vslInfoSetFlg ) {
		this.vslInfoSetFlg =	vslInfoSetFlg;
	}
 
	/**
	 * Column Info
	 * @return	vslInfoSetFlg
	 */
	 public	 String	getVslInfoSetFlg() {
		 return	this.vslInfoSetFlg;
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
	* @param  isValidated
	*/
	public void	setIsValidated( String	isValidated ) {
		this.isValidated =	isValidated;
	}
 
	/**
	 * Column Info
	 * @return	isValidated
	 */
	 public	 String	getIsValidated() {
		 return	this.isValidated;
	 } 
 	/**
	* Column Info
	* @param  faxNo
	*/
	public void	setFaxNo( String	faxNo ) {
		this.faxNo =	faxNo;
	}
 
	/**
	 * Column Info
	 * @return	faxNo
	 */
	 public	 String	getFaxNo() {
		 return	this.faxNo;
	 } 
 	/**
	* Column Info
	* @param  chgDpFlg
	*/
	public void	setChgDpFlg( String	chgDpFlg ) {
		this.chgDpFlg =	chgDpFlg;
	}
 
	/**
	 * Column Info
	 * @return	chgDpFlg
	 */
	 public	 String	getChgDpFlg() {
		 return	this.chgDpFlg;
	 } 
 	/**
	* Column Info
	* @param  faxSndFlg1
	*/
	public void	setFaxSndFlg1( String	faxSndFlg1 ) {
		this.faxSndFlg1 =	faxSndFlg1;
	}
 
	/**
	 * Column Info
	 * @return	faxSndFlg1
	 */
	 public	 String	getFaxSndFlg1() {
		 return	this.faxSndFlg1;
	 } 
 	/**
	* Column Info
	* @param  faxSndFlg2
	*/
	public void	setFaxSndFlg2( String	faxSndFlg2 ) {
		this.faxSndFlg2 =	faxSndFlg2;
	}
 
	/**
	 * Column Info
	 * @return	faxSndFlg2
	 */
	 public	 String	getFaxSndFlg2() {
		 return	this.faxSndFlg2;
	 } 
 	/**
	* Column Info
	* @param  faxSndFlg3
	*/
	public void	setFaxSndFlg3( String	faxSndFlg3 ) {
		this.faxSndFlg3 =	faxSndFlg3;
	}
 
	/**
	 * Column Info
	 * @return	faxSndFlg3
	 */
	 public	 String	getFaxSndFlg3() {
		 return	this.faxSndFlg3;
	 } 
 	/**
	* Column Info
	* @param  faxSndFlg4
	*/
	public void	setFaxSndFlg4( String	faxSndFlg4 ) {
		this.faxSndFlg4 =	faxSndFlg4;
	}
 
	/**
	 * Column Info
	 * @return	faxSndFlg4
	 */
	 public	 String	getFaxSndFlg4() {
		 return	this.faxSndFlg4;
	 } 
 	/**
	* Column Info
	* @param  faxSndFlg5
	*/
	public void	setFaxSndFlg5( String	faxSndFlg5 ) {
		this.faxSndFlg5 =	faxSndFlg5;
	}
 
	/**
	 * Column Info
	 * @return	faxSndFlg5
	 */
	 public	 String	getFaxSndFlg5() {
		 return	this.faxSndFlg5;
	 } 
 	/**
	* Column Info
	* @param  emlSndFlg1
	*/
	public void	setEmlSndFlg1( String	emlSndFlg1 ) {
		this.emlSndFlg1 =	emlSndFlg1;
	}
 
	/**
	 * Column Info
	 * @return	emlSndFlg1
	 */
	 public	 String	getEmlSndFlg1() {
		 return	this.emlSndFlg1;
	 } 
 	/**
	* Column Info
	* @param  emlSndFlg2
	*/
	public void	setEmlSndFlg2( String	emlSndFlg2 ) {
		this.emlSndFlg2 =	emlSndFlg2;
	}
 
	/**
	 * Column Info
	 * @return	emlSndFlg2
	 */
	 public	 String	getEmlSndFlg2() {
		 return	this.emlSndFlg2;
	 } 
 	/**
	* Column Info
	* @param  emlSndFlg3
	*/
	public void	setEmlSndFlg3( String	emlSndFlg3 ) {
		this.emlSndFlg3 =	emlSndFlg3;
	}
 
	/**
	 * Column Info
	 * @return	emlSndFlg3
	 */
	 public	 String	getEmlSndFlg3() {
		 return	this.emlSndFlg3;
	 } 
 	/**
	* Column Info
	* @param  emlSndFlg4
	*/
	public void	setEmlSndFlg4( String	emlSndFlg4 ) {
		this.emlSndFlg4 =	emlSndFlg4;
	}
 
	/**
	 * Column Info
	 * @return	emlSndFlg4
	 */
	 public	 String	getEmlSndFlg4() {
		 return	this.emlSndFlg4;
	 } 
 	/**
	* Column Info
	* @param  emlSndFlg5
	*/
	public void	setEmlSndFlg5( String	emlSndFlg5 ) {
		this.emlSndFlg5 =	emlSndFlg5;
	}
 
	/**
	 * Column Info
	 * @return	emlSndFlg5
	 */
	 public	 String	getEmlSndFlg5() {
		 return	this.emlSndFlg5;
	 } 
 	/**
	* Column Info
	* @param  frtTermCd
	*/
	public void	setFrtTermCd( String	frtTermCd ) {
		this.frtTermCd =	frtTermCd;
	}
 
	/**
	 * Column Info
	 * @return	frtTermCd
	 */
	 public	 String	getFrtTermCd() {
		 return	this.frtTermCd;
	 } 
 	/**
	* Column Info
	* @param  fax6
	*/
	public void	setFax6( String	fax6 ) {
		this.fax6 =	fax6;
	}
 
	/**
	 * Column Info
	 * @return	fax6
	 */
	 public	 String	getFax6() {
		 return	this.fax6;
	 } 
 	/**
	* Column Info
	* @param  fax7
	*/
	public void	setFax7( String	fax7 ) {
		this.fax7 =	fax7;
	}
 
	/**
	 * Column Info
	 * @return	fax7
	 */
	 public	 String	getFax7() {
		 return	this.fax7;
	 } 
 	/**
	* Column Info
	* @param  eml6
	*/
	public void	setEml6( String	eml6 ) {
		this.eml6 =	eml6;
	}
 
	/**
	 * Column Info
	 * @return	eml6
	 */
	 public	 String	getEml6() {
		 return	this.eml6;
	 } 
 	/**
	* Column Info
	* @param  eml7
	*/
	public void	setEml7( String	eml7 ) {
		this.eml7 =	eml7;
	}
 
	/**
	 * Column Info
	 * @return	eml7
	 */
	 public	 String	getEml7() {
		 return	this.eml7;
	 } 
 	/**
	* Column Info
	* @param  faxSndFlg6
	*/
	public void	setFaxSndFlg6( String	faxSndFlg6 ) {
		this.faxSndFlg6 =	faxSndFlg6;
	}
 
	/**
	 * Column Info
	 * @return	faxSndFlg6
	 */
	 public	 String	getFaxSndFlg6() {
		 return	this.faxSndFlg6;
	 } 
 	/**
	* Column Info
	* @param  faxSndFlg7
	*/
	public void	setFaxSndFlg7( String	faxSndFlg7 ) {
		this.faxSndFlg7 =	faxSndFlg7;
	}
 
	/**
	 * Column Info
	 * @return	faxSndFlg7
	 */
	 public	 String	getFaxSndFlg7() {
		 return	this.faxSndFlg7;
	 } 
 	/**
	* Column Info
	* @param  emlSndFlg6
	*/
	public void	setEmlSndFlg6( String	emlSndFlg6 ) {
		this.emlSndFlg6 =	emlSndFlg6;
	}
 
	/**
	 * Column Info
	 * @return	emlSndFlg6
	 */
	 public	 String	getEmlSndFlg6() {
		 return	this.emlSndFlg6;
	 } 
 	/**
	* Column Info
	* @param  emlSndFlg7
	*/
	public void	setEmlSndFlg7( String	emlSndFlg7 ) {
		this.emlSndFlg7 =	emlSndFlg7;
	}
 
	/**
	 * Column Info
	 * @return	emlSndFlg7
	 */
	 public	 String	getEmlSndFlg7() {
		 return	this.emlSndFlg7;
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
		setEml4(JSPUtil.getParameter(request,	prefix + "eml4", ""));
		setEml5(JSPUtil.getParameter(request,	prefix + "eml5", ""));
		setEvaluationYn(JSPUtil.getParameter(request,	prefix + "evaluation_yn", ""));
		setCustNm(JSPUtil.getParameter(request,	prefix + "cust_nm", ""));
		setCustCntcTpCd(JSPUtil.getParameter(request,	prefix + "cust_cntc_tp_cd", ""));
		setIbCmdtFlg(JSPUtil.getParameter(request,	prefix + "ib_cmdt_flg", ""));
		setRowCount(JSPUtil.getParameter(request,	prefix + "row_count", ""));
		setBlNo(JSPUtil.getParameter(request,	prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setNtcEml(JSPUtil.getParameter(request,	prefix + "ntc_eml", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setScNo(JSPUtil.getParameter(request,	prefix + "sc_no", ""));
		setFax5(JSPUtil.getParameter(request,	prefix + "fax5", ""));
		setFax4(JSPUtil.getParameter(request,	prefix + "fax4", ""));
		setFax3(JSPUtil.getParameter(request,	prefix + "fax3", ""));
		setCustFaxNo(JSPUtil.getParameter(request,	prefix + "cust_fax_no", ""));
		setFax2(JSPUtil.getParameter(request,	prefix + "fax2", ""));
		setFax1(JSPUtil.getParameter(request,	prefix + "fax1", ""));
		setBkgCustTpCd(JSPUtil.getParameter(request,	prefix + "bkg_cust_tp_cd", ""));
		setEml1(JSPUtil.getParameter(request,	prefix + "eml1", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setEml3(JSPUtil.getParameter(request,	prefix + "eml3", ""));
		setCustCntCd(JSPUtil.getParameter(request,	prefix + "cust_cnt_cd", ""));
		setIsAn(JSPUtil.getParameter(request,	prefix + "is_an", ""));
		setValCd(JSPUtil.getParameter(request,	prefix + "val_cd", ""));
		setEml2(JSPUtil.getParameter(request,	prefix + "eml2", ""));
		setDelCd(JSPUtil.getParameter(request,	prefix + "del_cd", ""));
		setCustAddr(JSPUtil.getParameter(request,	prefix + "cust_addr", ""));
		setCustSeq(JSPUtil.getParameter(request,	prefix + "cust_seq", ""));
		setCustEml(JSPUtil.getParameter(request,	prefix + "cust_eml", ""));
		setVvd(JSPUtil.getParameter(request,	prefix + "vvd", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setBkgNo(JSPUtil.getParameter(request,	prefix + "bkg_no", ""));
		setVslInfoSetFlg(JSPUtil.getParameter(request,	prefix + "vsl_info_set_flg", ""));
		setCustCd(JSPUtil.getParameter(request,	prefix + "cust_cd", ""));
		setIsValidated(JSPUtil.getParameter(request,	prefix + "is_validated", ""));
		setFaxNo(JSPUtil.getParameter(request,	prefix + "fax_no", ""));
		setChgDpFlg(JSPUtil.getParameter(request,	prefix + "chg_dp_flg", ""));
		setFaxSndFlg1(JSPUtil.getParameter(request,	prefix + "fax_snd_flg1", ""));
		setFaxSndFlg2(JSPUtil.getParameter(request,	prefix + "fax_snd_flg2", ""));
		setFaxSndFlg3(JSPUtil.getParameter(request,	prefix + "fax_snd_flg3", ""));
		setFaxSndFlg4(JSPUtil.getParameter(request,	prefix + "fax_snd_flg4", ""));
		setFaxSndFlg5(JSPUtil.getParameter(request,	prefix + "fax_snd_flg5", ""));
		setEmlSndFlg1(JSPUtil.getParameter(request,	prefix + "eml_snd_flg1", ""));
		setEmlSndFlg2(JSPUtil.getParameter(request,	prefix + "eml_snd_flg2", ""));
		setEmlSndFlg3(JSPUtil.getParameter(request,	prefix + "eml_snd_flg3", ""));
		setEmlSndFlg4(JSPUtil.getParameter(request,	prefix + "eml_snd_flg4", ""));
		setEmlSndFlg5(JSPUtil.getParameter(request,	prefix + "eml_snd_flg5", ""));
		setFrtTermCd(JSPUtil.getParameter(request,	prefix + "frt_term_cd", ""));
		setFax6(JSPUtil.getParameter(request,	prefix + "fax6", ""));
		setFax7(JSPUtil.getParameter(request,	prefix + "fax7", ""));
		setEml6(JSPUtil.getParameter(request,	prefix + "eml6", ""));
		setEml7(JSPUtil.getParameter(request,	prefix + "eml7", ""));
		setFaxSndFlg6(JSPUtil.getParameter(request,	prefix + "fax_snd_flg6", ""));
		setFaxSndFlg7(JSPUtil.getParameter(request,	prefix + "fax_snd_flg7", ""));
		setEmlSndFlg6(JSPUtil.getParameter(request,	prefix + "eml_snd_flg6", ""));
		setEmlSndFlg7(JSPUtil.getParameter(request,	prefix + "eml_snd_flg7", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ArrNtcCustListVO[]
	 */
	public ArrNtcCustListVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return ArrNtcCustListVO[]
	 */
	public ArrNtcCustListVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		ArrNtcCustListVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] eml4 =	(JSPUtil.getParameter(request, prefix +	"eml4".trim(),	length));
				String[] eml5 =	(JSPUtil.getParameter(request, prefix +	"eml5".trim(),	length));
				String[] evaluationYn =	(JSPUtil.getParameter(request, prefix +	"evaluation_yn".trim(),	length));
				String[] custNm =	(JSPUtil.getParameter(request, prefix +	"cust_nm".trim(),	length));
				String[] custCntcTpCd =	(JSPUtil.getParameter(request, prefix +	"cust_cntc_tp_cd".trim(),	length));
				String[] ibCmdtFlg =	(JSPUtil.getParameter(request, prefix +	"ib_cmdt_flg".trim(),	length));
				String[] rowCount =	(JSPUtil.getParameter(request, prefix +	"row_count".trim(),	length));
				String[] blNo =	(JSPUtil.getParameter(request, prefix +	"bl_no".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] ntcEml =	(JSPUtil.getParameter(request, prefix +	"ntc_eml".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] scNo =	(JSPUtil.getParameter(request, prefix +	"sc_no".trim(),	length));
				String[] fax5 =	(JSPUtil.getParameter(request, prefix +	"fax5".trim(),	length));
				String[] fax4 =	(JSPUtil.getParameter(request, prefix +	"fax4".trim(),	length));
				String[] fax3 =	(JSPUtil.getParameter(request, prefix +	"fax3".trim(),	length));
				String[] custFaxNo =	(JSPUtil.getParameter(request, prefix +	"cust_fax_no".trim(),	length));
				String[] fax2 =	(JSPUtil.getParameter(request, prefix +	"fax2".trim(),	length));
				String[] fax1 =	(JSPUtil.getParameter(request, prefix +	"fax1".trim(),	length));
				String[] bkgCustTpCd =	(JSPUtil.getParameter(request, prefix +	"bkg_cust_tp_cd".trim(),	length));
				String[] eml1 =	(JSPUtil.getParameter(request, prefix +	"eml1".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] eml3 =	(JSPUtil.getParameter(request, prefix +	"eml3".trim(),	length));
				String[] custCntCd =	(JSPUtil.getParameter(request, prefix +	"cust_cnt_cd".trim(),	length));
				String[] isAn =	(JSPUtil.getParameter(request, prefix +	"is_an".trim(),	length));
				String[] valCd =	(JSPUtil.getParameter(request, prefix +	"val_cd".trim(),	length));
				String[] eml2 =	(JSPUtil.getParameter(request, prefix +	"eml2".trim(),	length));
				String[] delCd =	(JSPUtil.getParameter(request, prefix +	"del_cd".trim(),	length));
				String[] custAddr =	(JSPUtil.getParameter(request, prefix +	"cust_addr".trim(),	length));
				String[] custSeq =	(JSPUtil.getParameter(request, prefix +	"cust_seq".trim(),	length));
				String[] custEml =	(JSPUtil.getParameter(request, prefix +	"cust_eml".trim(),	length));
				String[] vvd =	(JSPUtil.getParameter(request, prefix +	"vvd".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				String[] bkgNo =	(JSPUtil.getParameter(request, prefix +	"bkg_no".trim(),	length));
				String[] vslInfoSetFlg =	(JSPUtil.getParameter(request, prefix +	"vsl_info_set_flg".trim(),	length));
				String[] custCd =	(JSPUtil.getParameter(request, prefix +	"cust_cd".trim(),	length));
				String[] isValidated =	(JSPUtil.getParameter(request, prefix +	"is_validated".trim(),	length));
				String[] faxNo =	(JSPUtil.getParameter(request, prefix +	"fax_no".trim(),	length));
				String[] chgDpFlg =	(JSPUtil.getParameter(request, prefix +	"chg_dp_flg".trim(),	length));
				String[] faxSndFlg1 =	(JSPUtil.getParameter(request, prefix +	"fax_snd_flg1".trim(),	length));
				String[] faxSndFlg2 =	(JSPUtil.getParameter(request, prefix +	"fax_snd_flg2".trim(),	length));
				String[] faxSndFlg3 =	(JSPUtil.getParameter(request, prefix +	"fax_snd_flg3".trim(),	length));
				String[] faxSndFlg4 =	(JSPUtil.getParameter(request, prefix +	"fax_snd_flg4".trim(),	length));
				String[] faxSndFlg5 =	(JSPUtil.getParameter(request, prefix +	"fax_snd_flg5".trim(),	length));
				String[] emlSndFlg1 =	(JSPUtil.getParameter(request, prefix +	"eml_snd_flg1".trim(),	length));
				String[] emlSndFlg2 =	(JSPUtil.getParameter(request, prefix +	"eml_snd_flg2".trim(),	length));
				String[] emlSndFlg3 =	(JSPUtil.getParameter(request, prefix +	"eml_snd_flg3".trim(),	length));
				String[] emlSndFlg4 =	(JSPUtil.getParameter(request, prefix +	"eml_snd_flg4".trim(),	length));
				String[] emlSndFlg5 =	(JSPUtil.getParameter(request, prefix +	"eml_snd_flg5".trim(),	length));
				String[] frtTermCd =	(JSPUtil.getParameter(request, prefix +	"frt_term_cd".trim(),	length));
				String[] fax6 =	(JSPUtil.getParameter(request, prefix +	"fax6".trim(),	length));
				String[] fax7 =	(JSPUtil.getParameter(request, prefix +	"fax7".trim(),	length));
				String[] eml6 =	(JSPUtil.getParameter(request, prefix +	"eml6".trim(),	length));
				String[] eml7 =	(JSPUtil.getParameter(request, prefix +	"eml7".trim(),	length));
				String[] faxSndFlg6 =	(JSPUtil.getParameter(request, prefix +	"fax_snd_flg6".trim(),	length));
				String[] faxSndFlg7 =	(JSPUtil.getParameter(request, prefix +	"fax_snd_flg7".trim(),	length));
				String[] emlSndFlg6 =	(JSPUtil.getParameter(request, prefix +	"eml_snd_flg6".trim(),	length));
				String[] emlSndFlg7 =	(JSPUtil.getParameter(request, prefix +	"eml_snd_flg7".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	ArrNtcCustListVO();
						if ( eml4[i] !=	null)
						model.setEml4( eml4[i]);
						if ( eml5[i] !=	null)
						model.setEml5( eml5[i]);
						if ( evaluationYn[i] !=	null)
						model.setEvaluationYn( evaluationYn[i]);
						if ( custNm[i] !=	null)
						model.setCustNm( custNm[i]);
						if ( custCntcTpCd[i] !=	null)
						model.setCustCntcTpCd( custCntcTpCd[i]);
						if ( ibCmdtFlg[i] !=	null)
						model.setIbCmdtFlg( ibCmdtFlg[i]);
						if ( rowCount[i] !=	null)
						model.setRowCount( rowCount[i]);
						if ( blNo[i] !=	null)
						model.setBlNo( blNo[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( ntcEml[i] !=	null)
						model.setNtcEml( ntcEml[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( scNo[i] !=	null)
						model.setScNo( scNo[i]);
						if ( fax5[i] !=	null)
						model.setFax5( fax5[i]);
						if ( fax4[i] !=	null)
						model.setFax4( fax4[i]);
						if ( fax3[i] !=	null)
						model.setFax3( fax3[i]);
						if ( custFaxNo[i] !=	null)
						model.setCustFaxNo( custFaxNo[i]);
						if ( fax2[i] !=	null)
						model.setFax2( fax2[i]);
						if ( fax1[i] !=	null)
						model.setFax1( fax1[i]);
						if ( bkgCustTpCd[i] !=	null)
						model.setBkgCustTpCd( bkgCustTpCd[i]);
						if ( eml1[i] !=	null)
						model.setEml1( eml1[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( eml3[i] !=	null)
						model.setEml3( eml3[i]);
						if ( custCntCd[i] !=	null)
						model.setCustCntCd( custCntCd[i]);
						if ( isAn[i] !=	null)
						model.setIsAn( isAn[i]);
						if ( valCd[i] !=	null)
						model.setValCd( valCd[i]);
						if ( eml2[i] !=	null)
						model.setEml2( eml2[i]);
						if ( delCd[i] !=	null)
						model.setDelCd( delCd[i]);
						if ( custAddr[i] !=	null)
						model.setCustAddr( custAddr[i]);
						if ( custSeq[i] !=	null)
						model.setCustSeq( custSeq[i]);
						if ( custEml[i] !=	null)
						model.setCustEml( custEml[i]);
						if ( vvd[i] !=	null)
						model.setVvd( vvd[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
						if ( bkgNo[i] !=	null)
						model.setBkgNo( bkgNo[i]);
						if ( vslInfoSetFlg[i] !=	null)
						model.setVslInfoSetFlg( vslInfoSetFlg[i]);
						if ( custCd[i] !=	null)
						model.setCustCd( custCd[i]);
						if ( isValidated[i] !=	null)
						model.setIsValidated( isValidated[i]);
						if ( faxNo[i] !=	null)
						model.setFaxNo( faxNo[i]);
						if ( chgDpFlg[i] !=	null)
						model.setChgDpFlg( chgDpFlg[i]);
						if ( faxSndFlg1[i] !=	null)
						model.setFaxSndFlg1( faxSndFlg1[i]);
						if ( faxSndFlg2[i] !=	null)
						model.setFaxSndFlg2( faxSndFlg2[i]);
						if ( faxSndFlg3[i] !=	null)
						model.setFaxSndFlg3( faxSndFlg3[i]);
						if ( faxSndFlg4[i] !=	null)
						model.setFaxSndFlg4( faxSndFlg4[i]);
						if ( faxSndFlg5[i] !=	null)
						model.setFaxSndFlg5( faxSndFlg5[i]);
						if ( emlSndFlg1[i] !=	null)
						model.setEmlSndFlg1( emlSndFlg1[i]);
						if ( emlSndFlg2[i] !=	null)
						model.setEmlSndFlg2( emlSndFlg2[i]);
						if ( emlSndFlg3[i] !=	null)
						model.setEmlSndFlg3( emlSndFlg3[i]);
						if ( emlSndFlg4[i] !=	null)
						model.setEmlSndFlg4( emlSndFlg4[i]);
						if ( emlSndFlg5[i] !=	null)
						model.setEmlSndFlg5( emlSndFlg5[i]);
						if ( frtTermCd[i] !=	null)
						model.setFrtTermCd( frtTermCd[i]);
						if ( fax6[i] !=	null)
						model.setFax6( fax6[i]);
						if ( fax7[i] !=	null)
						model.setFax7( fax7[i]);
						if ( eml6[i] !=	null)
						model.setEml6( eml6[i]);
						if ( eml7[i] !=	null)
						model.setEml7( eml7[i]);
						if ( faxSndFlg6[i] !=	null)
						model.setFaxSndFlg6( faxSndFlg6[i]);
						if ( faxSndFlg7[i] !=	null)
						model.setFaxSndFlg7( faxSndFlg7[i]);
						if ( emlSndFlg6[i] !=	null)
						model.setEmlSndFlg6( emlSndFlg6[i]);
						if ( emlSndFlg7[i] !=	null)
						model.setEmlSndFlg7( emlSndFlg7[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getArrNtcCustListVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return ArrNtcCustListVO[]
	 */
	public ArrNtcCustListVO[]	 getArrNtcCustListVOs(){
		ArrNtcCustListVO[] vos = (ArrNtcCustListVO[])models.toArray(new	ArrNtcCustListVO[models.size()]);
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
		this.eml4 =	this.eml4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eml5 =	this.eml5.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evaluationYn =	this.evaluationYn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm =	this.custNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntcTpCd =	this.custCntcTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibCmdtFlg =	this.ibCmdtFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowCount =	this.rowCount.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo =	this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcEml =	this.ntcEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo =	this.scNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fax5 =	this.fax5.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fax4 =	this.fax4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fax3 =	this.fax3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custFaxNo =	this.custFaxNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fax2 =	this.fax2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fax1 =	this.fax1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCustTpCd =	this.bkgCustTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eml1 =	this.eml1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eml3 =	this.eml3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd =	this.custCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isAn =	this.isAn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.valCd =	this.valCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eml2 =	this.eml2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd =	this.delCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custAddr =	this.custAddr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq =	this.custSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custEml =	this.custEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd =	this.vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo =	this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslInfoSetFlg =	this.vslInfoSetFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd =	this.custCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isValidated =	this.isValidated.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo =	this.faxNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgDpFlg =	this.chgDpFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSndFlg1 =	this.faxSndFlg1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSndFlg2 =	this.faxSndFlg2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSndFlg3 =	this.faxSndFlg3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSndFlg4 =	this.faxSndFlg4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSndFlg5 =	this.faxSndFlg5.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndFlg1 =	this.emlSndFlg1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndFlg2 =	this.emlSndFlg2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndFlg3 =	this.emlSndFlg3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndFlg4 =	this.emlSndFlg4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndFlg5 =	this.emlSndFlg5.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtTermCd =	this.frtTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fax6 =	this.fax6.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fax7 =	this.fax7.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eml6 =	this.eml6.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eml7 =	this.eml7.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSndFlg6 =	this.faxSndFlg6.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSndFlg7 =	this.faxSndFlg7.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndFlg6 =	this.emlSndFlg6.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndFlg7 =	this.emlSndFlg7.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}