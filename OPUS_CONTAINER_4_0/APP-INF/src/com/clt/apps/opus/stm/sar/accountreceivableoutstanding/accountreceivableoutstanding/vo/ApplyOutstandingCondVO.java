/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ApplyOutstandingCondVO.java
 *@FileTitle : ApplyOutstandingCondVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.04.20
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2015.04.20  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo;

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
public class ApplyOutstandingCondVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<ApplyOutstandingCondVO>  models =	new	ArrayList<ApplyOutstandingCondVO>();


	/*	Column Info	*/
	private  String	 chgTpCd   =  null;
	/*	Column Info	*/
	private  String	 asOfDate   =  null;
	/*	Column Info	*/
	private  String	 bilToCustCntCd   =  null;
	/*	Column Info	*/
	private  String	 otsSmryCd   =  null;
	/*	Column Info	*/
	private  String	 bkgIoBndCd   =  null;
	/*	Column Info	*/
	private  String	 vvdCd9   =  null;
	/*	Column Info	*/
	private  String	 ifFromDt   =  null;
	/*	Column Info	*/
	private  String	 tjSrcNm   =  null;
	/*	Column Info	*/
	private  String	 overDueFm   =  null;
	/*	Column Info	*/
	private  String	 vvdCd5   =  null;
	/*	Column Info	*/
	private  String	 vvdCd6   =  null;
	/*	Column Info	*/
	private  String	 vvdCd7   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 vvdCd8   =  null;
	/*	Column Info	*/
	private  String	 vvdCd2   =  null;
	/*	Column Info	*/
	private  String	 vvdCd1   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 vvdCd4   =  null;
	/*	Column Info	*/
	private  String	 vvdCd3   =  null;
	/*	Column Info	*/
	private  String	 overDueTo   =  null;
	/*	Column Info	*/
	private  String	 otsSrcCd   =  null;
	/*	Column Info	*/
	private  String	 vvdCd14   =  null;
	/*	Column Info	*/
	private  String	 rhqCd   =  null;
	/*	Column Info	*/
	private  String	 blNo1   =  null;
	/*	Column Info	*/
	private  String	 blNo2   =  null;
	/*	Column Info	*/
	private  String	 ifToDt   =  null;
	/*	Column Info	*/
	private  String	 blNo3   =  null;
	/*	Column Info	*/
	private  String	 bilToCustSeq   =  null;
	/*	Column Info	*/
	private  String	 blNo4   =  null;
	/*	Column Info	*/
	private  String	 blNo5   =  null;
	/*	Column Info	*/
	private  String	 blNo6   =  null;
	/*	Column Info	*/
	private  String	 vvdCd11   =  null;
	/*	Column Info	*/
	private  String	 blNo7   =  null;
	/*	Column Info	*/
	private  String	 vvdCd10   =  null;
	/*	Column Info	*/
	private  String	 vvdCd13   =  null;
	/*	Column Info	*/
	private  String	 vvdCd12   =  null;
	/*	Column Info	*/
	private  String	 ofcCd   =  null;
	/*	Column Info	*/
	private  String	 otsCd   =  null;
	/*	Column Info	*/
	private  String	 repOtsOfcCd   =  null;
	/*	Column Info	*/
	private  String	 localChgFlag   =  null;
	/*	Column Info	*/
	private  String	 invoiceType   =  null;
	/*	Column Info	*/
	private  String	 rctCurrCd   =  null;
	/*	Column Info	*/
	private  String	 otsRctTmpSeq   =  null;
	/*	Column Info	*/
	private  String	 otsDtlFlg   =  null;
	/*	Column Info	*/
	private  String	 ofstChk   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public ApplyOutstandingCondVO(){}

	public ApplyOutstandingCondVO(String chgTpCd,String asOfDate,String bilToCustCntCd,String otsSmryCd,String bkgIoBndCd,String vvdCd9,String ifFromDt,String tjSrcNm,String overDueFm,String vvdCd5,String vvdCd6,String vvdCd7,String pagerows,String vvdCd8,String vvdCd2,String vvdCd1,String ibflag,String vvdCd4,String vvdCd3,String overDueTo,String otsSrcCd,String vvdCd14,String rhqCd,String blNo1,String blNo2,String ifToDt,String blNo3,String bilToCustSeq,String blNo4,String blNo5,String blNo6,String vvdCd11,String blNo7,String vvdCd10,String vvdCd13,String vvdCd12,String ofcCd,String otsCd,String repOtsOfcCd,String localChgFlag,String invoiceType,String rctCurrCd,String otsRctTmpSeq,String otsDtlFlg,String ofstChk)	{
		this.chgTpCd  = chgTpCd ;
		this.asOfDate  = asOfDate ;
		this.bilToCustCntCd  = bilToCustCntCd ;
		this.otsSmryCd  = otsSmryCd ;
		this.bkgIoBndCd  = bkgIoBndCd ;
		this.vvdCd9  = vvdCd9 ;
		this.ifFromDt  = ifFromDt ;
		this.tjSrcNm  = tjSrcNm ;
		this.overDueFm  = overDueFm ;
		this.vvdCd5  = vvdCd5 ;
		this.vvdCd6  = vvdCd6 ;
		this.vvdCd7  = vvdCd7 ;
		this.pagerows  = pagerows ;
		this.vvdCd8  = vvdCd8 ;
		this.vvdCd2  = vvdCd2 ;
		this.vvdCd1  = vvdCd1 ;
		this.ibflag  = ibflag ;
		this.vvdCd4  = vvdCd4 ;
		this.vvdCd3  = vvdCd3 ;
		this.overDueTo  = overDueTo ;
		this.otsSrcCd  = otsSrcCd ;
		this.vvdCd14  = vvdCd14 ;
		this.rhqCd  = rhqCd ;
		this.blNo1  = blNo1 ;
		this.blNo2  = blNo2 ;
		this.ifToDt  = ifToDt ;
		this.blNo3  = blNo3 ;
		this.bilToCustSeq  = bilToCustSeq ;
		this.blNo4  = blNo4 ;
		this.blNo5  = blNo5 ;
		this.blNo6  = blNo6 ;
		this.vvdCd11  = vvdCd11 ;
		this.blNo7  = blNo7 ;
		this.vvdCd10  = vvdCd10 ;
		this.vvdCd13  = vvdCd13 ;
		this.vvdCd12  = vvdCd12 ;
		this.ofcCd  = ofcCd ;
		this.otsCd  = otsCd ;
		this.repOtsOfcCd  = repOtsOfcCd ;
		this.localChgFlag  = localChgFlag ;
		this.invoiceType  = invoiceType ;
		this.rctCurrCd  = rctCurrCd ;
		this.otsRctTmpSeq  = otsRctTmpSeq ;
		this.otsDtlFlg  = otsDtlFlg ;
		this.ofstChk  = ofstChk ;
	}


	/**
	 * �뚯씠釉�而щ읆����옣��媛믪쓣 Hashtable<"column_name", "value">	濡�諛섑솚
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("chg_tp_cd", getChgTpCd());		
		this.hashColumns.put("as_of_date", getAsOfDate());		
		this.hashColumns.put("bil_to_cust_cnt_cd", getBilToCustCntCd());		
		this.hashColumns.put("ots_smry_cd", getOtsSmryCd());		
		this.hashColumns.put("bkg_io_bnd_cd", getBkgIoBndCd());		
		this.hashColumns.put("vvd_cd9", getVvdCd9());		
		this.hashColumns.put("if_from_dt", getIfFromDt());		
		this.hashColumns.put("tj_src_nm", getTjSrcNm());		
		this.hashColumns.put("over_due_fm", getOverDueFm());		
		this.hashColumns.put("vvd_cd5", getVvdCd5());		
		this.hashColumns.put("vvd_cd6", getVvdCd6());		
		this.hashColumns.put("vvd_cd7", getVvdCd7());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("vvd_cd8", getVvdCd8());		
		this.hashColumns.put("vvd_cd2", getVvdCd2());		
		this.hashColumns.put("vvd_cd1", getVvdCd1());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("vvd_cd4", getVvdCd4());		
		this.hashColumns.put("vvd_cd3", getVvdCd3());		
		this.hashColumns.put("over_due_to", getOverDueTo());		
		this.hashColumns.put("ots_src_cd", getOtsSrcCd());		
		this.hashColumns.put("vvd_cd14", getVvdCd14());		
		this.hashColumns.put("rhq_cd", getRhqCd());		
		this.hashColumns.put("bl_no1", getBlNo1());		
		this.hashColumns.put("bl_no2", getBlNo2());		
		this.hashColumns.put("if_to_dt", getIfToDt());		
		this.hashColumns.put("bl_no3", getBlNo3());		
		this.hashColumns.put("bil_to_cust_seq", getBilToCustSeq());		
		this.hashColumns.put("bl_no4", getBlNo4());		
		this.hashColumns.put("bl_no5", getBlNo5());		
		this.hashColumns.put("bl_no6", getBlNo6());		
		this.hashColumns.put("vvd_cd11", getVvdCd11());		
		this.hashColumns.put("bl_no7", getBlNo7());		
		this.hashColumns.put("vvd_cd10", getVvdCd10());		
		this.hashColumns.put("vvd_cd13", getVvdCd13());		
		this.hashColumns.put("vvd_cd12", getVvdCd12());		
		this.hashColumns.put("ofc_cd", getOfcCd());		
		this.hashColumns.put("ots_cd", getOtsCd());		
		this.hashColumns.put("rep_ots_ofc_cd", getRepOtsOfcCd());		
		this.hashColumns.put("local_chg_flag", getLocalChgFlag());		
		this.hashColumns.put("invoice_type", getInvoiceType());		
		this.hashColumns.put("rct_curr_cd", getRctCurrCd());		
		this.hashColumns.put("ots_rct_tmp_seq", getOtsRctTmpSeq());		
		this.hashColumns.put("ots_dtl_flg", getOtsDtlFlg());		
		this.hashColumns.put("ofst_chk", getOfstChk());		
		return this.hashColumns;
}

	/**
	 * 而щ읆紐낆뿉	��쓳�섎뒗 硫ㅻ쾭蹂�닔紐낆쓣	��옣�섏뿬 Hashtable<"column_name", "variable"> 濡�諛섑솚
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("chg_tp_cd", "chgTpCd");
		this.hashFields.put("as_of_date", "asOfDate");
		this.hashFields.put("bil_to_cust_cnt_cd", "bilToCustCntCd");
		this.hashFields.put("ots_smry_cd", "otsSmryCd");
		this.hashFields.put("bkg_io_bnd_cd", "bkgIoBndCd");
		this.hashFields.put("vvd_cd9", "vvdCd9");
		this.hashFields.put("if_from_dt", "ifFromDt");
		this.hashFields.put("tj_src_nm", "tjSrcNm");
		this.hashFields.put("over_due_fm", "overDueFm");
		this.hashFields.put("vvd_cd5", "vvdCd5");
		this.hashFields.put("vvd_cd6", "vvdCd6");
		this.hashFields.put("vvd_cd7", "vvdCd7");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd_cd8", "vvdCd8");
		this.hashFields.put("vvd_cd2", "vvdCd2");
		this.hashFields.put("vvd_cd1", "vvdCd1");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vvd_cd4", "vvdCd4");
		this.hashFields.put("vvd_cd3", "vvdCd3");
		this.hashFields.put("over_due_to", "overDueTo");
		this.hashFields.put("ots_src_cd", "otsSrcCd");
		this.hashFields.put("vvd_cd14", "vvdCd14");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("bl_no1", "blNo1");
		this.hashFields.put("bl_no2", "blNo2");
		this.hashFields.put("if_to_dt", "ifToDt");
		this.hashFields.put("bl_no3", "blNo3");
		this.hashFields.put("bil_to_cust_seq", "bilToCustSeq");
		this.hashFields.put("bl_no4", "blNo4");
		this.hashFields.put("bl_no5", "blNo5");
		this.hashFields.put("bl_no6", "blNo6");
		this.hashFields.put("vvd_cd11", "vvdCd11");
		this.hashFields.put("bl_no7", "blNo7");
		this.hashFields.put("vvd_cd10", "vvdCd10");
		this.hashFields.put("vvd_cd13", "vvdCd13");
		this.hashFields.put("vvd_cd12", "vvdCd12");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ots_cd", "otsCd");
		this.hashFields.put("rep_ots_ofc_cd", "repOtsOfcCd");
		this.hashFields.put("local_chg_flag", "localChgFlag");
		this.hashFields.put("invoice_type", "invoiceType");
		this.hashFields.put("rct_curr_cd", "rctCurrCd");
		this.hashFields.put("ots_rct_tmp_seq", "otsRctTmpSeq");
		this.hashFields.put("ots_dtl_flg", "otsDtlFlg");
		this.hashFields.put("ofst_chk", "ofstChk");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  chgTpCd
	*/
	public void	setChgTpCd( String	chgTpCd ) {
		this.chgTpCd =	chgTpCd;
	}
 
	/**
	 * Column Info
	 * @return	chgTpCd
	 */
	 public	 String	getChgTpCd() {
		 return	this.chgTpCd;
	 } 
 	/**
	* Column Info
	* @param  asOfDate
	*/
	public void	setAsOfDate( String	asOfDate ) {
		this.asOfDate =	asOfDate;
	}
 
	/**
	 * Column Info
	 * @return	asOfDate
	 */
	 public	 String	getAsOfDate() {
		 return	this.asOfDate;
	 } 
 	/**
	* Column Info
	* @param  bilToCustCntCd
	*/
	public void	setBilToCustCntCd( String	bilToCustCntCd ) {
		this.bilToCustCntCd =	bilToCustCntCd;
	}
 
	/**
	 * Column Info
	 * @return	bilToCustCntCd
	 */
	 public	 String	getBilToCustCntCd() {
		 return	this.bilToCustCntCd;
	 } 
 	/**
	* Column Info
	* @param  otsSmryCd
	*/
	public void	setOtsSmryCd( String	otsSmryCd ) {
		this.otsSmryCd =	otsSmryCd;
	}
 
	/**
	 * Column Info
	 * @return	otsSmryCd
	 */
	 public	 String	getOtsSmryCd() {
		 return	this.otsSmryCd;
	 } 
 	/**
	* Column Info
	* @param  bkgIoBndCd
	*/
	public void	setBkgIoBndCd( String	bkgIoBndCd ) {
		this.bkgIoBndCd =	bkgIoBndCd;
	}
 
	/**
	 * Column Info
	 * @return	bkgIoBndCd
	 */
	 public	 String	getBkgIoBndCd() {
		 return	this.bkgIoBndCd;
	 } 
 	/**
	* Column Info
	* @param  vvdCd9
	*/
	public void	setVvdCd9( String	vvdCd9 ) {
		this.vvdCd9 =	vvdCd9;
	}
 
	/**
	 * Column Info
	 * @return	vvdCd9
	 */
	 public	 String	getVvdCd9() {
		 return	this.vvdCd9;
	 } 
 	/**
	* Column Info
	* @param  ifFromDt
	*/
	public void	setIfFromDt( String	ifFromDt ) {
		this.ifFromDt =	ifFromDt;
	}
 
	/**
	 * Column Info
	 * @return	ifFromDt
	 */
	 public	 String	getIfFromDt() {
		 return	this.ifFromDt;
	 } 
 	/**
	* Column Info
	* @param  tjSrcNm
	*/
	public void	setTjSrcNm( String	tjSrcNm ) {
		this.tjSrcNm =	tjSrcNm;
	}
 
	/**
	 * Column Info
	 * @return	tjSrcNm
	 */
	 public	 String	getTjSrcNm() {
		 return	this.tjSrcNm;
	 } 
 	/**
	* Column Info
	* @param  overDueFm
	*/
	public void	setOverDueFm( String	overDueFm ) {
		this.overDueFm =	overDueFm;
	}
 
	/**
	 * Column Info
	 * @return	overDueFm
	 */
	 public	 String	getOverDueFm() {
		 return	this.overDueFm;
	 } 
 	/**
	* Column Info
	* @param  vvdCd5
	*/
	public void	setVvdCd5( String	vvdCd5 ) {
		this.vvdCd5 =	vvdCd5;
	}
 
	/**
	 * Column Info
	 * @return	vvdCd5
	 */
	 public	 String	getVvdCd5() {
		 return	this.vvdCd5;
	 } 
 	/**
	* Column Info
	* @param  vvdCd6
	*/
	public void	setVvdCd6( String	vvdCd6 ) {
		this.vvdCd6 =	vvdCd6;
	}
 
	/**
	 * Column Info
	 * @return	vvdCd6
	 */
	 public	 String	getVvdCd6() {
		 return	this.vvdCd6;
	 } 
 	/**
	* Column Info
	* @param  vvdCd7
	*/
	public void	setVvdCd7( String	vvdCd7 ) {
		this.vvdCd7 =	vvdCd7;
	}
 
	/**
	 * Column Info
	 * @return	vvdCd7
	 */
	 public	 String	getVvdCd7() {
		 return	this.vvdCd7;
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
	* @param  vvdCd8
	*/
	public void	setVvdCd8( String	vvdCd8 ) {
		this.vvdCd8 =	vvdCd8;
	}
 
	/**
	 * Column Info
	 * @return	vvdCd8
	 */
	 public	 String	getVvdCd8() {
		 return	this.vvdCd8;
	 } 
 	/**
	* Column Info
	* @param  vvdCd2
	*/
	public void	setVvdCd2( String	vvdCd2 ) {
		this.vvdCd2 =	vvdCd2;
	}
 
	/**
	 * Column Info
	 * @return	vvdCd2
	 */
	 public	 String	getVvdCd2() {
		 return	this.vvdCd2;
	 } 
 	/**
	* Column Info
	* @param  vvdCd1
	*/
	public void	setVvdCd1( String	vvdCd1 ) {
		this.vvdCd1 =	vvdCd1;
	}
 
	/**
	 * Column Info
	 * @return	vvdCd1
	 */
	 public	 String	getVvdCd1() {
		 return	this.vvdCd1;
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
	* @param  vvdCd4
	*/
	public void	setVvdCd4( String	vvdCd4 ) {
		this.vvdCd4 =	vvdCd4;
	}
 
	/**
	 * Column Info
	 * @return	vvdCd4
	 */
	 public	 String	getVvdCd4() {
		 return	this.vvdCd4;
	 } 
 	/**
	* Column Info
	* @param  vvdCd3
	*/
	public void	setVvdCd3( String	vvdCd3 ) {
		this.vvdCd3 =	vvdCd3;
	}
 
	/**
	 * Column Info
	 * @return	vvdCd3
	 */
	 public	 String	getVvdCd3() {
		 return	this.vvdCd3;
	 } 
 	/**
	* Column Info
	* @param  overDueTo
	*/
	public void	setOverDueTo( String	overDueTo ) {
		this.overDueTo =	overDueTo;
	}
 
	/**
	 * Column Info
	 * @return	overDueTo
	 */
	 public	 String	getOverDueTo() {
		 return	this.overDueTo;
	 } 
 	/**
	* Column Info
	* @param  otsSrcCd
	*/
	public void	setOtsSrcCd( String	otsSrcCd ) {
		this.otsSrcCd =	otsSrcCd;
	}
 
	/**
	 * Column Info
	 * @return	otsSrcCd
	 */
	 public	 String	getOtsSrcCd() {
		 return	this.otsSrcCd;
	 } 
 	/**
	* Column Info
	* @param  vvdCd14
	*/
	public void	setVvdCd14( String	vvdCd14 ) {
		this.vvdCd14 =	vvdCd14;
	}
 
	/**
	 * Column Info
	 * @return	vvdCd14
	 */
	 public	 String	getVvdCd14() {
		 return	this.vvdCd14;
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
	* @param  blNo1
	*/
	public void	setBlNo1( String	blNo1 ) {
		this.blNo1 =	blNo1;
	}
 
	/**
	 * Column Info
	 * @return	blNo1
	 */
	 public	 String	getBlNo1() {
		 return	this.blNo1;
	 } 
 	/**
	* Column Info
	* @param  blNo2
	*/
	public void	setBlNo2( String	blNo2 ) {
		this.blNo2 =	blNo2;
	}
 
	/**
	 * Column Info
	 * @return	blNo2
	 */
	 public	 String	getBlNo2() {
		 return	this.blNo2;
	 } 
 	/**
	* Column Info
	* @param  ifToDt
	*/
	public void	setIfToDt( String	ifToDt ) {
		this.ifToDt =	ifToDt;
	}
 
	/**
	 * Column Info
	 * @return	ifToDt
	 */
	 public	 String	getIfToDt() {
		 return	this.ifToDt;
	 } 
 	/**
	* Column Info
	* @param  blNo3
	*/
	public void	setBlNo3( String	blNo3 ) {
		this.blNo3 =	blNo3;
	}
 
	/**
	 * Column Info
	 * @return	blNo3
	 */
	 public	 String	getBlNo3() {
		 return	this.blNo3;
	 } 
 	/**
	* Column Info
	* @param  bilToCustSeq
	*/
	public void	setBilToCustSeq( String	bilToCustSeq ) {
		this.bilToCustSeq =	bilToCustSeq;
	}
 
	/**
	 * Column Info
	 * @return	bilToCustSeq
	 */
	 public	 String	getBilToCustSeq() {
		 return	this.bilToCustSeq;
	 } 
 	/**
	* Column Info
	* @param  blNo4
	*/
	public void	setBlNo4( String	blNo4 ) {
		this.blNo4 =	blNo4;
	}
 
	/**
	 * Column Info
	 * @return	blNo4
	 */
	 public	 String	getBlNo4() {
		 return	this.blNo4;
	 } 
 	/**
	* Column Info
	* @param  blNo5
	*/
	public void	setBlNo5( String	blNo5 ) {
		this.blNo5 =	blNo5;
	}
 
	/**
	 * Column Info
	 * @return	blNo5
	 */
	 public	 String	getBlNo5() {
		 return	this.blNo5;
	 } 
 	/**
	* Column Info
	* @param  blNo6
	*/
	public void	setBlNo6( String	blNo6 ) {
		this.blNo6 =	blNo6;
	}
 
	/**
	 * Column Info
	 * @return	blNo6
	 */
	 public	 String	getBlNo6() {
		 return	this.blNo6;
	 } 
 	/**
	* Column Info
	* @param  vvdCd11
	*/
	public void	setVvdCd11( String	vvdCd11 ) {
		this.vvdCd11 =	vvdCd11;
	}
 
	/**
	 * Column Info
	 * @return	vvdCd11
	 */
	 public	 String	getVvdCd11() {
		 return	this.vvdCd11;
	 } 
 	/**
	* Column Info
	* @param  blNo7
	*/
	public void	setBlNo7( String	blNo7 ) {
		this.blNo7 =	blNo7;
	}
 
	/**
	 * Column Info
	 * @return	blNo7
	 */
	 public	 String	getBlNo7() {
		 return	this.blNo7;
	 } 
 	/**
	* Column Info
	* @param  vvdCd10
	*/
	public void	setVvdCd10( String	vvdCd10 ) {
		this.vvdCd10 =	vvdCd10;
	}
 
	/**
	 * Column Info
	 * @return	vvdCd10
	 */
	 public	 String	getVvdCd10() {
		 return	this.vvdCd10;
	 } 
 	/**
	* Column Info
	* @param  vvdCd13
	*/
	public void	setVvdCd13( String	vvdCd13 ) {
		this.vvdCd13 =	vvdCd13;
	}
 
	/**
	 * Column Info
	 * @return	vvdCd13
	 */
	 public	 String	getVvdCd13() {
		 return	this.vvdCd13;
	 } 
 	/**
	* Column Info
	* @param  vvdCd12
	*/
	public void	setVvdCd12( String	vvdCd12 ) {
		this.vvdCd12 =	vvdCd12;
	}
 
	/**
	 * Column Info
	 * @return	vvdCd12
	 */
	 public	 String	getVvdCd12() {
		 return	this.vvdCd12;
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
	* @param  localChgFlag
	*/
	public void	setLocalChgFlag( String	localChgFlag ) {
		this.localChgFlag =	localChgFlag;
	}
 
	/**
	 * Column Info
	 * @return	localChgFlag
	 */
	 public	 String	getLocalChgFlag() {
		 return	this.localChgFlag;
	 } 
 	/**
	* Column Info
	* @param  invoiceType
	*/
	public void	setInvoiceType( String	invoiceType ) {
		this.invoiceType =	invoiceType;
	}
 
	/**
	 * Column Info
	 * @return	invoiceType
	 */
	 public	 String	getInvoiceType() {
		 return	this.invoiceType;
	 } 
 	/**
	* Column Info
	* @param  rctCurrCd
	*/
	public void	setRctCurrCd( String	rctCurrCd ) {
		this.rctCurrCd =	rctCurrCd;
	}
 
	/**
	 * Column Info
	 * @return	rctCurrCd
	 */
	 public	 String	getRctCurrCd() {
		 return	this.rctCurrCd;
	 } 
 	/**
	* Column Info
	* @param  otsRctTmpSeq
	*/
	public void	setOtsRctTmpSeq( String	otsRctTmpSeq ) {
		this.otsRctTmpSeq =	otsRctTmpSeq;
	}
 
	/**
	 * Column Info
	 * @return	otsRctTmpSeq
	 */
	 public	 String	getOtsRctTmpSeq() {
		 return	this.otsRctTmpSeq;
	 } 
 	/**
	* Column Info
	* @param  otsDtlFlg
	*/
	public void	setOtsDtlFlg( String	otsDtlFlg ) {
		this.otsDtlFlg =	otsDtlFlg;
	}
 
	/**
	 * Column Info
	 * @return	otsDtlFlg
	 */
	 public	 String	getOtsDtlFlg() {
		 return	this.otsDtlFlg;
	 } 
 	/**
	* Column Info
	* @param  ofstChk
	*/
	public void	setOfstChk( String	ofstChk ) {
		this.ofstChk =	ofstChk;
	}
 
	/**
	 * Column Info
	 * @return	ofstChk
	 */
	 public	 String	getOfstChk() {
		 return	this.ofstChk;
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
		setChgTpCd(JSPUtil.getParameter(request,	prefix + "chg_tp_cd", ""));
		setAsOfDate(JSPUtil.getParameter(request,	prefix + "as_of_date", ""));
		setBilToCustCntCd(JSPUtil.getParameter(request,	prefix + "bil_to_cust_cnt_cd", ""));
		setOtsSmryCd(JSPUtil.getParameter(request,	prefix + "ots_smry_cd", ""));
		setBkgIoBndCd(JSPUtil.getParameter(request,	prefix + "bkg_io_bnd_cd", ""));
		setVvdCd9(JSPUtil.getParameter(request,	prefix + "vvd_cd9", ""));
		setIfFromDt(JSPUtil.getParameter(request,	prefix + "if_from_dt", ""));
		setTjSrcNm(JSPUtil.getParameter(request,	prefix + "tj_src_nm", ""));
		setOverDueFm(JSPUtil.getParameter(request,	prefix + "over_due_fm", ""));
		setVvdCd5(JSPUtil.getParameter(request,	prefix + "vvd_cd5", ""));
		setVvdCd6(JSPUtil.getParameter(request,	prefix + "vvd_cd6", ""));
		setVvdCd7(JSPUtil.getParameter(request,	prefix + "vvd_cd7", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setVvdCd8(JSPUtil.getParameter(request,	prefix + "vvd_cd8", ""));
		setVvdCd2(JSPUtil.getParameter(request,	prefix + "vvd_cd2", ""));
		setVvdCd1(JSPUtil.getParameter(request,	prefix + "vvd_cd1", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setVvdCd4(JSPUtil.getParameter(request,	prefix + "vvd_cd4", ""));
		setVvdCd3(JSPUtil.getParameter(request,	prefix + "vvd_cd3", ""));
		setOverDueTo(JSPUtil.getParameter(request,	prefix + "over_due_to", ""));
		setOtsSrcCd(JSPUtil.getParameter(request,	prefix + "ots_src_cd", ""));
		setVvdCd14(JSPUtil.getParameter(request,	prefix + "vvd_cd14", ""));
		setRhqCd(JSPUtil.getParameter(request,	prefix + "rhq_cd", ""));
		setBlNo1(JSPUtil.getParameter(request,	prefix + "bl_no1", ""));
		setBlNo2(JSPUtil.getParameter(request,	prefix + "bl_no2", ""));
		setIfToDt(JSPUtil.getParameter(request,	prefix + "if_to_dt", ""));
		setBlNo3(JSPUtil.getParameter(request,	prefix + "bl_no3", ""));
		setBilToCustSeq(JSPUtil.getParameter(request,	prefix + "bil_to_cust_seq", ""));
		setBlNo4(JSPUtil.getParameter(request,	prefix + "bl_no4", ""));
		setBlNo5(JSPUtil.getParameter(request,	prefix + "bl_no5", ""));
		setBlNo6(JSPUtil.getParameter(request,	prefix + "bl_no6", ""));
		setVvdCd11(JSPUtil.getParameter(request,	prefix + "vvd_cd11", ""));
		setBlNo7(JSPUtil.getParameter(request,	prefix + "bl_no7", ""));
		setVvdCd10(JSPUtil.getParameter(request,	prefix + "vvd_cd10", ""));
		setVvdCd13(JSPUtil.getParameter(request,	prefix + "vvd_cd13", ""));
		setVvdCd12(JSPUtil.getParameter(request,	prefix + "vvd_cd12", ""));
		setOfcCd(JSPUtil.getParameter(request,	prefix + "ofc_cd", ""));
		setOtsCd(JSPUtil.getParameter(request,	prefix + "ots_cd", ""));
		setRepOtsOfcCd(JSPUtil.getParameter(request,	prefix + "rep_ots_ofc_cd", ""));
		setLocalChgFlag(JSPUtil.getParameter(request,	prefix + "local_chg_flag", ""));
		setInvoiceType(JSPUtil.getParameter(request,	prefix + "invoice_type", ""));
		setRctCurrCd(JSPUtil.getParameter(request,	prefix + "rct_curr_cd", ""));
		setOtsRctTmpSeq(JSPUtil.getParameter(request,	prefix + "ots_rct_tmp_seq", ""));
		setOtsDtlFlg(JSPUtil.getParameter(request,	prefix + "ots_dtl_flg", ""));
		setOfstChk(JSPUtil.getParameter(request,	prefix + "ofst_chk", ""));
	}
	
	/**
	 * Request ���곗씠�곕� VO 諛곗뿴濡�蹂�솚�섏뿬 諛섑솚.
	 * @param request
	 * @return ApplyOutstandingCondVO[]
	 */
	public ApplyOutstandingCondVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request �섏뼱���щ윭 嫄�DATA瑜�VO Class ���대뒗��
	 * @param request
	 * @param prefix
	 * @return ApplyOutstandingCondVO[]
	 */
	public ApplyOutstandingCondVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		ApplyOutstandingCondVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] chgTpCd =	(JSPUtil.getParameter(request, prefix +	"chg_tp_cd".trim(),	length));
				String[] asOfDate =	(JSPUtil.getParameter(request, prefix +	"as_of_date".trim(),	length));
				String[] bilToCustCntCd =	(JSPUtil.getParameter(request, prefix +	"bil_to_cust_cnt_cd".trim(),	length));
				String[] otsSmryCd =	(JSPUtil.getParameter(request, prefix +	"ots_smry_cd".trim(),	length));
				String[] bkgIoBndCd =	(JSPUtil.getParameter(request, prefix +	"bkg_io_bnd_cd".trim(),	length));
				String[] vvdCd9 =	(JSPUtil.getParameter(request, prefix +	"vvd_cd9".trim(),	length));
				String[] ifFromDt =	(JSPUtil.getParameter(request, prefix +	"if_from_dt".trim(),	length));
				String[] tjSrcNm =	(JSPUtil.getParameter(request, prefix +	"tj_src_nm".trim(),	length));
				String[] overDueFm =	(JSPUtil.getParameter(request, prefix +	"over_due_fm".trim(),	length));
				String[] vvdCd5 =	(JSPUtil.getParameter(request, prefix +	"vvd_cd5".trim(),	length));
				String[] vvdCd6 =	(JSPUtil.getParameter(request, prefix +	"vvd_cd6".trim(),	length));
				String[] vvdCd7 =	(JSPUtil.getParameter(request, prefix +	"vvd_cd7".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] vvdCd8 =	(JSPUtil.getParameter(request, prefix +	"vvd_cd8".trim(),	length));
				String[] vvdCd2 =	(JSPUtil.getParameter(request, prefix +	"vvd_cd2".trim(),	length));
				String[] vvdCd1 =	(JSPUtil.getParameter(request, prefix +	"vvd_cd1".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] vvdCd4 =	(JSPUtil.getParameter(request, prefix +	"vvd_cd4".trim(),	length));
				String[] vvdCd3 =	(JSPUtil.getParameter(request, prefix +	"vvd_cd3".trim(),	length));
				String[] overDueTo =	(JSPUtil.getParameter(request, prefix +	"over_due_to".trim(),	length));
				String[] otsSrcCd =	(JSPUtil.getParameter(request, prefix +	"ots_src_cd".trim(),	length));
				String[] vvdCd14 =	(JSPUtil.getParameter(request, prefix +	"vvd_cd14".trim(),	length));
				String[] rhqCd =	(JSPUtil.getParameter(request, prefix +	"rhq_cd".trim(),	length));
				String[] blNo1 =	(JSPUtil.getParameter(request, prefix +	"bl_no1".trim(),	length));
				String[] blNo2 =	(JSPUtil.getParameter(request, prefix +	"bl_no2".trim(),	length));
				String[] ifToDt =	(JSPUtil.getParameter(request, prefix +	"if_to_dt".trim(),	length));
				String[] blNo3 =	(JSPUtil.getParameter(request, prefix +	"bl_no3".trim(),	length));
				String[] bilToCustSeq =	(JSPUtil.getParameter(request, prefix +	"bil_to_cust_seq".trim(),	length));
				String[] blNo4 =	(JSPUtil.getParameter(request, prefix +	"bl_no4".trim(),	length));
				String[] blNo5 =	(JSPUtil.getParameter(request, prefix +	"bl_no5".trim(),	length));
				String[] blNo6 =	(JSPUtil.getParameter(request, prefix +	"bl_no6".trim(),	length));
				String[] vvdCd11 =	(JSPUtil.getParameter(request, prefix +	"vvd_cd11".trim(),	length));
				String[] blNo7 =	(JSPUtil.getParameter(request, prefix +	"bl_no7".trim(),	length));
				String[] vvdCd10 =	(JSPUtil.getParameter(request, prefix +	"vvd_cd10".trim(),	length));
				String[] vvdCd13 =	(JSPUtil.getParameter(request, prefix +	"vvd_cd13".trim(),	length));
				String[] vvdCd12 =	(JSPUtil.getParameter(request, prefix +	"vvd_cd12".trim(),	length));
				String[] ofcCd =	(JSPUtil.getParameter(request, prefix +	"ofc_cd".trim(),	length));
				String[] otsCd =	(JSPUtil.getParameter(request, prefix +	"ots_cd".trim(),	length));
				String[] repOtsOfcCd =	(JSPUtil.getParameter(request, prefix +	"rep_ots_ofc_cd".trim(),	length));
				String[] localChgFlag =	(JSPUtil.getParameter(request, prefix +	"local_chg_flag".trim(),	length));
				String[] invoiceType =	(JSPUtil.getParameter(request, prefix +	"invoice_type".trim(),	length));
				String[] rctCurrCd =	(JSPUtil.getParameter(request, prefix +	"rct_curr_cd".trim(),	length));
				String[] otsRctTmpSeq =	(JSPUtil.getParameter(request, prefix +	"ots_rct_tmp_seq".trim(),	length));
				String[] otsDtlFlg =	(JSPUtil.getParameter(request, prefix +	"ots_dtl_flg".trim(),	length));
				String[] ofstChk =	(JSPUtil.getParameter(request, prefix +	"ofst_chk".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	ApplyOutstandingCondVO();
						if ( chgTpCd[i] !=	null)
						model.setChgTpCd( chgTpCd[i]);
						if ( asOfDate[i] !=	null)
						model.setAsOfDate( asOfDate[i]);
						if ( bilToCustCntCd[i] !=	null)
						model.setBilToCustCntCd( bilToCustCntCd[i]);
						if ( otsSmryCd[i] !=	null)
						model.setOtsSmryCd( otsSmryCd[i]);
						if ( bkgIoBndCd[i] !=	null)
						model.setBkgIoBndCd( bkgIoBndCd[i]);
						if ( vvdCd9[i] !=	null)
						model.setVvdCd9( vvdCd9[i]);
						if ( ifFromDt[i] !=	null)
						model.setIfFromDt( ifFromDt[i]);
						if ( tjSrcNm[i] !=	null)
						model.setTjSrcNm( tjSrcNm[i]);
						if ( overDueFm[i] !=	null)
						model.setOverDueFm( overDueFm[i]);
						if ( vvdCd5[i] !=	null)
						model.setVvdCd5( vvdCd5[i]);
						if ( vvdCd6[i] !=	null)
						model.setVvdCd6( vvdCd6[i]);
						if ( vvdCd7[i] !=	null)
						model.setVvdCd7( vvdCd7[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( vvdCd8[i] !=	null)
						model.setVvdCd8( vvdCd8[i]);
						if ( vvdCd2[i] !=	null)
						model.setVvdCd2( vvdCd2[i]);
						if ( vvdCd1[i] !=	null)
						model.setVvdCd1( vvdCd1[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( vvdCd4[i] !=	null)
						model.setVvdCd4( vvdCd4[i]);
						if ( vvdCd3[i] !=	null)
						model.setVvdCd3( vvdCd3[i]);
						if ( overDueTo[i] !=	null)
						model.setOverDueTo( overDueTo[i]);
						if ( otsSrcCd[i] !=	null)
						model.setOtsSrcCd( otsSrcCd[i]);
						if ( vvdCd14[i] !=	null)
						model.setVvdCd14( vvdCd14[i]);
						if ( rhqCd[i] !=	null)
						model.setRhqCd( rhqCd[i]);
						if ( blNo1[i] !=	null)
						model.setBlNo1( blNo1[i]);
						if ( blNo2[i] !=	null)
						model.setBlNo2( blNo2[i]);
						if ( ifToDt[i] !=	null)
						model.setIfToDt( ifToDt[i]);
						if ( blNo3[i] !=	null)
						model.setBlNo3( blNo3[i]);
						if ( bilToCustSeq[i] !=	null)
						model.setBilToCustSeq( bilToCustSeq[i]);
						if ( blNo4[i] !=	null)
						model.setBlNo4( blNo4[i]);
						if ( blNo5[i] !=	null)
						model.setBlNo5( blNo5[i]);
						if ( blNo6[i] !=	null)
						model.setBlNo6( blNo6[i]);
						if ( vvdCd11[i] !=	null)
						model.setVvdCd11( vvdCd11[i]);
						if ( blNo7[i] !=	null)
						model.setBlNo7( blNo7[i]);
						if ( vvdCd10[i] !=	null)
						model.setVvdCd10( vvdCd10[i]);
						if ( vvdCd13[i] !=	null)
						model.setVvdCd13( vvdCd13[i]);
						if ( vvdCd12[i] !=	null)
						model.setVvdCd12( vvdCd12[i]);
						if ( ofcCd[i] !=	null)
						model.setOfcCd( ofcCd[i]);
						if ( otsCd[i] !=	null)
						model.setOtsCd( otsCd[i]);
						if ( repOtsOfcCd[i] !=	null)
						model.setRepOtsOfcCd( repOtsOfcCd[i]);
						if ( localChgFlag[i] !=	null)
						model.setLocalChgFlag( localChgFlag[i]);
						if ( invoiceType[i] !=	null)
						model.setInvoiceType( invoiceType[i]);
						if ( rctCurrCd[i] !=	null)
						model.setRctCurrCd( rctCurrCd[i]);
						if ( otsRctTmpSeq[i] !=	null)
						model.setOtsRctTmpSeq( otsRctTmpSeq[i]);
						if ( otsDtlFlg[i] !=	null)
						model.setOtsDtlFlg( otsDtlFlg[i]);
						if ( ofstChk[i] !=	null)
						model.setOfstChk( ofstChk[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getApplyOutstandingCondVOs();
	}

	/**
	 *  VO 諛곗뿴��諛섑솚
	 * @return ApplyOutstandingCondVO[]
	 */
	public ApplyOutstandingCondVO[]	 getApplyOutstandingCondVOs(){
		ApplyOutstandingCondVO[] vos = (ApplyOutstandingCondVO[])models.toArray(new	ApplyOutstandingCondVO[models.size()]);
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
		this.chgTpCd =	this.chgTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asOfDate =	this.asOfDate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilToCustCntCd =	this.bilToCustCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsSmryCd =	this.otsSmryCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgIoBndCd =	this.bkgIoBndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd9 =	this.vvdCd9.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifFromDt =	this.ifFromDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tjSrcNm =	this.tjSrcNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overDueFm =	this.overDueFm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd5 =	this.vvdCd5.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd6 =	this.vvdCd6.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd7 =	this.vvdCd7.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd8 =	this.vvdCd8.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd2 =	this.vvdCd2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd1 =	this.vvdCd1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd4 =	this.vvdCd4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd3 =	this.vvdCd3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overDueTo =	this.overDueTo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsSrcCd =	this.otsSrcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd14 =	this.vvdCd14.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd =	this.rhqCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo1 =	this.blNo1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo2 =	this.blNo2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifToDt =	this.ifToDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo3 =	this.blNo3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilToCustSeq =	this.bilToCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo4 =	this.blNo4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo5 =	this.blNo5.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo6 =	this.blNo6.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd11 =	this.vvdCd11.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo7 =	this.blNo7.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd10 =	this.vvdCd10.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd13 =	this.vvdCd13.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd12 =	this.vvdCd12.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd =	this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsCd =	this.otsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repOtsOfcCd =	this.repOtsOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.localChgFlag =	this.localChgFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invoiceType =	this.invoiceType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctCurrCd =	this.rctCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsRctTmpSeq =	this.otsRctTmpSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsDtlFlg =	this.otsDtlFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofstChk =	this.ofstChk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}