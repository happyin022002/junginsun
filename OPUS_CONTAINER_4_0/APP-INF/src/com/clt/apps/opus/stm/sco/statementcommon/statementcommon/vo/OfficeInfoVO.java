/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : OfficeInfoVO.java
 *@FileTitle : OfficeInfoVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.09.22
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2016.09.22  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo;

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
public class OfficeInfoVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<OfficeInfoVO>  models =	new	ArrayList<OfficeInfoVO>();


	/*	Column Info	*/
	private  String	 ofcWrtfTpCd1   =  null;
	/*	Column Info	*/
	private  String	 agnPfxCd   =  null;
	/*	Column Info	*/
	private  String	 ofcWrtfTpCd4   =  null;
	/*	Column Info	*/
	private  String	 otsIfFlg   =  null;
	/*	Column Info	*/
	private  String	 ofcWrtfTpCd5   =  null;
	/*	Column Info	*/
	private  String	 bankChgAcctCd   =  null;
	/*	Column Info	*/
	private  String	 ofcWrtfTpCd2   =  null;
	/*	Column Info	*/
	private  String	 ofcWrtfTpCd3   =  null;
	/*	Column Info	*/
	private  String	 creDt   =  null;
	/*	Column Info	*/
	private  String	 miscIncmLmtAmt   =  null;
	/*	Column Info	*/
	private  String	 agnOtsLmtAmt   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 bankCtrlCd   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 ofcEntrLvlCd   =  null;
	/*	Column Info	*/
	private  String	 rctOfcAddr   =  null;
	/*	Column Info	*/
	private  String	 arPrnTitNm   =  null;
	/*	Column Info	*/
	private  String	 rctOfcSpclNoCtnt   =  null;
	/*	Column Info	*/
	private  String	 agnCurrCd   =  null;
	/*	Column Info	*/
	private  String	 rctDocCd   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 updDt   =  null;
	/*	Column Info	*/
	private  String	 arCrCustPrnCtnt   =  null;
	/*	Column Info	*/
	private  String	 ovpayTpCd   =  null;
	/*	Column Info	*/
	private  String	 ofcBrncAgnTpCd   =  null;
	/*	Column Info	*/
	private  String	 rctTitNm   =  null;
	/*	Column Info	*/
	private  String	 rctRmk   =  null;
	/*	Column Info	*/
	private  String	 loclCurrCd   =  null;
	/*	Column Info	*/
	private  String	 rctOfcTelcmFaxNoCtnt   =  null;
	/*	Column Info	*/
	private  String	 arPrnCtnt   =  null;
	/*	Column Info	*/
	private  String	 enblFlg   =  null;
	/*	Column Info	*/
	private  String	 ofcCd   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;
	/*	Column Info	*/
	private  String	 otsCateCd   =  null;
	/*	Column Info	*/
	private  String	 otsCd   =  null;
	/*	Column Info	*/
	private  String	 bankOfc   =  null;
	/*	Column Info	*/
	private  String	 rctTpCd   =  null;
	/*	Column Info	*/
	private  String	 rctSpclRmk   =  null;
	/*	Column Info	*/
	private  String	 rctOfcTitNm   =  null;
	/*	Column Info	*/
	private  String	 agnCmbCd   =  null;
	/*	Column Info	*/
	private  String	 refEml   =  null;
	/*	Column Info	*/
	private  String	 repOtsOfcCd   =  null;
	/*	Column Info	*/
	private  String	 miscLssLmtAmt   =  null;
	/*	Column Info	*/
	private  String	 rctUnapyFlg   =  null;
	/*	Column Info	*/
	private  String	 ofcInqLvlCd   =  null;
	/*	Column Info	*/
	private  String	 ofcAdjTpCd1   =  null;
	/*	Column Info	*/
	private  String	 ofcAdjTpCd2   =  null;
	/*	Column Info	*/
	private  String	 ofcAdjTpCd3   =  null;
	/*	Column Info	*/
	private  String	 ofcAdjTpCd4   =  null;
	/*	Column Info	*/
	private  String	 ofcAdjTpCd5   =  null;
	/*	Column Info	*/
	private  String	 agnOtsLmtFlg   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public OfficeInfoVO(){}

	public OfficeInfoVO(String ofcWrtfTpCd1,String agnPfxCd,String ofcWrtfTpCd4,String otsIfFlg,String ofcWrtfTpCd5,String bankChgAcctCd,String ofcWrtfTpCd2,String ofcWrtfTpCd3,String creDt,String miscIncmLmtAmt,String agnOtsLmtAmt,String pagerows,String bankCtrlCd,String ibflag,String ofcEntrLvlCd,String rctOfcAddr,String arPrnTitNm,String rctOfcSpclNoCtnt,String agnCurrCd,String rctDocCd,String updUsrId,String updDt,String arCrCustPrnCtnt,String ovpayTpCd,String ofcBrncAgnTpCd,String rctTitNm,String rctRmk,String loclCurrCd,String rctOfcTelcmFaxNoCtnt,String arPrnCtnt,String enblFlg,String ofcCd,String creUsrId,String otsCateCd,String otsCd,String bankOfc,String rctTpCd,String rctSpclRmk,String rctOfcTitNm,String agnCmbCd,String refEml,String repOtsOfcCd,String miscLssLmtAmt,String rctUnapyFlg,String ofcInqLvlCd,String ofcAdjTpCd1,String ofcAdjTpCd2,String ofcAdjTpCd3,String ofcAdjTpCd4,String ofcAdjTpCd5,String agnOtsLmtFlg)	{
		this.ofcWrtfTpCd1  = ofcWrtfTpCd1 ;
		this.agnPfxCd  = agnPfxCd ;
		this.ofcWrtfTpCd4  = ofcWrtfTpCd4 ;
		this.otsIfFlg  = otsIfFlg ;
		this.ofcWrtfTpCd5  = ofcWrtfTpCd5 ;
		this.bankChgAcctCd  = bankChgAcctCd ;
		this.ofcWrtfTpCd2  = ofcWrtfTpCd2 ;
		this.ofcWrtfTpCd3  = ofcWrtfTpCd3 ;
		this.creDt  = creDt ;
		this.miscIncmLmtAmt  = miscIncmLmtAmt ;
		this.agnOtsLmtAmt  = agnOtsLmtAmt ;
		this.pagerows  = pagerows ;
		this.bankCtrlCd  = bankCtrlCd ;
		this.ibflag  = ibflag ;
		this.ofcEntrLvlCd  = ofcEntrLvlCd ;
		this.rctOfcAddr  = rctOfcAddr ;
		this.arPrnTitNm  = arPrnTitNm ;
		this.rctOfcSpclNoCtnt  = rctOfcSpclNoCtnt ;
		this.agnCurrCd  = agnCurrCd ;
		this.rctDocCd  = rctDocCd ;
		this.updUsrId  = updUsrId ;
		this.updDt  = updDt ;
		this.arCrCustPrnCtnt  = arCrCustPrnCtnt ;
		this.ovpayTpCd  = ovpayTpCd ;
		this.ofcBrncAgnTpCd  = ofcBrncAgnTpCd ;
		this.rctTitNm  = rctTitNm ;
		this.rctRmk  = rctRmk ;
		this.loclCurrCd  = loclCurrCd ;
		this.rctOfcTelcmFaxNoCtnt  = rctOfcTelcmFaxNoCtnt ;
		this.arPrnCtnt  = arPrnCtnt ;
		this.enblFlg  = enblFlg ;
		this.ofcCd  = ofcCd ;
		this.creUsrId  = creUsrId ;
		this.otsCateCd  = otsCateCd ;
		this.otsCd  = otsCd ;
		this.bankOfc  = bankOfc ;
		this.rctTpCd  = rctTpCd ;
		this.rctSpclRmk  = rctSpclRmk ;
		this.rctOfcTitNm  = rctOfcTitNm ;
		this.agnCmbCd  = agnCmbCd ;
		this.refEml  = refEml ;
		this.repOtsOfcCd  = repOtsOfcCd ;
		this.miscLssLmtAmt  = miscLssLmtAmt ;
		this.rctUnapyFlg  = rctUnapyFlg ;
		this.ofcInqLvlCd  = ofcInqLvlCd ;
		this.ofcAdjTpCd1  = ofcAdjTpCd1 ;
		this.ofcAdjTpCd2  = ofcAdjTpCd2 ;
		this.ofcAdjTpCd3  = ofcAdjTpCd3 ;
		this.ofcAdjTpCd4  = ofcAdjTpCd4 ;
		this.ofcAdjTpCd5  = ofcAdjTpCd5 ;
		this.agnOtsLmtFlg  = agnOtsLmtFlg ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ofc_wrtf_tp_cd1", getOfcWrtfTpCd1());		
		this.hashColumns.put("agn_pfx_cd", getAgnPfxCd());		
		this.hashColumns.put("ofc_wrtf_tp_cd4", getOfcWrtfTpCd4());		
		this.hashColumns.put("ots_if_flg", getOtsIfFlg());		
		this.hashColumns.put("ofc_wrtf_tp_cd5", getOfcWrtfTpCd5());		
		this.hashColumns.put("bank_chg_acct_cd", getBankChgAcctCd());		
		this.hashColumns.put("ofc_wrtf_tp_cd2", getOfcWrtfTpCd2());		
		this.hashColumns.put("ofc_wrtf_tp_cd3", getOfcWrtfTpCd3());		
		this.hashColumns.put("cre_dt", getCreDt());		
		this.hashColumns.put("misc_incm_lmt_amt", getMiscIncmLmtAmt());		
		this.hashColumns.put("agn_ots_lmt_amt", getAgnOtsLmtAmt());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("bank_ctrl_cd", getBankCtrlCd());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("ofc_entr_lvl_cd", getOfcEntrLvlCd());		
		this.hashColumns.put("rct_ofc_addr", getRctOfcAddr());		
		this.hashColumns.put("ar_prn_tit_nm", getArPrnTitNm());		
		this.hashColumns.put("rct_ofc_spcl_no_ctnt", getRctOfcSpclNoCtnt());		
		this.hashColumns.put("agn_curr_cd", getAgnCurrCd());		
		this.hashColumns.put("rct_doc_cd", getRctDocCd());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("upd_dt", getUpdDt());		
		this.hashColumns.put("ar_cr_cust_prn_ctnt", getArCrCustPrnCtnt());		
		this.hashColumns.put("ovpay_tp_cd", getOvpayTpCd());		
		this.hashColumns.put("ofc_brnc_agn_tp_cd", getOfcBrncAgnTpCd());		
		this.hashColumns.put("rct_tit_nm", getRctTitNm());		
		this.hashColumns.put("rct_rmk", getRctRmk());		
		this.hashColumns.put("locl_curr_cd", getLoclCurrCd());		
		this.hashColumns.put("rct_ofc_telcm_fax_no_ctnt", getRctOfcTelcmFaxNoCtnt());		
		this.hashColumns.put("ar_prn_ctnt", getArPrnCtnt());		
		this.hashColumns.put("enbl_flg", getEnblFlg());		
		this.hashColumns.put("ofc_cd", getOfcCd());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("ots_cate_cd", getOtsCateCd());		
		this.hashColumns.put("ots_cd", getOtsCd());		
		this.hashColumns.put("bank_ofc", getBankOfc());		
		this.hashColumns.put("rct_tp_cd", getRctTpCd());		
		this.hashColumns.put("rct_spcl_rmk", getRctSpclRmk());		
		this.hashColumns.put("rct_ofc_tit_nm", getRctOfcTitNm());		
		this.hashColumns.put("agn_cmb_cd", getAgnCmbCd());		
		this.hashColumns.put("ref_eml", getRefEml());		
		this.hashColumns.put("rep_ots_ofc_cd", getRepOtsOfcCd());		
		this.hashColumns.put("misc_lss_lmt_amt", getMiscLssLmtAmt());		
		this.hashColumns.put("rct_unapy_flg", getRctUnapyFlg());		
		this.hashColumns.put("ofc_inq_lvl_cd", getOfcInqLvlCd());		
		this.hashColumns.put("ofc_adj_tp_cd1", getOfcAdjTpCd1());		
		this.hashColumns.put("ofc_adj_tp_cd2", getOfcAdjTpCd2());		
		this.hashColumns.put("ofc_adj_tp_cd3", getOfcAdjTpCd3());		
		this.hashColumns.put("ofc_adj_tp_cd4", getOfcAdjTpCd4());		
		this.hashColumns.put("ofc_adj_tp_cd5", getOfcAdjTpCd5());		
		this.hashColumns.put("agn_ots_lmt_flg", getAgnOtsLmtFlg());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("ofc_wrtf_tp_cd1", "ofcWrtfTpCd1");
		this.hashFields.put("agn_pfx_cd", "agnPfxCd");
		this.hashFields.put("ofc_wrtf_tp_cd4", "ofcWrtfTpCd4");
		this.hashFields.put("ots_if_flg", "otsIfFlg");
		this.hashFields.put("ofc_wrtf_tp_cd5", "ofcWrtfTpCd5");
		this.hashFields.put("bank_chg_acct_cd", "bankChgAcctCd");
		this.hashFields.put("ofc_wrtf_tp_cd2", "ofcWrtfTpCd2");
		this.hashFields.put("ofc_wrtf_tp_cd3", "ofcWrtfTpCd3");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("misc_incm_lmt_amt", "miscIncmLmtAmt");
		this.hashFields.put("agn_ots_lmt_amt", "agnOtsLmtAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bank_ctrl_cd", "bankCtrlCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ofc_entr_lvl_cd", "ofcEntrLvlCd");
		this.hashFields.put("rct_ofc_addr", "rctOfcAddr");
		this.hashFields.put("ar_prn_tit_nm", "arPrnTitNm");
		this.hashFields.put("rct_ofc_spcl_no_ctnt", "rctOfcSpclNoCtnt");
		this.hashFields.put("agn_curr_cd", "agnCurrCd");
		this.hashFields.put("rct_doc_cd", "rctDocCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("ar_cr_cust_prn_ctnt", "arCrCustPrnCtnt");
		this.hashFields.put("ovpay_tp_cd", "ovpayTpCd");
		this.hashFields.put("ofc_brnc_agn_tp_cd", "ofcBrncAgnTpCd");
		this.hashFields.put("rct_tit_nm", "rctTitNm");
		this.hashFields.put("rct_rmk", "rctRmk");
		this.hashFields.put("locl_curr_cd", "loclCurrCd");
		this.hashFields.put("rct_ofc_telcm_fax_no_ctnt", "rctOfcTelcmFaxNoCtnt");
		this.hashFields.put("ar_prn_ctnt", "arPrnCtnt");
		this.hashFields.put("enbl_flg", "enblFlg");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ots_cate_cd", "otsCateCd");
		this.hashFields.put("ots_cd", "otsCd");
		this.hashFields.put("bank_ofc", "bankOfc");
		this.hashFields.put("rct_tp_cd", "rctTpCd");
		this.hashFields.put("rct_spcl_rmk", "rctSpclRmk");
		this.hashFields.put("rct_ofc_tit_nm", "rctOfcTitNm");
		this.hashFields.put("agn_cmb_cd", "agnCmbCd");
		this.hashFields.put("ref_eml", "refEml");
		this.hashFields.put("rep_ots_ofc_cd", "repOtsOfcCd");
		this.hashFields.put("misc_lss_lmt_amt", "miscLssLmtAmt");
		this.hashFields.put("rct_unapy_flg", "rctUnapyFlg");
		this.hashFields.put("ofc_inq_lvl_cd", "ofcInqLvlCd");
		this.hashFields.put("ofc_adj_tp_cd1", "ofcAdjTpCd1");
		this.hashFields.put("ofc_adj_tp_cd2", "ofcAdjTpCd2");
		this.hashFields.put("ofc_adj_tp_cd3", "ofcAdjTpCd3");
		this.hashFields.put("ofc_adj_tp_cd4", "ofcAdjTpCd4");
		this.hashFields.put("ofc_adj_tp_cd5", "ofcAdjTpCd5");
		this.hashFields.put("agn_ots_lmt_flg", "agnOtsLmtFlg");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  ofcWrtfTpCd1
	*/
	public void	setOfcWrtfTpCd1( String	ofcWrtfTpCd1 ) {
		this.ofcWrtfTpCd1 =	ofcWrtfTpCd1;
	}
 
	/**
	 * Column Info
	 * @return	ofcWrtfTpCd1
	 */
	 public	 String	getOfcWrtfTpCd1() {
		 return	this.ofcWrtfTpCd1;
	 } 
 	/**
	* Column Info
	* @param  agnPfxCd
	*/
	public void	setAgnPfxCd( String	agnPfxCd ) {
		this.agnPfxCd =	agnPfxCd;
	}
 
	/**
	 * Column Info
	 * @return	agnPfxCd
	 */
	 public	 String	getAgnPfxCd() {
		 return	this.agnPfxCd;
	 } 
 	/**
	* Column Info
	* @param  ofcWrtfTpCd4
	*/
	public void	setOfcWrtfTpCd4( String	ofcWrtfTpCd4 ) {
		this.ofcWrtfTpCd4 =	ofcWrtfTpCd4;
	}
 
	/**
	 * Column Info
	 * @return	ofcWrtfTpCd4
	 */
	 public	 String	getOfcWrtfTpCd4() {
		 return	this.ofcWrtfTpCd4;
	 } 
 	/**
	* Column Info
	* @param  otsIfFlg
	*/
	public void	setOtsIfFlg( String	otsIfFlg ) {
		this.otsIfFlg =	otsIfFlg;
	}
 
	/**
	 * Column Info
	 * @return	otsIfFlg
	 */
	 public	 String	getOtsIfFlg() {
		 return	this.otsIfFlg;
	 } 
 	/**
	* Column Info
	* @param  ofcWrtfTpCd5
	*/
	public void	setOfcWrtfTpCd5( String	ofcWrtfTpCd5 ) {
		this.ofcWrtfTpCd5 =	ofcWrtfTpCd5;
	}
 
	/**
	 * Column Info
	 * @return	ofcWrtfTpCd5
	 */
	 public	 String	getOfcWrtfTpCd5() {
		 return	this.ofcWrtfTpCd5;
	 } 
 	/**
	* Column Info
	* @param  bankChgAcctCd
	*/
	public void	setBankChgAcctCd( String	bankChgAcctCd ) {
		this.bankChgAcctCd =	bankChgAcctCd;
	}
 
	/**
	 * Column Info
	 * @return	bankChgAcctCd
	 */
	 public	 String	getBankChgAcctCd() {
		 return	this.bankChgAcctCd;
	 } 
 	/**
	* Column Info
	* @param  ofcWrtfTpCd2
	*/
	public void	setOfcWrtfTpCd2( String	ofcWrtfTpCd2 ) {
		this.ofcWrtfTpCd2 =	ofcWrtfTpCd2;
	}
 
	/**
	 * Column Info
	 * @return	ofcWrtfTpCd2
	 */
	 public	 String	getOfcWrtfTpCd2() {
		 return	this.ofcWrtfTpCd2;
	 } 
 	/**
	* Column Info
	* @param  ofcWrtfTpCd3
	*/
	public void	setOfcWrtfTpCd3( String	ofcWrtfTpCd3 ) {
		this.ofcWrtfTpCd3 =	ofcWrtfTpCd3;
	}
 
	/**
	 * Column Info
	 * @return	ofcWrtfTpCd3
	 */
	 public	 String	getOfcWrtfTpCd3() {
		 return	this.ofcWrtfTpCd3;
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
	* @param  miscIncmLmtAmt
	*/
	public void	setMiscIncmLmtAmt( String	miscIncmLmtAmt ) {
		this.miscIncmLmtAmt =	miscIncmLmtAmt;
	}
 
	/**
	 * Column Info
	 * @return	miscIncmLmtAmt
	 */
	 public	 String	getMiscIncmLmtAmt() {
		 return	this.miscIncmLmtAmt;
	 } 
 	/**
	* Column Info
	* @param  agnOtsLmtAmt
	*/
	public void	setAgnOtsLmtAmt( String	agnOtsLmtAmt ) {
		this.agnOtsLmtAmt =	agnOtsLmtAmt;
	}
 
	/**
	 * Column Info
	 * @return	agnOtsLmtAmt
	 */
	 public	 String	getAgnOtsLmtAmt() {
		 return	this.agnOtsLmtAmt;
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
	* @param  bankCtrlCd
	*/
	public void	setBankCtrlCd( String	bankCtrlCd ) {
		this.bankCtrlCd =	bankCtrlCd;
	}
 
	/**
	 * Column Info
	 * @return	bankCtrlCd
	 */
	 public	 String	getBankCtrlCd() {
		 return	this.bankCtrlCd;
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
	* @param  ofcEntrLvlCd
	*/
	public void	setOfcEntrLvlCd( String	ofcEntrLvlCd ) {
		this.ofcEntrLvlCd =	ofcEntrLvlCd;
	}
 
	/**
	 * Column Info
	 * @return	ofcEntrLvlCd
	 */
	 public	 String	getOfcEntrLvlCd() {
		 return	this.ofcEntrLvlCd;
	 } 
 	/**
	* Column Info
	* @param  rctOfcAddr
	*/
	public void	setRctOfcAddr( String	rctOfcAddr ) {
		this.rctOfcAddr =	rctOfcAddr;
	}
 
	/**
	 * Column Info
	 * @return	rctOfcAddr
	 */
	 public	 String	getRctOfcAddr() {
		 return	this.rctOfcAddr;
	 } 
 	/**
	* Column Info
	* @param  arPrnTitNm
	*/
	public void	setArPrnTitNm( String	arPrnTitNm ) {
		this.arPrnTitNm =	arPrnTitNm;
	}
 
	/**
	 * Column Info
	 * @return	arPrnTitNm
	 */
	 public	 String	getArPrnTitNm() {
		 return	this.arPrnTitNm;
	 } 
 	/**
	* Column Info
	* @param  rctOfcSpclNoCtnt
	*/
	public void	setRctOfcSpclNoCtnt( String	rctOfcSpclNoCtnt ) {
		this.rctOfcSpclNoCtnt =	rctOfcSpclNoCtnt;
	}
 
	/**
	 * Column Info
	 * @return	rctOfcSpclNoCtnt
	 */
	 public	 String	getRctOfcSpclNoCtnt() {
		 return	this.rctOfcSpclNoCtnt;
	 } 
 	/**
	* Column Info
	* @param  agnCurrCd
	*/
	public void	setAgnCurrCd( String	agnCurrCd ) {
		this.agnCurrCd =	agnCurrCd;
	}
 
	/**
	 * Column Info
	 * @return	agnCurrCd
	 */
	 public	 String	getAgnCurrCd() {
		 return	this.agnCurrCd;
	 } 
 	/**
	* Column Info
	* @param  rctDocCd
	*/
	public void	setRctDocCd( String	rctDocCd ) {
		this.rctDocCd =	rctDocCd;
	}
 
	/**
	 * Column Info
	 * @return	rctDocCd
	 */
	 public	 String	getRctDocCd() {
		 return	this.rctDocCd;
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
	* @param  arCrCustPrnCtnt
	*/
	public void	setArCrCustPrnCtnt( String	arCrCustPrnCtnt ) {
		this.arCrCustPrnCtnt =	arCrCustPrnCtnt;
	}
 
	/**
	 * Column Info
	 * @return	arCrCustPrnCtnt
	 */
	 public	 String	getArCrCustPrnCtnt() {
		 return	this.arCrCustPrnCtnt;
	 } 
 	/**
	* Column Info
	* @param  ovpayTpCd
	*/
	public void	setOvpayTpCd( String	ovpayTpCd ) {
		this.ovpayTpCd =	ovpayTpCd;
	}
 
	/**
	 * Column Info
	 * @return	ovpayTpCd
	 */
	 public	 String	getOvpayTpCd() {
		 return	this.ovpayTpCd;
	 } 
 	/**
	* Column Info
	* @param  ofcBrncAgnTpCd
	*/
	public void	setOfcBrncAgnTpCd( String	ofcBrncAgnTpCd ) {
		this.ofcBrncAgnTpCd =	ofcBrncAgnTpCd;
	}
 
	/**
	 * Column Info
	 * @return	ofcBrncAgnTpCd
	 */
	 public	 String	getOfcBrncAgnTpCd() {
		 return	this.ofcBrncAgnTpCd;
	 } 
 	/**
	* Column Info
	* @param  rctTitNm
	*/
	public void	setRctTitNm( String	rctTitNm ) {
		this.rctTitNm =	rctTitNm;
	}
 
	/**
	 * Column Info
	 * @return	rctTitNm
	 */
	 public	 String	getRctTitNm() {
		 return	this.rctTitNm;
	 } 
 	/**
	* Column Info
	* @param  rctRmk
	*/
	public void	setRctRmk( String	rctRmk ) {
		this.rctRmk =	rctRmk;
	}
 
	/**
	 * Column Info
	 * @return	rctRmk
	 */
	 public	 String	getRctRmk() {
		 return	this.rctRmk;
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
	* @param  rctOfcTelcmFaxNoCtnt
	*/
	public void	setRctOfcTelcmFaxNoCtnt( String	rctOfcTelcmFaxNoCtnt ) {
		this.rctOfcTelcmFaxNoCtnt =	rctOfcTelcmFaxNoCtnt;
	}
 
	/**
	 * Column Info
	 * @return	rctOfcTelcmFaxNoCtnt
	 */
	 public	 String	getRctOfcTelcmFaxNoCtnt() {
		 return	this.rctOfcTelcmFaxNoCtnt;
	 } 
 	/**
	* Column Info
	* @param  arPrnCtnt
	*/
	public void	setArPrnCtnt( String	arPrnCtnt ) {
		this.arPrnCtnt =	arPrnCtnt;
	}
 
	/**
	 * Column Info
	 * @return	arPrnCtnt
	 */
	 public	 String	getArPrnCtnt() {
		 return	this.arPrnCtnt;
	 } 
 	/**
	* Column Info
	* @param  enblFlg
	*/
	public void	setEnblFlg( String	enblFlg ) {
		this.enblFlg =	enblFlg;
	}
 
	/**
	 * Column Info
	 * @return	enblFlg
	 */
	 public	 String	getEnblFlg() {
		 return	this.enblFlg;
	 } 
 	/**
	* Column Info
	* @param  ofcCd
	*/
	public void	setOfcCd( String	ofcCd ) {
		this.ofcCd =	ofcCd;
	}
 
	/**
	 * Column Info
	 * @return	ofcCd
	 */
	 public	 String	getOfcCd() {
		 return	this.ofcCd;
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
	* @param  otsCateCd
	*/
	public void	setOtsCateCd( String	otsCateCd ) {
		this.otsCateCd =	otsCateCd;
	}
 
	/**
	 * Column Info
	 * @return	otsCateCd
	 */
	 public	 String	getOtsCateCd() {
		 return	this.otsCateCd;
	 } 
 	/**
	* Column Info
	* @param  otsCd
	*/
	public void	setOtsCd( String	otsCd ) {
		this.otsCd =	otsCd;
	}
 
	/**
	 * Column Info
	 * @return	otsCd
	 */
	 public	 String	getOtsCd() {
		 return	this.otsCd;
	 } 
 	/**
	* Column Info
	* @param  bankOfc
	*/
	public void	setBankOfc( String	bankOfc ) {
		this.bankOfc =	bankOfc;
	}
 
	/**
	 * Column Info
	 * @return	bankOfc
	 */
	 public	 String	getBankOfc() {
		 return	this.bankOfc;
	 } 
 	/**
	* Column Info
	* @param  rctTpCd
	*/
	public void	setRctTpCd( String	rctTpCd ) {
		this.rctTpCd =	rctTpCd;
	}
 
	/**
	 * Column Info
	 * @return	rctTpCd
	 */
	 public	 String	getRctTpCd() {
		 return	this.rctTpCd;
	 } 
 	/**
	* Column Info
	* @param  rctSpclRmk
	*/
	public void	setRctSpclRmk( String	rctSpclRmk ) {
		this.rctSpclRmk =	rctSpclRmk;
	}
 
	/**
	 * Column Info
	 * @return	rctSpclRmk
	 */
	 public	 String	getRctSpclRmk() {
		 return	this.rctSpclRmk;
	 } 
 	/**
	* Column Info
	* @param  rctOfcTitNm
	*/
	public void	setRctOfcTitNm( String	rctOfcTitNm ) {
		this.rctOfcTitNm =	rctOfcTitNm;
	}
 
	/**
	 * Column Info
	 * @return	rctOfcTitNm
	 */
	 public	 String	getRctOfcTitNm() {
		 return	this.rctOfcTitNm;
	 } 
 	/**
	* Column Info
	* @param  agnCmbCd
	*/
	public void	setAgnCmbCd( String	agnCmbCd ) {
		this.agnCmbCd =	agnCmbCd;
	}
 
	/**
	 * Column Info
	 * @return	agnCmbCd
	 */
	 public	 String	getAgnCmbCd() {
		 return	this.agnCmbCd;
	 } 
 	/**
	* Column Info
	* @param  refEml
	*/
	public void	setRefEml( String	refEml ) {
		this.refEml =	refEml;
	}
 
	/**
	 * Column Info
	 * @return	refEml
	 */
	 public	 String	getRefEml() {
		 return	this.refEml;
	 } 
 	/**
	* Column Info
	* @param  repOtsOfcCd
	*/
	public void	setRepOtsOfcCd( String	repOtsOfcCd ) {
		this.repOtsOfcCd =	repOtsOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	repOtsOfcCd
	 */
	 public	 String	getRepOtsOfcCd() {
		 return	this.repOtsOfcCd;
	 } 
 	/**
	* Column Info
	* @param  miscLssLmtAmt
	*/
	public void	setMiscLssLmtAmt( String	miscLssLmtAmt ) {
		this.miscLssLmtAmt =	miscLssLmtAmt;
	}
 
	/**
	 * Column Info
	 * @return	miscLssLmtAmt
	 */
	 public	 String	getMiscLssLmtAmt() {
		 return	this.miscLssLmtAmt;
	 } 
 	/**
	* Column Info
	* @param  rctUnapyFlg
	*/
	public void	setRctUnapyFlg( String	rctUnapyFlg ) {
		this.rctUnapyFlg =	rctUnapyFlg;
	}
 
	/**
	 * Column Info
	 * @return	rctUnapyFlg
	 */
	 public	 String	getRctUnapyFlg() {
		 return	this.rctUnapyFlg;
	 } 
 	/**
	* Column Info
	* @param  ofcInqLvlCd
	*/
	public void	setOfcInqLvlCd( String	ofcInqLvlCd ) {
		this.ofcInqLvlCd =	ofcInqLvlCd;
	}
 
	/**
	 * Column Info
	 * @return	ofcInqLvlCd
	 */
	 public	 String	getOfcInqLvlCd() {
		 return	this.ofcInqLvlCd;
	 } 
 	/**
	* Column Info
	* @param  ofcAdjTpCd1
	*/
	public void	setOfcAdjTpCd1( String	ofcAdjTpCd1 ) {
		this.ofcAdjTpCd1 =	ofcAdjTpCd1;
	}
 
	/**
	 * Column Info
	 * @return	ofcAdjTpCd1
	 */
	 public	 String	getOfcAdjTpCd1() {
		 return	this.ofcAdjTpCd1;
	 } 
 	/**
	* Column Info
	* @param  ofcAdjTpCd2
	*/
	public void	setOfcAdjTpCd2( String	ofcAdjTpCd2 ) {
		this.ofcAdjTpCd2 =	ofcAdjTpCd2;
	}
 
	/**
	 * Column Info
	 * @return	ofcAdjTpCd2
	 */
	 public	 String	getOfcAdjTpCd2() {
		 return	this.ofcAdjTpCd2;
	 } 
 	/**
	* Column Info
	* @param  ofcAdjTpCd3
	*/
	public void	setOfcAdjTpCd3( String	ofcAdjTpCd3 ) {
		this.ofcAdjTpCd3 =	ofcAdjTpCd3;
	}
 
	/**
	 * Column Info
	 * @return	ofcAdjTpCd3
	 */
	 public	 String	getOfcAdjTpCd3() {
		 return	this.ofcAdjTpCd3;
	 } 
 	/**
	* Column Info
	* @param  ofcAdjTpCd4
	*/
	public void	setOfcAdjTpCd4( String	ofcAdjTpCd4 ) {
		this.ofcAdjTpCd4 =	ofcAdjTpCd4;
	}
 
	/**
	 * Column Info
	 * @return	ofcAdjTpCd4
	 */
	 public	 String	getOfcAdjTpCd4() {
		 return	this.ofcAdjTpCd4;
	 } 
 	/**
	* Column Info
	* @param  ofcAdjTpCd5
	*/
	public void	setOfcAdjTpCd5( String	ofcAdjTpCd5 ) {
		this.ofcAdjTpCd5 =	ofcAdjTpCd5;
	}
 
	/**
	 * Column Info
	 * @return	ofcAdjTpCd5
	 */
	 public	 String	getOfcAdjTpCd5() {
		 return	this.ofcAdjTpCd5;
	 } 
 	/**
	* Column Info
	* @param  agnOtsLmtFlg
	*/
	public void	setAgnOtsLmtFlg( String	agnOtsLmtFlg ) {
		this.agnOtsLmtFlg =	agnOtsLmtFlg;
	}
 
	/**
	 * Column Info
	 * @return	agnOtsLmtFlg
	 */
	 public	 String	getAgnOtsLmtFlg() {
		 return	this.agnOtsLmtFlg;
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
		setOfcWrtfTpCd1(JSPUtil.getParameter(request,	prefix + "ofc_wrtf_tp_cd1", ""));
		setAgnPfxCd(JSPUtil.getParameter(request,	prefix + "agn_pfx_cd", ""));
		setOfcWrtfTpCd4(JSPUtil.getParameter(request,	prefix + "ofc_wrtf_tp_cd4", ""));
		setOtsIfFlg(JSPUtil.getParameter(request,	prefix + "ots_if_flg", ""));
		setOfcWrtfTpCd5(JSPUtil.getParameter(request,	prefix + "ofc_wrtf_tp_cd5", ""));
		setBankChgAcctCd(JSPUtil.getParameter(request,	prefix + "bank_chg_acct_cd", ""));
		setOfcWrtfTpCd2(JSPUtil.getParameter(request,	prefix + "ofc_wrtf_tp_cd2", ""));
		setOfcWrtfTpCd3(JSPUtil.getParameter(request,	prefix + "ofc_wrtf_tp_cd3", ""));
		setCreDt(JSPUtil.getParameter(request,	prefix + "cre_dt", ""));
		setMiscIncmLmtAmt(JSPUtil.getParameter(request,	prefix + "misc_incm_lmt_amt", ""));
		setAgnOtsLmtAmt(JSPUtil.getParameter(request,	prefix + "agn_ots_lmt_amt", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setBankCtrlCd(JSPUtil.getParameter(request,	prefix + "bank_ctrl_cd", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setOfcEntrLvlCd(JSPUtil.getParameter(request,	prefix + "ofc_entr_lvl_cd", ""));
		setRctOfcAddr(JSPUtil.getParameter(request,	prefix + "rct_ofc_addr", ""));
		setArPrnTitNm(JSPUtil.getParameter(request,	prefix + "ar_prn_tit_nm", ""));
		setRctOfcSpclNoCtnt(JSPUtil.getParameter(request,	prefix + "rct_ofc_spcl_no_ctnt", ""));
		setAgnCurrCd(JSPUtil.getParameter(request,	prefix + "agn_curr_cd", ""));
		setRctDocCd(JSPUtil.getParameter(request,	prefix + "rct_doc_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request,	prefix + "upd_dt", ""));
		setArCrCustPrnCtnt(JSPUtil.getParameter(request,	prefix + "ar_cr_cust_prn_ctnt", ""));
		setOvpayTpCd(JSPUtil.getParameter(request,	prefix + "ovpay_tp_cd", ""));
		setOfcBrncAgnTpCd(JSPUtil.getParameter(request,	prefix + "ofc_brnc_agn_tp_cd", ""));
		setRctTitNm(JSPUtil.getParameter(request,	prefix + "rct_tit_nm", ""));
		setRctRmk(JSPUtil.getParameter(request,	prefix + "rct_rmk", ""));
		setLoclCurrCd(JSPUtil.getParameter(request,	prefix + "locl_curr_cd", ""));
		setRctOfcTelcmFaxNoCtnt(JSPUtil.getParameter(request,	prefix + "rct_ofc_telcm_fax_no_ctnt", ""));
		setArPrnCtnt(JSPUtil.getParameter(request,	prefix + "ar_prn_ctnt", ""));
		setEnblFlg(JSPUtil.getParameter(request,	prefix + "enbl_flg", ""));
		setOfcCd(JSPUtil.getParameter(request,	prefix + "ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setOtsCateCd(JSPUtil.getParameter(request,	prefix + "ots_cate_cd", ""));
		setOtsCd(JSPUtil.getParameter(request,	prefix + "ots_cd", ""));
		setBankOfc(JSPUtil.getParameter(request,	prefix + "bank_ofc", ""));
		setRctTpCd(JSPUtil.getParameter(request,	prefix + "rct_tp_cd", ""));
		setRctSpclRmk(JSPUtil.getParameter(request,	prefix + "rct_spcl_rmk", ""));
		setRctOfcTitNm(JSPUtil.getParameter(request,	prefix + "rct_ofc_tit_nm", ""));
		setAgnCmbCd(JSPUtil.getParameter(request,	prefix + "agn_cmb_cd", ""));
		setRefEml(JSPUtil.getParameter(request,	prefix + "ref_eml", ""));
		setRepOtsOfcCd(JSPUtil.getParameter(request,	prefix + "rep_ots_ofc_cd", ""));
		setMiscLssLmtAmt(JSPUtil.getParameter(request,	prefix + "misc_lss_lmt_amt", ""));
		setRctUnapyFlg(JSPUtil.getParameter(request,	prefix + "rct_unapy_flg", ""));
		setOfcInqLvlCd(JSPUtil.getParameter(request,	prefix + "ofc_inq_lvl_cd", ""));
		setOfcAdjTpCd1(JSPUtil.getParameter(request,	prefix + "ofc_adj_tp_cd1", ""));
		setOfcAdjTpCd2(JSPUtil.getParameter(request,	prefix + "ofc_adj_tp_cd2", ""));
		setOfcAdjTpCd3(JSPUtil.getParameter(request,	prefix + "ofc_adj_tp_cd3", ""));
		setOfcAdjTpCd4(JSPUtil.getParameter(request,	prefix + "ofc_adj_tp_cd4", ""));
		setOfcAdjTpCd5(JSPUtil.getParameter(request,	prefix + "ofc_adj_tp_cd5", ""));
		setAgnOtsLmtFlg(JSPUtil.getParameter(request,	prefix + "agn_ots_lmt_flg", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OfficeInfoVO[]
	 */
	public OfficeInfoVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return OfficeInfoVO[]
	 */
	public OfficeInfoVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		OfficeInfoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] ofcWrtfTpCd1 =	(JSPUtil.getParameter(request, prefix +	"ofc_wrtf_tp_cd1".trim(),	length));
				String[] agnPfxCd =	(JSPUtil.getParameter(request, prefix +	"agn_pfx_cd".trim(),	length));
				String[] ofcWrtfTpCd4 =	(JSPUtil.getParameter(request, prefix +	"ofc_wrtf_tp_cd4".trim(),	length));
				String[] otsIfFlg =	(JSPUtil.getParameter(request, prefix +	"ots_if_flg".trim(),	length));
				String[] ofcWrtfTpCd5 =	(JSPUtil.getParameter(request, prefix +	"ofc_wrtf_tp_cd5".trim(),	length));
				String[] bankChgAcctCd =	(JSPUtil.getParameter(request, prefix +	"bank_chg_acct_cd".trim(),	length));
				String[] ofcWrtfTpCd2 =	(JSPUtil.getParameter(request, prefix +	"ofc_wrtf_tp_cd2".trim(),	length));
				String[] ofcWrtfTpCd3 =	(JSPUtil.getParameter(request, prefix +	"ofc_wrtf_tp_cd3".trim(),	length));
				String[] creDt =	(JSPUtil.getParameter(request, prefix +	"cre_dt".trim(),	length));
				String[] miscIncmLmtAmt =	(JSPUtil.getParameter(request, prefix +	"misc_incm_lmt_amt".trim(),	length));
				String[] agnOtsLmtAmt =	(JSPUtil.getParameter(request, prefix +	"agn_ots_lmt_amt".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] bankCtrlCd =	(JSPUtil.getParameter(request, prefix +	"bank_ctrl_cd".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] ofcEntrLvlCd =	(JSPUtil.getParameter(request, prefix +	"ofc_entr_lvl_cd".trim(),	length));
				String[] rctOfcAddr =	(JSPUtil.getParameter(request, prefix +	"rct_ofc_addr".trim(),	length));
				String[] arPrnTitNm =	(JSPUtil.getParameter(request, prefix +	"ar_prn_tit_nm".trim(),	length));
				String[] rctOfcSpclNoCtnt =	(JSPUtil.getParameter(request, prefix +	"rct_ofc_spcl_no_ctnt".trim(),	length));
				String[] agnCurrCd =	(JSPUtil.getParameter(request, prefix +	"agn_curr_cd".trim(),	length));
				String[] rctDocCd =	(JSPUtil.getParameter(request, prefix +	"rct_doc_cd".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] updDt =	(JSPUtil.getParameter(request, prefix +	"upd_dt".trim(),	length));
				String[] arCrCustPrnCtnt =	(JSPUtil.getParameter(request, prefix +	"ar_cr_cust_prn_ctnt".trim(),	length));
				String[] ovpayTpCd =	(JSPUtil.getParameter(request, prefix +	"ovpay_tp_cd".trim(),	length));
				String[] ofcBrncAgnTpCd =	(JSPUtil.getParameter(request, prefix +	"ofc_brnc_agn_tp_cd".trim(),	length));
				String[] rctTitNm =	(JSPUtil.getParameter(request, prefix +	"rct_tit_nm".trim(),	length));
				String[] rctRmk =	(JSPUtil.getParameter(request, prefix +	"rct_rmk".trim(),	length));
				String[] loclCurrCd =	(JSPUtil.getParameter(request, prefix +	"locl_curr_cd".trim(),	length));
				String[] rctOfcTelcmFaxNoCtnt =	(JSPUtil.getParameter(request, prefix +	"rct_ofc_telcm_fax_no_ctnt".trim(),	length));
				String[] arPrnCtnt =	(JSPUtil.getParameter(request, prefix +	"ar_prn_ctnt".trim(),	length));
				String[] enblFlg =	(JSPUtil.getParameter(request, prefix +	"enbl_flg".trim(),	length));
				String[] ofcCd =	(JSPUtil.getParameter(request, prefix +	"ofc_cd".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				String[] otsCateCd =	(JSPUtil.getParameter(request, prefix +	"ots_cate_cd".trim(),	length));
				String[] otsCd =	(JSPUtil.getParameter(request, prefix +	"ots_cd".trim(),	length));
				String[] bankOfc =	(JSPUtil.getParameter(request, prefix +	"bank_ofc".trim(),	length));
				String[] rctTpCd =	(JSPUtil.getParameter(request, prefix +	"rct_tp_cd".trim(),	length));
				String[] rctSpclRmk =	(JSPUtil.getParameter(request, prefix +	"rct_spcl_rmk".trim(),	length));
				String[] rctOfcTitNm =	(JSPUtil.getParameter(request, prefix +	"rct_ofc_tit_nm".trim(),	length));
				String[] agnCmbCd =	(JSPUtil.getParameter(request, prefix +	"agn_cmb_cd".trim(),	length));
				String[] refEml =	(JSPUtil.getParameter(request, prefix +	"ref_eml".trim(),	length));
				String[] repOtsOfcCd =	(JSPUtil.getParameter(request, prefix +	"rep_ots_ofc_cd".trim(),	length));
				String[] miscLssLmtAmt =	(JSPUtil.getParameter(request, prefix +	"misc_lss_lmt_amt".trim(),	length));
				String[] rctUnapyFlg =	(JSPUtil.getParameter(request, prefix +	"rct_unapy_flg".trim(),	length));
				String[] ofcInqLvlCd =	(JSPUtil.getParameter(request, prefix +	"ofc_inq_lvl_cd".trim(),	length));
				String[] ofcAdjTpCd1 =	(JSPUtil.getParameter(request, prefix +	"ofc_adj_tp_cd1".trim(),	length));
				String[] ofcAdjTpCd2 =	(JSPUtil.getParameter(request, prefix +	"ofc_adj_tp_cd2".trim(),	length));
				String[] ofcAdjTpCd3 =	(JSPUtil.getParameter(request, prefix +	"ofc_adj_tp_cd3".trim(),	length));
				String[] ofcAdjTpCd4 =	(JSPUtil.getParameter(request, prefix +	"ofc_adj_tp_cd4".trim(),	length));
				String[] ofcAdjTpCd5 =	(JSPUtil.getParameter(request, prefix +	"ofc_adj_tp_cd5".trim(),	length));
				String[] agnOtsLmtFlg =	(JSPUtil.getParameter(request, prefix +	"agn_ots_lmt_flg".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	OfficeInfoVO();
						if ( ofcWrtfTpCd1[i] !=	null)
						model.setOfcWrtfTpCd1( ofcWrtfTpCd1[i]);
						if ( agnPfxCd[i] !=	null)
						model.setAgnPfxCd( agnPfxCd[i]);
						if ( ofcWrtfTpCd4[i] !=	null)
						model.setOfcWrtfTpCd4( ofcWrtfTpCd4[i]);
						if ( otsIfFlg[i] !=	null)
						model.setOtsIfFlg( otsIfFlg[i]);
						if ( ofcWrtfTpCd5[i] !=	null)
						model.setOfcWrtfTpCd5( ofcWrtfTpCd5[i]);
						if ( bankChgAcctCd[i] !=	null)
						model.setBankChgAcctCd( bankChgAcctCd[i]);
						if ( ofcWrtfTpCd2[i] !=	null)
						model.setOfcWrtfTpCd2( ofcWrtfTpCd2[i]);
						if ( ofcWrtfTpCd3[i] !=	null)
						model.setOfcWrtfTpCd3( ofcWrtfTpCd3[i]);
						if ( creDt[i] !=	null)
						model.setCreDt( creDt[i]);
						if ( miscIncmLmtAmt[i] !=	null)
						model.setMiscIncmLmtAmt( miscIncmLmtAmt[i]);
						if ( agnOtsLmtAmt[i] !=	null)
						model.setAgnOtsLmtAmt( agnOtsLmtAmt[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( bankCtrlCd[i] !=	null)
						model.setBankCtrlCd( bankCtrlCd[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( ofcEntrLvlCd[i] !=	null)
						model.setOfcEntrLvlCd( ofcEntrLvlCd[i]);
						if ( rctOfcAddr[i] !=	null)
						model.setRctOfcAddr( rctOfcAddr[i]);
						if ( arPrnTitNm[i] !=	null)
						model.setArPrnTitNm( arPrnTitNm[i]);
						if ( rctOfcSpclNoCtnt[i] !=	null)
						model.setRctOfcSpclNoCtnt( rctOfcSpclNoCtnt[i]);
						if ( agnCurrCd[i] !=	null)
						model.setAgnCurrCd( agnCurrCd[i]);
						if ( rctDocCd[i] !=	null)
						model.setRctDocCd( rctDocCd[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( updDt[i] !=	null)
						model.setUpdDt( updDt[i]);
						if ( arCrCustPrnCtnt[i] !=	null)
						model.setArCrCustPrnCtnt( arCrCustPrnCtnt[i]);
						if ( ovpayTpCd[i] !=	null)
						model.setOvpayTpCd( ovpayTpCd[i]);
						if ( ofcBrncAgnTpCd[i] !=	null)
						model.setOfcBrncAgnTpCd( ofcBrncAgnTpCd[i]);
						if ( rctTitNm[i] !=	null)
						model.setRctTitNm( rctTitNm[i]);
						if ( rctRmk[i] !=	null)
						model.setRctRmk( rctRmk[i]);
						if ( loclCurrCd[i] !=	null)
						model.setLoclCurrCd( loclCurrCd[i]);
						if ( rctOfcTelcmFaxNoCtnt[i] !=	null)
						model.setRctOfcTelcmFaxNoCtnt( rctOfcTelcmFaxNoCtnt[i]);
						if ( arPrnCtnt[i] !=	null)
						model.setArPrnCtnt( arPrnCtnt[i]);
						if ( enblFlg[i] !=	null)
						model.setEnblFlg( enblFlg[i]);
						if ( ofcCd[i] !=	null)
						model.setOfcCd( ofcCd[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
						if ( otsCateCd[i] !=	null)
						model.setOtsCateCd( otsCateCd[i]);
						if ( otsCd[i] !=	null)
						model.setOtsCd( otsCd[i]);
						if ( bankOfc[i] !=	null)
						model.setBankOfc( bankOfc[i]);
						if ( rctTpCd[i] !=	null)
						model.setRctTpCd( rctTpCd[i]);
						if ( rctSpclRmk[i] !=	null)
						model.setRctSpclRmk( rctSpclRmk[i]);
						if ( rctOfcTitNm[i] !=	null)
						model.setRctOfcTitNm( rctOfcTitNm[i]);
						if ( agnCmbCd[i] !=	null)
						model.setAgnCmbCd( agnCmbCd[i]);
						if ( refEml[i] !=	null)
						model.setRefEml( refEml[i]);
						if ( repOtsOfcCd[i] !=	null)
						model.setRepOtsOfcCd( repOtsOfcCd[i]);
						if ( miscLssLmtAmt[i] !=	null)
						model.setMiscLssLmtAmt( miscLssLmtAmt[i]);
						if ( rctUnapyFlg[i] !=	null)
						model.setRctUnapyFlg( rctUnapyFlg[i]);
						if ( ofcInqLvlCd[i] !=	null)
						model.setOfcInqLvlCd( ofcInqLvlCd[i]);
						if ( ofcAdjTpCd1[i] !=	null)
						model.setOfcAdjTpCd1( ofcAdjTpCd1[i]);
						if ( ofcAdjTpCd2[i] !=	null)
						model.setOfcAdjTpCd2( ofcAdjTpCd2[i]);
						if ( ofcAdjTpCd3[i] !=	null)
						model.setOfcAdjTpCd3( ofcAdjTpCd3[i]);
						if ( ofcAdjTpCd4[i] !=	null)
						model.setOfcAdjTpCd4( ofcAdjTpCd4[i]);
						if ( ofcAdjTpCd5[i] !=	null)
						model.setOfcAdjTpCd5( ofcAdjTpCd5[i]);
						if ( agnOtsLmtFlg[i] !=	null)
						model.setAgnOtsLmtFlg( agnOtsLmtFlg[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getOfficeInfoVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return OfficeInfoVO[]
	 */
	public OfficeInfoVO[]	 getOfficeInfoVOs(){
		OfficeInfoVO[] vos = (OfficeInfoVO[])models.toArray(new	OfficeInfoVO[models.size()]);
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
		this.ofcWrtfTpCd1 =	this.ofcWrtfTpCd1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnPfxCd =	this.agnPfxCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcWrtfTpCd4 =	this.ofcWrtfTpCd4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsIfFlg =	this.otsIfFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcWrtfTpCd5 =	this.ofcWrtfTpCd5.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankChgAcctCd =	this.bankChgAcctCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcWrtfTpCd2 =	this.ofcWrtfTpCd2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcWrtfTpCd3 =	this.ofcWrtfTpCd3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt =	this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.miscIncmLmtAmt =	this.miscIncmLmtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnOtsLmtAmt =	this.agnOtsLmtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankCtrlCd =	this.bankCtrlCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcEntrLvlCd =	this.ofcEntrLvlCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctOfcAddr =	this.rctOfcAddr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arPrnTitNm =	this.arPrnTitNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctOfcSpclNoCtnt =	this.rctOfcSpclNoCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnCurrCd =	this.agnCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctDocCd =	this.rctDocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt =	this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arCrCustPrnCtnt =	this.arCrCustPrnCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovpayTpCd =	this.ovpayTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcBrncAgnTpCd =	this.ofcBrncAgnTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctTitNm =	this.rctTitNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctRmk =	this.rctRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCd =	this.loclCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctOfcTelcmFaxNoCtnt =	this.rctOfcTelcmFaxNoCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arPrnCtnt =	this.arPrnCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.enblFlg =	this.enblFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd =	this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsCateCd =	this.otsCateCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsCd =	this.otsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankOfc =	this.bankOfc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctTpCd =	this.rctTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctSpclRmk =	this.rctSpclRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctOfcTitNm =	this.rctOfcTitNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnCmbCd =	this.agnCmbCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refEml =	this.refEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repOtsOfcCd =	this.repOtsOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.miscLssLmtAmt =	this.miscLssLmtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctUnapyFlg =	this.rctUnapyFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcInqLvlCd =	this.ofcInqLvlCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcAdjTpCd1 =	this.ofcAdjTpCd1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcAdjTpCd2 =	this.ofcAdjTpCd2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcAdjTpCd3 =	this.ofcAdjTpCd3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcAdjTpCd4 =	this.ofcAdjTpCd4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcAdjTpCd5 =	this.ofcAdjTpCd5.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnOtsLmtFlg =	this.agnOtsLmtFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}